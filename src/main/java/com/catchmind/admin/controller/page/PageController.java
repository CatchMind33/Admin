package com.catchmind.admin.controller.page;

import com.catchmind.admin.model.entity.DeclareComment;
import com.catchmind.admin.model.entity.DeclareReview;
import com.catchmind.admin.model.entity.Profile;
import com.catchmind.admin.model.entity.Review;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.response.TalkAdminApiResponse;
import com.catchmind.admin.repository.*;
import com.catchmind.admin.service.AdminLogicService;
import com.catchmind.admin.service.PaginationService;
import com.catchmind.admin.service.TalkAdminApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class PageController {
    private final AdminLogicService adminLogicService;
    private final PaginationService paginationService;
    private final TalkAdminApiLogicService talkAdminApiLogicService;
    private final ReviewRepository reviewRepository;
    private final DecReviewRepository decReviewRepository;
    private final DecComRepository decComRepository;
    private final ProfileRepository profileRepository;
    private final ReserveRepository reserveRepository;
    private final ResAdminRepository resAdminRepository;

    @GetMapping("")
    public ModelAndView index(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {
            return new ModelAndView("/login");
        } else {
            userid= (String)session.getAttribute("userid");
            name= (String)session.getAttribute("name");
        }
        List<Review> reviews = reviewRepository.findTop3By();
        List<DeclareReview> declareReviews = decReviewRepository.findTop3By();
        List<DeclareComment> declareComments = decComRepository.findTop3By();
        List<Profile> profiles = profileRepository.findTop4By();
        Integer rev1 = reserveRepository.countByResMonth("01");
        Integer rev2 = reserveRepository.countByResMonth("02");
        Integer rev3 = reserveRepository.countByResMonth("03");
        Integer rev4 = reserveRepository.countByResMonth("04");
        Integer rev5 = reserveRepository.countByResMonth("05");
        Integer rev6 = reserveRepository.countByResMonth("06");
        Integer rev7 = reserveRepository.countByResMonth("07");
        Integer rev8 = reserveRepository.countByResMonth("08");
        Integer rev9 = reserveRepository.countByResMonth("09");
        Integer rev10 = reserveRepository.countByResMonth("10");
        Integer rev11 = reserveRepository.countByResMonth("11");
        Integer rev12 = reserveRepository.countByResMonth("12");
        Integer totrev = reserveRepository.countBy();
        Integer totres = resAdminRepository.countBy();
        Integer totreview = reviewRepository.countBy();
        Integer totuser = profileRepository.countBy();
        List<Profile> ranking = profileRepository.findTop5ByOrderByPrReviewDesc();
        String rank1name = ranking.get(0).getPrNick();
        String rank1count = String.valueOf(ranking.get(0).getPrReview());
        String rank2name = ranking.get(1).getPrNick();
        String rank2count = String.valueOf(ranking.get(1).getPrReview());
        String rank3name = ranking.get(2).getPrNick();
        String rank3count = String.valueOf(ranking.get(2).getPrReview());
        String rank4name = ranking.get(3).getPrNick();
        String rank4count = String.valueOf(ranking.get(3).getPrReview());
        String rank5name = ranking.get(4).getPrNick();
        String rank5count = String.valueOf(ranking.get(4).getPrReview());

        return new ModelAndView("/index")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("reviews",reviews)
                .addObject("decrev",declareReviews)
                .addObject("decCom",declareComments)
                .addObject("profile",profiles)
                .addObject("rev1",rev1)
                .addObject("rev2",rev2)
                .addObject("rev3",rev3)
                .addObject("rev4",rev4)
                .addObject("rev5",rev5)
                .addObject("rev6",rev6)
                .addObject("rev7",rev7)
                .addObject("rev8",rev8)
                .addObject("rev9",rev9)
                .addObject("rev10",rev10)
                .addObject("rev11",rev11)
                .addObject("rev12",rev12)
                .addObject("totrev",totrev)
                .addObject("totres",totres)
                .addObject("totreview",totreview)
                .addObject("totuser",totuser)
                .addObject("rank1name",rank1name)
                .addObject("rank2name",rank2name)
                .addObject("rank3name",rank3name)
                .addObject("rank4name",rank4name)
                .addObject("rank5name",rank4name)
                .addObject("rank1count",rank1count)
                .addObject("rank2count",rank2count)
                .addObject("rank3count",rank3count)
                .addObject("rank4count",rank4count)
                .addObject("rank5count",rank5count);
    }

    @GetMapping("login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @GetMapping("join")
    public ModelAndView join() {
        return new ModelAndView("/join");
    }

    @GetMapping("message")
    public ModelAndView message(@PageableDefault(size=10, sort="taaIdx", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<TalkAdminApiResponse> talks = talkAdminApiLogicService.msgList(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), talks.getTotalPages());
        ModelAndView view = new ModelAndView("/message");
        view.addObject("talks", talks);
        System.out.println(talks);
        view.addObject("paginationBarNumbers",barNumbers);
        return view;
    }

    @GetMapping("message/detail/{taaIdx}")
    public ModelAndView messageDetail(@PathVariable Long taaIdx) {
        Header<TalkAdminApiResponse> talk = talkAdminApiLogicService.read(taaIdx);
        ModelAndView view = new ModelAndView("/message_detail");
        view.addObject("talk", talk.getData());
        return view;
    }

    // 로그인 구현
    @PostMapping(path="/loginOk")  // http://localhost:8888/loginOk
    public String loginOk(HttpServletRequest request, String adUserid, String adUserpw){
        if(adminLogicService.read(adUserid,adUserpw).getData()!= null) {
            HttpSession session = request.getSession();
            String name = adminLogicService.read(adUserid, adUserpw).getData().getAdName();
            String userid = adminLogicService.read(adUserid, adUserpw).getData().getAdUserid();
            session.setAttribute("userid",userid);
            session.setAttribute("name",name);
            return "redirect:/";
        }else{
            return "redirect:/login";
        }
    }

}
