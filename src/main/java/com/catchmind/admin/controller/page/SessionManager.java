package com.catchmind.admin.controller.page;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class SessionManager {

    // 세션 생성
    public HttpSession createSession(HttpServletRequest request, String userid, String name) {
        HttpSession session = request.getSession();
        session.setAttribute("userid", userid);
        session.setAttribute("name", name);
        return session;
    }

    // 세션 조회 및 가져오기
    public void getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = "";
        String name = "";
        userid = (String) session.getAttribute("userid");
        name = (String) session.getAttribute("name");
    }

    // 세션만료 (로그아웃)
    public String expireSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect: /login";
    }
}
