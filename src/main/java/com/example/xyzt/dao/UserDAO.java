package com.example.xyzt.dao;

import com.example.xyzt.data.dto.response.UserResponseDTO;
import com.example.xyzt.data.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getListUser();

    void insertUser(String fullName, String userName, String email, String phoneNumber);

    void updateUser(String fullName, String userName, String email, String phoneNumber, int id);
    void deleteUser(int id);
}
