<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>



<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>FomularioRadicado</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">

</head>
<body>
	<div id="page-wrapper" class="gray-bg">
		<%@ include file="/WEB-INF/jsp/general/menu.jsp"%>
		<%@ include file="/WEB-INF/jsp/general/userTool.jsp"%>
		<div class="wrapper wrapper-content">
			<div class="container">
				<!--  -->
				<div class="contenido">
					<div class="container">

						<div class="row">

							<div class="col-md-12 col-lg-12">
								<div class="ibox float-e-margins">

									<div class="ibox-title">
										<h5>Casos</h5>
									</div>

									<div class="ibox-content">

										<div class="panel blank-panel">

											<div class="panel-heading">
												<div class="panel-options">
													<ul class="nav nav-tabs">
														<li class="active"><a data-toggle="tab" href="#tab-1">Visor
																de casos</a></li>
												
													</ul>
												</div>
											</div>

											<div class="panel-body">

												<form role="form" class="panel-body">
													<input type="hidden" name="${_csrf.parameterName}"
														id="${_csrf.parameterName}" value="${_csrf.token}" /> <input
														type='hidden' name='idusercreacion' id='idusercreacion'
														value='<sec:authentication property="principal.id"/>' />

													<div class="tab-content">

														<div id="tab-1" class="tab-pane active">

															<div class="row">
																<div class="form-group col-sm-5 col-md-3">
																	<label>Tipos de Caso</label> 
																	<select
																		class="form-control m-b" id="cmbTipoDeCaso"
																		name="txtTipoCaso"></select>
																</div>
																<div class="form-group col-sm-5 col-md-3">
																	<label>Estado actual</label> <select
																		class="form-control m-b" id="cmbEstadoCaso"
																		name="txtEstadoCaso">

																	</select>
																</div>
																<div class="form-group col-sm-3 col-md-3 btns-forms" >
																	<label> </label>
																	<button class="btn btn-azul" type="button"
																		onclick="mostrarTabla()" style="width: 45%">Filtrar</button>
																	<button class="btn btn-azul" type="button"
																		onclick="limpiarFiltros()" style="width: 45%">Limpiar</button>
																</div>
															</div>

															<hr class="border-bottom">
															<div class="row">
																<div class="alert alert-success" id="messageExitoso">
																	How quickly daft jumping zebras vex. <a
																		class="alert-link" href="#">Alert Link</a>.
																</div>
															
															</div>
															<div class="row">
																<div class="col-sm-6 col-md-6">
																	<h3 class="titulo-azul">Visor de casos</h3>
																</div>

																<div class=" col-sm-6 col-md-6 text-right">
																	<!--                                                         <button data-toggle="modal" class="btn btn-azul" type="button" onclick="irNuevoCaso()" >Adicionar caso</button> -->
																	<a data-toggle="modal" class="btn btn-azul"
																		href="#modal-nuevoCaso" style="float: right"
																		onclick="cargarFormularios()"><spring:message
																			code="button.label.nuevoCaso" /></a>

<!-- 																	<button class="btn btn-azul" type="submit">Cargar -->
<!-- 																		offline</button> -->
																</div>
																<!-- modal Sesion-->
<!-- 																<div class=" col-sm-6 col-md-6 text-right"> -->

<!-- 																	<a data-toggle="modal" class="btn btn-azul" -->
<!-- 																		href="#modal-form" style="float: right">mensaje -->
<!-- 																		finalizacion sesion</a> -->
<!-- 																	<div id="modal-form" class="modal fade" -->
<!-- 																		aria-hidden="true"> -->
<!-- 																		<div class="modal-dialog"> -->
<!-- 																			<div class="modal-content"> -->
<!-- 																				<div class="modal-body"> -->
<!-- 																					<div class="row"> -->
																						
<%-- 																							<spring:message code="label.title.finalizacion.Sesion" /> --%>
																						
<!-- 																					</div> -->
<!-- 																				</div> -->
<!-- 																				<div class="modal-footer"> -->
<!-- 																					<button type="button" class="btn btn-azul" -->
<!-- 																						data-dismiss="modal" onclick="modalClose()" -->
<!-- 																						style="width: 15%">Cancelar</button> -->
<!-- 																					<button type="button" class="btn btn-azul" -->
<!-- 																						onclick="" style="width: 15%">Aceptar</button> -->
<!-- 																				</div> -->
<!-- 																			</div> -->
<!-- 																		</div> -->


<!-- 																	</div> -->
<!-- 																</div> -->
																	<!-- modal Sesion-->
																</div>
																<!-- TABLA -->
															<div id="tablaListado"></div>


<!-- 															<hr class="border-bottom"> -->

															<div class="row">
																<!--                                                      <div class="form-group col-sm-6 col-md-6 form-inline"> -->
																<!--                                                         <label>Listar:</label>  -->
																<!--                                                         <select class="form-control"> -->
																<!--                                                             <option>1</option> -->
																<!--                                                             <option>2</option> -->
																<!--                                                             <option>3</option> -->
																<!--                                                             <option>4</option> -->
																<!--                                                             <option>5</option> -->
																<!--                                                         </select> -->
																<!--                                                         <label>Entradas</label>  -->
																<!--                                                     </div> -->
																<div class=" col-sm-6 col-md-6 text-right form-inline">
<!-- 																	<div class="form-group"> -->
<!-- 																		<input type="search" class="form-control" id="" -->
<!-- 																			placeholder="Buscar"> -->
<!-- 																	</div> -->
<!-- 																	<button type="submit" class="btn btn-azul">Buscar</button> -->
																</div>
															</div>

