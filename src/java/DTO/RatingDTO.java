/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author phamt
 */
public class RatingDTO {
    private int rateID;
    private int userID;
    private int recipeID;
    private int scoreUser;

    public RatingDTO() {
    }

    public RatingDTO(int rateID, int userID, int recipeID, int scoreUser) {
        this.rateID = rateID;
        this.userID = userID;
        this.recipeID = recipeID;
        this.scoreUser = scoreUser;
    }

    public int getRateID() {
        return rateID;
    }

    public void setRateID(int rateID) {
        this.rateID = rateID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getScoreUser() {
        return scoreUser;
    }

    public void setScoreUser(int scoreUser) {
        this.scoreUser = scoreUser;
    }
    
    
}
