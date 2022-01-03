$(document).ready(function () {
    $.ajax({
        url: '/Week_3_Day_5_war_exploded/user',
        dataType: 'json',
        type: 'GET',
        success: function (data) {
            if (location.href.indexOf("#reloaded") == -1) {
                location.href = location.href + "#reloaded";
                location.reload();
            }
            if (!data.serviceStatus.success) {
                $('#credentialError').show();
                $('#credentialError').html(data.serviceStatus.errorMessage);
            } else {
                $('#credentialError').hide();
            }
        }
    });
})