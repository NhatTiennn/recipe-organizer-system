/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.FeedbackDAO;
import DAO.IngredientDAO;
import DAO.MealPlanDAO;
import DAO.NutritionalDAO;
import DAO.RatingDAO;
import DAO.RecipeDAO;
import DAO.Save_favoriteDAO;
import DAO.StepDAO;
import DTO.FavoriteDTO;
import DTO.FeedbackDTO;
import DTO.IngredientDTO;
import DTO.MealPlanDTO;
import DTO.NutritionalDTO;
import DTO.RatingDTO;
import DTO.RecipeDTO;
import DTO.SaveDTO;
import DTO.StepDTO;
import DTO.UserDTO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phamt
 */
@WebServlet(name = "RecipeController", urlPatterns = {"/recipe"})
public class RecipeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "recipePage": {
                recipePage(request, response);
                break;
            }

            case "recipeDetail": {
                recipeDetail(request, response);
                break;
            }

            case "addFeedback": {
                addFeedback(request, response);
                break;
            }

            case "rating": {
                rating(request, response);
                break;
            }

            case "mealPlan": {
                mealPlan(request, response);
                break;
            }

            case "addPlan": {
                addPlan(request, response);
                break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected void recipePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RecipeDAO rDAO = new RecipeDAO();
            String indexPage = request.getParameter("page");
            if (indexPage == null) {
                indexPage = "1";
            }
            int page = Integer.parseInt(indexPage);
            int count = rDAO.countPro();
            int endP = count / 9;
            if (count % 9 != 0) {
                endP++;
            }
            List<RecipeDTO> list = rDAO.pageIndex(page);
            request.setAttribute("endP", endP);
            request.setAttribute("page", page);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/WEB-INF/layouts/noN_NoF.jsp").forward(request, response);
        }
    }

    protected void recipeDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int recipeID = Integer.parseInt(request.getParameter("recipeID"));
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        try {

            if (user == null) {
                RecipeDAO rDAO = new RecipeDAO();
                RecipeDTO recipe = rDAO.getOne(recipeID);

                FeedbackDAO fDAO = new FeedbackDAO();
                List<FeedbackDTO> listFeedback = fDAO.getComments(recipeID);

                RatingDAO raDAO = new RatingDAO();
                int totalRate = raDAO.totalRating(recipeID);
                int totalScoreRecipe = raDAO.totalScoreRecipe(recipeID);
                int totalUserScoreRecipe = raDAO.totalUserScoreRecipe(recipeID);
                int avgStar = 0;
                if (totalUserScoreRecipe > 0) {
                    avgStar = Math.round(totalScoreRecipe / totalUserScoreRecipe);
                }

                Save_favoriteDAO sfDAO = new Save_favoriteDAO();
                int sSize = sfDAO.totalSavedORecipe(recipeID);
                int fSize = sfDAO.totalFavoriteORecipe(recipeID);

                IngredientDAO ingreDAO = new IngredientDAO();
                List<IngredientDTO> ingredient = ingreDAO.getIngreORecipe(recipeID);

                NutritionalDAO nutriDAO = new NutritionalDAO();
                NutritionalDTO nutritional = nutriDAO.getNutriOneRecipe(recipeID);

                StepDAO sDAO = new StepDAO();
                List<StepDTO> step = sDAO.getStepORecipe(recipeID);

                request.setAttribute("nutritional", nutritional);
                request.setAttribute("ingredient", ingredient);
                request.setAttribute("step", step);
                request.setAttribute("sSize", sSize);
                request.setAttribute("fSize", fSize);
                request.setAttribute("avgStar", avgStar);
                request.setAttribute("totalRate", totalRate);
                request.setAttribute("feedbacks", listFeedback);
                request.setAttribute("noFb", listFeedback.size());
                request.setAttribute("recipe", recipe);

                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
            } else {

                RecipeDAO rDAO = new RecipeDAO();
                RecipeDTO recipe = rDAO.getOne(recipeID);

                FeedbackDAO fDAO = new FeedbackDAO();
                List<FeedbackDTO> listFeedback = fDAO.getComments(recipeID);

                RatingDAO raDAO = new RatingDAO();
                RatingDTO rating = raDAO.getRatingRecipe(recipeID, user.getUserID());
                int totalRate = raDAO.totalRating(recipeID);
                int totalScoreRecipe = raDAO.totalScoreRecipe(recipeID);
                int totalUserScoreRecipe = raDAO.totalUserScoreRecipe(recipeID);
                int avgStar = 0;
                if (totalUserScoreRecipe > 0) {
                    avgStar = Math.round(totalScoreRecipe / totalUserScoreRecipe);
                }
                Save_favoriteDAO sfDAO = new Save_favoriteDAO();
                SaveDTO save = sfDAO.getSavedRecipeID(recipeID, user.getUserID());
                FavoriteDTO favorite = sfDAO.getFavoriteRecipeID(recipeID, user.getUserID());
                int sSize = sfDAO.totalSavedORecipe(recipeID);
                int fSize = sfDAO.totalFavoriteORecipe(recipeID);

                IngredientDAO ingreDAO = new IngredientDAO();
                List<IngredientDTO> ingredient = ingreDAO.getIngreORecipe(recipeID);

                NutritionalDAO nutriDAO = new NutritionalDAO();
                NutritionalDTO nutritional = nutriDAO.getNutriOneRecipe(recipeID);

                StepDAO sDAO = new StepDAO();
                List<StepDTO> step = sDAO.getStepORecipe(recipeID);

                request.setAttribute("nutritional", nutritional);
                request.setAttribute("ingredient", ingredient);
                request.setAttribute("step", step);
                request.setAttribute("save", save);
                request.setAttribute("favorite", favorite);
                request.setAttribute("totalRate", totalRate);
                request.setAttribute("avgStar", avgStar);
                request.setAttribute("sSize", sSize);
                request.setAttribute("fSize", fSize);
                request.setAttribute("rating", rating);
                request.setAttribute("feedbacks", listFeedback);
                request.setAttribute("noFb", listFeedback.size());
                request.setAttribute("recipe", recipe);

                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void addFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        int recipeID = Integer.parseInt(request.getParameter("recipeID"));

        try {
            if (user == null) {
                request.setAttribute("failed", "Plz login to feedback");
                request.getRequestDispatcher("/recipe/recipeDetail.do?recipeID=" + recipeID).forward(request, response);
            } else {
                String content = request.getParameter("content");
                String userName = request.getParameter("userName");
                int userID = Integer.parseInt(request.getParameter("userID"));
                FeedbackDAO fDAO = new FeedbackDAO();
                FeedbackDTO feedback = new FeedbackDTO();
                Date datePost = new Date();
                feedback.setContent(content);
                feedback.setFeedBackDate(datePost);
                feedback.setUserID(userID);
                feedback.setRecipeID(recipeID);
                feedback.setUserName(userName);
                fDAO.addComments(feedback);
                response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
            }
        } catch (Exception e) {
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);

        }
    }

    protected void rating(HttpServletRequest request, HttpServletResponse response) {
        String op = request.getParameter("op");
        switch (op) {
            case "one": {
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    int scoreUser = 1;
                    RatingDAO rDAO = new RatingDAO();
                    RatingDTO rating = new RatingDTO();
                    RatingDTO check = rDAO.checkReRating(userID, recipeID);
                    if (check == null) {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.ratingRecipe(rating);
                        response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                    } else {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.reRating(rating);
                        response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "two": {
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    int scoreUser = 2;
                    RatingDAO rDAO = new RatingDAO();
                    RatingDTO rating = new RatingDTO();
                    RatingDTO check = rDAO.checkReRating(userID, recipeID);
                    if (check == null) {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.ratingRecipe(rating);
                        response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                    } else {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.reRating(rating);
                        response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "three": {
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    int scoreUser = 3;
                    RatingDAO rDAO = new RatingDAO();
                    RatingDTO rating = new RatingDTO();
                    RatingDTO check = rDAO.checkReRating(userID, recipeID);
                    if (check == null) {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.ratingRecipe(rating);
                        response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                    } else {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.reRating(rating);
                        response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "four": {
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    int scoreUser = 4;
                    RatingDAO rDAO = new RatingDAO();
                    RatingDTO rating = new RatingDTO();
                    RatingDTO check = rDAO.checkReRating(userID, recipeID);
                    if (check == null) {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.ratingRecipe(rating);
                        response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                    } else {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.reRating(rating);
                        response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "five": {
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    int scoreUser = 5;
                    RatingDAO rDAO = new RatingDAO();
                    RatingDTO rating = new RatingDTO();
                    RatingDTO check = rDAO.checkReRating(userID, recipeID);
                    if (check == null) {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.ratingRecipe(rating);
                        response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                    } else {
                        rating.setUserID(userID);
                        rating.setRecipeID(recipeID);
                        rating.setScoreUser(scoreUser);
                        rDAO.reRating(rating);
                        response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    protected void addPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        String oop = request.getParameter("op");
        switch (oop) {
            case "Add": {
                try {
                    int savedRecipeID = Integer.parseInt(request.getParameter("savedRecipeID"));
                    String choose = request.getParameter("choose");
                    String year = request.getParameter("years");
                    String month = request.getParameter("month");
                    String day = request.getParameter("day");
                    String date = year + "-" + month + "-" + day;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateAdd = sdf.parse(date);
                    MealPlanDAO mpDAO = new MealPlanDAO();
                    MealPlanDTO mp = new MealPlanDTO();
                    if (choose.equalsIgnoreCase("1")) {
                        mp.setUserID(user.getUserID());
                        mp.setSavedRecipeID(savedRecipeID);
                        mp.setDate(dateAdd);
                        mpDAO.addMealPlan(mp);
                        response.sendRedirect(request.getContextPath() + "/recipe/mealPlan.do?userID=" + user.getUserID());
                    } else {
                        request.setAttribute("failed", "Have something wrong here");
                        request.getRequestDispatcher("/recipe/mealPlan.do?userID=" + user.getUserID());
                    }

                } catch (Exception e) {
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            }
        }
    }

    private void mealPlan(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userID = Integer.parseInt(request.getParameter("userID"));
            Save_favoriteDAO sfDAO = new Save_favoriteDAO();
            List<SaveDTO> saved = sfDAO.getSaved(userID);
            request.setAttribute("list", saved);
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
