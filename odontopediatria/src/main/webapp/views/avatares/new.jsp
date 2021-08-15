<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/odontopediatria/js/avatares/desenharAvatar.js"></script>
<script src="/odontopediatria/js/avatares/new.js"></script>
<title>Novo avatar</title>
</head>
<body>
	<h2>Criar - Avatar</h2>
	
	<% 
		String id = request.getParameter("idPaciente");
	%>
	<div id="avatar" style="width:500px;height:500px;position:relative">
	</div>
	<!--  https://avatarmaker.com/ -->
	<form action="/odontopediatria/avatares" method="POST">
		<input hidden="true" name="idPaciente" value="<%=id%>" />		
		
		</div>
		
		<label for="corPele"> Cor da pele </label>
		<input type="color" name="corPele" id="corPele"/>
		<br/><br/>

		<label for="corOlho"> Cor do olho </label>
		<input type="color" name="corOlho" id="corOlho"/>
		<br/><br/>
		
		<button type="button" onclick="update('rosto')">Trocar Rosto</button>
		<button type="button" onclick="update('boca')">Trocar Boca</button>
		<button type="button" onclick="update('nariz')">Trocar Nariz</button>
		<button type="button" onclick="update('cabelo')">Trocar Cabelo</button>
		<button type="button" onclick="update('olho')">Trocar Olho</button>
		<button type="button" onclick="update('orelha')">Trocar Orelha</button>
		<button type="button" onclick="update('sobrancelha')">Trocar Sobrancelha</button>
		<button type="button" onclick="update('roupa')">Trocar Roupa</button>
		
		<input hidden=true id="rostoInput" name="rosto" value="1"/>
		<input hidden=true id="bocaInput" name="boca" value="1"/>
		<input hidden=true id="narizInput" name="nariz" value="1"/>
		<input hidden=true id="cabeloInput" name="cabelo" value="1"/>
		<input hidden=true id="olhoInput" name="olho" value="1"/>
		<input hidden=true id="orelhaInput" name="orelha" value="1"/>
		<input hidden=true id="sobrancelhaInput" name="sobrancelha" value="1"/>
		<input hidden=true id="roupaInput" name="roupa" value="1"/>
		
		<button type="submit"> Salvar </button>
	</form>
</body>
</html>