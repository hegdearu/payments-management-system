package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.AuditAction;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {
    private Long id;
    private String entityType;
    private Long entityId;
    private AuditAction action;
    private String oldValues;
    private String newValues;
    private Long userId;
    private LocalDateTime timestamp;
    private String ipAddress;
}
