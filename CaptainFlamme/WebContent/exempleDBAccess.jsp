<div class="row text-center">
        
        <!-- Affichage depuis la DB -->
					<%
				ResultSet resultset = ProductDAO.getfromcat("AC"); <!-- Requête SQL dans ProductDAO -->
			if(resultset!=null)
				while(resultset.next()){ <!-- Boucle - Pour chaque résultat de la requête -->
			%>
            <div class="col-md-4 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <img src="<%= resultset.getString(6) %>" alt=""> <!-- Champs numéro 6 du résultat courant -->
                    <div class="caption">
                        <h3><%= resultset.getString(2) %></h3>
                        <p><%= resultset.getString(4) %></p>
                        <p>
                            <a href="Canard.jsp?ref=<%=resultset.getString(1)%>" class="btn btn-primary">Buy Now!</a>
                        </p>
                    </div>
                </div>
            </div>
			<%
				}  
			%>
			<!-- Fin boucle -->

</div>