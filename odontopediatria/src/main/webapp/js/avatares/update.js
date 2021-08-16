
const atual = {
	orelha: 1,
	rosto: 1,
	olho: 1,
	sobrancelha: 1,
	boca: 1,
	nariz: 1,
	roupa: 1,
	cabelo: 1,
	pescoco: 1,
	corPele: "#000000",
	corOlho: "#000000",
	idAvatar: 0,
	idPaciente: 0,
	genero: 'm'
}



window.addEventListener('load', function () {

	const dados = document.getElementById('dados');
	
	atual.orelha=dados.dataset.orelha;
	atual.rosto=dados.dataset.rosto;
	atual.olho=dados.dataset.olho;
	atual.sobrancelha=dados.dataset.sobrancelha;
	atual.boca=dados.dataset.boca;
	atual.nariz=dados.dataset.nariz;
	atual.roupa=dados.dataset.roupa;
	atual.cabelo=dados.dataset.cabelo;
	atual.corPele = dados.dataset.corPele;
	atual.corOlho = dados.dataset.corOlho;
	atual.idAvatar = dados.dataset.idAvatar;
	atual.idPaciente = dados.dataset.idPaciente;
	atual.genero = dados.dataset.genero;

	
	const element = document.getElementById('avatar');
	
	desenharAvatar(atual, element);
	
	
	const corOlhoInput = document.getElementById('corOlho');
	corOlhoInput.addEventListener('change', (event) => {
		const olhos = document.getElementsByClassName('olho');	 
		
		for(olho of olhos){
			const svg = olho.getSVGDocument();
			svg.querySelectorAll("path")[1].setAttribute("fill", event.target.value)
		}
	});
	
	const corPele = document.getElementById('corPele');
	corPele.addEventListener('change', (event) => {
		const rosto = document.getElementsByClassName('rosto')[0];	 
		const body = document.getElementsByClassName('pescoço')[0];	 
		
		// rosto.getSVGDocument().querySelectorAll("path")[1].setAttribute("fill", event.target.value);
	})
})

function salvar() {   
 	if(!window.confirm("Tem certeza que deseja atualizar?")) return;

	const xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4) {
			switch(this.status) {
				case 200:
				window.location.assign("/odontopediatria/views/pacientes");
				break;
				case 403:
				alert('Não autorizado');
				logout();
				break;
			}
		}
 	};
 	
	xhttp.open("PUT", `/odontopediatria/avatares`, true);

	let bodyRequest = "";
	
	Object.entries(atual).forEach(([key, value]) => {
		bodyRequest += `${key}=${value}&`
	})
	
	console.log(bodyRequest)

	xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
	xhttp.send(bodyRequest);
	
}