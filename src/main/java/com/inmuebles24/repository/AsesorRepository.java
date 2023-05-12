package com.inmuebles24.repository;

import com.inmuebles24.model.Asesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsesorRepository extends JpaRepository<Asesor,Long> {
}
