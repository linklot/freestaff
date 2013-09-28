<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FreeStaff</title>
<link type="text/css" rel="stylesheet" href="${request.contextPath}<tiles:getAsString name='css'/>"/>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,400italic,700,700italic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
</head>
<body>
<!--  header -->
<header>
    <div class="wrapper">
        <h1>
            <a href="/" id="logo">Free Staff</a>
        </h1>
        <div class="clearFloat"></div>
    </div>
    <nav>
        <ul id="menu">
            <li class="alpha" id="menu_active">
                <a href="/">
                    <span>
                        <span>Home</span>
                    </span>
                </a>
            </li>
            <li>
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
                <a href="#">
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