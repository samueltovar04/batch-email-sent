package org.blackfin.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private String sexo;
    private String birthDate;
    private String email;
    private String phone;
    private boolean status;
}
