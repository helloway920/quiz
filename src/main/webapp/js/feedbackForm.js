$(document).ready(function () {
    $.ajax({
        url: '/Week_3_Day_5_war_exploded/feedback',
        dataType: 'json',
        type: 'GET',
        success: function (data) {
            if (location.href.indexOf("#reloaded") == -1) {
                location.href = location.href + "#reloaded";
                location.reload();
            }
        }
    });
    $('#submit').click(function (e) {
        e.preventDefault();
        let rating = $('#ratingId').val();
        let feedback = $('#feedback').val();
        let quizTypeId = $('#quizTypeId').val();
        $.ajax({
            url: '/Week_3_Day_5_war_exploded/feedback',
            data: {
                rating: rating,
                feedback: feedback,
                quizTypeId: quizTypeId,
            },
            dataType: 'json',
            type: 'POST',
            success: function (data) {
                window.location.href = data.redirectUrl;
            }
        })
    });
})