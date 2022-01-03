// $(document).ready(function () {
//     $.ajax({
//         url: '/home',
//         dataType: 'json',
//         type: 'GET',
//         success: function (data) {
//             if(location.href.indexOf("#reloaded")==-1){
//                 location.href=location.href+"#reloaded";
//                 location.reload();
//             }
//         }
//     });
// })
//
// function js_method(params){
//     $.ajax({
//         url: '/quiz',
//         data:{
//             quizId:params
//         },
//         dataType: 'json',
//         type: 'GET',
//         success: function (data) {
//             window.location.href = data.redirectUrl;
//         }
//     });
// }