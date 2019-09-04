/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.NotasDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dany
 */
public class NotasDao {
    
    final String SELECTALL = "SELECT * FROM notes";
    final String CREATE = "INSERT INTO notes (name, text) VALUES (?,?)";
    
    public int create(NotasDto u) {
        int rs = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlConnection.open();
            ps = conn.prepareStatement(this.CREATE);
            ps.setString(1, u.getName());
            ps.setString(2, u.getText());
            rs = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error SQL" + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error Closing" + ex.getMessage());
            }
        }
        return rs;
    }
   
    public List<NotasDto> getAll() {
        List<NotasDto> lu = new ArrayList<>();
        Connection conn = null;
        Statement ps = null;
        try {
            conn = MysqlConnection.open();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(this.SELECTALL);
            while (rs.next()) {
                NotasDto u = new NotasDto();
                 u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setDate(rs.getString("date"));
                u.setText(rs.getString("text"));
                lu.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL" + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error Closing" + ex.getMessage());
            }
        }
        return lu;
    }
    
}
