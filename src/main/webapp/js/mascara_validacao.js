// JavaScript Document

//Contador de Caracteres 
function limite_textarea(valor){
	quant = 140;
	total = valor.length;
	if (total <= quant){
		resto = quant - total;
		document.getElementById('cont').innerHTML = resto;
	}else {
		document.getElementById('textarea').value = valor.substr(0,quant);
		}	
}



