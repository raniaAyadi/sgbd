<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>



<div class="panel panel-default">
  <div class="panel-heading">Update championnat</div>
  <div class="panel-body">
  
  
  <form action="" method="post">
  
  	<div class="form-group">
  		<label for="usr">date debut</label>
  		<input type="text" class="form-control" id="usr"  name="date_debut" value="${championnat.getDate_debut() }">
	</div>
	
	
	<div class="form-group">
  		<label for="a">date fin</label>
  		<input type="text" class="form-control" id="a"  name="date_fin" value="${championnat.getDate_fin() }">
	</div>
	
		<div class="form-group">
  		<label for="b">date fin</label>
  		<input type="text" class="form-control" id="b"  name="niveau" value="${championnat.getNiveau() }">
	</div>
  
  	<input  type="hidden" name="EC" value="1"  /> 	
  	<button type="submit" class="btn">submit</button>
  
  
  </form>
  
   </div>
</div>


















</t:wrapper>
