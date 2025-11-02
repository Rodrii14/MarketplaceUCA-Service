package com.marketplace.backend.utils.mappers;

import com.marketplace.backend.domain.dto.faculty.ResponseFacultyDto;
import com.marketplace.backend.domain.entities.Faculty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacultyMappers {

    public ResponseFacultyDto castFacultyData(Faculty faculty){
        ResponseFacultyDto responseFaculty = new ResponseFacultyDto();
        responseFaculty.setFacultyName(faculty.getFacultyName());

        return responseFaculty;
    }

    public List<ResponseFacultyDto> castFacultyDataList(List<Faculty> faculties){
        List<ResponseFacultyDto> responseFacultyList = new ArrayList<>();

        if(!faculties.isEmpty()){
            for (Faculty faculty : faculties) {
                responseFacultyList.add(castFacultyData(faculty));
            }
        }

        return responseFacultyList;
    }
}
