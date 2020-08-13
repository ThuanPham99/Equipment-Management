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
        <title>Device repair history Page</title>

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
                            <a class="active">
                                <i class="fa fa-book"></i>
                                <span> Device repair history</span>
                            </a>
                        </li>
                        <s:if test="role == 'user'">
                            <li class="mt">
                                <a href="user.jsp">
                                    <i class="fa fa-book"></i>
                                    <span>Back</span>
                                </a>
                            </li>
                        </s:if>
                        <s:if test="role == 'admin'">
                            <li class="mt">
                                <a href="crudDevice.jsp">
                                    <i class="fa fa-book"></i>
                                    <span>Back</span>
                                </a>
                            </li>
                        </s:if>
                            <s:if test="role == 'repairer'">
                            <li class="mt">
                                <a href="searchDeviceByRepaier.jsp">
                                    <i class="fa fa-book"></i>
                                    <span>Back</span>
                                </a>
                            </li>
                        </s:if>


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
                    <h3><i class="fa fa-bar-chart-o"></i>Device repair history</h3>

                    <!--table--------------------------->
                    <h3><s:property value="%{#request.NOTF}"/></h3>
                    <s:if test="dtos != null">
                        <div class="row mt">
                            <div class="col-md-12">
                                <div class="content-panel">
                                    <table class="table table-striped table-advance table-hover">
                                        <h4><i class="fa fa-angle-right"></i>ID Device : <s:property value="ID"></s:property> </h4>
                                            <hr>
                                            <thead>
                                                <tr>
                                                    <th><i class="fa fa-star">No</th>
                                                    <th class="hidden-phone"><i class="fa fa-question-circle"></i> Time Request</th>
                                                    <th><i class="fa fa-toggle-left "></i>Description</th>
                                                    <th><i class="fa fa-bookmark"></i>Sender</th>
                                                    <th><i class="fa fa-toggle-left "></i>Repairer</th>
                                                    <th><i class="fa fa-bullhorn"></i>Time Done</th>
                                                    <th>Result</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            <s:iterator value="dtos" status="counter" >
                                                <tr>
                                                    <th>
                                                        <s:property value="%{#counter.count}"></s:property>
                                                        </th>
                                                        <td><s:property value="timeRequest"></s:property></td>
                                                    <th><s:property value="description"></s:property></th>
                                                    <td><s:property value="sender"></s:property> </td>
                                                    <td><s:property value="repairer"></s:property> </td>
                                                    <td><s:property value="timeDone"></s:property></td>
                                                        <td><span class="label label-warning label-mini">
                                                            <s:if test="result == 1">
                                                                SUCCESS
                                                            </s:if>
                                                            <s:else>
                                                                FALSE
                                                            </s:else>

                                                        </span></td>

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

