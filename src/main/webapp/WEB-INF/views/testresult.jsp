<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp" />
<h1 style="text-align: center;margin-top:200px;">SUCCESS PAGE!</h1>
<a href="${flowExecutionUrl}&_eventId=beginPage" type="button"
	class="btn btn-lg btn-success"> <span
	class="glyphicon glyphicon-ban-circle"></span>
</a>
<c:import url="footer.jsp" />