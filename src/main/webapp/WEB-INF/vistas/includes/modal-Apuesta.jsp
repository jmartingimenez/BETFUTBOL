<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   		
   		<div class="container">
  <div class="row">

    <div id="myModal" class="modal fade in">
      <div class="modal-dialog">
        <div class="modal-content">

          <div class="modal-header">
            <h3 class="modal-title">Apuesta en curso</h3>
          </div>
          <div class="modal-body">
            <h5 id="descripcion">Indique la cantidad de dinero que desea apostar.</h5>
          </div>
          <div class="modal-footer">
            <div class="form-group text-center">
	            <form:form action="procesar-apuesta" method="POST" modelAttribute="apuesta">	
					<form:hidden path="cuotaNombre" class="text-info"/>
					<form:hidden path="cuotaValor" class="text-info"/>
					<form:hidden path="evento.id" class="text-info"/>
					
					<div class="col-md-5">
   					<div class="input-group">
       				<span class="input-group-addon">AR$</span>
    				<form:input class="form-control" type="number" min="1" max="100000" path="cantidadApostada"/>
 					</div>
					</div>
					
					<button class="btn btn-success" name="submit" value="Confirmar" type="Submit" data-toggle="page-alert" data-delay="5000" data-toggle-id="10">Apostar</button>
					<button class="btn btn-primary"  data-dismiss="modal" value="Cancelar">Cancelar</button> 
				</form:form>              
            </div>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dalog -->
    </div><!-- /.modal -->
  </div>
</div>   
   
   	
   	
