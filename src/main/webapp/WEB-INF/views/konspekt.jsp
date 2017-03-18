<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Begin page content -->
<script type="text/javascript">
	$("body").removeClass("bg_custom");
</script>

<div class="container wrapper">

	<div class="page-header">
		<h3 class="text-warning">${partitionName}</h3>
		<p class="lead text-warning">Раздел: ${themeName}</p>
		<p class="lead">Вопросов: ${countQuestions}</p>
	</div>
	<div>
		<div class="panel panel-warning fixed_heading">
			<div class="panel-heading">
				<h3 class="panel-title">
					Вопрос:<span id="questionIndex"></span>
				</h3>
			</div>
			<div id="question" class="panel-body"></div>
		</div>
	</div>
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">Ответ</h3>
		</div>
		<div id="pan" class="panel-body fixed_panel">
			<p id="answ"></p>
		</div>
	</div>
	<script type="text/javascript">
		doOnLoad();
	</script>
	<div id="test" class="row">&nbsp;</div>

	<div class="row">
		<div class="col-md-4 col-sm-12">
			<button id="prev" type="button" class="btn btn-lg btn-default">
				<span class="glyphicon glyphicon-arrow-left"></span>
			</button>
			<button id="next" type="button" class="btn btn-lg btn-default">
				<span class="glyphicon glyphicon-arrow-right"></span>
			</button>
		</div>
	</div>
	<div class="row alert_margin">
		<div class="col-md-12 col-sm-12">
			<div id="alert" role="alert">
				<strong id="cause"></strong><span id="alertMessage"></span>
			</div>
		</div>
	</div>

	<div class="well well_margin">
		<p>
			Нормативная документация: <span id="description"></span>
		</p>
	</div>
</div>



