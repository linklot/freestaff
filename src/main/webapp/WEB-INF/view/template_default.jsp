<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Freestaff - Skilled Migrant Solutions</title>
<link type="text/css" rel="stylesheet" href="${request.contextPath}<tiles:getAsString name='css'/>"/>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-45366714-1', 'freestaff.com.au');
  ga('send', 'pageview');

</script>
</head>
<body>
<!-- top bar -->
<div class="topbar">
    <div class="wrapper">
        <span class="cand_signup_wrapper"><a href="/reg">Candidate SignUp</a></span>
        <span class="emp_signup_wrapper"><a href="/employerReg">Employer Register</a></span>
    </div>
</div>
<!-- top bar end -->

<!--  header -->
<header>
    <div class="wrapper">
        <h1>
            <a href="/" id="logo"><img src="/res/image/freestaff_logo.png"/></a>
        </h1>
        <div class="clearFloat"></div>
    </div>
    <nav>
        <ul id="menu">
            <li class="alpha" id="menu_active">
                <a href="/">
                    <span>
                        <span>HOME</span>
                    </span>
                </a>
            </li>
            <li>
                <a href="/candidate">
                    <span>
                        <span><div class="double_line">CANDIDATE LOG IN</div></span>
                    </span>
                </a>
            </li>
            <li>
                <a href="/employer">
                    <span>
                        <span><div class="double_line">EMPLOYER LOG IN</div></span>
                    </span>
                </a>
            </li>
            <li>
                <a href="/jobs">
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