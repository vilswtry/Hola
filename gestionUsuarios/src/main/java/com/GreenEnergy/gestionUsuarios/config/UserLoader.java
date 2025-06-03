package com.GreenEnergy.gestionUsuarios.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.GreenEnergy.gestionUsuarios.model.Cliente;
import com.GreenEnergy.gestionUsuarios.model.Rol;
import com.GreenEnergy.gestionUsuarios.model.Tecnico;
import com.GreenEnergy.gestionUsuarios.model.Usuario;
import com.GreenEnergy.gestionUsuarios.repository.UsuarioRepository;

import jakarta.annotation.PostConstruct;

@Configuration
public class UserLoader {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostConstruct
    public void initData() {
        if (usuarioRepository.count() > 0)
            return;

        Usuario cliente1 = new Usuario();
        cliente1.setNombre("Ana");
        cliente1.setApellido("González");
        cliente1.setRut("1001000-K");
        cliente1.setEmail("ana.gonzalez@example.com");
        cliente1.setTelefono("987654321");
        cliente1.setPassword("cliente123");
        cliente1.setRol(Rol.CLIENTE);

        Cliente datosCliente1 = new Cliente();
        datosCliente1.setNombre(cliente1.getNombre());
        datosCliente1.setApellido(cliente1.getApellido());
        datosCliente1.setRut(cliente1.getRut());
        datosCliente1.setEmail(cliente1.getEmail());
        datosCliente1.setTelefono(cliente1.getTelefono());
        datosCliente1.setUsuario(cliente1);
        cliente1.setCliente(datosCliente1);
        usuarioRepository.save(cliente1);


        Usuario cliente2 = new Usuario();
        cliente2.setNombre("Luis");
        cliente2.setApellido("Ramírez");
        cliente2.setRut("1002000-K");
        cliente2.setEmail("luis.ramirez@example.com");
        cliente2.setTelefono("987654322");
        cliente2.setPassword("cliente123");
        cliente2.setRol(Rol.CLIENTE);

        Cliente datosCliente2 = new Cliente();
        datosCliente2.setNombre(cliente2.getNombre());
        datosCliente2.setApellido(cliente2.getApellido());
        datosCliente2.setRut(cliente2.getRut());
        datosCliente2.setEmail(cliente2.getEmail());
        datosCliente2.setTelefono(cliente2.getTelefono());
        datosCliente2.setUsuario(cliente2);
        cliente2.setCliente(datosCliente2);
        usuarioRepository.save(cliente2);

        Usuario tecnico1 = new Usuario();
        tecnico1.setNombre("Carlos");
        tecnico1.setApellido("Muñoz");
        tecnico1.setRut("2001000-K");
        tecnico1.setEmail("carlos.munoz@example.com");
        tecnico1.setTelefono("912345671");
        tecnico1.setPassword("tecnico123");
        tecnico1.setRol(Rol.TECNICO);

        Tecnico datosTecnico1 = new Tecnico();
        datosTecnico1.setNombre(tecnico1.getNombre());
        datosTecnico1.setApellido(tecnico1.getApellido());
        datosTecnico1.setRut(tecnico1.getRut());
        datosTecnico1.setEmail(tecnico1.getEmail());
        datosTecnico1.setTelefono(tecnico1.getTelefono());
        datosTecnico1.setUsuario(tecnico1);
        tecnico1.setTecnico(datosTecnico1);
        usuarioRepository.save(tecnico1);

        Usuario tecnico2 = new Usuario();
        tecnico2.setNombre("Valeria");
        tecnico2.setApellido("Pérez");
        tecnico2.setRut("2002000-K");
        tecnico2.setEmail("valeria.perez@example.com");
        tecnico2.setTelefono("912345672");
        tecnico2.setPassword("tecnico123");
        tecnico2.setRol(Rol.TECNICO);

        Tecnico datosTecnico2 = new Tecnico();
        datosTecnico2.setNombre(tecnico2.getNombre());
        datosTecnico2.setApellido(tecnico2.getApellido());
        datosTecnico2.setRut(tecnico2.getRut());
        datosTecnico2.setEmail(tecnico2.getEmail());
        datosTecnico2.setTelefono(tecnico2.getTelefono());
        datosTecnico2.setUsuario(tecnico2);
        tecnico2.setTecnico(datosTecnico2);
        usuarioRepository.save(tecnico2);

    }
}
