package fr.eql.ai113.petpal.spring.back.entity.dto;

import fr.eql.ai113.petpal.spring.back.entity.CatBreed;

import java.time.LocalDate;

public class CatDto {

    private String name;
    private LocalDate birthdate;
    private String picture;
    private CatBreed breed;
    private long ownerId;

    /// Getters ///
    public String getName() {
        return name;
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public String getPicture() {
        return picture;
    }
    public CatBreed getBreed() {
        return breed;
    }
    public long getOwnerId() {
        return ownerId;
    }
}
