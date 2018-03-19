<div id="actividadParticular" name="actividadParticular">
	<div class="row">
		<div class="col-sm-10 ">
			<label><spring:message
					code="label.Actividad.particular.nombre" /></label>
		<div class="alert alert-danger" id="messageErrorAactividad" name="messageError" style="display: none">How quickly daft jumping zebras vex.</div>
		</div>
	
		<div class="col-sm-2 b-r">
		
		</div>
		
	</div>
	<div class="row">
		<div class="col-sm-10 ">
			<input id="nombreActividad" name="nombreActividad"
				class="form-control type=" text" onclick="" onchange=""  maxlength="30" />
		</div>
		
		<div class="col-sm-2">
			<a href="javascript:void(0);"
				onclick="actividadesParticularesCaso()" title="Adicionar"
				class="btn btn-success btn-circle .btn-xs" style="background-color: #449D50; border:0;"> <i
				class="glyphicon glyphicon-plus"></i>
			</a>
		</div>
		

	</div>
	<br>
	<hr class="hr-line-solid">
	<br>
	<div class="row" id="divEspacio">
		
	
	</div>
	<div class="row" id="divEspacio1">
		
	
	</div>

<!-- 	<div class="row" id="divEspacio"></div> -->

			<div class="modal-body" style="background-color: white">
				<form id="nuevasActividades" name="nuevasActividades">
		
		<div class="row" id="campoTarea" name="campoTarea"
			style="display: none">
			<div class="row">
				<div class="col-sm-7">
					<label><spring:message code="label.maestroActividad.tarea" /></label>
				</div>
				<div class="col-sm-5">
					<label><spring:message
							code="label.Actividad.particular.fechaDeVencimientoTarea" /></label>
							<div class="alert alert-danger" id="messageError" name="messageError">
                             How quickly daft jumping zebras vex. <a class="alert-link" href="#">Alert Link</a>.
                     	</div>

				</div>
			</div>
<!-- 			<div class="row"> -->
<!-- 				<div class="alert alert-danger" id="messageError" name="messageError"> -->
<!--                              How quickly daft jumping zebras vex. <a class="alert-link" href="#">Alert Link</a>. -->
<!--                      	</div> -->
<!-- 			</div> -->
			<div class="row">

				<div class="col-sm-7">
					<input id="nombreTarea" name="nombreTarea" type="text"
						class="form-control" maxlength="30"/>
				</div>
				<div class="col-sm-4">
				
					<input type="date" class="form-control"
						id="txtFechaDeVencimientoTarea"
						name="txtFechaDeVencimientoTarea" onchange="validarfechasTareas(this)">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8">
					<label><spring:message
							code="label.Actividad.particular.responsable" /></label> <Select
						class="form-control" id="cmbResponsableTarea"
						name="cmbResponsableTarea" tabindex="2"></Select>
				</div>
			</div>
			<div class="row">

				<div class="col-sm-12">
					<label><spring:message
							code="label.maestroActividad.detalleTarea" /></label>
				</div>
			</div>
			<div class="row">

				<div class="col-sm-10">
					<input id="detalleTarea" name="detalleTarea" type="text"
						class="form-control" maxlength="255"/>
				</div>
				<div class="col-sm-2">

					<a href="javascript:void(0);"
						onclick="clonarCampoTareaParticular(this)" class="btn btn-success btn-circle .btn-xs"
						style="background-color: #449D44; border:0;" name="btTareas" title="Adicionar Tarea"> <i
						class="glyphicon glyphicon-plus" id="btnTareas" name="btnTareas"></i>
					</a>
				</div>
			</div>
		</div>
			<div class="row" id="divEspacio"></div>
		
				</form>
			</div>
<br>

</div>



<!-- <div class="row"> -->
<!-- 					<div class="col-sm-6 "> -->
<!-- 						<label><spring:message code="label.maestroActividad.nombre" /></label> -->
<!-- 					</div> -->
<!-- 					<div class="col-sm-6 "> -->
<!-- 					<input id="nombreActividad" name="nombreActividad" type="text" onclick="buscarActividad()" onchange="buscarActividad()"/>  -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="row"> -->

<!-- 				<div class="col-sm-6"> -->
<!-- 						<label><spring:message code="label.maestroActividad.adicionarTarea" /></label> -->
<!-- 							<a href="javascript:void(0);" -->
<!-- 																			onclick="mostrarCampoTarea()" -->
<!-- 																			class="btn btn-success" -->
<!-- 																			style="background-color: #449D44;"> <i -->
<!-- 																			class="glyphicon glyphicon-plus"></i> -->
<!-- 																		</a> -->
<!-- 					</div> -->
<!-- 					<div class="col-sm-6"> -->

<!-- 					</div> -->

<!-- 				<div class="row" id="divEspacio"></div> -->
<!-- 				<div class="modal-body" style="background-color: white"> -->
<!-- 				<form id="nuevasActividades" name="nuevasActividades"> -->
<!-- 					<div class="row" id="campoTarea" style="display: none"> -->
<!-- 					<div class="col-sm-6"> -->
<!-- 						<label><spring:message code="label.maestroActividad.tarea" /></label> -->
<!-- 						<input id="nombreTarea" name="nombreTarea" type="text" /> -->
<!-- 					</div> -->
<!-- 					<div class="col-sm-6"> -->
<!-- 					<label><spring:message code="label.maestroActividad.detalleTarea" /></label> -->
<!-- 						<input id="detalleTarea" name="detalleTarea" type="text" /> -->
<!-- 						<a href="javascript:void(0);" -->
<!-- 																			onclick="clonarCampoTarea(this)" -->
<!-- 																			class="btn btn-success" -->
<!-- 																			style="background-color: #449D44;"> <i -->
<!-- 																			class="glyphicon glyphicon-plus"></i> -->
<!-- 																		</a> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				</form> -->
<!-- 				</div> -->
<!-- 				</div> -->
<!-- 				<div class="row" style="text-align: right;"> -->
<!-- 				<a href="#" onclick="doAjaxPostAdd()"><i class="fa fa-floppy-o"></i><span class="text-muted"></span></a> -->
<!-- 				</div> -->





