package com.catchmind.admin.model.type;

import lombok.Getter;

public enum UserSortType {
    NAME("이름"),
    NICKNAME("닉네임"),
    REGDATE("가입날짜");

    @Getter private final String description;

    UserSortType(String description){
        this.description = description;
    }

}
