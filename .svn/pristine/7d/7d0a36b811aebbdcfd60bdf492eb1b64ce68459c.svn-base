var $clientForm ;
var formularioEquipoCaso=null;
var formularioaActividad=null;
var formularioPrestamos=null;
var contFilasTareasAdicionales = 0;
var filaActividad = 0;
var actividadesArray = new Array();
var countActividades = 0;
var filaTareaActividad = 0;
var filasActividadesParticulares=new Array(); 
var countActividadesParticulares=0;
var codigoActivad=10000000;
var mensaje='<div class="alert alert-danger" id="messageErrorAactividad" name="messageError" style="display: none">How quickly daft jumping zebras vex. <a class="alert-link" href="#">Alert Link</a>.</div>';
var metodoOnchage='onchange="validarfechasTareas(this)"';
var metodoOnchageActividad='onchange="validarFechasDesdeActividad(this)"';
var formularioNuevoCaso=null;
var botonPresionado = null;
var filaABorrar = null;
var filaABorrarTarea = null; 


function irNuevoCaso() {
	//document.location.href = "nuevoCaso";
	$("#modal-nuevoCaso").modal("show");
}
//se carga el formulario de equipo caso  y de la actividad limpio para poder clonarlo 
function cargarFormularios()
{
	if (formularioEquipoCaso == null) {
		formularioDemandados = $("[name = formularioEquipoCaso]")[0].cloneNode(true);
		formularioEquipoCaso = $("[name = formularioEquipoCaso]")[1].cloneNode(true);
	}
	if (formularioaActividad == null) {
		formularioaActividad = $("[name = actividadParticular]")[0].cloneNode(true);	 	
	}
	if (formularioPrestamos == null) {
		formularioPrestamos = $("[name = prestamos]")[0].cloneNode(true);	 	
	}
	formularioNuevoCaso=$("#modal")[0].cloneNode(true);
	
}
// metodo para cargar la fecha de caducidad
function mostrarFechaCaducidad()
{
	
	
	fechaCaduci=$("#txtFechaDeLosHechos").val();
	var fecha=fechaCaduci.split("-");
	var aniosCaducidad = $("#aniosCaducidadParam").val();
	ano = parseInt(fecha[0]) + parseInt(aniosCaducidad);	
	$("#txtFechaDeCaducidad").val(ano+"-"+fecha[1]+"-"+fecha[2]);
//	var fechaCaducidad = new Date($("#txtFechaDeLosHechos").val());
//	var fecha;
//		ano=(fechaCaducidad.getFullYear()+2).toString();
//		fecha=ano.concat("-");
//		mes=fechaCaducidad.getMonth()+1;
//		if(mes.toString().length<2){
//			fecha=fecha.concat("0");
//			fecha=fecha.concat(mes);
//		}
//		else{
//			fecha=fecha.concat(mes);
//		}
//		dia=fechaCaducidad.getDate();
//		fecha=fecha.concat("-");
//		if(dia.toString().length<2){
//			fecha=fecha.concat("0");
//			fecha=fecha.concat(dia);
//		}
//		else{
//			fecha=fecha.concat(dia);
//		}
//		$("#txtFechaDeCaducidad").val(fecha);
			
}
// metodo para agregar formulario bienes afectados
function agregarFormularioBienesAfectados() {
	var formularioBienesAfectados = $("[name = formularioBienesAfectados]")[0];
	var object = formularioBienesAfectados.cloneNode(true);
	object.style.display='block';
	var boton = object.getElementsByTagName('a')[0];
	boton.setAttribute("class", "btn btn-danger btn btn-circle .btn-xs");
	boton.setAttribute("style", "background-color: red;border=0;");
	boton.firstElementChild.setAttribute("class", "glyphicon glyphicon-minus");
	boton.onclick = function borrarFormulario() {
		document.getElementById("panelBienesAfectados").removeChild(this.parentNode.parentNode.parentNode);
	};
	$("#panelBienesAfectados").append(object);
}
// metodo para mostrar el formulario de radicados acumlados
function mostrarCamposRadicadoAcumlado(campo) {
	var  checkBox = campo;
	if (checkBox.checked){
		checkBox.parentNode.parentNode.parentNode.parentNode.nextElementSibling.style.display='block';
	}else{
		
		checkBox.parentNode.parentNode.parentNode.parentNode.nextElementSibling.style.display='none';
	}
}
//metodo para agregar el formulario del radicado
function agregarFormularioRadicado() {
	var formularioBienesAfectados = $("[name = formularioRadicado]")[0];
	var object = formularioBienesAfectados.cloneNode(true);
	object.style.display='block';
	var boton = object.getElementsByTagName('a')[0];
	boton.setAttribute("class", "btn btn-danger btn btn-circle .btn-xs");
	boton.setAttribute("style", "background-color: red;border:0;");
	boton.firstElementChild.setAttribute("class", "glyphicon glyphicon-minus");
	boton.onclick = function borrarFormulario() {
		document.getElementById("panelRadicado").removeChild(this.parentNode.parentNode.parentNode);
	};
	$("#panelRadicado").append(object);
}
// metodo para solo mostrar el campo nombre cuando se tiene una persona juridica
function mostrarPersonaJuridica(campoTipoPersona)
{
	var selector=campoTipoPersona;
	if(selector.value=="Persona Juridica"){
		selector.parentNode.parentNode.nextElementSibling.style.display='none';
		selector.parentNode.parentNode.nextElementSibling.nextElementSibling.style.display='block';
	}else{
		selector.parentNode.parentNode.nextElementSibling.style.display='block';
		selector.parentNode.parentNode.nextElementSibling.nextElementSibling.style.display='none';
		
	}
}
// metodo para agregar formulario del equipo del caso
function agregarFormularioEquipoCaso()
{
	var object = formularioEquipoCaso.cloneNode(true);
	var arrayBotones = object.getElementsByTagName('a'); 
	var boton = arrayBotones[arrayBotones.length - 1]; 
	boton.setAttribute("class", "btn btn-danger btn btn-circle .btn-xs");
	boton.setAttribute("style", "background-color: red;border:0;");
	boton.setAttribute("title", "Eliminar");
	boton.firstElementChild.setAttribute("class", "glyphicon glyphicon-minus");
	boton.onclick = function borrarFormulario() {
		//document.getElementById("panelEquipoCaso").removeChild(this.parentNode.parentNode.parentNode);
		$(this).closest("div[name=formularioEquipoCaso]").remove();
	};
	$("#panelEquipoCaso").append(object);	
	//rulesForm();
}
function eliminarDemandadoYVictimas(botonEliminar){
	$(botonEliminar).closest("div[name=formularioEquipoCaso]").remove();
}
// metodo para  agregar formulario demandado
function agregarFormularioDemandados()
{
	var object = formularioDemandados.cloneNode(true);
	var arrayBotones = object.getElementsByTagName('a'); 
	var boton = arrayBotones[arrayBotones.length - 1]; 
	boton.setAttribute("class", "btn btn-danger btn btn-circle .btn-xs");
	boton.setAttribute("style", "background-color: red;border:0;");
	boton.setAttribute("title", "Eliminar");
	boton.firstElementChild.setAttribute("class", "glyphicon glyphicon-minus");
	boton.onclick = function borrarFormulario() {
		//document.getElementById("panelEquipoCaso").removeChild(this.parentNode.parentNode.parentNode);
		$(this).closest("div[name=formularioEquipoCaso]").remove();
	};
	$("#panelDemandado").append(object);	
	//rulesForm();
}
// metodo para agregar otro campo telefono
function agregartelefono(boton)
{
	var formularioTelefono = boton.parentNode.parentNode;
	var object = formularioTelefono.cloneNode(true);
	$(object).find("input[name^='txtTelefonoMiembro']").val("");
	var boton = object.getElementsByTagName('a')[0];
	
	//cmbCiudad = $(object).find("a").eq(0);
	//boton.attr("class","btn btn-danger btn");
	
	boton.setAttribute("class", "btn btn-danger btn btn-circle .btn-xs");
	boton.setAttribute("style", "background-color: red;border:0;");
	boton.setAttribute("title", "Eliminar Teléfono");
	
	//boton.children().eq(0)
	boton.firstElementChild.setAttribute("class", "glyphicon glyphicon-minus");
	
	
	
	boton.onclick = function borrarFormulario() {
		formularioTelefono.parentNode.removeChild(this.parentNode.parentNode);
	};
	formularioTelefono.parentNode.appendChild(object);

}
// metodo para agregar otro campo celular
function agregarCelular(boton)
{
	var formularioCelular = boton.parentNode.parentNode;
	var object = formularioCelular.cloneNode(true);
	$(object).find("input[name=txtCelularMiembro]").val("");
	var boton = object.getElementsByTagName('a')[0];
	boton.setAttribute("class", "btn btn-danger btn btn-circle .btn-xs");
	boton.setAttribute("style", "background-color: red;border:0;");
	boton.setAttribute("title", "Eliminar Celular");
	boton.firstElementChild.setAttribute("class", "glyphicon glyphicon-minus");
	boton.onclick = function borrarFormulario() {
		formularioCelular.parentNode.removeChild(this.parentNode.parentNode);
	};
	formularioCelular.parentNode.appendChild(object);

}
//metodo para agregar otro campo correo
function agregarCorreo(boton)
{
	var formularioCorreo = boton.parentNode.parentNode;
	var object = formularioCorreo.cloneNode(true);
	$(object).find("input[name^='txtCorreoMiembro']").val("");
	var boton = object.getElementsByTagName('a')[0];
	boton.setAttribute("class", "btn btn-danger btn btn-circle .btn-xs");
	boton.setAttribute("style", "background-color: red;border:0;");
	boton.setAttribute("title", "Eliminar Correo");
	boton.firstElementChild.setAttribute("class", "glyphicon glyphicon-minus");
	boton.onclick = function borrarFormulario() {
		formularioCorreo.parentNode.removeChild(this.parentNode.parentNode);
	};
	formularioCorreo.parentNode.appendChild(object);

}
//metodo para agregar otro formulario actividad particular
function agregarFormularioActividadParticular()//boton)
{
		//var nuevasActividades = boton.parentNode.parentNode.parentNode;
		var object = formularioaActividad.cloneNode(true);		
		var boton = object.getElementsByTagName('a')[0];
		boton.setAttribute("class", "btn btn-danger btn btn-circle .btn-xs");
		boton.setAttribute("style", "background-color: red;border:0;");
		boton.firstElementChild.setAttribute("class", "glyphicon glyphicon-minus");
		boton.onclick = function borrarFormulario() {
			//nuevasActividades.parentNode.removeChild(this.parentNode.parentNode.parentNode);
			document.getElementById("actividades").removeChild(this.parentNode.parentNode.parentNode);
		};
		//nuevasActividades.parentNode.appendChild(object);
		$("#actividades").append(object);

	// cargarResponsableTareas(object);
		//cargarAbogado(object);
		
}
//metodo para agregar otro formulario tarea  particular
function agregarFormularioTareaParticular(boton){
	
	//clonarCampoTareaParticular($("#btnTareas"));
	
	//var nuevasActividades =$(boton).closest("div[name=actividadParticular]").find("div[name=prueba]")[0]; //add() $("#campoTarea")[0];
	var nuevasActividades =$(boton).closest("div[name=actividadParticular]").find("div[name=campoTarea]")[0]; //add() $("#campoTarea")[0];
	var object = nuevasActividades.cloneNode(true);	
	object.style.display='block';
	//$(object).find("div[name=campoTarea]")[0].style.display='block';
	var boton= $(object).find("a[name=btTareas]")[0];
	$(object).find("div[name=messageError]").hide();
	//var boton = object.getElementsByTagName('a')[0];
//	boton.attr("class", "btn btn-danger btn");
//	boton.attr("style", "background-color: red;");
//	boton.first("class", "glyphicon glyphicon-minus");
	boton.setAttribute("class", "btn btn-danger btn btn-circle .btn-xs");
	boton.setAttribute("style", "background-color: red;border:0;");
	boton.firstElementChild.setAttribute("class", "glyphicon glyphicon-minus");
	boton.onclick = function borrarFormulario() {
			nuevasActividades.parentNode.removeChild(this.parentNode.parentNode.parentNode);
	};
	nuevasActividades.parentNode.appendChild(object);

	cargarResponsableTareas(object);
	
		 
}
// metodo para agregar varios prestamos
function agregarFormularioPrestamos()
{
	var object = formularioPrestamos.cloneNode(true);
	object.style.display='block';
	var arrayBotones = object.getElementsByTagName('a'); 
	var boton = arrayBotones[arrayBotones.length - 1]; 
	boton.setAttribute("class", "btn btn-danger btn btn-circle .btn-xs");
	boton.setAttribute("style", "background-color: red;border:0;");
	boton.firstElementChild.setAttribute("class", "glyphicon glyphicon-minus");
	boton.onclick = function borrarFormulario() {
		//document.getElementById("panelEquipoCaso").removeChild(this.parentNode.parentNode.parentNode);
		$(this).closest("div[name=prestamos]").remove();
	};
	$("#panelPrestamos").append(object);
	formatearCamposValores();
	//rulesForm();
}
//metodo para guardar el caso
function doAjaxPostAdd() {
	var fechaHechos = new Date($("#txtFechaDeLosHechos").val());
	var fechaCaducidad = new Date($("#txtFechaDeCaducidad").val());
	var data_caso = "_csrf=" + $("#_csrf").val();
	// bloque para ingresar el detalle del caso
		data_caso += "&estadoCaso.codigo="+$("#txtEstadoCaso").val()+"&tipoCaso.codigo=" + $("#txtTipoCaso").val() + "&nombre=" + $("#txtNombreCaso").val() + "&fechaHecho=" + fechaHechos;
		data_caso += "&numeroDespacho="+$("#txtnumeroDespacho").val() + "&nombreFuncionario=" + $("#txtnombreFuncionario").val();
		data_caso += "&comentario="+ $("#txtComentario").val();
		data_caso += "&ciudadHechos.ciudadPK.codigoCiudad=" +$("#txtMunicipioDeLosHechos").val() +"&ciudadHechos.ciudadPK.codigoDepartamento=" +$("#txtDepartamentoDeLosHechos").val();
		data_caso += "&direccionHechos=" + $("#txtDireccionDeLosHechos").val() + "&resumenHechos=" + $("#txtResumenDeLosHechos").val();
		//data_caso += "&fechaCaducidad=" + fechaCaducidad + "&justificacion=" + "Esta es la justificacion";
		data_caso += "&fechaCaducidad=" + fechaCaducidad;
		data_caso += "&usuarioCreacion=" + $("#idusercreacion").val();
		data_caso += "&usuarioUltimaModificacion=" + $("#idusercreacion").val();
		data_caso += "&direccionProceso=" + $("#txtDireccionDespacho").val();
		if(!EstaVacio($("#txtMunicipioProceso").val())){
			
			data_caso += "&ciudadProceso.ciudadPK.codigoCiudad=" + $("#txtMunicipioProceso").val() + "&ciudadProceso.ciudadPK.codigoDepartamento=" +$("#txtDeparmentoProceso").val();
		}
	
	//Bloque para ingresar los bienes afectados
		
		if($("div[name=formularioBienesAfectados]").length>1){
			$("div[name=formularioBienesAfectados]:gt(0)").each(function(ind,formularioBienAfectado){
				
//				if($(formularioBienAfectado).find("input[name=txtTituloBien]").val()!="" || 
//						$(formularioBienAfectado).find("input[name=txtTituloBien]").val()!=null || $(formularioBienAfectado).find("select[name=txtclaseBien]").val()!="" || 
//						$(formularioBienAfectado).find("select[name=txtclaseBien]").val()!=null || $(formularioBienAfectado).find("input[name=txtdescripcionBien]").val()!="" ||
//						$(formularioBienAfectado).find("input[name=txtdescripcionBien]").val()!=null
//						)
				
				if(!EstaVacio($(formularioBienAfectado).find("input[name=txtTituloBien]").val()) || 
						!EstaVacio($(formularioBienAfectado).find("select[name=txtclaseBien]").val()) || 
						!EstaVacio($(formularioBienAfectado).find("input[name=txtdescripcionBien]").val())
						){
		
					
							if(!EstaVacio($(formularioBienAfectado).find("input[name=txtTituloBien]").val())){
								
								data_caso+="&bienAfectadoSet["+ ind +"].titulo="+$(formularioBienAfectado).find("input[name=txtTituloBien]").val();
							}
							if(!EstaVacio($(formularioBienAfectado).find("select[name=txtclaseBien]").val())){
								data_caso+="&bienAfectadoSet["+ ind +"].clase.codigo="+$(formularioBienAfectado).find("select[name=txtclaseBien]").val();
								
							}
							if(!EstaVacio($(formularioBienAfectado).find("textarea[name=txtdescripcionBien]").val())){
								
								data_caso+="&bienAfectadoSet["+ ind +"].detalle="+$(formularioBienAfectado).find("textarea[name=txtdescripcionBien]").val();
							}
							data_caso+="&bienAfectadoSet["+ ind +"].activo="+"A";
				}
			});
		}
		
		
		
		
//		var titulo=document.getElementsByName("txtTituloBien");
//		var claseBienAfectado=document.getElementsByName("txtclaseBien");
//		var descripcion=document.getElementsByName("txtdescripcionBien");
//	
//			for(var i=0; i<$("[name = formularioBienesAfectados]").length; i++)
//			{
//				data_caso+="&bienAfectadoSet["+i+"].titulo="+titulo[i].value;
//				data_caso+=	"&bienAfectadoSet["+i+"].clase.codigo="+claseBienAfectado[i].value;
//				data_caso+=	"&bienAfectadoSet["+i+"].detalle="+descripcion[i].value;
//				data_caso+="&bienAfectadoSet["+i+"].activo="+"a";
//					
//			}
//		Bloque para ingresar los radicados 
			if($("div[name=formularioRadicado]").length>1){	
				$("div[name=formularioRadicado]:gt(0)").each(function(ind,formularioRadicado){
					if ($(formularioRadicado).find("input[name=checkBoxRadicado]:checked").length>0){
						data_caso+="&radicadoSet["+ ind +"].codigo="+$(formularioRadicado).find("input[name=txtNumeroRadicado]").val();
						data_caso+="&radicadoSet["+ ind +"].instancia.codigo="+$(formularioRadicado).find("select[name=txtInstanciaRadicado]").val();
						data_caso+="&radicadoSet["+ ind +"].activo=" + "A" ;
						data_caso+="&radicadoSet["+ ind +"].usuarioCreacion="+$("#idusercreacion").val();
						data_caso+="&radicadoSet["+ ind +"].usuarioUltimaModificacion="+$("#idusercreacion").val();
						data_caso+="&radicadoSet["+ ind +"].acumulado="+ "S";
						data_caso+="&radicadoSet["+ ind +"].radicadoAcumulado.codigo="+$(formularioRadicado).find("input[name=txtNumeroRadicadoPadre]").val(); 
						data_caso+="&radicadoSet["+ ind +"].comentarioAcumulado="+$(formularioRadicado).find("input[name=txtAcomuladoObservaciones]").val();
						data_caso+="&radicadoSet["+ ind +"].acumuladoCon="+$(formularioRadicado).find("input[name=txtacomuladoCon]").val();
						
					}else{
						data_caso+="&radicadoSet["+ ind +"].codigo="+$(formularioRadicado).find("input[name=txtNumeroRadicado]").val();
						data_caso+="&radicadoSet["+ ind +"].instancia.codigo="+$(formularioRadicado).find("select[name=txtInstanciaRadicado]").val();
						data_caso+="&radicadoSet["+ ind +"].activo=" + "A" ;
						data_caso+="&radicadoSet["+ ind +"].usuarioCreacion="+$("#idusercreacion").val();
						data_caso+="&radicadoSet["+ ind +"].usuarioUltimaModificacion="+$("#idusercreacion").val();
						data_caso+="&radicadoSet["+ ind +"].acumulado="+ "N";
					}
					
				});
			}
				
//						var numerosRadicados=document.getElementsByName("txtNumeroRadicado");
//						var instanciasRadicados=document.getElementsByName("txtInstanciaRadicado");
//						var checkBoxRadicadosAcumulado=document.getElementsByName("checkBoxRadicado");
//						var acumuladosCon=document.getElementsByName("txtacomuladoCon");// pendiente por crear el campo en la base de datos
//						var radicadosPadre=document.getElementsByName("txtNumeroRadicadoPadre");
//						var comentarios=document.getElementsByName("txtAcomuladoObservaciones");
//				
//						for(var i=0; i<$("[name = formularioRadicado]").length; i++){
//							if (checkBoxRadicadosAcumulado[i].checked){
//									data_caso+="&radicadoSet["+i+"].codigo="+numerosRadicados[i].value;
//									data_caso+="&radicadoSet["+i+"].instancia.codigo="+instanciasRadicados[i].value;
//									data_caso+="&radicadoSet["+i+"].activo=" + "A" + "&radicadoSet["+i+"].usuarioCreacion="+$("#idusercreacion").val();
//									data_caso+="&radicadoSet["+i+"].usuarioUltimaModificacion="+$("#idusercreacion").val();
//									data_caso+="&radicadoSet["+i+"].acumulado="+ "S" + "&radicadoSet["+i+"].radicadoAcumulado.codigo="+radicadosPadre[i].value; 
//									data_caso+="&radicadoSet["+i+"].comentarioAcumulado="+comentarios[i].value;
//									data_caso+="&radicadoSet["+i+"].acumuladoCon="+acumuladosCon[i].value;
//									
//							}else{
//									data_caso+="&radicadoSet["+i+"].codigo="+numerosRadicados[i].value;
//									data_caso+="&radicadoSet["+i+"].instancia.codigo="+instanciasRadicados[i].value;
//									data_caso+="&radicadoSet["+i+"].activo=" + "a" + "&radicadoSet["+i+"].usuarioCreacion="+$("#idusercreacion").val();
//									data_caso+="&radicadoSet["+i+"].usuarioUltimaModificacion="+$("#idusercreacion").val();
//									data_caso+="&radicadoSet["+i+"].acumulado="+ "N";
//									
//							}
//					} 
       
        // Bloque para ingresar los miembros del equipo
		var direccion=document.getElementsByName("txtDireccionMiembro");
	//	var identificacion=document.getElementsByName("txtIdentificacionMiembro");
	//	var tipoMiembro=document.getElementsByName("txtTipoDeMiembro");
	//	var parentesco=document.getElementsByName("txtParentescoMiembro");
	//	var checkBoxEsContacto=document.getElementsByName("esContacto");
	//	var selectorEsPersonaJuridica=document.getElementsByName("txtTipoPersona");
		var departamentoMiembroEquipo=document.getElementsByName("TxtDepartamentoMiembro");
		var ciudadMiembroEquipo=document.getElementsByName("txtMunicipioMiembro");
			for(var i=0; i<$("[name = formularioEquipoCaso]").length; i++){
				var formularioEquipoCaso = $("[name = formularioEquipoCaso] ")[i];
				data_caso+="&casoEquipoCasoSet["+i+"].direccion="+direccion[i].value;
				if(ciudadMiembroEquipo[i].value!="" && ciudadMiembroEquipo[i].value!=null){
					
					data_caso += "&casoEquipoCasoSet["+i+"].ciudadEquipoCaso.ciudadPK.codigoCiudad=" +ciudadMiembroEquipo[i].value;
					data_caso +="&casoEquipoCasoSet["+i+"].ciudadEquipoCaso.ciudadPK.codigoDepartamento=" + departamentoMiembroEquipo[i].value;
				}
				
				// --------se esta modificando
				if($(formularioEquipoCaso).find("select[name=txtTipoPersona]").length != 0)
				{
					if($(formularioEquipoCaso).find("select[name=txtTipoPersona]").val()=="Persona Juridica" 
						&& $(formularioEquipoCaso).find("select[name=txtTipoPersona]").val()!=""){
						
						data_caso +="&casoEquipoCasoSet["+i+"].personajuridica="+"S";
						data_caso +="&casoEquipoCasoSet["+i+"].equipoCaso.nombre="+$(formularioEquipoCaso).find("input[name=txtNombresMiembro]").val();
					}else{
						data_caso +="&casoEquipoCasoSet["+i+"].personajuridica="+"N";
						data_caso +="&casoEquipoCasoSet["+i+"].equipoCaso.nombre="+$(formularioEquipoCaso).find("input[name=txtNombresMiembro]").val();						
					}
					data_caso +="&casoEquipoCasoSet["+i+"].casoEquipoCasoPK.miembro="+3;
					data_caso +="&casoEquipoCasoSet["+i+"].activo="+"S";
					data_caso +="&casoEquipoCasoSet["+i+"].contacto="+"S";
				}
				else{
					data_caso +="&casoEquipoCasoSet["+i+"].personajuridica="+"N";
					data_caso +="&casoEquipoCasoSet["+i+"].equipoCaso.nombre="+$(formularioEquipoCaso).find("input[name=txtNombresMiembro]").val();
					data_caso +="&casoEquipoCasoSet["+i+"].equipoCaso.apellido="+$(formularioEquipoCaso).find("input[name=txtApellidosMiembro]").val();
					data_caso +="&casoEquipoCasoSet["+i+"].casoEquipoCasoPK.miembro="+$(formularioEquipoCaso).find("select[name=txtTipoDeMiembro]").val();
					data_caso +="&casoEquipoCasoSet["+i+"].equipoCaso.identificacion="+$(formularioEquipoCaso).find("input[name=txtIdentificacionMiembro]").val();
					if($(formularioEquipoCaso).find("select[name=txtParentescoMiembro]").val()!=""){
						data_caso +="&casoEquipoCasoSet["+i+"].parentesco.codigo="+$(formularioEquipoCaso).find("select[name=txtParentescoMiembro]").val();
						
					}
					
					data_caso +="&casoEquipoCasoSet["+i+"].activo="+"S";
					if ($(formularioEquipoCaso).find("input[name=esContacto]:checked").length>0){
						data_caso +="&casoEquipoCasoSet["+i+"].contacto="+"S";
					}else{
						data_caso +="&casoEquipoCasoSet["+i+"].contacto="+"N";
					}
				}
				
				 var j=0;
					$(formularioEquipoCaso).find("input[name^='txtTelefonoMiembro']").each(function(){
						if(!EstaVacio($(this).val())){
					    data_caso +="&casoEquipoCasoSet["+i+"].equipoCaso.telefonoList["+j+"].numero="+$(this).val();
					    j++;}
					});
					j=0;
					$(formularioEquipoCaso).find("input[name^='txtCorreoMiembro']").each(function(){
						if(!EstaVacio($(this).val())){
					    data_caso +="&casoEquipoCasoSet["+i+"].equipoCaso.correoList["+j+"].correo="+$(this).val();
					    j++;}
					});
					j=0;
					$(formularioEquipoCaso).find("input[name=txtCelularMiembro]").each(function(){
						if(!EstaVacio($(this).val())){
					    data_caso +="&casoEquipoCasoSet["+i+"].equipoCaso.celularList["+j+"].numero="+$(this).val();
					    j++;}
					});
				
					
					var aux1=i+1;
					if(aux1==$("[name = formularioEquipoCaso]").length){
						i++;
						
							var aux=0;
							 $("#cmbMiembroAbogado option:disabled").each(function(ind1,dato1){
								 aux=i+ind1;
								 data_caso +="&casoEquipoCasoSet["+aux+"].casoEquipoCasoPK.identificacion=" + $(dato1).val();
								 data_caso +="&casoEquipoCasoSet["+aux+"].equipoCaso.identificacion="+$(dato1).val();
								 data_caso +="&casoEquipoCasoSet["+aux+"].equipoCaso.nombre=" + $(dato1).text();
								 data_caso +="&casoEquipoCasoSet["+aux+"].equipoCaso.correoList["+0+"].correo="+$("label[name=correoAbogado]").eq(ind1).text();
								 data_caso +="&casoEquipoCasoSet["+aux+"].equipoCaso.telefonoList["+0+"].numero="+$("label[name=telefonoAbogado]").eq(ind1).text();
								 data_caso +="&casoEquipoCasoSet["+aux+"].direccion="+$("label[name=direccionAbogado]").eq(ind1).text();
								 data_caso +="&casoEquipoCasoSet["+aux+"].contacto="+"S";
								 data_caso +="&casoEquipoCasoSet["+aux+"].personajuridica="+"N";
								 data_caso +="&casoEquipoCasoSet["+aux+"].casoEquipoCasoPK.miembro="+5;
								 data_caso +="&casoEquipoCasoSet["+aux+"].activo="+"S";
								  
							});
									
					
					}
					
			/// Bloque para ingresar informacionn del prestamo

			}			
			if($("div[name=prestamos]").length>1){
				$("div[name=prestamos]:gt(0)").each(function(ind1,dato1){
					var guardarPrestamo=false;
					if(!EstaVacio($(dato1).find("input[name=txtnombreDeudor]").val())){					
						data_caso+="&listaPrestamos["+ ind1 +"].nombreDeudor="+$(dato1).find("input[name=txtnombreDeudor]").val();
						guardarPrestamo=true;
					}
					if(!EstaVacio($(dato1).find("input[name=txtIdentificacionDeudor]").val())){						
						data_caso+="&listaPrestamos["+ ind1 +"].identificacion="+$(dato1).find("input[name=txtIdentificacionDeudor]").val();
						guardarPrestamo=true;
					}
					if(!EstaVacio($(dato1).find("textarea[name=txtDescripcionPrestamo]").val())){						
						data_caso+="&listaPrestamos["+ ind1 +"].descripcionPrestamo="+$(dato1).find("textarea[name=txtDescripcionPrestamo]").val();
						guardarPrestamo=true;
					}
					if(!EstaVacio($(dato1).find("input[name=txtFechaPrestamo]").val())){
						data_caso+="&listaPrestamos["+ ind1 +"].fechaPrestamo="+new Date($(dato1).find("input[name=txtFechaPrestamo]").val());
						guardarPrestamo=true;
					}
					if(!EstaVacio($(dato1).find("input[name=txtValorPrestamo]").val())){
						data_caso+="&listaPrestamos["+ ind1 +"].monto="+$(dato1).find("input[name=txtValorPrestamo]").val();
						guardarPrestamo=true;
					}
					if(!EstaVacio($(dato1).find("input[name=txtPorcentajeInteresPrestamo]").val())){
						data_caso+="&listaPrestamos["+ ind1 +"].porcentajeInteres="+$(dato1).find("input[name=txtPorcentajeInteresPrestamo]").val();
						guardarPrestamo=true;
					}
					if(!EstaVacio($(dato1).find("input[name=txtIntereses]").val())){
						data_caso+="&listaPrestamos["+ ind1 +"].intereses="+$(dato1).find("input[name=txtIntereses]").val();
						guardarPrestamo=true;
					}
					if(!EstaVacio($(dato1).find("input[name=txtSaldoPrestamo]").val())){
						data_caso+="&listaPrestamos["+ ind1 +"].saldo="+$(dato1).find("input[name=txtSaldoPrestamo]").val();
						guardarPrestamo=true;
					}
					if(!EstaVacio($(dato1).find("select[name=txtEntidadFinanciera]").val())){
						data_caso+="&listaPrestamos["+ ind1 +"].entidadFinaciera.codigoEntidadfinaciera="+$(dato1).find("select[name=txtEntidadFinanciera]").val();
						guardarPrestamo=true;
					}
					if(!EstaVacio($(dato1).find("input[name=txtNumeroDeCuenta]").val())){
						data_caso+="&listaPrestamos["+ ind1 +"].numeroCuenta="+$(dato1).find("input[name=txtNumeroDeCuenta]").val();
						guardarPrestamo=true;
					}
					if(!EstaVacio($(dato1).find("select[name=txtTipoDeCuenta]").val())){
						data_caso+="&listaPrestamos["+ ind1 +"].tipocuenta="+$(dato1).find("select[name=txtTipoDeCuenta]").val();
						guardarPrestamo=true;
						
					}
					if(!EstaVacio($(dato1).find("input[name=txtTituloValor]").val())){
						data_caso+="&listaPrestamos["+ ind1 +"].titulo="+$(dato1).find("input[name=txtTituloValor]").val();
						guardarPrestamo=true;
						
					}
					if(guardarPrestamo){
						
						data_caso+="&listaPrestamos["+ ind1 +"].activo="+"S";
						data_caso+="&listaPrestamos["+ ind1 +"].cancelado="+"N";
						data_caso+="&listaPrestamos["+ ind1 +"].usuarioCreacion="+$("#idusercreacion").val();
						data_caso+="&listaPrestamos["+ ind1 +"].usuarioUltimaModificacion="+$("#idusercreacion").val();
					}
					
					//data_caso+=$(dato1).find("input[name=txtTituloValor]").val();
					
				});
			
			}
//			//Bloque para ingresar las actividades y tareas del caso
//	
//			for (var ind=0;ind<countActividades;ind++){
//				var cantTareas=actividadesArray[ind].cantidadTareas;
//				var tareasActividadesArray=actividadesArray[ind].tareas;
//				$("#actividadVencimiento"+actividadesArray[ind].fila).val();
//				
//				data_caso +="&listaActividadesCaso["+ind+"].nombreActividad="+actividadesArray[ind].nombreActividad;
//				data_caso +="&listaActividadesCaso["+ind+"].fechaLimite="+new Date($("#actividadVencimiento"+actividadesArray[ind].fila).val());
//				data_caso +="&listaActividadesCaso["+ind+"].finalizada="+"N";
//				data_caso +="&listaActividadesCaso["+ind+"].usuarioCreacion="+$("#idusercreacion").val();
//				data_caso +="&listaActividadesCaso["+ind+"].usuarioUltimaModificacion="+$("#idusercreacion").val();
//				
//				
//				
//				for(var ind1 = 0;  ind1 < cantTareas; ind1++){
//					
//					data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].tarea="+$("#nombreTarea"+tareasActividadesArray[ ind1].fila).val();
//					data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].detalle="+$("#detalleTarea"+tareasActividadesArray[ ind1].fila).val();
//					data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].fechaLimite="+new Date($("#vencimiento"+tareasActividadesArray[ ind1].fila).val());
//					data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].finalizada="+"N";
//					data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].usuarioCreacion="+$("#idusercreacion").val();
//					data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].usuarioUltimaModificacion="+$("#idusercreacion").val();
//					//data_caso +="&tareaParticularCasoSet["+ind+"].casoEquipoCaso.casoEquipoCasoPK.codigo="+;
//					//data_caso +="&tareaParticularCasoSet["+ind+"].casoEquipoCaso.casoEquipoCasoPK.codigoEquipoCaso="+;
//					data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].casoEquipoCaso.casoEquipoCasoPK.miembro="+5;
//					data_caso += "&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].casoEquipoCaso.casoEquipoCasoPK.codigoEquipoCaso="+$("#responsable"+tareasActividadesArray[ ind1].fila).val();
//				
//					
//					
//					
//					
//					
//					
//				}
//			}
//			
//			
//			
//			
//			// termiano bloque de actividades y tareas
			
	$.ajax({
		type : "POST",
		url : contexto + "/caso/guardar",
		//data : $("#idFormulario").serialize(),
		data : data_caso ,
		dataType : "json",
		success : function(response) {

			//alert(response.STATUS);
			guardarActividades(response);
		}
	});
	
}

