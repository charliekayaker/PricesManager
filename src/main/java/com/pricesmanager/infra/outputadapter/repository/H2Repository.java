package com.pricesmanager.infra.outputadapter.repository;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;
import com.pricesmanager.infra.outputport.PriceRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
public class H2Repository implements PriceRepository {

    private final JdbcTemplate jdbcTemplate;

    public H2Repository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Price> getPrice(PriceDetails priceDetails) {
        RowMapper<Price> rowMapper = (rs, rowNum) -> Price.builder()
                .productId(rs.getInt("PRODUCT_ID"))
                .brandId(rs.getInt("BRAND_ID"))
                .startDate(rs.getDate("START_DATE"))
                .priceList(rs.getInt("PRICE_LIST"))
                .endDate(rs.getDate("END_DATE"))
                .value(rs.getDouble(("PRICE"))
                )
                .build();

        List<Price> prices = jdbcTemplate.query(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRICE WHERE START_DATE = ?");
                    ps.setDate(1, new java.sql.Date(priceDetails.getApplicationDate().getTime()));
                    return ps;
                },
                rowMapper);

        return Optional.of(prices.get(0));
    }
}
