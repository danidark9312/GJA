<div id="modal-buscarTipoCaso" name="modal-buscarTipoCaso" class="modal fade" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 330px; height: 50px;">
			<div class="modal-body" style="background-color: white">
			<form id="detalleDelCaso" name="detalleDelCaso">
				<div class="row">
				<div class="col-sm-6 " style="text-align: center;">
				<h2 class="modal-title"><spring:message code="label.maestroTipoCaso.tituloTipoCaso"/></h2>
				</div>
				<div class="col-sm-6">
				</div>
			</div>
				<div class="row">
					<div class="col-sm-4 b-r">
						<label><spring:message code="label.maestroTipoCaso.nombre" /></label>
					</div>
					<div class="col-sm-8 b-r">
					<input id="buscarTipoCaso" name="buscarTipoCaso" type="text" onclick="buscarTipoCaso()" onchange="buscarTipoCaso()"/> 
					</div>
				</div>
				</form>	
				</div>
			</div>
			</div>
</div>


<div id="modal-actualizarTipoCaso" name="modal-actualizarTipoCaso" class="modal fade" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 700px;">
			<div class="modal-header">
			<div class="row">
				<div class="col-sm-6 ">
				<h2 class="modal-title"><spring:message code="label.maestroTipoCaso.titulo"/></h2>
				</div>
				<div class="col-sm-6">
				</div>
			</div>
			</div>
			<div class="modal-body" style="background-color: white">
			
			
					<div class="row">
						<div class="alert alert-success" id="messageExitosoModal">
		                             How quickly daft jumping zebras vex. <a class="alert-link" href="#">Alert Link</a>.
		                         </div>
						<div class="alert alert-danger" id="messageErrorModal">
		                             How quickly daft jumping zebras vex. <a class="alert-link" href="#">Alert Link</a>.
		                         </div>
					</div>
				<form id="frmTiposCasos" name="frmTiposCasos">
					<div class="col-sm-3 ">
						<label><spring:message code="label.maestroTipoCaso.nombre" /></label>
					</div>
					<div class="col-sm-6 ">
					<input id="nombreTipoCaso" name="nombreTipoCaso" class="form-control" type="text" maxlength="30" style="width:300px;"/> 
					<input id="codigoTipoCaso" name="codigoTipoCaso" type="hidden" /> 
					</div>
				</form>
				<div class="col-sm-12 ">&nbsp;</div>
				<div class="col-sm-3 ">
					
	                <label><spring:message code="label.maestroTipoCaso.actividad" /></label>
	                </div>
	                <div class="col-sm-6 ">
	                <div class="input-group">
	                <select data-placeholder="Seleccione una o varias actividades..." multiple class="form-control" name="actividadTipoCaso" id="actividadTipoCaso">
	                <c:forEach items="${actividades}" var="actividad">
	                	<option value="${actividad.cdactividad}">${actividad.dsactividad}</option>
	   				</c:forEach> 
	                </select>
	                </div>
	                
			
				</div>
				
				
				
				<div class="row" style="text-align: right;">
				<div class="col-sm-12 ">&nbsp;
				</div>
				<div class="col-sm-8">
					&nbsp;
				</div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-azul" data-dismiss="modal" style="width:100px;"><spring:message code="label.maestroTipoCaso.salir"/></button>
				</div>
				<div class="col-sm-2">
				<button type="button" class="btn btn-azul" onclick="guardar()" id="guardarTipoCaso" style="width:100px;"><spring:message code="label.maestroTipoCaso.guardar"/></button>
				</div>
				</div>
			
				
				
				
				
				</div>
			</div>
			</div>
</div>




<div id="modal-EliminarTipoCaso" name="modal-EliminarTipoCaso" class="modal fade" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 620px;">
			<div class="modal-header">
			<div class="row">
			<div class="col-sm-1 ">
					</div>
			<div class="col-sm-10">
				<h2 class="modal-title"><spring:message code="label.maestroTipoCaso.mensajeEliminarTipoCaso"/></h2>
				</div>
				<div class="col-sm-1 ">
					</div>
				</div>
				<div class="row" style="text-align: right;;padding-right: 12%;">
				<button type="button" class="btn btn-white" data-dismiss="modal"><spring:message code="label.maestroTipoCaso.cancelar"/></button>
				<button type="button" class="btn btn-white" data-dismiss="modal"  onclick="eliminarTipoCasoSeguro()"><spring:message code="label.maestroTipoCaso.eliminar"/></button>
					
				</div>
			</div>
			</div>
			</div>
			</div>