function validarFormulario() {
	ocultarMensajesError();
	var isError=false;
	limpiarMensajeError();
	limpiarErrores();
	var erroresNuevoCaso = [];
	var erroresAbogados = [];
	var erroresDemandados = [];
	var erroresVictimasDemandantes = [];
	var erroresActividades = [];
	var erroresLugarProceso = [];
	var erroresBienes = [];
	var erroresRadicados = [];
	var erroresPrestamo = [];
	
	
	/**
	 *   Formulario Nuevo Caso
	 * */
	
	// valida el estado del caso
	if(EstaVacio($("#txtEstadoCaso").val())){
		$("#txtEstadoCaso").addClass("campoTextoError");
		isError=true;
		erroresNuevoCaso.push("El campo estado del caso es obligatorio.");
	}
	//valida el  tipo del caso
	if(EstaVacio($("#txtTipoCaso").val())){
		$("#txtTipoCaso").addClass("campoTextoError");
		isError=true;
		erroresNuevoCaso.push("El campo tipo del caso es obligatorio.");
	}
	// valida el nombre del caso
	if(EstaVacio($("#txtNombreCaso").val())){
		$("#txtNombreCaso").addClass("campoTextoError");
		isError=true;
		erroresNuevoCaso.push("El campo nombre del caso es obligatorio.");
	}
	//valida la fechas de los hechos
	if(EstaVacio($("#txtFechaDeLosHechos").val())){
		$("#txtFechaDeLosHechos").addClass("campoTextoError");
		isError=true;
		erroresNuevoCaso.push("El campo fecha de los hechos es obligatorio.");
	}
	// valida el lugar de los hechos	
	 // Pais
	if(EstaVacio($("#txtPaisDeLosHechos").val())){
		$("#txtPaisDeLosHechos").addClass("campoTextoError");
		isError=true;
		erroresNuevoCaso.push("El campo pa\u00EDs de los hechos es obligatorio.");
	}
	// Departamento
	if(EstaVacio($("#txtDepartamentoDeLosHechos").val())){
		$("#txtDepartamentoDeLosHechos").addClass("campoTextoError");
		isError=true;
		erroresNuevoCaso.push("El campo departamento de los hechos es obligatorio.");
	}
	// Municipio
	if(EstaVacio($("#txtMunicipioDeLosHechos").val())){
		$("#txtMunicipioDeLosHechos").addClass("campoTextoError");
		isError=true;
		erroresNuevoCaso.push("El campo municipio de los hechos es obligatorio.");
	}
	
	/**
	 *   Formulario abogados
	 * */
	
	// valida que se ingrese abogados al caso
	if($("#cmbMiembroAbogado option:disabled").length==0){
		$("#cmbMiembroAbogado").addClass("campoTextoError");
		isError=true;
		erroresAbogados.push("Es obligatorio agregar al menos un abogado.");
	}

	/**
	 *   Formulario demandados
	 * */
	// Valida que se ingrese un demandante
	if ($("select[name=txtTipoPersona]").length<1) {
		
		$("#messageErrorDemandante").html("Se debe ingresar un demandante");
		$("#messageErrorDemandante").show();
		isError=true;
		
	}
	//valida el tipo de persona	
	$("select[name=txtTipoPersona]").each(function(){
		if (EstaVacio($(this).val())) {
			$(this).addClass("campoTextoError");
			isError=true;
			erroresDemandados.push("El campo tipo de persona es obligatorio.");
		}
	});
	// valida el  nombre del miembro del equipo
	$("input[name=txtNombresMiembro]").not("#formularioNombreMiembroNatural input[name=txtNombresMiembro]").each(function(){
		if(EstaVacio($(this).val())){
			$(this).addClass("campoTextoError");
			isError=true;
			erroresDemandados.push("El campo nombres es obligatorio.")
		}
	});
	
	/**
	 *   Formulario Victimas/Demandantes
	 * */
	//valida que se tenga un tipo de miembro victima
	var mensajeFaltaVictima=false;
	var mensajeFaltaDemandante=false;
	$("select[name=txtTipoDeMiembro]").each(function(){
		if($(this).val()==1){
			mensajeFaltaVictima=true;
			
		}
		if($(this).val()==2){
			
			mensajeFaltaDemandante=true;
		}
	});
	
	//Valida los tipos de miembros	
	$("select[name=txtTipoDeMiembro]").each(function(){
		if(EstaVacio($(this).val())){
			$(this).addClass("campoTextoError");
			isError=true;
			erroresVictimasDemandantes.push("El campo tipo de miembro es obligatorio.");
		}
	});
	$("#formularioNombreMiembroNatural input[name=txtNombresMiembro]").each(function(){
		if(EstaVacio($(this).val())){
			$(this).addClass("campoTextoError");
			isError=true;
			erroresVictimasDemandantes.push("El campo nombres es obligatorio.")
		}
	});
	// Valida el apellido del miembro del equipo
	$("input[name=txtApellidosMiembro]").each(function(){
		if(EstaVacio($(this).val())){
			$(this).addClass("campoTextoError");
			isError=true;
			erroresVictimasDemandantes.push("El campo apellidos es obligatorio.");	
		}
	});
	// valida los telefonos
	$("input[name=txtTelefonoMiembro]").each(function(){
		if(EstaVacio($(this).val())){
			$(this).addClass("campoTextoError");
			isError=true;
			erroresVictimasDemandantes.push("El campo Tel\u00E9fono es obligatorio.");
		}
	});
	//valida los correos 
	$("input[name=txtCorreoMiembro]").each(function(){
		if(EstaVacio($(this).val())){
			$(this).addClass("campoTextoError");
			isError=true;
			erroresVictimasDemandantes.push("El campo correo es obligatorio.");
		}
	});
	
	
	
	if (mensajeFaltaVictima && mensajeFaltaDemandante) {
		
		$("#messageErrorVictimaDemandante").hide();
	} else {
		messageErrorVictimaDemandante
		$("#messageErrorVictimaDemandante").html("Se debe ingresar una victima y un demandante");
		  $("#messageErrorVictimaDemandante").show(); 
		isError=true;
	}
	
	/**
	 *   Formulario Actividades
	 * */
	
	// valida que se ingrese los campos nombre tarea
	for (var i=0;i<countActividades;i++) {
		var cantTareas=actividadesArray[i].cantidadTareas;
		var tareasActividadesArray=actividadesArray[i].tareas;
		//alert ($("#actividadVencimiento"+actividadesArray[i].fila).val());
		for (var j = 0; j < cantTareas; j++) {
			if(EstaVacio($("#nombreTarea"+tareasActividadesArray[j].fila).val())){
				$("#nombreTarea"+tareasActividadesArray[j].fila).addClass("campoTextoError");
				isError=true;
			}
			
		}
	}
	// valida que se ingrese los campos responsables
	
	for (var i=0;i<countActividades;i++){
		var cantTareas=actividadesArray[i].cantidadTareas;
		var tareasActividadesArray=actividadesArray[i].tareas;
		//alert ($("#actividadVencimiento"+actividadesArray[i].fila).val());
		for(var j=0;j<cantTareas;j++){
			if(EstaVacio($("#responsable"+tareasActividadesArray[j].fila).val())){
				$("#responsable"+tareasActividadesArray[j].fila).addClass("campoTextoError");
				isError=true;
			}
			
		}
	}
	
	// valida que se ingrese las fechas de vencimiento tarea	
	for (var i=0;i<countActividades;i++){
		var cantTareas=actividadesArray[i].cantidadTareas;
		var tareasActividadesArray=actividadesArray[i].tareas;
		//alert ($("#actividadVencimiento"+actividadesArray[i].fila).val());
		for(var j=0;j<cantTareas;j++){
			if(EstaVacio($("#vencimiento"+tareasActividadesArray[j].fila).val())){
				$("#vencimiento"+tareasActividadesArray[j].fila).addClass("campoTextoError");
				isError=true;
			}
		}
	}
	//valida que se ingrese una fecha de vencimiento actividad
	for (var i=0;i<countActividades;i++){
		if(EstaVacio($("#actividadVencimiento"+actividadesArray[i].fila).val())){
			$("#actividadVencimiento"+actividadesArray[i].fila).addClass("campoTextoError");
				isError=true;
			}
	}
	//	valida que se ingrese los campos detalle
	for (var i=0;i<countActividades;i++){
		var cantTareas=actividadesArray[i].cantidadTareas;
		var tareasActividadesArray=actividadesArray[i].tareas;
		//alert ($("#actividadVencimiento"+actividadesArray[i].fila).val());
		for(var j=0;j<cantTareas;j++){
			if(EstaVacio($("#detalleTarea"+tareasActividadesArray[j].fila).val())){
				$("#detalleTarea"+tareasActividadesArray[j].fila).addClass("campoTextoError");
				isError=true;
			}
			
		}
	}
	
	/**
	 *   Formulario radicados
	 * */
	
	// valida numero de radicados
	$("input[name=txtNumeroRadicado]:gt(0)").each(function() {
		if(EstaVacio($(this).val())){
			$(this).addClass("campoTextoError");
			isError=true;
			erroresRadicados.push("El campo n\u00FAmero radicado es obligatorio.");
		}
	});
	// valida la instancia del radicado	
	$("select[name=txtInstanciaRadicado]:gt(0)").each(function() {
		if(EstaVacio($(this).val())){
			$(this).addClass("campoTextoError");
			isError=true;
			erroresRadicados.push("El campo instancia es obligatorio.");
		}
	});
	

	/**
	 *   Formulario lugar proceso
	 * */
	
	if(!EstaVacio($("#txtDireccionDespacho").val())){
		if (EstaVacio($("#txtPaisProceso").val())) {
			$("#txtPaisProceso").addClass("campoTextoError");
			isError=true;
			erroresLugarProceso.push("El campo pa\u00EDs es obligatorio.");
		} else {
			$("#txtPaisProceso").removeClass("campoTextoError");
		}
		if (EstaVacio($("#txtDeparmentoProceso").val())) {
			$("#txtDeparmentoProceso").addClass("campoTextoError");
			isError=true;
			erroresLugarProceso.push("El campo departamento es obligatorio.");
		} else {
			$("#txtDeparmentoProceso").removeClass("campoTextoError");
		}
		if (EstaVacio($("#txtMunicipioProceso").val())) {
			$("#txtMunicipioProceso").addClass("campoTextoError");
			isError=true;
			erroresLugarProceso.push("El campo municipio es obligatorio.");
		} else {
			$("#txtMunicipioProceso").removeClass("campoTextoError");
		}
	} else {
		$("#txtPaisProceso").removeClass("campoTextoError");
		$("#txtDeparmentoProceso").removeClass("campoTextoError");
		$("#txtMunicipioProceso").removeClass("campoTextoError");
	}
	
	
	if (isError) {
		var objectErrores = new Object();
		objectErrores.erroresNuevoCaso = erroresNuevoCaso;
		objectErrores.erroresAbogados = erroresAbogados;
		objectErrores.erroresDemandados = erroresDemandados;
		objectErrores.erroresVictimasDemandantes = erroresVictimasDemandantes;
		objectErrores.erroresActividades = erroresActividades;
		objectErrores.erroresLugarProceso = erroresLugarProceso;
		objectErrores.erroresBienes = erroresBienes;
		objectErrores.erroresRadicados = erroresRadicados;
		objectErrores.erroresPrestamo = erroresPrestamo;
		mostrarMensajesError(objectErrores);
		return false;
	}else{
		return true;
	}
}

