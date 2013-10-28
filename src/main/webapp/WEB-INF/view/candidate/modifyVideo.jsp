<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/res/js/candidate/modifyVideo.js"></script>
<div class="wrapper">
    <div id="pad">
        <h2>Modify Video</h2>
        <span class="backward"><a href="/candidate">Back to Bio Page</a></span>
        <div class="clearFloat"></div>
        <form:form id="form0">
        <div class="row">
            <p>You can embed Youtube videos. Please ONLY submit the video id of your video.</p>
            <p>How to find a video id: while watching a video, click "Share" button right below the video, then a short link appears. Copy the string after the last slash, it is the video id. For example, "LpSaGyhARoA" in a short link "http://youtu.be/LpSaGyhARoA".</p>
        </div>
        <div class="row">
            <div class="key">Video ID:</div>
            <div class="value">
                <input type="text" id="videoUrl" name="videoUrl" value='<c:out value="${user.candidate.videoUrl}"/>'/>
            </div>
            <div class="show"><a href="#" id="hrefPreview">Preview</a></div>
        </div>
        <div class="clearFloat"></div>
        <div class="video_wrapper"></div>
        <div class="opt_bar">
            <input type="submit" id="btnSubmit" value="Save"/>
        </div>
        </form:form>
    </div>
</div>