layui.use(['layer','table','upload','form'],function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var upload = layui.upload;
    var form = layui.form;

    // 弹出页BrandForm.html，form表单提交 --> lay-filter="formBrandAdd"
    form.on('submit(formBrandAdd)', function(data){
        var arr = [];
        $("input:checkbox[name='category']:checked").each(function() { // 遍历name=standard的多选框
            arr.push($(this).val());
        });
        // data.field获取页面name属性数据
        data.field.category = arr;
        //data.field.category = arr.join(',');
        $.ajax({
            type: 'post',
            url: '/item/brand/add',
            data: data.field,
            success: function (data) {
                //var index = parent.layer.getFrameIndex(); //先得到当前iframe层的索引
                parent.layer.closeAll(); //再执行关闭
            },
            error: function (msg) {
                alert(msg);
            },
            dataType: 'json'
        });
        return false;
    });

    // 弹出页BrandForm.html，上传处理 --> id="uploadLogo"
    // (后续需要添加上传文件类型限制)
    upload.render({
        elem: '#uploadLogo',
        url: '/item/brand/upload',
        before: function(obj){
            // 预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#logoImage').attr('src', result); //图片链接（base64）
            });
        },
        done: function (data) {
            // 保存图片链接到表单的隐藏域
            $("#image").val(data.data.src);
        }
    });

    // 页面Brand.html，表格处理
    table.render({
        elem: '#brand',
        url: '/item/brand/query',
        //url: 'http://127.0.0.1:10010/api/item/layUI',
        cols: [[
            {field: 'id', title: 'id', sort: true},
            {field: 'name', title: '名称'},
            {field: 'image', title: 'LOGO'},
            {field: 'letter', title: '首字母'},
            {fixed: 'right', title:'操作', toolbar: '#toolbar', width:150}
        ]],
        id: 'forReload',
        page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            groups: 1, //只显示 1 个连续页码
            first: false, //不显示首页
            last: false //不显示尾页
        }
    });

    //监听表格行工具事件
    table.on('tool(brand)', function (obj) {
        var data = obj.data;
        console.log(data);
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                $.ajax({
                    type: 'post',
                    url: '/item/brand/delete',
                    data: data,
                    success: function (data) {
                        table.reload('forReload',{page:{curr:1}});// 重新加载表格
                        console.log(data);
                    },
                    error: function (msg) {
                        alert(msg);
                    },
                    dataType: 'json'
                });
                layer.close(index);
            });
        } else if(obj.event === 'edit'){

        }
    });

    // 页面Brand.html，方法定义
    var activeMethod = {
        // 打开弹出页
        brandForm: function () {
            layer.open({
                title: '新增品牌',
                area: ['700px', '80%'],
                type: 2,
                content: 'BrandForm.html',
                end: function () {
                    table.reload('forReload',{page:{curr:1}});// 重新加载表格
                }
            })
        },

        // 搜索处理
        searchBrand: function(){
            var uNumber = "";
            var uTel = "";
            //执行重载
            table.reload('forReload', {
                where: {
                    numberParam: uNumber,
                    telParam: uTel
                },
                page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        }
    };

    // 页面Brand.html，方法使用 --> class="layui-btn" data-method="..."
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