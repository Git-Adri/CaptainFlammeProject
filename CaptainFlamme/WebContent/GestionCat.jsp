<%@ page language="java" 
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="beans.Charge,beans.GroupeCharge,beans.Interrupteur,beans.Category,java.util.*"
%>
<!DOCTYPE html>
<html lang="en">

	<head>
	
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>ReCap</title>
	
	    <!-- Bootstrap Core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <link href="css/interface.css" rel="stylesheet">
	
	
	    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
		<style>   
		.pull-bottom{
			display: inline-block;
	    	vertical-align: bottom;
	    	float: none;}
	    </style>
	</head>

	<body>
	    <!-- Header -->
	<div class="container-fluid header-logo">
	  <div class="row">
		<div class="col-xs-12 col-md-8"><a href="#"><img src="images/logo.png"></a></div>
		<div class="col-xs-12 col-md-2 user-prof pull-right"><a href="#"><img src="images/profile.png"></a> TestUser</div>
	  </div>
	</div>
		
		<!-- Navigation -->
	<nav class="navbar navbar-inverse nav-main" role="navigation">
	        <div class="container-fluid">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                </button>
	            </div>
	            <!-- Collect the nav links, forms, and other content for toggling -->
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav">
	                    <li>
	                        <a href="#">Visualiser r�seau</a>
	                    </li>
	                    <li>
	                        <a href="#">Cat�gories</a>
	                    </li>
						<li>
	                        <a href="#">G�n�rer rapport	</a>
	                    </li>
						<li>
	                        <a href="#">Action	</a>
	                    </li>
						<li>
	                        <a href="#">Autre	</a>
	                    </li>
	                </ul>
	            </div>
	            <!-- /.navbar-collapse -->
	        </div>
	        <!-- /.container -->
	</nav>
	    <div class="container-fluid main-page">
			<div class ="row">
				<!-- Page Content -->
			        <div class="col-md-2 menu_gauche ">
		                <p class="lead">Administration</p>
		                <div class="list-group">
							<a href="#" class="list-group-item">Gestion cat�gories</a>
		                    <a href="#" class="list-group-item">Gestion utilisateurs</a>
		                    <a href="#" class="list-group-item">Gestion du r�seau</a>
		                </div>
		            </div>
		    	<div class="container col-md-10 main-content">
		    	<h3>Gestion cat�gories</h3>
	    	
		<div class="panel-group" id="accordion">
		  
		  <%
			%>
			<%= (String)request.getAttribute("test")%>
			
			<%

			ArrayList<Category> lstCat =(ArrayList<Category>) request.getAttribute("list");;
			if(lstCat!=null){
				Iterator<Category> itr = lstCat.iterator();
						
				Category cat;
				int i = 0;
			
				while(itr.hasNext()){
					cat = (Category)itr.next();
					i++;			
			%>
						  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a data-toggle="collapse" data-parent="#accordion" href=<%="#collapse"+i%>>
			        <%=cat.getNomCategory()%></a>
			      </h4>
			    </div>
			    <div id=<%="collapse"+i %> class="panel-collapse collapse">
			  	  <div class="panel-body">
			         <div class="row">
				      	<div class="pull-bottom">
				      		<h4>Charges</h4>
				      	</div>
				        <div class="pull-right pull-bottom">
					       <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">Ajouter charge</button>
			    
			      
				  
		        		</div>
			        </div>
					    <table class="table">
						  <thead>
						    <tr>
						      <th scope="col" class="col-sm-3">Nom</th>
						      <th scope="col" class="col-sm-3">Boitier</th>
						      <th scope="col" class="col-sm-3">Charge</th>
						      <th scope="col" class="col-sm-2">Editer</th>
						      <th scope="col" class="col-sm-1">Supprimer</th>
						    </tr>
						  </thead>
						  <tbody>
						  <% for(Charge c : cat.getCharges()){ %>
						    <tr>
						      <th scope="row"><%= c.getNomCharge()%></th>
						      <td><%= c.getNumBoitier()%></td>
						      <td><%= c.getIdCharge()%></td>
						      <td>edit</td>
						      <td><a href="#">X</a></td>
						    </tr>
						    <tr>
						    
					 <%}%>
				      
						  </tbody>
						</table>
    				</div>
    				 <div class="panel-body">
			         <div class="row">
				      	<div class="pull-bottom">
				      		<h4>Groupe Charge</h4>
				      	</div>
				        <div class="pull-right pull-bottom">
					       <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">Ajouter charge</button>
			    
			      
				  
		        		</div>
			        </div>
					    <table class="table">
						  <thead>
						    <tr>
						      <th scope="col" class="col-sm-3">Nom</th>
						      <th scope="col" class="col-sm-3">Id</th>
						      <th scope="col" class="col-sm-3">Consommation</th>
						      <th scope="col" class="col-sm-2">Editer</th>
						      <th scope="col" class="col-sm-1">Supprimer</th>
						    </tr>
						  </thead>
						  <tbody>
						  <% for(GroupeCharge c : cat.getGroupesCharge()){ %>
						    <tr>
						      <th scope="row"><%= c.getNomGroupe()%></th>
						      <td><%= c.getIdGroupe()%></td>
						      <td><%= c.getConsommation()%></td>
						      <td>edit</td>
						      <td><a href="#">X</a></td>
						    </tr>
						    <tr>
						    
					 <%}%>
				      
						  </tbody>
						</table>
    				</div>
    				 <div class="panel-body">
			         <div class="row">
				      	<div class="pull-bottom">
				      		<h4>Interrupteurs</h4>
				      	</div>
				        <div class="pull-right pull-bottom">
					       <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">Ajouter charge</button>
			    
			      
				  
		        		</div>
			        </div>
					    <table class="table">
						  <thead>
						    <tr>
						      <th scope="col" class="col-sm-3">Nom</th>
						      <th scope="col" class="col-sm-3">Id</th>
						      <th scope="col" class="col-sm-3">Etat</th>
						      <th scope="col" class="col-sm-2">Editer</th>
						      <th scope="col" class="col-sm-1">Supprimer</th>
						    </tr>
						  </thead>
						  <tbody>
						  <% for(Interrupteur c : cat.getInterrupteurs()){ %>
						    <tr>
						      <th scope="row"><%= c.getId()%></th>
						      <td><%= c.getNom() %></td>
						      <td><%= c.getEtatActuel()%></td>
						      <td>edit</td>
						      <td><a href="#">X</a></td>
						    </tr>
						    <tr>
						    
					 <%}%>
				      
						  </tbody>
						</table>
    				</div>
    					
	  			</div>
			</div>
		<% }
}%>
		
	</div> <!-- /container -->
	    </div> 
		</div>
		<div class="modal fade" id="myModal" role="dialog">
			    <div class="modal-dialog">
			    
			      <!-- Modal content-->
			      <div class="modal-content">
			      	<form>
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title">Ajouter charge</h4>
			        </div>
			        <div class="modal-body">
			          <div class="form-group">
						  <label for="sel1">Choisir boitier:</label>
						  <select class="form-control" id="sel1">
						    <option>1</option>
						    <option>2</option>
						    <option>3</option>
						    <option>4</option>
						  </select>
						</div>
						<div class="form-group">
						  <label for="sel1">Choisir charge:</label>
						  <select class="form-control" id="sel1">
						    <option>1</option>
						    <option>2</option>
						    <option>3</option>
						    <option>4</option>
						  </select>
						</div>
			        
			          
			        </div>
			        <div class="modal-footer">
			          <button type="submit" class="btn btn-primary">Valider</button>
			        
			          <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
			        </div>
			        </form>
			      </div>
			      
			    </div>
			  </div>
	       <hr>
	</div>
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; ReCap</p>
                </div>
            </div>
        </footer>

  
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
