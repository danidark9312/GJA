<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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

<title>Detalle Caso</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/casos/detalleCaso.js"></script>
<script src="${pageContext.request.contextPath}/js/general/general.js"></script>
<script>
		var contexto = '${pageContext. request. contextPath}';
	</script>


</head>

<body class="top-navigation">

	<div id="wrapper">
		<%@ include file="/WEB-INF/jsp/general/menu.jsp"%>
		<%@ include file="/WEB-INF/jsp/general/userTool.jsp"%>
		<div id="page-wrapper" class="gray-bg">

			<!--         <div class="menu-top">     -->

			<!--             <div class="row bg-menu"> -->

			<!--                 <nav class="navbar navbar-static-top" role="navigation"> -->

			<!--                     <div class="container"> -->

			<!--                         <div class="navbar-header"> -->
			<!--                             <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button"> -->
			<!--                                 <i class="fa fa-reorder"></i> -->
			<!--                             </button> -->
			<!--                             <a href="#" class="navbar-brand"> -->
			<!--                                 <img src="img/logo-header.png" class="logo-desktop"> -->
			<!--                                 <img src="img/logo-mobile.png" class="logo-mobile"> -->
			<!--                             </a> -->
			<!--                         </div> -->

			<!--                         <div class="navbar-collapse collapse" id="navbar"> -->

			<!--                             <ul class="nav navbar-nav"> -->
			<!--                                 <li class="active"> -->
			<!--                                     <a aria-expanded="false" role="button" href="index.html">Inicio</a> -->
			<!--                                 </li> -->
			<!--                                 <li class="dropdown"> -->
			<!--                                     <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Casos <span class="caret"></span></a> -->
			<!--                                     <ul class="dropdown-menu" role="menu"> -->
			<!--                                         <li><a href="#">Opción 1</a></li> -->
			<!--                                         <li><a href="#">Opción 2</a></li> -->
			<!--                                         <li><a href="#">Opción 3</a></li> -->
			<!--                                         <li><a href="#">Opción 4</a></li> -->
			<!--                                     </ul> -->
			<!--                                 </li> -->
			<!--                                  <li> -->
			<!--                                     <a aria-expanded="false" role="button" href="#">Clientes</a> -->
			<!--                                 </li> -->
			<!--                                  <li> -->
			<!--                                     <a aria-expanded="false" role="button" href="#">Reportes</a> -->
			<!--                                 </li> -->
			<!--                                  <li> -->
			<!--                                     <a aria-expanded="false" role="button" href="#">Notificaciones</a> -->
			<!--                                 </li> -->
			<!--                                  <li> -->
			<!--                                     <a aria-expanded="false" role="button" href="#">Documentos</a> -->
			<!--                                 </li> -->
			<!--                                  <li> -->
			<!--                                     <a aria-expanded="false" role="button" href="#">Papeleras</a> -->
			<!--                                 </li> -->
			<!--                             </ul> -->

			<!--                         </div>     -->

			<!--                     </div> -->
			<!--                 </nav> -->
			<!--             </div> -->

			<!--         </div>     -->

			<!--         <div class="margen-superior"></div> -->

			<!--         <div id="breadcrumbs-logout"> -->

			<!--             <div class="container"> -->

			<!--                 <div class="row"> -->

			<!--                     <div class="col-md-6"> -->
			<!--                         <ol class="breadcrumb"> -->
			<!--                             <li> -->
			<!--                                 <a href="#">Inicio</a> -->
			<!--                             </li> -->
			<!--                             <li> -->
			<!--                                 <a href="#">Casos</a> -->
			<!--                             </li> -->
			<!--                              <li> -->
			<!--                                 <a href="#">Visor Caso</a> -->
			<!--                             </li> -->
			<!--                             <li class="active"> -->
			<!--                                 <strong>Detalle Caso</strong> -->
			<!--                             </li> -->
			<!--                         </ol> -->
			<!--                     </div> -->

			<!--                     <div class="col-md-6"> -->
			<!--                         <ul class="nav navbar-top-links navbar-right"> -->
			<!--                             <li> -->
			<!--                                 <i class="fa fa-user"></i> Natalia Madrigal -->
			<!--                             </li> -->
			<!--                             <li> -->
			<!--                                 <a href="#"> -->
			<!--                                     <i class="fa fa-sign-out"></i> Salir -->
			<!--                                 </a> -->
			<!--                             </li> -->
			<!--                         </ul> -->
			<!--                     </div> -->

			<!--                 </div> -->

			<!--             </div> -->

			<!--         </div>                             -->

			<div class="contenido">
				<div class="container">

					<div class="row">

						<div class="col-md-12 col-lg-12">
							<div class="ibox float-e-margins">

								<div class="ibox-title">
									<h5>Detalle del caso</h5>
									<!--                                 <div class="ibox-tools"> -->
									<!--                                     <button class="btn btn-azul" type="submit">Crear nuevo caso</button> -->
									<!--                                 </div> -->
								</div>

								<div class="ibox-content">

									<div class="panel blank-panel">

										<div class="panel-heading">
											<div class="panel-options">
												<ul class="nav nav-tabs">
													<li class="active"><a data-toggle="tab" href="#tab-1">Detalle
															del caso</a></li>
													<li class=""><a data-toggle="tab" href="#tab-2">Equipo
															del caso</a></li>
													<li class=""><a data-toggle="tab" href="#tab-3">Actividades</a></li>
													<!--<li class=""><a data-toggle="tab" href="#tab-4">Confidencial</a></li>
                                                 <li class=""><a data-toggle="tab" href="#tab-5">información de contacto</a></li>
                                                
                                                 -->
												</ul>
											</div>
										</div>

										<div class="panel-body">

											<form role="form-inline" class="panel-body">
												<input type="hidden" name="${_csrf.parameterName}"
													id="${_csrf.parameterName}" value="${_csrf.token}" /> <input
													type="hidden" value="${caso.codigo}" name="codigoParam"
													id="codigoParam" />
												<div class="tab-content detalles-caso">

													<div id="tab-1" class="tab-pane active">

														<div class="row pv-5">

															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.campo.nombreCaso" />
																</p>
															</div>

															<div class="col-md-3 dato">
																<p>
																	<label id="nombreCaso" name="nombreCaso" value=""></label>
																</p>
															</div>


															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.campo.tipoCaso" />
																</p>
															</div>

															<div class="col-md-3 dato">
																<p>

																	<label id="tipoCaso" name="tipoCaso" value=""></label>
																</p>
															</div>


														</div>

														<div class="row pv-5">

															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.campo.fechaDeLosHechos" />
																</p>
															</div>

															<div class="col-md-3 dato">
																<p>
																	<label id="fechaHechos" name="fechaHechos" value=""></label>
																</p>
															</div>

															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.campo.fechaDeCaducidad" />
																</p>
															</div>

															<div class="col-md-3 dato">
																<p>
																	<label id="fechaFinHechos" name="fechaFinHechos"
																		value=""></label>
																</p>
															</div>

														</div>


														<div class="row pv-5">
															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.detalleCaso.estadoProceso" />
																</p>
															</div>
															<div class="col-md-3 dato">
																<p>
																	<label id="procesoEstado" name="procesoEstado"></label>
																</p>
															</div>
															<div class="col-md-3 titulo-dato"></div>
															<div class="col-md-3 dato"></div>
														</div>

														<div class="row pv-5">

															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.detalleCaso.resumenHecho" />
																</p>
															</div>

															<div class="col-md-9 dato">
																<p>
																	<label id="resumenHechos" name="resumenHechos" value=""></label>
																</p>
															</div>

														</div>

														<div class="row">

															<div class="col-md-12">
																<h3 class="titulo-azul">
																	<p>
																		<spring:message code="label.detalleCaso.lugarHechos" />
																	</p>
																</h3>
															</div>

														</div>

														<div class="row pv-5">

															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.campo.paisDeLosHechos" />
																</p>
															</div>

															<div class="col-md-3 dato">
																<p>
																	<label id="hechosPais" name="hechosPais"></label>
																</p>
															</div>

															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message
																		code="label.campo.departamentoDeLosHechos" />
																</p>

															</div>

															<div class="col-md-3 dato">
																<p>
																	<label id="hechosDepartamento"
																		name="hechosDepartamento" value=""></label>
																</p>
															</div>

														</div>

														<div class="row pv-5">

															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.campo.municipioDeLosHechos" />
																</p>
															</div>

															<div class="col-md-3 dato">
																<p>
																	<label id="hechosMunicipio" name="hechosMunicipio"></label>
																</p>
															</div>
															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.campo.direccionDeLosHechos" />
																</p>

															</div>
															<div class="col-md-3 dato">
																<p>
																	<label id="hechosDireccion" name="hechosDireccion"></label>
																</p>
															</div>

															<div class="col-md-3 dato"></div>
														</div>
														<div class="row">

															<div class="col-md-12">
																<h3 class="titulo-azul">
																	<spring:message code="label.titulo.lugarDespacho" />
																</h3>
															</div>

														</div>

														<div class="row pv-5">

															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.detalleCaso.pais" />
																</p>
															</div>

															<div class="col-md-3 dato">
																<p>
																	<label id="ProcesoPais" name="procesoPais"></label>
																</p>
															</div>

															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.detalleCaso.departamento" />
																</p>
															</div>

															<div class="col-md-3 dato">
																<p>
																	<label id="procesoDepartamento"
																		name="procesoDepartamento" value=""></label>
																</p>
															</div>

														</div>

														<div class="row pv-5">

															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.detalleCaso.municipio" />
																</p>
															</div>

															<div class="col-md-3 dato">
																<p>
																	<label id="ProcesoMunicipio" name="procesoMunicipio"></label>
																</p>
															</div>
															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.detalleCaso.despacho" />
																</p>
															</div>

															<div class="col-md-3 dato">
																<p>
																	<label id="nombreDespacho" name="nombreDespacho"
																		value=""></label>
																</p>
															</div>

															<div class="col-md-3 dato"></div>
														</div>
														<div class="row pv-5">

															<div class="col-md-3 titulo-dato">
																<p>
																	<spring:message code="label.detalleCaso.funcionario" />
																</p>
															</div>

															<div class="col-md-3 dato">
																<p>
																	<label id="funcionario" name="funcionario" value=""></label>
																</p>
															</div>
															<div class="col-md-3 titulo-dato">
																<!-- 																<p> -->
																<%-- 																	<spring:message code="label.detalleCaso.despacho" /> --%>
																<!-- 																</p> -->
															</div>

															<div class="col-md-3 dato">
																<!-- 																<p> -->
																<!-- 																	<label id="nombreDespacho" name="nombreDespacho" -->
																<!-- 																		value=""></label> -->
																<!-- 																</p> -->
															</div>





														</div>
														<div class="row">

															<div class="col-md-3 titulo-dato ">
																<p>
																	<spring:message code="label.detalleCaso.descripcion" />
																</p>

															</div>
															<div class="col-md-9 dato">
																<p>
																	<label id="ProcesoDescripcion"
																		name="ProcesoDescripcion"></label>
																</p>
															</div>

														</div>


														<div class="row">

															<div class="col-md-12">
																<h3 class="titulo-azul">
																	<spring:message code="label.detalleCaso.bienesTitulo" />
																</h3>
															</div>

														</div>

														<div class="row">

															<div class="col-md-12">
																<div id="tablaListadoBienesAfectados"></div>
															</div>

														</div>


														<div class="row">

															<div class="col-md-12">
																<h3 class="titulo-azul">
																	<spring:message code="label.detalleCaso.tituloRadicado" />
																</h3>
															</div>

														</div>
														<div id="tablaRadicado"></div>


														<!--                                                 <div class="row"> -->

														<!--                                                     <div class="col-md-12 text-right pv-5"> -->
														<!--                                                         <button class="btn btn-azul" type="submit">Eliminar caso</button> -->
														<!--                                                         <button class="btn btn-azul" type="submit">Cerrar caso</button> -->
														<!--                                                         <button class="btn btn-azul" type="submit">Asociar radicados</button> -->
														<!--                                                         <button class="btn btn-azul" type="submit">Editar detalles</button> -->
														<!--                                                     </div> -->

														<!--                                                 </div> -->



													</div>

													<!-- FIN TAB -->
													<!--  TAB EQUIPO CASO -->
													<div id="tab-2" class="tab-pane">
														<c:forEach var="registro"
															items="${caso.casoEquipoCasoSet}" begin="0"
															varStatus="status">
															<div class="col-md-4 col-lg-4 integrante">
																<div class="inner">
																	<div class="row">
																		<div class="col-xs-5">
																			<div class="m-b-sm text-center">
																				<img alt="image" class="img-circle"
																					src="img/usuario-azul.png">
																				<p>${registro.tipoMiembro.nombre}</p>
																			</div>
																		</div>
																		<div class="col-xs-7">
																			<h3 class="nombre">${registro.equipoCaso.nombre}
																				${registro.equipoCaso.apellido}</h3>
																			<hr class="border-bottom">
																			<p class="empresa">${registro.equipoCaso.identificacion}</p>
																			<p class="dato">${registro.parentesco.nombre}</p>

																			<!-- 																			<p class="dato">  -->
																			<%-- 																				${registro.ciudadEquipoCaso.departamento.pais.nombre}  --%>
																			<!-- 																				</p>  -->
																			<!-- 																			<p class="dato">  -->
																			<%-- 																				${registro.ciudadEquipoCaso.nombre}  --%>
																			<%-- 																				, ${registro.ciudadEquipoCaso.departamento.nombre}  --%>
																			<!-- 																				</p>  -->
																			<p class="dato">
																				<spring:message code="label.detalleCaso.direccion" />
																				${registro.direccion}
																			</p>
																			<div class="row">
																				<div class="col-md-5 titulo-dato ">
																					<spring:message code="label.detalleCaso.telefono" />
																				</div>
																				<div class="col-md-7 titulo-dato ">
																					<SPAN title='Ver detalles'><a
																						name='masTelefono<c:out value="${status.count}"/>'><i
																							id='masTelefono<c:out value="${status.count}"/>'
																							class='glyphicon glyphicon-chevron-down'
																							onclick="mostrarTelefono(<c:out value="${status.count}"/>)"
																							style="display: block"></i></a></SPAN> <SPAN
																						title='Ver detalles'><a
																						name='menosTelefono<c:out value="${status.count}"/>'><i
																							id='menosTelefono<c:out value="${status.count}"/>'	class='glyphicon glyphicon-chevron-up'
																							onclick="ocultarTelefono(<c:out value="${status.count}"/>)"
																							style="display: none"></i></a></SPAN>
																				</div>
																			</div>

																			<div
																				id="campoTelefono<c:out value="${status.count}"/>"
																				style='display: none;'>
																				<c:forEach var="registroTelefono"
																					items="${registro.equipoCaso.telefonoList}"
																					begin="0" end="3">
																					<p class="dato">${registroTelefono.numero}</p>
																				</c:forEach>
																			</div>
																			<div class="row">
																				<div class="col-md-5 titulo-dato ">
																					<spring:message code="label.detalleCaso.correo" />
																				</div>
																				<div class="col-md-7 titulo-dato ">
																					<SPAN title='Ver detalles'><a
																						name='masCorreo<c:out value="${status.count}"/>'><i
																							id='masCorreo<c:out value="${status.count}"/>'
																							class='glyphicon glyphicon-chevron-down'
																							onclick="mostrarEmail(<c:out value="${status.count}"/>)"
																							style="display: block"></i></a></SPAN> <SPAN
																						title='Ver detalles'><a
																						name='menosCorreo<c:out value="${status.count}"/>'><i
																							id='menosCorreo<c:out value="${status.count}"/>'
																							class='glyphicon glyphicon-chevron-up'
																							onclick="ocultarEmail(<c:out value="${status.count}"/>)"
																							style="display: none"></i></a></SPAN>
																				</div>
																			</div>
																			<div id="campoCorreo<c:out value="${status.count}"/>"
																				style='display: none;'>
																				<c:forEach var="registroEmail"
																					items="${registro.equipoCaso.correoList}" begin="0"
																					end="3">
																					<p class="dato">${registroEmail.correo}</p>
																				</c:forEach>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</c:forEach>
														<div id="controlEspacios"></div>


													</div>



													<!-- FIN TAB -->

													<div id="tab-3" class="tab-pane">

														<div class="wrapper wrapper-content  animated fadeInRight">
															<div class="row" id="sortable-view">

																<c:forEach items="${actividades}" var="actividad">


																	<div class="col-lg-12">

																		<div class="ibox ">
																			<div class="ibox-title">
																				<h5>${actividad.nombreActividad}</h5>
																				<div class="ibox-tools">
																					<a class="collapse-link"> <i
																						class="fa fa-chevron-up"></i>
																					</a>


																				</div>
																			</div>
																			<div class="ibox-content">

																				<table class="table table-striped">
																					<thead>
																						<tr>
																							<th width="20%">Tarea</th>
																							<th width="50%">Descripción</th>
																							<th width="20%">Responsable</th>
																							<th width="10%">Fecha Limite</th>
																						</tr>
																					</thead>
																					<tbody>
																						<c:forEach
																							items="${actividad.tareaParticularCasoSet}"
																							var="tarea">
																							<tr>
																								<td>${tarea.tarea}</td>
																								<td>${tarea.detalle}</td>
																								<td>${tarea.casoEquipoCaso.equipoCaso.nombre}</td>
																								<td><fmt:formatDate pattern="yyyy-MM-dd"
																										value="${tarea.fechaLimite}" /></td>
																							</tr>

																						</c:forEach>
																					</tbody>
																				</table>
																			</div>
																		</div>

																	</div>
																</c:forEach>


															</div>
														</div>



													</div>

													<!-- FIN TAB -->

													<div id="tab-4" class="tab-pane">

														<p>Thousand unknown plants are noticed by me: when I
															hear the buzz of the little world among the stalks, and
															grow familiar with the countless indescribable forms of
															the insects and flies, then I feel the presence of the
															Almighty, who formed us in his own image, and the breath
														</p>

														<p>I am alone, and feel the charm of existence in this
															spot, which was created for the bliss of souls like mine.
															I am so happy, my dear friend, so absorbed in the
															exquisite sense of mere tranquil existence, that I
															neglect my talents. I should be incapable of drawing a
															single stroke at the present moment; and yet.</p>

													</div>

													<!-- FIN TAB -->

													<div id="tab-5" class="tab-pane">
														<strong>Donec quam felis</strong>

														<p>Thousand unknown plants are noticed by me: when I
															hear the buzz of the little world among the stalks, and
															grow familiar with the countless indescribable forms of
															the insects and flies, then I feel the presence of the
															Almighty, who formed us in his own image, and the breath
														</p>

														<p>I am alone, and feel the charm of existence in this
															spot, which was created for the bliss of souls like mine.
															I am so happy, my dear friend, so absorbed in the
															exquisite sense of mere tranquil existence, that I
															neglect my talents. I should be incapable of drawing a
															single stroke at the present moment; and yet.</p>

													</div>

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

		</div>

		<div class="footer">
			<div class="container">
				<div class="row">
					<div class="col-lg-4">
						<img src="img/logo-footer.png">
					</div>
					<div class="col-lg-8 text-right">MÓDULO WEB © 2015 - Grupo
						Jurídico de Antioquia - Todos los derechos reservados.</div>
				</div>
			</div>
		</div>

	</div>
 <%@ include file="/WEB-INF/jsp/seguridad/modalMensajeFinalizacionSesion.jsp"%>


	<!-- Mainly scripts -->
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- Custom and plugin javascript -->
	<script src="js/inspinia.js"></script>
	<script src="js/plugins/pace/pace.min.js"></script>

	<!-- Flot -->
	<script src="js/plugins/flot/jquery.flot.js"></script>
	<script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
	<script src="js/plugins/flot/jquery.flot.resize.js"></script>

	<!-- ChartJS-->
	<script src="js/plugins/chartJs/Chart.min.js"></script>

	<!-- Peity -->
	<script src="js/plugins/peity/jquery.peity.min.js"></script>
	<!-- Peity demo -->
	<script src="js/demo/peity-demo.js"></script>

	<script src="js/plugins/dataTables/jquery.dataTables-cust.min.js"></script>
	<script src="js/plugins/dataTables/ColReorder.min.js"></script>
	<script src="js/plugins/dataTables/FixedColumns.min.js"></script>
	<script src="js/plugins/dataTables/ColVis.min.js"></script>
	<script src="js/plugins/dataTables/ZeroClipboard.js"></script>
	<script src="js/plugins/dataTables/dataTable.tableTools.min.js"></script>
	<script src="js/plugins/dataTables/DT_bootstrap.js"></script>

	<!-- JQUERY MASKED INPUT -->
	<script src="/js/plugins/masked-input/jquery.maskedinput.min.js"></script>

	<!-- JQUERY NUMBER INPUT -->
	<script src="js/plugins/jquery.number/jquery.number.js"></script>

	<!-- JQUERY BlockUI Plugin -->
	<script src="js/plugins/jqueryBlockUI/jquery.blockUI.js"></script>

	
	
	<!-- finalizacin de Sesion -->
	 <script  src="js/seguridad/session.js"></script>
	<script> 
    $(document).ready(function() {

    		$(document).ajaxStart($.blockUI)
				.ajaxStop($.unblockUI);
    	 	if ($("#codigoParam").val() != "") {
				 consultarCaso ($("#codigoParam").val()); 
		    	 mostrarTablaBienesAfectados($("#codigoParam").val());
		    	 mostrarTablaRadicado($("#codigoParam").val());
			}
    	 	WinMove();
		
    	  });
	
    </script>
</body>

</html>