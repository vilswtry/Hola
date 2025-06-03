package com.GreenEnergy.registroClientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GreenEnergy.registroClientes.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
