/**
 * common.js
 * @author 御风 <1945199284@qq.com>
 */
layui.define(['layer'], function(exports) {

    "use strict";

    var $ = layui.jquery,
        layer = layui.layer;

    var common = {
        /**
         * 抛出一个异常错误信息
         * @param {String} msg
         */
        throwError: function(msg) {
            throw new Error(msg);
        },
        /**
         * 弹出一个错误提示
         * @param {String} msg
         */
        msgError: function(msg) {
            layer.msg(msg, {
                icon: 5
            });
        }
    };

    exports('common', common);

});
