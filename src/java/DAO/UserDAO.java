/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtil.DBContext;
import DTO.UserDTO;
import hash.Hasher;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author phamt
 */


public class UserDAO {

    public int getAllAcc() throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select count(*) from [User]");
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public List<UserDTO> pageIndex(int index) throws SQLException {
        List<UserDTO> list = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from [User] order by userID offset ? rows fetch next 8 rows only");
        stm.setInt(1, (index - 1) * 8);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            UserDTO user = new UserDTO();
            user.setUserID(rs.getInt("userID"));
            user.setUserName(rs.getString("userName"));
            user.setImageUser(rs.getString("imageUser"));
            user.setGender(rs.getBoolean("gender"));
            user.setDob(rs.getDate("dob"));
            user.setPhone(rs.getString("phone"));
            user.setGmail(rs.getString("gmail"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setStatus(rs.getBoolean("status"));
            list.add(user);
        }
        con.close();
        return list;
    }

    public UserDTO getOne(int userID) throws SQLException {
        UserDTO user = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from [User] where userID = ?");
        stm.setInt(1, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            user = new UserDTO();
            user.setUserID(rs.getInt("userID"));
            user.setUserName(rs.getString("userName"));
            user.setImageUser(rs.getString("imageUser"));
            user.setDob(rs.getDate("dob"));
            user.setGender(rs.getBoolean("gender"));
            user.setPhone(rs.getString("phone"));
            user.setGmail(rs.getString("gmail"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setStatus(rs.getBoolean("status"));
        }
        con.close();
        return user;
    }

    public List<UserDTO> selectAll() throws SQLException {
        List<UserDTO> list = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from [User]");
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            UserDTO user = new UserDTO();
            user.setUserID(rs.getInt("userID"));
            user.setUserName(rs.getString("userName"));
            user.setImageUser(rs.getString("imageUser"));
            user.setDob(rs.getDate("dob"));
            user.setGender(rs.getBoolean("gender"));
            user.setPhone(rs.getString("phone"));
            user.setGmail(rs.getString("gmail"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setStatus(rs.getBoolean("status"));
            list.add(user);
        }
        con.close();
        return list;
    }

    public UserDTO login(String gmail, String password) throws SQLException, NoSuchAlgorithmException {
        UserDTO user = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from [User] where gmail = ? and [password] = ?");
        stm.setString(1, gmail);
        stm.setString(2, Hasher.hash(password));
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            user = new UserDTO();
            user.setUserID(rs.getInt("userID"));
            user.setUserName(rs.getString("userName"));
            user.setImageUser(rs.getString("imageUser"));
            user.setDob(rs.getDate("dob"));
            user.setGender(rs.getBoolean("gender"));
            user.setPhone(rs.getString("phone"));
            user.setGmail(rs.getString("gmail"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setStatus(rs.getBoolean("status"));
        }
        con.close();
        return user;
    }

    public UserDTO signUp(String gmail, String password) throws SQLException, NoSuchAlgorithmException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("insert into [User](gmail, [password], [role], [status]) values(?, ?, 'USER', 1)");
        stm.setString(1, gmail);
        stm.setString(2, Hasher.hash(password));
        stm.executeUpdate();
        con.close();
        return null;
    }

    public UserDTO checkGmail(String gmail) throws SQLException {
        UserDTO user = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from [User] where gmail = ?");
        stm.setString(1, gmail);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            user = new UserDTO();
            user.setUserID(rs.getInt("userID"));
            user.setUserName(rs.getString("userName"));
            user.setImageUser(rs.getString("imageUser"));
            user.setDob(rs.getDate("dob"));
            user.setGender(rs.getBoolean("gender"));
            user.setPhone(rs.getString("phone"));
            user.setGmail(rs.getString("gmail"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setStatus(rs.getBoolean("status"));
        }
        con.close();
        return user;
    }

    public UserDTO checkInf(int userID) throws SQLException {
        UserDTO user = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from [User] where userID = ?");
        stm.setInt(1, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            user = new UserDTO();
            user.setUserID(rs.getInt("userID"));
            user.setUserName(rs.getString("userName"));
            user.setImageUser(rs.getString("imageUser"));
            user.setDob(rs.getDate("dob"));
            user.setGender(rs.getBoolean("gender"));
            user.setPhone(rs.getString("phone"));
            user.setGmail(rs.getString("gmail"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setStatus(rs.getBoolean("status"));
        }
        con.close();
        return user;
    }

    public void update(String userName, String imageUser, Date dob, boolean gender, String phone, int userID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("update [User] set  userName = ?, "
                + "imageUser = ?, dob = ?, gender = ?, phone = ? where userID = ?");
        stm.setString(1, userName);
        stm.setString(2, imageUser);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(dob));
        stm.setBoolean(4, gender);
        stm.setString(5, phone);
        stm.setInt(6, userID);
        int count = stm.executeUpdate();
        con.close();
    }

//    public void updateUser(UserDTO user) throws SQLException {
//        Connection con = DBContext.makeConnection();
//        PreparedStatement stm = con.prepareStatement("update [User] set userName = ?, firstName = ?, "
//                + "lastName = ?, dob = ?, gender = ?, phone = ? where userID = ?");
//        stm.setString(1, user.getUserName());
//        stm.setString(2, user.getFirstName());
//        stm.setString(3, user.getLastName());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        stm.setString(4, sdf.format(user.getDob()));
//        stm.setBoolean(5, user.isGender());
//        stm.setString(6, user.getPhone());
//        stm.setInt(7, user.getUserID());
//        int count = stm.executeUpdate();
//        con.close();
//    }
    public void updateByAdmin(String userName, String imageUser, Date dob, boolean gender,
            String phone, String gmail, String password, String role, int userID)
            throws SQLException, NoSuchAlgorithmException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("update [User] set userName = ?, imageUser = ?,"
                + "dob = ?, gender = ?, phone = ?, gmail = ?, password = ?, role = ? where userID = ?");
        stm.setString(1, userName);
        stm.setString(2, imageUser);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(dob));
        stm.setBoolean(4, gender);
        stm.setString(5, phone);
        stm.setString(6, gmail);
        stm.setString(7, Hasher.hash(password));
        stm.setString(8, role);
        stm.setInt(9, userID);
        int count = stm.executeUpdate();
        con.close();
    }

    public UserDTO checkPass(String password, int userID) throws SQLException, NoSuchAlgorithmException {
        UserDTO user = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from [User] where [password] = ? and userID = ?");
        stm.setString(1, Hasher.hash(password));
        stm.setInt(2, userID);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            user = new UserDTO();
            user.setUserID(rs.getInt("userID"));
            user.setUserName(rs.getString("userName"));
            user.setImageUser(rs.getString("imageUser"));
            user.setDob(rs.getDate("dob"));
            user.setGender(rs.getBoolean("gender"));
            user.setPhone(rs.getString("phone"));
            user.setGmail(rs.getString("gmail"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setStatus(rs.getBoolean("status"));
        }
        con.close();
        return user;
    }

    public UserDTO changePass(String password, int userID) throws SQLException, NoSuchAlgorithmException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("update [User] set [password] = ? where userID = ?");
        stm.setString(1, Hasher.hash(password));
        stm.setInt(2, userID);
        int count = stm.executeUpdate();
        return null;
    }

    public UserDTO resetPass(String password, String gmail) throws SQLException, NoSuchAlgorithmException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("update [User] set [password] = ? where gmail = ?");
        stm.setString(1, Hasher.hash(password));
        stm.setString(2, gmail);
        int count = stm.executeUpdate();
        return null;
    }

    //XEM LAI, DELETE DINH FOREIN_KEY
    public void remove(int userID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("delete [User] where userID = ?");
        stm.setInt(1, userID);
        int count = stm.executeUpdate();
        con.close();
    }
}
