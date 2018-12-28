function getProjRoot() {
    var pathName = window.document.location.pathname;
    return pathName.substring(0,pathName.substring(1).lastIndexOf('/')+1);
}

function getFormData() {
    var inputObj = {};
    inputObj.eId=$("#eId").val();
    inputObj.eTel=$("#eTel").val();
    return inputObj;
}
function iframeChg(url) {
    $("#iFrame").attr("src", url);
}