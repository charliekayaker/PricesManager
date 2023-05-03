package com.pricesmanager.infra.inputadapter.http;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;
import com.pricesmanager.infra.inputport.PricesInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
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

    @GetMapping(value = "/getPrices", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> getPrices(HttpServletRequest request){

        log.info(tag + " Request : " + request.getParameter("productId") + " " + request.getParameter("brandId") + " "+
                request.getParameter("applicationDate"));



        PriceDetails priceDetails = PriceDetails.builder()
                .brandId(request.getParameter("brandId"))
                .productId(request.getParameter("productId"))
                .applicationDate(LocalDateTime.parse(request.getParameter("applicationDate")))
                .build();

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
