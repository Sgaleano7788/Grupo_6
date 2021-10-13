$(document).ready(function(){
 
  listarClientes();

function listarClientes(){
	$.ajax({
		type:"post",
		url:"ReporteVentas",
		dataType:"json",
		success:function(result){
			console.log(result)

var tabla=document.querySelector("#ListaVentas");
var total=0;
			tabla.innerHTML=''
			tabla.innerHTML+=`<tr>
			<th><b><FONT COLOR="black">CEDULA</FONT></b></th>
			<th><b><FONT COLOR="black">NOMBRE</FONT></b></th>
			<th><b><FONT COLOR="black">VALOR TOTAL VENTAS</FONT></b></th>

			</tr>`
			for(let venta of result){
				total= total+venta.TotalVentas;
				tabla.innerHTML+=`<tr>
				<td>${venta.cedula}</td>
				<td>${venta.Nombre}</td>
			    <td>${venta.TotalVentas}</td>
				<tr>`
			}

			tabla.innerHTML+=`<tr>
			  <td></td>
			  <td><b><FONT COLOR="black">Total ventas:</FONT></b></td>
	          <td><b><FONT COLOR="black">$ ${total}</FONT></b></td>
	           <tr>`
			
		}
		
	})
}	

});