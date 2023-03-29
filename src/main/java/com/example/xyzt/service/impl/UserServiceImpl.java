package com.example.xyzt.service.impl;

import com.example.xyzt.constans.ErrorMessageConstans;
import com.example.xyzt.dao.UserDAO;
import com.example.xyzt.dao.impl.UserDAOImpl;
import com.example.xyzt.data.dto.request.UserRequestDTO;
import com.example.xyzt.data.dto.response.UserResponseDTO;
import com.example.xyzt.data.entity.User;
import com.example.xyzt.exception.WrongFormatException;
import com.example.xyzt.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO = new UserDAOImpl();
    public static List<UserResponseDTO> list = new ArrayList<>();

    @Override
    public void insert(UserRequestDTO userRequestDTO) {
        userDAO.insertUser(userRequestDTO.getFullName(), userRequestDTO.getUserName(),
                userRequestDTO.getEmail(), userRequestDTO.getPhoneNumber());

    }


    @Override
    public UserRequestDTO update(UserRequestDTO userRequestDTO, int id) {
        userDAO.updateUser(userRequestDTO.getFullName(), userRequestDTO.getUserName(),
                userRequestDTO.getEmail(), userRequestDTO.getPhoneNumber(), id);
        return userRequestDTO;
    }


    @Override
    public List<UserResponseDTO> getAll() {
        List<User> userList = userDAO.getListUser();
        for (int i = 0; i < userList.size(); i++) {
            UserResponseDTO userResponseDTO = new UserResponseDTO(userList.get(i));
            list.add(userResponseDTO);

        }
        return list;
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}


//    private static Pattern pattern;
//    private static Matcher matcher;
//    private static String REGEX_EMAIL = "^[a-zA-Z]+[a-z0-9]*@{1}[A-Za-z]{1}+mail.com$";
//    private static String REGEX_PHONE_NUMBER = "^0\\d{9}$";
//    private static String REGEX_USERNAME = "^[\\S]+$";


//        Boolean checkEmail = checkEmail(userRequestDTO.getEmail());
//        Boolean checkPhoneNumber = checkPhoneNumber(userRequestDTO.getPhoneNumber());
//        Boolean checkUserName =checkUsername(userRequestDTO.getUserName());
////        if (checkEmail == false) {
////            throw new WrongFormatException(ErrorMessageConstans.WRONG_EMAIL);
////        } else if (checkPhoneNumber == false) {
////            throw new WrongFormatException(ErrorMessageConstans.WRONG_PHONE_NUMBER);
////
////        } else if (checkUserName==false) {
////            throw new WrongFormatException(ErrorMessageConstans.WRONG_USERNAME);
////
////        } else {


//        Boolean checkEmail = checkEmail(userRequestDTO.getEmail());
//        Boolean checkPhoneNumber = checkPhoneNumber(userRequestDTO.getPhoneNumber());
//        Boolean checkUserName = checkUsername(userRequestDTO.getUserName());
//        if (checkEmail == false) {
//            throw new WrongFormatException(ErrorMessageConstans.WRONG_EMAIL);
//        } else if (checkPhoneNumber == false) {
//            throw new WrongFormatException(ErrorMessageConstans.WRONG_PHONE_NUMBER);
//
//        } else if (checkUserName == false) {
//            throw new WrongFormatException(ErrorMessageConstans.WRONG_USERNAME);
//        } else {


//    private static Boolean checkEmail(String check) {
//        pattern = Pattern.compile(REGEX_EMAIL);
//        matcher = pattern.matcher(check);
//        if (matcher.find()) {
//            return true;
//        }
//        return false;
//    }
//
//    private static Boolean checkPhoneNumber(String check) {
//        pattern = Pattern.compile(REGEX_PHONE_NUMBER);
//        matcher = pattern.matcher(check);
//        if (matcher.find()) {
//            return true;
//        }
//        return false;
//    }
//
//    private static Boolean checkUsername(String check) {
//        pattern = Pattern.compile(REGEX_USERNAME);
//        matcher = pattern.matcher(check);
//        if (matcher.find()) {
//            return true;
//        }
//        return false;
//    }
//}
