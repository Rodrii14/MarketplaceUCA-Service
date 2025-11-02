package com.marketplace.backend.services.impl;

import com.marketplace.backend.domain.dto.faculty.CreateFacultyDto;
import com.marketplace.backend.domain.dto.faculty.ResponseFacultyDto;
import com.marketplace.backend.domain.dto.faculty.UpdateFacultyDto;
import com.marketplace.backend.domain.entities.Faculty;
import com.marketplace.backend.exceptions.faculty.FacultyNotFound;
import com.marketplace.backend.repositories.iFacultyRepository;
import com.marketplace.backend.services.iFacultyServices;
import com.marketplace.backend.utils.mappers.FacultyMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyServicesImpl implements iFacultyServices {

    private final iFacultyRepository facultyRepository;
    private final FacultyMappers mappers;

    @Override
    public void createFaculty(CreateFacultyDto facultyDto) {
        Faculty faculty = new Faculty();
        faculty.setFacultyName(facultyDto.getFacultyName());

        facultyRepository.save(faculty);
    }

    @Override
    public ResponseFacultyDto updateFacultyByName(UpdateFacultyDto faculty) {
        Faculty facultyToUpdate = facultyRepository.findFacultyByFacultyName(faculty.getFacultyName());

        if(facultyToUpdate == null){
            throw new FacultyNotFound();
        }

        facultyToUpdate.setFacultyName(faculty.getNewFacultyName());
        facultyRepository.save(facultyToUpdate);
        return mappers.castFacultyData(facultyToUpdate);
    }

    @Override
    public ResponseFacultyDto getFacultyByName(String facultyName) {
        Faculty faculty = facultyRepository.findFacultyByFacultyName(facultyName);

        if(faculty == null){
            throw new FacultyNotFound();
        }

        return mappers.castFacultyData(faculty);
    }

    @Override
    public List<ResponseFacultyDto> getAllFaculties() {
        List<Faculty> faculties = facultyRepository.findAllFaculty();

        return mappers.castFacultyDataList(faculties);
    }
}
