tiempo (600000);



function adicionarListener(codigo){
//	YAHOO.util.Event.addListener("s"+codigo, "click", YAHOO.example.container.dialog1.show, YAHOO.example.container.mensajefinalizarsesion, true);
//    YAHOO.util.Event.addListener("h"+codigo, "click", YAHOO.example.container.dialog1.hide, YAHOO.example.container.mensajefinalizarsesion, true);
}

function initDialog() {
	$("#modal-form").modal("show");
	
}


function ejecutarWindow2(){
//	YAHOO.example.container.mensajefinalizarsesion.show();
}



//YAHOO.util.Event.addListener(window, "load", initDialog);






// JavaScript Document
if( document.captureEvents ) {
//non IE
if( Event.CLICK || KEYDOWN) {
//NS 4, NS 6, Mozilla 0.9.x

document.captureEvents( Event.CLICK || Event.KEYDOWN);

// document.captureEvents( );
}
}
document.onclick = cronoreset;
document.onkeydown = cronoreset;
function cronoreset(){ resetTime (300000); }

function resetTime (dato){
  dato1=(dato*1)+(300000*1);
  clearTimeout(resetDeVentana);
  clearTimeout(resetDeSalir);
  
  resetDeVentana = setTimeout("abreVentana(1);",dato);
  resetDeSalir = setTimeout("salir();",dato1);
  
}

function tiempo(dato){
  dato1=(dato*1)-(300000*1);
  resetDeVentana = setTimeout("abreVentana(1);",dato1);
  resetDeSalir = setTimeout("salir();",dato);

  
}


function abreVentana(numero){
	$("#modal-finalizacionSesion").modal("show");
}

function salir(){

    document.location.href="j_spring_security_logout";
}
