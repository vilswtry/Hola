package com.GreenEnergy.gestionUsuarios.DTO;

import com.GreenEnergy.gestionUsuarios.model.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
