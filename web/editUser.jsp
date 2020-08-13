
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <title>Dashio - Bootstrap Admin Template</title>

        <!-- Favicons -->
        <link href="img/favicon.png" rel="icon">
        <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Bootstrap core CSS -->
        <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--external css-->
        <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
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
                            <a class="active">
                                <i class="fa fa-book"></i>
                                <span>Edit User</span>
                            </a>
                        </li>
                        <li class="mt">
                            <a href="crudUser.jsp">
                                <i class="fa fa-book"></i>
                                <span>Back</span>
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
                    <!-- /row -->
                    <div class="row mt">
                        <div class="col-lg-12">
                            <h4><i class="fa fa-angle-right"></i> Edit User</h4>
                            <div class="form-panel">
                                <div class="form">
                                    <form class="cmxform form-horizontal style-form" id="signupForm" method="get" action="UpdateUserAction">
                                        <div class="form-group ">
                                            <label for="firstname" class="control-label col-lg-2">User ID</label>
                                            <div class="col-lg-10">
                                                <input type="hidden" name="adminChange" value="<s:property value="%{#session.User.userID}"/>"/>
                                                <input class=" form-control" id="firstname" name="userID" type="text" readonly="true" value="<s:property value="dto.userID"></s:property>"/>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="lastname" class="control-label col-lg-2">User Name</label>
                                                <div class="col-lg-10">
                                                    <input class=" form-control" id="lastname" name="userName" type="text" required="required" title="UserName cant be blank" value="<s:property value="dto.userName"></s:property>"/>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="username" class="control-label col-lg-2">Room</label>
                                                <div class="col-lg-10">
                                                    <input class="form-control " id="username" name="room" type="text" required="required"title="room cant be blank" value="<s:property value="dto.room"></s:property>"/>
                                                <font color="red"><s:property value="userErrorOBj.room"></s:property></font>
                                            </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="username" class="control-label col-lg-2">Role</label>
                                                <div class="col-lg-10">
                                                    <input class="form-control " id="username" name="role" type="text" required="required" title="role cant be blank" value="<s:property value="dto.role"></s:property>" />
                                                <font color="red"><s:property value="userErrorOBj.role"></s:property></font>
                                            </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="username" class="control-label col-lg-2">Image</label>
                                                <div class="col-lg-10">
                                                    <input class="form-control " id="username" name="image" type="text" required="required" title="image cant be blank" value="<s:property value="dto.image"></s:property>" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">
                                                <button class="btn btn-theme" type="submit">Save</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <!-- /form-panel -->
                        </div>
                        <!-- /col-lg-12 -->
                    </div>
                    <!-- /row -->
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
                    <a href="form_validation.html#" class="go-top">
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
        <script src="lib/form-validation-script.js"></script>

    </body>

</html>
