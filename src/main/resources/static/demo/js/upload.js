$(function () {
    $('#uploadJquery').on('click',function () {
        uploadImg();
    });
});
function uploadImg() {
    var objData = new FormData($('#uploadForm')[0]);
    $.ajax({
        type : 'POST',
        url : '/demo/upload',
        //url: 'http://127.0.0.1:8082/upload/image',
        data : objData,
        cache: false,
        processData: false,
        contentType: false,
        dataType : 'json',
        success: function (data) {
            alert(data.data.src);
        },
        error : function (msg) {
            console.log('error: ' + msg);
        }
    });
}