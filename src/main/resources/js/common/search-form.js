$(document).ready(function() {

    $('#search-btn').click(function() {
        window.location.href = '/search/tags/' + $('#search-tags').val();
        return false;
    });

});