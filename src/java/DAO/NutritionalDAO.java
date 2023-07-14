/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtil.DBContext;
import DTO.NutritionalDTO;
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
public class NutritionalDAO {

    public NutritionalDTO getNutriOneRecipe(int recipeID) throws SQLException {
        NutritionalDTO nutritional = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select sum(calories) as calories,"
                + " SUM(fat) as fat, SUM(carb) as carb,"
                + " SUM(proteins) as proteins, SUM(sugar) as sugar "
                + "from Nutritional a join Ingredient b "
                + "on a.[name] = b.ingredientName where b.recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            nutritional = new NutritionalDTO();
            nutritional.setCalories(rs.getDouble("calories"));
            nutritional.setFat(rs.getDouble("fat"));
            nutritional.setCarb(rs.getDouble("carb"));
            nutritional.setProteins(rs.getDouble("proteins"));
            nutritional.setSugar(rs.getDouble("sugar"));
        }
        con.close();
        return nutritional;
    }
}
