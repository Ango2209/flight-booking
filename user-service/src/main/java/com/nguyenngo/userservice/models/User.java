package com.nguyenngo.userservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String password;
    private String address;
    @Column(unique = true, nullable = false)
    private String email;
    private String numberPhone;
}
