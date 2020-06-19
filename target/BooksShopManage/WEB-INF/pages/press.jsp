<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台管理</title>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <script src="../static/js/jquery-3.3.1.min.js"></script>
    <script src="../static/layui/layui.js"></script>
    <script>
        $(function () {
            layui.use('element', function(){
                var element = layui.element;
            });
            var tbody = $("#tbody");
            var bsPressid = [];
            var a = 0;
            <c:forEach var="b" items="${bsPressList}">
                 bsPressid[a] = "${b.bsPressid}";
                 var bsPressnum = "${b.bsPressnum}";
                 var bsPressname = "${b.bsPressname}"

                 var $tr = $(" <tr>\n" +
                "                            <td>"+bsPressid[a]+"</td>\n" +
                "                            <td>"+bsPressnum+"</td>\n" +
                "                            <td>"+bsPressname+"</td>\n" +
                "                            <td><a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">删除</a>" +
                "                            <input type=\"hidden\" value='${b.bsPressid}'></td>\n" +

                "                        </tr>");
                 tbody.append($tr);
                a++;
            </c:forEach>
            $("#tbody").on('click','.layui-btn.layui-btn-danger.layui-btn-xs',function () {
                let bsPressid = $(this).next().val();
                let $tr = $(this).parent().parent();
               let index = $tr.index();
               var data = '{"bsPressid":'+bsPressid+'}';
                $.ajax({
                    url:"../bsPress/delById",
                    contentType:"application/json;charset=UTF-8",
                    data:data,
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        if(data>0){
                            alert("成功删除");
                            $tr.remove();
                        }
                    },
                     error:function (data) {
                         console.log(data);
                        alert("数据错误");
                     },
                });
            });
            //提交按钮
            layui.use('form', function(){
                var form = layui.form;
                form.render();
                //监听提交
                form.on('submit', function(data){
                    data = data.field;
                    console.log(data);
                    data =
                        '{"bsPressnum":"'+data.bsPressnum+'",' +
                        '"bsPressname":"'+data.bsPressname+'"}';
                    console.log(data);
                      $.ajax({
                        url:"../bsPress/insertOne",
                        contentType:"application/json;charset=UTF-8",
                        data:data,
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                            if(data>0){
                                layer.alert("添加成功");
                            }else{
                                layer.alert("添加失败");
                            }
                        },
                         error:function (data) {
                             console.log(data);
                            alert("数据错误");
                         },
                    });
                    return false;
                });
                form.verify({
                    bsPressnum:[/^[a-zA-Z0-9]+$/,
                        "请输入正确的格式"
                    ]
                    ,
                    bsPressname:[/^[\u4e00-\u9fa5]+$/,
                        "请输入正确的格式"
                    ]
                });
                form.render();
            });
        });
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">后台管理</div>
        <ul class="layui-nav layui-layout-left">
           <li class="layui-nav-item"><a href="../bsBooks/selectAll">书籍管理</a></li>
            <li class="layui-nav-item"><a href="../bsBookclass/selectAll">书籍类别管理</a></li>
            <li class="layui-nav-item"><a href="../bsPress/selectAll">出版社管理</a></li>
        </ul>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-tab layui-tab-card">
            <ul class="layui-tab-title">
                <li class="layui-this">查看出版社</li>
                <li>添加出版社</li>
            </ul>
            <div class="layui-tab-content" style="height: 800px;">
                <div id="selectAll" class="layui-tab-item layui-show">
                    <table id="demo" class="layui-table"  lay-skin="nob" lay-filter="test">
                        <colgroup>
                            <col width="200">
                            <col width="200">
                            <col width="200">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>出版社ID</th>
                            <th>编号</th>
                            <th>出版社名称</th>
                            <th>删除</th>
                        </tr>
                        </thead>
                        <tbody id="tbody">

                        </tbody>
                    </table>
                </div>
                <div class="layui-tab-item">
                     <form class="layui-form" lay-filter="test1" method="post">
                        <div class="layui-form-item">
                            <label class="layui-form-label">出版社编号*</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsPressnum" lay-verify="bsPressnum"
                                       placeholder="请输入出版社编号"  autocomplete="off"
                                       class="layui-input" required/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">出版社名称*</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsPressname" lay-verify="bsPressname"
                                       placeholder="请输入出版社名称"  autocomplete="off"
                                       class="layui-input" required/>
                            </div>
                        </div>
                          <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button type="submit" class="layui-btn" lay-submit lay-filter="*">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>