<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

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
        <link rel="stylesheet" href="<c:url value="/calendar/css/style.css"/>">
        <link href="<c:url value="/style.css"/>" rel="stylesheet">

        <!-- Responsive CSS -->
        <link href="<c:url value="/css/responsive/responsive.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/fonts-2/themify-icons/themify-icons.css"/>">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <!--
        
        -->        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet"><!--
        
        -->        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"><!--
        
        -->        <link rel="stylesheet" href="<c:url value="/calendar/css/style.css"/>">
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
                                            <a class="dropdown-item" href="<c:url value="/user/changePass.do?userID=${user.userID}"/>">Change Password</a>
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
                            <a href="<c:url value="/home/index.do"/>" class="yummy-logo">Flavorful Creations</a>
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

                                            <a class="dropdown-item" href="<c:url value="/save_favorite/favorite.do?userID=${user.userID}"/>">My favorites</a>
                                            <a class="dropdown-item" href="<c:url value="/save_favorite/saved.do?userID=${user.userID}"/>">Saved</a>
                                        </div>
                                    </li>

                                    <li class="nav-item">
                                        <a class="nav-link" href="<c:url value="/recipe/mealPlan.do?userID=${user.userID}"/>">Meal Plan</a>
                                    </li>

                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp"/>
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

        <!--        DIALOG REMOVING FAVORITE-->
        <div class="modal fade" id="RemoveFavorite" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Are you sure?</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Removing this recipe will delete it permanently from favorite recipes and posts on your profile.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <form action="<c:url value="/save_favorite/removeFromFavourite.do?recipeID=${recipe.recipeID}&userID=${user.userID}"/>" method="POST">
                            <button type="submit" name="op" value="remove" class="btn btn-primary">Remove</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!--        DIALOG REMOVING SAVED-->      
        <div class="modal fade" id="RemoveSaved" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Are you sure?</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Removing this recipe will delete it permanently from save recipes and posts on your profile.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <form action="<c:url value="/save_favorite/removeFromSaved.do?recipeID=${recipe.recipeID}&userID=${user.userID}"/>" method="POST">
                            <button type="submit" name="op" value="remove" class="btn btn-primary">Remove</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!--        DIALOG LOGIN TO ...-->      
        <div class="modal fade" id="Login" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Notification</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Please sign up to do anything !!!
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <a href="<c:url value="/user/login.do"/>"><button type="button" name="op" value="remove" class="btn btn-primary">Sign in</button></a>
                    </div>
                </div>
            </div>
        </div>


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

<!--        <script src="<c:url value="/calendar/js/jquery.min.js"/>"></script>-->
        <script src="<c:url value="/calendar/js/popper.js"/>"></script>
        <script src="<c:url value="/calendar/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/calendar/js/main.js"/>"></script>
    </body>
</html>


<!--
    var bookmarkIcon = document.querySelector("button.bi-bookmark");
    bookmarkIcon.addEventListener("click", function () {

        if (bookmarkIcon.classList.contains("bi-bookmark-fill")) {
            bookmarkIcon.classList.remove("bi-bookmark-fill");
            bookmarkIcon.classList.add("bi-bookmark");
        } else {
            bookmarkIcon.classList.remove("bi-bookmark");
            bookmarkIcon.classList.add("bi-bookmark-fill");
        }
    });
    
    var heart = document.querySelector("i.bi-heart-fill");
    heart.addEventListener("click", function () {

        if (heart.classList.contains("bi-heart-fill")) {
            heart.classList.remove("bi-heart-fill");
            heart.classList.add("bi-heart");
        } else {
            heart.classList.remove("bi-heart");
            heart.classList.add("bi-heart-fill");
        }
    });
-->
<script>
    function setRating(rating) {
        var stars = document.getElementsByClassName("rate");
        for (var i = 0; i < rating; i++) {
            stars[i].classList.add("checked");
        }
        for (var i = rating; i < stars.length; i++) {
            stars[i].classList.remove("checked");
        }
    }


//    document.addEventListener('DOMContentLoaded', function () {
//        var tableDates = document.querySelectorAll('.table-date');
//        var inputIndex = 1;
//
//        // Duy?t qua t?ng ô và thêm th? input
//        for (var i = 1; i < tableDates.length; i++) {
//            var tableDate = tableDates[i];
//
//            // Ki?m tra n?u class ch?a "nil"
//            if (tableDate.classList.contains('nil')) {
//                continue; 
//            }
//
//            var inputValue = tableDate.textContent;
//
//            
//            var inputElement = document.createElement('input');
//            inputElement.setAttribute('disable', );
//            inputElement.setAttribute('name', '' + 'day');
//            inputElement.setAttribute('value', '' + inputIndex);
//            inputElement.setAttribute('style', 'border: none; background: none; width:16px');
//            inputElement.value = inputValue;
//
//            tableDate.innerHTML = '';
//            tableDate.appendChild(inputElement);
//
//            inputIndex++;
//        }
//    });
    document.addEventListener('DOMContentLoaded', function () {
        var tableDates = document.querySelectorAll('.table-date');
        var inputIndex = 1; // Bi?n m?i ?? theo dõi s? l??ng input th?c t?

        // Duy?t qua t?ng ô và thêm th? input
        for (var i = 0; i < tableDates.length; i++) {
            var tableDate = tableDates[i];

            // Ki?m tra n?u class ch?a "nil"
            if (tableDate.classList.contains('nil')) {
                continue; // B? qua ô có l?p "table-date nil"
            }

            var inputValue = tableDate.textContent;

            // T?o th? input và gán giá tr? value
            var inputElement = document.createElement('input');
            inputElement.setAttribute('type', 'text');
            inputElement.setAttribute('name', 'day');
            inputElement.setAttribute('value', '' + inputIndex);
            inputElement.setAttribute('style', 'border: none; background: none; width:16px');
            inputElement.value = inputValue;

            // Thay th? n?i dung c?a ô b?ng th? input
            tableDate.innerHTML = '';
            tableDate.appendChild(inputElement);

            inputIndex++; // T?ng giá tr? c?a inputIndex
        }
    });

    document.addEventListener('DOMContentLoaded', function() {
        var spanValue = document.getElementById("label").innerText;
        document.getElementById("year").value = spanValue;
    });
</script>
