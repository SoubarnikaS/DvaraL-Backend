package com.sdp.dvaral.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sdp.dvaral.model.HallImages;
import com.sdp.dvaral.model.Halls;
import com.sdp.dvaral.service.HallService;
import com.sdp.dvaral.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/halls")
public class HallController {

    @Autowired
    private HallService hallService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/add-halls", consumes = {"multipart/form-data"})
    public ResponseEntity<?> addHallDetails(@RequestPart ("formData") String formData, @RequestPart ("files") MultipartFile files) {

        try{

            objectMapper.registerModule(new JavaTimeModule());

            Halls hallObj = objectMapper.readValue(formData, Halls.class);

            Halls hallResponse = hallService.addHallDetails(hallObj);

            imageService.uploadImage(files);

            return new ResponseEntity<>("Hall details added successfully with ID : " + hallResponse.getHallID(), HttpStatus.CREATED);
        }catch (Exception e){

            return new ResponseEntity<>("Error in adding hall details", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
