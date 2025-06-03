package com.GreenEnergy.gestionUsuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GreenEnergy.gestionUsuarios.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
