<%
	//scriptlet
	String nomeEmpresa = (String) request.getAttribute("empresa");
	System.out.println(nomeEmpresa);
%>

<html>
	<body>
		<span>Empresa <strong><%= nomeEmpresa %></strong> cadastrada com sucesso!</span>
	</body>
</html>