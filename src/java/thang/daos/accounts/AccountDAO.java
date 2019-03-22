/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.daos.accounts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import thang.connection.MyConnection;
import thang.daos.BaseDAO;
import thang.dtos.accounts.AccountDTO;

/**
 *
 * @author Thang
 */
public class AccountDAO extends BaseDAO implements Serializable {

    public int checkLogin(String username, String password) throws Exception {
        int roleId = 0;
        String sql = "SELECT roleId from Account where username = ? and password = ? And isDelete = 0";
        try {
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                roleId = rs.getInt("roleId");
            }
        } finally {
            closeConnection();
        }
        return roleId;
    }

    public boolean register(AccountDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "INSERT into Account(username, password, roleId, isDelete) values(?,?,?,0)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setInt(3, dto.getRoleId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<AccountDTO> findByLikeUsername (String search) throws Exception{
        List<AccountDTO> result = new ArrayList<>();
        String username;
        int roleId;
        AccountDTO dto;
        try {
            String sql = "Select username, roleId From Account "
                    + "Where username LIKE ? And isDelete = 0";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                username = rs.getString("username");
                roleId = rs.getInt("roleId");
                dto = new AccountDTO(username, roleId);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean delete(String username) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Account set isDelete = 1 Where username = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<String> getAllUsername() throws Exception {
        List<String> result = new ArrayList();
        try {
            String sql = "Select username from Account Where isDelete = 0 And roleId = 2";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("username"));
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean changePassword(String username, String password) throws Exception {
        boolean check = false;
        String sql = "Update Account Set password = ? Where username = ?";
        try {
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, password);
            preStm.setString(2, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
