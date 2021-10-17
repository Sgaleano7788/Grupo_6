$(document).ready(function(){
 
  listarUsuarios();

function listarUsuarios(){
	$.ajax({
		type:"post",
		url:"ReporteUsuarios",
		dataType:"json",
		success:function(result){
			console.log(result)
			var tabla=document.querySelector("#ListaUsuarios");
			tabla.innerHTML=''
			tabla.innerHTML+=`<tr>
			<th><b><FONT COLOR="black">CEDULA</FONT></b></th>
			<th><b><FONT COLOR="black">NOMBRE</FONT></b></th>
			<th><b><FONT COLOR="black">EMAIL</FONT></b></th>
			<th><b><FONT COLOR="black">PASSWORD</FONT></b></th>
			</tr>`
			for(let usuario of result){
				tabla.innerHTML+=`<tr>
				<td>${usuario.Cedula}</td>
				<td>${usuario.Nombre}</td>
			    <td>${usuario.Email}</td>
				<td>${usuario.Password}</td>
				<tr>`
			}
		}
		
	})
}	

});