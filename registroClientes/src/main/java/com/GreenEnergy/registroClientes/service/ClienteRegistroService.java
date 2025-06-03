package com.GreenEnergy.registroClientes.service;

import com.GreenEnergy.registroClientes.DTO.ClienteRegistroDto;
import com.GreenEnergy.registroClientes.DTO.UsuarioDto;
import com.GreenEnergy.registroClientes.model.Cliente;
import com.GreenEnergy.registroClientes.model.Rol;
import com.GreenEnergy.registroClientes.model.Usuario;
import com.GreenEnergy.registroClientes.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClienteRegistroService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDto registrarCliente(ClienteRegistroDto dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setRut(dto.getRut());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefono(dto.getTelefono());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(Rol.CLIENTE);

        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setRut(dto.getRut());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());

        cliente.setUsuario(usuario);
        usuario.setCliente(cliente);

        usuarioRepository.save(usuario);

        return new UsuarioDto(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getRut(),
                usuario.getEmail(),
                usuario.getTelefono(),
                null,
                usuario.getRol());
    }

}
