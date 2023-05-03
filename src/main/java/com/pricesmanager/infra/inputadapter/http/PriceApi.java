package com.pricesmanager.infra.inputadapter.http;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;
import com.pricesmanager.infra.inputport.PricesInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "pricesApi")
public class PriceApi {

    private final String tag = PriceApi.class.getName();
    private final PricesInputPort pricesInputPort;

    public PriceApi(PricesInputPort pricesInputPort){
        this.pricesInputPort = pricesInputPort;
    }

    @GetMapping(value = "getPrices", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> getPrices(@Valid PriceDetails priceDetails){
        log.info(tag + " Request : " + priceDetails.toString());

        try {
            Optional<Price> price = pricesInputPort.getPrice(priceDetails);
            log.info(tag + " Response : " + price.toString());
            return price.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            log.error(tag + " Error getting price", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error getting price", e);
        }
    }


}
