<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Вопросы и ответы для аттестации ГИП, Главспец, Главный инженер, Прораб в Беларуси">
<meta name="author" content="Q-lab">
<meta name="yandex-verification" content="69be0d4201bbb0e7" />
<link rel="icon" href="resources/icons/favicon.ico">
<title>Q-lab: Эффективные программы</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="resources/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="resources/js/ie10-viewport-bug-workaround.js"></script>
<script src="resources/js/main.js"></script>

</head>

<body class="bg_custom">

	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="http://q-lab.by">Q-lab</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
						<li class="active"><a href="menu">Выбрать раздел</a></li>
					</sec:authorize>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
						<li class="active"><a href="login">Вход<span
								class="glyphicon glyphicon-log-in menu-margin-span"></span></a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_USER')">
						<li><a href="#">Личный кабинет</a></li>
						<li><a href="logout">Выход<span
								class="glyphicon glyphicon-log-out menu-margin-span"></span></a></li>
						
					</sec:authorize>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	