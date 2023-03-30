package fr.eql.ai113.petpal.spring.back.service;

import fr.eql.ai113.petpal.spring.back.entity.Cat;
import fr.eql.ai113.petpal.spring.back.entity.dto.CatDto;

import java.util.List;

public interface SpaceService {

    List<Cat> findOwnerCats(long id);
    Cat saveCat(CatDto catDto);
}
