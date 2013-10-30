<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Freestaff - Skilled Migrant Solutions</title>
<link type="text/css" rel="stylesheet" href="${request.contextPath}<tiles:getAsString name='css'/>">
<script type="text/javascript" src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
</head>
<body>
<!--  header -->
<header>
    <div id="top_bar">
        <div class="wrapper">
            <div class="signout"></div>
            <div class="greeting">
                Welcome, <c:out value="${user.candidate.firstName}"/>
                <c:out value="${user.candidate.lastName}"/>
            <div class="clearFloat"></div>
            </div>
        </div>
    </div>
    <div class="wrapper">
        <h1>
            <a href="/" id="logo"><img src="/res/image/freestaff_logo.png"/></a>
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
                <a href="#">
                    <span>
                        <span>Employer</span>
                    </span>
                </a>
            </li>
            <li>
                <a href="#">
                    <span>
                        <span>JOBS</span>
                    </span>
                </a>
            </li>
            <li class="omega">
                <a href="/about">
                    <span>
                        <span>ABOUT</span>
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
    Freestaff &copy; 2013
    <br>
    <a href="/credit" target="_blank">Credit</a>
</footer>
<!-- end of footer -->
</body>
</html>