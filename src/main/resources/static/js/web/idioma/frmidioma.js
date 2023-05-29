$(document).on("click", "#btnagregar", function(){
	
	$("#hddidregisNive").val("0");
	$("#txtnivel").val("");
});

$(document).on("click", ".btnactualizar", function(){	
	$("#hddidregisNivel").val($(this).attr("data-id_nivel"));
	$("#txtnivel").val($(this).attr("data-nivel"));
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/NivelIdioma/registrarNivelIdioma",
		contentType: "application/json",
		data: JSON.stringify({
			id_nivel: $("#hddidregisNivel").val(),
			nivel: $("#txtnivel").val(),
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarNivelIdioma();
		}
	});
	$("#modalNivel").modal("hide");
})

$(document).on("click", ".btnEliminarnivel", function(){
	$("#hddideliminarNivel").val("");
	$("#hddideliminarNivel").val($(this).attr("data-id_nivel"));
	$("#msjeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-nivel")+"?");
	$("#hddideliminarNivel").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/nivelidioma/eliminarNivelIdioma",
		data: JSON.stringify({
			id_nivel: $("#hddideliminarNivel").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarNivelIdioma();
		}
	})
	$("#modalEliminarNivel").modal("hide");
})

function ListarNivelIdioma(){
	$.ajax({
		type: "GET",
		url: "/NivelIdioma/listarNivelIdioma",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblnivel > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblnivel> tbody").append("<tr>"+
						"<td>"+value.id_nivel+"</td>"+
						"<td>"+value.nivel+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnActualizarnivel'"+
							" data-id_nivel='"+value.id_nivel+"'"+
							" data-nivel='"+value.nivel+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btnEliminarnivel'"+	
							" data-id_nivel='"+value.id_nivel+"'"+
							" data-nivel='"+value.nivel+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}





