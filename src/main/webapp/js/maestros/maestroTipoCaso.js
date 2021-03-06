var contadorClonador	= 0;
var codigoTipoCaso	    =0;
var codigoTarea			=0;
var casoActividad		= false;
var eventoBoton 		= "";
var idEliminar 			="";
var nuevo = true;

function mostrarTablaTipoCaso(){
	
	var data_decode = "_csrf=" + $("#_csrf").val()+"&activo=S";
	//data_decode += "&tipoDeCaso="+;
	
	var tablaHtml="<table id='datatableTiposCasos' class='table table-striped table-hover' >";
	tablaHtml+="	<thead>";
	tablaHtml+="<tr class='tr_titulo'>";
	tablaHtml+="<th>Código</th>";
	tablaHtml+="<th >Nombre</th>";
	tablaHtml+="<th >Acción</th>";
//	tablaHtml+="<th hidden='hidden'>&nbsp;</th>";
	tablaHtml+="</tr>";
	tablaHtml+="	</thead>";
	tablaHtml+="	<tbody>";
	tablaHtml+="</tbody>";
	tablaHtml+="</table>";
	$("#tablaListadoTiposCasos").html(tablaHtml);
	oTable =$('#datatableTiposCasos').dataTable({
		"bProcessing": true,
        "bServerSide": true,
        "bFilter":true,
        "bInfo":false,
        "sAjaxSource": contexto + "/maestroTipoCaso/mostrarTiposCasos?" + data_decode,
        "language": {
            "sProcessing":     "Procesando...",
            "sLengthMenu":     "Mostrar _MENU_ registros",
            "sZeroRecords":    "No se encontraron resultados",
            "sEmptyTable":     "Ningún dato disponible en esta tabla",
            "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix":    "",
            "sSearch":         "Buscar:",
            "sUrl":            "",
            "sInfoThousands":  ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst":    "Primero",
                "sLast":     "Último",
                "sNext":     "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        },
        "aoColumns": [
						{ "mDataProp": "codigoTipoCaso", "bSortable": false, "sWidth":"30%" },
						{ "mDataProp": "nombreTipoCaso","bSortable": false, "sWidth":"30%" },
				 		{ "mDataProp": "papelera","bSortable": false, "sWidth":"20%" }
//						{ "mDataProp": "codigoActividad","bSortable": false,  "bVisible": false }
					],
		"fnServerData": function ( sSource, aoData, fnCallback ) {
            $.ajax( {
                type: 'POST',
                url: contexto + "/maestroTipoCaso/mostrarTiposCasos?" + data_decode,
                data: aoData,
                success: fnCallback,
                error : function (e) {
                   
                }
            } );
        }, 
        "fnDrawCallback": function(oSettings) {
        	
       	 $.each($("[name = verDetalle]"), function (index, optionData) {
    		 optionData.onclick = function () {
    			 var tr = optionData.parentNode.parentNode.parentNode;
    			 if (oTable.fnIsOpen(tr)) {
    		        oTable.fnClose(tr);
    		        optionData.firstChild.removeAttribute('class', 'glyphicon glyphicon-chevron-up');
    		        optionData.firstChild.setAttribute("class", "glyphicon glyphicon-chevron-down");
    		      } else {
    		        oTable.fnOpen(tr, oTable.fnGetData(tr).detalle, "info_row" );
    		        optionData.firstChild.removeAttribute('class', "glyphicon glyphicon-chevron-down");
    		        optionData.firstChild.setAttribute("class", 'glyphicon glyphicon-chevron-up');
    		      }
    		 };
    	 });
       	$.each($("[name = verDetalleEquipoCaso]"), function (index, optionData) {
   		 optionData.onclick = function () {
   			 var tr = optionData.parentNode.parentNode.parentNode;
   			 if (oTable.fnIsOpen(tr)) {
   		        oTable.fnClose(tr);
   		        optionData.firstChild.removeAttribute('class', 'glyphicon glyphicon-chevron-up');
   		        optionData.firstChild.setAttribute("class", "glyphicon glyphicon-chevron-down");
   		      } else {
   		        oTable.fnOpen(tr, oTable.fnGetData(tr).detalleEquipoCaso, "info_row" );
   		        optionData.firstChild.removeAttribute('class', "glyphicon glyphicon-chevron-down");
   		        optionData.firstChild.setAttribute("class", 'glyphicon glyphicon-chevron-up');
   		      }
   		 };
   	 });
     
    		oTable.on('mouseover', 'tr', function () {
    		  	this.style.cursor = 'pointer';
    	});

    		oTable.find("tr").each(function(data) {
    		   	var aData = oTable.fnGetData(this); // get datarow
    		    $(this).find("td:lt(2)").on("click", function() {
    		   	
    		   	if (null != aData)  // null if we clicked on title row
    		   	{
    		   		consultarTipoCaso(aData.codigoTipoCaso);
    		   
    		     
    		   	   	
    		   	}   
    		   	});
    		   	});
        }
	
		
	});
	
}

function eliminarTipoCaso(codigo){
		
	
		codigoTipoCaso =codigo;
		canIsDeleteTipoCaso(codigo);
	
}


function consultarTipoCaso(codigo){
	var data_caso ="codigo="+codigo;
    data_caso +="&_csrf=" + $("#_csrf").val();
	$.ajax({
	     type : "POST",
		  dataType: "json",
		  url: contexto + "/maestroTipoCaso/consultarTipoCaso",
		  data: data_caso,
		  success: function (res) {
			  if(res.codigo != null){
				  limpiarModal();
				  codigoTipoCaso=codigo;
				  nuevo=false;
				$("#modal-actualizarTipoCaso").modal("show");
				
				//$('#actualizarActividad').show();
				$('#guardarTipoCaso').show();
				
				$("#codigoTipoCaso").val(res.codigo); 
				$("#nombreTipoCaso").val(res.nombre);
				
				var selected=$("#actividadTipoCaso option:selected").map(function(){ return this.value }).get();
				$.each(res.actividadTipoCasoList, function(index, optionData) {
					
					
				    selected.push(optionData.cdactividad);// 2 is the val I set for Dog
				    
					
					 //$('#actividadTipoCaso').val(optionData.cdactividad);
				      //  $('#actividadTipoCaso').trigger("chosen:updated");
					
					
						  	 	
				  });
				$('#actividadTipoCaso').val(selected);
				$('#actividadTipoCaso').trigger("chosen:updated");
				$.each(res.actividadTipoCasoList, function(index, optionData) {
					casoActividad=true;
				});		 
		  }
		 }
	});
}

function rulesForm() {



	 $frmActividades =	 $("#frmTiposCasos").each(function() {
	      $(this).validate({
	
	rules : {
		nombreTipoCaso : {
			required : true
		}
	},

	// Messages for form validation
	messages : {
		nombreTipoCaso : {
			required : 'El nombre del tipo de caso es requerido.'
		}
		
	},

	// Do not change code below
	errorPlacement : function(error, element) {
		error.insertAfter(element.parent());
	}
	});
	 });
	 
	
}

function existNameActividad(){
	var data_caso ="nombre="+$("#nombreTipoCaso").val();
	 data_caso +="&_csrf=" + $("#_csrf").val();
	$.ajax({
	     type : "POST",
		  dataType: "json",
		  url: contexto + "/maestroTipoCaso/existNameTipoCaso",
		  data: data_caso,
		  success: function (res) {
			  if(res.STATUS =="SUCCESS"){
				  $("#messageErrorModal").html("No se puede guardar el tipo de caso, ya existe un tipo de caso con el mismo nombre.")
				  $("#messageErrorModal").show(); 
				  
				  
			  }else{
				  doAjaxPostAdd();
			  }
		  }
		 
	});
}

function guardar(){
	$("#messageErrorModal").hide();
	if (nuevo){
		existNameActividad();
	}else{
		doAjaxPostAdd();
	}
}

function doAjaxPostAdd() {
	
	$("#messageError").hide();
	$("#messageErrorModal").hide();
	
	if ($("#frmTiposCasos").valid()) {
		var data_tipoCaso = "_csrf=" + $("#_csrf").val();
		data_tipoCaso += "&nombre="+$("#nombreTipoCaso").val()+"&activo=S";
		
		if (codigoTipoCaso!=-1){
			data_tipoCaso += "&codigo="+codigoTipoCaso;
		}
		
		var count=0;
		$('#actividadTipoCaso :selected').each( function( i, selected ) {
		 	 data_tipoCaso+="&actividadTipoCasoList["+i+"].cdactividad.cdactividad="+$(selected).val();
		 	count++;
		 	 if (codigoTipoCaso!=-1){
		 		data_tipoCaso += "&tareaActividadList[" + i + "].cdtipocaso.codigo="
				+ codigoTipoCaso;
			}
		}); 
		
		if (count>0){
		
		$.ajax({
			type : "POST",
			url : contexto + "/maestroTipoCaso/guardarTipoCaso",
			//data : $("#idFormulario").serialize(),
			data : data_tipoCaso ,
			dataType : "json",
			success : function(res) {
				if(res.STATUS =="SUCCESS"){
					$("#modal-actualizarTipoCaso").modal("hide");
					  $("#messageExitoso").html("Se guardó el tipo de caso exitosamente.")
					  $("#messageExitoso").show(); 
					  codigoTipoCaso=-1;
					  mostrarTablaTipoCaso();
					  setTimeout("limpiarMensajeExito();",10000);
					}else{
						$("#modal-actualizarTipoCaso").modal("hide");
						$("#messageError").html("No se pudo guardar el tipo de caso.")
						  $("#messageError").show(); 
						  setTimeout("limpiarMensajeError();",10000);
					}
				
			}
		});
	}else{
		$("#messageErrorModal").html("Debe adicionar al menos una actividad al tipo de caso.")
		  $("#messageErrorModal").show();
	}
	}
	
}

function doAjaxPostUpdate() {
	
	
//	cdtareaactividad
	var data_actividad = "_csrf=" + $("#_csrf").val();
	data_actividad += "&dsactividad="+$("#nombreActividad").val();
	data_actividad += "&dsdetalle="+$("#nombreActividad").val();
	data_actividad += "&cdactividad="+$("#codigoActividad").val();
	data_actividad += "&isactivo="+"S";
	
	if( $("[name = nombreTarea]").length == 1){
		for(var i=0; i< $("[name = nombreTarea]").length; i++)
		{
			data_actividad+="&tareaActividadList["+i+"].dsdetalle="+$('#nombreTarea')[i].value;
		}
		for(var i=0; i< $("[name = codigoTarea]").length; i++)
		{
			data_actividad+="&tareaActividadList["+i+"].cdtarea.cdtarea="+$('#codigoTarea')[i].value;
			data_actividad+="&tareaActividadList["+i+"].cdtarea.cdtarea="+$('#codigoTareaActividad')[i].value;
			
		}
		for(var i=0; i< $("[name = codigoTareaActividad]").length; i++)
		{
			data_actividad+="&tareaActividadList["+i+"].cdtareaactividad="+$('#codigoTareaActividad')[i].value;
			
		}
	}else{
		for(var i=0; i< $("[name = nombreTarea]").length; i++)
		{
			data_actividad+="&tareaActividadList["+i+"].dsdetalle="+nombreTarea[i].value;
		}
		for(var i=0; i< $("[name = codigoTarea]").length; i++)
		{
			data_actividad+="&tareaActividadList["+i+"].cdtarea.cdtarea="+codigoTarea[i].value;
		}
		for(var i=0; i< $("[name = codigoTareaActividad]").length; i++)
		{
			data_actividad+="&tareaActividadList["+i+"].cdtareaactividad="+codigoTareaActividad[i].value;
		}
	}
	if( $("[name = detalleTarea]").length == 1){	
		for(var i=0; i< $("[name = detalleTarea]").length; i++)
		{
			data_actividad+=	"&tareaActividadList["+i+"].cdtarea.dstarea="+$('#detalleTarea')[i].value;
		}
	}else{
		for(var i=0; i< $("[name = detalleTarea]").length; i++)
		{
			data_actividad+="&tareaActividadList["+i+"].cdtarea.dstarea="+detalleTarea[i].value;
		}
	}
	
	
	
	$.ajax({
		type : "POST",
		url : contexto + "/maestroActividad/guardarActividad",
		//data : $("#idFormulario").serialize(),
		data : data_actividad ,
		dataType : "json",
		success : function(response) {
		
		}
	});
	
}

function mostrarCampoTarea(boton)
{
	$('#campoTarea').show();
	$("#adicionarTareaPrincipal").hide(); 
}

function clonarCampoTarea(boton)
{
		var nuevasActividades = boton.parentNode.parentNode;
		var object = nuevasActividades.cloneNode(true);		
		var boton = object.getElementsByTagName('a')[0];
		boton.setAttribute("class", "fa fa-minus-square");
		boton.onclick = function borrarFormulario() {
			nuevasActividades.parentNode.removeChild(this.parentNode.parentNode);
		};
		nuevasActividades.parentNode.appendChild(object);	
}




function eliminarTareaSeguro(){

	eliminarDiv(idEliminar);
	var data_caso ="cdtarea="+codigoTarea;
	 data_caso +="&_csrf=" + $("#_csrf").val();
	$.ajax({
	     type : "POST",
		  dataType: "json",
		  url: contexto + "/maestroActividad/eliminarTarea",
		  data: data_caso,
		  success: function (res) {
			  		if(res.STATUS =="SUCCESS"){
			  		
				};
		 }
	});

	
	
}

function eliminarTipoCasoSeguro(){
	var data_caso ="codigo="+codigoTipoCaso;
	 data_caso +="&_csrf=" + $("#_csrf").val();
	$.ajax({
	     type : "POST",
		  dataType: "json",
		  url: contexto + "/maestroTipoCaso/eliminarTipoCaso",
		  data: data_caso,
		  success: function (res) {
			  if(res.STATUS =="SUCCESS"){
				  $("#messageExitoso").html("Se eliminó el tipo de caso exitosamente.")
				  $("#messageExitoso").show(); 
				  mostrarTablaTipoCaso();
				  setTimeout("limpiarMensajeExito();",10000);
				}else{
					$("#messageError").html("No se pudo eliminar el tipo de caso.")
					  $("#messageError").show(); 
					mostrarTablaTipoCaso();
					  setTimeout("limpiarMensajeError();",10000);
				}
			  ;
			 
		 }
	});
}

function eliminarDiv(div)
{
var o = document.getElementById(div);
o.parentNode.removeChild(o);
}
function eliminarTarea(boton){
	codigoTarea=boton.parentNode.parentNode.children[0].children[2].value;
	eventoBoton = boton;
	if(casoActividad==true){
		$("#modal-NoEliminarTarea").modal("show");
	
	}else if(casoActividad==false){
		$("#modal-EliminarTarea").modal("show");
			codigoActividad =codigoTarea;
			idEliminar=boton.parentNode.parentNode.id;
	}
}

function mostrarModalNuvoTipoCaso(){
	nuevo=true;
	$("#modal-actualizarTipoCaso").modal("show"); 
	limpiarModal();
}




 function limpiarCampos(){
	  $("#detalleTarea").val(""); 
	  $("#nombreTarea").val("");
	  $("#nombreActividad").val("");
	  $("#codigoActividad").val("");
	  $("#codigoTarea").val("");
	  $("#codigoTareaActividad").val("");
	  
 }
 
 function limpiarModal(){
	 $("#nombreTipoCaso").val("");
	 $("#messageExitosoModal").hide();
	  $("#messageErrorModal").hide();
	 codigoTipoCaso=-1;
	 $("#actividadTipoCaso").val('').trigger("chosen:updated");
 }
 
 function mostrarAsociarTipoCaso(){
	 $("#modal-asociarActividad").modal("show");
	 cargarActividades("listaActividades"); 
	 cargarTipoCaso('listaTipoCaso');
 }
 
 function limpiarMensajeError(){
	 $("#messageError").hide();
 }
 
 function limpiarMensajeExito(){
	 $("#messageExitoso").hide();
 }
 
 function canIsDeleteTipoCaso(codigo){
		var data_caso ="codigo="+codigo;
		 data_caso +="&_csrf=" + $("#_csrf").val();
		$.ajax({
		     type : "POST",
			  dataType: "json",
			  url: contexto + "/caso/canIsDeleteTipoCaso",
			  data: data_caso,
			  success: function (res) {
				  if(res.STATUS =="SUCCESS"){
					  $("#modal-EliminarTipoCaso").modal("show"); 
				  }else{
					  $("#messageError").html("No se puede eliminar el tipo de caso, ya se encuentra asociado a uno o varios casos.")
					  $("#messageError").show(); 
					  setTimeout("limpiarMensajeError();",10000);
				  }
			  }
			 
		});
	}

