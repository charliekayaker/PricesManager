package com.pricesmanager.infra.inputport;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;

import java.util.Optional;

public interface PricesInputPort {

    Optional<Price> getPrice(PriceDetails priceDetails);
}
