package com.marketplace.backend.repositories;

import com.marketplace.backend.domain.entities.Faculty;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface iFacultyRepository extends iGenericRepository<Faculty, UUID> {

    @Query("SELECT f FROM Faculty f")
    List<Faculty> findAllFaculty();

    Faculty findFacultyByFacultyName(String name);
}
