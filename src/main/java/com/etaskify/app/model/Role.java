package com.etaskify.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 494140733821570671L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @NaturalId
    @Column(name = "name")
    private RoleName roleName;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public static Role fromName(RoleName name) {
        if (name == null) {
            return null;
        }
        return new Role(name);
    }
}
