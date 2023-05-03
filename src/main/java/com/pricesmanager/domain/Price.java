package com.pricesmanager.domain;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Builder
@Getter
public class Price {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int productId;
    private double value;
    private int brandId;
    private int priceList;
}
