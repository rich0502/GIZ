$(function () {

	var idioma = {
		"sProcessing": "Procesando...",
		"sLengthMenu": "Mostrar _MENU_ entries",
		"sZeroRecords": "No se encontraron resultados",
		"sEmptyTable": "No data available in table",
		"sInfo": "Showing  _START_ to _END_ of _TOTAL_ entries",
		"sInfoEmpty": "Showing  0 to 0 of 0 entries",
		"sInfoFiltered": "(filter of _MAX_ entries)",
		"sInfoPostFix": "",
		"sSearch": "Search :",
		"sUrl": "",
		"sInfoThousands": ",",
		"sLoadingRecords": "Cargando...",
		"oPaginate": {
			"sFirst": "Primero",
			"sLast": "Ãšltimo",
			"sNext": "Next",
			"sPrevious": "Previous"
		},
		"oAria": {
			"sSortAscending": ": Activar para ordenar la columna de manera ascendente",
			"sSortDescending": ": Activar para ordenar la columna de manera descendente"
		},
		"buttons": {
			"copyTitle": 'Information de copie',
			"copyKeys": 'Use your keyboard or menu to select the copy command',
			"copySuccess": {
				"_": '%d fichiers sont copiés sur un autre fichier',
				"1": '1 fila copiada al portapapeles'
			},

			"pageLength": {
				"_": "Show %d",
				"-1": "All"
			}
		}
	};
	
	var today = new Date();
	var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
	var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
	var dateTime = date+' '+time;

	$(document).ready(function () {

		var table = $('#ejemplo').DataTable({

			"paging": true,
			"lengthChange": true,
			"searching": true,
			"ordering": false,
			"info": true,
			"autoWidth": true,
			"language": idioma,
			"lengthMenu": [[25, 50, -1], [25, 50, "All"]],
			dom: 'Bfrt<"col-md-12 inline"i> <"col-md-12 inline"p>',

			buttons: {
				dom: {
					container: {
						tag: 'div',
						className: 'flexcontent btn-row'
					},
					buttonLiner: {
						tag: null
					}
				},

				buttons: [

					{
						extend: 'excelHtml5',
						text: 'Excel',
						title: 'Tableau de capitalisation' + ' ' + dateTime,
						titleAttr: 'Export',
						className: 'small gbtn export excel',
						/*
						 * exportOptions: { columns: [0, 1] },
						 */
					},

					{
						extend: 'pageLength',
						titleAttr: 'Registros a mostrar',
						className: 'selectTable'
					}]
			}
		});
	});

});