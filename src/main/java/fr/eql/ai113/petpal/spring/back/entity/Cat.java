package fr.eql.ai113.petpal.spring.back.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class Cat extends Pet {

    @Enumerated(EnumType.STRING)
    private CatBreed breed;

    public Cat() {
    }

    public Cat(String name, LocalDate birthdate, String picture, Owner owner, CatBreed breed) {
        super(name, birthdate, picture, owner);
        this.breed = breed;
    }

    /// Getters ///
    public CatBreed getBreed() {
        return breed;
    }
}
