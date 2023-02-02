package com.catchmind.admin.controller.api;

import com.catchmind.admin.controller.CrudController;
import com.catchmind.admin.model.entity.TalkAdmin;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.TalkAdminApiRequest;
import com.catchmind.admin.model.network.response.ProfileResponse;
import com.catchmind.admin.model.network.response.TalkAdminApiResponse;
import com.catchmind.admin.repository.ProfileRepository;
import com.catchmind.admin.service.ProfileLogicService;
import com.catchmind.admin.service.TalkAdminApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/talkAdmin")
@RequiredArgsConstructor
public class TalkAdminApiController extends CrudController<TalkAdminApiRequest, TalkAdminApiResponse, TalkAdmin> {
    private final TalkAdminApiLogicService talkAdminApiLogicService;
    private final ProfileRepository profileRepository;
    private final ProfileLogicService profileLogicService;

    @GetMapping("/noShow")
    public Header<ProfileResponse> noShow(@RequestParam("nick") String taaNick, @RequestParam("idx") Long prIdx, @RequestParam("msg") String taaContent, @RequestParam("status") boolean prBlock) {
        talkAdminApiLogicService.createmsg(taaNick,taaContent);
//        profileLogicService.updateBlock(prIdx,prBlock);
        return profileLogicService.updateBlock(prIdx,prBlock);
    }

    @GetMapping("/point")
    public Header<ProfileResponse> point(@RequestParam("nick") String taaNick, @RequestParam("idx") Long prIdx, @RequestParam("msg") String taaContent, @RequestParam("point") Integer point ) {
        talkAdminApiLogicService.createmsg(taaNick,taaContent);
//        profileLogicService.updateBlock(prIdx,prBlock);
        return profileLogicService.updatePoint(prIdx,point);
    }

    @GetMapping("/adminmsg")
    public Header<TalkAdminApiResponse> admin(@RequestParam("name") String resaBisName, @RequestParam("msg") String taaContent) {
        return talkAdminApiLogicService.createadminmsg(resaBisName,taaContent);
    }

    @GetMapping("/msg")
    public Header<TalkAdminApiResponse> user(@RequestParam("taaNick") String taaNick, @RequestParam("taaContent") String taaContent) {
        return talkAdminApiLogicService.createmsg(taaNick,taaContent);
    }

    @PostMapping("/pending")
    public Header<TalkAdminApiResponse> pending(@RequestBody Header<TalkAdminApiRequest> request) {
        System.out.println(request.getData());
        return talkAdminApiLogicService.createPending(request);
    }
}
