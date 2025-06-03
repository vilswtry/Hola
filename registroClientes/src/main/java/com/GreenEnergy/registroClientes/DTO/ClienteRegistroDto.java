package com.GreenEnergy.registroClientes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRegistroDto {

    private String nombre;
    private String apellido;
    private String rut;
    private String email;
    private String telefono;
    private String password;

}
