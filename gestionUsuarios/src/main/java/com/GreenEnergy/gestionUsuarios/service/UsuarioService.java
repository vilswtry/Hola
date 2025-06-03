package com.GreenEnergy.gestionUsuarios.service;

import com.GreenEnergy.gestionUsuarios.model.Usuario;
import com.GreenEnergy.gestionUsuarios.DTO.UsuarioDto;
import com.GreenEnergy.gestionUsuarios.model.Cliente;
import com.GreenEnergy.gestionUsuarios.model.Rol;
import com.GreenEnergy.gestionUsuarios.model.Tecnico;
import com.GreenEnergy.gestionUsuarios.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDto crearUsuario(UsuarioDto dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setRut(dto.getRut());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefono(dto.getTelefono());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(dto.getRol());

        if (dto.getRol() == Rol.CLIENTE) {
            Cliente cliente = new Cliente();
            cliente.setNombre(dto.getNombre());
            cliente.setApellido(dto.getApellido());
            cliente.setRut(dto.getRut());
            cliente.setEmail(dto.getEmail());
            cliente.setTelefono(dto.getTelefono());

            cliente.setUsuario(usuario);
            usuario.setCliente(cliente);
        } else if (dto.getRol() == Rol.TECNICO) {
            Tecnico tecnico = new Tecnico();
            tecnico.setNombre(dto.getNombre());
            tecnico.setApellido(dto.getApellido());
            tecnico.setRut(dto.getRut());
            tecnico.setEmail(dto.getEmail());
            tecnico.setTelefono(dto.getTelefono());

            tecnico.setUsuario(usuario);
            usuario.setTecnico(tecnico);
        }

        usuarioRepository.save(usuario);
        return dto;
    }

    public UsuarioDto actualizarUsuario(Long id, UsuarioDto dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setRut(dto.getRut());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefono(dto.getTelefono());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(dto.getRol());

        if (usuario.getRol() == Rol.CLIENTE) {
            Cliente cliente = usuario.getCliente();
            if (cliente == null) {
                cliente = new Cliente();
                cliente.setUsuario(usuario);
                usuario.setCliente(cliente);
            }
            cliente.setNombre(dto.getNombre());
            cliente.setApellido(dto.getApellido());
            cliente.setRut(dto.getRut());
            cliente.setEmail(dto.getEmail());
            cliente.setTelefono(dto.getTelefono());

        } else if (usuario.getRol() == Rol.TECNICO) {
            Tecnico tecnico = usuario.getTecnico();
            if (tecnico == null) {
                tecnico = new Tecnico();
                tecnico.setUsuario(usuario);
                usuario.setTecnico(tecnico);
            }
            tecnico.setNombre(dto.getNombre());
            tecnico.setApellido(dto.getApellido());
            tecnico.setRut(dto.getRut());
            tecnico.setEmail(dto.getEmail());
            tecnico.setTelefono(dto.getTelefono());
        }

        usuarioRepository.save(usuario);
        return dto;
    }

    public void eliminarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioRepository.delete(usuario);
    }

    public UsuarioDto mapToDto(Usuario usuario) {
        if (usuario == null)
            return null;
        UsuarioDto dto = new UsuarioDto();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setRut(usuario.getRut());
        dto.setEmail(usuario.getEmail());
        dto.setTelefono(usuario.getTelefono());
        dto.setPassword(null);
        dto.setRol(usuario.getRol());
        return dto;
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}