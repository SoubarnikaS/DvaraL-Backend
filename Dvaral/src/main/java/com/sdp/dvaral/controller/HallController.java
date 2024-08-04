package com.sdp.dvaral.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sdp.dvaral.model.HallImages;
import com.sdp.dvaral.model.Halls;
import com.sdp.dvaral.service.HallService;
import com.sdp.dvaral.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/halls")
@Slf4j
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

            imageService.uploadImage(files, hallResponse);

            return new ResponseEntity<>("Hall details added successfully with ID : " + hallResponse.getHallID(), HttpStatus.CREATED);

        }catch (Exception e){

            log.error(e.getMessage());
            return new ResponseEntity<>("Error in adding hall details : {}" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/hall/{hallId}")
    public List<HallImages> getImagesByHallId(@PathVariable Long hallId) {
        return imageService.getImagesByHallId(hallId);
    }
}
