/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.daos.accounts;

import thang.daos.BaseDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import thang.connection.MyConnection;
import thang.dtos.accounts.UserDTO;

/**
 *
 * @author Thang
 */
public class UserDAO extends BaseDAO implements Serializable {
    public String findUserFullnameByUsername(String username) throws Exception {
        String fullname = null;
        String sql = "SELECT fullname from [User] where username = ?";
        try {
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                fullname = rs.getString("fullname");
            }
        } finally {
            closeConnection();
        }
        return fullname;
    }
    
    public boolean insert(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into [User](username, yob, fullname, gender, phone, email, address) "
                    + "values(?,?,?,?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setInt(2, dto.getYob());
            preStm.setString(3, dto.getFullname());
            preStm.setBoolean(4, dto.isGender());
            preStm.setString(5, dto.getPhone());
            preStm.setString(6, dto.getEmail());
            preStm.setString(7, dto.getAddress());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean update(UserDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update [User] set fullname = ?, yob = ?, gender = ?, phone = ?, email = ?, address = ? "
                    + "Where username = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getFullname());
            preStm.setInt(2, dto.getYob());
            preStm.setBoolean(3, dto.isGender());
            preStm.setString(4, dto.getPhone());
            preStm.setString(5, dto.getEmail());
            preStm.setString(6, dto.getAddress());
            preStm.setString(7, dto.getUsername());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public UserDTO findByUsername(String username) throws Exception {
        UserDTO dto = null;
        try {
            String sql = "SELECT fullname, yob, gender, email, phone, address From [User] "
                    + "Where username = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                boolean gender = rs.getBoolean("gender");
                int yob = rs.getInt("yob");
                dto = new UserDTO(username, fullname, phone, email, address, yob, gender);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean delete(String username) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete from [User] Where username = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean checkIfUserHasProfile(String username) throws Exception {
        boolean check = false;
        try {
            String sql = "Select username from [User] Where username = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            check = rs.next();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean addToCart(String username, int ticketId) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into Cart(username, ticketId) values(?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setInt(2, ticketId);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean removeCart(String username, int ticketId) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete Cart Where username = ? And ticketId = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setInt(2, ticketId);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<Integer> viewCart(String username) throws Exception {
        List<Integer> result = new ArrayList<>();
        try {
            String sql = "Select ticketId From Cart Where username = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(rs.getInt("ticketId"));
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
