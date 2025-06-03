package com.GreenEnergy.gestionUsuarios.repository;

import com.GreenEnergy.gestionUsuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}