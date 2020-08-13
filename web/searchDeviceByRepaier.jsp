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
        <title>Search Device Page</title>

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
                        <p class="centered"><a href="#"><img src="img/ui-sam.jpg" class="img-circle" width="80"></a></p>
                        <h5 class="centered">
                            <s:property value="%{#session.User.userName}"/>
                        </h5>
                        <li  class="mt">
                            <a href="repairer.jsp">
                                <i class="fa fa-book"></i>
                                <span>Request Repair</span>
                            </a>
                        </li>
                        <li>
                            <a class="active"   href="searchDeviceByRepaier.jsp">
                                <i class="fa fa-envelope"></i>
                                <span>Search Device</span>
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
                    <h3><i class="fa fa-bar-chart-o"></i>Device</h3>
                    <div class="row mt">
                        <!--  DATE PICKERS -->
                        <div class="col-lg-12">
                            <div class="form-panel">
                                <form action="SearchDeviceAction" class="form-horizontal style-form" method="POST">
                            
                            <div class="form-group">
                                <label class="control-label col-md-3">Device ID</label>
                                <div class="col-md-3 col-xs-11">
                                    <input type="hidden" name="role" value="<s:property value="%{#session.User.role}"/>"/>
                                    <input class="form-control form-control-inline input-medium " value="${requestScope.SearchDevice}"  size="16" type="text" name="searchDevice" />
                                </div>
                                 
                                <div class="col-md-3 col-xs-11">
                                    <button type="submit" class="btn btn-primary btn-lg btn-block">Search</button>
                                </div>
                            </div>


                            </form>
</div>
                        </div>
                        <!-- /form-panel -->
                    </div>

                    <!--table--------------------------->
                    <h3><s:property value="%{#request.ERROR}"/></h3>
                    <s:if test="listDevice != null">
                        <div class="row mt">
                            <div class="col-md-12">
                                <div class="content-panel">
                                    <table class="table table-striped table-advance table-hover">
                                        <h4><i class="fa fa-angle-right"></i>Result Table</h4>
                                        <hr>
                                        <thead>
                                            <tr>
                                                <th><i class="fa fa-star">No</th>
                                                <th><i class="fa fa-bullhorn"></i>ID Device</th>
                                                <th class="hidden-phone"><i class="fa fa-question-circle"></i> Name</th>
                                                <th><i class="fa fa-toggle-left "></i>Room</th>
                                                <th><i class="fa fa-bookmark"></i>Date of purchase</th>
                                                <th><i class="fa fa-toggle-left "></i>Number Repairs</th>
                                                 <th><i class="fa fa-bullhorn"></i>Status</th>
                                                <th>Change Room</th>
                                                <th>History Repairs</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <s:iterator value="listDevice" status="counter" >
                                                <tr>
                                                    <th>
                                                        <s:property value="%{#counter.count}"></s:property>
                                                        </th>
                                                        <td>
                                                        <s:property value="ID"></s:property>
                                                        </td>
                                                        <td class="hidden-phone"><s:property value="name"></s:property></td>
                                                    <th><s:property value="room"></s:property></th>
                                                    <td><s:property value="dateOfBuy"></s:property> </td>
                                                    <td><s:property value="numberOfRepairs"></s:property> </td>
                                                    <td><span class="label label-warning label-mini">
                                                                <s:if test="status == 1">
                                                                    Normal
                                                                </s:if>
                                                                <s:if test="status == 2">
                                                                    Damaged
                                                                </s:if>
                                                                <s:if test="status == 3">
                                                                    Repairing
                                                                </s:if>

                                                            </span></td>
                                                        <td>
                                                            
                                                            <form action="ChangeRoomByRepairerAction" method="POST">
                                                                <input type="hidden" name="room" value="<s:property value="room"></s:property>"/>
                                                                <input type="hidden" name="deviceID" value="<s:property value="ID"></s:property>"/>
                                                                <button type="submit" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                                            </form>


                                                        </td>
                                                        <th>
                                                            <form action="RHistoryAction" method="POST">
                                                                <input type="hidden" name="role" value="repairer"/>
                                                                 <input type="hidden" name="ID" value="<s:property value="ID"></s:property>"/>
                                                                <button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
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

