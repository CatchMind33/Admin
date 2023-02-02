package com.catchmind.admin.model.entity;

import com.catchmind.admin.repository.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProfileTest {
    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void userCount() {
        Long cnt = profileRepository.count();
        System.out.println(cnt);
//        return profileRepository.CountById();
    }
}