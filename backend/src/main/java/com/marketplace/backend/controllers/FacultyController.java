package com.marketplace.backend.controllers;

import com.marketplace.backend.domain.dto.faculty.CreateFacultyDto;
import com.marketplace.backend.domain.dto.GeneralResponse;
import com.marketplace.backend.domain.dto.faculty.ResponseFacultyDto;
import com.marketplace.backend.domain.dto.faculty.UpdateFacultyDto;
import com.marketplace.backend.services.iFacultyServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class FacultyController {

    private final iFacultyServices facultyServices;

    @PostMapping("/faculty/create")
    public ResponseEntity<GeneralResponse> createFaculty(@RequestBody CreateFacultyDto facultyDto) {
        facultyServices.createFaculty(facultyDto);

        return GeneralResponse.builder()
                .message("Faculty created successfully")
                .status(HttpStatus.CREATED)
                .build();
    }

    @PatchMapping("/faculty/update")
    public ResponseEntity<GeneralResponse> updateFaculty(@RequestBody UpdateFacultyDto facultyDto) {
        ResponseFacultyDto response = facultyServices.updateFacultyByName(facultyDto);

        return GeneralResponse.builder()
                .data(response)
                .message("Faculty updated successfully")
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/faculty/all")
    public ResponseEntity<GeneralResponse> getAllFaculties() {
        List<ResponseFacultyDto> resp = facultyServices.getAllFaculties();

        return GeneralResponse.builder()
                .data(resp)
                .message("ok")
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/faculty/name")
    public ResponseEntity<GeneralResponse> getFacultyByName(@RequestParam("name") String name) {
        ResponseFacultyDto response = facultyServices.getFacultyByName(name);

        return GeneralResponse.builder()
                .data(response)
                .message("ok")
                .status(HttpStatus.OK)
                .build();
    }
}
