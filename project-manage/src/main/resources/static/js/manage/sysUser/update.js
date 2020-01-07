var form = layui.form;
var $ = layui.$;
// 验证成功后才会执行下面的操作
form.on('submit(formVerify)',function (formData) {
    // 提交成功后返回信息，关闭弹出层
    $.ajax({
        url: '/sysUser/update',
        data: formData.field,
        type: "POST",
        success: function (returnData) {
            //当你在iframe页面关闭自身时
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index);
            parent.layer.msg(returnData,{
                icon:1,
                time: 2000
            });
            // 刷新表格（即点击分页控件的“确定”按钮）
            parent.$('#searchBtn').click();
        }
    });
    return false;
});