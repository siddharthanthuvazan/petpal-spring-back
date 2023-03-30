package fr.eql.ai113.petpal.spring.back.service.impl;

import fr.eql.ai113.petpal.spring.back.entity.Cat;
import fr.eql.ai113.petpal.spring.back.entity.Owner;
import fr.eql.ai113.petpal.spring.back.repository.CatDao;
import fr.eql.ai113.petpal.spring.back.repository.OwnerDao;
import fr.eql.ai113.petpal.spring.back.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService {

    /** Injecté par le setter */
    private OwnerDao ownerDao;
    /** Injecté par le setter */
    private CatDao catDao;

    @Override
    public List<Owner> findAllOwnersButSelf(long id) {
        return ownerDao.findAllByIdNot(id);
    }

    @Override
    public List<Cat> findOwnerCats(long id) {
        return catDao.findByOwnerId(id);
    }

    /// Setters ///
    @Autowired
    public void setOwnerDao(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }
    @Autowired
    public void setCatDao(CatDao catDao) {
        this.catDao = catDao;
    }
}
