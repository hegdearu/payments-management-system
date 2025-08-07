package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.ReportType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDto {
    private Long id;
    private ReportType reportType;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private BigDecimal totalIncoming;
    private BigDecimal totalOutgoing;
    private BigDecimal netAmount;
    private String generatedByUsername;
    private LocalDateTime generatedAt;
    private String filePath;
}