function limpiarErrores(){
	$("#txtEstadoCaso").removeClass("campoTextoError");//estado del caso
	$("#txtEstadoCaso").addClass("form-control");
	$("#txtTipoCaso").removeClass("campoTextoError");//tipo del caso
	$("#txtTipoCaso").addClass("form-control");
	$("#txtNombreCaso").removeClass("campoTextoError");//Nombre del caso
	$("#txtNombreCaso").addClass("form-control");
	$("#txtFechaDeLosHechos").removeClass("campoTextoError");//fechas de los hechos
	$("#txtFechaDeLosHechos").addClass("form-control");
	$("#txtPaisDeLosHechos").removeClass("campoTextoError");//Pa�s del los hechos
	$("#txtPaisDeLosHechos").addClass("form-control");
	$("#txtDepartamentoDeLosHechos").removeClass("campoTextoError");//Departamento de los hechos
	$("#txtDepartamentoDeLosHechos").addClass("form-control");
	$("#txtMunicipioDeLosHechos").removeClass("campoTextoError");//Municipio de los hechos
	$("#txtMunicipioDeLosHechos").addClass("form-control");
	$("#cmbMiembroAbogado").removeClass("campoTextoError");//Abogados
	$("#cmbMiembroAbogado").addClass("form-control");
	$("#txtMunicipioProceso").removeClass("campoTextoError");//municipio delproceso
	$("#messageErrorDemandante").hide();// demandante
	
	// tipo de persona 
	$("select[name=txtTipoPersona]").each(function(){
	
			$(this).removeClass("campoTextoError");
			$(this).addClass("form-control");
	
	});
	// nombre del miembro
	$("input[name=txtNombresMiembro]").each(function(){
	
			$(this).removeClass("campoTextoError");
			$(this).addClass("form-control");
	
	});
	// Apellido
	$("input[name=txtApellidosMiembro]").each(function(){
	
			$(this).removeClass("campoTextoError");
			$(this).addClass("form-control");
	
	});
	//tipos de miembros
	$("select[name=txtTipoDeMiembro]").each(function(){
	
			$(this).removeClass("campoTextoError");
			$(this).addClass("form-control");
	
	});
	//telefonos
	$("input[name=txtTelefonoMiembro]").each(function(){
	
			$(this).removeClass("campoTextoError");
			$(this).addClass("form-control");
	
	});
	//Correo
	$("input[name=txtCorreoMiembro]").each(function(){
	
			$(this).removeClass("campoTextoError");
			$(this).addClass("form-control");
	
	});
	//numero radicado
	$("input[name=txtNumeroRadicado]:gt(0)").each(function(){
	
			$(this).removeClass("campoTextoError");
			$(this).addClass("form-control");
	
	});
	// instancia
	$("select[name=txtInstanciaRadicado]:gt(0)").each(function(){
		
			$(this).removeClass("campoTextoError");
			$(this).addClass("form-control");
		
	});


/// Validacion de tareas de la actividad
	
	//  Nombre tarea
	for (var i=0;i<countActividades;i++){
		var cantTareas=actividadesArray[i].cantidadTareas;
		var tareasActividadesArray=actividadesArray[i].tareas;
		//alert ($("#actividadVencimiento"+actividadesArray[i].fila).val());
		for(var j=0;j<cantTareas;j++){
			
				$("#nombreTarea"+tareasActividadesArray[j].fila).removeClass("campoTextoError");
				$("#nombreTarea"+tareasActividadesArray[j].fila).addClass("form-control");
			
			
		}
	}
	//	Detalle
	for (var i=0;i<countActividades;i++){
		var cantTareas=actividadesArray[i].cantidadTareas;
		var tareasActividadesArray=actividadesArray[i].tareas;
		//alert ($("#actividadVencimiento"+actividadesArray[i].fila).val());
		for(var j=0;j<cantTareas;j++){
			
				$("#detalleTarea"+tareasActividadesArray[j].fila).removeClass("campoTextoError");
				$("#detalleTarea"+tareasActividadesArray[j].fila).addClass("form-control");
			
			
		}
	}
	// Responsables
	
	for (var i=0;i<countActividades;i++){
		var cantTareas=actividadesArray[i].cantidadTareas;
		var tareasActividadesArray=actividadesArray[i].tareas;
		//alert ($("#actividadVencimiento"+actividadesArray[i].fila).val());
		for(var j=0;j<cantTareas;j++){
			
				$("#responsable"+tareasActividadesArray[j].fila).removeClass("campoTextoError");
				$("#responsable"+tareasActividadesArray[j].fila).addClass("form-control");
			
			
		}
	}
	
// Fechas de vencimiento tarea	
	for (var i=0;i<countActividades;i++){
		var cantTareas=actividadesArray[i].cantidadTareas;
		var tareasActividadesArray=actividadesArray[i].tareas;
		//alert ($("#actividadVencimiento"+actividadesArray[i].fila).val());
		for(var j=0;j<cantTareas;j++){
			
				$("#vencimiento"+tareasActividadesArray[j].fila).removeClass("campoTextoError");
				$("#vencimiento"+tareasActividadesArray[j].fila).addClass("form-control");
			
		}
	}
//Fecha de vencimiento actividad
	
	for (var i=0;i<countActividades;i++){
		
			$("#actividadVencimiento"+actividadesArray[i].fila).removeClass("campoTextoError");
			$("#actividadVencimiento"+actividadesArray[i].fila).addClass("form-control");
			
	}
	
	
	
	
	
}


