package fr.eql.ai113.petpal.spring.back.service;

import fr.eql.ai113.petpal.spring.back.entity.Cat;
import fr.eql.ai113.petpal.spring.back.entity.Owner;

import java.util.List;

public interface GalleryService {

    List<Owner> findAllOwnersButSelf(long id);
    List<Cat> findOwnerCats(long id);
}
