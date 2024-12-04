package com.microservice.user.infrastructure.out.jpa.entity;

import com.microservice.user.domain.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 50, unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "role")
    private List<UserEntity> user;

    public RoleEntity(String name) {
        this.name = name;
    }
}