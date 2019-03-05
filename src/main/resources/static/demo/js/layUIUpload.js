layui.use('upload', function(){
    var uploadVar = layui.upload;
    uploadVar.render({
        elem: '#uploadLayUI',
        //url: '/demo/upload',
        url: 'http://127.0.0.1:8082/upload/image',
        done: function (res) {
            var rs = res.data.src;
            alert(rs);
            $('#uploadRs').attr('src', rs);
        },
        error: function (msg) {
            console.log(msg);
        }
    });
});