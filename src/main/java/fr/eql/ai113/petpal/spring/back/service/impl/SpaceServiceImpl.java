package fr.eql.ai113.petpal.spring.back.service.impl;

import fr.eql.ai113.petpal.spring.back.entity.Cat;
import fr.eql.ai113.petpal.spring.back.entity.Owner;
import fr.eql.ai113.petpal.spring.back.entity.dto.CatDto;
import fr.eql.ai113.petpal.spring.back.repository.CatDao;
import fr.eql.ai113.petpal.spring.back.repository.OwnerDao;
import fr.eql.ai113.petpal.spring.back.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceServiceImpl implements SpaceService {

    /** Injecté par le setter */
    private CatDao catDao;
    /** Injecté par le setter */
    private OwnerDao ownerDao;

    @Override
    public List<Cat> findOwnerCats(long id) {
        return catDao.findByOwnerId(id);
    }

    @Override
    public Cat saveCat(CatDto catDto) {
        Owner owner = ownerDao.findById(catDto.getOwnerId());
        Cat cat = new Cat(
                catDto.getName(),
                catDto.getBirthdate(),
                catDto.getPicture(),
                owner,
                catDto.getBreed()
        );
        return catDao.save(cat);
    }

    /// Setters ///
    @Autowired
    public void setCatDao(CatDao catDao) {
        this.catDao = catDao;
    }
    @Autowired
    public void setOwnerDao(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }
}
