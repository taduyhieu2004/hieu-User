package com.example.xyzt.dao.impl;

import com.example.xyzt.dao.DataSource;
import com.example.xyzt.dao.UserDAO;
import com.example.xyzt.data.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.xyzt.constans.SQLContains.UserSQL.*;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getListUser() {
        List<User> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(GET_ALL_USER);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("fullname");
                String userName = rs.getString("username");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phonenumber");
                User user = new User(id, fullName, userName, email, phoneNumber);
                list.add(user);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }


    @Override
    public void insertUser(String fullName, String userName, String email, String phoneNumber) {
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement(INSERT_USER);
            pst.setString(1, fullName);
            pst.setString(2, userName);
            pst.setString(3, email);
            pst.setString(4, phoneNumber);
            int row = pst.executeUpdate();
            connection.commit();
            System.out.println("Row affected: " + row);

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    @Override
    public void updateUser(String fullName, String userName, String email, String phoneNumber, int id) {
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            PreparedStatement pvt = connection.prepareStatement(UPDATE_USER);
            pvt.setString(1, fullName);
            pvt.setString(2, userName);
            pvt.setString(3, email);
            pvt.setString(4, phoneNumber);
            pvt.setInt(5, id);
            int row = pvt.executeUpdate();
            connection.commit();
            System.out.println("Row affected: " + row);

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    @Override
    public void deleteUser(int id) {
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement(DELETE_USER);
            pst.setInt(1, id);
            int row = pst.executeUpdate();
            connection.commit();
            System.out.println("Row affected: " + row);

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}

