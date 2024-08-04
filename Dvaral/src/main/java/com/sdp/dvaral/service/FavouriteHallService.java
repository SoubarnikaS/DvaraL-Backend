package com.sdp.dvaral.service;


import com.sdp.dvaral.model.FavoriteHalls;
import com.sdp.dvaral.model.Halls;
import com.sdp.dvaral.model.Users;
import com.sdp.dvaral.repository.FavouriteHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavouriteHallService {

    @Autowired
    private FavouriteHallRepository favouriteHallRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private HallService hallService;


    public FavoriteHalls addHallToFav(Long userID, Long hallID) {

        Users userObj = userService.getUser(userID);
        Halls hallObj = hallService.getHallDetailsBYID(hallID).get();

        FavoriteHalls favoriteHalls = new FavoriteHalls();

        favoriteHalls.setUsers(userObj);
        favoriteHalls.setHall(hallObj);

        return favouriteHallRepository.save(favoriteHalls);
    }

//    public List<Halls> getFavouriteForUser(Long userID) {
//
//        //1)get particular user object
//        List<FavoriteHalls> favoriteHallsList = favouriteHallRepository.findByUsers_UserID(userID);
//
//        //2)stream the halls object alone from favHall object
//        List<Halls> favouriteHalls = favoriteHallsList.stream()
//                .map(FavoriteHalls::getHall)
//                .collect(Collectors
//                        .toCollection(ArrayList::new));
//        
//        return favouriteHalls;
//    }

    public List<FavoriteHalls> getFavouriteForUser(Long userID) {

        return favouriteHallRepository.findByUsers_UserID(userID);
    }

    public void deleteFavorite(FavoriteHalls favoriteHalls) {

        favouriteHallRepository.delete(favoriteHalls);
    }
}
