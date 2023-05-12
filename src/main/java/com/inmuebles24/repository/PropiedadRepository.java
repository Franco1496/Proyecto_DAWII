package com.inmuebles24.repository;

import com.inmuebles24.model.Propiedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropiedadRepository extends JpaRepository<Propiedad,Long> {
}
