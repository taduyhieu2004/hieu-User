package com.example.xyzt.service;

import com.example.xyzt.data.dto.request.UserRequestDTO;
import com.example.xyzt.data.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {
    void insert(UserRequestDTO userRequestDTO);

    UserRequestDTO update(UserRequestDTO userRequestDTO, int id);

    List<UserResponseDTO> getAll();
    void deleteUser(int id);
}
