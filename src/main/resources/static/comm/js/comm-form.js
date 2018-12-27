function getFormData() {
    var inputObj = {};
    inputObj.eId=$("#eId").val();
    inputObj.eTel=$("#eTel").val();
    return inputObj;
}
function iframeChg(url) {
    $("#iFrame").attr("src", url);
}