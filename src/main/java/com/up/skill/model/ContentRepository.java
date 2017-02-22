package com.up.skill.model;

/**
 * Created by jejeTabadzki on 2/16/2017.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContentRepository extends JpaRepository<ContentForm, Long>{

    //ContentForm findOneByEmail(String email);

}