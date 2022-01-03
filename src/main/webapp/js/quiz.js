buttonClick = function(prevPage, curPage, totalSize) {
    if (curPage < 1 || curPage > totalSize) {
        return false;
    }
    let radio = document.getElementsByName("choice");
    let selectIdx = 0;
    for (let i = 0; i < radio.length; i++) {
        if (radio[i].checked) {
            selectIdx = radio[i].value;
        }
    }
    $.ajax({
        url: '/Week_3_Day_5_war_exploded/quiz',
        data: {
            prevPage: prevPage,
            curPage: curPage,
            selectIdx: selectIdx
        },
        dataType: 'json',
        type: 'GET',
        success: function (data) {
            window.location.href = data.redirectUrl;
        }
    });
}

function submit() {
    let radio = document.getElementsByName("choice");
    let selectIdx = 0;
    for (let i = 0; i < radio.length; i++) {
        if (radio[i].checked) {
            selectIdx = radio[i].value;
        }
    }
    $.ajax({
        url: '/Week_3_Day_5_war_exploded/submission',
        data: {
            selectIdx: selectIdx
        },
        dataType: 'json',
        type: 'GET',
        success: function (data) {
            let con = true;
            if(data.allAnswer=="0"){
                con = confirm("You didn't answer all questions. Do you want to submit?");
            }
            if(!con){
                return false;
            }else{
                $.ajax({
                    url: '/Week_3_Day_5_war_exploded/submission',
                    data: {
                        selectIdx: selectIdx
                    },
                    dataType: 'json',
                    type: 'POST',
                    success: function (data) {
                        window.location.href = data.redirectUrl;
                    }
                });
            }
        }
    });
}

setTimeout(function () {
    alert("Time is up.");
    let radio = document.getElementsByName("choice");
    let selectIdx = 0;
    for (let i = 0; i < radio.length; i++) {
        if (radio[i].checked) {
            selectIdx = radio[i].value;
        }
    }
    $.ajax({
        url: '/Week_3_Day_5_war_exploded/submission',
        data: {
            selectIdx: selectIdx
        },
        dataType: 'json',
        type: 'POST',
        success: function (data) {
            window.location.href = data.redirectUrl;
        }
    });
}, 90000)
