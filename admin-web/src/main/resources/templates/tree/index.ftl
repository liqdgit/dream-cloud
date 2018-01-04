<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>李木子</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <#--<script src="/static/js/tree/dream-tree.js"></script>-->
</head>
<body style="text-align: center;font-size: 20px;color: red; padding-top: 100px">
<div class="btn-toolbar" role="toolbar">
    <div class="btn-group">
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#insertModal">添加</button>
    </div>
</div>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>编号</th>
                <th>ID</th>
                <th>名称</th>
                <th>父ID</th>
                <th>左值</th>
                <th>右值</th>
                <th>层级</th>
                <th>版本</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <#list treeList as tree>
                <tr>
                    <td>${tree_index + 1}</td>
                    <td>${(tree.id)!}</td>
                    <td>${(tree.name)!}</td>
                    <td>${(tree.pid)!}</td>
                    <td>${(tree.left)!}</td>
                    <td>${(tree.right)!}</td>
                    <td>${(tree.level)!}</td>
                    <td>${(tree.version)!}</td>
                    <td>
                        <a href="javascript:void(0)" data-toggle="modal" data-target="#updateModal">修改</a>
                        <a href="javascript:void(0)">删除</a>
                        <a href="javascript:void(0)" onclick="insertNodePid('${(tree.id)!}')" data-toggle="modal" data-target="#insertNode">添加子节点</a>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>

<div class="modal fade" id="insertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="#">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="add_name" type="text"  placeholder="节点名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">父级</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="add_pid">
                                <#list treeList as tree>
                                    <option value="${tree.id}">${tree.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" id="add_submit" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改
                </h4>
            </div>
            <div class="modal-body">
                在这里添加一些文本
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="insertNode" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" action="#">
                    <input type="hidden" id="add_node_pid">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="add_node_name" type="text"  placeholder="节点名称">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" id="add_node_submit" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $("#add_submit,#add_node_submit").click(function () {
            var elementId = $(this).attr("id");
            var pid, name;
            if(elementId == "add_submit"){
                pid = $("#add_pid").val();
                name = $("#add_name").val();
            }else{
                pid = $("#add_node_pid").val();
                name = $("#add_node_name").val();
            }

            $.ajax({
                url: '/tree/save',
                type: 'post',
                data: {name: name, pid: pid},
                success:function (result) {
                    alert(result.message);
                    if(result.code == 200){
                        window.location.href = '/tree/pageList';
                    }
                }
            });
        });
    });

    function insertNodePid(id) {
        $("#add_node_pid").val();
    }
</script>
</html>