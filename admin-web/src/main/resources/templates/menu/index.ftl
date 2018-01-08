<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DREAM-CLOUD</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <#--<script src="/static/js/tree/dream-tree.js"></script>-->
</head>
<body style="text-align: center;font-size: 20px;color: red; padding-top: 100px">
<div class="btn-toolbar" role="toolbar">
    <div class="btn-group">
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#insertModal">添加</button>
    </div>
</div>
    <table id="table" class="table table-bordered">

    </table>
</body>
<script type="text/javascript">
    $("#table").bootstrapTable({ // 对应table标签的id
        url: "/${urlPrefix}/menu/queryPageList", // 获取表格数据的url
        cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
        method: 'post',
        striped: true,  //表格显示条纹，默认为false
        pagination: true, // 在表格底部显示分页组件，默认false
        pageList: [10, 20], // 设置页面可以显示的数据条数
        pageSize: 10, // 页面数据条数
        pageNumber: 1, // 首页页码
        sidePagination: 'server', // 设置为服务器端分页
        queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
            debugger;
            return {
                pageSize: params.limit, // 每页要显示的数据条数
                pageNum: params.pageNumber, // 每页要显示的数据条数
                offset: params.offset, // 每页显示数据的开始行号
                sort: params.sort, // 要排序的字段
                sortOrder: params.order, // 排序规则
                data: null // 额外添加的参数
            }
        },
        sortName: 'id', // 要排序的字段
        sortOrder: 'desc', // 排序规则
        columns: [
            {
                checkbox: true, // 显示一个勾选框
                align: 'center' // 居中显示
            }, {
                field: 'id', // 返回json数据中的name
                title: '编号', // 表格表头显示文字
                align: 'center', // 左右居中
                valign: 'middle' // 上下居中
            }, {
                field: 'name',
                title: '名称',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'url',
                title: 'url',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'desc',
                title: '描述',
                align: 'center',
                valign: 'middle'
            }, {
                title: "操作",
                align: 'center',
                valign: 'middle',
                width: 160, // 定义列的宽度，单位为像素px
                formatter: function (value, row, index) {
                    return '<button class="btn btn-primary btn-sm" onclick="del(\'' + row.id + '\')">删除</button>';
                }
            }
        ],
        onLoadSuccess: function(){  //加载成功时执行
            console.info("加载成功");
        },
        onLoadError: function(){  //加载失败时执行
            console.info("加载数据失败");
        }

    })

</script>
</html>