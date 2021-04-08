$("#sc").change(
				function() {
					var sc = $(this).val();
					console.log(sc);

					$.ajax({
						type : 'GET',
						url : "./dropdownlist/" + sc,
						success : function(data) {
							var slctSubcat = $('#theme'), option = "";
							slctSubcat.empty();
							option = option
							+ "<option value='null'>Sélectionner le canevas</option>";
							for (var i = 0; i < data.length; i++) {
								option = option
										+ "<option value='"+data[i][2]+ "'>"
										+ data[i][1] + "</option>";
							}
							slctSubcat.append(option);
						},
						error : function() {
							alert("error");
						}

					});
				});
$(document).ready(function() {
	var maxLength = 85;
	$('select > option').text(function(i, text) {
		if (text.length > maxLength) {
			return text.substr(0, maxLength) + '...';
		}
	});
});