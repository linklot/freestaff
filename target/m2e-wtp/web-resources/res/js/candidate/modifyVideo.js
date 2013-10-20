var hrefPreview, video_wrapper, videoUrl, form;

$(document).ready(function() {
    hrefPreview = $('#hrefPreview');
    video_wrapper = $('.video_wrapper');
    videoUrl = $('#videoUrl');
    form = $('#form0');
    
    hrefPreview.click(function(event) {
        event.preventDefault();
        videoUrl.val($.trim(videoUrl.val()));
        if(videoUrl.val() != '') {
            video_wrapper.css('display', 'block');
            var html = '<iframe id="ytplayer" type="text/html" width="640" height="360" src="https://www.youtube.com/embed/'+ videoUrl.val() +'" frameborder="0" allowfullscreen></iframe>';
            video_wrapper.html(html);
        }
    });

    form.submit(function(event) {
        videoUrl.val($.trim(videoUrl.val()));
    });
});