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

	<h3>Hakutulokset</h3>
	<c:if test="${empty searchResults}">
	  Ei hakutuloksia.
	</c:if>
	
	<c:if test="${not empty searchResults}">
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