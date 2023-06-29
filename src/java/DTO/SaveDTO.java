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
public class SaveDTO {

    private int savedRecipeID;
    private int recipeID;
    private String imageRecipe;
    private String recipeName;
    private int userID;

    public SaveDTO() {
    }

    public SaveDTO(int savedRecipeID, int recipeID, String imageRecipe, String recipeName, int userID) {
        this.savedRecipeID = savedRecipeID;
        this.recipeID = recipeID;
        this.imageRecipe = imageRecipe;
        this.recipeName = recipeName;
        this.userID = userID;
    }

    

    public String getImageRecipe() {
        return imageRecipe;
    }

    public void setImageRecipe(String imageRecipe) {
        this.imageRecipe = imageRecipe;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getSavedRecipeID() {
        return savedRecipeID;
    }

    public void setSavedRecipeID(int savedRecipeID) {
        this.savedRecipeID = savedRecipeID;
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
     
}

