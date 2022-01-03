$(document).ready(function () {
    $('#submit').click(function (e) {
        e.preventDefault();
        const reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        let userName = $('#userName').val();
        let password = $('#password').val();
        let birthDate = $('#birthDate').val();
        let address = $('#address').val();
        let email = $('#email').val();
        let isAdmin = $('input[name="isAdmin"]:checked').val();
        let message ="";
        if (userName == null || userName == '') {
            message += "User Name cannot be empty\n";
        }
        if (password == null || password == '') {
            message += "Password cannot be empty\n";
        }
        alert(birthDate==null);
        if (birthDate == null) {
            message += "BirthDate cannot be empty\n";
        }
        if (isAdmin == null) {
            message += "Admin cannot be empty\n";
        }
        if (email == null || email == '') {
            message += "Email cannot be empty\n";
        }else if (!reg.test(email)) {
            message += "Invalid Email Format\n";
        }
        if(message.length>1){
            alert(message);
            return false;
        }
        $.ajax({
            url: '/Week_3_Day_5_war_exploded/user',
            data: {
                userName: userName,
                password: password,
                birthDate: birthDate,
                email: email,
                address: address,
                isAdmin: isAdmin
            },
            dataType: 'json',
            type: 'POST',
            success: function (data) {
                console.log(data);
                if (!data.serviceStatus.success) {
                    $('#credentialError').show();
                    $('#credentialError').html(data.serviceStatus.errorMessage);
                } else {
                    $('#credentialError').hide();
                    window.location.href = data.redirectUrl;
                }
            }
        })
    });
})