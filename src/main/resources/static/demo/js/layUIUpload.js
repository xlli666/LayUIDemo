layui.use('upload', function(){
    var uploadVar = layui.upload;
    uploadVar.render({
        elem: '#uploadLayUI',
        url: '/demo/upload',
        //url: 'http://127.0.0.1:8082/upload/imageLayUI',
        done: function (res) {
            alert(res.data.src);
        },
        error: function (msg) {
            console.log(msg);
        }
    });
});