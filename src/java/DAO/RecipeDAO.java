/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtil.DBContext;
import DTO.RecipeDTO;
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
public class RecipeDAO {

    public int countPro() throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select count(*) from [Recipe]");
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public List<RecipeDTO> getAll() throws SQLException {
        List<RecipeDTO> list = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from [Recipe]");
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            RecipeDTO recipe = new RecipeDTO();
            recipe.setRecipeID(rs.getInt("recipeID"));
            recipe.setUserID(rs.getInt("userID"));
            recipe.setRecipeName(rs.getString("recipeName"));
            recipe.setDatePost(rs.getDate("datePost"));
            recipe.setDescription(rs.getString("description"));
            recipe.setCookingTime(rs.getDouble("cookingTime"));
            recipe.setImageRecipe(rs.getString("imageRecipe"));
            recipe.setStatus(rs.getBoolean("status"));
            list.add(recipe);
        }
        return list;
    }

    public List<RecipeDTO> pageIndex(int index) throws SQLException {
        List<RecipeDTO> list = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from [Recipe] a join [User] b"
                + " on a.userID = b.userID order by [recipeID] "
                + "offset ? rows fetch next 9 rows only");
        stm.setInt(1, (index - 1) * 9);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            RecipeDTO recipe = new RecipeDTO();
            recipe.setRecipeID(rs.getInt("recipeID"));
            recipe.setUserID(rs.getInt("userID"));
            recipe.setRecipeName(rs.getString("recipeName"));
            recipe.setUserName(rs.getString("userName"));
            recipe.setDatePost(rs.getDate("datePost"));
            recipe.setDescription(rs.getString("description"));
            recipe.setCookingTime(rs.getDouble("cookingTime"));
            recipe.setImageRecipe(rs.getString("imageRecipe"));
            recipe.setStatus(rs.getBoolean("status"));
            list.add(recipe);
        }
        return list;
    }

    public List<RecipeDTO> myPro(int userID) throws SQLException {
        List<RecipeDTO> list = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from [Recipe] where userID = ? and [status] = 1");
        stm.setInt(1, userID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            RecipeDTO recipe = new RecipeDTO();
            recipe.setRecipeID(rs.getInt("recipeID"));
            recipe.setUserID(rs.getInt("userID"));
            recipe.setRecipeName(rs.getString("recipeName"));
            recipe.setDatePost(rs.getDate("datePost"));
            recipe.setDescription(rs.getString("description"));
            recipe.setCookingTime(rs.getDouble("cookingTime"));
            recipe.setImageRecipe(rs.getString("imageRecipe"));
            recipe.setStatus(rs.getBoolean("status"));
            list.add(recipe);
        }
        con.close();
        return list;
    }

    public void addPro(RecipeDTO recipe) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("insert [Recipe] values(?, ?, ?, ?, ?, ?, ?, 0)");
        stm.setInt(1, recipe.getUserID());
        stm.setString(2, recipe.getRecipeName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(recipe.getDatePost()));
        stm.setString(4, recipe.getDescription());
        stm.setDouble(5, recipe.getCookingTime());
        stm.setString(6, recipe.getImageRecipe());
        stm.executeUpdate();
        con.close();
    }

    public RecipeDTO updatePro(String name, String description, double cookingTime, String image, int recipeID)
            throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("update [Recipe] set [recipeName] = ?, "
                + "[description] = ?, [cookingTime] = ?, "
                + "[imageRecipe] = ?, [status] = 0 where [recipeID] = ?");
        stm.setString(1, name);
        stm.setString(2, description);
        stm.setDouble(3, cookingTime);
        stm.setString(4, image);
        stm.setInt(5, recipeID);
        int count = stm.executeUpdate();
        con.close();
        return null;
    }

    public void deletePro(int recipeID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("delete [Recipe] where recipeID = ?");
        stm.setInt(1, recipeID);
        int count = stm.executeUpdate();
        con.close();
    }

    public RecipeDTO getOne(int recipeID) throws SQLException {
        RecipeDTO recipe = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from [Recipe] a join [User] b on a.userID = b.userID where a.recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            recipe = new RecipeDTO();
            recipe.setRecipeID(rs.getInt("recipeID"));
            recipe.setUserID(rs.getInt("userID"));
            recipe.setRecipeName(rs.getString("recipeName"));
            recipe.setDatePost(rs.getDate("datePost"));
            recipe.setDescription(rs.getString("description"));
            recipe.setCookingTime(rs.getDouble("cookingTime"));
            recipe.setUserName(rs.getString("userName"));
            recipe.setImageRecipe(rs.getString("imageRecipe"));
            recipe.setStatus(rs.getBoolean("status"));
        }
        con.close();
        return recipe;
    }

    public void addRecipeForUser(int recipeID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("update Recipe set [status] = 1 where recipeID = ?");
        stm.setInt(1, recipeID);
        int count = stm.executeUpdate();
        con.close();
    }
}
