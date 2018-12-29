/**
 * 获取项目跟目录
 * @returns {string}
 */
function getRootPath() {
    var pathName = window.document.location.pathname;
    return pathName.substring(0,pathName.substring(1).lastIndexOf('/')+1);
}

/**
 * iframe切换
 * @param url 页面路径
 */
function iframeChg(url) {
    $("#iframe").attr("src", url);
}

/**
 * 根据元素ID 获取值
 * （待开发）
 */
function getFormData() {
    var inputObj = {};
    inputObj.a='';
    inputObj.b='';
    return inputObj;
}