//metodo para validar las fechas de las tareas
function validarfechasTareas(campoFechaTarea){
	
	//var fechaActividad=new Date($(dato1).find("input[name=txtFechaDeVencimientoActividad]").val());
	var campoFechaActividad=$(campoFechaTarea).closest("div[name=actividadParticular]").find("input[name^='actividadVencimiento']");
	var fechaActividad=new Date($(campoFechaActividad).val());
	var fechaTarea=new Date($(campoFechaTarea).val());
	if(fechaActividad<fechaTarea)
	{
		$(campoFechaTarea).val("");
		//$("#messageExitoso").show(); 
		$(campoFechaTarea).closest("td").find("div[name=messageError]").html("Fecha mayor a la de la actividad.");
		$(campoFechaTarea).closest("td").find("div[name=messageError]").show();
	}
	else{
		$(campoFechaTarea).closest("td").find("div[name=messageError]").hide();
	
	}
}

//Metodo para validar las fechas de las tareas cuando se cambia la fecha de la actividad
function validarFechasDesdeActividad(campoFechaActividad){
	
	var fechaActividad=new Date($(campoFechaActividad).val());
	$(campoFechaActividad).closest("div[name=actividadParticular]").find("input[name^='vencimiento']").each(function(ind,dato){
		
		var fechaTarea=new Date($(dato).val());
		if(fechaActividad<fechaTarea){
			$(dato).val("");
			//$("#messageExitoso").show(); 
//			$(dato).closest("div[name=campoTarea]").find("div[name=messageError]").html("Fecha mayor a la de la actividad.");
//			$(dato).closest("div[name=campoTarea]").find("div[name=messageError]").show();
			
			$(dato).closest("td").find("div[name=messageError]").html("Fecha mayor a la de la actividad.");
			$(dato).closest("td").find("div[name=messageError]").show();
		}
		
	});
	
	
}