<div id="modal-EliminarTarea" name="modal-EliminarTarea" class="modal fade" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 620px;">
			<div class="modal-header">
			<div class="row">
			<div class="col-sm-1 ">
					</div>
			<div class="col-sm-10">
				<h2 class="modal-title"><spring:message code="label.maestroTipoCaso.mensajeEliminarTarea"/></h2>
				</div>
				<div class="col-sm-1 ">
					</div>
				</div>
				<div class="row" style="text-align: right;;padding-right: 12%;">
					<button type="button" class="btn btn-white" data-dismiss="modal"><spring:message code="label.maestroTipoCaso.cancelar"/></button>
						<button type="button" class="btn btn-white" data-dismiss="modal"  onclick="eliminarTareaSeguro()"><spring:message code="label.maestroTipoCaso.eliminar"/></button>
				</div>
			</div>
			</div>
			</div>
			</div>
			
			
<div id="modal-NoEliminarTarea" name="modal-NoEliminarTarea" class="modal fade" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 620px;">
			<div class="modal-header">
			<div class="row">
			<div class="col-sm-1 ">
					</div>
			<div class="col-sm-10">
				<h2 class="modal-title"><spring:message code="label.maestroTipoCaso.mensajeEliminarTareaNoEliminar"/></h2>
				</div>
				<div class="col-sm-1 ">
					</div>
				</div>
				<div class="row" style="text-align: right;;padding-right: 12%;">
		<button type="button" class="btn btn-white" data-dismiss="modal"><spring:message code="label.maestroTipoCaso.salir"/></button>
				</div>
			</div>
			</div>
			</div>
			</div>			

<div id="modal-NoEliminarTipoCaso" name="modal-NoEliminarTipoCaso" class="modal fade" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 620px;">
			<div class="modal-header">
			<div class="row">
			<div class="col-sm-1 ">
					</div>
			<div class="col-sm-10">
				<h2 class="modal-title"><spring:message code="label.maestroTipoCaso.mensajeEliminarTipoCasoNoEliminar"/></h2>
				</div>
				<div class="col-sm-1 ">
					</div>
				</div>
				<div class="row" style="text-align: right;;padding-right: 12%;">
				<button type="button" class="btn btn-white" data-dismiss="modal"><spring:message code="label.maestroTipoCaso.salir"/></button>
				</div>
			</div>
			</div>
			</div>
			</div>
			
	<div id="modal-NoModificarTarea" name="modal-NoModificarTarea" class="modal fade" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 620px;">
			<div class="modal-header">
			<div class="row">
			<div class="col-sm-1 ">
					</div>
			<div class="col-sm-10">
				<h2 class="modal-title"><spring:message code="label.maestroTipoCaso.mensajeEliminarTareaNoModificar"/></h2>
				</div>
				<div class="col-sm-1 ">
					</div>
				</div>
				<div class="row" style="text-align: right;;padding-right: 12%;">
				<button type="button" class="btn btn-white" data-dismiss="modal"><spring:message code="label.maestroTipoCaso.salir"/></button>
					
				</div>
			</div>
			</div>
			</div>
			</div>			

<div id="modal-NoModificarTipoCaso" name="modal-NoModificarTipoCaso" class="modal fade" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 620px;">
			<div class="modal-header">
			<div class="row">
			<div class="col-sm-1 ">
					</div>
			<div class="col-sm-10">
				<h2 class="modal-title"><spring:message code="label.maestroTipoCaso.mensajeEliminarTipoCasoNoModificar"/></h2>
				</div>
				<div class="col-sm-1 ">
					</div>
				</div>
				<div class="row" style="text-align: right;;padding-right: 12%;">
					<button type="button" class="btn btn-white" data-dismiss="modal"><spring:message code="label.maestroTipoCaso.salir"/></button>
				</div>
			</div>
			</div>
			</div>
			</div>


