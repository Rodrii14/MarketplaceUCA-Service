package com.marketplace.backend.utils.mappers;

import com.marketplace.backend.domain.dto.user.ResponseUserDto;
import com.marketplace.backend.domain.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMappers {

    public ResponseUserDto castUserData(User user) {
        ResponseUserDto response = new ResponseUserDto();

        response.setName(user.getName());
        response.setEmail(user.getUsername());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setFacultyName(user.getFaculty().getFacultyName());
        response.setRating(user.getRating());
        response.setRole(user.getRole());

        return response;
    }

    public List<ResponseUserDto> getCastedUserList(List<User> user) {
        List<ResponseUserDto> responseUserList = new ArrayList<>();

        if (!user.isEmpty()) {
            for (User us : user) {
                responseUserList.add(castUserData(us));
            }

        }

        return responseUserList;
    }
}
