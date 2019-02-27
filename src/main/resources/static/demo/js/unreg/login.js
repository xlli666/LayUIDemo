layui.use('form', function(){
    var $ = layui.jquery;
    var form = layui.form;

    //监听提交
    form.on('submit(formLogin)', function(data){
        $.ajax({
            type: 'post',
            //url: 'http://api.democloud.com/api/auth/accredit',
            url: 'http://127.0.0.1:10010/api/auth/accredit',
            data: data.field,
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            success: function(data){
                if ("OK" === data.data) {
                    alert('登录成功');
                }
            },
            error: function (msg) {
                console.log('服务异常，code: ' + msg.status);
                alert('登录失败');
            },
            dataType: 'json'
        });
        return false;
    });
    form.on('submit(getToken)', function(data){
        $.ajax({
            type: 'post',
            url: 'http://api.democloud.com/api/auth/verify',
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            success: function(data){
                console.log(data);
                alert('suc');
            },
            error: function (msg) {
                console.log(msg);
                alert('err')
            }
        });
        return false;
    });
});