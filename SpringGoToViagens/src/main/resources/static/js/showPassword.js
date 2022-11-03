
// USUÁRIO LOGADO
// MUDA O TYPE DO INPUT SENHA PARA VISUALIZAÇÃO DA MESMA - PÁGINA INFO CADASTRAIS

const iconEsconder = document.querySelector('#esconder');
const iconMostrar = document.querySelector('#mostrar');

let input = document.getElementById('senhaInfo');


iconEsconder.addEventListener("click", showSenha);
iconMostrar.addEventListener("click", showSenha);

function showSenha() {


	if (input.type == "password") {
		input.type = "text";
		iconMostrar.style.display = 'block';
		iconEsconder.style.display = 'none';

	} else {
		input.type = "password";
		iconEsconder.style.display = 'block';
		iconMostrar.style.display = 'none';
	}

}
