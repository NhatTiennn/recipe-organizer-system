<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<section class="ftco-section">
    <div class="container">
        <div class="row">
            <button class="button" id="add-button" style="background-color: #fc6c3f">Add Recipe</button>

            <div class="col-md-12">
                <c:forEach var="saved" items="${list}">
                    <form action="<c:url value="/recipe/addPlan.do?savedRecipeID=${saved.savedRecipeID}"/>" method="post">
                        <div class="calendar-container" style="background-color: white; border:solid 1px #ebebeb">
                            <div class="calendar"> 
                                <div class="year-header"> 
                                    <span class="left-button fa fa-chevron-left" id="prev"> </span> 
                                    <span class="year" id="label" ></span>
                                    <input hidden type="text" id="year" name="years" value="2023" style="border: none; background: none;"/>
                                    <!--                                    CHECK T OR F-->
                                    <span class="right-button fa fa-chevron-right" id="next"> </span>
                                </div> 
                                <table class="months-table w-100"> 
                                    <tbody>
                                        <tr class="months-row">
                                            <td class="month"><input style="border: none; background: none; width: 30px"  type="text" name="month" value="01"></td> 
                                            <td class="month"><input style="border: none; background: none; width: 30px"  type="text" name="month" value="02"></td> 
                                            <td class="month"><input style="border: none; background: none; width: 30px"  type="text" name="month" value="03"></td> 
                                            <td class="month"><input style="border: none; background: none; width: 30px"  type="text" name="month" value="04"></td> 
                                            <td class="month"><input style="border: none; background: none; width: 30px"  type="text" name="month" value="05"></td> 
                                            <td class="month"><input style="border: none; background: none; width: 30px"  type="text" name="month" value="06"></td> 
                                            <td class="month"><input style="border: none; background: none; width: 30px"  type="text" name="month" value="07"></td>
                                            <td class="month"><input style="border: none; background: none; width: 30px"  type="text" name="month" value="08"></td> 
                                            <td class="month"><input style="border: none; background: none; width: 30px"  type="text" name="month" value="09"></td> 
                                            <td class="month"><input style="border: none; background: none; width: 30px"  type="text" name="month" value="10"></td>          
                                            <td class="month"><input style="border: none; background: none; width: 30px"  type="text" name="month" value="11"></td>
                                            <td class="month"><input style="border: none; background: none; width: 30px"  type="text" name="month" value="12"></td>
                                        </tr>
                                    </tbody>
                                </table> 

                                <table class="days-table w-100"> 
                                    <td class="day">Sun</td> 
                                    <td class="day">Mon</td> 
                                    <td class="day">Tue</td> 
                                    <td class="day">Wed</td> 
                                    <td class="day">Thu</td> 
                                    <td class="day">Fri</td> 
                                    <td class="day">Sat</td>
                                </table> 
                                <div class="frame"> 
                                    <table class="dates-table w-100"> 
                                        <tbody class="tbody">
                                        </tbody>
                                    </table>
                                </div> 

                            </div>
                        </div>
                        <div class="events-container" style="background-color: #fc6c3f">
                        </div>
                        <div class="dialog" id="dialog" style="background: #138496; height: 100%;">
                            <h2 class="dialog-header" style="border-bottom: solid 1px    "> Add Recipes </h2>


                            <div id="form"  style=" overflow-y: scroll; height: 63%; margin-left: 5%" >
                                <div class="single-widget-area popular-post-widget" style="width: 80%; ">
                                    <!-- Single Popular Post -->
                                    <div class="single-populer-post d-flex">
                                        <img src="${saved.imageRecipe}" alt="" style="height: 110px">
                                        <div class="post-content">
                                            <a href="#">
                                                <h6>${saved.recipeName}</h6>
                                            </a>
                                        </div>
                                        <label class="checkbox">
                                            <input type="checkbox" value="1" name="choose" id="flexCheckDefault">
                                            <span class="primary"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="single-widget-area popular-post-widget" style="text-align: center">
                                <input type="button" value="Cancel" class="button" id="cancel-button">
                                <input type="submit" value="Add" name="op" class="button button-white" id="ok-button">
                            </div>
                        </div>
                    </form>
                </c:forEach>
            </div>
        </div>
    </div>
</section>

