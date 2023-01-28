package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.Notice;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.NoticeApiRequest;
import com.catchmind.admin.model.network.response.NoticeApiResponse;
import com.catchmind.admin.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeApiLogicService extends BaseService<NoticeApiRequest, NoticeApiResponse, Notice> {

    private final NoticeRepository noticeRepository;


    private NoticeApiResponse response(Notice users){
        NoticeApiResponse noticeApiResponse = NoticeApiResponse.builder()
                .noIdx(users.getNoIdx())
                .noTitle(users.getNoTitle())
                .adName(users.getAdName())
                .adUserid(users.getAdUserid())
                .noContent(users.getNoContent())
                .build();
        return noticeApiResponse;
    }


    @Override
    public Header<NoticeApiResponse> create(Header<NoticeApiRequest> request) {
        NoticeApiRequest noticeApiRequest = request.getData();

        Notice notice = Notice.builder().noTitle(noticeApiRequest.getNoTitle())
                .adName(noticeApiRequest.getAdName())
                .noContent(noticeApiRequest.getNoContent())
                .build();
        Notice newNotice = baseRepository.save(notice);
        return Header.OK(response(newNotice));
    }



    @Override
    public Header<NoticeApiResponse> update(Header<NoticeApiRequest> request) {
        NoticeApiRequest noticeApiRequest = request.getData();
        Optional<Notice> notices = noticeRepository.findByNoIdx(noticeApiRequest.getNoIdx());
//        System.out.println("idx는" + noticeApiRequest.getNoIdx());
//        System.out.println("notices는" + notices);
        return notices.map(
                        user -> {
                            user.setNoTitle(noticeApiRequest.getNoTitle());
                            user.setNoContent(noticeApiRequest.getNoContent());
                            return user;
                        }).map(user -> baseRepository.save(user))
                .map(user -> response(user))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음")
                );
    }


    @Override
    public Header delete(Long noIdx) {
        Optional<Notice> notices = baseRepository.findById(noIdx);
        return notices.map(notice -> {
            baseRepository.delete(notice);
            return Header.ok();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }


    @Override
    public Header<NoticeApiResponse> read(Long id) {
        return baseRepository.findById(id).map(notice -> response(notice))
                .map(Header::OK).orElseGet(()->Header.ERROR("데이터 없음"));
    }


    @Transactional(readOnly = true)
    public Page<Notice> noticeList(Pageable pageable) {
        return noticeRepository.findAll(pageable);

    }






//    public Header<List<NoticeApiResponse>> search(Pageable pageable) {
//        Page<Notice> notices = baseRepository.findAll(pageable);
//        List<NoticeApiResponse> noticeApiResponses = notices.stream().map(
//                notice -> response(notice)).collect(Collectors.toList());
//        Pagination pagination = Pagination.builder()
//                .totalPages(notices.getTotalPages())
//                .totalElements(notices.getTotalElements())
//                .currentPage(notices.getNumber())
//                .currentElements(notices.getNumberOfElements())
//                .build();
//        return Header.OK(noticeApiResponses, pagination);
//    }

}
