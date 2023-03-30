package fr.eql.ai113.petpal.spring.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Owner implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @JsonIgnore
    @Column(unique = true)
    private String login;
    @JsonIgnore
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pet> pets = new ArrayList<>();
    @JsonIgnore
    @ElementCollection(targetClass = PetCategory.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "owner_favorite_pet_category")
    @Column(name = "favorite_pet_category")
    private List<PetCategory> favoritePetCategories = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
    @Override
    public String getUsername() {
        return login;
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

    public Owner() {
    }

    public Owner(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /// Getters ///
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public List<Pet> getPets() {
        return pets;
    }
    public List<PetCategory> getFavoritePetCategories() {
        return favoritePetCategories;
    }

    /// Setters ///
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
