
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
	
	console.log(atual)
	
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
	
	console.log(dados.dataset.corPele)
	
	
		// rosto.getSVGDocument().querySelectorAll("path")[1].setAttribute("fill", event.target.value);
	
})