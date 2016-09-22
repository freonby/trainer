<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Begin page content -->
<div class="container bg_menu">

	<form class="form-menu" action="start" method="GET">
		<h4>Раздел:</h4>
		<select id="partition" name="partition" class="form-control input-sm"
			onselect="doCheckPartitions()" onchange="doCheckPartitions()">
			<c:forEach var="partition" items="${partitionList}">
				<option>${partition.name}</option>
			</c:forEach>
		</select>
		<h4>Тема:</h4>
		<select id="theme" name="theme" class="form-control input-sm">
		</select>
		<button class="btn btn-lg btn-success btn-block" type="submit">Начать
			тест</button>
	</form>
	<script type="text/javascript">
		$('#partition').select();
	</script>
</div>
<!-- /container -->