function guardarActividades(CodigosEquipo){
	
	//Bloque para ingresar las actividades y tareas del caso
	if(countActividades>0){
	var data_caso = "_csrf=" + $("#_csrf").val();
	for (var ind=0;ind<countActividades;ind++){
		var cantTareas=actividadesArray[ind].cantidadTareas;
		var tareasActividadesArray=actividadesArray[ind].tareas;
		$("#actividadVencimiento"+actividadesArray[ind].fila).val();
		
		data_caso +="&listaActividadesCaso["+ind+"].nombreActividad="+actividadesArray[ind].nombreActividad;
		data_caso +="&listaActividadesCaso["+ind+"].fechaLimite="+new Date($("#actividadVencimiento"+actividadesArray[ind].fila).val());
		data_caso +="&listaActividadesCaso["+ind+"].finalizada="+"N";
		data_caso +="&listaActividadesCaso["+ind+"].usuarioCreacion="+$("#idusercreacion").val();
		data_caso +="&listaActividadesCaso["+ind+"].usuarioUltimaModificacion="+$("#idusercreacion").val();
		
		
		
		for(var ind1 = 0;  ind1 < cantTareas; ind1++){
			
			data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].tarea="+$("#nombreTarea"+tareasActividadesArray[ ind1].fila).val();
			data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].detalle="+$("#detalleTarea"+tareasActividadesArray[ ind1].fila).val();
			data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].fechaLimite="+new Date($("#vencimiento"+tareasActividadesArray[ ind1].fila).val());
			data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].finalizada="+"N";
			data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].usuarioCreacion="+$("#idusercreacion").val();
			data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].usuarioUltimaModificacion="+$("#idusercreacion").val();
			//data_caso +="&tareaParticularCasoSet["+ind+"].casoEquipoCaso.casoEquipoCasoPK.codigo="+;
			//data_caso +="&tareaParticularCasoSet["+ind+"].casoEquipoCaso.casoEquipoCasoPK.codigoEquipoCaso="+;
			data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].casoEquipoCaso.casoEquipoCasoPK.miembro="+5;
			//data_caso += "&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].casoEquipoCaso.casoEquipoCasoPK.codigoEquipoCaso="+$("#responsable"+tareasActividadesArray[ ind1].fila).val();
		
			
			var identificacion=$("#responsable"+tareasActividadesArray[ ind1].fila).val();
			//var codigoEquipo=CodigosEquipo.equipoCaso.identficacion;
			var codigoCaso="";
			$.each(CodigosEquipo.equipoCaso, function(index, optionData) {	  
				 
				if(optionData.identificacion==identificacion){
					data_caso += "&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].casoEquipoCaso.casoEquipoCasoPK.codigoEquipoCaso="+optionData.codigoEquipoCaso;
					}
				codigoCaso =optionData.codigoCaso;
				//option.text = optionData.nombre;
				  
				  
			  });
			data_caso +="&listaActividadesCaso["+ind+"].tareaParticularCasoSet["+ind1+"].casoEquipoCaso.casoEquipoCasoPK.codigo="+codigoCaso;
			
			
			
			
		}
	}
	

	$.ajax({
		type : "POST",
		url : contexto + "/caso/guardarActividades",
		//data : $("#idFormulario").serialize(),
		data : data_caso ,
		dataType : "json",
		success : function(response) {
			
			if(response.STATUS =="SUCCESS"){
				$("#modal-nuevoCaso").modal("hide");
				$("#messageExitoso").html("Se guard\u00f3 el caso exitosamente.");
				$("#messageExitoso").show(); 
				setTimeout("limpiarMensajeExito();",10000);
				//limpiarFormularioNuevoCaso();
				mostrarTabla();
				
			}else{
				$("#messageError").html("No se fue posible guardar el caso.");
				  $("#messageError").show(); 
				  setTimeout("limpiarMensajeError();",10000);
				
			}
			
			
			
			//alert(response.STATUS);
			}
	});
	}else{
		//limpiarFormularioNuevoCaso();
		$("#messageExitoso").html("Se guard� el caso exitosamente.");
		$("#messageExitoso").show(); 
		setTimeout("limpiarMensajeExito();",10000);
	}
	
}



