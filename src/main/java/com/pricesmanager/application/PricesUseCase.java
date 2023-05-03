package com.pricesmanager.application;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;
import com.pricesmanager.domain.exception.RegisterNotFoundException;
import com.pricesmanager.infra.inputport.PricesInputPort;
import com.pricesmanager.infra.outputport.PriceRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PricesUseCase implements PricesInputPort {

    private final PriceRepository priceRepository;

    public PricesUseCase(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

    @Override
    public Optional<Price> getPrice(PriceDetails priceDetails) {

        try {
            return priceRepository.getPrice(priceDetails);
        } catch (RegisterNotFoundException e) {
           e.printStackTrace();
        }

        return Optional.empty();
    }
}
