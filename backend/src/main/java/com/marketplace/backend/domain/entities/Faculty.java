package com.marketplace.backend.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "faculty", unique = true)
    private String facultyName;

    @OneToMany(mappedBy = "faculty",  cascade = CascadeType.ALL, fetch = FetchType.LAZY,  orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
        user.setFaculty(this);
    }
}