<!-- 															<hr class="border-bottom"> -->


															<!--                                                 <div class="table-responsive"> -->
															<!--                                                     <table class="table table-striped"> -->
															<!--                                                         <thead> -->
															<!--                                                         <tr> -->
															<!--                                                             <th>Caso <i class="fa fa-angle-up"></i></th> -->
															<!--                                                             <th>Radicado <i class="fa fa-angle-up"></i></th> -->
															<!--                                                             <th>Responsable del caso <i class="fa fa-angle-up"></i></th> -->
															<!--                                                             <th>Próxima tarea <i class="fa fa-angle-down"></i></th> -->
															<!--                                                         </tr> -->
															<!--                                                         </thead> -->
															<!--                                                         <tbody> -->
															<!--                                                         <tr> -->
															<!--                                                             <td>Nombre caso</td> -->
															<!--                                                             <td>Número del radicado</td> -->
															<!--                                                             <td>Nombre del responsable</td> -->
															<!--                                                             <td>Próxima tarea</td> -->
															<!--                                                         </tr> -->
															<!--                                                         <tr> -->
															<!--                                                             <td>Nombre caso</td> -->
															<!--                                                             <td>Número del radicado</td> -->
															<!--                                                             <td>Nombre del responsable</td> -->
															<!--                                                             <td>Próxima tarea</td> -->
															<!--                                                         </tr> -->
															<!--                                                         <tr> -->
															<!--                                                             <td>Nombre caso</td> -->
															<!--                                                             <td>Número del radicado</td> -->
															<!--                                                             <td>Nombre del responsable</td> -->
															<!--                                                             <td>Próxima tarea</td> -->
															<!--                                                         </tr> -->
															<!--                                                         <tr> -->
															<!--                                                             <td>Nombre caso</td> -->
															<!--                                                             <td>Número del radicado</td> -->
															<!--                                                             <td>Nombre del responsable</td> -->
															<!--                                                             <td>Próxima tarea</td> -->
															<!--                                                         </tr> -->
															<!--                                                         <tr> -->
															<!--                                                             <td>Nombre caso</td> -->
															<!--                                                             <td>Número del radicado</td> -->
															<!--                                                             <td>Nombre del responsable</td> -->
															<!--                                                             <td>Próxima tarea</td> -->
															<!--                                                         </tr> -->
															<!--                                                         <tr> -->
															<!--                                                             <td>Nombre caso</td> -->
															<!--                                                             <td>Número del radicado</td> -->
															<!--                                                             <td>Nombre del responsable</td> -->
															<!--                                                             <td>Próxima tarea</td> -->
															<!--                                                         </tr> -->

															<!--                                                         </tbody> -->
															<!--                                                     </table> -->
															<!--                                                 </div> -->

															<!-- FIN TABLA -->

															<!--                                                 <div class="row"> -->
															<!--                                                     <div class="col-sm-12 m-b-xs"> -->
															<!--                                                         <div class="btn-group"> -->
															<!--                                                             <button type="button" class="btn btn-white"><i class="fa fa-chevron-left"></i></button> -->
															<!--                                                             <button class="btn btn-white">1</button> -->
															<!--                                                             <button class="btn btn-white  active">2</button> -->
															<!--                                                             <button class="btn btn-white">3</button> -->
															<!--                                                             <button class="btn btn-white">4</button> -->
															<!--                                                             <button type="button" class="btn btn-white"><i class="fa fa-chevron-right"></i> </button> -->
															<!--                                                         </div> -->
															<!--                                                     </div> -->
															<!--                                                 </div> -->


														</div>

														<!-- FIN TAB -->

														<div id="tab-2" class="tab-pane"></div>

														<!-- FIN TAB -->

													</div>

												</form>

											</div>

										</div>

										<!-- FIN TABS -->

									</div>
								</div>
							</div>

						</div>

					</div>

				</div>

				<!--  -->


			</div>
		</div>
		<%@ include file="/WEB-INF/jsp/general/pieDePagina.jsp"%>

	</div>
	<!-- Ventanas modales -->
	<%@ include file="/WEB-INF/jsp/casos/nuevoCaso.jsp"%>
	 <%@ include file="/WEB-INF/jsp/seguridad/modalMensajeFinalizacionSesion.jsp"%>
	

	<!-- Mainly scripts -->
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="js/plugins/jeditable/jquery.jeditable.js"></script>

	<!-- Data Tables -->
	<script src="js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script src="js/plugins/dataTables/dataTables.responsive.js"></script>
	<script src="js/plugins/dataTables/dataTables.tableTools.min.js"></script>

	<!-- Custom and plugin javascript -->
	<script src="js/inspinia.js"></script>
	<script src="js/plugins/pace/pace.min.js"></script>
	<script src="js/casos/caso.js"></script>
	<script src="js/casos/visorCaso.js"></script>
    
   <!-- Input Mask-->
    <script src="js/plugins/jasny/jasny-bootstrap.min.js"></script>

	<script src="js/general/cargarComboBox.js"></script>
	<script src="js/general/general.js"></script>
	
	<!-- JQUERY MASKED INPUT -->
	<script
		src="js/plugins/masked-input/jquery.maskedinput.min.js"></script>
		
	<!-- JQUERY NUMBER INPUT -->
	<script src="js/plugins/jquery.number/jquery.number.js"></script>

	<!-- JQUERY VALIDATE -->
	<script
		src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>

<!-- finalizacin de Sesion -->
 <script  src="js/seguridad/session.js"></script>



	<script>
		$(document).ready(function() {
			$(document).ajaxStart($.blockUI)
				.ajaxStop($.unblockUI);
			
		  	$("#messageExitoso").hide();
		  	ocultarMensajesError();
			cargarCombox();
			directorioActual("Casos", "Visor de Casos");
			mostrarTabla();
			

		});
	</script>
</body>
</html>
