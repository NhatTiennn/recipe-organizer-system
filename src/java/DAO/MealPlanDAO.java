/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtil.DBContext;
import DTO.MealPlanDTO;
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
public class MealPlanDAO {

    public List<MealPlanDTO> PlanODate(int userID, Date date) throws SQLException {
        List<MealPlanDTO> list = new ArrayList<>();
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from MealPlanning a join Recipe b on a.recipeID = b.recipeID "
                + "join MyRecipes c on b.recipeID = c.recipeID "
                + "where a.userID = ? and a.[date] = ?");

        stm.setInt(1, userID);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(2, sdf.format(date));
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            MealPlanDTO mealPlan = new MealPlanDTO();
            mealPlan.setPlanningID(rs.getInt("planningID"));
            mealPlan.setUserID(rs.getInt("userID"));
            mealPlan.setSavedRecipeID(rs.getInt("savedRecipeID"));
            mealPlan.setDate(rs.getDate("date"));
            list.add(mealPlan);
        }
        con.close();
        return list;
    }

    public void addMealPlan(MealPlanDTO mealPlan) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("insert MealPlanning values(?, ?, ?)");
        stm.setInt(1, mealPlan.getUserID());
        stm.setInt(2, mealPlan.getSavedRecipeID());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(mealPlan.getDate()));
        int count = stm.executeUpdate();
    }

    public void getOne(int planningID) throws SQLException {
        MealPlanDTO mealPlan = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from MealPlanning where planningID = ?");
        stm.setInt(1, planningID);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            mealPlan = new MealPlanDTO();
            mealPlan.setPlanningID(rs.getInt("planningID"));
            mealPlan.setUserID(rs.getInt("userID"));
            mealPlan.setSavedRecipeID(rs.getInt("savedRecipeID"));
            mealPlan.setDate(rs.getDate("date"));
        }
        con.close();
    }
    
    public void deleteMeal(int planningID) throws SQLException {
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("delete MealPlanning where planningID = ?");
        stm.setInt(1, planningID);
        stm.executeUpdate();
    }
}
