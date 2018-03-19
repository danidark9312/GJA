function mostrarTabla(){
	
	var data_decode = "_csrf=" + $("#_csrf").val();
	if ($("#cmbEstadoCaso").val()!=null ){
		
		data_decode += "&estadoCaso=" + $("#cmbEstadoCaso").val();
		}
	if ($("#cmbTipoDeCaso").val()!=null ){
		
		data_decode += "&tipoCaso=" + $("#cmbTipoDeCaso").val();
		}
	
	var tablaHtml="<table id='datatableCasos' class='table table-striped table-hover' >";
	tablaHtml+="	<thead>";
	tablaHtml+="<tr class='tr_titulo'>";
	tablaHtml+="<th >C&oacute;digo Caso</th>";
	tablaHtml+="<th >Nombre Caso</th>";
	tablaHtml+="<th >Estado del Caso</th>";
	tablaHtml+="<th >Tipo del Caso</th>";
	tablaHtml+="<th >Radicados</th>";
	tablaHtml+="<th >Equipo del caso</th>";
	tablaHtml+="<th >Tarea</th>";
	tablaHtml+="<th hidden='hidden'>&nbsp;</th>";
	tablaHtml+="<th hidden='hidden'>&nbsp;</th>";
	tablaHtml+="<th hidden='hidden'>&nbsp;</th>";
	tablaHtml+="</tr>";
	tablaHtml+="	</thead>";
	tablaHtml+="	<tbody>";
	tablaHtml+="</tbody>";
	tablaHtml+="</table>";
	$("#tablaListado").html(tablaHtml);
	oTable =$('#datatableCasos').dataTable({
		"bProcessing": true,
        "bServerSide": true,
        "bFilter":false,
        "sAjaxSource": contexto + "/caso/mostrarCasos?" + data_decode,
        "aaSorting": [[ 1, "asc" ]],
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
						{ "mDataProp": "codigo", "bSortable": false, "sWidth":"10%" },
						{ "mDataProp": "nombre","bSortable": false, "sWidth":"10%" },
						{ "mDataProp": "estadoCaso","bSortable": false, "sWidth":"10%" },
						{ "mDataProp": "tipoCaso","bSortable": false, "sWidth":"10%" },
						{ "mDataProp": "accion","bSortable": false, "sWidth":"10%" },
						{ "mDataProp": "accionEquipo","bSortable": false, "sWidth":"10%" },
						{ "mDataProp": "accionDetalleTarea","bSortable": false, "sWidth":"10%" },
						{ "mDataProp": "detalle", "bSortable": false, "sWidth":"10%", "bVisible": false},
						{ "mDataProp": "detalleEquipoCaso", "bSortable": false, "sWidth":"10%", "bVisible": false},
						{ "mDataProp": "detalleTarea", "bSortable": false, "sWidth":"10%", "bVisible": false}
						
					],
		"fnServerData": function ( sSource, aoData, fnCallback ) {
            $.ajax( {
                type: 'POST',
                url: contexto + "/caso/mostrarCasos?" + data_decode,
                data: aoData,
                success: fnCallback,
                error : function (e) {
                    alert (e);
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
       	$.each($("[name = verDetalleTarea]"), function (index, optionData) {
      		 optionData.onclick = function () {
      			 var tr = optionData.parentNode.parentNode.parentNode;
      			 if (oTable.fnIsOpen(tr)) {
      		        oTable.fnClose(tr);
      		        optionData.firstChild.removeAttribute('class', 'glyphicon glyphicon-chevron-up');
      		        optionData.firstChild.setAttribute("class", "glyphicon glyphicon-chevron-down");
      		      } else {
      		        oTable.fnOpen(tr, oTable.fnGetData(tr).detalleTarea, "info_row" );
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
    			$(this).find("td:lt(4)").on("click", function() {
    				
    				if (null != aData)  // null if we clicked on title row
    				{
    					  document.location.href="detalleCaso?codigo=" + aData.codigo;
    					    					
    				}   
    			});
    		});

    		
    		
    		
    		
        }
	
		
	});
	
	
//	oTable.on('click', 'tr', function () {
//			
//			var aData = oTable.fnGetData(this); // get datarow
//		    if (null != aData)  // null if we clicked on title row
//		    {
//		    	document.location.href="cliente?documento=" + aData.documento;
//		    }   
//	});
	
}

function limpiarFiltros() {
	$("#cmbTipoDeCaso").val("");
	$("#cmbEstadoCaso").val("");
	mostrarTabla();
}