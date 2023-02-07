package com.catchmind.admin.service;

import com.catchmind.admin.model.entity.Photo;
import com.catchmind.admin.model.network.Header;
import com.catchmind.admin.model.network.request.PhotoApiRequest;
import com.catchmind.admin.model.network.response.PhotoApiResponse;
import com.catchmind.admin.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoApiLogicService extends BaseService<PhotoApiRequest, PhotoApiResponse, Photo>{

    private final PhotoRepository photoRepository;

    private PhotoApiResponse response(Photo photo) {
        PhotoApiResponse photoApiResponse = PhotoApiResponse.builder()
                .phIdx(photo.getPhIdx())
                .orgNm(photo.getOrgNm())
                .savedNm(photo.getSavedNm())
                .savedPath(photo.getSavedPath())
                .type(photo.getType())
                .resaBisName(photo.getResaBisName())
                .build();
        return photoApiResponse;
    }



    @Override
    public Header<PhotoApiResponse> create(Header<PhotoApiRequest> request) {
        PhotoApiRequest photoApiRequest = request.getData();
        Photo photo = Photo.builder()
                .resaBisName(photoApiRequest.getResaBisName())
                .build();
        Photo newPhoto = photoRepository.save(photo);
        return Header.OK(response(newPhoto));
    }

    @Override
    public Header<PhotoApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<PhotoApiResponse> update(Header<PhotoApiRequest> request) {
        return null;
    }

    @Override
    public Header<PhotoApiResponse> delete(Long id) {
        return null;
    }
}
