<%--
  Created by IntelliJ IDEA.
  User: Ambow
  Date: 2021/9/20
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <form action="yuyueAdd" method="post">

       预约初始时间：<input type="datetime-local" name="ytimebegin" onblur="yuyue(this.value)">
       请选择要约的书：<select name="ybid.bookid" id="allbooks">
       <%--<c:forEach items="${books}" var="book">
           <option value="${book.bookid}">${book.bname}</option>
       </c:forEach>--%>
   </select>  <br/>

       <input type="submit" value="预约">
   </form>
</body>
</html>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    function yuyue(val){
        $.ajax({
            url:"allBookByTime",
            method:"post",
            data:{time:val},
            dataType:"json",
            success:function (data){
                $("#allbooks").empty();
                var val = "";
                for (var i = 0 ; i < data.books.length ; i ++){
                    val += "<option value="+data.books[i].booid+">"+data.books[i].bname+"</option>"
                }
                $("#allbooks").append(val)
            }
        });
    }
</script>