<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>käyttäjän tiedot</title>
  </head>
  <body>
  <div class="content">
    <h2>Käyttäjän tiedot</h2>

	<table class="userInformation">
	  <tr>
	    <caption>Käyttäjätiedot</caption>
	    <td><a href="<c:url value="/edit-user.action"/>">Katso/muokkaa käyttäjätietoja</a></td>
	  </tr>
	</table>
	
	<br/>
	
	<table class="items">
      <caption>Tuotteet</caption>
      <tr>
        <th class="items">Myymättömät tuotteet</th>
        <th class="items">Ostetut tuotteet</th>
      </tr>
      <tr>
        <td><a href="<c:url value="/view-open-items.action"/>">Käyttäjän myynnissä olevat tuotteet</a></td>
        <td><a href="<c:url value="/view-sold-items.action"/>">Käyttäjän myydyt tuotteet</a></td>
      </tr>
      <tr>
        <td><a href="<c:url value="/view-unsold-items.action"/>">Käyttäjän myynnistä poistuneet tuotteet</a></td>
        <td><a href="<c:url value="/view-orders.action"/>">Käyttäjän omat ostot</a></td>
      </tr>
    </table>

  </div>
  </body>
</html>