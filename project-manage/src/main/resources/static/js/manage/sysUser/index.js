
var table = layui.table;
var form = layui.form;
var $ = layui.jquery;
var searchFormData = {};

table.render({
    elem: '#sysUserTable',
    url:'/sysUser/getPage',
    method: 'POST',
    cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui2 2.2.1 新增
    page: {
        groups: 5
    }, //开启分页
    toolbar: 'default',
    cols: [[
            {type: 'checkbox', fixed: 'left'},
            {field: 'account', width:'45%', title: '账号', align:'center'},
            {field: 'name', width:'45%', title: '用户名', align:'center', sort: true}
        ]]
});

form.on('submit(search)', function(data){
    searchFormData = JSON.stringify(data.field);
    //执行重载
    table.reload('sysUserTable', {
        page: {
            curr: 1 //重新从第 1 页开始
        }
        ,where: {
            search: searchFormData
        }
    });
    return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
});

//监听头工具栏事件
table.on('toolbar(sysUserTable)', function(obj){
    var checkStatus = table.checkStatus('sysUserTable'),
        data = checkStatus.data; //获取选中的数据
    switch(obj.event){
        case 'update':
            console.log(checkStatus)
            if(data.length === 0){
                layer.msg('请选择一行');
            } else if(data.length > 1){
                layer.msg('只能同时编辑一个');
            } else {
                layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
            }
            break;
        case 'delete':
            if(data.length === 0){
                layer.msg('请选择一行');
            } else {
                layer.msg('删除');
            }
            break;
    };
});
