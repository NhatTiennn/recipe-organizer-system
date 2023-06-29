<%-- 
    Document   : editPro
    Created on : Jun 23, 2023, 9:24:28 PM
    Author     : phamt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="col-12 col-md-8 col-lg-8"  >
    <div class="container">
        <div class="row">
            <div class="personal-info col-12 col-md-12 col-lg-12"
                 style="background-color: white; margin-bottom: 50px;margin-top: 50px;border-bottom-style: solid; border-color:whitesmoke; border-width: 1px;border-radius: 10px;">
                <div class="personal-info-heading col-12 col-md-12 col-lg-12" style="    border-bottom-style: solid;
                     border-width: 2px;
                     border-color: whitesmoke;">
                    <div class="col-12 col-md-12 col-lg-12" style="margin-top: 30px;">
                        <h2>My Profile</h2>
                    </div>
                    <div class="col-12 col-md-12 col-lg-12" style="margin-top: 30px; ">
                        <p></p>

                    </div>
                </div>
                <div class="personal-info-body col-12 col-md-12 col-lg-12" style="margin-top:10px; ">
                    <form action="<c:url value="/user/profile_handler.do"/>" method="post">
                        <input type="hidden" class="form-control" id="id" name="userID" placeholder="id" value="${user.userID}">
                        <div class="form-group first">
                            <label for="name">User Name</label>
                            <input type="text" class="form-control" placeholder="Your name" id="firstName" name="userName" value="${user.userName}">
                        </div>
                        <div class="form-group first">
                            <label for="name">Image</label>
                            <input type="text" class="form-control" placeholder="Image" id="lastName" name="imageUser" value="${user.imageUser}">
                        </div>
                        <div class="form-group first">
                            <label for="phone">Phone</label>
                            <input type="text" class="form-control" placeholder="Your phone" id="phone" name="phone" value="${user.phone}">
                        </div>
                        <div class="form-group first">
                            <label for="dob">Date of birth</label>
                            <input type="date" class="form-control" placeholder="" id="dob" name="dob" value="${user.dob}">
                        </div>
                        <div class="mb-3">
                            <label for="gender" class="form-label">Gender:</label>
                            <input type="radio" name="gender" <c:if test="${user.gender == 'false'}">checked="checked"</c:if> value="0" required="required">Male
                            <input type="radio" name="gender" <c:if test="${user.gender == 'true'}">checked="checked"</c:if> value="1" required="required">Female
                        </div>
                        <p style="color:red">${message}</p>
                        <p style="color:green">${success}</p>
                        <button type="submit" name="op" value="save" class="btn btn-success">Confirm</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

