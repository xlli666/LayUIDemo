layui.config({
    base: '/comm/js/' //navbar组件js所在目录
}).use('navbar', function () {
    var mNavBar = layui.navbar();
    mNavBar.set({
        elem: '#nav',
        url: '/comm/js/menu.json' //数据源地址
        //url: '/menu/query' //数据源Controller处理
    });
    mNavBar.render();
    //下面的部分不是必须的
    mNavBar.on('click(test)', function(data) {
        console.log(data.elem);
        console.log(data.field.title);//标题
        console.log(data.field.icon);//图标
        console.log(data.field.href);//调转地址
        //layer.msg(data.field.href);
    });
    //给选中的页签添加选中样式（解决刷新失效问题）
    var url = window.location.href.replace("//", "");
    var relUrl = url.substring(url.lastIndexOf("/") + 1);
    if (relUrl.indexOf("?") != -1) {
        relUrl = relUrl.split("?")[0];
    }
    $("#leftNavbar a").each(function () {
        var that = this;
        if ($(that).attr("href") == relUrl) {
            $(that).parent().addClass("layui-this");
            $(that).parents("li:eq(0)").addClass("layui-nav-itemed");
            var nodes = $(that).parents("li:eq(0)").find("a .layui-nav-more");
            if (nodes.length > 0) {
                nodes.each(function () {
                    if ($(this).parents("dd:eq(0)").find("[href='" + relUrl +  "']").length > 0) {
                        $(this).parent().parent().addClass("layui-nav-itemed");
                    }
                });
            }
        }
    });
});