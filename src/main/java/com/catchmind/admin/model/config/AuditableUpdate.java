package com.catchmind.admin.model.config;

import java.time.LocalDateTime;

public interface AuditableUpdate {
    LocalDateTime getRegDate();
    LocalDateTime getUpdateDate();

    void setRegDate(LocalDateTime regDate);
    void setUpdateDate(LocalDateTime updateDate);
}

