/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ThangVo
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {

    Connection con;

    public UserDatabase(Connection con) {
        this.con = con;
    }

    //for register user 
    public boolean saveUser(Users user) {
        boolean set = false;
        try {
            //Insert register data to database
            String query = "insert into Registration values(?,?,?,?,?)";

            PreparedStatement pt = this.con.prepareStatement(query);
               pt.setString(1,null);
            pt.setString(2, user.getName());

            pt.setString(3, user.getLastname());
            pt.setString(4, user.getPassword());
            pt.setBoolean(5, user.isRoles());

            pt.executeUpdate();
            set = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    public Users login(String email, String pass) {
        Users usr = null;
        try {
            String query = "select * from Registration where username=? and password=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usr = new Users();

                usr.setName(rs.getString("username"));

                usr.setPassword(rs.getString("password"));
                usr.setRoles(rs.getBoolean("roles"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usr;
    }

    public ArrayList<Users> nvList(String name) {
        ArrayList<Users> nvList = new ArrayList<>();

        try {

            String sql = "Select *from Registration where username Like ?";
            PreparedStatement stm = this.con.prepareStatement(sql);
            stm.setString(1, "%" + name + "%");

            ResultSet rs = stm.executeQuery();
            Users em;
            while (rs.next()) {
                em = new Users(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("lastname"),
                        rs.getBoolean("roles")
                );
                nvList.add(em);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nvList;
    }

    public boolean deleteRecord(String username) {
        boolean result = false;

        try {

            String sql = "Delete from Registration where username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);

            int rs = stm.executeUpdate();
            stm.close();
            con.close();
            if (rs > 0) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
      public boolean updateRecord(String username, String lastname, boolean roles) {
        try {
            
            String sql = "Update Registration set lastname=? , roles=? where username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            
            stm.setString(1, lastname);
            
            stm.setBoolean(2, roles);
            stm.setString(3, username);
             int rs = stm.executeUpdate();
           
            stm.close();
            con.close();
            if (rs>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
