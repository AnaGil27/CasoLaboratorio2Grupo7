$(document).on("click", "#btnagregar", function(){
	$("#txtingreso_Usu").val("");
	$("#txtcurso").val("");
	$("#hddidregistrocurso").val("0");
	$("#txtcentro_estudios").val("");
	$("#txtfecha_inicio").val("");
	$("#txtfecha_fin").val("");
	$("#modalSala").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtdescripcion").val($(this).attr("data-descsala"));
	$("#txtnroasientos").val($(this).attr("data-asientos"));
	$("#hddidregistrosala").val($(this).attr("data-idsala"));
	$("#cboestado").empty();
	var idcurso = $(this).attr("data-idcurso");
	$("#modalCurso").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/curso/registrarCurso",
		contentType: "application/json",
		data: JSON.stringify({
			idcurso: $("#txtcurso").val(),
			ingreso_Usu: $("#txtingreso_Usu").val(),
			curso: $("#txtcurso").val(),
			centro_estudios: $("#txtcentro_estudios").val(),
			centro_estudios: $("#txtfecha_inicio").val(),
			centro_estudios: $("#txtfecha_fin").val(),
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarCurso();
		}
	});
	$("#modalCurso").modal("hide");
})

$(document).on("click", ".btneliminarcurso", function(){
	$("#hddideliminarsala").val("");
	$("#hddideliminarsala").val($(this).attr("data-idsala"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-descsala")+"?");
	$("#modalEliminarSala").modal("show");
})

function ListarSala(){
	$.ajax({
		type: "GET",
		url: "/curso/listarCursos",
		dataType: "json",
		success: function(resultado){
			$("#tblcurso > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcurso > tbody").append("<tr>"+
						"<td>"+value.idcurso+"</td>"+
						"<td>"+value.ingreso_Usu+"</td>"+
						"<td>"+value.curso+"</td>"+
						"<td>"+value.centro_estudios+"</td>"+
						"<td>"+value.fecha_inicio+"</td>"+
						"<td>"+value.fecha_fin+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-idcurso='"+value.idsala+"'"+
							" data-ingreso_Usu='"+value.ingreso_Usu+"'"+
							" data-curso='"+value.curso+"'"+
							" data-centro_estudios='"+value.centro_estudios+"'"+
							" data-fecha_inicio='"+value.fecha_inicio+"'"+
							" data-fecha_fin='"+value.fecha_fin+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarcurso'"+	
							" data-idsala='"+value.idcurso+"'"+
							" data-curso='"+value.curso+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}





