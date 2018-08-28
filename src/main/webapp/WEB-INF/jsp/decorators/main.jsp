<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
    <title>E-Shop - <decorator:title/></title>
    <decorator:head/>
  </head>
  <body>
    <table class="titles">
      <tr>
      	<td id="nameTitle">Verkkokirppu</td>
        <td class="userName">
          Tunnus: <security:authentication property="principal.username"/> <br/>
          <a href="<c:url value="/j_spring_security_logout"/>">Kirjaudu ulos</a>
        </td>
      </tr>
    </table>
    <div class="page">
    
      <form method="get" action="<c:url value="/quick-search.action"/>">
        <table border="1" class="top">
          <tr class="headerLinks">
      	    <td class="width"><a class="headLinks" href="<c:url value="/browse-departments.action"/>"><div style="text-align: center;">Selaa osastoja</div></a></td>
            <td class="width"><a class="headLinks" href="<c:url value="/add-item.action"/>"><div style="text-align: center;">Myy tuote</div></a> </td>
            <td class="width"><a class="headLinks" href="<c:url value="/user-information.action"/>"><div style="text-align: center;">Omat tiedot</div></a> </td>
          </tr>
        </table>
      
        <div class="search">
	      <input type="text" name="title" size="40" />
	      <input type="submit" name="_search" value="Etsi"/>
	      <a class="searchLink" href="<c:url value="/search-items.action"/>">Yksityiskohtainen haku</a>
	    </div>
	  </form>
	
    <decorator:body/>
	</div>
  </body>
</html>
