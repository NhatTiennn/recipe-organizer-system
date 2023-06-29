<%-- 
    Document   : my_Pro
    Created on : Jun 24, 2023, 11:47:40 AM
    Author     : phamt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Flavorful Creations</title>

    <!-- Favicon -->
    <link rel="icon" href="<c:url value="/img/core-img/favicon.icon"/>">

    <!-- Core Stylesheet -->
    <link href="<c:url value="/style.css"/>" rel="stylesheet">

    <!-- Responsive CSS -->
    <link href="<c:url value="/css/responsive/responsive.css"/>" rel="stylesheet">

</head>

<body>
    <!-- Preloader Start -->
    <div id="preloader">
        <div class="yummy-load"></div>
    </div>

    <!-- Background Pattern Swither -->
    <div id="pattern-switcher">
        Bg Pattern
    </div>
    <div id="patter-close">
        <i class="fa fa-times" aria-hidden="true"></i>
    </div>

    <!-- ****** Top Header Area Start ****** -->
    <div class="top_header_area">
        <div class="container">
            <div class="row">
                <div class="col-5 col-sm-6">
                    <!--  Top Social bar start -->
                    <div class="top_social_bar">
                        <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                        <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                        <a href="#"><i class="fa fa-google" aria-hidden="true"></i></a>
                    </div>
                </div>
                <!--  Login Register Area -->
                <div class="col-7 col-sm-6">
                    <div class="signup-search-area d-flex align-items-center justify-content-end">
                        <div class="col-8 col-sm-8">
                            <div class="search_button justify-content-end align-items-center d-flex">
                                <a class="searchBtn" href="#"><i class="fa fa-search" aria-hidden="true"></i></a>
                            </div>
                            <div class="search-hidden-form justify-content-end align-items-center ">
                                <form action="MainController" method="GET">
                                    <input type="text" name="search" id="search-anything"
                                           placeholder="Search Anything...">
                                    <input type="submit" name="action" value="Search" class="d-none">
                                    <span class="searchBtn"><i class="fa fa-times" aria-hidden="true"></i></span>
                                </form>
                            </div>
                        </div>
                        <c:if test="${user == null}">
                            <div class="login_register_area d-flex col-4 col-sm-4">
                                <div class="login">
                                    <a href="<c:url value="/user/login.do"/>">Sign in</a>
                                </div>
                                <div class="register">
                                    <a href="<c:url value="/user/signUp.do"/>">Sign up</a>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${user != null}">
                            <div class="login_register_area d-flex col-4 col-sm-4">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="yummyDropdown" role="button"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <h7>Hello, 
                                            <c:if test="${user.userName == null}">...</c:if>
                                            <c:if test="${user.userName != null}">${user.userName}</c:if>
                                            </h7>
                                        </a>
                                        <div class="dropdown-menu" aria-labelledby="yummyDropdown">
                                            <a class="dropdown-item" href="<c:url value="/user/profile.do?userID=${user.userID}"/>">Your Profile</a>
                                        <c:if test="${user.role == 'ADMIN'}">
                                            <a class="dropdown-item" href="dashboard.jsp">Dash Board</a>
                                        </c:if>
                                        <a class="dropdown-item" href="changepass.html">Change Password</a>
                                        <a class="dropdown-item" href="myfavorite.html">Your Saved</a>
                                        <form action="<c:url value="/user/logout.do"/>" method="POST">
                                            <input class="dropdown-item" type="submit" name="action" value="Log out">
                                        </form>
                                    </div>
                                </li>
                            </div>
                        </c:if>
                    </div>
                </div>


            </div>
        </div>
    </div>
    <header class="header_area">
        <div class="container">
            <div class="row">
                <!-- Logo Area Start -->
                <div class="col-12">
                    <div class="logo_area text-center">
                        <a href="mainpage.jsp" class="yummy-logo">Flavorful Creations</a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <nav class="navbar navbar-expand-lg">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#yummyfood-nav"
                                aria-controls="yummyfood-nav" aria-expanded="false" aria-label="Toggle navigation"><i
                                class="fa fa-bars" aria-hidden="true"></i> Menu</button>
                        <!-- Menu Area Start -->
                        <div class="collapse navbar-collapse justify-content-center" id="yummyfood-nav">
                            <ul class="navbar-nav" id="yummy-nav">
                                <li class="nav-item active">
                                    <a class="nav-link" href="<c:url value="/home/index.do"/>">Home<span
                                            class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="<c:url value="/recipe/recipePage.do"/>">Recipes</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="categories.jsp">Categories</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="yummyDropdown" role="button"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">My Recipes</a>
                                    <div class="dropdown-menu" aria-labelledby="yummyDropdown">
                                        <a class="dropdown-item" href="createrecipe.jsp">Add a recipe</a>

                                        <a class="dropdown-item" href="#">My favorites</a>
                                        <a class="dropdown-item" href="myfavorite.html">Saved</a>

                                    </div>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" href="planpage.jsp">Meal Plan</a>
                                </li>

                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <div style="background-color:rgb(255, 225, 209);">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-4 col-lg-4 "
                     style="background-color: white; margin-bottom: 50px;margin-top: 50px;border-radius: 10px;">
                    <div class="row">
                        <div class="col-12">
                            <div class="personal-head row" style="border-bottom-style: solid; border-color:whitesmoke;">
                                <div class="col-4 col-md-4 col-lg-4" style="margin-top: 10px;margin-bottom: 10px;">
                                    <c:if test="${user.imageUser == null}">
                                        <img src="<c:url value="/img/about-img/1.jpg"/>" alt="Personal image"
                                             style="width: 100%;border-radius: 10px;">
                                    </c:if>
                                    <c:if test="${user.imageUser != null}">
                                        <img src="${user.imageUser}" alt="Personal image"
                                             style="width: 100%;border-radius: 10px;">
                                    </c:if>
                                </div>
                                <div class="col-8 col-md-8 col-lg-8 profile-user">
                                    <h4 style="color:black;margin-top: 27px; ">Hello, 
                                        <c:if test="${user.userName == null}">...</c:if>
                                        <c:if test="${user.userName != null}">${user.userName}</c:if>
                                        </h4>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 personal-info-a">
                                <a href="<c:url value="/user/profile.do?userID=${user.userID}"/>">My Profile</a>
                        </div>
                        <div class="col-12 change-password-a">
                            <a href="<c:url value="/user/changePass.do?userID=${user.userID}"/>" class="" >Change password</a>
                        </div>
                        <div class="col-12 saved-items-a">
                            <a href="myfavorite.html" class="" >Saved Items & Collections</a>
                        </div>
                        <div class="col-12 personal-recipes-a">
                            <a href="#my-recipe" class="">Personal Recipes</a>
                        </div>
                    </div>
                </div>

                <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp"/>
            </div>
        </div>
    </div>
    <footer class="footer_area">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="footer-content">
                        <!-- Logo Area Start -->
                        <div class="footer-logo-area text-center">
                            <a href="<c:url value="/home/index.do"/>" class="yummy-logo">Flavorful Creations</a>
                        </div>                      
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <!-- Copywrite Text -->
                    <div class="copy_right_text text-center">
                        <p>Enjoy your life <i class="fa fa-heart-o"
                                              aria-hidden="true"></i> by "Flavorful Creations"</p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ****** Footer Menu Area End ****** -->

    <!-- Jquery-2.2.4 js -->
    <script src="<c:url value="/js/jquery/jquery-2.2.4.min.js"/>"></script>
    <!-- Popper js -->
    <script src="<c:url value="/js/bootstrap/popper.min.js"/>"></script>
    <!-- Bootstrap-4 js -->
    <script src="<c:url value="/js/bootstrap/bootstrap.min.js"/>"></script>
    <!-- All Plugins JS -->
    <script src="<c:url value="/js/others/plugins.js"/>"></script>
    <!-- Active JS -->
    <script src="<c:url value="/js/active.js"/>"></script>
</body>
</html>
