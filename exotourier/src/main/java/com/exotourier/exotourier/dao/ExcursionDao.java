package com.exotourier.exotourier.dao;

import com.exotourier.exotourier.domain.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

public interface ExcursionDao extends JpaRepository<Excursion, Integer> {

=======
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExcursionDao extends JpaRepository<Excursion, Integer> {

    Optional<Excursion> findByName(String name);
>>>>>>> 53f4914a5a1dfec6dc78128b276e398ad1a5d2ff

}
