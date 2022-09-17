package com.SpringSecurity.mention;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MentionRepository extends JpaRepository<Mention,Integer>{

}
