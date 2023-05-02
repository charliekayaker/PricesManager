package com.pricesmanager.infra.outputadapter.repository;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;
import com.pricesmanager.infra.outputport.PriceRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class H2Repository implements PriceRepository {

    private JdbcTemplate jdbcTemplate;

    public H2Repository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Price getPrice(PriceDetails priceDetails) {
        return null;
    }
}
