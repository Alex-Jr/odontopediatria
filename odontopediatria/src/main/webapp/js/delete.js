function deletar(elemento) {
	//if(!window.confirm("Tem certeza que deseja deletar?")) return;
	
	let pai = elemento.parentElement;
	
	let vo = pai.parentElement;
	
	let id = vo.firstElementChild.innerText;
	console.log(id);
	
	const xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4) {
			switch(this.status) {
				case 200:
				alert('Paciente deletado com sucesso!')
				window.location.assign("/odontopediatria/views/pacientes");
				break;
				case 403:
				alert('Não autorizado');
				logout();
				break;
			}
		}
 	};

	xhttp.open("DELETE", `/odontopediatria/pacientes`, true);	
	
	const bodyRequest = `id=${id}`; 
	  
	xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
	console.log(bodyRequest)
	xhttp.send(bodyRequest);
	
}