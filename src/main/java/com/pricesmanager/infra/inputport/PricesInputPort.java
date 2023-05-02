package com.pricesmanager.infra.inputport;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;

public interface PricesInputPort {

    Price getPrice(PriceDetails priceDetails);
}
