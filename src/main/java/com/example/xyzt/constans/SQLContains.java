package com.example.xyzt.constans;

public class SQLContains {
    public static class UserSQL {
        public static String GET_ALL_USER = "SELECT*FROM employee.user";
        public static String INSERT_USER = "INSERT INTO employee.user (fullname,username,email,phonenumber) VALUES (?,?,?,?) ";
        public static String UPDATE_USER = "UPDATE employee.user" +
                " SET " +
                " fullname =? " +
                " ,username = ?" +
                " , email= ?" +
                ", phonenumber=?" +

                "  WHERE ID =?";
        public static String DELETE_USER =" DELETE FROM employee.user WHERE ID= ?";

    }
}
