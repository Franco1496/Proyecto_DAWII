package com.inmuebles24.repository;

import com.inmuebles24.model.Propiedad_asesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Propiedad_asesorRepository extends JpaRepository<Propiedad_asesor, Long> {
}
