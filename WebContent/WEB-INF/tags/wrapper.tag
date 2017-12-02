<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">


  <head>


  <title>Projet SGBD</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  

  </head>

<!-- load current active page -->
<script>
var currentActivePage = <%	
	String s = (String) request.getAttribute("active");
	if(s == null){
		out.println("null");
	}else{
		out.println( "\"" + s +  "\"" );
	}
%>;
$(document).ready(function(){
    $("#" + currentActivePage).addClass(" active");
});

function redirect(url){
	window.location.href = url;
}
</script>



  <body>

    <!-- Navigation -->
    <div class="container">
    <div style="height:25px"></div>
		<div class="well">${header_message}</div>
  </div>



    <!-- Page Content -->
    <div class="container">
<div style="height:25px;"></div>
     <div class="row">
        <div class="col-lg-3">
          <div class="list-group">
            <a href="accueil" class="list-group-item" id="accueil">Accueil</a>
            <a href="matches" class="list-group-item" id="matches">Matches</a>
            <a href="clubs" class="list-group-item" id="clubs" >Clubs</a>
            <a href="responsables" class="list-group-item" id="responsables" >Responsables</a>
            <a href="equipes" class="list-group-item" id="equipes" >Equipes</a>
            <a href="joueurs" class="list-group-item" id="joueurs" >Joueurs</a>
            <a href="entraineurs" class="list-group-item" id="entraineurs" >Entraîneurs</a>
            <a href="championnats" class="list-group-item" id="championnats" >Championnats</a>
            <a href="statistiques" class="list-group-item" id="statistiques" >Statistiques</a>
          </div>
        </div>
        <!-- /.col-lg-3 -->
        <div class="col-lg-9">
        <style>
        	.upper_part button{
        		float:right;
        		heigth:30px;
        		margin-right:6px;
    
        	}
        </style>
  
				
			<jsp:doBody/>
            
        </div>
        <!-- /.col-lg-9 -->

</div>
<div style="height:50px;"></div>
    </div>
    <!-- /.container -->




    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy;  2017</p>
      </div>
      <!-- /.container -->
    </footer>

 
  </body>

</html>







