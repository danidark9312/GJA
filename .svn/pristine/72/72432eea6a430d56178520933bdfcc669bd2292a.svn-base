
<!-- <div class="row" style="text-align: right; padding-right: 6%;"> -->
<div class="alert alert-danger" id="messageErrorDemandante" name="messageError" style="display: none">How quickly daft jumping zebras vex. <a class="alert-link" href="#">Alert Link</a>.</div>
<div class="row"padding-right: 6%;">

	<div class="col-sm-11"></div>
	<div class="col-sm-1" style="padding-left: 1%;">
		<a href="javascript:void(0);" onclick="agregarFormularioDemandados()"
			class="btn btn-primary btn-circle .btn-xs"
			style="background-color: #449D44; border: 0;"
			title="Adicionar Demandado"><i class="glyphicon glyphicon-plus"></i></a>
	</div>

</div>
<hr class="hr-line-solid">	
<div name="formularioEquipoCaso">
	<div class="row">
		<div class="col-sm-6 b-r">
			<label><spring:message code="label.campo.tipoDePersona" /></label> <select
				class="form-control" id="txtTipoPersona" name="txtTipoPersona"
				tabindex="2" onchange="">
				<option value="">Seleccionar</option>
				<option value="Persona Natural">Persona Natural</option>
				<option value="Persona Juridica">Persona Juridica</option>
			</select>
		</div>
		<div class="col-sm-6">
				<label><spring:message code="label.campo.nombresMiembro" /></label>
				<input type="text" class="form-control" id="txtNombresMiembro"
					name="txtNombresMiembro" maxlength="60">
		</div>

	</div>

	<div class="row">
		<div class="col-sm-6 b-r">
			<label><spring:message code="label.campo.paisDemandado" /></label> <select
				class="form-control" id="txtPaisMiembro" name="txtPaisMiembro"
				tabindex="2"
				onchange="cargarDepartamentosPorPais1(this)">
			</select>
		</div>
		<div class="col-sm-6 b-r">
			<label><spring:message
					code="label.campo.departamentoDemandado" /></label> <select
				class="form-control" id="TxtDepartamentoMiembro"
				name="TxtDepartamentoMiembro" tabindex="2"
				onchange="cargarCiudadPorDepartamentos1(this)">
			</select>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<label><spring:message code="label.campo.municipioDemandado" /></label>
			<select class="form-control" id="txtMunicipioMiembro"
				name="txtMunicipioMiembro" tabindex="2">
			</select>
		</div>
		<div class="col-sm-6">
			<label><spring:message code="label.campo.direccionDeMiembro" /></label>
			
			<div class="input-group m-b"><span class="input-group-addon"><i class="fa fa-map-marker"></i></span>
					<input type="text" class="form-control" id="txtDireccionMiembro"
						name="txtDireccionMiembro" maxlength="60">
					</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6 b-r" >
		</div>
	<div class="col-sm-6" style="padding-left: 3%">
		</div>
	</div>


<div class="row">
	<div class="col-sm-6 b-r">
		<div name="formularioTelefono">

			<div class="col-sm-10" style="padding-left: 1%">
			<label><spring:message code="label.campo.telefonoMiembro" /></label>
					<div class="input-group m-b"><span class="input-group-addon"><i class="fa fa-phone-square"></i></span>
					<input type="text" class="form-control" id="txtTelefonoMiembro"
					name="txtTelefonoMiembroDemandado" maxlength="15" data-mask="(999) 999-9999" placeholder="(___) ___-____">
					</div>
					
			</div>
			<div class="col-sm-2">
			
				<a href="javascript:void(0);" onclick="agregartelefono(this)" title="Adicionar Teléfono"
					class="btn btn-success btn-circle .btn-xs" style="background-color: #449D44; border: 0;"> <i
					class="glyphicon glyphicon-plus"></i>
				</a>
			</div>

		</div>
	</div>

	<div class="col-sm-6 b-r">
		<div name="formularioCelular">
		<div class="col-sm-10 ">
			<label><spring:message code="label.campo.celularMiembro" /></label>
		
			<div class="input-group m-b"><span class="input-group-addon"><i class="fa fa-mobile"></i></span>
					<input type="text" class="form-control" id="txtCelularMiembro"
					name="txtCelularMiembro" maxlength="20" data-mask="(999) 999-9999" placeholder="(___) ___-____">
					</div>
		
			
		</div>
		<div class="col-sm-2">
			<a href="javascript:void(0);" onclick="agregarCelular(this)" class="btn btn-success btn-circle .btn-xs" title="Adicionar Teléfono"
				style="background-color: #449D44; border: 0;"><i
				class="glyphicon glyphicon-plus"></i></a>
		</div>
		</div>
	</div>
	
	</div>
	
	<div class="row">
		<div class="col-sm-12">
		</div>
	</div>
	<div class="row">
		<div name="formularioCorreo">
		<div class="col-sm-11">
			<label><spring:message code="label.campo.correoMiembro" /></label>
		
			<div class="input-group m-b" style="width: 99%"><span class="input-group-addon"><i class="fa fa-at"></i></span>
					<input type="text" class="form-control" id="txtCorreoMiembro"
							name="txtCorreoMiembroDemandado" maxlength="60" >
					</div>
				
			</div>
		<div class="col-sm-1" style="padding-left: 1%;">
			<a href="javascript:void(0);" onclick="agregarCorreo(this)" class="btn btn-success btn-circle .btn-xs" title="Adicionar Correo"
				style="background-color: #449D44; border: 0;"><i
				class="glyphicon glyphicon-plus"></i></a>
		</div>
		</div>
	</div>


	<div class="row">
		<div class="col-sm-12">
			<label><spring:message
					code="label.campo.observacionesMiembro" /></label>
			<textarea  id="txtObservacionesMiembro"
				name="txtObservacionesMiembro" class="form-control" rows="3" maxlength="255"></textarea>
		</div>
	</div>
    <br>
	<div class="row" padding-right: 6%;">

		<div class="col-sm-11"></div>
		<div class="col-sm-1" style="padding-left: 1%;">
			<a href="javascript:void(0);" onclick="eliminarDemandadoYVictimas(this)"
				class="btn btn-primary btn-circle .btn-xs"
				style="background-color:red; border: 0;"
				title="Adicionar Demandado"><i class="glyphicon glyphicon-minus"></i></a>
		</div>

	</div>



	<hr class="hr-line-solid">	
</div>
