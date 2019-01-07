layui.use('form',function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    var category = '';

    form.on('submit(formSpecQuery)', function (data) {
        layer.alert(JSON.stringify(data.field));
        $.ajax({
            type: 'post',
            url: '/item/specifications/query',
            data: data.field,
            success: function (data) {
                $("#result").val(data.specifications);
            },
            error: function (msg) {
                alert(msg);
            },
            dataType: 'json'
        });
        return false;
    });
    form.on('select(category)',function (data) {
        category = data.value;
    });
    form.on('submit(formSpecAdd)', function (data) {
        // 页面数据处理
        var params = [];
        $("input:text[name='group']").each(function(i) { // 遍历name=group的输入框
            var groupKName = 'group'+i+'k';
            var groupSName = 'group'+i+'searchable';
            var groupGName = 'group'+i+'global';
            var groupOName = 'group'+i+'options';
            var groupNName = 'group'+i+'numerical';
            var groupUName = 'group'+i+'unit';

            var param = [];
            $("input:text[name='"+groupKName+"']").each(function(j) {
                var kVal = $(this).val();
                var sVal = false;
                if ($("input:checkbox[name='"+groupSName+j+"']:checked").length !== 0) {
                    sVal = true;
                }
                var gVal = false;
                if ($("input:checkbox[name='"+groupGName+j+"']:checked").length !== 0) {
                    gVal = true;
                }
                var nVal = false;
                if ($("input:checkbox[name='"+groupNName+j+"']:checked").length !== 0) {
                    nVal = true;
                }
                var uVal = $("input:text[name='"+groupUName+j+"']").val();
                var oVal = [];
                $("input:checkbox[name='"+groupOName+j+"']:checked").each(function() { // 遍历name=ram的多选框
                    oVal.push($(this).val());
                });

                param.push({
                    k:kVal,
                    searchable:sVal,
                    global:gVal,
                    options:oVal,
                    numerical:nVal,
                    unit:uVal
                });
                //param.push({"k":$(this).val()});
            });
            /*$("input:checkbox[name='"+groupSName+"']").each(function(j) {
                //param.push({"searchable":$(this).val()});
            });
            $("input:text[name='"+groupGName+"']").each(function() {
                param.push({"global":$(this).val()});
            });
            $("input:text[name='"+groupNName+"']").each(function() {
                param.push({"numerical":$(this).val()});
            });
            $("input:text[name='"+groupUName+"']").each(function() {
                param.push({"unit":$(this).val()});
            });*/
            params.push({"group":$(this).val(),"param":param});
        });
        if (category === '') {
            layer.alert('请先选择商品类别');
            return false;
        }
        var requestData = {
            categoryId: category,
            specifications: JSON.stringify(params)
        };
        // 发送请求添加规格信息
        $.ajax({
            type: 'post',
            url: '/item/specifications/add',
            data: requestData,
            success: function (data) {
                alert("success" + data.code);
            },
            error: function (msg) {
                alert(msg);
            },
            dataType: 'json'
        });
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