
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
        <title>Mail Admin Page</title>

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
                <a  class="logo"><b>MANAGE<span> WEB</span></b></a>
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
                            <a  href="admin.jsp">
                                <i class="fa fa-book"></i>
                                <span>Device statistics</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;">
                                <i class="fa fa-desktop"></i>
                                <span>CRUD</span>
                            </a>
                            <ul class="sub">
                                <li><a href="crudUser.jsp">Users</a></li>
                                <li><a href="crudRoom.jsp">Rooms</a></li>
                                <li><a href="crudDevice.jsp">Devices</a></li>
                            </ul>
                        </li>

                        <li>
                            <a class="active" href="adminNoti.jsp">
                                <i class="fa fa-envelope"></i>
                                <span>Notification</span>
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
                    <!-- page start-->
                    <div class="row mt">
                        <div class="col-sm-3">
                            <section class="panel">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked mail-nav">
                                        <li class="active"><a href="adminNoti.jsp"> <i class="fa fa-inbox"></i>Request repairs</a></li>

                                    </ul>
                                </div>
                            </section>
                        </div>


                        <div class="col-sm-9">
                            <section class="panel">

                                <div class="panel-body minimal">
                                    <div class="mail-option">

                                        <div class="btn-group">
                                            <form action="LoadRequestRepairAction" method="POST">
                                                <input type="hidden" name="role" value="<s:property value="%{#session.User.role}"/>"/>
                                                <button type="submit" class="btn btn-default">Load Inbox Mail</button>
                                                </a>
                                            </form>
                                            <h3><s:property value="%{#request.ERROR}"/></h3>

                                        </div>

                                    </div>
                                    <div class="table-inbox-wrap ">

                                        <!--table--------------------------->
                                        <s:if test="listRequest != null">
                                            <div class="row mt">
                                                <div class="col-md-12">
                                                    <div class="content-panel">
                                                        <table class="table table-striped table-advance table-hover">
                                                            <hr>
                                                            <thead>
                                                                <tr>
                                                                    <th><i class="fa fa-star">No</th>
                                                                    <th class="hidden-phone"><i class="fa fa-question-circle"></i> Sender</th>
                                                                    <th><i class="fa fa-toggle-left "></i>Device to be repaired</th>
                                                                    <th><i class="fa fa-bookmark"></i>Time</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>

                                                                <s:iterator value="listRequest" status="counter" >
                                                                    <tr>
                                                                        <th>
                                                                            <s:property value="%{#counter.count}"></s:property>
                                                                            </th>
                                                                            <td><s:property value="sender"></s:property></td>
                                                                        <th><s:property value="deviceID"></s:property></th>
                                                                        <td><s:property value="time"></s:property> </td>

                                                                        </tr>
                                                                </s:iterator>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </s:if>

                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
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
                    <a href="inbox.html#" class="go-top">
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

    </body>

</html>
