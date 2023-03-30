package fr.eql.ai113.petpal.spring.back.repository;

import fr.eql.ai113.petpal.spring.back.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerDao extends JpaRepository<Owner, Long> {

    Owner findByLoginAndPassword(String login, String password);
    List<Owner> findAllByIdNot(long id);
    Owner findById(long id);
    Owner findByLogin(String login);
}
