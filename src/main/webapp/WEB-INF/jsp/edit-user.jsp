<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>muokkaa käyttäjän tietoja</title>
  </head>
  <body>
  <div class="content">
  
    <c:if test="${updateSucceed == true}">
      <p class="feedback">
	    Käyttäjätiedot päivitetty.
	  </p>
	</c:if>

	<form:form>
	  <form:errors path="*" cssClass="errors" />
	  <h2>Muokkaa käyttäjätietoja</h2>
	  <table class="normal">
	    <caption><c:out value="${user.userName}" /></caption>
	    <tr>
	      <th>Salasana:</th>
	      <td><form:password showPassword="true" path="password" tabindex="1"/></td>
	    </tr>
	    <tr>
	    <th>Salasana uudelleen:</th>
	      <td><form:password showPassword="true" path="password2" tabindex="2"/></td>
	    </tr>
	    <tr>
	      <th>Etunimi:</th>
	      <td><form:input path="firstName" tabindex="3"/></td>
	    </tr>
	    <tr>
	      <th>Sukunimi:</th>
	      <td><form:input path="lastName" tabindex="4"/></td>
	    </tr>
	    <tr>
	      <th>Lähiosoite:</th>
	      <td><form:input path="address" size="35" tabindex="5"/></td>
	    </tr>
	    <tr>
	      <th>Postinumero:</th>
	      <td><form:input path="zipCode" size="7" maxlength="5" tabindex="6"/></td>
	    </tr>
	    <tr>
	      <th>Postitoimipaikka:</th>
	      <td><form:input path="homeTown" size="15" tabindex="7"/></td>
	    </tr>
	    <tr>
	      <th>Puhelinnumero:</th>
	      <td>
	        <form:input path="areaCode" size="3" maxlength="3" tabindex="8"/>
	        -
	        <form:input path="phoneNumber" size="10" maxlength="10" tabindex="9"/>
	      </td>
	    </tr>
	    <tr>
	      <th>Sähköpostiosoite:</th>
	      <td><form:input path="mail" size="35" tabindex="10"/></td>
	    </tr>
	    <tr>
	      <td/>
	      <td><br/><input type="submit" action="onSubmit" value="Päivitä" tabindex="11"/></td>
	    </tr>
	  </table>
	</form:form>
	
  </div>
  </body>
</html>