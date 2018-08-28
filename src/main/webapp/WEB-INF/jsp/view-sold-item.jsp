<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <title>tuotteen tietojen näyttäminen</title>
  </head>
  <body>
  <div class="content">

    <h2>Tuotteen tiedot</h2>

	<table class="item">
	  <caption><c:out value="${item.title}" /></caption>
	  <tr class="odd">
	    <th class="width">Hinta:</th>
	    <td><c:out value="${item.price}" />  € </td>
	  </tr>
	  <tr>
	    <th>Sijainti:</th>
	    <td><c:out value="${item.location}" /> </td>
	  </tr>
	  <tr class="odd">
	    <th>Osasto:</th>
	    <td><c:out value="${item.department}" /> </td>
	  </tr>
	  <tr>
	    <th>Myyjä:</th> 
	    <td><a href="/e-shop/view-seller.action?sellerId=<c:out value="${item.sellerId}" />"/"><c:out value="${item.seller}" /></a></td>
	  </tr>
	  <tr class="odd">
	    <th>Ostaja:</th> 
	    <td><a href="/e-shop/view-buyer.action?buyerId=<c:out value="${item.buyerId}" />"/"><c:out value="${item.buyer}" /></a> </td>
	  </tr>
	  <tr>
	    <th>Ilmoitusaika:</th>
	    <td><joda:format value="${item.createTime}" style="SL" locale="" /> </td>
	  </tr>
	  <tr class="odd">
	    <th>Ostoaika:</th> 
	    <td><joda:format value="${item.endTime}" style="SL" locale="" /></td>
	  </tr>
	  <tr>
	    <th valign="top">Kuvaus:</th>
	    <td><form:textarea path="item.description" readonly="true" cols="60" rows="13" cssStyle="font-family: Times New Roman; font-size: 14px;" tabindex="5"/></td>
	  </tr>
    </table>

  </div>
  </body>
</html>