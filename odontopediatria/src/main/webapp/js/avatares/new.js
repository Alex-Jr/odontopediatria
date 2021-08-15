
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