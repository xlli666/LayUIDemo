$(function () {
    $('#temp').on('click',function () {
        clickRequest();
    });
});
function clickRequest() {
    var objData = getFormData();
    $.ajax({
        type : 'POST',
        url : '/demo/query',
        data : objData,
        success : function (data) {
            setData(data);
        },
        error : function (msg) {
            alert('error: ' + msg);
        },
        dataType : 'json'
    });
}

function setData(param) {
    var resultList = JSON.stringify(param.list);
    $('#result').val(resultList);
}