package com.example.xyzt.controller;

import com.example.xyzt.data.dto.request.UserRequestDTO;
import com.example.xyzt.data.dto.response.UserResponseDTO;
import com.example.xyzt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping()
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> insertUser(@Validated @RequestBody UserRequestDTO userRequestDTO) {
        userService.insert(userRequestDTO);
        return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.OK);

    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateUser(@RequestBody @Validated UserRequestDTO userRequestDTO, @PathVariable int id) {
        return new ResponseEntity<>(userService.update(userRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpEntity.EMPTY, HttpStatus.OK);
    }


}
