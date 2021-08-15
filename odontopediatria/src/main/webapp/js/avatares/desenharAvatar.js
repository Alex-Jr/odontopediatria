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
		tamanho: { w: 310, h: 310 },
		posicao: { x: -7, y: 22},
	},
	cabelo: {
		tamanho: { w: 247, h: 247},
		posicao: { x: 28, y: 15},
	},
	pescoco: {
		tamanho: { w: 288, h: 288},
		posicao: { x: 2, y: 21},
	}
}

let partesId;

const max = { // isso poderia ser dinamico, mas pelo como é mvp está hardcoded
	orelha: 2,
	rosto: 2,
	olho: 4,
	sobrancelha: 5,
	boca: 6,
	nariz: 2,
	roupa: 2,
	cabelo: 3,
	pescoco: 1,
}

// a ordem do array ira determinar a posição Z dos svg
	const partes = [
		"pescoco",
		"roupa", // ta sem pescoço
		"orelha",
		"rosto",
		"cabelo", // precisa remover parte branca
		"olho",
		"sobrancelha",
		"boca",
		"nariz",
	]

let first = true;

function desenha({ width, height, data, className, top, left, index, distance = 0, mirrow , target}) {
			const imgElement = document.createElement('object')
			imgElement.type = "image/svg+xml"
			imgElement.width = width;
			imgElement.height = height;
			imgElement.data = data;
			imgElement.className = className;
			imgElement.style.position = "absolute"
			imgElement.style.top = `${top}px`;
			imgElement.style.left = `${left + distance/2}px`;	
			imgElement.style.zIndex = index;
			imgElement.style.pointerEvents = "none"; 
			if(mirrow) {
				imgElement.style.transform = "scaleX(-1)"
			}
			
			target.appendChild(imgElement);
			
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
					target,
				})
			}
	}
	
	
function desenharAvatar(received, element){
	partesId = received;

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
			data: `/odontopediatria/avatar/${partesId.genero}/${parte}/${partesId[parte]}.svg` ,
			className: parte,
			top: eixoY,
			left: eixoX,
			index,
			distance,
			target: element,
		})
	})
	
	if(first) {
		setTimeout(() => { mudaCorOlho({ target: { value: partesId.corOlho }}); first = false; }, 750 );
	} 	
}

function mudaCorOlho(event) {
	const olhos = document.getElementsByClassName('olho');	 
	console.log('a')
		
		for(olho of olhos){
			const svg = olho.getSVGDocument();
			svg.querySelectorAll("path")[1].setAttribute("fill", event.target.value)
		}
}


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
	
		el.data = `/odontopediatria/avatar/${partesId.genero}/${type}/${next}.svg`;
	}
	
	if(input) {	
		input.value = atual[type];
	}

	if(type === "olho") {
		setTimeout(() => { mudaCorOlho({ target: { value: partesId.corOlho }}); first = false; }, 100 );
	}
}
