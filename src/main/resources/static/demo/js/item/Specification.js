layui.use('form',function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;

    form.on('submit(formSpecQuery)', function (data) {
        layer.alert(JSON.stringify(data.field));
        return false;
    });
    form.on('submit(formSpecAdd)', function (data) {
        layer.alert(JSON.stringify(data.field));
        return false;
    });
    form.on('submit(formSpecUpdate)', function (data) {
        layer.alert(JSON.stringify(data.field));
        return false;
    });
    form.on('submit(formSpecDelete)', function (data) {
        layer.alert(JSON.stringify(data.field));
        return false;
    });
});