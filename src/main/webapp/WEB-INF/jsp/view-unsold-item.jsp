<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <title>tuotteen tietojen näyttäminen</title>
  </head>
  <body>
  <div class="content">
  
    <c:if test="${itemBought == true}">
   	  <p class="feedback">
	    Tuote on jo ostettu. 
	  </p>
	</c:if>
  
    <c:if test="${param.itemAdded == true}">
   	  <p class="feedback">
	    Tuote asetettu myyntiin. 
	  </p>
	</c:if>
	
	<c:if test="${param.itemRemoved == true}">
   	  <p class="feedback">
	    Tuote poistettu myynnistä. 
	  </p>
	</c:if>
  
    <c:if test="${buySucceed == true}">
      <p class="feedback">	
	    Olet ostanut tuotteen. 
	  </p>
	</c:if>
  
    <h2>Tuotteen tiedot</h2>

	<table class="item">
	  <caption><c:out value="${item.title}" /></caption>
	  <tr class="odd">
	    <th class="width">Hinta:</th>
	    <td><c:out value="${item.price}" />  € </td>
	  </tr>
	  <tr>
	    <th>Sijainti:</th>
	    <td><c:out value="${item.location}" /> </td>
	  </tr>
	  <tr class="odd">
	    <th>Osasto:</th>
	    <td><c:out value="${item.department}" /> </td>
	  </tr>
	  <tr>
	    <th>Myyjä:</th>
	    <td><c:out value="${item.seller}" /> </td>
	  </tr>
	  <tr class="odd">
	    <th>Ilmoitusaika:</th>
	    <td><joda:format value="${item.createTime}" style="SL" locale="" /> </td>
	  </tr>
	  <tr>
	    <th>Sulkeutumisaika:</th> 
	    <td><joda:format value="${item.endTime}" style="SL" locale="" /></td>
	  </tr>
	  <tr class="odd">
	    <th valign="top">Kuvaus:</th>
	    <td><form:textarea path="item.description" readonly="true" cols="60" rows="13" cssStyle="font-family: Times New Roman; font-size: 14px;" tabindex="5"/></td>
	  </tr>
	  
	  <tr>
	    <td colspan="2"><hr/></td>
	  </tr>
	
	  <c:if test="${isInSell == true && isUsersUnsoldItem == false}">
	    <tr>
		  <td>
		    <form:form>
		      <td><input type="submit" value="Osta" /></td>
		    </form:form>
		  </td>
		</tr>
	  </c:if>
	
	  <c:if test="${isInSell == true && isUsersUnsoldItem == true}">
		<tr>
		<td/>
		  <td>
		    <table>
			  <tr>
			    <td>
		          <form:form method="get" action="edit-item.action">
		            <input type="hidden" name="itemId" value="${param.itemId}" />
		            <input type="submit" value="Muokkkaa" />
		          </form:form>
		        </td>

				<td>
	    		  <form:form action="remove-item.action">
                    <input type="hidden" name="itemId" value="${param.itemId}" />
	                <input type="submit" value="Poista myynnistä" />
	    		  </form:form>
	    		</td>
	    	  </tr>
	    	</table>
		  </td>
		</tr>
	  </c:if>
	
      <c:if test="${isInSell == false && isUsersUnsoldItem == true}">
        <tr>
		  <td>
	        <form:form method="get" action="add-item.action">
	          <input type="hidden" name="itemId" value="${param.itemId}" />
	          <td><input type="submit" value="Myy uudelleen" /></td>
	        </form:form>
	      </td>
        </tr>
      </c:if>
    </table>
    
  </div>
  </body>
</html>