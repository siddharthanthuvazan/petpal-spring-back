package fr.eql.ai113.petpal.spring.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "pet_type")
public abstract class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthdate;
    private String picture;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Owner owner;

    public Pet() {
    }

    public Pet(String name, LocalDate birthdate, String picture, Owner owner) {
        this.name = name;
        this.birthdate = birthdate;
        this.picture = picture;
        this.owner = owner;
    }

    /// Getters ///
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public String getPicture() {
        return picture;
    }
    public Owner getOwner() {
        return owner;
    }
}
