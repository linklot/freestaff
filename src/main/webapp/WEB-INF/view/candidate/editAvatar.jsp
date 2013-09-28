<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/editAvatar.js"></script>
<div class="wrapper">
    <div id="pad">
        <div id="photo_wrapper">
            <div class="title">Current Photo</div>
            <div id="avatar"></div>
        </div>
        <div id="upload_wrapper">
            <div class="title">Upload a Photo</div>
            <div class="prompt">You can upload a JPG, GIF or PNG file (<strong>200*200</strong> pixels. File size limit is 4 MB).</div>
            <div class="upload">
                <form:form id="pic_form" method="post" enctype="multipart/form-data">
                    <input type="hidden" id="cid" name="cid" value='<c:out value="${user.id}"/>'/>
                    <input type="file" id="pic_file" name="pic_file"/>
                    <input type="submit" id="btnSubmit" value="Upload"/>
                    <label id="msgLbl" for="btnSubmit"></label>
                </form:form>
            </div>
        </div>
        <div class="clearFloat"></div>
        <div id="backward"><a href="/candidate">Back to Bio Page</a></div>
    </div>
</div>
