<%-- 
    Document   : index
    Created on : Jun 23, 2023, 11:48:33 AM
    Author     : phamt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- ****** Header Area End ****** -->

<!-- ****** Welcome Post Area Start ****** -->
<div id="slider">
    <div class="row">
        <div class="col-12 col-md-12 col-lg-12">
            <a href="categories.jsp">
                <img src="<c:url value="/img/sidebar-img/healthyfoodslogan.png"/>" alt="Trending" style="">
            </a>
        </div>
    </div>
</div>
<section class="categories_area clearfix" id="about">
    <div class="container">
        <div class="row">
            <div class="col-12 col-md-12 col-lg-12" style="text-align: center;">
                <h2 style="margin-bottom: 20px;">Recommended Categories</h2>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="single_catagory wow fadeInUp" data-wow-delay=".3s">
                    <img src="<c:url value="/img/sidebar-img/healthymain.jpeg"/>" alt="" style="width: 350px;height:220px">
                    <div class="catagory-title">
                        <a href="#">
                            <h5>Healthy Main Dishes</h5>
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="single_catagory wow fadeInUp" data-wow-delay=".6s">
                    <img src="<c:url value="/img/sidebar-img/green-salad.jpg"/>" alt="" style="width: 350px;height:220px">
                    <div class="catagory-title">
                        <a href="#">
                            <h5>Healthy Salad</h5>
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="single_catagory wow fadeInUp" data-wow-delay=".9s">
                    <img src="<c:url value="/img/catagory-img/3.jpg"/>" alt="" style="width: 350px;height:220px">
                    <div class="catagory-title">
                        <a href="#">
                            <h5>Eat clean</h5>
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-12 col-lg-12" style="text-align:  center;margin-top:30px">

                <a class="show-more-button" href="categories.jsp" style="border-radius: 30px;">Explore it</a>

            </div>
        </div>
    </div>
</section>
<!-- ****** Categories Area End ****** -->

