package org.blackfin.infrastructure.persistence;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "userTable")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends PanacheEntity {
    private String name;
    @Column(name="last_name")
    private String lastName;
    private String dni;
    private String sexo;
    @Column(name="birth_date")
    private String birthDate;
    private String email;
    private String phone;
    private boolean status;
}