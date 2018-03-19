<div id="modal-nuevoCaso" name="modal-nuevoCaso" class="modal fade"
	aria-hidden="true">
	<div class="modal-dialog" id="modal">
		<div class="modal-content"
			style="width: 850px; height: 850px; overflow: scroll;">

			<div class="modal-header">
				<div class="row">
					<div class="col-sm-8 b-r">
						<h2 class="modal-title">
							<spring:message code="label.campo.nuevoCaso" />
						</h2>
					</div>
					<div class="col-sm-4">
						<label><spring:message code="label.campo.estadoCaso" /></label> <Select
							class="form-control" id="txtEstadoCaso" name="txtEstadoCaso"
							tabindex="2"></Select>
					</div>
				</div>
			</div>
			<div class="modal-body" style="background-color: white"
				id="modalPrueba">

				<div class="row">
					<div class="alert alert-danger" id="messageError">
						
					</div>
				</div>
				<div class="row">
					<div class="alert alert-danger" id="messageErrorNuevoCaso">
						
					</div>
				</div>

				<!-- Inicio bloque Nuevo Caso-->
				<input hidden="hidden" id="aniosCaducidadParam"
					name="aniosCaducidadParam" value="${aniosCaducidad}" />
				<form id="detalleDelCaso" name="detalleDelCaso">
					<div class="row">
						<div class="col-sm-4 b-r">

						</div>
						<div class="col-sm-8">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4 b-r">
							<label><spring:message code="label.campo.tipoCaso" /></label>
							<Select class="form-control" id="txtTipoCaso" name="txtTipoCaso"
								tabindex="2" onchange="cargarActividadesTipoCaso(this)"></Select>
						</div>
						<div class="col-sm-8">
							<label><spring:message code="label.campo.nombreCaso" /></label>
							<input type="text" class="form-control" id="txtNombreCaso"
								name="txtNombreCaso" maxlength="50">
						</div>

					</div>
					<div class=row>
						<div class="col-sm-4 b-r">
						</div>
						<div class="col-sm-4 b-r">
						</div>
						<div class="col-sm-4">
						</div>

					</div>
					<div class=row>
						<div class="col-sm-4 b-r">
							<label><spring:message code="label.campo.fechaDeLosHechos" /></label>
							<input type="date" class="form-control" id="txtFechaDeLosHechos"
								name="txtFechaDeLosHechos" onchange="mostrarFechaCaducidad()">
						</div>
						<div class="col-sm-4 b-r">
							<label><spring:message code="label.campo.fechaDeCaducidad" /></label>
							<input type="date" class="form-control" id="txtFechaDeCaducidad"
								name="txtFechaDeLosHechos" disabled="true">
						</div>
						<div class="col-sm-4">
							<label><spring:message code="label.campo.paisDeLosHechos" /></label>
							<select class="form-control cmbsCiudadProcesos" id="txtPaisDeLosHechos"
								name="txtPaisDeLosHechos" tabindex="2"
								onchange="cargarDepartamentosPorPais(this,'txtDepartamentoDeLosHechos','txtMunicipioDeLosHechos')"></select>
						</div>

					</div>

					<div class=row>
						<div class="col-sm-4 b-r">
						</div>
						<div class="col-sm-4 b-r">
						</div>
						<div class="col-sm-4">
						</div>

					</div>
					<div class=row>
						<div class="col-sm-4 b-r">
							<label><spring:message code="label.campo.departamentoDeLosHechos" /></label>
							<select class="form-control cmbsCiudadProcesos" id="txtDepartamentoDeLosHechos"
								name=" txtDepartamentoDeLosHechos"
								onchange="cargarCiudadPorDepartamentos(this,'txtMunicipioDeLosHechos')"
								tabindex="2"></select>

						</div>
						<div class="col-sm-4 b-r">
							<label><spring:message code="label.campo.municipioDeLosHechos" /></label>
							<select class="form-control" id="txtMunicipioDeLosHechos"
								name="txtMunicipioDeLosHechos" tabindex="2"></select>

						</div>
						<div class="col-sm-4">
							<label><spring:message code="label.campo.direccionDeLosHechos" /></label>
							<div class="input-group m-b">
								<span class="input-group-addon"><i
									class="fa fa-map-marker"></i></span> <input type="text"
									class="form-control" id="txtDireccionDeLosHechos"
									name="txtDireccionDeLosHechos" maxlength="60">
							</div>

						</div>
						<div class=row>
							<div class="col-sm-12">
							</div>
						</div>
						<div class=row>
							<div class="col-sm-12">
								<label><spring:message code="label.campo.resumenDeLosHechos" /></label>
								<textarea  id="txtResumenDeLosHechos"
									name="txtResumenDeLosHechos" rows="3" maxlength="255" class="form-control" ></textarea>

							</div>
						</div>
						<br>
						<hr class="hr-line-solid">
						<br>
						<!-- Fin bloque Nuevo Caso-->
						<!-- Inicio del bloque abogados -->
						<div class="row">
							<div class="col-sm-12 b-r">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseAbogados"><spring:message code="label.titulo.abogados" /></a>
										</h4>
									</div>
									<div id="collapseAbogados" class="panel-collapse collapse">
										<div class="panel-body">
											<div class="row">
												<div class="alert alert-danger" id="messageErrorAbogado">
													
												</div>
											</div>
											<%@ include file="/WEB-INF/jsp/casos/abogado.jsp"%>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--  Fin del bloque abogados -->
						<!--  incio del bloque demandados -->
						<div class="row">
							<div class="col-sm-12 b-r">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseDemandados"><spring:message code="label.titulo.demandados" /></a>
										</h4>
									</div>
									<div id="collapseDemandados" class="panel-collapse collapse">
										<div class="panel-body" id="panelDemandado">
											<div class="row">
												<div class="alert alert-danger" id="messageErrorDemandados">
													
												</div>
											</div>
											<%@ include file="/WEB-INF/jsp/casos/demandado.jsp"%>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!--  Fin del bloque demandos -->
						<!-- inicio bloque equipo del caso-->
						<div class="row">
							<div class="col-sm-12 b-r">
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h5 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapseSolicitud"><spring:message code="label.titulo.victimas" /></a>
											</h5>
										</div>
										<div id="collapseSolicitud" class="panel-collapse collapse">
											<div class="panel-body" id="panelEquipoCaso">
												<div class="row">
													<div class="alert alert-danger" id="messageErrorEquipoCaso">
														
													</div>
												</div>
												<%@ include file="/WEB-INF/jsp/casos/equipoDelCaso.jsp"%>

											</div>
										</div>
									</div>
								</div>


							</div>

						</div>
						<!-- Fin bloque equipo del caso-->
						<!-- Inicio del bloque actividades-->
						<div class="row">
							<div class="col-sm-12 b-r">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#Actividad"><spring:message code="label.titulo.actividades" /></a>
										</h4>
									</div>
									<div id="Actividad" class="panel-collapse collapse">
										<div class="panel-body" id="actividades">
											<div class="row">
												<div class="alert alert-danger" id="messageErrorActividades">
													
												</div>
											</div>
											<%@ include
												file="/WEB-INF/jsp/casos/actividadParticularCaso.jsp"%>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Fin del bloque actividades-->

						<!--  Inicio del bloque Despacho y lugar del proceso -->
						<div class="row">
							<div class="col-sm-12 b-r">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseDespachoLugarProceso"><spring:message code="label.titulo.lugarDespacho" /></a>
										</h4>
									</div>
									<div id="collapseDespachoLugarProceso"
										class="panel-collapse collapse">
										<div class="panel-body">
											<div class="row">
												<div class="alert alert-danger" id="messageErrorLugarProceso">
													
												</div>
											</div>
											<%@ include
												file="/WEB-INF/jsp/casos/despachoLugarProceso.jsp"%>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--  Fin del bloque Despacho y lugar del proceso -->
						<!--  Inicio del bloque Bienes Afectados -->
						<div class="row">
							<div class="col-sm-12 b-r">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseBienesAfectados"><spring:message code="label.titulo.bienesAfectados"/></a>
										</h4>
									</div>
									<div id="collapseBienesAfectados"
										class="panel-collapse collapse">
										<div class="panel-body" id="panelBienesAfectados">
											<div class="row">
												<div class="alert alert-danger" id="messageErrorBienesAfectados">
													
												</div>
											</div>
											<%@ include file="/WEB-INF/jsp/casos/bienesAfectados.jsp"%>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--  Fin del bloque Bienes Afectados -->
						<!--  Incio del bloque Radicados -->
						<div class="row">
							<div class="col-sm-12 b-r">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseRadicado"><spring:message code="label.titulo.radicados"/></a>
										</h4>
									</div>
									<div id="collapseRadicado" class="panel-collapse collapse">
										<div class="panel-body" id="panelRadicado">
											<div class="row">
												<div class="alert alert-danger" id="messageErrorRadicados">
													
												</div>
											</div>
											<%@ include file="/WEB-INF/jsp/casos/radicado.jsp"%>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--  Fin del bloque Radicados -->
						<!--  Inicio del bloque Prestamos -->
						<div class="row">
							<div class="col-sm-12 b-r">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapsePrestamo"><spring:message code="label.titulo.prestamos"/></a>
										</h4>
									</div>
									<div id="collapsePrestamo" class="panel-collapse collapse">
										<div class="panel-body" id="panelPrestamos">
											<div class="row">
												<div class="alert alert-danger" id="messageErrorPrestamos">
													
												</div>
											</div>
											<%@ include file="/WEB-INF/jsp/casos/prestamo.jsp"%>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--  Fin del bloque Prestamos -->
						<!-- inicio bloque comentario -->
						<div class="row">
							<div class="col-sm-12 b-r">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapseComentario"><spring:message code="label.titulo.comentario"/></a>
										</h4>
									</div>
									<div id="collapseComentario" class="panel-collapse collapse">
										<div class="panel-body">
											<div class="row">
												<div class="alert alert-danger" id="messageErrorComentarios">
													
												</div>
											</div>
											<div class=row>
												<div class="col-sm-12 b-r">
													<label><spring:message
															code="label.campo.comentarios" /></label>
													<textarea class="col-sm-12 b-r" id="txtComentario"
														name="txtComentario" rows="3" maxlength="255"></textarea>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- fin bloque comentario -->
						<div class="modal-footer">
							<button type="button" class="btn btn-azul" data-dismiss="modal"
								onclick="modalClose()" style="width: 15%">Cerrar</button>
							<button type="button" class="btn btn-azul" onclick="guardar()"
								style="width: 15%">Guardar</button>
						</div>
				</form>
			</div>
		</div>

	</div>
