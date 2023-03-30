package fr.eql.ai113.petpal.spring.back.controller.rest;

import fr.eql.ai113.petpal.spring.back.entity.Cat;
import fr.eql.ai113.petpal.spring.back.entity.dto.CatDto;
import fr.eql.ai113.petpal.spring.back.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("space")
@CrossOrigin(origins = "${front.url}")
public class SpaceRestController {

    /** Injecté par le setter */
    SpaceService spaceService;

    @GetMapping("/owners/{id}/cats")
    public List<Cat> findOwnerCats(@PathVariable long id) {
        return spaceService.findOwnerCats(id);
    }

    @PostMapping("/cat")
    public Cat saveCat(@RequestBody CatDto catDto) {
        return spaceService.saveCat(catDto);
    }

    /// Setters ///
    @Autowired
    public void setSpaceService(SpaceService spaceService) {
        this.spaceService = spaceService;
    }
}
