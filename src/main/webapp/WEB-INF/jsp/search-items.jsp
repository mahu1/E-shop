<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net/el" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/displaytag.css"/>"/>
    <title>tuotteiden etsiminen</title>
  </head>
  <body>
  <div class="content">
    <h2>Etsi tuotteita</h2>
    
	<form:form method="GET">
	  <form:errors path="*" />
	  <table class="normal">
	    <tr>
	      <th>Hakusanat:</th>
	      <td><form:input path="title" size="40" tabindex="1" /></td>
	    </tr>
	    <tr>
	      <th>Hinta:</th>
	      <td>
	        <form:input path="minPrice" size="7" tabindex="2"/>
	        € - 
	        <form:input path="maxPrice" size="7" tabindex="3" />
	        € 
	      </td>
	    </tr>
	    <tr>
	      <th>Sijainti:</th>
	      <td>
	        <form:select path="locationId" tabindex="4" >
	          <form:option value="0">Koko Suomi</form:option>
	  	      <form:options itemValue="locationId" itemLabel="district" items="${locations}" />
	        </form:select>
	      </td>
	    </tr>
	    <tr>
	      <th>Osasto:</th>
	      <td>
	        <form:select path="departmentId" tabindex="5" >
	          <form:option value="0">Kaikki</form:option>
	  	      <form:options itemValue="departmentId" itemLabel="title" items="${departments}" />
	        </form:select>
	      </td>
	    </tr>
	    <tr>
	      <th>Myyjä:</th>
	      <td><form:input path="seller" tabindex="6" /></td>
	    </tr>
        <tr>
          <td/>
          <td><br/><input type="submit" name="_search" value="Etsi" tabindex="7" /></td>
	    </tr>
	  </table>
	</form:form>
	</div>
	
	<c:if test="${emptyList == true}">
	  <br/>  
	  Ei hakutuloksia. 
	</c:if>
	
	<c:if test="${not empty searchResults}">
	  <h3>Hakutulokset</h3>
	  <display:table id="current" class="displayTable" name="searchResults" requestURI="" pagesize="100" defaultsort="1" >
	    <display:column class="title1" property="title" title="Tuote" sortable="true" href="view-unsold-item.action" paramId="itemId" paramProperty="itemId" />
	    <display:column property="price" title="Hinta" sortable="true" />
	    <display:column property="department" title="Osasto" sortable="true" />
	    <display:column title="Sulkeutumisaika" sortable="true">
	      <joda:format value="${current.endTime}" style="SL" locale="" />
	    </display:column>
	  </display:table>
	</c:if>
	
  </body>
</html>