package com.pricesmanager.infra.inputadapter.http;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;
import com.pricesmanager.infra.inputport.PricesInputPort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pricesApi")
public class PriceApi {

    private final PricesInputPort pricesInputPort;

    public PriceApi(PricesInputPort pricesInputPort){
        this.pricesInputPort = pricesInputPort;
    }

    @GetMapping(value = "getPrices", produces= MediaType.APPLICATION_JSON_VALUE)
    public Price getPrices(PriceDetails priceDetails){

        return pricesInputPort.getPrice(priceDetails).orElse(null);
    }


}
