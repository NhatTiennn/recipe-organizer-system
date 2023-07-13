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
public class StepDTO {
    private int stepID;
    private int recipeID;
    private int stepNumber;
    private String instructions;

    public StepDTO() {
    }

    public StepDTO(int stepID, int recipeID, int stepNumber, String instructions) {
        this.stepID = stepID;
        this.recipeID = recipeID;
        this.stepNumber = stepNumber;
        this.instructions = instructions;
    }

    public int getStepID() {
        return stepID;
    }

    public void setStepID(int stepID) {
        this.stepID = stepID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    
    
}
