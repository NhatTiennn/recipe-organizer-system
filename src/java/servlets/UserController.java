/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.UserDAO;
import DTO.UserDTO;
import api.SendEmail;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author phamt
 */
@WebServlet(name = "UserController", urlPatterns = {"/user"})
public class UserController extends HttpServlet {

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
            case "login": {
                request.getRequestDispatcher("/WEB-INF/layouts/noN_NoF.jsp").forward(request, response);
                break;
            }

            case "login_handler": {
                login_handler(request, response);
                break;
            }

            case "logout": {
                logout(request, response);
                break;
            }

            case "signUp": {
                request.getRequestDispatcher("/WEB-INF/layouts/noN_NoF.jsp").forward(request, response);
                break;
            }

            case "signUp_handler": {
                signUp_handler(request, response);
                break;
            }

            case "profile": {
                profile(request, response);
                break;
            }

            case "profile_handler": {
                profile_handler(request, response);
                break;
            }

            case "changePass": {
                changePass(request, response);
                break;
            }

            case "changePass_handler": {
                changePass_handler(request, response);
                break;
            }

            case "forgot": {
                request.getRequestDispatcher("/WEB-INF/layouts/noN_NoF.jsp").forward(request, response);
                break;
            }

            case "forgot_handler": {
                forgot_handler(request, response);
                break;
            }

            case "code": {
                request.getRequestDispatcher("/WEB-INF/layouts/noN_NoF.jsp").forward(request, response);
                break;
            }

            case "verify_code": {
                verify_code(request, response);
                break;
            }

            case "resetPass": {
                request.getRequestDispatcher("/WEB-INF/layouts/noN_NoF.jsp").forward(request, response);
                break;
            }

            case "resetPass_handler": {
                resetPass_handler(request, response);
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

    protected void login_handler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "Login": {
                try {
                    String gmail = request.getParameter("gmail");
                    String password = request.getParameter("password");
                    String rem = request.getParameter("rem");

                    Cookie cg = new Cookie("cGmail", gmail);
                    Cookie cp = new Cookie("cPassword", password);
                    Cookie cr = new Cookie("cRem", rem);

                    if (rem != null) {
                        cg.setMaxAge(60 * 60 * 24 * 7);
                        cp.setMaxAge(60 * 60 * 24 * 7);
                        cr.setMaxAge(60 * 60 * 24 * 7);
                    } else {
                        cg.setMaxAge(0);
                        cp.setMaxAge(0);
                        cr.setMaxAge(0);
                    }
                    response.addCookie(cg);
                    response.addCookie(cp);
                    response.addCookie(cr);
                    UserDAO uDAO = new UserDAO();
                    UserDTO user = uDAO.login(gmail, password);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                        response.sendRedirect(request.getContextPath() + "/home/index.do");
                    } else {
                        request.setAttribute("message", "Wrong gmail or password");
                        request.getRequestDispatcher("/user/login.do").forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
            }
            break;

            case "Cancel": {
                response.sendRedirect(request.getContextPath() + "/home/index.do");
                break;
            }
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/home/index.do");
        } catch (Exception e) {
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void signUp_handler(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String op = request.getParameter("op");
        switch (op) {
            case "SignUp": {
                try {
                    String gmail = request.getParameter("gmail");
                    String password = request.getParameter("password");
                    String Cpassword = request.getParameter("Cpassword");
                    UserDAO uDAO = new UserDAO();
                    UserDTO user = uDAO.checkGmail(gmail);
                    if (gmail == null) {
                        request.setAttribute("message", "Plz fill the box");
                        request.getRequestDispatcher("/user/signUp.do").forward(request, response);
                    } else if (!password.equals(Cpassword)) {
                        request.setAttribute("message", "The password doesnn't match");
                        request.getRequestDispatcher("/user/signUp.do").forward(request, response);

                    } else {
                        if (user == null) {
                            uDAO.signUp(gmail, password);
                            response.sendRedirect(request.getContextPath() + "/home/index.do");
                        } else {
                            request.setAttribute("message", "Email has been signed up");
                            request.getRequestDispatcher("/user/signUp.do").forward(request, response);
                        }
                    }
                } catch (Exception e) {
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
            }
            break;

            case "Cancel": {
                response.sendRedirect(request.getContextPath() + "/home/index.do");
            }
            break;
        }
    }

    protected void profile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDAO uDAO = new UserDAO();
            int userID = Integer.parseInt(request.getParameter("userID"));
            UserDTO user = uDAO.getOne(userID);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/layouts/my_Pro.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/WEB-INF/layouts/my_Pro.jsp").forward(request, response);

        }
    }

    protected void profile_handler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "save": {
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));

