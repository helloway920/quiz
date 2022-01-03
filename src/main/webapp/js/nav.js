function logOut(){
    $.ajax({
        url: '/Week_3_Day_5_war_exploded/login',
        dataType: 'json',
        type: 'GET',
        success: function (data) {
            if (data.serviceStatus.success) {
                alert("Thank you for using!");
            }
            window.location.href = data.redirectUrl;
        }
    })
}