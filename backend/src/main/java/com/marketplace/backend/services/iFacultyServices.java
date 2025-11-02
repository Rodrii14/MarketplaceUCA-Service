package com.marketplace.backend.services;

import com.marketplace.backend.domain.dto.faculty.CreateFacultyDto;
import com.marketplace.backend.domain.dto.faculty.ResponseFacultyDto;
import com.marketplace.backend.domain.dto.faculty.UpdateFacultyDto;

import java.util.List;

public interface iFacultyServices {

    void createFaculty(CreateFacultyDto faculty);
    ResponseFacultyDto updateFacultyByName(UpdateFacultyDto faculty);
    ResponseFacultyDto getFacultyByName(String facultyName);
    List<ResponseFacultyDto> getAllFaculties();
}
