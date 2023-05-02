package com.pricesmanager.infra.outputport;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;

import java.util.Optional;

public interface PriceRepository {

   Optional<Price> getPrice(PriceDetails priceDetails);
}
