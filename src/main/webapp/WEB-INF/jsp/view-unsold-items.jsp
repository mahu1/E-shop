<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net/el" %>

<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/displaytag.css"/>"/>
    <title>käyttäjän myymättömät myynnistä poistuneet tuotteet</title>
  </head>
  <body>

    <h2>Käyttäjän myymättömät myynnistä poistuneet tuotteet</h2>

	<c:if test="${empty searchResults}">
	  Ei myymättömiä myynnistä poistuneita tuotteita. 
	</c:if>

	<c:if test="${not empty searchResults}">
	  <display:table id="current" class="displayTable" name="searchResults" requestURI="" pagesize="100" defaultsort="1" >
	    <display:column class="title2" property="title" title="Tuote" sortable="true" href="view-unsold-item.action" paramId="itemId" paramProperty="itemId" />
	    <display:column property="price" title="Hinta" sortable="true" />
	    <display:column property="department" title="Osasto" sortable="true" />
	    <display:column title="Ilmoitusaika" sortable="true">
	      <joda:format value="${current.createTime}" style="SL" locale="" />
	    </display:column>
	    <display:column title="Sulkeutumisaika" sortable="true">
	      <joda:format value="${current.endTime}" style="SL" locale="" />
	    </display:column>
	  </display:table>
	</c:if>

  </body>
</html>