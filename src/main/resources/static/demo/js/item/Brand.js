layui.use('layer',function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var activeMethod = {
        brandForm: function () {
            layer.open({
                title: '新增品牌',
                area: ['700px', '80%'],
                type: 2,
                content: 'BrandForm.html'
            })
        },
        addBrandInfo: function () {
            alert($('#name').val());
            var objData = {

            };
            $.ajax({
                type: 'post',
                url: '/demo/query',
                data: objData,
                success: function (data) {
                    alert('suc')
                },
                error: function (msg) {
                    alert('fail')
                },
                dataType: 'json'
            });
        }
    };

    $('.layui-btn').on('click',function () {
        var method = $(this).data('method');
        activeMethod[method] ? activeMethod[method].call(this) : '';
    });
});


/*************
$(function () {
    $('#addBrand').on('click',function () {
        layer.open({
            title: '新增品牌',
            area: ['700px', '80%'],
            type: 2,
            content: 'BrandForm.html'
        })
    });
    $('#addConfirm').on('click',function () {
        addBrandInfo();
    });
});
function addBrandInfo() {
    var objData = getFormData();
    $.ajax({
        type: 'post',
        url: '',
        data: objData,
        success: function (data) {

        },
        error: function (msg) {

        },
        dataType: 'json'
    })
}*/