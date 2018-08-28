<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <title>ostajan tietojen näyttäminen</title>
  </head>
  <body>
  <div class="content">
  
    <h2>Ostajan tiedot</h2>

	<table class="user">
	  <caption><c:out value="${user.userName}" /></caption>
	  <tr class="odd">
	    <th class="width">Nimi: </th>
	    <td><c:out value="${user.firstName}" /> <c:out value="${user.lastName}" /> </td>
	  </tr>
	  <tr>
	    <th>Lähiosoite: </th>
	    <td><c:out value="${user.address}" /> </td>
	  </tr>
	  <tr class="odd">
	    <th>Postinumero: </th>
	    <td><c:out value="${user.zipCode}" /> </td>
	  </tr>
	  <tr>
	    <th>Postitoimipaikka: </th>
	    <td><c:out value="${user.homeTown}" /> </td>
	  </tr>
	  <tr class="odd">
	    <th>Puhelinnumero: </th>
	    <td><c:out value="${user.areaCode}" />-<c:out value="${user.phoneNumber}" /> </td>
	  </tr>
	  <tr>
	    <th>Sähköpostiosoite: </th>
	    <td><c:out value="${user.mail}" /> </td>
	  </tr>
	</table>

  </div>
  </body>
</html>