package com.cebem.medidor.services;

import java.util.List;
import java.util.Optional;

import com.cebem.medidor.models.Superheroe;

public interface superheroeService {
    List<Superheroe> listarTodos();
    Optional<Superheroe> obtenerPorId(Long id);
    Superheroe guardar(Superheroe superheroe);
    void eliminar(Long id);
}
