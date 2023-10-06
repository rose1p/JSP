<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL & EL</title>
</head>
<body>
	<c:set var="name" value="철수"/>
	<c:set var="age" value="20"/>
	
	<c:choose>
	<c:when test="${age >= 20}">
		<p>성인입니다.</p>
	</c:when>
	
	<c:otherwise>
        <p>성인이 아닙니다.</p>
    </c:otherwise>
	</c:choose>
	
	<p>이름 : ${name}</p>
	<p>나이 : ${age}</p>
	
	<%!
		String[] names = {"철수", "맹구", "훈이"};
		int[] ages = {19,20,23};
	%>
	<%
		request.setAttribute("names", names);
		request.setAttribute("ages", ages);
	%>
	<c:forEach var="i" begin="0" end="<%= names.length - 1 %>">
		<c:if test="${ages[i] >= 20}">
			<p>이름 : ${names[i]}</p>
			<p>나이 : ${ages[i]}</p>
		</c:if>
	</c:forEach>
	
	<%@ page import="java.util.HashMap" %>
	<%@ page import="java.util.Map" %>
	<%!
		Map<String, Integer> people = new HashMap<>();
		{
			people.put("철수", 19);
			people.put("맹구", 20);
			people.put("훈이", 23);
			people.put("짱구", 22);
		}
	%>
	<%
		request.setAttribute("people", people);
	%>
	<c:forEach var="entry" items="${people.entrySet()}">
		<c:if test="${entry.value >= 20}">
			<p>${entry.key}, ${entry.value}</p>
		</c:if>
	</c:forEach>
</body>
</html>