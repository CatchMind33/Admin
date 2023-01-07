package com.catchmind.admin.model.config;

import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getRegDate();
    void setRegDate(LocalDateTime regDate);
}
