$(document).ready(function(){
 
  listarClientes();

function listarClientes(){
	$.ajax({
		type:"post",
		url:"ReporteClientes",
		dataType:"json",
		success:function(result){
			console.log(result)
			var tabla=document.querySelector("#ListaClientes");
			tabla.innerHTML=''
			tabla.innerHTML+=`<tr>
			<th><b><FONT COLOR="black">CEDULA</FONT></b></th>
			<th><b><FONT COLOR="black">NOMBRE</FONT></b></th>
			<th><b><FONT COLOR="black">EMAIL</FONT></b></th>
			<th><b><FONT COLOR="black">TELEFONO</FONT></b></th>
			<th><b><FONT COLOR="black">DIRECCION</FONT></b></th>
			</tr>`
			for(let cliente of result){
				tabla.innerHTML+=`<tr>
				<td>${cliente.cedula}</td>
				<td>${cliente.nombre}</td>
			    <td>${cliente.email}</td>
				<td>${cliente.telefono}</td>
			    <td>${cliente.direccion}</td>
				<tr>`
			}
			
		}
		
	})
}	

});