package com.GreenEnergy.registroClientes.DTO;

import com.GreenEnergy.registroClientes.model.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String rut;
    private String email;
    private String telefono;
    private String password;
    private Rol rol;
}
