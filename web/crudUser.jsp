<%-- 
    Document   : crudUser
    Created on : Mar 2, 2020, 3:57:04 PM
    Author     : NT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--  <meta name="description" content="">
          <meta name="author" content="Dashboard">
          <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">-->
        <title>Dashio - Bootstrap Admin Template</title>

        <!-- Favicons -->
        <link href="img/favicon.png" rel="icon">
        <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Bootstrap core CSS -->
        <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--external css-->
        <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="lib/bootstrap-fileupload/bootstrap-fileupload.css" />
        <link rel="stylesheet" type="text/css" href="lib/bootstrap-datepicker/css/datepicker.css" />
        <link rel="stylesheet" type="text/css" href="lib/bootstrap-daterangepicker/daterangepicker.css" />
        <link rel="stylesheet" type="text/css" href="lib/bootstrap-timepicker/compiled/timepicker.css" />
        <link rel="stylesheet" type="text/css" href="lib/bootstrap-datetimepicker/datertimepicker.css" />
        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/style-responsive.css" rel="stylesheet">

        <!-- =======================================================
          Template Name: Dashio
          Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
          Author: TemplateMag.com
          License: https://templatemag.com/license/
        ======================================================= -->
    </head>

    <body>
        <section id="container">
            <!-- **********************************************************************************************************************************************************
                TOP BAR CONTENT & NOTIFICATIONS
                *********************************************************************************************************************************************************** -->
            <!--header start-->
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <!--logo start-->
                <a href="index.html" class="logo"><b>MANAGE<span> WEB</span></b></a>
                <!--logo end-->
               
                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <li><a class="logout" href="LogoutAction">Logout</a></li>
                    </ul>
                </div>
            </header>
            <!--header end-->
            <!-- **********************************************************************************************************************************************************
                MAIN SIDEBAR MENU
                *********************************************************************************************************************************************************** -->
            <!--sidebar start-->
            <aside>
                <div id="sidebar" class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">
                        <p class="centered"><a href="profile.html"><img src="img/ui-sam.jpg" class="img-circle" width="80"></a></p>
                        <h5 class="centered">
                            <s:property value="%{#session.User.userName}"/>
                        </h5>
                        <li class="mt">
                            <a href="admin.jsp">
                                <i class="fa fa-book"></i>
                                <span>Device statistics</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a class="active" href="javascript:;">
                                <i class="fa fa-desktop"></i>
                                <span>CRUD</span>
                            </a>
                            <ul class="sub">
                                <li class="active" ><a href="crudUser.jsp">Users</a></li>
                                <li><a href="crudRoom.jsp">Rooms</a></li>
                                <li><a href="crudDevice.jsp">Devices</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="adminNoti.jsp">
                                <i class="fa fa-envelope"></i>
                                <span>Notification </span>
                            </a>
                        </li>
                    </ul>
                    <!-- sidebar menu end-->
                </div>
            </aside>
            <!--sidebar end-->
            <!-- **********************************************************************************************************************************************************
                MAIN CONTENT
                *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <h3><i class="fa fa-bar-chart-o"></i> User</h3>
                    <div class="row mt">
                        <!--  DATE PICKERS -->
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <form action="SearchUserAction" class="form-horizontal style-form" method="POST">
                            
                            <div class="form-group">
                                <label class="control-label col-md-3">User ID</label>
                                <div class="col-md-3 col-xs-11">
                                    <input class="form-control form-control-inline input-medium " value="${requestScope.SearchUser}"  size="16" type="text" name="searchUser" />
                                </div>
                                 
                                <div class="col-md-3 col-xs-11">
                                    <button type="submit" class="btn btn-primary btn-lg btn-block">Search</button>
                                </div>
                            </div>
                            <div class="form-group">
                               <label class="control-label col-md-3">Create a User</label>
                               <a href="createUser.jsp">
                                   <button type="button" class="btn btn-warning">Create</button>
                               </a>
                               
                            </div>


                            </form>
</div>
                        </div>
                        <!-- /form-panel -->
                    </div>

                    <!--table--------------------------->
                    <h3><s:property value="%{#request.ERROR}"/></h3>
                    <s:if test="listUser != null">
                        <div class="row mt">
                            <div class="col-md-12">
                                <div class="content-panel">
                                    <table class="table table-striped table-advance table-hover">
                                        <h4><i class="fa fa-angle-right"></i>Result Table</h4>
                                        <hr>
                                        <thead>
                                            <tr>
                                                <th><i class="fa fa-star">No</th>
                                                <th><i class="fa fa-bullhorn"></i>ID User</th>
                                                <th class="hidden-phone"><i class="fa fa-question-circle"></i> Name</th>
                                                <th><i class="fa fa-toggle-left "></i>Room</th>
                                                <th><i class="fa fa-bookmark"></i>Role</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <s:iterator value="listUser" status="counter">
                                                <tr>
                                                    <th>
                                                        <s:property value="%{#counter.count}"></s:property>
                                                        </th>
                                                        <td>
                                                        <s:property value="userID"></s:property>
                                                        </td>
                                                        <td class="hidden-phone"><s:property value="userName"></s:property></td>
                                                    <th><s:property value="room"></s:property></th>
                                                    <td><s:property value="role"></s:property> </td>
                                                        <td>
                                                            <form action="EditUserAction" method="POST">
                                                                <input type="hidden" name="userId" value="<s:property value="userID"></s:property>"/>
                                                                <button type="submit" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                                            </form>


                                                        </td>
                                                        <th>
                                                            <form action="DeleteUserAction" method="POST">
                                                                <input type="hidden" name="idUser" value=" <s:property value="userID"></s:property>"/>
                                                                <input type="hidden" name="searchUser" value="${requestScope.SearchUser}"/>
                                                            <button type="submit"class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                                            </form>
                                                            
                                                        </th>
                                                    </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </s:if>


                </section>
                <!-- /wrapper -->
            </section>
            <!-- /MAIN CONTENT -->
            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    <p>
                        &copy; Copyrights <strong>Dashio</strong>. All Rights Reserved
                    </p>
                    <div class="credits">
                        <!--
                          You are NOT allowed to delete the credit link to TemplateMag with free version.
                          You can delete the credit link only if you bought the pro version.
                          Buy the pro version with working PHP/AJAX contact form: https://templatemag.com/dashio-bootstrap-admin-template/
                          Licensing information: https://templatemag.com/license/
                        -->
                        Created with Dashio template by <a href="https://templatemag.com/">TemplateMag</a>
                    </div>
                    <a href="advanced_form_components.html#" class="go-top">
                        <i class="fa fa-angle-up"></i>
                    </a>
                </div>
            </footer>
            <!--footer end-->
        </section>
        <!-- js placed at the end of the document so the pages load faster -->
        <script src="lib/jquery/jquery.min.js"></script>
        <script src="lib/bootstrap/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
        <script src="lib/jquery.scrollTo.min.js"></script>
        <script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
        <!--common script for all pages-->
        <script src="lib/common-scripts.js"></script>
        <!--script for this page-->
        <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
        <script type="text/javascript" src="lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
        <script type="text/javascript" src="lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="lib/bootstrap-daterangepicker/date.js"></script>
        <script type="text/javascript" src="lib/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script type="text/javascript" src="lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript" src="lib/bootstrap-daterangepicker/moment.min.js"></script>
        <script type="text/javascript" src="lib/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
        <script src="lib/advanced-form-components.js"></script>

    </body>

</html>
