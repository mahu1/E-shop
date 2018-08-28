<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>osastot</title>
  </head>
  <body>
  <div class="content">
  
    <h2>Valitse osasto</h2>

	<table class="departments">
	  <tr>
	    <td><a href="<c:url value="/quick-search.action?departmentId=1&_search"/>">Elokuvat</a></td>
		<td><a href="<c:url value="/quick-search.action?departmentId=9&_search"/>">Lelut ja pelit</a></td>
	  </tr>
	  <tr>
	    <td><a href="<c:url value="/quick-search.action?departmentId=2&_search"/>">Elektroniikka</a></td>
	    <td><a href="<c:url value="/quick-search.action?departmentId=10&_search"/>">Liput</a></td>
	  </tr>
	  <tr>
	    <td><a href="<c:url value="/quick-search.action?departmentId=3&_search"/>">Huonekalut</a></td>
	    <td><a href="<c:url value="/quick-search.action?departmentId=11&_search"/>">Musiikki</a></td>
	  </tr>
	  <tr>
	    <td><a href="<c:url value="/quick-search.action?departmentId=4&_search"/>">Keräily</a></td>
	    <td><a href="<c:url value="/quick-search.action?departmentId=12&_search"/>">Sekalaista</a></td>
	  </tr>
	  <tr>
	    <td><a href="<c:url value="/quick-search.action?departmentId=5&_search"/>">Kirjat ja lehdet</a></td>
	    <td><a href="<c:url value="/quick-search.action?departmentId=13&_search"/>">Soittimet</a></td>
	  </tr>
	  <tr>
	    <td><a href="<c:url value="/quick-search.action?departmentId=6&_search"/>">Koti</a></td>
	    <td><a href="<c:url value="/quick-search.action?departmentId=14&_search"/>">Taide</a></td>
	  </tr>
	  <tr>
	    <td><a href="<c:url value="/quick-search.action?departmentId=7&_search"/>">Kulkuneuvot</a></td>
	    <td><a href="<c:url value="/quick-search.action?departmentId=15&_search"/>">Vaatetus</a></td>
	  </tr>
	  <tr>
	    <td><a href="<c:url value="/quick-search.action?departmentId=8&_search"/>">Lasten tarvikkeet</a></td>
	    <td><a href="<c:url value="/quick-search.action?departmentId=16&_search"/>">Videopelit</a></td>
	  </tr>
	</table>

  </div>
  </body>
</html>
