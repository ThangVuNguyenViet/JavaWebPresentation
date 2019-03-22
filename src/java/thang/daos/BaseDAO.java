/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Thang
 */
public class BaseDAO {
    protected Connection conn;
    protected PreparedStatement preStm;
    protected ResultSet rs;

    protected void closeConnection() throws Exception {
        if (conn != null) {
            conn.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (rs != null) {
            rs.close();
        }
    }
}