<!-- ****** Blog Area Start ****** -->
<section class="blog_area section_padding_0_80">
    <div class="container">
        <div class="row">
            <div class="col-12 col-md-12 col-lg-12 " style="text-align: center;">
                <h2 style="margin-bottom: 30px;">Featuring Recipes</h2>
            </div>
            <div class="col-12 col-md-6 col-lg-6">
                <ul class="toptrending">
                    <li style="margin-bottom: 30px;">
                        <div class="row">
                            <div class="col-6 col-md-6">
                                <img src="<c:url value="/img/sidebar-img/cach-nau-pho-bo-nam-dinh-chuan-vi-thom-ngon-nhu-hang-quan-202201250230038502.jpg" />"
                                     alt="" style="width: 100%;">
                            </div>
                            <div class="col-6 col-md-6">
                                <a href="<c:url value="/pho.jsp"/>"><h3>Homemade Pho</h3></a>

                                <div class="post-comment-share-area d-flex">
                                    <!-- Post Favourite -->

                                    <!-- Post Comments -->
                                    <div class="post-comments" style="margin-bottom: 10px;">
                                        <a href="<c:url value="/asia.html"/>"><i class="" aria-hidden="true"></i>Healthy Main Dishes</a>
                                    </div>
                                    <!-- Post Share -->

                                </div>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star" style="margin-right: 10px;"></span>
                                <span > 300 ratings</span>

                            </div>

                        </div>

                    </li>
                    <li style="margin-bottom: 30px;">
                        <div class="row">
                            <div class="col-6 col-md-6">
                                <img src="<c:url value="/img/sidebar-img/steak_10_b1b1397477ea4c8ca1f215989632a614_1024x1024.jpg"/>"
                                     alt="" style="width: 100%;">
                            </div>
                            <div class="col-6 col-md-6">
                                <a href="<c:url value="/beefsteak.html"/>">
                                    <h5>Beefsteak</h5>
                                </a>

                                <div class="post-comment-share-area d-flex">
                                    <!-- Post Favourite -->

                                    <!-- Post Comments -->
                                    <div class="post-comments" style="margin-bottom: 10px;">
                                        <a href="#"><i class="" aria-hidden="true"></i>Healthy Main Dishes</a>
                                    </div>
                                    <!-- Post Share -->

                                </div>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star" style="margin-right: 10px;"></span>
                                <span > 264 ratings</span>

                            </div>

                        </div>

                    </li>
                    <li style="margin-bottom: 30px;">
                        <div class="row">
                            <div class="col-6 col-md-6">
                                <img src="<c:url value="/img/sidebar-img/chikenfries.jpg"/>" alt="" style="width: 100%;height: 95%;">
                            </div>
                            <div class="col-6 col-md-6">
                                <a href="<c:url value="/chickenfries.html"/>"><h5>Chicken Fries</h5></a>

                                <div class="post-comment-share-area d-flex">
                                    <!-- Post Favourite -->

                                    <!-- Post Comments -->
                                    <div class="post-comments" style="margin-bottom: 10px;">
                                        <a href="<c:url value="/america.html"/>"><i class="" aria-hidden="true"></i>Raw Food Diet</a>
                                    </div>
                                    <!-- Post Share -->

                                </div>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star" style="margin-right: 10px;"></span>
                                <span > 240 ratings</span>

                            </div>

                        </div>

                    </li>

                </ul>
            </div>
            <div class="col-12 col-md-6 col-lg-6">
                <ul class="toptrending">
                    <li style="margin-bottom: 30px;">
                        <div class="row">
                            <div class="col-6 col-md-6">
                                <img src="<c:url value="/img/sidebar-img/download (1).jpeg"/>" alt="" style="width: 100%;">
                            </div>
                            <div class="col-6 col-md-6">
                                <a href="">
                                    <h4>Easy spaghetti Bolognese
                                    </h4>
                                </a>

                                <div class="post-comment-share-area d-flex">
                                    <!-- Post Favourite -->

                                    <!-- Post Comments -->
                                    <div class="post-comments" style="margin-bottom: 10px;">
                                        <a href="#"><i class="" aria-hidden="true"></i>Healthy Main Dishes</a>
                                    </div>
                                    <!-- Post Share -->

                                </div>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star" style="margin-right: 10px;"></span>
                                <span > 300 ratings</span>

                            </div>

                        </div>

                    </li>
                    <li style="margin-bottom: 30px;">
                        <div class="row">
                            <div class="col-6 col-md-6">
                                <img src="<c:url value="/img/sidebar-img/Salmon-and-potato-parcels.jpg"/>" alt=""
                                     style="width: 100%;height: 95%;">
                            </div>
                            <div class="col-6 col-md-6">
                                <a href="<c:url value="/baked-salmon-recipes.html"/>">
                                    <h5>Baked Salmon & Leek parcel
                                    </h5>
                                </a>
                                <div class="post-comment-share-area d-flex">
                                    <!-- Post Favourite -->

                                    <!-- Post Comments -->
                                    <div class="post-comments" style="margin-bottom: 10px;">
                                        <a href="#"><i class="" aria-hidden="true"></i>Healthy Main Dishes</a>
                                    </div>
                                    <!-- Post Share -->

                                </div>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star" style="margin-right: 10px;"></span>
                                <span > 300 ratings</span>

                            </div>

                        </div>

                    </li>
                    <li style="margin-bottom: 30px;">
                        <div class="row">
                            <div class="col-6 col-md-6">
                                <img src="<c:url value="/img/sidebar-img/Aubergine&bean.png"/>" alt="" style="width: 100%; ">
                            </div>
                            <div class="col-6 col-md-6">

                                <h5>Aubergine & chickpea stew
                                </h5>
                                <div class="post-comment-share-area d-flex">
                                    <!-- Post Favourite -->

                                    <!-- Post Comments -->
                                    <div class="post-comments" style="margin-bottom: 10px;">
                                        <a href="#"><i class="" aria-hidden="true"></i>Healthy Main Dishes</a>
                                    </div>
                                    <!-- Post Share -->

                                </div>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star checked"></span>
                                <span class="fa fa-star" style="margin-right: 10px;"></span>
                                <span > 300 ratings</span>

                            </div>

                        </div>

                    </li>

                </ul>
            </div>

        </div>
    </div>
