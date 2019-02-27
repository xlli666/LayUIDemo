layui.use('form', function(){
    var $ = layui.jquery;
    var form = layui.form;

    $('#username').on('blur',function () {
        var username = $('#username').val();
        var chkType = 1;
        $.ajax({
            type: 'post',
            url: 'http://127.0.0.1:10010/api/user/check/' + username + '/' + chkType,
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            success: function(data){
                if ("false" === data.data) {
                    alert('用户已存在');
                }
            },
            error: function (msg) {
                console.log('服务异常，code: ' + msg.status);
            }
        })
    });

    // 获取验证码
    form.on('submit(getVCode)', function(data){
        $.ajax({
            type: 'post',
            url: 'http://127.0.0.1:10010/api/user/code',
            data: {
                tel: data.field.tel
            },
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            success: function(data){
                if ("true" === data.data) {
                    alert('验证码已发送');
                }
            },
            error: function (msg) {
                console.log('服务异常，code: ' + msg.status);
                alert('服务异常, 请稍后尝试');
            },
            dataType: 'json'
        });
        return false;
    });
    // 注册
    form.on('submit(formReg)', function(data){
        $.ajax({
            type: 'post',
            url: 'http://127.0.0.1:10010/api/user/register',
            data: data.field,
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            success: function(data){
                if ("true" === data.data) {
                    alert('注册成功');
                }
            },
            error: function (msg) {
                console.log('服务异常，code: ' + msg.status);
                alert('服务异常, 注册失败');
            },
            dataType: 'json'
        });
        return false;
    });
});