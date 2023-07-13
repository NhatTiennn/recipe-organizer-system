/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtil.DBContext;
import DTO.StepDTO;
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
public class StepDAO {
    public List<StepDTO> getStepORecipe(int recipeID) throws SQLException {
        List<StepDTO> list = null;
        Connection con = DBContext.makeConnection();
        PreparedStatement stm = con.prepareStatement("select * from Step where recipeID = ?");
        stm.setInt(1, recipeID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while(rs.next()) {
            StepDTO step = new StepDTO();
            step.setStepID(rs.getInt("stepID"));
            step.setRecipeID(rs.getInt("recipeID"));
            step.setStepNumber(rs.getInt("stepNumber"));
            step.setInstructions(rs.getString("instructions"));
            list.add(step);
        }
        con.close();
        return list;
    }
}
