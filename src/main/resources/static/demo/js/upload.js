$(function () {
    $('#uploadJquery').on('click',function () {
        uploadImg();
    });
    $('#dltBtn').on('click',function () {
        deleteImg();
    });
});
function uploadImg() {
    var objData = new FormData($('#uploadForm')[0]);
    $.ajax({
        type : 'POST',
        //url : '/demo/upload',
        url: 'http://127.0.0.1:8082/upload/image',
        data : objData,
        cache: false,
        processData: false,
        contentType: false,
        dataType : 'json',
        success: function (data) {
            var rs = data.data.src;
            alert(rs);
            $('#uploadRs').attr('src', rs);
        },
        error : function (msg) {
            console.log('error: ' + msg);
        }
    });
}

function deleteImg() {
    $.ajax({
        type : 'POST',
        //url : '/demo/upload',
        url: 'http://127.0.0.1:8082/upload/delete',
        data : {
            fileUrl: 'http://192.168.43.141/group1/M00/00/00/wKgrjVx968CAF0dsAAAHR9A3qNg684_60x60.png'
        },
        dataType : 'json',
        success: function (data) {
            alert(data.data.src);
        },
        error : function (msg) {
            alert(msg.status);
        }
    });
}