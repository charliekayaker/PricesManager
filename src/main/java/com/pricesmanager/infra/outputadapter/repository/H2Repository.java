package com.pricesmanager.infra.outputadapter.repository;

import com.pricesmanager.domain.Price;
import com.pricesmanager.domain.PriceDetails;
import com.pricesmanager.domain.exception.RegisterNotFoundException;
import com.pricesmanager.infra.outputport.PriceRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Component
public class H2Repository implements PriceRepository {

    private final JdbcTemplate jdbcTemplate;

    public H2Repository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Price> getPrice(PriceDetails priceDetails) throws RegisterNotFoundException {
        RowMapper<Price> rowMapper = (rs, rowNum) -> Price.builder()
                .productId(rs.getInt("PRODUCT_ID"))
                .brandId(rs.getInt("BRAND_ID"))
                .startDate(rs.getTimestamp("START_DATE").toLocalDateTime())
                .priceList(rs.getInt("PRICE_LIST"))
                .endDate(rs.getTimestamp("END_DATE").toLocalDateTime())
                .price(rs.getDouble(("PRICE")))
                .build();

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT PRODUCT_ID,")
                  .append(" BRAND_ID,")
                  .append(" START_DATE,")
                  .append(" PRICE_LIST,")
                  .append(" END_DATE,")
                  .append(" PRICE,")
                  .append(" PRIORITY")
                  .append(" FROM PRICE WHERE ?")
                  .append(" BETWEEN START_DATE AND END_DATE ")
                  .append("ORDER BY PRIORITY");

        List<Price> prices = jdbcTemplate.query(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(sqlBuilder.toString());
                    ps.setTimestamp(1, Timestamp.valueOf(priceDetails.getApplicationDate())) ;
                    return ps;
                },
                rowMapper);

        if(prices.get(0)==null){
            throw new RegisterNotFoundException("No records match the conditions . . . ");
        }

        return Optional.of(prices.get(0));
    }
}
