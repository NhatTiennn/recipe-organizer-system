/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtil.DBContext;
import DTO.FeedbackDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phamt
 */
public class FeedbackDAO {

    public List<FeedbackDTO> getAllFeedback() throws SQLException {
        List<FeedbackDTO> list = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from FeedBack a "
                + "join Recipe b on a.recipeID = b.recipeID "
                + "join [User] c on b.userID = c.userID "
                + "where a.[status] = 0");

        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            FeedbackDTO feedback = new FeedbackDTO();
            feedback.setFeedBackID(rs.getInt("feedBackID"));
            feedback.setContent(rs.getString("content"));
            feedback.setUserID(rs.getInt("userID"));
            feedback.setUserName(rs.getString("userName"));
            feedback.setFeedBackDate(rs.getDate("feedbackDate"));
            feedback.setRecipeID(rs.getInt("recipeID"));
            feedback.setStatus(rs.getBoolean("status"));
            list.add(feedback);
        }
        con.close();
        return list;
    }

    public List<FeedbackDTO> getComments(int recipeID) throws SQLException {
        List<FeedbackDTO> list = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from FeedBack a "
                + "join Recipe b on a.recipeID = b.recipeID "
                + "join [User] c on b.userID = c.userID "
                + "where a.recipeID = ? and a.[status] = 1");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            FeedbackDTO feedback = new FeedbackDTO();
            feedback.setFeedBackID(rs.getInt("feedBackID"));
            feedback.setContent(rs.getString("content"));
            feedback.setUserID(rs.getInt("userID"));
            feedback.setUserName(rs.getString("userName"));
            feedback.setFeedBackDate(rs.getDate("feedbackDate"));
            feedback.setRecipeID(rs.getInt("recipeID"));
            feedback.setStatus(rs.getBoolean("status"));
            list.add(feedback);
        }
        con.close();
        return list;
    }

    public FeedbackDTO getOne(int feedBackID) throws SQLException {
        FeedbackDTO feedback = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from [FeedBack] where feedBackID = ?");
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            feedback = new FeedbackDTO();
            feedback.setFeedBackID(rs.getInt("feedBackID"));
            feedback.setContent(rs.getString("content"));
            feedback.setUserID(rs.getInt("userID"));
            feedback.setFeedBackDate(rs.getDate("feedbackDate"));
            feedback.setRecipeID(rs.getInt("recipeID"));
            feedback.setStatus(rs.getBoolean("status"));
        }
        con.close();
        return feedback;
    }
    
    public void addComments(FeedbackDTO fb) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("insert [FeedBack] values(?, ?, ?, ?, 0)");
        stm.setString(1, fb.getContent());
        stm.setInt(2, fb.getRecipeID());
        stm.setInt(3, fb.getUserID());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(4, sdf.format(fb.getFeedBackDate()));
        stm.executeUpdate();
        con.close();
    }
    
    public void removeCmts(int feedBackID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("delete [FeedBack] where feedBackID = ?");
        stm.setInt(1, feedBackID);
        int count = stm.executeUpdate();
        con.close();
    }

    public int getTotalComments() throws SQLException {
        int result = 0;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select count(feedBackID) as totalC from [feedBack]");
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            result += rs.getInt("totalC");
        }
        return result;
    }
    
    public void addCommentsFAdmin(int feedBackID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("update feedBack set [status] = 1 where feedBackID = ?");
        stm.setInt(1, feedBackID);
        int count = stm.executeUpdate();
        con.close();
    }
}
