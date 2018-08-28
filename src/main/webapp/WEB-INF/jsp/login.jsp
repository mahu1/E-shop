<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles(out).css"/>"/>
    <title>sisäänkirjautuminen</title>
  </head>
  <body>

    <c:if test="${param.failure == true}">
      <p class="feedback">
	    Käyttäjätunnus tai salasana on virheellinen. 
	  </p>
	</c:if>
	
	 <c:if test="${param.logout == true}">
	   <p class="feedback">
	    Olet kirjautunut ulos järjestelmästä. 
	  </p>
	</c:if>
  
  	<c:if test="${param.userAdded == true}">
      <p class="feedback">
	    Olet rekisteröitynyt sovelluksen käyttäjäksi. 
	  </p>
	</c:if>

    <h2>Kirjaudu sisään</h2>

	<form:form action="j_spring_security_check">
	  <table class="login">
	    <tr>
	      <td>Käyttäjätunnus: </td>
	      <td><input type="text" size="20" name="j_username" tabindex="1"/> </td>
	    </tr>
	    <tr>
	      <td>Salasana: </td>
	      <td><input type="password" size="20" name="j_password" tabindex="2"/> </td>
		</tr>
	    <tr>
	      <td/>
	      <td><input type="submit" value="Kirjaudu sisään" tabindex="3"/></td>
	    </tr>
	  </table>
	</form:form>

  
    <p>
      <a href="<c:url value="/register-user.action"/>">Rekisteröi käyttäjä</a>
    </p>

  </body>
</html>