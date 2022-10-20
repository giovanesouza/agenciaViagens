// HORA
function dataHora() {

	let d = new Date(); // Para pegar a data atual
		
	// DATA
	let dia = d.getDate().toString().padStart(2,'0'); // Dia com 2 digitos;
	let m = String(d.getMonth() + 1).padStart(2,'0'); // Mês com 2 digitos
	let a = d.getFullYear();
	
	document.getElementById('data').innerText = `${dia}/${m}/${a}`;

	let hora = d.getHours(); // Pega a hora
	let min = d.getMinutes(); // Pega os minutos
	let seg = d.getSeconds(); // Pega os segundos

	// JUNTANDO h, m e s em um texto

	let txt = `${hora}h${min}:${seg}`

	// INSERINDO NA HTML - ficará visível APENAS QUANDO ACIONADA
	document.getElementById('hora').innerHTML = txt;

}

setInterval(dataHora, 1000);


// PÁGINA EXCLUIR CONTA - CÓDIGO INSERIDO DIRETAMENTE NA PÁG, POIS O JSP NÃO ESTAVA RECONHECENDO POR ESTE ARQUIVO.
// CÓDIGO PARA HABILITAR/DESABILITAR O BOTÃO DE EXCLUIR CONTA

let sim = document.getElementById('sim');
let nao = document.getElementById('nao');
let btn = document.getElementById('botao');


btn.disabled = true;

sim.addEventListener("change", escolha);
nao.addEventListener("change", escolha);

function escolha() {
	if (document.querySelector("#sim").checked == true) {
		btn.disabled = false;
	} else {
		btn.disabled = true;
	}
}




// MUDA O TYPE DO INPUT SENHA PARA VISUALIZAÇÃO DA MESMA - PÁGINA INFO CADASTRAIS

const iconEsconder = document.querySelector('#esconder');
const iconMostrar = document.querySelector('#mostrar');

iconMostrar.style.display = 'none';
iconEsconder.style.display = 'none';


/*
let input = document.getElementById('senhaInfo');
let show = document.getElementById('mostrarSenha');


show.addEventListener("click", showSenha);

function showSenha() {
	
	//alert("clicou");


	if (input.type == "password") {
		input.type = "text";
	} else {
		input.type = "password";
	}


}
*/