// validacionn de los campos nuevo caso
function rulesForm() {	

	$clientForm = $("#detalleDelCaso").validate({
		

		
		rules : {
			//validacion del formulario Detalle del caso
			
			txtEstadoCaso : {
				required : true
			},
			txtTipoCaso : {
				required : true
			},
			txtNombreCaso : {
				required : true
			},
			txtFechaDeLosHechos : {
				required : true
			},
			txtPaisDeLosHechos : {
				
				required : true
			},
			txtDepartamentoDeLosHechos : {
				required : true
			},
			txtMunicipioDeLosHechos : {
				required : true
			},
			txtDireccionDeLosHechos : {
				required : true
			},
			txtTipoDeMiembro : {
				required : true
			},
			txtNombresMiembro : {
				required : true
			},
			txApellidosMiembro : {
				required : true
			},
			txTelefonoMiembro : {
				required : true
			},
			txCorreoMiembro : {
				required : true,
				email:true
			},
			txTelefonoMiembro : {
				required : true
			}
			
		},

		// Messages for form validation
		messages : {
			//validacion del formulario Detalle del caso
			txtEstadoCaso : {
				required :"Ingrese el estado del caso" 
			},
			txtTipoCaso : {
				required :"Ingrese el tipo de caso"
			},
			txtNombreCaso : {
				required : " Ingrese el nombre del caso"
			},
			txtFechaDeLosHechos : {
				required :" Ingrese una fecha"
			},
			txtPaisDeLosHechos : {
				required :"Ingrese un pais"
			},
			txtDepartamentoDeLosHechos : {
				required :"Ingrese un departamento"
			},
			txtMunicipioDeLosHechos : {
				required :"Ingrese un municipio"
			},
			txtDireccionDeLosHechos : {
				required : "Ingrese una direccion"
			},
			//validadacion del bloque  equipo del caso
			txtTipoDeMiembro : {
				required :"Ingrese un tipo Miembro"
			},
			txtNombresMiembro : {
				required : "Ingrese un nombre  "
			},
			txApellidosMiembro : {
				required : "Ingrese un apellido"
			},
			txTelefonoMiembro : {
				required : "Ingrese un telefono"
			},
			txCorreoMiembro : {
				required : "Ingrese un correo"
			},
			txTelefonoMiembro : {
				required : "Ingrese un telefono"
			}
			
		},

		// Do not change code below
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());	
			
		}

	});

}
// metodo para validar primero los campos antes de guardar

function guardar() {

	if(validarFormulario()){
		doAjaxPostAdd();
		
		//limpiarFormularioNuevoCaso();
		
		mostrarTabla();
		
		
	}
}
function limpiarFormularioNuevoCaso()
{
//	$("#modal-nuevoCaso").find("input").each(function(ind1, input){
//		$(input).val("");
//		
//	});
//	$("#modal-nuevoCaso").find("select").each(function(ind1, select){
//		$(select).val("");
//		
//	});
	
	$("#modal-nuevoCaso").html(formularioNuevoCaso);
	formularioNuevoCaso=$("#modal")[0].cloneNode(true);
	
}
// Metodo para mostrar los abogados asignados al caso
function asignarAbogadosAlCaso(){


	var option = $("#cmbMiembroAbogado").val();
	var codigoAbogadoSeleccionado = "codigoAbogadoSeleccionado=" +  $("#cmbMiembroAbogado").val(); //abogadoSeleccionado.value;
	$("#cmbMiembroAbogado option:selected").attr("disabled","disabled");
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerAbogadosSeleccionados",
		  data: codigoAbogadoSeleccionado,
		  success: function (response) {

			  
			  	$.each(response.abogados, function(index, optionData)  {	  
				  
			  		var elementoAbogado="";
  				  		
			  		// bloque para mostrar la informacion de los abogados crean los elementos html
			  		//elementoAbogado+='<div class="row" name="abogados">';
			  		
			  		elementoAbogado+='<div class="col-sm-12 b-r" name="abogados">';
			  		elementoAbogado+='<div class="row" >'; // <!-- Inicio primera fila los nombres de los campos -->
			  		
			  		elementoAbogado+='<div class="col-sm-6 b-r" style="padding-bottom: 1%;" >';
			  		elementoAbogado+='<label">';
			  		elementoAbogado+="NÚMERO DE IDENTIFICACIÓN";
			  		elementoAbogado+='</label">';
			  		elementoAbogado+='</div>';
			  		
			  		elementoAbogado+='<div class="col-sm-6" style="padding-bottom: 1%;"  >';
			  		elementoAbogado+='<label">';
			  		elementoAbogado+="NOMBRE ABOGADO";
			  		elementoAbogado+='</label">';
			  		elementoAbogado+='</div>';
			  		
			  		elementoAbogado+='</div>';
			  		
			  		elementoAbogado+='<div class="row" >';

			  		elementoAbogado+='<div class="col-sm-6 b-r" style="padding-bottom: 1%;" >';
			  		elementoAbogado+='<label name="identificacion">';
			  		elementoAbogado+=optionData.codigo;
			  		elementoAbogado+='</label">';
			  		elementoAbogado+='</div>';
			  		
					elementoAbogado+='<div class="col-sm-6" style="padding-bottom: 1%;"  >';
			  		elementoAbogado+='<label name="nombreAbogado">';
			  		elementoAbogado+=optionData.nombre;
			  		elementoAbogado+='</label">';
			  		elementoAbogado+='</div>';
			  		
			  		elementoAbogado+='</div>';
			  		
			  		elementoAbogado+='<div class="row" >';
			  		
			  		elementoAbogado+='<div class="col-sm-6 b-r" style="padding-bottom: 1%;"  >';
			  		elementoAbogado+='<label">';
			  		elementoAbogado+="NÚMERO DE TARJETA PROFESIONAL";
			  		elementoAbogado+='</label">';
			  		elementoAbogado+='</div>';
			  		
			  		elementoAbogado+='<div class="col-sm-6" style="padding-bottom: 1%;"  >';
			  		elementoAbogado+='<label">';
			  		elementoAbogado+="TELEFONO";
			  		elementoAbogado+='</label">';
			  		elementoAbogado+='</div>';
			  
			  		
			  	
			  		
			  		elementoAbogado+='</div>'; //<!-- Fin segunda fila los valores de los campos -->
			  	
			  		elementoAbogado+='<div class="row">'; //<!-- Inicio tercera fila los nombres de los campos -->
			  	
			  		elementoAbogado+='<div class="col-sm-6 b-r"  style="padding-bottom: 1%;" >';
			  		elementoAbogado+='<label name="tarjetaProfesional">';
			  		elementoAbogado+=optionData.tarjetaProfesional;
			  		elementoAbogado+='</label">';
			  		elementoAbogado+='</div>';
			  		
			  		
					elementoAbogado+='<div class="col-sm-6"  style="padding-bottom: 1%;" >';
			  		elementoAbogado+='<label name="telefonoAbogado">';
			  		elementoAbogado+=optionData.telefono; 
			  		elementoAbogado+='</label>';
			  		elementoAbogado+='</div>';
			  		
			  	
			  		
			  	
			  		
			  		elementoAbogado+='</div>'; 
			  		
			  		elementoAbogado+='<div class="row">';
			  		
			  		
			  		elementoAbogado+='<div class="col-sm-6 b-r" style="padding-bottom: 1%;"  >';
			  		elementoAbogado+='<label">';
			  		elementoAbogado+="EMAIL";
			  		elementoAbogado+='</label">';
			  		elementoAbogado+='</div>';
			  		
			  		elementoAbogado+='<div class="col-sm-6" style="padding-bottom: 1%;" >';
			  		elementoAbogado+='<label">';
			  		elementoAbogado+="DIRECCION";
			  		elementoAbogado+='</label">';
			  		elementoAbogado+='</div>';
			  	
			  	
			  		
			  		
			  		elementoAbogado+='</div>';
			  		
			  		elementoAbogado+='<div class="row">';
			  		
			  		elementoAbogado+='<div class="col-sm-6 b-r" style="padding-bottom: 1%;" >';
			  		elementoAbogado+='<label name="correoAbogado">';
			  		elementoAbogado+=optionData.correo; 
			  		elementoAbogado+='</label>';
			  		elementoAbogado+='</div>';
			  		
			  		elementoAbogado+='<div class="col-sm-6" style="padding-bottom: 1%;" >';
			  		elementoAbogado+='<label name="direccionAbogado">';
			  		elementoAbogado+=optionData.direccion; 
			  		elementoAbogado+='</label>';
			  		elementoAbogado+='</div>';
			  		
			  		elementoAbogado+='</div>'; //<!-- Fin cuarta fila los valores de los campos -->
			  		elementoAbogado+='<div class="row" style="text-align: right;padding-right: 4%;">';
			  		elementoAbogado+='<a href="#" name="ElimnarAbogado" onclick="borrarAbogado(this,'  + option +' )" class="btn btn-success btn-circle .btn-xs" style="background-color: red; border:0;" title="Eliminar Abogado">';
			  		elementoAbogado+='<i class="glyphicon glyphicon-minus" ></i> </a>';
			  		elementoAbogado+='</div>';
			  		elementoAbogado+= '<br><hr class="hr-line-solid"><br>';
			  		elementoAbogado+='</div>';
			  		$("#equipoAbogados").append(elementoAbogado);// se agrega los elementos al Div de equipo Abogados
			  });

		  }

	});
	cargarResponsableTareas1();
	$("#cmbMiembroAbogado").val("");
	//optionData.codigo
	//habilitarResponsablesDesdeAbogados();
	
}
//Metodo para borrar abogados del caso mientras se esta creando el caso
function borrarAbogado(boton,option) {
	 //$(boton.parentNode.parentNode).remove();
	 $(boton).closest("div[name=abogados]").remove();
	//$(boton).closest("div[name=equipoAbogados]").remove();
	 $("#cmbMiembroAbogado").val(option);
	 $("#cmbMiembroAbogado option:selected").removeAttr("disabled");
	 $("#cmbMiembroAbogado").val("");
	  //validarResponsablesTareas();
	 quitarResponsableTarea(option);
}

