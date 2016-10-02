<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Begin page content -->
<div class="container">
	<div class="page-header">
		<h3>Раздел: ${partitionName}</h3>
		<p class="lead">Тема: ${themeName}</p>
		<p class="lead">Вопросов: ${countQuestions}</p>
	</div>
	<div class="page-header">
		<div class="panel panel-info fixed_heading">
			<div class="panel-heading">
				<h3 class="panel-title">
					Вопрос:<span id="questionIndex"></span>
				</h3>
			</div>
			<div id="question" class="panel-body"></div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Выберите вариант ответа</h3>
				</div>

				<div id="pan" class="panel-body fixed_panel">

					<div class="radio">
						<label><input id="radio1" type="radio"
							name="optionsRadios" value=""><span id="answ1"></span></label>
					</div>
					<div class="radio">
						<label><input id="radio2" type="radio"
							name="optionsRadios" value=""><span id="answ2"></span></label>
					</div>
					<div class="radio">
						<label><input id="radio3" type="radio"
							name="optionsRadios" value=""><span id="answ3"></span></label>
					</div>
					<div class="radio">
						<label><input id="radio4" type="radio"
							name="optionsRadios" value=""><span id="answ4"></span></label>
					</div>

				</div>

			</div>
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
			<button id="answer" type="button" class="btn btn-lg btn-info">
				<span class="glyphicon glyphicon-retweet"></span>
			</button>
			<a href="${flowExecutionUrl}&_eventId=exitPage"  type="button" class="btn btn-lg btn-success">
				<span class="glyphicon glyphicon-ban-circle"></span>
			</a>
			
			
		</div>
	</div>
</div>
<div class="container">
	<div id="alert" role="alert">
		<strong id="cause"></strong><span id="alertMessage"></span>
	</div>
	<div class="well">
		<p>
			Нормативная документация: <span id="description"></span>
		</p>
	</div>

</div>

