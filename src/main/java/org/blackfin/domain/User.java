package org.blackfin.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
