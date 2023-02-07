package com.catchmind.admin.controller.page;

import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.response.DecComApiResponse;
import com.catchmind.admin.model.network.response.DecReviewApiResponse;
import com.catchmind.admin.model.network.response.ReviewApiResponse;
import com.catchmind.admin.service.DecComLogicService;
import com.catchmind.admin.service.DecReviewLogicService;
import com.catchmind.admin.service.PaginationService;
import com.catchmind.admin.service.ReviewLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewLogicService reviewLogicService;
    private final PaginationService paginationService;
    private final DecReviewLogicService decReviewLogicService;
    private final DecComLogicService decComLogicService;

    @GetMapping("")
    public String reviewMain(@PageableDefault(size=10, sort="revIdx", direction = Sort.Direction.DESC)Pageable pageable, ModelMap map) {
        Page<ReviewApiResponse> reviews = reviewLogicService.reviewList(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), reviews.getTotalPages());
        map.addAttribute("reviews",reviews);
        map.addAttribute("paginationBarNumbers", barNumbers);
        System.out.println(reviews);
        return "review/review";
    }

    @GetMapping("/detail/{revIdx}")
    public ModelAndView reviewDetail(@PathVariable Long revIdx) {
        Header<ReviewApiResponse> review = reviewLogicService.read(revIdx);
        ModelAndView view = new ModelAndView("review/review_detail");
        view.addObject("review", review.getData());
        System.out.println(review);
        System.out.println(review.getData());
        return view;
    }

    @GetMapping("/report")
    public String reviewReport(@PageableDefault(size=5, sort="derIdx", direction = Sort.Direction.DESC) Pageable pageable, ModelMap map) {
        Page<DecReviewApiResponse> decReviews = decReviewLogicService.list(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), decReviews.getTotalPages());
        map.addAttribute("decReviews", decReviews);
        map.addAttribute("paginationBarNumbers",barNumbers);
        System.out.println(decReviews);
        return "review/review_report";
    }

    @GetMapping("/comment/report")
    public String commentReport(@PageableDefault(size=5, sort="decIdx", direction = Sort.Direction.DESC) Pageable pageable, ModelMap map) {
        Page<DecComApiResponse> decComs = decComLogicService.list(pageable);
        List<Integer> barNumbers = paginationService.getPaginationBarNumber(pageable.getPageNumber(), decComs.getTotalPages());
        map.addAttribute("decComs", decComs);
        map.addAttribute("paginationBarNumbers",barNumbers);
        return "review/comment_report";
    }
}
