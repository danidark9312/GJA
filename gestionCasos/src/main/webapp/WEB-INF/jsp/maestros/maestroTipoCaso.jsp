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

<title>Casos</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/plugins/chosen/chosen.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">



</head>

<body class="top-navigation">

	<div id="wrapper">
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
											<h5>
												<spring:message code="label.maestroTipoCaso.titulo" />
											</h5>
										</div>
										<div class="ibox-content">

												<form role="form" class="panel-body">
														<input type="hidden" name="${_csrf.parameterName}"
															id="${_csrf.parameterName}" value="${_csrf.token}" /> <input
															type='hidden' name='idusercreacion' id='idusercreacion'
															value='<sec:authentication property="principal.id"/>' />
														<div class="row">
															<div class="alert alert-success" id="messageExitoso">
								                                How quickly daft jumping zebras vex. <a class="alert-link" href="#">Alert Link</a>.
								                            </div>
															<div class="alert alert-danger" id="messageError">
								                                How quickly daft jumping zebras vex. <a class="alert-link" href="#">Alert Link</a>.
								                            </div>
														</div>
														<div class="row" style="text-align: right;padding-right: 1%;">

															 <a data-toggle="modal"
																onclick="mostrarModalNuvoTipoCaso()"
																class="btn btn-primary btn-circle .btn-xs"
																style="background-color: #449D44;border: 0;"  title="<spring:message code="label.maestroTipoCaso.botonNuevo" />"> <i
																class="glyphicon glyphicon-plus"></i>
															</a>
														</div>
														<div id="tablaListadoTiposCasos"></div>

																<div class="row"></div>
																<!-- TABLA -->
																<div id="tablaListado"></div>

																<hr class="border-bottom">

															
													</form>

												

											

										
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
	</div>

	<!-- Ventanas modales -->
	<%@ include file="/WEB-INF/jsp/modales/modalMaestroTipoCaso.jsp"%>
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
	<script src="js/maestros/maestroTipoCaso.js"></script>

	<!-- Custom and plugin javascript -->
	<script src="js/inspinia.js"></script>
	<script src="js/plugins/pace/pace.min.js"></script>

	<!-- JQUERY VALIDATE -->
	<script
		src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>

	<script src="js/general/cargarComboBox.js"></script>
	<script src="js/general/general.js"></script>
	
	<!-- Chosen -->
    <script src="js/plugins/chosen/chosen.jquery.js"></script>
	
	
	<!-- finalizacin de Sesion -->
	 <script  src="js/seguridad/session.js"></script>

	<script>
		$(document)
				.ready(
						function() {
							rulesForm();
							directorioActual("Administradores", "Tipos Casos");
							mostrarTablaTipoCaso();
							$("#messageExitoso").hide();
							$("#messageError").hide();
							$("#messageExitosoModal").hide();
							$("#messageErrorModal").hide();

							var config = {
					                '.chosen-select'           : {},
					                '.chosen-select-deselect'  : {allow_single_deselect:true},
					                '.chosen-select-no-single' : {disable_search_threshold:10},
					                '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
					                '.chosen-select-width'     : {width:"95%"}
					            }
					            //for (var selector in config) {
					                $("#actividadTipoCaso").chosen({ width:  '300px' },{allow_single_deselect:true});
					            //}



						});

	</script>


</body>
</html>