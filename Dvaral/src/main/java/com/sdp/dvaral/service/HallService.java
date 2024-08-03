package com.sdp.dvaral.service;

import com.sdp.dvaral.model.Halls;
import com.sdp.dvaral.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    public Halls addHallDetails(Halls formData) {

        return hallRepository.save(formData);
    }
}
