layui.use('upload', function(){
    var uploadVar = layui.upload;
    uploadVar.render({
        elem: '#uploadLayUI',
        url: 'http://127.0.0.1:8082/upload/imageLayUI',
        //url: '/demo/upload',
        done: function (res) {
            console.log(res.data.src);
        },
        error: function (msg) {
            alert(msg);
        }
    });
});