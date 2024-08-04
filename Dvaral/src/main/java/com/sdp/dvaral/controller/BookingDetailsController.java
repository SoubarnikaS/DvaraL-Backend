package com.sdp.dvaral.controller;


import com.sdp.dvaral.model.BookingDetails;
import com.sdp.dvaral.service.BookingDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hall")
@Slf4j
public class BookingDetailsController {

    @Autowired
    private BookingDetailsService bookingDetailsService;


    @PostMapping("/add/booking-details/{userID}/{hallID}")
    public ResponseEntity<?> addBookingDetails(@RequestBody BookingDetails bookingDetails, @PathVariable Long userID, @PathVariable Long hallID) {

        try{

            log.info("Started");
            BookingDetails bookedHalls = bookingDetailsService.addBookingDetails(bookingDetails, userID, hallID);
            log.info("Completed");
            return new ResponseEntity<>(bookedHalls, HttpStatus.CREATED);

        }catch (Exception e){

            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
