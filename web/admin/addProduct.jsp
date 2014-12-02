

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/customTld.tld" prefix="ct" %>
<%@ page language="java" isELIgnored="false" %>
<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_catalog.jsp" />


<td>
           <form action="addProduct" method="post">
            <p>* required fields</p>
            <table cellspacing="5" border="0">
             <tr>
                 <td align="right">Code</td>
                 <td><input type="text" value="bf01" name="code" <ct:ifEmptyMark color="blue" field="${product.code}"/>></td>
             </tr>
             <tr>
                 <td align="right">Description</td>
                 <td><input type="text" value="enter a description" name="description" <ct:ifEmptyMark color="blue" field="${product.description}"/>></td>
             </tr>
             <tr>
                 <td align="right">Price</td>
                 <td><input type="text" value="00.00" name="price" <ct:ifEmptyMark color="blue" field="${product.price}"/>></td><br>
             </tr>
            </table>
        
          <input type="submit" value="Add Product" />
        </form>
    </td>
<jsp:include page="/includes/column_right_news.jsp" flush="true" />
<jsp:include page="/includes/footer.jsp" />