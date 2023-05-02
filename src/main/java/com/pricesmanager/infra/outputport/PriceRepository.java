package com.pricesmanager.infra.outputport;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;

public interface PriceRepository {

   Price getPrice(PriceDetails priceDetails);
}
