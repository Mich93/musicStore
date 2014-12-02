<%-- 
    Document   : deleteProduct
    Created on : Sep 16, 2014, 11:25:18 AM
    Author     : stefano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/customTld.tld" prefix="ct" %>
<jsp:include page="/includes/header.html" />
<jsp:include page="/includes/column_left_catalog.jsp" />

<td>
        <h2>Do you really want to delete this product?</h2><br><br>
        
            
                    Product Code: ${product.code}<br>
                    Product Description: ${product.description}<br>
                    Product Price: ${product.price}<br>
        <form action="deleteProduct?code=${product.code}" method="post">  
            <input type="submit" value="Yes" />
        </form>
        <form action="/index.jsp" method="post">  
            <input type="submit" value="No" />
        </form>
</td>
<jsp:include page="/includes/column_right_news.jsp" flush="true" />
<jsp:include page="/includes/footer.jsp" />