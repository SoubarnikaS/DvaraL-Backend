package com.sdp.dvaral.repository;


import com.sdp.dvaral.model.HallImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<HallImages, Long> {

    List<HallImages> findByHalls_HallID(Long hallID);}
