<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html" charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<header>
		<h1>Chat API</h1>
		<menu>
			<menu-item><c:out value="${sessionScope.username}"/></menu-item>
			<menu-item><a href="./disconnect">Disconnect</a></menu-item>
		</menu>
	</header>
	<aside>
		<article>Liste des canaux</article>
	</aside>
	<section>
		<form method="post" action="chat">
			<p>
				<textarea>
<c:forEach items="${requestScope.messages}" var="message">
<c:out value="${message.username}" /> <c:out value="${message.creationDate}" />
<c:out value="${message.content}"/>
</c:forEach>
				</textarea>
			<p><input type="text" name="message"/></p>
			<p><input type="submit" value="Send" /></p>
		</form>
	</section>
	<footer> </footer>
</body>
</html>