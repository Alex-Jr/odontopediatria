function entrar(naguentomais) {   
 	const xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4) {
			switch(this.status) {
				case 200:
				//tipo=admin,nome=Pedro raposo,crm=00,id=1
				const params = this.responseText.split(",");

				if(this.responseText.length == 0) {
					alert("Usuario ou senha errados");		
					return;	
				}
				
				for(let i = 0; i < params.length; i++) {
					const param = params[i].split("=");
					document.cookie = `${param[0]}=${param[1]}; SameSite=Lax`;
				}
				// document.cookie = `user=${this.responseText}; SameSite=Lax`;
				window.location.assign(`/odontopediatria/views/${naguentomais}`);
				break;
				case 403:
				alert('Não autorizado');
				logout();
				break;
			}
		}
 	};

	xhttp.open("POST", `/odontopediatria/login`, true);

	let bodyRequest = "";
	
	const form = document.forms['formulario'];
	for (input of form) {
		if(!input.name) continue;
		console.log(input);
		bodyRequest += `${input.name}=${input.value}&`;
	}
	  
	xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
	xhttp.send(bodyRequest);
	
}