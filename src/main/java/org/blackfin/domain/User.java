package org.blackfin.domain;

import lombok.*;

@Getter
@Setter
@Builder
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
