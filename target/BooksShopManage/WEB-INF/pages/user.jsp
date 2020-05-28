<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
    <style>
        #image{
            width: 92px;
            height: 92px;
            margin: 10px;
            border: 0.5px solid black;
        }
    </style>
    <script>
        $(function () {
            layui.use('element', function(){
                var element = layui.element;
            });
            var tbody = $("#tbody");
            var $tr;
            <c:forEach items="${bsUsersList}" var="b">
                var bsLoginname = "${b.bsLoginname}";
                var bsUsertype = "${b.bsUsertype}"
                var bsUsersex = "${b.bsUsersex}";
                var bsUsername = "${b.bsUsername}";
                var bsTruename = "${b.bsTruename}";
                var bsUserbrithday = "${b.bsUserbrithday}";
                var bsUserqq = "${b.bsUserqq}";
                var bsUserphone = "${b.bsUserphone}";
                var bsUseremail = "${b.bsUseremail}";
                var bsProvince = "${b.bsProvince}";
                var bsUniversity = "${b.bsUniversity}";
                $tr = $(" <tr>\n" +
                    "                            <td>"+bsLoginname+"</td>\n" +
                    "                            <td>"+bsUsertype+"</td>\n" +
                    "                            <td>"+bsUsersex+"</td>\n" +
                    "                            <td>"+bsUsername+"</td>\n" +
                    "                            <td>"+bsTruename+"</td>\n" +
                    "                            <td>"+bsUserbrithday+"</td>\n" +
                    "                            <td>"+bsUserqq+"</td>\n" +
                    "                            <td>"+bsUserphone+"</td>\n" +
                    "                            <td>"+bsUseremail+"</td>\n" +
                    "                            <td>"+bsProvince+"</td>\n" +
                    "                            <td>"+bsUniversity+"</td>\n" +
                    "                <td><a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">删除</a>" +
                    "            <input type=\"hidden\" value='${b.bsUserid}'></td>\n" +
                    "                        </tr>");
                tbody.append($tr);
            </c:forEach>
             $("#tbody").on('click','.layui-btn.layui-btn-danger.layui-btn-xs',function () {
                let bsUserid = $(this).next().val();
                let $tr = $(this).parent().parent();
               let index = $tr.index();
               alert(bookId);
               var data = '{"bsUserid":"'+bsUserid+'"}';
                $.ajax({
                    url:"../bsUsers/delById",
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
                        alert("数据错误");
                     },
                });
            });
             //上传图片
            var url = 'https://api.uomg.com/api/image.ali';
            var imgUrl = null;
             $("input[type='file']").change(function(e) {
                file_upload(this.files)
            });
            var obj = $('body');
            obj.on('dragenter', function(e) {
                e.stopPropagation();
                e.preventDefault()
            });
            obj.on('dragover', function(e) {
                e.stopPropagation();
                e.preventDefault()
            });
            obj.on('drop', function(e) {
                e.preventDefault();
                file_upload(e.originalEvent.dataTransfer.files)
            });
             function file_upload(files){
                if (files.length == 0) return alert('请选择图片文件！');
                for(var j = 0,len = files.length; j < len; j++){
                    console.log(files[j]);
                    let imageData = new FormData();
                    imageData.append("file", 'multipart');
                    imageData.append("Filedata", files[j]);
                    $.ajax({
                        url: url,
                        type: 'POST',
                        data: imageData,
                        cache: false,
                        contentType: false,
                        processData: false,
                        dataType: 'json',
                        // 图片上传成功
                        success: function (result) {
                            if (result.code == 1){
                                imgUrl = result.imgurl;
                                $("#image").attr('src',imgUrl);
                            }else{
                                alert("上传失败，请重新上传");
                            }
                        },
                        // 图片上传失败
                        error: function () {
                            console.log('图片上传失败');
                        }
                    });
                }
            }
             layui.use('form', function(){
                var form = layui.form;
                form.render();
                //监听用户单选
                form.on('radio(bsUsertype)', function(data){
                    //被点击的radio的value值
                    if(data.value==0){
                        var $userClass = $("#userClass");
                        var $div = $(" <div class=\"layui-form-item\" id='stu'>\n" +
                            "        <label class=\"layui-form-label\">学校</label>\n" +
                            "        <div class=\"layui-input-block\">\n" +
                            "            <input type=\"text\" name=\"bsUniversity\" placeholder=\"如果是学校用户请填入学校\" autocomplete=\"off\"\n" +
                            "                   class=\"layui-input\">\n" +
                            "        </div>\n" +
                            "    </div>");
                        $userClass.after($div);
                    }else{
                        $("#stu").remove();
                    }
                });
                //监听提交
                form.on('submit', function(data){
                    data = data.field;
                    console.log(data);
                    data =
                        '{"bsUserid":'+data.bsUserid+',' +
                        '"bsLoginname":"'+data.bsLoginname+'",' +
                        '"bsUsertype":'+data.bsUsertype+',' +
                        '"bsUsersex":'+data.bsUsersex+',' +
                        '"bsTruename":"'+data.bsTruename+'",' +
                        '"bsUserbrithday1":"'+data.bsUserbrithday1+'",' +
                        '"bsUserqq":"'+data.bsUserqq+'",' +
                        '"bsUserphone":"'+data.bsUserphone+'",' +
                        '"bsUseremail":"'+data.bsUseremail+'",' +
                        '"bsProvince":"'+data.bsProvince+'",' +
                        '"bsUniversity":"'+data.bsUniversity+'"}';
                    console.log(data);
                      $.ajax({
                        url:"../bsUsers/updateOne",
                        contentType:"application/json;charset=UTF-8",
                        data:data,
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                            if(data>0){
                                layer.alert("信息修改成功");
                            }else if(data == 0){
                                layer.alert("该用户不存在或未完善信息");
                            }else{
                                layer.alert("信息修改失败");
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
                    //我们既支持上述函数式的方式，也支持下述数组的形式
                    //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
                    bsUserid:[/^[0-9]*$/
                        ,"请输入正确的格式"]
                    ,
                    bsLoginname:[/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
                        ,"请输入正确的格式"]
                    ,
                    bsUsertype:[/[0,1]/
                        ,"请填写"]
                    ,
                    bsUsersex:[/[0,1]/
                        ,"请填写"]
                    ,
                    bsTruename:[   /^[\u4e00-\u9fa5]+$/
                        , "请输入正确的格式"
                    ]
                    ,
                    bsUserbrithday1:[ /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/
                        , "请输入正确的格式"
                    ]
                    ,
                    bsUserphone: [
                        /^1[3456789]\d{9}$/
                        ,'电话号有误'
                    ]
                });
                form.render();
            });
            //日期函数
            layui.use('laydate', function(){
                var laydate = layui.laydate;
                //执行一个laydate实例
                laydate.render({
                    elem: '#birthday' //指定元素
                });
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
            <li class="layui-nav-item"><a href="../bsPublishbooks/selectAll">卖书管理</a></li>
            <li class="layui-nav-item"><a href="../bsBookclass/selectAll">书籍类别管理</a></li>
            <li class="layui-nav-item"><a href="../bsPress/selectAll">出版社管理</a></li>
            <li class="layui-nav-item"><a href="../bsUsers/selectAll">用户管理</a></li>
        </ul>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-tab layui-tab-card">
            <ul class="layui-tab-title">
                <li class="layui-this">查看所有用户</li>
                <li>修改用户信息</li>
            </ul>
            <div class="layui-tab-content" style="height: 800px;">
                <div id="selectAll" class="layui-tab-item layui-show">
                     <table id="demo" class="layui-table"  lay-skin="nob" lay-filter="test">
                        <colgroup>
                            <col width="200">
                            <col width="200">
                            <col width="150">
                            <col width="100">
                            <col width="200">
                            <col width="200">
                            <col width="150">
                            <col width="100">
                            <col width="200">
                            <col width="200">
                            <col width="150">
                            <col width="100">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>账号</th>
                            <th>用户类型：学校用户1，普通用户0</th>
                            <th>用户性别；男1，女0</th>
                            <th>用户名</th>
                            <th>真实姓名</th>
                            <th>生日</th>
                            <th>qq</th>
                            <th>手机号</th>
                            <th>邮箱</th>
                            <th>省份</th>
                            <th>学校</th>
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
                            <label class="layui-form-label">用户ID*</label>
                            <div class="layui-input-block">
                                <input type="number" name="bsUserid" lay-verify="bsUserid"
                                       placeholder="请输入"  autocomplete="off"
                                       class="layui-input" required/>
                            </div>
                        </div>
                         <div class="layui-form-item">
                            <label class="layui-form-label">用户名*</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsLoginname" lay-verify="bsLoginname" placeholder="请输入"  autocomplete="off"
                                       class="layui-input" required/>
                            </div>
                        </div>
                          <div class="layui-form-item" id="userClass">
                            <label class="layui-form-label">用户类型*</label>
                            <div class="layui-input-block">
                                <input type="radio" lay-filter="bsUsertype" name="bsUsertype" value="0" title="学生">
                                <input type="radio" lay-filter="bsUsertype" name="bsUsertype" value="1" title="普通用户">
                            </div>
                        </div>
                         <div class="layui-form-item">
                            <label class="layui-form-label">性别*</label>
                            <div class="layui-input-block">
                                <input type="radio" lay-filter="bsUsersex" name="bsUsersex" value="0" title="男">
                                <input type="radio" lay-filter="bsUsersex" name="bsUsersex" value="1" title="女">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">真实姓名*</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsTruename" lay-verify="bsTruename" placeholder="请输入"  autocomplete="off"
                                       class="layui-input" required/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">生日*</label>
                            <div class="layui-inline">
                                <input type="text" name = "bsUserbrithday1"
                                       lay-verify="bsUserbrithday1" class="layui-input"
                                       id="birthday">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">QQ号</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsUserqq" placeholder="请输入QQ号" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">手机号*</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsUserphone" lay-verify="bsUserphone" placeholder="请输入手机号" autocomplete="off" class="layui-input"  required >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsUseremail" placeholder="请输入邮箱" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                          <div class="layui-form-item">
                            <label class="layui-form-label">所在省份*</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsProvince" lay-verify="bsProvince" placeholder="请输入您所在的省份"
                                       autocomplete="off"
                                       class="layui-input">
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