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
public class RecipeDTO {

    private int recipeID;
    private int userID;
    private String recipeName;
    private String userName;
    private Date datePost;
    private String description;
    private double cookingTime;
    private String imageRecipe;
    private int savedRecipeID;
    private boolean status;

    public RecipeDTO() {
    }

    public RecipeDTO(int recipeID, int userID, String recipeName, String userName, Date datePost, String description, double cookingTime, String imageRecipe, int savedRecipeID, boolean status) {
        this.recipeID = recipeID;
        this.userID = userID;
        this.recipeName = recipeName;
        this.userName = userName;
        this.datePost = datePost;
        this.description = description;
        this.cookingTime = cookingTime;
        this.imageRecipe = imageRecipe;
        this.savedRecipeID = savedRecipeID;
        this.status = status;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(double cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getImageRecipe() {
        return imageRecipe;
    }

    public void setImageRecipe(String imageRecipe) {
        this.imageRecipe = imageRecipe;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSavedRecipeID() {
        return savedRecipeID;
    }

    public void setSavedRecipeID(int savedRecipeID) {
        this.savedRecipeID = savedRecipeID;
    }

}
