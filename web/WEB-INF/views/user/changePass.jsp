<%-- 
    Document   : editPro
    Created on : Jun 23, 2023, 9:24:28 PM
    Author     : phamt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-12 col-md-8 col-lg-8"  >
    <div class="container">
        <div class="row">
            <div class="personal-info col-12 col-md-12 col-lg-12"
                 style="background-color: white; margin-bottom: 50px;margin-top: 50px;border-bottom-style: solid; border-color:whitesmoke; border-width: 1px;border-radius: 10px;">
                <div class="personal-info-heading col-12 col-md-12 col-lg-12" style="    border-bottom-style: solid;
                     border-width: 2px;
                     border-color: whitesmoke;">
                    <div class="col-12 col-md-12 col-lg-12" style="margin-top: 30px;">
                        <h2>Change password</h2>
                    </div>
                    <div class="col-12 col-md-12 col-lg-12" style="margin-top: 30px; ">
                        <p></p>

                    </div>
                </div>
                <div class="personal-info-body col-12 col-md-12 col-lg-12" style="margin-top:10px; ">
                    <form action="<c:url value="/user/changePass_handler.do?userID=${user.userID}"/>" method="post">
                        <input type="hidden" class="form-control" id="id" name="userID" placeholder="id" value="${user.userID}">
                        <div class="form-group first">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" placeholder="Old Password" id="Opassword" name="Opassword">
                        </div>
                        <div class="form-group first">
                            <label for="Npassword">New Password</label>
                            <input type="password" class="form-control" placeholder="New Password" id="Npassword" name="Npassword">
                        </div>
                        <div class="form-group first">
                            <label for="Cpassword">Confirm Password</label>
                            <input type="password" class="form-control" placeholder="Confirm Password" id="Cpassword" name="Cpassword">
                        </div>
                        <p style="color:red">${failed}</p>
                        <p style="color:green">${success}</p>
                        <button type="submit" name="op" value="save" class="btn btn-success">Confirm</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

