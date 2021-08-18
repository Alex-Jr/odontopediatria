
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
	corOlho: "#000000",
	corPele: "#000000",
	genero: "m"
}

window.addEventListener('load', function() {
	const element = document.getElementById('avatar');

	const genero = document.getElementById('genero');
	atual.genero = genero.dataset.genero;
	console.log(atual);

	desenharAvatar(atual, element);

	const corOlhoInput = document.getElementById('corOlho');
	corOlhoInput.addEventListener('change', (event) => {
		mudaCorOlho(event)
		atual.corOlho = event.target.value;
	});

	const corPele = document.getElementById('corPele');
	corPele.addEventListener('change', (event) => {
		const rosto = document.getElementsByClassName('rosto')[0];
		const body = document.getElementsByClassName('pescoço')[0];

		// rosto.getSVGDocument().querySelectorAll("path")[1].setAttribute("fill", event.target.value);
	})
})