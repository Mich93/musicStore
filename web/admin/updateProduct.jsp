<%-- 
    Document   : updateProduct
    Created on : Sep 16, 2014, 11:25:06 AM
    Author     : stefano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/customTld.tld" prefix="ct" %>
<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_catalog.jsp" />

<td>
        <h2>Update the product</h2><br>
        <form action="updateProduct" method="post">
            <p>* required fields</p>
            <table cellspacing="5" border="0">
             <tr>
                 <td align="right">Code</td>
                 <td><input type="text" name="code" value="${product.code}"><ct:ifEmptyMark color="blue" field="${product.code}"/> </td>
             </tr>
             <tr>
                 <td align="right">Description</td>
                 <td ><input type="text" value="${product.description}" name="description"><ct:ifEmptyMark color="blue" field="${product.description}"/></td>
             </tr>
             <tr>
                 <td align="right">Price</td>
                 <td><input type="text" value="${product.price}" name="price" ><ct:ifEmptyMark color="blue" field="${product.price}"/></td><br>
             </tr>
            </table>
        
        <input type="submit" value="Update Product" />
        </form>
</td>