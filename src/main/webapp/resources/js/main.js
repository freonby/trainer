function pingSession(){
	$.ajax({
		url : 'closeSession',
		data : ({
			optionClose : "close"

		}),

	});
	
}

function doCheckPartitions() {
	$.ajax({
		url : 'checkoption',
		data : ({
			option : $('#partition').val()
		}),
		success : function(data) {
			var json = JSON.parse(data);
			$('#theme').empty();
			for (var i = 0; i < json.length; i++) {
				$('#theme').append("<option>" + json[i] + "</option>");
			}

		}
	});
};
$(window).unload(function() {
	
	$.ajax({
		url : 'closeSession',
		data : ({
			optionClose : "close"

		}),
		
	});
});
function doOnLoad() {

	$.ajax({
		url : 'check',
		data : ({
			param : "start"

		}),
		success : function(data) {
			var json = JSON.parse(data);
			$("#questionIndex").html(json[0]);
			$("#question").html(json[1]);
			for (var i = 1; i < 5; i++) {
				$("#radio" + i).val(json[i + 1]);
				$("#answ" + i).html(json[i + 1]);
			}
			$("#alert").removeClass();
			$("#alert").addClass(json[6]);
			$("#alert").css("display", json[7]);
			$("#cause").html(json[8]);
			$("#alertMessage").html(json[9]);
			$("#description").html(json[10]);
		}
	});
	
	
}
$(document).ready(function() {

	$("#prev").click(function() {

		$.ajax({
			url : 'check',
			data : ({
				param : "prev"

			}),
			success : function(data) {
				var json = JSON.parse(data);
				$("#questionIndex").html(json[0]);
				$("#question").html(json[1]);

				for (var i = 1; i < 5; i++) {
					$("#radio" + i).val(json[i + 1]);
					$("#answ" + i).html(json[i + 1]);
				}
				$("#alert").removeClass();
				$("#alert").addClass(json[6]);
				$("#alert").css("display", json[7]);
				$("#cause").html(json[8]);
				$("#alertMessage").html(json[9]);
				$("#description").html(json[10]);
				$('input[name=optionsRadios]:checked').prop("checked", false);
			}
		});
	});
	$("#next").click(function() {

		$.ajax({
			url : 'check',
			data : ({
				param : "next"

			}),
			success : function(data) {
				var json = JSON.parse(data);
				$("#questionIndex").html(json[0]);
				$("#question").html(json[1]);

				for (var i = 1; i < 5; i++) {
					$("#radio" + i).val(json[i + 1]);
					$("#answ" + i).html(json[i + 1]);
				}
				$("#alert").removeClass();
				$("#alert").addClass(json[6]);
				$("#alert").css("display", json[7]);
				$("#cause").html(json[8]);
				$("#alertMessage").html(json[9]);
				$("#description").html(json[10]);
				$('input[name=optionsRadios]:checked').prop("checked", false);
			}
		});
	});
});

$(document).ready(function() {
	var value;
	$('input[name=optionsRadios]').change(function() {
		$("#answer").removeClass();
		$("#answer").addClass("btn btn-lg btn-info");
		value = $('input[name=optionsRadios]:checked').val();

	});
	$("#answer").click(function() {
		$("#answer").removeClass();
		$("#answer").addClass("btn btn-lg btn-default");
		$.ajax({
			url : 'check',
			data : ({
				param : value

			}),
			success : function(data) {
				var json = JSON.parse(data);
				$("#questionIndex").html(json[0]);
				$("#question").html(json[1]);

				for (var i = 1; i < 5; i++) {
					$("#radio" + i).val(json[i + 1]);
					$("#answ" + i).html(json[i + 1]);
				}
				$("#alert").removeClass();
				$("#alert").addClass(json[6]);
				$("#alert").css("display", json[7]);
				$("#cause").html(json[8]);
				$("#alertMessage").html(json[9]);
				$("#description").html(json[10]);
				$('input[name=optionsRadios]:checked').prop("checked", false);
			}
		});
	});
});
