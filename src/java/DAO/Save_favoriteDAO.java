/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtil.DBContext;
import DTO.FavoriteDTO;
import DTO.SaveDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phamt
 */
public class Save_favoriteDAO {

    public List<SaveDTO> getSaved(int userID) throws SQLException {
        List<SaveDTO> list = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from SavedRecipes a join [Recipe] b on a.recipeID = b.recipeID "
                + "join [User] c on b.userID = c.userID where a.userID = ?");
        stm.setInt(1, userID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            SaveDTO save = new SaveDTO();
            save.setSavedRecipeID(rs.getInt("savedRecipeID"));
            save.setRecipeID(rs.getInt("recipeID"));
            save.setImageRecipe(rs.getString("imageRecipe"));
            save.setRecipeName(rs.getString("recipeName"));
            save.setUserID(rs.getInt("userID"));
            list.add(save);
        }
        con.close();
        return list;
    }

    public SaveDTO getOneSaved(int recipeID, int userID) throws SQLException {
        SaveDTO save = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from SavedRecipes where recipeID = ? and userID = ?");
        stm.setInt(1, recipeID);
        stm.setInt(2, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            save = new SaveDTO();
            save.setSavedRecipeID(rs.getInt("savedRecipeID"));
            save.setRecipeID(rs.getInt("recipeID"));
            save.setUserID(rs.getInt("userID"));
        }
        con.close();
        return save;
    }

    public SaveDTO getSavedRecipeID(int recipeID) throws SQLException {
        SaveDTO save = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from SavedRecipes a join Recipe b "
                + "on a.recipeID = b.recipeID "
                + "join [User] c on b.userID = c.userID "
                + "where a.recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            save = new SaveDTO();
            save.setSavedRecipeID(rs.getInt("savedRecipeID"));
            save.setRecipeID(rs.getInt("recipeID"));
            save.setImageRecipe(rs.getString("imageRecipe"));
            save.setRecipeName(rs.getString("recipeName"));
            save.setUserID(rs.getInt("userID"));
        }
        con.close();
        return save;
    }

    public void addSavedByID(int recipeID, int userID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("insert SavedRecipes values(?,?)");
        stm.setInt(1, recipeID);
        stm.setInt(2, userID);
        stm.executeUpdate();
        con.close();
    }

    public void removeSavedRecipe(int userID,int recipeID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("delete SavedRecipes where userID= ? and recipeID = ?");
        stm.setInt(1, userID);
        stm.setInt(2, recipeID);
        stm.executeUpdate();
        con.close();
    }

    //===================================================================================================
    public List<FavoriteDTO> getFavorite(int userID) throws SQLException {
        List<FavoriteDTO> list = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from FavoriteRecipes a join [Recipe] b on a.recipeID = b.recipeID "
                + "join [User] c on b.userID = c.userID where a.userID = ?");
        stm.setInt(1, userID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            FavoriteDTO favorite = new FavoriteDTO();
            favorite.setFavoriteRecipeID(rs.getInt("favoriteRecipeID"));
            favorite.setRecipeID(rs.getInt("recipeID"));
            favorite.setImageRecipe(rs.getString("imageRecipe"));
            favorite.setRecipeName(rs.getString("recipeName"));
            favorite.setUserID(rs.getInt("userID"));
            list.add(favorite);
        }
        con.close();
        return list;
    }

    public FavoriteDTO getOneFavorite(int favoriteRecipeID) throws SQLException {
        FavoriteDTO favorite = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from FavoriteRecipes where favoritedRecipeID = ?");
        stm.setInt(1, favoriteRecipeID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            favorite = new FavoriteDTO();
            favorite.setFavoriteRecipeID(rs.getInt("favoriteRecipeID"));
            favorite.setRecipeID(rs.getInt("recipeID"));
            favorite.setImageRecipe(rs.getString("imageRecipe"));
            favorite.setRecipeName(rs.getString("recipeName"));
            favorite.setUserID(rs.getInt("userID"));
        }
        con.close();
        return favorite;
    }

    public FavoriteDTO getFavoriteRecipeID(int favoriteRecipeID) throws SQLException {
        FavoriteDTO favorite = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from FavoriteRecipes where favoriteRecipeID = ?");
        stm.setInt(1, favoriteRecipeID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            favorite = new FavoriteDTO();
            favorite.setFavoriteRecipeID(rs.getInt("favoriteRecipeID"));
            favorite.setRecipeID(rs.getInt("recipeID"));
            favorite.setImageRecipe(rs.getString("imageRecipe"));
            favorite.setRecipeName(rs.getString("recipeName"));
            favorite.setUserID(rs.getInt("userID"));
        }
        con.close();
        return favorite;
    }

    public void addFavoriteByID(int favoriteRecipeID, int userID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("insert FavoriteRecipes values(?, ?)");
        stm.setInt(1, favoriteRecipeID);
        stm.setInt(2, userID);
        stm.executeUpdate();
        con.close();
    }

    public void removeFavoriteRecipe(int favoriteRecipeID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("delete FavoriteRecipes where favoriteRecipeID = ?");
        stm.setInt(1, favoriteRecipeID);
        stm.executeUpdate();
        con.close();
    }
}
