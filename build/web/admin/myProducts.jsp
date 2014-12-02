

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" isELIgnored="false" %>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_catalog.jsp" />

         <td>
        <table border="3">
           <tr>
            <td><b>Code<b></td>
            <td><b>Description<b></td>
            <td><b>Price<b></td>
           </tr>
           <c:forEach var="item" items="${items}">
           <tr>
            <td>${item.code}</td>
            <td>${item.description}</td>
            <td>${item.price}</td>
            <td><a href="manageMyProducts?code=${item.code}&callee=update">Edit</a></td>
            <td><a href="manageMyProducts?code=${item.code}&callee=delete">Delete</a></td>
           </tr>
           </c:forEach>
        </table>
        <form action="/music/admin/addProduct.jsp" method="post">
          <input type="submit" name="add" value="Add Product" />
        </form>
         </td>
<jsp:include page="/includes/column_right_news.jsp" flush="true" />
<jsp:include page="/includes/footer.jsp" />