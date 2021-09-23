<%--
  Created by IntelliJ IDEA.
  User: Ambow
  Date: 2021/9/20
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 我的购物车
   <table border="1">
       <tr>
           <td><input type="checkbox" name="all1" onclick="all1()"/> 全选</td>
           <td>图书名</td>
           <td>图书价格</td>
           <td>购买量</td>
       </tr>
       <c:forEach items="${shopList}" var="shop" varStatus="xx">
           <tr>
               <td><input type="checkbox" name="shop" value="${shop.shopid}"/> </td>
               <td>${shop.sbid.bname}</td>
               <td>${shop.sbid.bprice}</td>
               <td><input type="button" value="-">
                   <input type="text" value="${shop.snum}" id="snum${xx.index}">
                   <input type="button" value="+" onclick="addnum(${xx.index})">
               </td>
           </tr>
       </c:forEach>

       <tr>
           <td><a href="javascript:;" onclick="jiesuan()">结算</a></td>
       </tr>
   </table>
</body>

<script >

    function  addnum(index ){

        var val = document.getElementById("snum"+index).value;
       // alert(index+"..add.."+val);
        val = parseInt(val)+1 ;
        document.getElementById("snum"+index).value= val ;
    }

    function  jiesuan(){
        var shop1 = document.getElementsByName("shop");
        var str = "";
        var snum ="";
        for (var i = 0 ; i < shop1.length ; i ++){
            if(shop1[i].checked){
                var value = shop1[i].value;
                str+= value+"-" ;
                var snum1 = document.getElementById("snum"+i).value;
                snum += snum1 +"-"
            }
        }
        window.location.href="addOrder?sid="+str+"&snum="+snum;
    }

    function  all1(){
      var all1 = document.getElementsByName("all1");
      var shop1 = document.getElementsByName("shop");
      if(all1[0].checked){
          for (var i = 0 ; i < shop1.length ; i ++){
              shop1[i].checked = true ;
          }
      }else{
          for (var i = 0 ; i < shop1.length ; i ++){
              shop1[i].checked = false ;
          }
      }
    }
</script>
</html>