</div>


<div id="modal-EliminarActividad" name="modal-confirmacion"
	class="modal fade" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 620px;">
			<div class="modal-header">
				<div class="row">
					<div class="col-sm-1 "></div>
					<div class="col-sm-10">
						<h2 class="modal-title">
							<spring:message code="label.title.confirmacion.Actividad" />
						</h2>
					</div>
					<div class="col-sm-1 "></div>
				</div>
				<div class="row" style="text-align: right;; padding-right: 12%;">
					<button type="button" class="btn btn-white" data-dismiss="modal">
						<spring:message code="label.maestroActividad.cancelar" />
					</button>
					<button type="button" class="btn btn-white" data-dismiss="modal"
						onclick="borrarActividad(filaABorrar,botonPresionado)">
						<spring:message code="label.maestroActividad.eliminar" />
					</button>

				</div>
			</div>
		</div>
	</div>
</div>

<div id="modal-EliminarTarea" name="modal-confirmacion"
	class="modal fade" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width: 620px;">
			<div class="modal-header">
				<div class="row">
					<div class="col-sm-1 "></div>
					<div class="col-sm-10">
						<h2 class="modal-title">
							<spring:message code="label.title.confirmacion.Tarea" />
						</h2>
					</div>
					<div class="col-sm-1 "></div>
				</div>
				<div class="row" style="text-align: right; padding-right: 12%;">
					<button type="button" class="btn btn-white" data-dismiss="modal">
						<spring:message code="label.button.confirmacionTarea.cancelar" />
					</button>
					<button type="button" class="btn btn-white" data-dismiss="modal"
						onclick="deleteTarea(filaABorrar, filaABorrarTarea, botonPresionado)">
						<spring:message code="label.maestroActividad.eliminar" />
					</button>

				</div>
			</div>
		</div>
	</div>
</div>