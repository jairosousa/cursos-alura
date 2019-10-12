<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<body>
		<c:if test="${not empty empresa}">
			Empresa <strong> ${ empresa } </strong>cadastrada com sucesso!!!
		</c:if>
		
		<c:if test="${empty empresa}">
			Nenhuma empresa cadastrada!
		</c:if>
		
		<!-- Teste -->
		<br/>
		<br/>
		<c:forEach var="i" begin="1" end="10" step="2">
			${i} <br/>
		</c:forEach>
	
	</body>
</html>