//Metodo para iniciar los selectores de  nuevo caso

var seleccionar=true;
function cargarCombox()
{
  	cargarPaises("txtPaisDeLosHechos");
	cargarPaises("txtPaisMiembro");
	cargarPaises("txtPaisMiembro1");
	cargarPaises("txtPaisProceso");
//	$("select[name=txtPaisMiembro]").each(function(ind,dato){
//		
//		cargarPaises(dato);
//	});
	
$("select[name=txtEstadoCaso]").each(function(ind,dato){
	
	cargarEstadoCaso(dato);
});

$("select[name=txtTipoCaso]").each(function(ind,dato){
	
	cargarTipoCaso(dato);
});
	
	//cargarTipoCaso("txtTipoCaso");
	//cargarEstadoCaso("txtEstadoCaso");
	obtenerClaseBien("txtclaseBien");
	obtenerInstancia("txtInstanciaRadicado");
	obtenerTipoMiembro("txtTipoDeMiembro");
	obtenerParentesco("txtParentescoMiembro");
	cargarEntidadesFinancieras("txtEntidadFinanciera");
	cargarAbogado("cmbMiembroAbogado");
	//rulesForm();

}
// metodo para mostrar los abogados en el seleccionar
function cargarAbogado(campoAbogado) {
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerAbogados",
		  data: null,
		  success: function (response) {
			  var select = document.getElementById(campoAbogado);
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  select.add(option); 
			  $.each(response.abogados, function(index, optionData) {	  
				  var select = document.getElementById(campoAbogado);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  select.add(option);
			  });
		  }
	});
}
//Metodo para cargar los abogados como responsables
function cargarResponsableTareas1(){
	
	$("#actividadParticular").find("select[name^='responsable']").each(function(){
		var select=this;
		var option = document.createElement("option");
		$(select).find("option").each(function(){
				if($(this).val()=="")
				{
					seleccionar=false;
				}
			
		});
		if (seleccionar) {
			option.value = "";
			option.text = "Seleccionar";
			select.add(option);
		}
			
		var option = document.createElement("option");
		if($("#cmbMiembroAbogado").find('option:selected').val()!=""){
			option.value=$("#cmbMiembroAbogado").find('option:selected').val();
			option.text = $("#cmbMiembroAbogado").find('option:selected').text();
			select.add(option);
		}
	});
	seleccionar=false;
}
//quitar responsable cuando se borre el abogado
function quitarResponsableTarea(idResponsble){
	var valorAnterior =null;
	$("#actividadParticular").find("select[name^='responsable']").each(function(){
		if($(this).val()==idResponsble)
			{
			valorAnterior ="";
			}else{
				
			valorAnterior = $(this).val();
			}
		$(this).val(idResponsble);
		$(this).find('option:selected').remove();
		$(this).val(valorAnterior);
		
		
	});
}
//Metodo para cargar los responsables cuando se agreguen tareas no se esta utilizando
function agregarResponsablesNuevaTarea(columnaTarea){
	var select=$(columnaTarea).find("select[name^='responsable']");
	var option = document.createElement("option");
	  option.value = "";
	  option.text = "Seleccionar";
	  select.add(option);
	  $("#cmbMiembroAbogado option:disabled").each(function(ind1,dato1){
			 var option = document.createElement("option");
			  option.value =$(dato1).val();
			  option.text = $(dato1).text();
			  select.add(option);
		});
	
	
}
//Metodo para Cargar los responsables de las tareas
function cargarResponsableTareas(formulario){
	
	//$("#actividadParticular").find("select[name^='responsable']").each(function(){
	$(formulario).find("select[name^='responsable']").each(function(){	
		var select=this;
	    var option = document.createElement("option");
		  option.value = "";
		  option.text = "Seleccionar";
		  select.add(option); 
		  
		  $("#cmbMiembroAbogado option:disabled").each(function(ind1,dato1){
				 var option = document.createElement("option");
				  option.value =$(dato1).val();
				  option.text = $(dato1).text();
				  select.add(option);
			});
	    
	 });
}
//Meotodo para validar los responsables cuando se borren del bloque de abogados
function habilitarResponsablesDesdeAbogados(){
	
	$("#actividades").find("select[name=cmbResponsableTarea]:gt(0)").each(function(ind,select1){
			  
		  $("#cmbMiembroAbogado option:disabled").each(function(ind,select2){
			  	var valorAnterior = $(select1).val();
			  	 $(select1).val($(select2).val());
			  	 $(select1).find('option:selected').removeAttr("disabled");
			  	 $(select1).val(valorAnterior);			  
			});
	    
	 });

	
}
// Metodo para cargar los paises
function cargarPaises(campoPaises) {
	

	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerPaises",
		  data: null,
		  success: function (response) {
			  var select = document.getElementById(campoPaises);
			  //var select = campoPaises;
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  select.add(option);
			  $.each(response.paises, function(index, optionData) {	  
				  var select = document.getElementById(campoPaises);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  select.add(option);
			  });
		  }
	});
}
//Metodo para cargar los departamentos por pais
function cargarDepartamentosPorPais(campoPais,campoDepartamento,campoMunicipio) {

	$("#" + campoDepartamento).find("option").remove();
	$("#"+campoMunicipio).find("option").remove();
	
	
	
	var codigoPais = "codigoPais=" +  campoPais.value;
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerDepartamentosPorPais",
		  data: codigoPais,
		  success: function (response) {
			  var select = document.getElementById(campoDepartamento);
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  select.add(option);
			  $.each(response.departamentos, function(index, optionData)  {	  
				  var select = document.getElementById(campoDepartamento);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  select.add(option);
			  });
		  }
	});
}
//Metodo para cargar las ciudades por departamento
function cargarCiudadPorDepartamentos(campoDepartamento,campoCiudad) {
	
	$(campoCiudad).find("option").remove();
	var codigoDepartamento = "codigoDepartamento=" + campoDepartamento.value;
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerCiudadPorDepartamento",
		  data: codigoDepartamento,
		  success: function (response) {
			  var select = document.getElementById(campoCiudad);
			  select.options.length = 0;
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  select.add(option);
			  $.each(response.ciudades, function(index, optionData)  {	  
				  var select = document.getElementById(campoCiudad);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  select.add(option);
			  });
		  }
	});
}
//Metodo para cargar los departamentos  por pais para los miembros del equipo
function cargarDepartamentosPorPais1(campoPais) {
	var divTemp=$(campoPais).closest("div[name=formularioEquipoCaso]");;
	//var divTemp=$(campoPais).closest("div[name=ubicacion]");
	var campoDepartamento=null;
	$(divTemp).find("select[name^='TxtDepartamentoMiembro']").each(function(){
		campoDepartamento=$(this)[0];
		$(campoDepartamento).find("option").remove();
	 });
	$(divTemp).find("select[name^='txtMunicipioMiembro']").each(function(){
		$(this).find("option").remove();
	 });
	var codigoPais = "codigoPais=" +  campoPais.value;
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerDepartamentosPorPais",
		  data: codigoPais,
		  success: function (response) {
			  //var select = document.getElementById(campoDepartamento);
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  campoDepartamento.add(option);
			  $.each(response.departamentos, function(index, optionData)  {	  
				  //var select = document.getElementById(campoTemp);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  campoDepartamento.add(option);
			  });
		  }
	});
}
//Metodo para cargar las ciudades por departamento para los miembros del equipo
function cargarCiudadPorDepartamentos1(campoDepartamento) {
	
	var divTemp=$(campoDepartamento).closest("div[name=formularioEquipoCaso]");
	var campoCiudad=null;
	$(divTemp).find("select[name^='txtMunicipioMiembro']").each(function(){
		campoCiudad=$(this)[0];
		$(this).find("option").remove();
	 });
	var codigoDepartamento = "codigoDepartamento=" + campoDepartamento.value;
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerCiudadPorDepartamento",
		  data: codigoDepartamento,
		  success: function (response) {
			  //var select = document.getElementById(campoDepartamento);
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  campoCiudad.add(option);
			  $.each(response.ciudades, function(index, optionData)  {	  
				  //var select = document.getElementById(campoTemp);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  campoCiudad.add(option);
			  });
		  }
	});
}
//Metodo para cargar los tipos de caso
function cargarTipoCaso(campoTipoDeCaso) {
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerTipoDeCaso",
		  data: null,
		  success: function (response) {
			  //var select = document.getElementById(campoTipoDeCaso);
			  var select = campoTipoDeCaso;
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  select.add(option);
			  $.each(response.tiposDeCaso, function(index, optionData) {	  
				  //var select = document.getElementById(campoTipoDeCaso);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  select.add(option);
			  });
		  }
	});
}
//Metodo para cargar los estados del caso
function cargarEstadoCaso(campoEstadoCaso) {
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerEstadoCaso",
		  data: null,
		  success: function (response) {
			  //var select = document.getElementById(campoEstadoCaso);
			  var select =campoEstadoCaso;
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  select.add(option);
			  $.each(response.estadosCaso, function(index, optionData) {	  
				 // var select = document.getElementById(campoEstadoCaso);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  select.add(option);
			  });
		  }
	});
}
//Metodo para obtener la clase de bien : inmueble o mueble
function obtenerClaseBien(campoClaseBien) {
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerClaseBien",
		  data: null,
		  success: function (response) {
			  var select = document.getElementById(campoClaseBien);
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  select.add(option);
			  $.each(response.clasesBienes, function(index, optionData) {	  
				  var select = document.getElementById(campoClaseBien);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  select.add(option);
			  });
		  }
	});
}
// Metodo para obtener la instancia del radicado
function obtenerInstancia(campoInstancia) {
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerInstancia",
		  data: null,
		  success: function (response) {
			  var select = document.getElementById(campoInstancia);
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  select.add(option);
			  $.each(response.instancias, function(index, optionData) {	  
				  var select = document.getElementById(campoInstancia);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  select.add(option);
			  });
		  }
	});
}
//Metodo para obtener  el tipo de miembro
function obtenerTipoMiembro(campoTipoMiembro) {
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerTipoMiembro",
		  data: null,
		  success: function (response) {
			  var select = document.getElementById(campoTipoMiembro);
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  select.add(option);
			  $.each(response.tiposMiembros, function(index, optionData) {	  
				  
				  if(optionData.codigo!=3 && optionData.codigo!=5 ){
					  var select = document.getElementById(campoTipoMiembro);
					  var option = document.createElement("option");
					  option.value = optionData.codigo;
					  option.text = optionData.nombre;
					  select.add(option);
				  }
			  });
		  }
	});
}
//Metodo para obtener  el  parentezco
function obtenerParentesco(campoParentesco) {
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/obtenerParentesco",
		  data: null,
		  success: function (response) {
			  var select = document.getElementById(campoParentesco);
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  select.add(option);
			  $.each(response.parentescos, function(index, optionData) {	  
				  var select = document.getElementById(campoParentesco);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  select.add(option);
			  });
		  }
	});
}

function cargarActividades(listaActividades) {
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestroTipoCaso/obtenerActividades",
		  data: null,
		  success: function (response) {
			  var select = document.getElementById(listaActividades);
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  select.add(option);
			  $.each(response.actividad, function(index, optionData) {	  
				  var select = document.getElementById(listaActividades);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  select.add(option);
			  });
		  }
	});
}
//Metodo que carga las entidades financieras
function cargarEntidadesFinancieras(CampoEntidadFinanciera)
{
	$.ajax({
		  dataType: "json",
		  url: contexto + "/maestro/cargarEntidadesFinancieras",
		  data: null,
		  success: function (response) {
			  var select = document.getElementById(CampoEntidadFinanciera);
			  var option = document.createElement("option");
			  option.value = "";
			  option.text = "Seleccionar";
			  select.add(option);
			  $.each(response.entidadesFinancieras, function(index, optionData) {	  
				  var select = document.getElementById(CampoEntidadFinanciera);
				  var option = document.createElement("option");
				  option.value = optionData.codigo;
				  option.text = optionData.nombre;
				  select.add(option);
			  });
		  }
	});
	
}




