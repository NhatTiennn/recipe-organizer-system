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
public class FeedbackDTO {

    private int feedBackID;
    private String content;
    private int userID;
    private int recipeID;
    private String userName;
    private Date feedBackDate;
    private boolean status;

    public FeedbackDTO() {
    }

    public FeedbackDTO(int feedBackID, String content, int userID, int recipeID, String userName, Date date, boolean status) {
        this.feedBackID = feedBackID;
        this.content = content;
        this.userID = userID;
        this.recipeID = recipeID;
        this.userName = userName;
        this.feedBackDate = feedBackDate;
        this.status = status;
    }

    public int getFeedBackID() {
        return feedBackID;
    }

    public void setFeedBackID(int feedBackID) {
        this.feedBackID = feedBackID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getFeedBackDate() {
        return feedBackDate;
    }

    public void setFeedBackDate(Date feedBackDate) {
        this.feedBackDate = feedBackDate;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    } 
}
