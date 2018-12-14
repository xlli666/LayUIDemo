layui.use('table', function () {
    var tableVar = layui.table;
    tableVar.render({
        elem: '#test',
        //url: 'http://127.0.0.1:10010/api/item/layUI',
        url: '/demo/query22',
        cols: [[
            {field: 'id', title: '编号', sort: true},
            {field: 'name', title: '姓名'},
            {field: 'tel', title: '电话'}
        ]],
        id: 'forReload',
        parseData: function(res){
            return {
                "code": res.code, //解析接口状态
                "msg": res.msg, //解析提示文本
                "count": res.count, //解析数据长度
                "data": null //解析数据列表
            }
        },
        page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            groups: 1, //只显示 1 个连续页码
            first: false, //不显示首页
            last: false //不显示尾页
        },
        limits: [1, 3, 5],
        limit: 1 //每页默认显示的数量
    });

    var active = {
        reload: function(){
            var eId = $('#eId').val();
            var eTel = $('#eTel').val();
            //执行重载
            tableVar.reload('forReload', {
                where: {
                    eId: eId,
                },
                parseData: function(res){
                    return {
                        "code": res.code, //解析接口状态
                        "msg": res.msg, //解析提示文本
                        "count": res.count, //解析数据长度
                        "data": res.data //解析数据列表
                    }
                },
                page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        }
    };

    $('.layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});