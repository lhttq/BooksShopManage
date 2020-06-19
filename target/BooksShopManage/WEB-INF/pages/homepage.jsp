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
            var loginName;
            var press = [];
            var a = 0;
            <c:forEach items="${bsPressList}" var="b">
                press[a] = "${b.bsPressname}";
                a++;
            </c:forEach>
            a = 0;
             let $tr;
            <c:forEach items="${bsBooksList}" var="b">
                var url = "${b.bsBookcover}";
                var isbn = "${b.bsBooksn}"
                var bookname = "${b.bsBookname}";
                var price = "${b.bsBookprice}";
                $tr = $("<tr>\n" +
                "                <td>\n" +
                "                    <span class = \"image\"><img src="+url+" alt=\"\"></span>\n" +
                "                    <span>\n" +
                "                        <h6 class = \"bookName\">"+bookname+"</h6>\n" +
                "                        <span class=\"press\">"+press[a]+"</span>\n" +
                "                    </span>\n" +
                "                </td>\n" +
                "                <td>￥ "+price+"</td>\n" +
                "                <td>"+isbn+"</td>\n" +
                "                <td><a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">删除</a>" +
                "            <input type=\"hidden\" value='${b.bsBookid}'></td>\n" +
                "            </tr>");
                tbody.append($tr);
                a++;
            </c:forEach>
             $("#tbody").on('click','.layui-btn.layui-btn-danger.layui-btn-xs',function () {
                let bookId = $(this).next().val();
                let $tr = $(this).parent().parent();
               let index = $tr.index();
               alert(bookId);
               var data = '{"bsBookid":"'+bookId+'"}';
                $.ajax({
                    url:"../bsBooks/delById",
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
            //提交按钮
            layui.use('form', function(){
                var form = layui.form;
                form.render();
                //监听提交
                form.on('submit', function(data,e){
                    //var data = JSON.stringify(form.val("test1"));
                    data = data.field;
                    let img = $("#image").attr('src');
                    data.bsBookcover = img;
                    console.log(data);
                    data =
                        '{"bsBooksn":"'+data.bsBooksn+'",' +
                        '"bsBookname":"'+data.bsBookname+'",' +
                        '"bsBookauthor":"'+data.bsBookauthor+'",' +
                        '"bsBookclassid":'+data.bsBookclassid+',' +
                        '"bsBookbt1":"'+data.bsBookbt+'",' +
                        '"bsPressnum":"'+data.bsPressnum+'",' +
                        '"bsBookprice":'+data.bsBookprice+',' +
                        '"bsBookcover":"'+data.bsBookcover+'",' +
                        '"bsProvince":"'+data.bsProvince+'",' +
                        '"bsBooksnum":'+data.bsBooksnum+'}';
                    console.log(data);
                      $.ajax({
                        url:"insertBook",
                        contentType:"application/json;charset=UTF-8",
                        data:data,
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                            if(data>0){
                                layer.alert("书籍上传成功");
                            }else{
                                layer.alert("书籍上传失败");
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
                    bsBooksn:[/^[\u4e00-\u9fa5_a-zA-Z0-9]+$/,
                        "请输入正确的格式"
                    ]
                    ,
                    bsBookname:[/^[\u4e00-\u9fa5]+$/,
                        "请输入正确的格式"
                    ]
                    ,
                    bsBookauthor:[/^[\u4e00-\u9fa5_a-zA-Z0-9]+$/
                    , "请输入正确的格式"
                    ]
                    ,
                    bsBookclassid:[/^[0-9]{0,2}$/
                    , "请输入正确的格式"
                    ]
                    ,
                    bsPressnum:[/^[A-Za-z0-9]+$/
                    , "请输入正确的格式"
                    ]
                    ,
                    image:function (value) {
                        if($("#image").attr('src') == ""){
                            alert($("#image").attr('src'));
                            return "请上传图片";
                        }
                    }
                    ,
                    bsBookprice:[/^[0-9]+(.[0-9]{2})?$/
                        ,
                        "请输入正确的格式"
                    ]
                    ,
                    bsBooknum:[/^[0-9]{2}$/
                        , "请输入正确的格式"
                    ]
                    ,
                    bsBookbt:[ /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/
                        , "请输入正确的格式"
                    ]
                    ,
                    bsProvince:[/^[\u4e00-\u9fa5]+$/,
                        "请输入正确的格式"]
                    ,
                });
                form.render();
            });
              //日期函数
            layui.use('laydate', function(){
                var laydate = layui.laydate;
                //执行一个laydate实例
                laydate.render({
                    elem: '#test1'//指定元素
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
            <li class="layui-nav-item"><a href="../bsBookclass/selectAll">书籍类别管理</a></li>
            <li class="layui-nav-item"><a href="../bsPress/selectAll">出版社管理</a></li>
        </ul>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-tab layui-tab-card">
            <ul class="layui-tab-title">
                <li class="layui-this">查看所有书籍</li>
                <li>添加书籍</li>
                <li>修改书籍</li>
            </ul>
            <div class="layui-tab-content" style="height: 800px;">
                <div id="selectAll" class="layui-tab-item layui-show">
                     <table id="demo" class="layui-table"  lay-skin="nob" lay-filter="test">
                        <colgroup>
                            <col width="200">
                            <col width="200">
                            <col width="150">
                            <col width="100">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>图片</th>
                            <th>价格</th>
                            <th>ISBN</th>
                            <th>删除</th>
                        </tr>
                        </thead>
                        <tbody id="tbody"></tbody>
                    </table>
                </div>
                <div class="layui-tab-item">
                    <form class="layui-form" lay-filter="test1" method="post">
                        <div class="layui-form-item">
                            <label class="layui-form-label">图书编号*</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsBooksn" lay-verify="bsBooksn"
                                       placeholder="请输入图书编号"  autocomplete="off"
                                       class="layui-input" required/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">图书名称*</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsBookname" lay-verify="bsBookname"
                                       placeholder="请输入图书名称"  autocomplete="off"
                                       class="layui-input" required/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">图书作者</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsBookauthor"
                                       lay-verify="bsBookauthor" placeholder="请输入图书作者"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">图书类别id*</label>
                            <div class="layui-input-block">
                                <input type="number" name="bsBookclassid" lay-verify="bsBookclassid"
                                       placeholder="请输入图书类别id" autocomplete="off"
                                       class="layui-input"  required>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">图书出版日期*</label>
                            <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
                                <input type="text" name = "bsBookbt"
                                       lay-verify="bsBookbt" class="layui-input" id="test1">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">图书出版社编号*</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsPressnum" lay-verify="bsPressnum"
                                       placeholder="请输入出版社编号"  autocomplete="off"
                                       class="layui-input" required/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">图书价格*</label>
                            <div class="layui-input-block">
                                <input type="number" name="bsBookprice" lay-verify="bsBookprice"  placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <img id="image" name = "image" lay-verify="image" src="" alt="">
                            <label class="layui-form-label">图书照片*</label>
                            <div class="layui-input-block">
                                <input type="file" name = "bsBookcover" value="选择图片" accept="image/*" multiple="">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">所在省份*</label>
                            <div class="layui-input-block">
                                <input type="text" name="bsProvince" lay-verify="bsProvince" placeholder="请输入" autocomplete="off" class="layui-input"  required>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">书籍数量*</label>
                            <div class="layui-input-block">
                                <input type="number" name="bsBooksnum" lay-verify="bsBooksnum"  placeholder="请输入" autocomplete="off" class="layui-input">
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