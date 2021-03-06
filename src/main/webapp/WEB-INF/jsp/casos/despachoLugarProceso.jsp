<div class="row" >
	<div class="col-sm-4 b-r">
		<label><spring:message code="label.campo.paisHecho" /></label>
	</div>
	<div class="col-sm-4 b-r">
		<label><spring:message code="label.campo.departamentoHecho" /></label>
	</div>
	<div class="col-sm-4 ">
		<label><spring:message code="label.campo.municipioHecho" /></label>
	</div>
</div>
<div class="row">
	<div class="col-sm-4 b-r">
		<select class="form-control" id="txtPaisProceso" name="txtPaisProceso"
			onchange="cargarDepartamentosPorPais(this,'txtDeparmentoProceso','txtMunicipioProceso')">
		</select>
	</div>
	<div class="col-sm-4 b-r">
		<select class="form-control" id="txtDeparmentoProceso"
			name="txtDeparmentoProceso"
			onchange="cargarCiudadPorDepartamentos(this,'txtMunicipioProceso')">
		</select>
	</div>
	<div class="col-sm-4">
		<select class="form-control" id="txtMunicipioProceso"
			name="txtMunicipioHecho">
		</select>
	</div>
</div>
<div class="row">
	<div class="col-sm-4 b-r">
		<label><spring:message code="label.campo.numeroDespacho" /></label>
	</div>
	<div class="col-sm-8">
		<label><spring:message code="label.campo.nombreFuncionario" /></label>
	</div>
</div>
<div class="row">
	<div class="col-sm-4 b-r">
		<input type="text" class="form-control" id="txtnumeroDespacho"
			name="txtnumeroDespacho" maxlength="30">
	</div>
	<div class="col-sm-8">
		<input type="text" class="form-control" id="txtnombreFuncionario"
			name="txtnombreFuncionario" maxlength="60">
	</div>
</div>
	<div class="row">
		<div class="col-sm-12">
			<label><spring:message code="label.campo.direccionDeMiembro" /></label>
				<div class="input-group m-b"><span class="input-group-addon"><i class="fa fa-map-marker"></i></span>
					<input type="text" class="form-control" id="txtDireccionDespacho"
						name="txtDireccionDespacho" maxlength="60">
					</div>
			
		</div>
		<br>
	</div>