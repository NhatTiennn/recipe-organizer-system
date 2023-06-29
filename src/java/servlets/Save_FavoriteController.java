/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Save_favoriteDAO;
import DTO.FavoriteDTO;
import DTO.SaveDTO;
import DTO.UserDTO;
import java.io.IOException;
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
@WebServlet(name = "Save_FavoriteController", urlPatterns = {"/save_favorite"})
public class Save_FavoriteController extends HttpServlet {

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
            case "favorite": {
                favorite(request, response);
            }
            break;

            case "saved": {
                saved(request, response);
            }
            break;

            case "addToFavourite":
                addToFavourite(request, response);
                break;

            case "addToSaved":
                addToSaved(request, response);
                break;

            case "removeFromFavourite":
                removeFromFavourite(request, response);
                break;
            case "removeFromSaved":
                removeFromSaved(request, response);
                break;
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

    protected void favorite(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userID = Integer.parseInt(request.getParameter("userID"));
            Save_favoriteDAO sfDAO = new Save_favoriteDAO();
            List<FavoriteDTO> favorite = sfDAO.getFavorite(userID);
            request.setAttribute("favorite", favorite);
            request.getSession().setAttribute("size", favorite.size());
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    protected void saved(HttpServletRequest request, HttpServletResponse response) {
        try {
            int userID = Integer.parseInt(request.getParameter("userID"));
            Save_favoriteDAO sfDAO = new Save_favoriteDAO();
            List<SaveDTO> save = sfDAO.getSaved(userID);
            request.setAttribute("save", save);
            request.getSession().setAttribute("size", save.size());
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    protected void addToFavourite(HttpServletRequest request, HttpServletResponse response) {
        String op = request.getParameter("op");
        switch (op) {
            case "Like": {
                try {
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    Save_favoriteDAO sfDAO = new Save_favoriteDAO();
                    FavoriteDTO check = sfDAO.getOneFavorite(recipeID);

                    if (check == null) {
                        FavoriteDTO favorite = new FavoriteDTO();
                        favorite.setRecipeID(recipeID);
                        favorite.setUserID(userID);
                        sfDAO.addFavoriteByID(recipeID, userID);
                        request.setAttribute("check", check);
                        response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                    }
                    request.setAttribute("check", check);
                    response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void addToSaved(HttpServletRequest request, HttpServletResponse response) {
        String op = request.getParameter("op");
        switch (op) {
            case "Save": {
                try {
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    Save_favoriteDAO sfDAO = new Save_favoriteDAO();
                    SaveDTO check = sfDAO.getOneSaved(recipeID, userID);
                    if (check == null) {
                        SaveDTO save = new SaveDTO();
                        save.setRecipeID(recipeID);
                        save.setUserID(userID);
                        sfDAO.addSavedByID(recipeID, userID);
                        response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                    }
                    response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        }

    }

    protected void removeFromFavourite(HttpServletRequest request, HttpServletResponse response) {
        String op = request.getParameter("op");
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        switch (op) {
            case "Remove": {
                try {
                    int favoriteRecipeID = Integer.parseInt(request.getParameter("favoriteRecipeID"));
                    Save_favoriteDAO sfDAO = new Save_favoriteDAO();
                    sfDAO.removeFavoriteRecipe(favoriteRecipeID);
                    response.sendRedirect(request.getContextPath() + "/save_favorite/favorite.do?userID=" + user.getUserID());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void removeFromSaved(HttpServletRequest request, HttpServletResponse response) {
        String op = request.getParameter("op");
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        switch (op) {
            case "Remove": {
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    Save_favoriteDAO sfDAO = new Save_favoriteDAO();
                    sfDAO.removeSavedRecipe(userID, recipeID);
                    response.sendRedirect(request.getContextPath() + "/save_favorite/saved.do?userID=" + user.getUserID());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
            case "remove": {
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    int recipeID = Integer.parseInt(request.getParameter("recipeID"));
                    Save_favoriteDAO sfDAO = new Save_favoriteDAO();
                    sfDAO.removeSavedRecipe(userID, recipeID);
                    response.sendRedirect(request.getContextPath() + "/recipe/recipeDetail.do?recipeID=" + recipeID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}