//Metodo para validar los responsables del caso se modifican los abogados mientras se crea el caso
function validarResponsablesTareas(){

	$("#cmbMiembroAbogado option:enabled:gt(0)").each(function(ind1,select1){
		
  		  
		  $("#actividades").find("select[name=cmbResponsableTarea]").each(function(ind1, select2){
			  
			  if ($(select1).val() == $(select2).val()) {
				  $(select2).find('option:selected').attr("disabled","disabled");
				  $(select2).val("");
			  }else{
				  
				  var valor = $(select1).val();
				  var valorAnterior = $(select2).val();
				  $(select2).val(valor);
				  $(select2).find('option:selected').attr("disabled","disabled");
				  $(select2).val(valorAnterior);
				  
			  }
				  
			  
		  });

	});
	
}

function limpiarMensajeError(){
	 $("#messageError").hide();
}

function limpiarMensajeExito(){
	 $("#messageExitoso").hide();
}

//Metodo para cargar actividades tipo caso
function cargarActividadesTipoCaso(selectTipoCaso){
	
	var codigoTipoCaso = "codigoTipoCaso=" +$(selectTipoCaso).find('option:selected').val();

	
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerActividadesTipoCaso",
		  data: codigoTipoCaso,
		  success: function (response) {
			  var html='';  
			  
			  borrarActividadesTipoCaso();
			  $.each(response.actividadesTipoCaso, function(index, optionData) {
				   
				    elementoActividad = new Object();
					elementoActividad.fila= filaActividad;
				    elementoActividad.codigoActividad=optionData.codigo;
				    elementoActividad.nombreActividad = optionData.nombre;
				    
				    
				    var tareasActividadesArray = new Array();
				    var countTareasActividades = 0;
					
					html+='<div class="col-sm-12" name="actividadParticular" style="padding-left: 3%; padding-right: 3%;">';
			
					html+='<div class="panel panel-default">';
					html+='	<div class="panel-heading">';
					
					
					html+='<div class="row">';
					
					html+='<div class="col-sm-10">';
					
					html+='		<h4 class="panel-title">';
					html+='			<a data-toggle="collapse" data-parent="#accordion"';
					html+='				href="#collapseActividad'+optionData.codigo+'">'+optionData.nombre+'</a>';
					html+='		</h4>';
					
					html+='</div>';
					
					html+='<div class="col-sm-2">';
					
					html+='		<div class="ibox-tools">';
					//////
					html+='		<a href="javascript:void(0);"';
					html+='			onclick="mostrarModalEliminarActividad('+filaActividad+',this)" class="btn btn-success btn-circle .btn-xs" title="Eliminar Actividad"';
					html+='			style="background-color:red;border:0;" name="btnActividad" alt="borrar actividad"> <i';
					html+='			class="glyphicon glyphicon-minus" id="btnActividad" name="btnActividad"></i>';
					html+='		</a>';
					/////
					html+='		<a href="javascript:void(0);"';
					html+='			onclick="adicionarTarea(\'tabla'+optionData.codigo+'\','+filaActividad+')" class="btn btn-success btn-circle .btn-xs" title="Adicionar Tarea"';
					html+='			style="background-color: #449D44;border:0;" name="btTareas" alt="Adicionar tarea"> <i';
					html+='			class="glyphicon glyphicon-plus" id="btnTareas" name="btnTareas"></i>';
					html+='		</a>';
					html+='		</div>';
					
					html+='	</div>';
					
					html+='</div>';
					
					html+='	</div>';
					html+='	<div id="collapseActividad'+optionData.codigo+'" class="panel-collapse collapse">';
					html+='		<div class="panel-body" id="panelActividad'+optionData.codigo+'">';
					
					html+='<div class="row">';
					html+='<div class="col-sm-3" style="padding-top: 1%;">';
					
					html+='		Fecha vencimiento: </div> <div class="col-sm-3" style="margin-bottom: 1%;"> <input type="date" id="actividadVencimiento'+filaActividad+'" name="actividadVencimiento'+filaActividad+'"'+metodoOnchageActividad+'></div> ';
				
					html+='<div class="col-sm-6">';
					html+='</div>';
					
					html+='			<table class="table table-bordered" id="tabla'+optionData.codigo+'">';
					html+='				<thead>';
					html+='				<tr>';
					html+='					<th>Tarea</th>';
					html+='					<th>Detalle</th>';
					html+='					<th>Responsable</th>';
					html+='					<th>Fecha Vencimiento</th>';
					html+='					<th>Acción</th>';
					html+='				</tr>';
					html+='				</thead>';
					html+='				<tbody>';
					$.each(optionData.tareasActividades, function(indexTarea, optionDataTarea) {
						
						elementoTareaActividad = new Object();
					    elementoTareaActividad.fila= filaTareaActividad;
					   
					    
					    
						
						html+='				<tr id="'+optionData.codigo+'Tarea">';
						html+='					<td>'+optionDataTarea.nombreTarea+'<input type="hidden" value="'+optionDataTarea.nombreTarea+'" id="nombreTarea'+filaTareaActividad+'" name="nombreTarea'+filaTareaActividad+'"></td>';
						html+='					<td>'+optionDataTarea.detalleTarea+'<input type="hidden" value="'+optionDataTarea.detalleTarea+'" id="detalleTarea'+filaTareaActividad+'" name="detalleTarea'+filaTareaActividad+'"></td>';
						html+='					<td><select class="form-control" id="responsable'+filaTareaActividad+'" name="responsable'+filaTareaActividad+'"></select></td>';
						html+='					<td>'+mensaje+'<input type="date" class="form-control" id="vencimiento'+filaTareaActividad+'" name="vencimiento'+filaTareaActividad+'"'+metodoOnchage+'></td>';
					//	html+='					<td><a href="javascript:deleteTarea('+filaActividad+','+filaTareaActividad+',\''+optionData.codigo+'Tarea\');"  ><i class="glyphicon glyphicon-minus" style="background-color:red;" ></i></a></td>';
						html+='					<td><a href="javascript:void(0);" class="btn btn-success btn-circle .btn-xs" style="background-color:red;border:0;" title="Eliminar Tarea"  onclick="mostrarModalEliminarTarea('+filaActividad+','+filaTareaActividad+',this);"  ><i class="glyphicon glyphicon-minus" style="background-color:red;" ></i></a></td>';
						html+='				</tr>';
						tareasActividadesArray[countTareasActividades]=elementoTareaActividad;
					    countTareasActividades++;
					    filaTareaActividad++;
					});
					
					elementoActividad.tareas = tareasActividadesArray;
					elementoActividad.cantidadTareas=countTareasActividades;
					
					actividadesArray[countActividades]=elementoActividad;
					countActividades++;
					filaActividad++;
					
					html+='				</tbody>';
					html+='			</table>';
					html+='		</div>';
					html+='	</div>';
					html+='</div>';
					html+='</div>';
					html+='</div>';
			  });
			  $("#divEspacio").html(html);
			  cargarResponsableTareas("#divEspacio");
		  }});
	
	
	
}

function deleteTarea(filaActividad, filaTarea, tabla) {
	posicion=-1;
	
	//$("#"+tabla).remove();
	$(tabla).closest("tr").remove();
	
	for (var i=0;i<countActividades;i++){
		
		
		if (actividadesArray[i].fila==filaActividad){
			var cantTareas=actividadesArray[i].cantidadTareas;
			var tareasActividadesArray=actividadesArray[i].tareas;
			
			for(var j=0;j<cantTareas;j++){
				if (tareasActividadesArray[j].fila==filaTarea){
					//alert ("Eliminando tarea enla posicion "+j+" del array "+tareasActividadesArray);
					tareasActividadesArray.splice( j, 1 );
					cantTareas--;
					actividadesArray[i].cantidadTareas=cantTareas;
					
					break;
				}
			}
		}
	}
	
	
	
	

	//countTareas--;
	
}

function adicionarTarea(tabla, fila) {
	var newRow=$("<tr id='"+contFilasTareasAdicionales+"Tarea'>");
	var cols="";
	cols+="<td><input type='text' class='form-control' id='nombreTarea"+filaTareaActividad+"' name='nombreTarea"+filaTareaActividad+"'></td>";
	cols+="<td><input type='text' class='form-control' id='detalleTarea"+filaTareaActividad+"' name='detalleTarea"+filaTareaActividad+"'></td>";
	cols+="<td><select class='form-control' id='responsable"+filaTareaActividad+"' name='responsable"+filaTareaActividad+"'></select></td>";
	cols+="<td>" + mensaje + "<input type='date' class='form-control' id='vencimiento"+filaTareaActividad+"' name='vencimiento"+filaTareaActividad+"'"+metodoOnchage+"></td>";
  //cols+="<td><a href='javascript:void(0);' onclick='deleteTarea("+contFilasTareasAdicionales+","+contFilasTareasAdicionales+",this);'  ><i class='glyphicon glyphicon-minus' style'background-color:red;'></i></a></td>";
	cols+="<td><a href='javascript:void(0);' onclick='deleteTarea("+fila+","+filaTareaActividad+",this);' class='btn btn-success btn-circle .btn-xs' style='background-color:red;border:0;' title='Eliminar Tarea' ><i class='glyphicon glyphicon-minus' style'background-color:red;'></i></a></td>";
	newRow.append(cols);
	
	
	
	$("#"+tabla).append(newRow);

	for (var i=0;i<countActividades;i++){
		
		
		if (actividadesArray[i].fila==fila){
			var cantTareas=actividadesArray[i].cantidadTareas;
			var tareasActividadesArray=actividadesArray[i].tareas;
			
			elementoTareaActividad = new Object();
		    elementoTareaActividad.fila= filaTareaActividad;
		    tareasActividadesArray[cantTareas]=elementoTareaActividad;
		    cantTareas++;
		    actividadesArray[i].cantidadTareas=cantTareas;
		    
		}
		
		
	}
	
	
	filaTareaActividad++;
	contFilasTareasAdicionales++;
	//countTareas--;
	cargarResponsableTareas(newRow);
	//agregarResponsablesNuevaTarea(newRow);
	
}

