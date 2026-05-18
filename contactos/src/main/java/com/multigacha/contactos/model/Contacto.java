package com.multigacha.contactos.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Contacto {

    private Integer id;
    private Integer telefono;
    private String direccion;

}
