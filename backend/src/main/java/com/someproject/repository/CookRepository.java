package com.someproject.repository;

import com.someproject.model.kitchen.Cook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookRepository extends JpaRepository<Cook,Long>{
}