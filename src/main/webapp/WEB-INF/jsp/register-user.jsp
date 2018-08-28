<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles(out).css"/>"/>
    <title>rekisteröinti</title>
  </head>
  <body>
  <div class="content">
  
	<c:if test="${addError == true}">
	  <p class="feedback">
	  Valittu käyttäjätunnus on jo käytössä - vaihda käyttäjätunnusta.
	  </p>
	</c:if>

	<form:form>
	  <form:errors path="*" cssClass="errors"/>
	  <h2>Rekisteröidy</h2>
	  <table class="register">
	    <tr>
	      <th>Käyttäjätunnus: </th>
	      <td><form:input path="userName" /></td>
	    </tr>
	    <tr>
	      <th>Salasana: </th>
	      <td><form:password showPassword="true" path="password" /></td>
	    </tr>
	    <tr>
	      <th>Salasana uudelleen: </th>
	      <td><form:password showPassword="true" path="password2" /></td>
	    </tr>
	    <tr>
	      <th>Etunimi: </th>
	      <td><form:input path="firstName" /></td>
	    </tr>
	    <tr>
	      <th>Sukunimi: </th>
	      <td><form:input path="lastName" /></td>
	    </tr>
	    <tr>
	      <th>Lähiososite: </th>
	      <td><form:input path="address" size="30" /></td>
	    </tr>
	    <tr>
	      <th>Postinumero: </th>
	      <td><form:input path="zipCode" size="7" maxlength="5" /></td>
	    </tr>
	    <tr>
	      <th>Postitoimipaikka: </th>
	      <td><form:input path="homeTown" size="15" /></td>
	    </tr>
	    <tr>
	      <th>Puhelinnumero: </th>
	      <td>
	        <form:input path="areaCode" size="3" maxlength="3" />
	        -
	        <form:input path="phoneNumber" size="10" maxlength="10" />
	      </td>
	    </tr>
	    <tr>
	      <th>Sähköpostiosoite: </th>
	      <td><form:input path="mail" size="30" /></td>
	    </tr>
	    <tr>
	      <td/>
	      <td><br/><input type="submit" value="Rekisteröidy" /></td>
	    </tr>
	  </table>
	</form:form>
	
	<p>
      <a href="<c:url value="/login.action"/>">Takaisin</a>
	</p>

  </div>
  </body>
</html>