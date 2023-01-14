package com.illusioncart.springserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Builder
@Entity
@Data //getter setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user") //in postgres user table is predefined
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Integer uuid;

    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Book> book;


    //Below methods injected by UserDetails for Authentication
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
