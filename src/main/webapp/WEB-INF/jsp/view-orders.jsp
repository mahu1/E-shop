<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net/el" %>

<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/displaytag.css"/>"/>
    <title>käyttäjän ostot</title>
  </head>
  <body>
    <h2>Käyttäjän ostot</h2>
    
    <c:if test="${empty searchResults}">
	  Ei ostoja. 
	</c:if>

	<c:if test="${not empty searchResults}">
	  <display:table id="current" class="displayTable" name="searchResults" requestURI="" pagesize="100" defaultsort="1" >
	    <display:column class="title1" property="itemTitle" title="Tuote" sortable="true" href="view-sold-item.action" paramId="itemId" paramProperty="itemId" />
	    <display:column property="price" title="Hinta" sortable="true" />
	    <display:column property="department" title="Osasto" sortable="true" />
	    <display:column title="Ostoaika" sortable="true">
	      <joda:format value="${current.orderTime}" style="SL" locale="" />
	    </display:column>
		<display:column property="seller" title="Myyjä" sortable="true" href="view-seller.action" paramId="sellerId" paramProperty="sellerId" />
	  </display:table>
	</c:if>

  </body>
</html>