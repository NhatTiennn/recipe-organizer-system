<%-- 
    Document   : favorite
    Created on : Jun 26, 2023, 10:53:37 PM
    Author     : phamt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<div style="background-color: rgba">
    <div class="container">
        <div class="row">
            <div class="col-12 col-md-12 col-lg-12" style="text-align: center;"><h1>Liked</h1></div>
            <c:if test="${size == 0 and user != null}">
                <p class="text-center align-content-lg-center">Don't have anything here</p>
            </c:if>
            <c:if test="${user != null}">
                <c:forEach var="favorite" items="${favorite}">
                    <div class="col-6 col-md-3 col-lg-3 my-favorite">
                        <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                            <!-- Post Thumb -->
                            <div class="post-thumb">
                                <a>
                                    <img src="${favorite.imageRecipe}" alt="" style="height: 180px; width: 100%; margin-bottom: 10px">
                                </a>
                            </div>
                            <!-- Post Content -->
                            <div class="post-content">
                                <div class="row">

                                    <div class="col-10 col-md-10 col-lg-10" style="text-align: center">
                                        <a href="<c:url value="/recipe/recipeDetail.do?recipeID=${favorite.recipeID}"/>"
                                           <h4 class="post-headline" style="text-align: center; font-size: 27px">${favorite.recipeName}</h4>
                                        </a>
                                    </div>
                                    <div class="col-2 col-md-2 col-lg-2">
                                        <a class=" material-symbols-outlined nav-item dropdown" href="#" id="yummyDropdown" role="button"
                                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black;float:right; padding: 0.5rem 0rem">more_vert</a>
                                        <div class="dropdown-menu" aria-labelledby="yummyDropdown">
                                            <form action="<c:url value="/save_favorite/removeFromFavourite.do?favoriteRecipeID=${favorite.favoriteRecipeID}"/>" method="POST">
                                                  <input class="dropdown-item" type="submit" name="op" value="Remove">
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach> 
            </c:if>

            <c:if test="${user == null}">
                <p>Please Sign in to view your recipe</p>
            </c:if>
        </div>
    </div>
</div>
