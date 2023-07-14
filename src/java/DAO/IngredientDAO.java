/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtil.DBContext;
import DTO.IngredientDTO;
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
public class IngredientDAO {
    public List<IngredientDTO> getIngreORecipe(int recipeID) throws SQLException {
        List<IngredientDTO> listIngre = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from Ingredient where recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        listIngre = new ArrayList<>();
        while(rs.next()) {
            IngredientDTO ingredient = new IngredientDTO();
            ingredient.setIngredientID(rs.getInt("ingredientID"));
            ingredient.setIngredientName(rs.getString("ingredientName"));
            ingredient.setRecipeID(rs.getInt("recipeID"));
            ingredient.setQuantity(rs.getDouble("quantity"));
            ingredient.setUnit(rs.getString("unit"));
            listIngre.add(ingredient);
        }
        con.close();
        return listIngre;
    }
}