                    String userName = request.getParameter("userName");
                    String imageUser = request.getParameter("imageUser");
                    String phone = request.getParameter("phone");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date dob = sdf.parse(request.getParameter("dob"));
                    String gender = request.getParameter("gender");
                    UserDAO uDAO = new UserDAO();
                    uDAO.update(userName, imageUser, dob, gender.equals("1"), phone, userID);
                    request.setAttribute("success", "Changed success");
                    request.getRequestDispatcher("/user/profile.do?userID=" + userID).forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/noN_NoF.jsp").forward(request, response);
                }
            }
        }
    }

    protected void changePass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDAO uDAO = new UserDAO();
            int userID = Integer.parseInt(request.getParameter("userID"));
            UserDTO user = uDAO.getOne(userID);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/layouts/my_Pro.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void changePass_handler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "save": {
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));

                    String Opassword = request.getParameter("Opassword");
                    String Npassword = request.getParameter("Npassword");
                    String Cpassword = request.getParameter("Cpassword");
                    UserDAO uDAO = new UserDAO();
                    UserDTO user = uDAO.checkPass(Opassword, userID);

                    if (!Npassword.equals(Cpassword)) {
                        request.setAttribute("failed", "The password doesn't match");
                        request.getRequestDispatcher("/user/changePass.do?userID=" + userID).forward(request, response);
                    } else {
                        if (user == null) {
                            request.setAttribute("failed", "Wrong old password");
                            request.getRequestDispatcher("/user/changePass.do?userID=" + userID).forward(request, response);
                        } else {
                            uDAO.changePass(Npassword, userID);
                            request.setAttribute("success", "Password changed");
                            request.getRequestDispatcher("/user/changePass.do?userID=" + userID).forward(request, response);
                        }
                    }
                } catch (Exception e) {
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
            }
        }
    }

    private void forgot_handler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "Confirm": {
                try {
                    String gmail = request.getParameter("gmail");

                    SendEmail sm = new SendEmail();
                    String code = sm.getRandom();

                    UserDTO user = new UserDTO(gmail, code);

                    boolean test = sm.sendEmail(user);
                    if (test) {
                        request.getSession().setAttribute("user", user);
                        response.sendRedirect(request.getContextPath() + "/user/code.do");
                    }
                } catch (Exception e) {
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
            }
            break;

            case "Cancel": {
                response.sendRedirect(request.getContextPath() + "/user/login.do");
            }
            break;
        }
    }

    protected void verify_code(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "Verify": {
                try {
                    UserDTO user = (UserDTO) request.getSession().getAttribute("user");
                    String code = request.getParameter("code");

                    Timer time = new Timer();
                    time.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            user.setCode(null);
                            time.cancel();  
                        }
                    }, 30 * 1000);

                    if (code.equalsIgnoreCase(user.getCode())) {
                        response.sendRedirect(request.getContextPath() + "/user/resetPass.do");
                    } else {
                        request.setAttribute("failed", "Wrong code");
                        request.getRequestDispatcher("/user/code.do").forward(request, response);
                    }
                } catch (Exception e) {
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
            }
            break;

            case "Cancel": {
                response.sendRedirect(request.getContextPath() + "/user/forgot.do");
            }
            break;

            case "Resend": {
                try {
                    String gmail = request.getParameter("gmail");

                    SendEmail sm = new SendEmail();
                    String code = sm.getRandom();

                    UserDTO user = new UserDTO(gmail, code);

                    boolean test = sm.sendEmail(user);
                    if (test) {
                        request.getSession().setAttribute("user", user);
                        response.sendRedirect(request.getContextPath() + "/user/code.do");
                    }
                } catch (Exception e) {
                }
            }
            break;
        }
    }

    protected void resetPass_handler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "Reset": {
                try {
                    String gmail = request.getParameter("gmail");

                    String Npassword = request.getParameter("Npassword");
                    String Cpassword = request.getParameter("Cpassword");
                    UserDAO uDAO = new UserDAO();

                    if (!Npassword.equals(Cpassword)) {
                        request.setAttribute("failed", "The password doesn't match");
                        request.getRequestDispatcher("/user/resetPass.do").forward(request, response);
                    } else {
                        uDAO.resetPass(Npassword, gmail);
                        request.getSession().invalidate();
                        response.sendRedirect(request.getContextPath() + "/home/index.do");
                    }
                } catch (Exception e) {
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
            }
        }
    }

}
