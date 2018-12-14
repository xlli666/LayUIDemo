$(function () {
    $('#uploadJquery').on('click',function () {
        uploadImg();
    });
});
function uploadImg() {
    var objData = new FormData($('#uploadForm')[0]);
    $.ajax({
        type : 'POST',
        //url : 'http://127.0.0.1:10010/api/upload/image',
        url: 'http://127.0.0.1:8082/upload/image',
        data : objData,
        cache: false,
        processData: false,
        contentType: false,
        dataType : 'json',
        success: function (data) {
            alert(data);
        },
        error : function (msg) {
            alert('error: ' + msg);
        }
    });
}