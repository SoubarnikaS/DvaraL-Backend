package com.sdp.dvaral.service;

import com.sdp.dvaral.model.Halls;
import com.sdp.dvaral.model.Users;
import com.sdp.dvaral.repository.HallRepository;
import com.sdp.dvaral.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private UserRepository userRepository;

    public Halls addHallDetails(Halls halls, Long userID) {

        Optional<Users> userObj = userRepository.findById(userID);

        userObj.ifPresent(halls::setUsers);

        return hallRepository.save(halls);
    }

    public List<Halls> getAllHallDetails() {
        return hallRepository.findAll();
    }

    public Optional<Halls> getHallDetailsBYID(Long hallID) {
        return hallRepository.findById(hallID);
    }

    public Optional<Halls> editHallDetails(Halls halls, Long hallID) {

        Halls existingHall = hallRepository.findById(hallID).orElse(null);

        if (existingHall != null) {

            existingHall.setHallOwner(halls.getHallOwner());
            existingHall.setHallName(halls.getHallName());
            existingHall.setHallType(halls.getHallType());
            existingHall.setHallLocation(halls.getHallLocation());
            existingHall.setHallDescription(halls.getHallDescription());
            existingHall.setHallStatus(halls.getHallStatus());
            existingHall.setHallAddress(halls.getHallAddress());
            existingHall.setHallContact(halls.getHallContact());
            existingHall.setCapacity(halls.getCapacity());
            existingHall.setHallPrice(halls.getHallPrice());
            existingHall.setHallAmenitiesList(halls.getHallAmenitiesList());


            Halls updatedHall = hallRepository.save(existingHall);


            return Optional.of(updatedHall);

        } else {

            return Optional.empty();
        }
    }


    public Boolean deleteHallDetails(Long hallID) {

        Halls halls = hallRepository.findById(hallID).orElse(null);

        if (halls != null) {

            hallRepository.deleteById(hallID);
            return true;
        }else{

            return false;
        }

    }


}
