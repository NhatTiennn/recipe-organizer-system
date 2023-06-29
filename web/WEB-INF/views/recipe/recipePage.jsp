<%-- 
    Document   : recipePage
    Created on : Jun 25, 2023, 3:54:05 PM
    Author     : phamt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="blog_area section_padding_0_80">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 ">
                <!-- col-lg-8 -->
                <div class="row">
                    <div class="col-12 col-md-12 col-lg-12" style="text-align: center;">
                        <h2 style="margin-bottom: 30px;">All Recipes</h2>
                    </div>
                    <c:forEach var="recipe" items="${list}">
                        <c:if test="${recipe.status == 'false'}">
                            <div class="col-md-4">
                                <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                                    <!-- Post Thumb -->
                                    <div class="post-thumb">
                                        <img src="${recipe.imageRecipe}" alt="" style="height:220px ;width: 350px">
                                    </div>
                                    <!-- Post Content -->
                                    <div class="post-content">
                                        <div class="post-meta d-flex">
                                            <div class="post-author-date-area d-flex">
                                                <!-- Post Author -->
                                                <div class="post-author">
                                                    <a href="#">By ${recipe.userName}</a>
                                                </div>
                                                <!-- Post Date -->

                                            </div>
                                            <!-- Post Comment & Share Area -->
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star checked" style="margin-right: 10px;"></span>
                                            <span > 300 ratings</span>
                                        </div>
                                        <a href="<c:url value="/recipe/recipeDetail.do?recipeID=${recipe.recipeID}"/>">
                                            <h4 class="post-headline">
                                                ${recipe.recipeName}
                                            </h4>
                                        </a>

                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                    <div class="col-12">
                        <div class="pagination-area d-sm-flex mt-15">

                            <nav aria-label="#">
                                <ul class="pagination">
                                    <li class="page-item">
                                        <a class="page-link" href="<c:url value="/recipe/recipePage.do?page=${page-1}"/>"><i class="fa fa-angle-double-left" aria-hidden="true"></i> Previous</a>
                                    </li>
                                    <c:forEach var="i" begin="1" end="${endP}" step="1">
                                        <c:if test="${i  < page + 1}">
                                            <li class="page-item ${page == i?'active':''}">
                                                <a class="page-link" href="<c:url value="/recipe/recipePage.do?page=${i}"/>">${i}</a>
                                            </li>
                                        </c:if>

                                    </c:forEach>
                                    <li class="page-item">
                                        <a class="page-link" href="<c:url value="/recipe/recipePage.do?page=${page + 1}"/>">Next <i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
                                    </li>
                                </ul>
                            </nav>
                            <div class="page-status">
                                <p>Page ${page}</p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
