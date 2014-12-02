<td width="166" valign="top">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="<c:url value='/cart/displayCart?productCode=${product.code}'/>">
    <img src="/music/images/addtocart.gif" width="113" height="47">
</a><br><br>
<a href="<c:url value='/cart/displayCart'/>">
    <img src="/music/images/showcart.gif" width="113" height="47">
</a><br><br>
    <a href="<c:url value='/catalog/checkUser' />">
        <img src="/music/images/listen.gif" width="113" height="47">
    </a><br><br>
</td>