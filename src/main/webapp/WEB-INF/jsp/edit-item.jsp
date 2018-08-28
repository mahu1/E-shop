<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<html>
  <head>
    <title>muokkaa tuotteen tietoja</title>
  </head>
  <body>
  <div class="content">
    
   	<c:if test="${updateSucceed == true}">
   	  <p class="feedback">
	    Tuotteen tiedot päivitetty.
	  </p>
	</c:if>
	
	<form:form>
	  <form:errors path="*" cssClass="errors"/>
      <h2>Muokkaa tuotteen tietoja</h2>
	  <table class="normal">
	    <caption class="times">
	      <strong>Tuote ilmoitettu:</strong>
	      <joda:format value="${item.createTime}" style="SL" locale="" /> <br/>
	      <strong>Tuote sulkeutuu:</strong> 
	      <joda:format value="${item.endTime}" style="SL" locale="" />
	    </caption>
	    <tr>
	      <th>Otsikko:</th>
	      <td><form:input path="title" size="66" tabindex="1"/></td>
	    </tr>
	    <tr>
	      <th>Hinta:</th>
	      <td><form:input path="price" size="7" tabindex="2"/></td>
	    </tr>
	    <tr>
	      <th>Sijainti:</th>
	      <td>
	        <form:select path="locationId" tabindex="3">
	  	      <form:options itemValue="locationId" itemLabel="district" items="${locations}"/>
	        </form:select>
	      </td>
	    </tr>
	    <tr>
	      <th>Osasto:</th>
	      <td>
	        <form:select path="departmentId" tabindex="4">
	  	      <form:options itemValue="departmentId" itemLabel="title" items="${departments}"/>
	        </form:select>
	      </td>
	    </tr>
	    <tr>
	      <th valign="top">Kuvaus:</th>
	      <td><form:textarea  path="description" cols="50" rows="13" tabindex="5"/></td>
	    </tr>
	  	<tr>
	  	<td/>
	  	<td>
	      <br/>
	      <input type="submit" value="Päivitä" tabindex="6"/>
	    </td>
	    </tr>
	  </table>
	</form:form>
	
  </div>
  </body>
</html>