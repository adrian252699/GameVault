package com.example.GameVault.repository;

import com.example.GameVault.Model.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJuegoRepository extends JpaRepository<Juego,Long> {
    List<Juego> findByTituloContainingIgnoreCase(String titulo);

    @Query("SELECT j FROM Juego j WHERE LOWER(j.descripcion) LIKE LOWER(CONCAT('%', :filtro, '%'))")
    List<Juego> buscarPorDescripcion(@Param("filtro") String filtro);
}
