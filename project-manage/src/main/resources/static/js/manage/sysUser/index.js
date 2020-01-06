var table = layui.table;
var form = layui.form;
var $ = layui.jquery;
var searchFormData = {};

table.render({
    id: 'sysUserTable',
    elem: '#sysUserTable',
    url:'/sysUser/getPage',
    method: 'POST',
    cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    page: {
        groups: 2
    }, //开启分页
    toolbar: 'default',
    cols: [
        [
            {type: 'checkbox', fixed: 'left'},
            {field: 'account', width:'45%', title: '账号', align:'center'},
            {field: 'name', width:'45%', title: '用户名', align:'center', sort: true}
        ]
    ]
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
    var checkStatus = table.checkStatus(obj.config.id),
        data = checkStatus.data; //获取选中的数据
    switch(obj.event){
        case 'add':
            layer.open({
                type: 2,
                skin: 'layui-layer-rim', //样式类名
                title: '用户新增',
                closeBtn: 1, //不显示关闭按钮
                area: ['400px', '400px'],
                shadeClose: true, //开启遮罩关闭
                content: '/sysUser/toUpdate',
                btn: ['保存','关闭'],
                success: function(layero, index) {

                },
                yes: function (index) {
                    // 获取弹出层中的form表单元素
                    var formSubmit=layer.getChildFrame('form', index);
                    // 获取表单中的提交按钮（在我的表单里第一个button按钮就是提交按钮，使用find方法寻找即可）
                    var submited = formSubmit.find('button')[0];
                    // 触发点击事件，会对表单进行验证，验证成功则提交表单，失败则返回错误信息
                    submited.click();
                }
            });
            break;
        case 'update':
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