function actividadesParticularesCaso(){
	
	if(EstaVacio($("#nombreActividad").val()) )
	{
		
		$("#messageErrorAactividad").html("Ingrese un nombre para la actividad");
		$("#messageErrorAactividad").show(); 
		
	}
	else{
		$("#messageErrorAactividad").hide();
	
	
	var html='';
	elementoActividad = new Object();
    elementoActividad.fila= filaActividad;
    elementoActividad.codigoActividad=codigoActivad;
    elementoActividad.nombreActividad =$("#nombreActividad").val();
    
    filasActividadesParticulares[countActividadesParticulares]=filaActividad; 
    
    var tareasActividadesArray = new Array();
    var countTareasActividades = 0;
    html+='	<br>';
  	html+='<div  name="actividadParticular" style="padding-left: 3%; padding-right: 3%;">';
	html+='<div class="panel panel-default">';
	html+='	<div class="panel-heading">';
	
	html+='<div class="row">';
	
	html+='<div class="col-sm-10">';
	
	html+='		<h4 class="panel-title">';
	html+='			<a data-toggle="collapse" data-parent="#accordion"';
	html+='				href="#collapseActividad'+codigoActivad+'">'+$("#nombreActividad").val()+'</a>';
	html+='		</h4>';
	
	html+='</div>';
	
	html+='<div class="col-sm-2">';
	
	html+='		<div class="ibox-tools">';
	//////
	html+='		<a href="javascript:void(0);"';
	html+='			onclick="borrarActividad('+filaActividad+',this)" class="btn btn-success btn-circle .btn-xs" title="Eliminar Tarea"';
	html+='			style="background-color:red;border:0;" name="btnActividad" title="Eliminar Actividad"> <i';
	html+='			class="glyphicon glyphicon-minus" id="btnActividad" name="btnActividad"></i>';
	html+='		</a>';
	/////
	html+='		<a href="javascript:void(0);"';
	html+='			onclick="adicionarTarea(\'tabla'+codigoActivad+'\','+filaActividad+')" class="btn btn-success btn-circle .btn-xs" title="Adicionar Tarea"';
	html+='			style="background-color: #449D44;border:0;" name="btTareas" title="Adicionar"> <i';
	html+='			class="glyphicon glyphicon-plus" id="btnTareas" name="btnTareas"></i>';	
	html+='		</a>';
	html+='		</div>';
	
	html+='	</div>';
	
	html+='</div>';
	
	html+='	</div>';
	html+='	<div id="collapseActividad'+codigoActivad+'" class="panel-collapse collapse">';
	html+='		<div class="panel-body" id="panelActividad'+codigoActivad+'">';
	
	html+='<div class="row">';
	html+='<div class="col-sm-3" style="padding-top: 1%;">';
	
	html+='		Fecha vencimiento: </div> <div class="col-sm-3" style="margin-bottom: 1%;"> <input type="date" id="actividadVencimiento'+filaActividad+'" name="actividadVencimiento'+filaActividad+'"'+metodoOnchageActividad+'></div> ';
	html+='<div class="col-sm-6">';
	html+='</div>';
	html+='			<table class="table table-bordered" id="tabla'+codigoActivad+'">';
	html+='				<thead>';
	html+='				<tr>';
	html+='					<th>Tarea</th>';
	html+='					<th>Detalle</th>';
	html+='					<th>Responsable</th>';
	html+='					<th>Fecha Vencimiento</th>';
	html+='					<th>Acción</th>';
	html+='				</tr>';
	html+='				</thead>';
	html+='				<tbody>';

	
	elementoActividad.tareas = tareasActividadesArray;
	elementoActividad.cantidadTareas=countTareasActividades;
	
	actividadesArray[countActividades]=elementoActividad;
	countActividades++;
	filaActividad++;
	countActividadesParticulares++;
	
	html+='				</tbody>';
	html+='			</table>';
	html+='		</div>';
	html+='	</div>';
	html+='</div>';
	html+='</div>';
    html+='	<br">';
	
	$("#divEspacio1").append(html);
	codigoActivad++;
	
	}
	
}


function borrarActividad(filaActividad,actividad) {
	
    $(actividad).closest("div[name=actividadParticular]").remove();
	for (var i=0;i<countActividades;i++){
			
			
			if (actividadesArray[i].fila==filaActividad){
				
				//alert ("Eliminando actividad enla posicion "+i+" del array "+actividadesArray);
				actividadesArray.splice( i, 1 );
				for (var j=0;j<countActividadesParticulares;j++){
					if (filasActividadesParticulares[j]==filaActividad){
						filasActividadesParticulares.splice( j, 1 );		
						countActividadesParticulares--;
						//break;
					}
					
				}
				
				countActividades--;
				break;
				
			}
		}
	
}

function borrarActividadesTipoCaso() {
	
	
	for (var i=0;i<countActividades;i++){
		var borrarActividad=true;
		
		//filaActividad=actividadesArray[i].fila;
		
		for (var j=0;j<countActividadesParticulares;j++){
			if (filasActividadesParticulares[j]==actividadesArray[i].fila){
				borrarActividad=false;
				break;
			}
			
		}
		
		if(borrarActividad){
			actividadesArray.splice( i, 1 );
			countActividades--;
			i--;
		}
	
	}
	


}



function mostrarModalEliminarActividad(fila, boton) {
	filaABorrar = fila;
	botonPresionado = boton;
	$("#modal-EliminarActividad").modal("show");
}


function mostrarModalEliminarTarea(fila, filaTarea, boton) {
	filaABorrar = fila;
	filaABorrarTarea = filaTarea;
	botonPresionado = boton;
	$("#modal-EliminarTarea").modal("show");
}


function modalClose() {
		  // do something…ç
		$("#modal-nuevoCaso").modal("hide");
		limpiarFormularioNuevoCaso();
}


function formatearCamposValores() {
	$('#txtValorPrestamo').number( true, 2 ,',','.');
	$('#txtPorcentajeInteresPrestamo').number( true, 2 ,',','.');
	$('#txtIntereses').number( true, 2 ,',','.');
	$('#txtSaldoPrestamo').number( true, 2 ,',','.');
}

function mostrarMensajesError(objectErrores) {
	$("#messageError").html("No se puede guardar el caso. Existen errores en el formulario.");
	$("#messageError").show();
	var mensajeError = "";
	if (objectErrores.erroresNuevoCaso.length) {
		$.each(objectErrores.erroresNuevoCaso, function(index, optionData) {
			mensajeError += "<p>" + (index + 1) + ". " + optionData + "</p>"
		});
		$("#messageErrorNuevoCaso").html(mensajeError);
		$("#messageErrorNuevoCaso").show();
		mensajeError = "";
	}
	if (objectErrores.erroresAbogados.length) {
		$.each(objectErrores.erroresAbogados, function(index, optionData) {
			mensajeError += "<p>" + (index + 1) + ". " + optionData + "</p>"
		});
		$("#messageErrorAbogado").html(mensajeError);
		$("#messageErrorAbogado").show();
		mensajeError = "";
	}
	if (objectErrores.erroresDemandados.length) {
		$.each(objectErrores.erroresDemandados, function(index, optionData) {
			mensajeError += "<p>" + (index + 1) + ". " + optionData + "</p>"
		});
		$("#messageErrorDemandados").html(mensajeError);
		$("#messageErrorDemandados").show();
		mensajeError = "";
	}
	if (objectErrores.erroresVictimasDemandantes.length) {
		$.each(objectErrores.erroresVictimasDemandantes, function(index, optionData) {
			mensajeError += "<p>" + (index + 1) + ". " + optionData + "</p>"
		});
		$("#messageErrorEquipoCaso").html(mensajeError);
		$("#messageErrorEquipoCaso").show();
		mensajeError = "";
	}
	if (objectErrores.erroresActividades.length) {
		$.each(objectErrores.erroresActividades, function(index, optionData) {
			mensajeError += "<p>" + (index + 1) + ". " + optionData + "</p>"
		});
		$("#messageErrorActividades").html(mensajeError);
		$("#messageErrorActividades").show();
		mensajeError = "";
	}
	if (objectErrores.erroresLugarProceso.length) {
		$.each(objectErrores.erroresLugarProceso, function(index, optionData) {
			mensajeError += "<p>" + (index + 1) + ". " + optionData + "</p>"
		});
		$("#messageErrorLugarProceso").html(mensajeError);
		$("#messageErrorLugarProceso").show();
		mensajeError = "";
	}
	if (objectErrores.erroresBienes.length) {
		$.each(objectErrores.erroresBienes, function(index, optionData) {
			mensajeError += "<p>" + (index + 1) + ". " + optionData + "</p>"
		});
		$("#messageErrorBienesAfectados").html(mensajeError);
		$("#messageErrorBienesAfectados").show();
		mensajeError = "";
	}
	if (objectErrores.erroresRadicados.length) {
		$.each(objectErrores.erroresRadicados, function(index, optionData) {
			mensajeError += "<p>" + (index + 1) + ". " + optionData + "</p>"
		});
		$("#messageErrorRadicados").html(mensajeError);
		$("#messageErrorRadicados").show();
		mensajeError = "";
	}
	if (objectErrores.erroresPrestamo.length) {
		$.each(objectErrores.erroresPrestamo, function(index, optionData) {
			mensajeError += "<p>" + (index + 1) + ". " + optionData + "</p>"
		});
		$("#messageErrorPrestamos").html(mensajeError);
		$("#messageErrorPrestamos").show();
		mensajeError = "";
	}
}


function ocultarMensajesError() {
	$("#messageError").hide();
	$("#messageError").html("");
	$("#messageErrorNuevoCaso").hide();
	$("#messageErrorNuevoCaso").html("");
	$("#messageErrorAbogado").hide();
	$("#messageErrorAbogado").html("");
	$("#messageErrorDemandados").hide();
	$("#messageErrorDemandados").html("");
	$("#messageErrorEquipoCaso").hide();
	$("#messageErrorEquipoCaso").html("");
	$("#messageErrorActividades").hide();
	$("#messageErrorActividades").html("");
	$("#messageErrorLugarProceso").hide();
	$("#messageErrorLugarProceso").html("");
	$("#messageErrorBienesAfectados").hide();
	$("#messageErrorBienesAfectados").html("");
	$("#messageErrorRadicados").hide();
	$("#messageErrorRadicados").html("");
	$("#messageErrorPrestamos").hide();
	$("#messageErrorPrestamos").html("");
	$("#messageErrorComentarios").hide();
	$("#messageErrorComentarios").html("");
}