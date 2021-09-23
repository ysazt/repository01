<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    书的列表页如下： <a href="myshop" >我的购物车</a> <br/>
     <a href="myorderNotPay" >我的未支付订单</a><br/>
     <a href="myorderPay" >我的已支付订单</a><br/>
    <a href="chongzhi.jsp">充值</a> <br/>
    <a href="yuyue">我要预约</a>

    <table border="1">
        <tr>
            <td>书名</td>
            <td>价格</td>
        </tr>
        <c:forEach items="${allBook}" var="book">
            <tr>
                <td><a href="byidBook?id=${book.bookid}">${book.bname}</a></td>
                <td>${book.bprice}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
