<%-- 
    Document   : login
    Created on : Jun 23, 2023, 9:24:11 PM
    Author     : phamt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="<c:url value="/login/fonts/icomoon/style.css"/>">

        <link rel="stylesheet" href="<c:url value="/login/css/owl.carousel.min.css"/>">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="<c:url value="/login/css/bootstrap.min.css"/>">

        <!-- Style -->
        <link rel="stylesheet" href="<c:url value="/login/css/style.css"/>">

        <title>Login #2</title>
    </head>
    <body>
        <div class="d-lg-flex half">
            <div class="bg order-1 order-md-2" style="background-image: url('<c:url value="/login/img/bg_1.jpg"/>');"></div>
            <div class="contents order-2 order-md-1">
                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-7">
                            <h3>Login to <strong>Flavorful Creations</strong></h3>
                            <p class="mb-4">Enter your User Name and Password </p>

                            <!--FORM LOGIN-->
                            <form action="<c:url value="/user/login_handler.do"/>" method="post">
                                <div class="form-group first">
                                    <label for="username">Email</label>
                                    <input type="text" class="form-control" placeholder="your-email@gmail.com" id="gmail" name="gmail">
                                </div>
                                <div class="form-group last mb-3">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" placeholder="Your Password" id="password" name="password">
                                </div>
                                <p style="color:red">${message}</p>
                                <div class="d-flex mb-5 align-items-center">
                                    <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                                        <input type="checkbox" checked="checked" name="rem"/>
                                        <div class="control__indicator"></div>
                                    </label>
                                    <span class="ml-auto"><a href="<c:url value="/user/forgot.do"/>" class="forgot-pass">Forgot Password</a></span> 
                                </div>
                                <input type="submit" value="Login" class="btn btn-block btn-primary" name="op">
                                <input type="submit" value="Cancel" class="btn btn-block btn-primary" name="op">
                            </form>

                            <!-- END FORM -->
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <script src="<c:url value="/login/js/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/login/js/popper.min.js"/>"></script>
        <script src="<c:url value="/login/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/login/js/main.js"/>"></script>
    </body>
</html>
