package org.example.model;

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
public class Report {
    private Long id;
    private ReportType reportType;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private BigDecimal totalIncoming = BigDecimal.ZERO;
    private BigDecimal totalOutgoing = BigDecimal.ZERO;
    private BigDecimal netAmount = BigDecimal.ZERO;
    private Long generatedBy;
    private LocalDateTime generatedAt;
    private String filePath;
}
