package ru.netology.springsecuritydemo.entity;

import lombok.Data;
import ru.netology.springsecuritydemo.entity.enums.Role;
import ru.netology.springsecuritydemo.entity.enums.Status;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private Status status;
}