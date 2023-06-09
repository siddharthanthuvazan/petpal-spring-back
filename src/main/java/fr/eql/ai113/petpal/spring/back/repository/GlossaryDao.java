package fr.eql.ai113.petpal.spring.back.repository;

import fr.eql.ai113.petpal.spring.back.entity.Glossary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GlossaryDao extends JpaRepository<Glossary, Long> {

    @Query("SELECT g.expression FROM Glossary g")
    List<String> findAllExpressions();
}
