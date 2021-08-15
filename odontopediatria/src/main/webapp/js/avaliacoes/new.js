
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
	idMedico: 0,
	genero: "m"
}


const expressoes = {
	triste: {
		sobrancelha: 4,
	},
	feliz: {
		boca: 5,
	},	
	raiva: {
		sobrancelha: 3,
		boca: 2,
		olho: 3,
	},
	chateado: {
		sobrancelha: 5,
		boca: 3,
	},
	animado: {
		olho: 4,
		boca: 6,
	}, 
	normal: {
		
	}
}

function getRandomInt(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min)) + min;
}

function gerarExpressoes() {
	const used = []
	for(let i = 1; i <= 4; i++) {
		const div = document.getElementById(`expressao${i}`)
		const expressoesArray= Object.entries(expressoes);

		let selecionado = getRandomInt(0, expressoesArray.length);
		while(used.includes(selecionado)) {
			selecionado = getRandomInt(0, expressoesArray.length);
		}
		used.push(selecionado)
		
		div.dataset.expressao = expressoesArray[selecionado][0];
		
		div.innerHTML = "";
		
		desenharAvatar(merge(atual, expressoesArray[selecionado][1]), div);		
	}
}

let selected = "";
let total = 0;

function selecionar(index) {
	const el = document.getElementById("expressoes")
	selected += `${index.dataset.expressao}&`
	el.value = selected;
	total += 1;
	if(total >= 5) {
		document.getElementById("avaliacao").submit();
		return;
	}
	gerarExpressoes();
}

function merge(obj1,obj2){
    var obj3 = {};
    for (var attrname in obj1) { obj3[attrname] = obj1[attrname]; }
    for (var attrname in obj2) { obj3[attrname] = obj2[attrname]; }
    return obj3;
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
	atual.idMedico = dados.dataset.idMedico;
	atual.genero = dados.dataset.genero;
		
	const avatar = document.getElementById('avatar');
	
	desenharAvatar(atual, avatar)
	
	gerarExpressoes();
})