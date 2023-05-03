package com.pricesmanager.domain;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Builder
@Getter
public class PriceDetails {

    private String brandId;
    private String productId;
    private LocalDateTime applicationDate;
}
