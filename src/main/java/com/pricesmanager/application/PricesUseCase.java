package com.pricesmanager.application;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;
import com.pricesmanager.infra.inputport.PricesInputPort;
import com.pricesmanager.infra.outputport.PriceRepository;
import org.springframework.stereotype.Component;

@Component
public class PricesUseCase implements PricesInputPort {

    private PriceRepository priceRepository;

    public PricesUseCase(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getPrice(PriceDetails priceDetails) {
        return null;
    }
}
