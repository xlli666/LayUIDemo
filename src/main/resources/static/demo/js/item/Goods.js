layui.use(['layer','table','upload','form','layedit'],function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var upload = layui.upload;
    var form = layui.form;
    var layedit = layui.layedit;

    // 构建一个默认的编辑器
    var index = layedit.build('description');

    // 选择分类后渲染规格参数和SKU属性(暂时获取到了数据，缺少前端渲染)
    form.on('select(category)',function (data) {
        var requestData = {
            category: data.value
        };
        $.ajax({
            type: 'post',
            url: '/item/specifications/query',
            data: requestData,
            success: function (data) {
                var jsonData = JSON.parse(data.specifications);
                // 保存全部规格
                //this.specifications = jsonData;
                // 对特有规格进行筛选
                var temp = [];
                jsonData.forEach(function(params){
                    params.param.forEach(function(values) {
                        var jsonK = values.k;
                        var jsonOptions = values.options;
                        var jsonSelected = values.global;
                        if (!jsonSelected) {
                            temp.push({
                                k:jsonK,
                                options:jsonOptions,
                                selected:[]
                            })
                        }
                    })
                });
                //this.specialSpecs = temp;
                console.log(temp);
            },
            error: function (msg) {
                alert(msg);
            },
            dataType: 'json'
        });
    });

    // 表单提交
    form.on('submit(formGoodsAdd)', function (data) {
        alert(layedit.getContent(index)); // 获取编辑器内容
        //alert(layedit.getText(index)); // 获取编辑器纯文本内容
        //alert(layedit.getSelection(index)); // 获取选中内容
    });

    // 页面Goods.html，表格处理
    table.render({
        elem: '#goods',
        url: '/item/goods/spu/page',
        //url: 'http://127.0.0.1:10010/api/item/layUI',
        cols: [[
            {field: 'id', title: 'id', sort: true},
            {field: 'title', title: '标题'},
            {field: 'cname', title: '分类'},
            {field: 'bname', title: '品牌'},
            {fixed: 'right', title:'操作', toolbar: '#toolbar', width: 160}
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
    table.on('tool(goods)', function (obj) {
        var data = obj.data;
        console.log(data);
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit'){

        }
    });

    // 页面Goods.html，方法定义
    var activeMethod = {
        // 打开弹出页
        goodsForm: function () {
            layer.open({
                title: '新增商品',
                area: ['700px', '80%'],
                type: 2,
                content: 'GoodsForm.html',
                end: function () {
                    table.reload('forReload',{page:{curr:1}});// 重新加载表格
                }
            })
        },

        // 搜索处理
        searchGoods: function(key){
            //执行重载
            table.reload('forReload', {
                where: {
                    saleable: 1,
                    key: key
                },
                page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        }
    };

    // 页面Goods.html，方法使用 --> class="layui-btn" data-method="..."
    $('.layui-btn').on('click',function () {
        var method = $(this).data('method');
        activeMethod[method] ? activeMethod[method].call(this,$("#key").val()) : '';
    });
});