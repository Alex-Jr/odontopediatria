const parteInfos = {
	orelha: {
		tamanho: { w: 80, h: 80 },
		posicao: { x: 110, y: 130, distance: 140 },
	},
	rosto: {
		tamanho: { w: 300, h: 300 },
		posicao: { x: 0, y: 0},
	},
	olho: {
		tamanho: { w: 80, h: 80 },
		posicao: { x: 110, y: 115, distance: 60},
	},
	sobrancelha: {
		tamanho: { w: 90, h: 90 },
		posicao: { x: 105, y: 95, distance: 70},
	},
	boca: {
		tamanho: { w: 90, h: 90 },
		posicao: { x: 105, y: 175},
	},
	nariz: {
		tamanho: { w: 85, h: 85 },
		posicao: { x: 106, y: 130},
	},
	roupa: {
		tamanho: { w: 300, h: 300 },
		posicao: { x: 0, y: 26},
	},
	cabelo: {
		tamanho: { w: 247, h: 247},
		posicao: { x: 28, y: 15},
	}
}

const cores = {
	pele: "",
	olho: "",
}


const atual = {
	orelha: 1,
	rosto: 1,
	olho: 1,
	sobrancelha: 1,
	boca: 1,
	nariz: 1,
	roupa: 1,
	cabelo: 1,
}

const max = { // isso poderia ser dinamico, mas pelo como é mvp está hardcoded
	orelha: 2,
	rosto: 2,
	olho: 2,
	sobrancelha: 2,
	boca: 2,
	nariz: 2,
	roupa: 2,
	cabelo: 2,
}


window.addEventListener('load', function () {

	// a ordem do array ira determinar a posição Z dos svg
	const partes = [
		"roupa", // ta sem pescoço
		"orelha",
		"rosto",
		"cabelo", // precisa remover parte branca
		"olho",
		"sobrancelha",
		"boca",
		"nariz",
	]
	
	const element = document.getElementById('avatar');

	function desenha({ width, height, data, className, top, left, index, distance = 0, mirrow }) {
			const imgElement = document.createElement('object')
			imgElement.type = "image/svg+xml"
			imgElement.width = width;
			imgElement.height = height;
			imgElement.data = `/odontopediatria/avatar/${className}/1.svg`;
			imgElement.className = className;
			imgElement.style.position = "absolute"
			imgElement.style.top = `${top}px`;
			imgElement.style.left = `${left + distance/2}px`;	
			imgElement.style.zIndex = index;
			if(mirrow) {
				imgElement.style.transform = "scaleX(-1)"
			}
			
			element.appendChild(imgElement);
			
			if(distance) {
				desenha({
					width,
					height,
					data,
					className,
					top,
					left: left - distance/2,
					index,
					distance: 	0,
					mirrow: true,
				})
			}
	}
	
	partes.forEach((parte, index) => {
		const {
			tamanho: {
				w: width,
				h: height,
			},
			posicao: {
				x: eixoX,
				y: eixoY,
				distance,
			}
		} = parteInfos[parte];	

		desenha({
			width,
			height,
			data: `/odontopediatria/avatar/${parte}/1.svg` ,
			className: parte,
			top: eixoY,
			left: eixoX,
			index,
			distance,
		})
	})

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

function update(type) {
	const elements = document.getElementsByClassName(type);
	const input = document.getElementById(`${type}Input`);

	
	for(let i = 0; i < elements.length; i = i + 1) {
		el = elements[i];
		let next = atual[type] + 1 - i;
		
		if(next > max[type]) {
			next = 1
		}
		
		atual[type] = next
	
		el.data = `/odontopediatria/avatar/${type}/${next}.svg`;
	}

	input.value = atual[type];
}