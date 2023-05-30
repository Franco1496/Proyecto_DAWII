package com.inmuebles24.repository;

import com.inmuebles24.model.TipoPropiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPropiedadRepository extends JpaRepository<TipoPropiedad, Long> {
}
