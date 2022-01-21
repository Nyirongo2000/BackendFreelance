package com.example.freelanceP.creator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface CreatorRepository extends JpaRepository<Creator,Long> {

    //SELECT * FROM creator WHERE email =?
  // @Query("SELECT s FROM s Creator WHERE s.email = ?1")
    Optional<Creator> findCreatorByEmail(String email);
}