</section>
<!-- ****** Blog Area End ****** -->
<section class="blog_area section_padding_0_80">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 ">
                <!-- col-lg-8 -->
                <div class="row">
                    <div class="col-12 col-md-12 col-lg-12" style="text-align: center;">
                        <h2 style="margin-bottom: 30px;">Suggest Recipes</h2>
                    </div>
                    <div class="col-md-4">
                        <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                            <!-- Post Thumb -->
                            <div class="post-thumb">
                                <img src="<c:url value="/img/sidebar-img/bakedkalechips.jpeg"/>" alt="" style="height:220px ;width: 350px">
                            </div>
                            <!-- Post Content -->
                            <div class="post-content">
                                <div class="post-meta d-flex">
                                    <div class="post-author-date-area d-flex">
                                        <!-- Post Author -->
                                        <div class="post-author">
                                            <a href="#">By Thành Long</a>
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
                                <a href="#">
                                    <h4 class="post-headline">Baked Kale Chips
                                    </h4>
                                </a>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                            <!-- Post Thumb -->
                            <div class="post-thumb">
                                <img src="<c:url value="/img/sidebar-img/salmon.jpeg"/>" alt="" style="width: 350px">
                            </div>
                            <!-- Post Content -->
                            <div class="post-content">
                                <div class="post-meta d-flex">
                                    <div class="post-author-date-area d-flex">
                                        <!-- Post Author -->
                                        <div class="post-author">
                                            <a href="#">By Thành Long</a>
                                        </div>
                                        <!-- Post Date -->

                                    </div>
                                    <!-- Post Comment & Share Area -->
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star "></span>
                                    <span class="fa fa-star" style="margin-right: 10px;"></span>
                                    <span > 242 ratings</span>
                                </div>
                                <a href="#">
                                    <h4 class="post-headline">Maple Salmon
                                    </h4>
                                </a>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                            <!-- Post Thumb -->
                            <div class="post-thumb">
                                <img src="<c:url value="/img/sidebar-img/Miso_soup_blog_lg.jpg"/>" alt="">
                            </div>
                            <!-- Post Content -->
                            <div class="post-content">
                                <div class="post-meta d-flex">
                                    <div class="post-author-date-area d-flex">
                                        <!-- Post Author -->
                                        <div class="post-author">
                                            <a href="#">By Thành Long</a>
                                        </div>
                                        <!-- Post Date -->

                                    </div>
                                    <!-- Post Comment & Share Area -->
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star" style="margin-right: 10px;"></span>
                                    <span > 300 ratings</span>
                                </div>
                                <a href="#">
                                    <h4 class="post-headline">Miso Soup
                                    </h4>
                                </a>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                            <!-- Post Thumb -->
                            <div class="post-thumb">
                                <img src="<c:url value="/img/sidebar-img/green-salad.jpg"/>" alt="" style="width: 350px">
                            </div>
                            <!-- Post Content -->
                            <div class="post-content">
                                <div class="post-meta d-flex">
                                    <div class="post-author-date-area d-flex">
                                        <!-- Post Author -->
                                        <div class="post-author">
                                            <a href="#">By Thành Long</a>
                                        </div>
                                        <!-- Post Date -->

                                    </div>
                                    <!-- Post Comment & Share Area -->
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked" style="margin-right: 10px;"></span>
                                    <span > 30 ratings</span>
                                </div>
                                <a href="#">
                                    <h4 class="post-headline">Green Salad
                                    </h4>
                                </a>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                            <!-- Post Thumb -->
                            <div class="post-thumb">
                                <img src="<c:url value="/img/sidebar-img/hambuger.jpeg"/>" alt="" style="width: 320px;height: 220px">
                            </div>
                            <!-- Post Content -->
                            <div class="post-content">
                                <div class="post-meta d-flex">
                                    <div class="post-author-date-area d-flex">
                                        <!-- Post Author -->
                                        <div class="post-author">
                                            <a href="#">By Thành Long</a>
                                        </div>
                                        <!-- Post Date -->

                                    </div>
                                    <!-- Post Comment & Share Area -->
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star" style="margin-right: 10px;"></span>
                                    <span > 150 ratings</span>
                                </div>
                                <a href="#">
                                    <h4 class="post-headline">Hambuger Vegetables
                                    </h4>
                                </a>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                            <!-- Post Thumb -->
                            <div class="post-thumb">
                                <img src="<c:url value="/img/sidebar-img/best-pineapple-banana-smoothie-served-in-glassed-topped-with-fresh-pineapple-and-mint-leaves.jpg"/>" alt="" style="width: 350px">
                            </div>
                            <!-- Post Content -->
                            <div class="post-content">
                                <div class="post-meta d-flex">
                                    <div class="post-author-date-area d-flex">
                                        <!-- Post Author -->
                                        <div class="post-author">
                                            <a href="#">By Thành Long</a>
                                        </div>
                                        <!-- Post Date -->

                                    </div>
                                    <!-- Post Comment & Share Area -->
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star" style="margin-right: 10px;"></span>
                                    <span > 300 ratings</span>
                                </div>
                                <a href="#">
                                    <h4 class="post-headline">Pineapple and Banana Smoothie
                                    </h4>
                                </a>

                            </div>
                        </div>

                    </div>
                    <div class="col-md-4">
                        <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                            <!-- Post Thumb -->
                            <div class="post-thumb">
                                <img src="<c:url value="/img/sidebar-img/Salmon-and-potato-parcels.jpg"/>" alt="" style="width: 350px;height: 220px">
                            </div>
                            <!-- Post Content -->
                            <div class="post-content">
                                <div class="post-meta d-flex">
                                    <div class="post-author-date-area d-flex">
                                        <!-- Post Author -->
                                        <div class="post-author">
                                            <a href="#">By Thành Long</a>
                                        </div>
                                        <!-- Post Date -->

                                    </div>
                                    <!-- Post Comment & Share Area -->
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked" style="margin-right: 10px;"></span>
                                    <span > 230 ratings</span>
                                </div>
                                <a href="#">
                                    <h4 class="post-headline">Baked Salmon & Leek Parcel
                                    </h4>
                                </a>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                            <!-- Post Thumb -->
                            <div class="post-thumb">
                                <img src="<c:url value="/img/sidebar-img/cach-nau-pho-bo-nam-dinh-chuan-vi-thom-ngon-nhu-hang-quan-202201250230038502.jpg"/>" alt="" style="width: 320px;height: 220px">
                            </div>
                            <!-- Post Content -->
                            <div class="post-content">
                                <div class="post-meta d-flex">
                                    <div class="post-author-date-area d-flex">
                                        <!-- Post Author -->
                                        <div class="post-author">
                                            <a href="#">By Thành Long</a>
                                        </div>
                                        <!-- Post Date -->

                                    </div>
                                    <!-- Post Comment & Share Area -->
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked" style="margin-right: 10px;"></span>
                                    <span > 1050 ratings</span>
                                </div>
                                <a href="#">
                                    <h4 class="post-headline">Pho
                                    </h4>
                                </a>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-post wow fadeInUp" data-wow-delay=".4s">
                            <!-- Post Thumb -->
                            <div class="post-thumb">
                                <img src="<c:url value="/img/sidebar-img/comtam.jpg"/>" alt="" style="width: 350px;height: 220px">
                            </div>
                            <!-- Post Content -->
                            <div class="post-content">
                                <div class="post-meta d-flex">
                                    <div class="post-author-date-area d-flex">
                                        <!-- Post Author -->
                                        <div class="post-author">
                                            <a href="#">By Thành Long</a>
                                        </div>
                                        <!-- Post Date -->

                                    </div>
                                    <!-- Post Comment & Share Area -->
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star" style="margin-right: 10px;"></span>
                                    <span > 300 ratings</span>
                                </div>
                                <a href="#">
                                    <h4 class="post-headline">Broken Rice
                                    </h4>
                                </a>

                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-12 col-lg-12" style="text-align:  center;margin-top:30px">
                        <a class="show-more-button" href="recipespage.jsp" style="border-radius: 30px;">Show more</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
