package com.catchmind.admin.controller.api;

import com.catchmind.admin.service.ProfileLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainApiController {

    private final ProfileLogicService profileLogicService;


    // totaluser 및 newUser
//    @GetMapping("userCnt")
//    public void userCnt() {
//        profileLogicService.userCount();
//
//        System.out.println(profileLogicService.userCount());
//    }
}