<style>
    .pagination .page-item .page-link:hover {
        background-color: #eee;
        border-radius: .125rem;
        -webkit-transition: all .3s linear;
        transition: all .3s linear;
    }
    div.dataTables_wrapper div.dataTables_paginate ul.pagination {
        -webkit-box-pack: end;
        -webkit-justify-content: flex-end;
        -ms-flex-pack: end;
        justify-content: flex-end;
    }
    .pagination .page-item.active .page-link {
        color: #fff;
        background-color: #4285f4;
        border-radius: .125rem;
        -webkit-box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16), 0 2px 10px 0 rgba(0,0,0,0.12);
        box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16), 0 2px 10px 0 rgba(0,0,0,0.12);
        -webkit-transition: all .2s linear;
        transition: all .2s linear;
    }
    .pagination .page-item.not-select .page-link {
        color: #fff;
        background-color: #F4511E;
        border-radius: .125rem;
        -webkit-box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16), 0 2px 10px 0 rgba(0,0,0,0.12);
        box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16), 0 2px 10px 0 rgba(0,0,0,0.12);
        -webkit-transition: all .2s linear;
        transition: all .2s linear;
    }
    .pagination .page-item .page-link {
        font-size: .9rem;
        color: #212529;
        background-color: #776e6e2b;
        border: 0;
        margin-left: 4px;
        outline: 0;
        -webkit-transition: all .3s linear;
        transition: all .3s linear;
        margin-bottom: 15px;

    }
    .page-item.active .page-link {
        z-index: 3;
        color: #fff;
        background-color: #007bff;
        border-color: #007bff;
    }
    .page-link {
        position: relative;
        display: block;
        padding: .5rem .75rem;
        line-height: 1.25;
    }
    .footer {

        left: 0;
        bottom: 0;
        width: 100%;
        color: white;
        text-align: center;
    }
    .logo-area {

        background-repeat: no-repeat;
    }
    .logo-area {
        width: 260px;
        display: block;
        min-height: 60px;
        float: right;
    }

    .navbar {
        padding: .3rem 0.3rem !important;
    }




    /*radio button css*/

    @keyframes check {0% {height: 0;width: 0;}
                      25% {height: 0;width: 10px;}
                      50% {height: 20px;width: 10px;}
    }
    .checkboxRadio{
        background-color:#fff;
        display:inline-block;
        height:28px;
        margin:0 .25em;
        width:28px;
        border-radius:4px;
        border:1px solid #307196;
        float:left
    }
    .checkboxRadio span{
        display:block;
        height:28px;
        position:relative;
        width:28px;
        padding:0
    }
    .checkboxRadio span:after{
        -moz-transform:scaleX(-1) rotate(135deg);
        -ms-transform:scaleX(-1) rotate(135deg);
        -webkit-transform:scaleX(-1) rotate(135deg);
        transform:scaleX(-1) rotate(135deg);
        -moz-transform-origin:left top;
        -ms-transform-origin:left top;
        -webkit-transform-origin:left top;
        transform-origin:left top;
        border-right:4px solid #fff;
        border-top:4px solid #fff;
        content:'';
        display:block;
        height:20px;
        left:3px;
        position:absolute;
        top:15px;
        width:10px
    }
    .checkboxRadio span:hover:after{
        border-color:#999
    }
    .checkboxRadio input{
        display:none
    }
    .checkboxRadio input:checked + span:after{
        -webkit-animation:check .8s;
        -moz-animation:check .8s;
        -o-animation:check .8s;
        animation:check .8s;
        border-color:#555
    }
    .checkboxRadio input:checked + .default:after{
        border-color:#444
    }
    .checkboxRadio input:checked + .primary:after{
        border-color:#2874a1;
    }
    .timercss{
        font-size: 25px;
        font-family: cursive;
        color: #FFEB3B !important;
    }
    .list-group-item {
        padding: .45rem 1rem;
    }
    .list-group-flush label {
        margin-bottom: .0rem !important;
    }
    .pagination {
        display: -ms-flexbox;
        flex-wrap: wrap;
        display: flex;
        padding-left: 0;
        list-style: none;
        border-radius: 0.25rem;
    }
    .btn-circle {
        width: 30px;
        height: 30px;
        text-align: center;
        padding: 6px 0;
        font-size: 12px;
        line-height: 1.428571429;
        border-radius: 15px;
    }
    .btn-circle.btn-lg {
        width: 50px;
        height: 50px;
        padding: 10px 16px;
        font-size: 18px;
        line-height: 1.33;
        border-radius: 25px;
    }
    .btn-success1 {
        color: #525252;
        background-color: #e4e4e4;
        border-color: #9a9a9a;
    }
    .username {
        font-weight: 500;
    }
    .profile-block{
        margin:5px auto;
        position:relative;
        overflow:hidden;
    }
    .profile-block .nav > li > a {
        background: #e7e7e7;
        border-radius: 0;
        color: #000;
        display: block;
        font-size: 14px;
        padding: 6px 18px;
        position: relative;
        text-align: left;
        text-decoration: none;


    }
    .profile-block ul > li > a > i {
        color: #000;
        font-size: 16px;
        padding-right: 10px;
    }
    .profile-block ul > li > a:hover, 
    .profile-block ul > li > a:focus, 
    .profile-block ul li.active a {
        background: #fff !important;
        border-radius: 0;
        color: #000 !important;
    }
    li.paginate_button.page-item {
        z-index: 0;
    }

    .widget-title>h6 {
        background: #5ea4cc;
        height: 55px;
        width: 100%;
        font-size: 16px;
        line-height: 52px;
        border-radius: 2px;
        margin-bottom: 0px;
        text-transform: uppercase;
    } 


</style>


