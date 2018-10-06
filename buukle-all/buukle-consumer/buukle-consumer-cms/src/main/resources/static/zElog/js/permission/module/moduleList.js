//@ sourceURL=ModuleList.js
$(function () {
    /*绑定页面按钮操作组件*/
    bindsearchConditionClick();
    /*绑定添加页面中加载父级菜单树点击事件*/
    bindShowFatherModuleTree();
    /*绑定添加页面保存按钮事件*/
    bindAddModulePageClick();
});
var tableIns;
function renderTable() {
    layui.use('table', function() {
        var table = layui.table;
        //执行渲染
        tableIns = table.render({
            elem: '#table',
            url: '/module/getModuleList',
            page: true,
            where: {
                moduleName:   $('#fuzzy-index-0').val()
                ,startTime: ($('#startTime').val()==""?"":$('#startTime').val()+" 00:00:00")
                ,endTime:   ($('#endTime').val()==""?"":$('#endTime').val()+" 23:59:59")
                ,status: $('#status').val()
            },
            method: 'post',
            first:  '首页',
            last:   '尾页',
            request: {
                pageName: 'pageNo',
                limitName: 'pageSize'
            }
            ,cols: [[
                {field: 'moduleName', title: '菜单/按钮名', width:177}
                ,{title: '创建时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.gmtCreated)}}</a></div>'}
                ,{title: '更新时间', width: 160,templet: '<div><a href="javascript:;">{{formatDateTime(d.modifiedTime)}}</a></div>'}
                ,{title: '状态', width: 80,templet: '<div>{{formatStatus(d.status)}} </div>'}
                ,{title: '操作',fixed: 'right', width:290, align:'center',templet: '<div>{{formatUserHandle(d.status,d.id)}} </div>'}
            ]]
            ,limits: [10, 20, 30,50,100]
            ,limit: 10
            ,done: function (res, pageNo, count) {
                //绑定按钮点击事件
                bindTableBtnsClick();
            }
        });
    });
}
/*重新载入表数据*/
function reloadTable() {
    setTimeout(function () {
        tableIns.reload();
    },1000);
}

/*菜单树回显*/
function bindShowFatherModuleTree(){
    $('#fatherModuleName').off().on('click',function () {
        $('#fatherModuleName').attr('disabled','disabled');
        $.ajax({
            url:'/module/getFatherModuleList',
            dataType:'json',
            type:'post',
            success:function (data) {
                $('#fatherModuleTreeContain').html('');
                layui.use('tree', function(){
                    layui.tree({
                        elem: '#fatherModuleTreeContain' //传入元素选择器
                        ,nodes:  data,
                        click:function (node) {
                            $('#fatherModuleName').val(node.name);
                            $('#pid').val(node.id);
                        }
                    });
                });
                layui.use("layer",function () {
                    var layer = layui.layer;
                    layer.open({
                        title:"选择父级菜单",
                        type:1,
                        content: $('#fatherModuleTree'),
                        area: ['500px', '320px']
                    });
                });
            }
        });
    });
    /*防止二次点击*/
    $('#yes').off().on('click',function () {
        $('#fatherModuleName').attr('disabled',false);
    })
}
/*绑定添加页面点击事件*/
function bindAddModulePageClick() {
    //点击选择类型动态显示按钮选项
    $('#moduleType').off().on('change',function () {
        if($(this).val() == 1){
            $('.btn-selected').show();
        }
        if($(this).val() == 0){
            $('.btn-select-item').val('');
            $('.btn-selected').hide();
        }
    });
    //保存
    $('#addModule').off().on('click',function () {
        $.ajax({
            url:'/module/addModule',
            dataType:'json',
            type:'post',
            data:$('#addModuleForm').serialize(),
            success:function (data) {
                layer.msg(data.msg, {
                    icon: 1,
                    time: 1000
                });
                //清空添加表单
                $('.add-input').val('');
                reloadTable ();
            }
        });
    });
}
/*详情回显回调*/
function detail(data) {
    for(var key in data){
        if(key == "status"){
            $("#moduleStatus").val(data[key]==0?"停用":"启用")
            continue;
        }else if(key=="gmtCreated" || key=="modifiedTime"){
            $("#"+key).val(formatDateTime(data[key]));
            continue;
        }
        $("#"+key).val(data[key]);
    }
}
/*修改回显回调*/
function modify(id, data) {

}
