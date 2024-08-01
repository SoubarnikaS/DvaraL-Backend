package com.sdp.dvaral.repository;

import com.sdp.dvaral.model.Halls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Halls, Long> {
}
