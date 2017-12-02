<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapper>



      <div class="row" style="margin-bottom:10px;"> 
		<div class="upper_part">
		<button type="button" class="btn btn-success" onclick="redirect('/sgbd/update?EC=1&update&id=3')" >${green_button}</button>
		</div>
		</div>


<div class="panel panel-default">
  <div class="panel-heading">Description de la requête: ${description}
  	<div style="float:right">${nb_results } resultats</div>
  </div>
  <div class="panel-body">
  	<table class="table table-bordered">
  <thead>
    
  <tr>
    	<th>ID </th>
    	<th>NIVEAU </th>
    	<th>DATE DEBUT </th>
    	<th>DATE FIN </th>
</tr>
   
  </thead>
  <tbody>
  
  <c:forEach items="${all}" var="line">
  <tr>
  	<td>${line.getId()}</td>
  	<td>${line.getNiveau()}</td>
  	<td>${line.getDate_debut()}</td>
  	<td>${line.getDate_fin()}</td>
  	</tr>
  </c:forEach>  
  </tbody>
</table>
  
<c:if test="${show_actions}"> 
	<div class="jumbotron">
	    <h4>Actions</h4> 
	    <ul>
		    <c:forEach items="${actions}" var="action">
		            <li> <a href="#"><c:out value="${action}"/></a></li>
		    </c:forEach>
		</ul>
	</div>
</c:if>
  

  
  </div>
</div>




</t:wrapper>
