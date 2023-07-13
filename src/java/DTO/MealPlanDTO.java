/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author phamt
 */
public class MealPlanDTO {
    private int planningID;
    private int savedRecipeID;
    private int userID;
    private Date date;

    public MealPlanDTO() {
    }

    public MealPlanDTO(int planningID, int savedRecipeID, int userID, Date date) {
        this.planningID = planningID;
        this.savedRecipeID = savedRecipeID;
        this.userID = userID;
        this.date = date;
    }

    public int getPlanningID() {
        return planningID;
    }

    public void setPlanningID(int planningID) {
        this.planningID = planningID;
    }

    public int getSavedRecipeID() {
        return savedRecipeID;
    }

    public void setSavedRecipeID(int savedRecipeID) {
        this.savedRecipeID = savedRecipeID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
