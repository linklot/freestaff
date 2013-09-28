<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Free Staff</title>
<link type="text/css" rel="stylesheet" href="${request.contextPath}<tiles:getAsString name='css'/>"/>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,400italic,700,700italic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="/res/js/jquery.js"></script>
</head>
<body>
<!--  header -->
<header>
    <div id="top_bar">
        <div class="wrapper">
            <div class="signout"><a href='<c:url value="j_spring_security_logout"/>'>Sign out</a></div>
            <div class="greeting">Welcome, <c:out value="${user.candidate.firstName}"/>.
            <div class="clearFloat"></div>
            </div>
        </div>
    </div>
    <div class="wrapper">
        <h1>
            <a href="/" id="logo">Free Staff</a>
        </h1>
        <div class="clearFloat"></div>
    </div>
    <nav>
        <ul id="menu">
            <li class="alpha">
                <a href="/">
                    <span>
                        <span>Home</span>
                    </span>
                </a>
            </li>
            <li id="menu_active">
                <a href="/candidate">
                    <span>
                        <span>Candidate</span>
                    </span>
                </a>
            </li>
            <li>
                <a href="/employer">
                    <span>
                        <span>Employer</span>
                    </span>
                </a>
            </li>
            <li>
                <a href="/about">
                    <span>
                        <span>About</span>
                    </span>
                </a>
            </li>
            <li class="omega">
                <a href="/sitemap">
                    <span>
                        <span>Sitemap</span>
                    </span>
                </a>
            </li>
        </ul>
        <div class="clearFloat"></div>
    </nav>
</header>
<!-- end of header -->

<!-- body -->
<tiles:insertAttribute name="content"/>
<!-- end of body -->

<!-- footer -->
<footer>
    &copy; COPYRIGHT FreeStaff 2013
    <a href="http://www.freestaff.com.au/">www.freestaff.com.au</a>
    <br>
    3D Models provided by
    <a href="http://www.templates.com/product/3d-models/" target="_blank" rel="nofollow">www.templates.com</a>
</footer>
<!-- end of footer -->
</body>
</html>