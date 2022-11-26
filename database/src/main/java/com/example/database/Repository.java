package com.example.database;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Repository extends JpaRepository<Model, Long> {
    @Query(value = "select * from productos p where p.name like %:name%", nativeQuery = true)
    ArrayList<Model> findAllByTitleContaining(@Param("name") String query);
}
