<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>tuotteen lisääminen</title>
  </head>
  <body>
  <div class="content">

	<form:form>
	  <form:errors path="*" cssClass="errors"/>
	  <h2>Täytä tuotteen tiedot</h2>
	  <table class="normal">
	    <tr>
	      <th>Otsikko:</th>
	      <td><form:input path="title" size="66" tabindex="1"/></td>
	    </tr>
		<tr>
	      <th>Hinta:</th>
	      <td><form:input path="price" size="7" tabindex="2"/> €</td>
	    </tr>
	    <tr>
	      <th>Sijainti:</th>
	      <td>
	        <form:select path="locationId" tabindex="3">
	          <form:option value="0">Valitse sijainti</form:option>
	  	      <form:options itemValue="locationId" itemLabel="district" items="${locations}" />
	        </form:select>
	      </td>
	    </tr>
	  <tr>
	    <th>Osasto:</th>
	    <td>
	      <form:select path="departmentId" tabindex="4">
	        <form:option value="0">Valitse osasto</form:option>
	  	    <form:options itemValue="departmentId" itemLabel="title" items="${departments}" />
	      </form:select>
	    </td>
	  </tr>
	  <tr>
	    <th>Aukioloaika:</th>
	    <td><form:input path="sellingTime" size="3" tabindex="5"/> vuorokautta</td>
	  </tr>
	  <tr>
	    <th valign="top">Kuvaus:</th>
	    <td><form:textarea path="description" cols="50" rows="12" tabindex="6"/></td>
	  </tr>
	  <tr>
	    <td/>
	    <td><br/>
	      <input type="submit" value="Aseta myyntiin" tabindex="7"/>
	    </td>
	  </tr>
	  </table>
	</form:form>

  </div>
  </body>
</html>