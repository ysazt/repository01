<%--
  Created by IntelliJ IDEA.
  User: Ambow
  Date: 2021/9/20
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 图书详情页面：
 <form action="addShop" method="post">
   图书名：${book.bname}
   图书价格：${book.bprice}
     <input type="hidden" name="bookid" value="${book.bookid}">
   购买量:<input type="text" name="snum" value="1">
         <input type="submit" value="加入购物车">
 </form>
</body>
</html>
