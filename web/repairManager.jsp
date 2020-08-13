
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
        <title>Mail Repair Page</title>

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
                        <li class="active" class="mt">
                            <a href="repairer.jsp">
                                <i class="fa fa-book"></i>
                                <span>Request Repair</span>
                            </a>
                        </li>
                        <li>
                            <a    href="searchDeviceByRepaier.jsp">
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
                    <!-- page start-->
                    <div class="row mt">
                        <div class="col-sm-3">
                            <section class="panel">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked mail-nav">
                                        <li ><a href="repairer.jsp"> <i class="fa fa-inbox"></i>Request repairs</a></li>
                                        <li class="active"><a href="repairManager.jsp"> <i class="fa fa-envelope-o"></i>My Repair Manager</a></li>

                                    </ul>
                                </div>
                            </section>
                        </div>


                        <div class="col-sm-9">
                            <section class="panel">

                                <div class="panel-body minimal">
                                    <div class="mail-option">

                                        <div class="btn-group">
                                            <form action="LoadMyRepairAction" method="POST">
                                                <input type="hidden" name="myID" value="<s:property value="%{#session.User.userID}"/>"/>
                                                <button type="submit" class="btn btn-default">Load My repair Mail</button>
                                                </a>
                                            </form>
                                            <h3><s:property value="%{#request.ERROR}"/></h3>

                                        </div>

                                    </div>
                                    <div class="table-inbox-wrap ">

                                        <!--table--------------------------->
                                        <s:if test="listWork != null">
                                            <div class="row mt">
                                                <div class="col-md-12">
                                                    <div class="content-panel">
                                                        <table class="table table-striped table-advance table-hover">
                                                            <hr>
                                                            <thead>
                                                                <tr>
                                                                    <th>No</th>
                                                                    <th>Sender</th>
                                                                    <th>Context</th>
                                                                    <th>Time</th>
                                                                    <th>Type</th>
                                                                    <th>DeviceID need fix</th>
                                                                    <th>Complete Repair</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>

                                                                <s:iterator value="listWork" status="counter" >
                                                                    <tr>
                                                                        <th>
                                                                            <s:property value="%{#counter.count}"></s:property>
                                                                            </th>
                                                                            <td><s:property value="sender"></s:property></td>
                                                                        <th><s:property value="mailContext"></s:property></th>
                                                                        <td><s:property value="time"></s:property></td>
                                                                        <td><s:property value="type"></s:property></td>
                                                                        <td><s:property value="deviceID"></s:property></td>

                                                                            <th>
                                                                                <form action="CompleteRepairAction" method="POST">
                                                                                    <input type="hidden" name="sender" value="<s:property value="sender"></s:property>"/>
                                                                                <input type="hidden" name="timeRequest" value="<s:property value="time"></s:property>"/>
                                                                                <input type="hidden" name="typeNoti" value="<s:property value="type"></s:property>"/>
                                                                                <input type="hidden" name="receiver" value="<s:property value="%{#session.User.userID}"/>"/>
                                                                                <input type="hidden" name="deviceID" value="<s:property value="deviceID"></s:property>"/>
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
