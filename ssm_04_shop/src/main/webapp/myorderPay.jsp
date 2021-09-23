<%--
  Created by IntelliJ IDEA.
  User: Ambow
  Date: 2021/9/20
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 已支付列表
  <c:forEach items="${myorder}" var="orders" varStatus="xx">
      订单号：${orders.orderid.oid}
      商品名：${orders.obid.bname}
      商品单价：${orders.oprice}
      商品数量：${orders.onum}
      <span id="price${xx.count}"> ${orders.oprice}</span>
      <span id="num${xx.count}"> ${orders.onum}</span>

  </c:forEach>
</body>

<script>
    function  zhifu(val){

       var price = document.getElementById("price"+val).innerHTML;
       var num = document.getElementById("num"+val).innerHTML;
       alert(price +"...."+num)
       var qian = price * num ;
       var moneys = document.getElementById("money").value;
       if(moneys>= qian){
           alert("有钱人，请取支付吧")
           window.location.href="zhifu?qian="+qian;
       }else{
           alert("你这么穷，赶紧充值吧");
           window.location.href="chongzhi.jsp";
       }

    }
</script>
</html>
