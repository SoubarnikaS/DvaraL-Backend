package com.sdp.dvaral.service;

import com.sdp.dvaral.model.HallImages;
import com.sdp.dvaral.repository.ImageRepository;
import com.sdp.dvaral.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public HallImages uploadImage(MultipartFile files) throws IOException {

        return imageRepository.save(HallImages.builder()
                .imageName(files.getOriginalFilename())
                .data(ImageUtil.compressImage(files.getBytes())).build());

    }
}
