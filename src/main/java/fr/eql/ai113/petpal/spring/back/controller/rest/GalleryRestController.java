package fr.eql.ai113.petpal.spring.back.controller.rest;

import fr.eql.ai113.petpal.spring.back.entity.Cat;
import fr.eql.ai113.petpal.spring.back.entity.Owner;
import fr.eql.ai113.petpal.spring.back.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gallery")
@CrossOrigin(origins = "${front.url}")
public class GalleryRestController {

    /** Injecté par le setter */
    GalleryService galleryService;

    @GetMapping("/owners/exclude/{id}")
    public List<Owner> findAllOwnersButSelf(@PathVariable long id) {
        return galleryService.findAllOwnersButSelf(id);
    }

    @GetMapping("/owners/{id}/cats")
    public List<Cat> findOwnerCats(@PathVariable long id) {
        return galleryService.findOwnerCats(id);
    }

    /// Setters ///
    @Autowired
    public void setGalleryService(GalleryService galleryService) {
        this.galleryService = galleryService;
    }
}
