package com.sdp.dvaral.service;


import com.sdp.dvaral.model.BookingDetails;
import com.sdp.dvaral.model.Halls;
import com.sdp.dvaral.model.Users;
import com.sdp.dvaral.repository.BookingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingDetailsService {

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private HallService hallService;


    public BookingDetails addBookingDetails(BookingDetails bookingDetails, Long userID, Long hallID) {

        Users userObj = userService.getUser(userID);
        Halls hallObj = hallService.getHallDetailsBYID(hallID).get();

        bookingDetails.setUsers(userObj);
        bookingDetails.setHalls(hallObj);

        return bookingDetailsRepository.save(bookingDetails);
    }
}
