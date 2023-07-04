/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtil.DBContext;
import DTO.RatingDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phamt
 */
public class RatingDAO {
    
    public RatingDTO getRatingRecipe(int recipeID, int userID) throws SQLException {
        RatingDTO rating = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from Rating a join Recipe b"
                + " on a.recipeID = b.recipeID "
                + "join [User] c on b.userID = c.userID "
                + "where a.recipeID = ? and a.userID = ?");
        stm.setInt(1, recipeID);
        stm.setInt(2, userID);
        ResultSet rs = stm.executeQuery();
        while(rs.next()) {
            rating = new RatingDTO();
            rating.setRateID(rs.getInt("rateID"));
            rating.setUserID(rs.getInt("userID"));
            rating.setRecipeID(rs.getInt("recipeID"));
            rating.setScoreUser(rs.getInt("scoreUser"));
        }
        con.close();
        return rating;
    }

    public void ratingRecipe(RatingDTO rating) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("insert Rating values(?, ?, ?)");
        stm.setInt(1, rating.getUserID());
        stm.setInt(2, rating.getRecipeID());
        stm.setInt(3, rating.getScoreUser());
        int count = stm.executeUpdate();
        con.close();
    }

    public RatingDTO getOne(int rateID) throws SQLException {
        RatingDTO rating = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from Rating where rateID = ?");
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            rating = new RatingDTO();
            rating.setRateID(rs.getInt("rateID"));
            rating.setUserID(rs.getInt("userID"));
            rating.setRecipeID(rs.getInt("recipeID"));
            rating.setRateID(rs.getInt("scoreUser"));
        }
        con.close();
        return rating;
    }
    
    public RatingDTO checkReRating(int userID, int recipeID) throws SQLException {
        RatingDTO rating = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from Rating where userID = ? and recipeID = ?");
        stm.setInt(1, userID);
        stm.setInt(2,recipeID);
        ResultSet rs = stm.executeQuery();
        while(rs.next()) {
            rating = new RatingDTO();
            rating.setRateID(rs.getInt("rateID"));
            rating.setUserID(rs.getInt("userID"));
            rating.setRecipeID(rs.getInt("recipeID"));
            rating.setRateID(rs.getInt("scoreUser"));
        }
        con.close();
        return rating;
    }
    
    public void reRating(RatingDTO rating) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("update Rating set scoreUser = ? where userID = ? and recipeID = ?");
        stm.setInt(1, rating.getScoreUser());
        stm.setInt(2, rating.getUserID());
        stm.setInt(3, rating.getRecipeID());
        int count = stm.executeUpdate();
        con.close();
    }
    
    public int totalRating(int recipeID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select count(*) from Rating where recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        while(rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
    
    public int totalScoreRecipe(int recipeID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select SUM(scoreUser) from Rating where recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        while(rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
    
    public int totalUserScoreRecipe(int recipeID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select count(userID) from Rating where recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        while(rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
