<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Begin page content -->
<div class="container">
<h1>Вопросы для аттестации специалистов в строительстве</h1>
	<form class="form-menu" action="start" method="GET">
		<h4>Раздел:</h4>
		<select id="partition" name="partition" class="form-control"
			onselect="doCheckPartitions()" onchange="doCheckPartitions()">
			<c:forEach var="partition" items="${partitionList}">
				<option>${partition.name}</option>

			</c:forEach>
		</select>
		<h4>Тема:</h4>
		<select id="theme" name="theme" class="form-control">
		</select>
		<button class="btn btn-lg btn-danger btn-block" type="submit">Начать</button>
	</form>
	<script type="text/javascript">
		$('#partition').select();
	</script>
</div>
<!-- /container -->

