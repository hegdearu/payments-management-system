package org.example.repository;

import org.example.enums.PaymentCategory;
import org.example.enums.PaymentStatus;
import org.example.enums.PaymentType;
import org.example.model.Payment;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public class PaymentRepository {
    private final JdbcTemplate jdbcTemplate;

    public PaymentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Payment save(Payment payment) {
        String insertSql = "INSERT INTO payments (" +
                "id, payment_type, category, amount, description, status, created_by" +
                ") VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(insertSql);
            ps.setString(1, payment.getId());
            ps.setString(2, payment.getPaymentType().name());
            ps.setString(3, payment.getCategory().name());
            ps.setBigDecimal(4, payment.getAmount());
            ps.setString(5, payment.getDescription());
            ps.setString(6, payment.getStatus().name());
            ps.setString(7, payment.getCreatedBy());
            return ps;
        }, keyHolder);

        String selectSql = "SELECT * FROM payments WHERE id = ?";
        return jdbcTemplate.queryForObject(selectSql,paymentRowMapper() ,payment.getId());

    }

    private RowMapper<Payment> paymentRowMapper() {
        return (rs, rowNum) -> Payment.builder()
                .id(rs.getString("id"))
                .paymentType(PaymentType.valueOf(rs.getString("payment_type")))
                .category(PaymentCategory.valueOf(rs.getString("category")))
                .amount(rs.getBigDecimal("amount"))
                .description(rs.getString("description"))
                .status(PaymentStatus.valueOf(rs.getString("status")))
                .paymentDate(rs.getObject("payment_date", LocalDate.class))
                .createdBy(rs.getString("created_by"))
                .createdAt(rs.getObject("created_at", LocalDateTime.class))
                .updatedAt(rs.getObject("updated_at", LocalDateTime.class))
                .build();
    }
}