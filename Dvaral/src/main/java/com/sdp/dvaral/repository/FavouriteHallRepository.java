package com.sdp.dvaral.repository;

import com.sdp.dvaral.model.FavoriteHalls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteHallRepository extends JpaRepository<FavoriteHalls, Long> {
    List<FavoriteHalls> findByUsers_UserID(Long userId);

    @Override
    void delete(FavoriteHalls entity);
}
