<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FreeStaff Administrator</title>
<link type="text/css" rel="stylesheet" href="${request.contextPath}<tiles:getAsString name='css'/>"/>
<script type="text/javascript" src="http://codeorigin.jquery.com/jquery-1.10.2.min.js"></script>
<script src="/res/js/hideshow.js" type="text/javascript"></script>
<script src="/res/js/jquery.tablesorter.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/res/js/jquery.equalHeight.js"></script>
<script type="text/javascript" src="/res/js/admin/global.js"></script>
</head>
<body>
<!-- header -->
<header id="header">
    <hgroup>
        <h1 class="site_title">
            <a href="/admin">FreeStaff</a>
        </h1>
        <h2 class="section_title">Administration</h2>
    </hgroup>
</header>
<section id="secondary_bar">
    <div class="user">
        <p>
            <c:out value="${user.account}"/>
        </p>
        <a class="logout_user" href='<c:url value="/j_spring_security_logout"/>' title="Logout">Logout</a>

    </div>
    <div class="breadcrumbs_container">
        <article class="breadcrumbs">
            <a href="/admin">Website Admin</a>
            <div class="breadcrumb_divider"></div>
            <a class="current"><tiles:insertAttribute name="currLoc"/></a>
        </article>
    </div>
</section>
<!-- end of header -->

<!-- side bar -->
<aside id="sidebar" class="column">
    <h3>Candidates</h3>
    <ul class="toggle">
        <li class="icn_new_article">
            <a href="/admin/candidates/0/20">List Candidate</a>
        </li>
    </ul>
    <h3>Employers</h3>
    <ul class="toggle">
        <li class="icn_view_users">
            <a href="/admin/employerApplications/0/20">List Applications</a>
        </li>
        <li class="icn_add_user">
            <a href="/admin/newEmployer">Add New Employer</a>
        </li>
        <li class="icn_view_users">
            <a href="/admin/employers/0/20">List Employers</a>
        </li>
    </ul>
    <h3>Blog</h3>
    <ul class="toggle">
        <li class="icn_categories">
            <a href="/admin/categories">List Category</a>
        </li>
        <li class="icn_folder">
            <a href="/admin/category">Add Category</a>
        </li>
        <li class="icn_photo">
            <a href="/admin/posts/0/20">List Posts</a>
        </li>
        <li class="icn_new_article">
            <a href="/admin/post">Add Post</a>
        </li>
    </ul>
    <h3>Admin</h3>
    <ul class="toggle">
        <li class="icn_audio">
            <a href="/admin/feedbacks/0/20">Feedbacks</a>
        </li>
        <li class="icn_security">
            <a href="/admin/pwd">Change Password</a>
        </li>
        <li class="icn_jump_back">
            <a href='<c:url value="/j_spring_security_logout"/>'>Logout</a>
        </li>
    </ul>
    <footer>
        <hr />  
        <p>Theme by MediaLoot</p>
    </footer>
</aside>
<!-- end of side bar -->

<!-- body -->
<tiles:insertAttribute name="content"/>
<!-- end of body -->

<!-- footer -->
<!-- end of footer -->
</body>
</html>