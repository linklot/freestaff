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
<script src="/res/js/hideshow.js" type="text/javascript"></script>
<script src="/res/js/jquery.tablesorter.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/res/js/jquery.equalHeight.js"></script>
</head>
<body>
<!-- header -->
<header id="header">
    <hgroup>
        <h1 class="site_title">
            <a href="/employer">Freestaff</a>
        </h1>
        <h2 class="section_title">Employer</h2>
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
            <a href="/employer">Dashboard</a>
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
        <li class="icn_search">
            <a href="/employer/search">Candidate Search</a>
        </li>
    </ul>
    <h3>Invitations</h3>
    <ul class="toggle">
        <li class="icn_email">
            <a href="/employer/invitations">Invitations</a>
        </li>
    </ul>
    <h3>Employer</h3>
    <ul class="toggle">
        <li class="icn_settings">
            <a href="/employer/profile">Profile</a>
        </li>
        <li class="icn_security">
            <a href="/employer/pwd">Change Password</a>
        </li>
        <li class="icn_edit_article">
            <a href="/employer/feedback">Feedback</a>
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