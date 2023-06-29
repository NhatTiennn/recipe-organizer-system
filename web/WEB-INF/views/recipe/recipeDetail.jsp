<%-- 
    Document   : recipeDetail
    Created on : Jun 26, 2023, 2:14:47 PM
    Author     : phamt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="breadcumb-nav">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Categories</li>
                        <li class="breadcrumb-item active" aria-current="page">Keto</li>
                    </ol>
                </nav>
            </div>
        </div>
    </div>
</div>
<section class="blog_area section_padding_0_80">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-sm-12 col-md-4 col-lg-4">
                <div class="row">
                    <div class="col-12">
                        <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                            <div class="post-thumb">
                                <img src="${recipe.imageRecipe}" alt="StuffedChicken"/>
                            </div>  
                        </div>
                    </div>
                    <div class="col-4 col-md-4">
                        <div class="saved-favorite">
                            <form action="<c:url value="/save_favorite/addToSaved.do?recipeID=${recipe.recipeID}&userID=${user.userID}"/>" method="POST">
                                <input type="submit" name="op" value="Save"
                                       style="padding:8px 30px 8px 30px; background-color: #fc6c3f;border-radius: 12px;color: white;border: 2px solid ;">
                            </form>
                        </div>
                    </div>
                    <div class="col-4 col-md-4">
                        <div class="print-recipe">
                            <button onclick="window.print()"
                                    style="padding: 8px 40px 8px 40px;background-color:white ;border-radius: 12px;border: 2px solid #fc6c3f;color: #fc6c3f;">Print</button>
                        </div>
                    </div>
                    <div class="col-4 col-md-4">
                        <div class="saved-favorite">
                            <form action="MainController" method="POST">
                                <input type="submit" name="action" value="Share"
                                       style="padding:8px 30px 8px 30px; background-color: #fc6c3f;border-radius: 12px;color: white;border: 2px solid ;">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-12 col-sm-12 col-md-8 col-lg-8">
                <div class="post-content">
                    <a href="#">
                        <h1 class="post-headline" >${recipe.recipeName}</h1>
                    </a>
                    <div class="post-meta d-flex">
                        <div class="post-author-date-area d-flex">
                            <!-- Post Author -->
                            <div class="post-author">
                                By <a href="#" style="font-size: 14px;">${recipe.userName}</a>
                            </div>
                            <div class="star-rating">
                                <form action="<c:url value="/recipe/rating.do?userID=${user.userID}&recipeID=${recipe.recipeID}"/>" method="post">
                                    <button class="fa fa-star <c:if test="${rating.scoreUser >= 1}">checked</c:if>" onclick="setRating(1)" style="cursor: pointer; border: none; background: none;" name="op" value="one"></button>
                                    <button class="fa fa-star <c:if test="${rating.scoreUser >= 2}">checked</c:if>" onclick="setRating(2)" style="cursor: pointer; border: none; background: none;" name="op" value="two"></button>
                                    <button class="fa fa-star <c:if test="${rating.scoreUser >= 3}">checked</c:if>" onclick="setRating(3)" style="cursor: pointer; border: none; background: none;" name="op" value="three"></button>
                                    <button class="fa fa-star <c:if test="${rating.scoreUser >= 4}">checked</c:if>" onclick="setRating(4)" style="cursor: pointer; border: none; background: none;" name="op" value="four"></button>
                                    <button class="fa fa-star <c:if test="${rating.scoreUser == 5}">checked</c:if>" onclick="setRating(5)" style="cursor: pointer; border: none; background: none;" name="op" value="five"></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="row mt-4 mb-4">
                            <div class="col-4" style="display: flex;
                                 justify-content: start;
                                 align-items: center;
                                 gap: 1rem;padding-left: 34px;">
                                <span class="material-symbols-outlined" style="font-size:30px; color:black">
                                    star
                                </span>


                                <div>

                                    <span style="color:black; ">110 ratings</span>
                                </div>
                            </div>
                            <div class="col-4" style="display: flex;
                                 justify-content: center;
                                 align-items: center;
                                 gap: 1rem">
                                <i class="ti-comment bookmark" style="font-size:23px; color:black;"></i>
                                <span style="color:black; float: right;">${noFb} Feedback</span>
                        </div>
                    </div>       

                    <div class="row mt-4 mb-4">
                        <div class="col-4" style="display: flex;
                             justify-content: center;
                             align-items: center;
                             gap: 1rem">
                            <i class="ti-timer" style="font-size: 30px;"></i>
                            <div>
                                <span>Cooking: ${recipe.cookingTime} mins</span>
                            </div>
                        </div>

                        <div class="col-4" style="display: flex;
                             justify-content: center;
                             align-items: center;
                             gap: 1rem">
                            <i class="bi bi-heart-fill"  style="font-size:23px; color:black;cursor: pointer;"></i>
                            <span style="padding-left: 5px;"> Like: </span>
                        </div>

                        <div class="col-4" style="display: flex;
                             justify-content: center;
                             align-items: center;
                             gap: 1rem">
                            <c:if test="${save == null}">
                                <form action="<c:url value="/save_favorite/addToSaved.do?recipeID=${recipe.recipeID}&userID=${user.userID}"/>" method="POST">
                                    <button class="bi bi-bookmark"  style="font-size:23px; color:black;cursor: pointer; border: none;" type="submit" name="op" value="Save"></button>
                                </form>
                            </c:if>
                            <c:if test="${save != null}">
                                <form action="<c:url value="/save_favorite/removeFromSaved.do?recipeID=${recipe.recipeID}&userID=${user.userID}"/>" method="POST">
                                    <button class="bi bi-bookmark-fill"  style="font-size:23px; color:black;cursor: pointer; border: none;" type="submit" name="op" value="remove"></button>
                                </form>
                            </c:if>
                            <span style="padding-left: 5px;"> Saved: 10</span>
                        </div>
                    </div>
                    <p> 
                        ${recipe.description}
                    </p>
                    <div class="row " >
                        <div class="col-2 col-md-2 col-lg-12 mb-2">
                            <h4 style="background-color: #fafafa; text-align: center;" > <span><b>Nutrional</b></span></h4>
                        </div>
                        <div class="col-2 col-md-2 col-lg-2 "
                             style="background-color: beige;border-style: solid;border-width: 2px 0px 2px 2px;text-align: center;">
                            <span><b>kcal</b></span><br>
                            550
                        </div>
                        <div class="col-2 col-md-2 col-lg-2"
                             style="background-color: beige;border-style: solid;border-width: 2px 0px 2px 2px;text-align: center;">
                            <span><b>fat</b></span><br>
                            20
                        </div>
                        <div class="col-2 col-md-2 col-lg-2"
                             style="background-color: beige;border-style: solid;border-width: 2px 0px 2px 2px; text-align: center; ">
                            <span><b>protein</b></span><br>
                            1
                        </div>
                        <div class="col-2 col-md-2 col-lg-2"
                             style="background-color: beige;border-style: solid;border-width:2px 0px 2px 2px;text-align: center; ">
                            <span><b>carbs</b></span><br>
                            5
                        </div>
                        <div class="col-2 col-md-2 col-lg-2"
                             style="background-color: beige;border-style: solid;border-width: 2px 0px 2px 2px;text-align: center; ">
                            <span><b>sugars</b></span><br>
                            0g
                        </div>
                        <div class="col-2 col-md-2 col-lg-2"
                             style="background-color: beige;border-style: solid;border-width: 2px 2px 2px 2px;text-align: center;  ">
                            <span><b>salt</b></span><br>
                            1.42g

                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="row">
            <div class="col-12 col-md-5 col-lg-5 mt-5">
                <h4 style="background-color: #fafafa">Ingredients</h4>
                <ul style="background-color: #fafafa">
                    <li>- 450g chicken breasts</li>
                    <li>- 120g cream cheese</li>
                    <li>- 2 tbsp green pesto</li>
                    <li>- 2 tbsp Parmesan cheese, finely grated</li>
                    <li>- ½ tsp avocado oil</li>
                    <li>- ¼ tsp sea salt</li>
                    <li>- ¼ tsp ground black pepper</li>
                </ul>
            </div>
            <div class="col-12 col-md-5 col-lg-5 mt-5">
                <h4 style="background-color: #fafafa">Steps</h4>
                <div  style="background-color: #fafafa">
                    <h5>Step 1:</h5>
                    <p>Preheat the air fryer to 350°F (180°C).</p>
                    <h5>Step 2:</h5>
                    <P>Place the chicken breasts flat on a chopping board 
                        and slice a pocket into each breast horizontally.</P>

                    <h5>Step 3:</h5>
                    <p>Combine the cream cheese, pesto, and Parmesan cheese.</p>
                    <h5>Step 4:</h5>
                    <p>Spoon equal portions of the cheese mixture into the pockets
                        of the chicken breasts. Fold the top of the chicken breast over 
                        the filling and secure it with a toothpick.</p>
                    <h5>Step 5:</h5>
                    <p>Drizzle the avocado oil over the chicken breasts and rub it in.
                        Season on both sides with sea salt and ground black pepper.</p>
                    <h5>Step 6:</h5>
                    <p>Place the stuffed chicken breasts in the preheated air fryer 
                        and cook for 18-20 minutes until golden and cooked through.</p>
                    <h5>Step 7:</h5>
                    <p>Remove from the air fryer and serve with a green salad or your 
                        favorite veggies.</p>
                </div>

            </div>
        </div>

        <!--Comment -->
        <div class="container mt-9 mb-9">
            <div class="row height d-flex justify-content-center align-items-center">
                <div class="col-md-12" >
                    <div class="card">
                        <div class="p-4"  style="background-color: #fafafa">
                            <h4>Comments</h4>
                        </div>
                        <form action="<c:url value="/recipe/addFeedback.do"/>">
                            <div class="mt-3 d-flex flex-row align-items-center p-3 form-color">
                                <input type="number" hidden name="userID" value="${user.userID}">
                                <input type="number" hidden name="recipeID" value="${recipe.recipeID}">
                                <input type="text" hidden name="userName" value="${user.userName}">
                                <input type="text" class="form-control" placeholder="Enter your comment..." name="content">
                                <p class="small mb-0" style="color: #aaa;">
                                    <button type="submit" class="btn btn-outline-success">Post</button>
                                </p>
                            </div>
                        </form>
                        ${message}
                        <div class="mt-2"  style="background-color: #fafafa">
                            <c:forEach var="fb" items="${feedbacks}">
                                <c:if test="${fb.status == 'true'}">
                                    <div class="d-flex flex-row p-3"> 
                                        <img src="img/sidebar-img/HT.jpeg" width="40" height="40" class="rounded-circle mr-3">
                                        <div class="w-100" style="background-color: #fafafa">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div class="d-flex flex-row align-items-center"> 
                                                    <span class="mr-2">${fb.userName}</span> 
                                                </div> 
                                                <small>${fb.feedBackDate}</small>
                                            </div>
                                            <p class="text-justify comment-text mb-0">${fb.content}</p>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</section>
