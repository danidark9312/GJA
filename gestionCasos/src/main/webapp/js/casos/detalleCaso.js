function consultarCaso (codigo) {
	//var documento =152;
	var documento =codigo;
	var data_caso ="codigo="+documento;
	 data_caso +="&_csrf=" + $("#_csrf").val();
	$.ajax({
	     type : "POST",
		  dataType: "json",
		  url: contexto + "/detalleCaso/consultarCaso",
		  data: data_caso,
		  success: function (res) {
			  if(res.codigo != null){
				$("#nombreCaso").text(res.nombre);
				var fechaHecho = new Date(res.fechaHecho);
				var fechaHechoFormato =formatoFecha(fechaHecho);
				$("#fechaHechos").text(fechaHechoFormato);
				var fechaFinHecho = new Date(res.fechaCaducidad);
				var fechaFinHechoFormato =formatoFecha(fechaFinHecho);
				$("#fechaFinHechos").text(fechaFinHechoFormato);//FechaCaducidad donde esta??
				$("#funcionario").text(res.nombreFuncionario);
				$("#resumenHechos").text(res.resumenHechos);				
				$("#hechosDireccion").text(res.direccionHechos);
			    $("#ProcesoDescripcion").text(res.direccionProceso);
			    if(res.ciudadProceso!=null){
				$("#ProcesoMunicipio").text(res.ciudadProceso.nombre);
				$("#procesoDepartamento").text(res.ciudadProceso.departamento.nombre);
				$("#ProcesoPais").text(res.ciudadProceso.departamento.pais.nombre);
			    }
//				$("#ProcesoDescripcion").text(optionData.departamentoCaso);//falta proceso es la direccion  en la base de datos
			    if(res.ciudadHechos!=null){
			    $("#hechosMunicipio").text(res.ciudadHechos.nombre);
				$("#hechosDepartamento").text(res.ciudadHechos.departamento.nombre);
				$("#hechosPais").text(res.ciudadHechos.departamento.pais.nombre);
			    }
//				$("#ProcesoDescripcion").text(optionData.departamentoCaso);//falta proceso es la direccion  en la base de datos
				$("#procesoEstado").text(res.estadoCaso.nombre);
				$("#estadoCaso").text(res.estadoCaso.nombre);
				$("#tipoCaso").text(res.tipoCaso.nombre);
				$("#nombreDespacho").text(res.numeroDespacho);
		  }
		 }
	});
}


function mostrarTablaBienesAfectados(codigo){
	//var documento =152;
	var documento =codigo;
	var data_caso = "codigo="+documento;
		data_caso += "&_csrf=" + $("#_csrf").val();
	var tablaHtml="<table id='tablaListadoBienesAfectadosJS' class='table table-striped' >";
	tablaHtml+="	<thead>";
	tablaHtml+="<tr>";
	tablaHtml+="<th >Nombre</th>";
	tablaHtml+="<th >Descripción</th>";
	tablaHtml+="<th >Tipo</th>";
	tablaHtml+="</tr>";
	tablaHtml+="	</thead>";
	tablaHtml+="	<tbody>";
	tablaHtml+="</tbody>";
	tablaHtml+="</table>";
	$("#tablaListadoBienesAfectados").html(tablaHtml);
	oTable =$('#tablaListadoBienesAfectadosJS').dataTable({
		"bProcessing": false,
        "bServerSide": true,
        "bFilter":false,
        "bPaginate":false, 
        "bInfo":false,
        "sAjaxSource": contexto+"/detalleCaso/getAllTable?" + data_caso,
        "aaSorting": [[ 1, "desc" ]],
        "aoColumns": [
						{ "mDataProp": "tituloBienAfectado", "bSortable": false, "sWidth":"40%" },
						{ "mDataProp": "detalleBienAfectado","bSortable": false, "sWidth":"40%" },
						{ "mDataProp": "tipoBienAfectdo", "bSortable": false,  "sWidth":"20%" }

					],
		"fnServerData": function ( sSource, aoData, fnCallback ) {
			
			
			$.ajax( {
				type: 'POST',
				dataType: "json",
                url: contexto+"/detalleCaso/getAllTable?" + data_caso,
                data: aoData,
                success: fnCallback,
                error : function (e) {
                    alert (e);
                }
            } );
        }
	});
	

	
	oTable.on('mouseover', 'tr', function () {
		  	this.style.cursor = 'pointer';
	});
	
	oTable.on('click', 'tr', function () {
			
			var aData = oTable.fnGetData(this); // get datarow
		    if (null != aData)  // null if we clicked on title row
		    {
		    }   
	});
	
}

function mostrarTablaRadicado(codigo){
	//var documento =152;
	var documento =codigo;
	var data_caso = "codigo="+documento;
		data_caso += "&_csrf=" + $("#_csrf").val();
	var tablaHtml="<table id='tablaListadoRadicados' class='table table-striped' >";
	tablaHtml+="	<thead>";
	tablaHtml+="<tr>";
	tablaHtml+="<th >Número Radicado</th>";
	tablaHtml+="<th >Instancia</th>";
	tablaHtml+="</tr>";
	tablaHtml+="	</thead>";
	tablaHtml+="	<tbody>";
	tablaHtml+="</tbody>";
	tablaHtml+="</table>";
	$("#tablaRadicado").html(tablaHtml);
	oTable =$('#tablaListadoRadicados').dataTable({
		"bProcessing": false,
        "bServerSide": true,
        "bFilter":false,
        "bPaginate":false, 
        "bInfo":false,
        "sAjaxSource": contexto+"/detalleCaso/getAllTableRadicado?" + data_caso,
        "aaSorting": [[ 1, "desc" ]],
        "aoColumns": [
						{ "mDataProp": "codigoRadicado", "bSortable": false, "sWidth":"50%" },
						{ "mDataProp": "instanciaRadicado","bSortable": false, "sWidth":"50%" }
			

					],
		"fnServerData": function ( sSource, aoData, fnCallback ) {
			
			
			$.ajax( {
				type: 'POST',
				dataType: "json",
                url: contexto+"/detalleCaso/getAllTableRadicado?" + data_caso,
                data: aoData,
                success: fnCallback,
                error : function (e) {
                    alert (e);
                }
            } );
        }
	});
	

	
	oTable.on('mouseover', 'tr', function () {
		  	this.style.cursor = 'pointer';
	});
	
	oTable.on('click', 'tr', function () {
			
			var aData = oTable.fnGetData(this); // get datarow
		    if (null != aData)  // null if we clicked on title row
		    {
//		    	document.location.href="cliente?documento=" + aData.documento;
		    }   
	});
	
}



function mostrarTelefono(id){
	$('#'+"campoTelefono"+id).show();
	$('#'+"masTelefono"+id).hide();
	$('#'+"menosTelefono"+id).show();
}
function mostrarEmail(id){
	$('#'+"campoCorreo"+id).show();
	$('#'+"masCorreo"+id).hide();
	$('#'+"menosCorreo"+id).show();
}
function ocultarTelefono(id){
	$('#'+"campoTelefono"+id).hide();
	$('#'+"masTelefono"+id).show();
	$('#'+"menosTelefono"+id).hide();
}
function ocultarEmail(id){
	$('#'+"campoCorreo"+id).hide();
	$('#'+"masCorreo"+id).show();
	$('#'+"menosCorreo"+id).hide();
}