package com.sdp.dvaral.repository;

import com.sdp.dvaral.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Long> {
    List<BookingDetails> findByUsers_UserID(Long userID);
}
