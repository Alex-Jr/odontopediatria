function update() {   
 	if(!window.confirm("Tem certeza que deseja atualizar?")) return;

	const xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4) {
			switch(this.status) {
				case 200:
				window.location.assign("/odontopediatria/views/medicos");
				break;
				case 403:
				alert('Não autorizado');
				logout();
				break;
			}
		}
 	};
 	
 	//id=1&nome=caio&datanasc=&

	xhttp.open("PUT", `/odontopediatria/medicos`, true);

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