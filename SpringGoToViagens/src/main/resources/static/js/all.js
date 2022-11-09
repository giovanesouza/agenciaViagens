
//REALIZA O SCROLL
function subirTela() {

    window.scrollTo({
        top: 0,
        left: 0,
        behavior: 'smooth'
    });

}


// CONDIÇÃO PARA MOSTRAR OU NÃO O BOTÃO

function btnScroll() {

    if (window.scrollY < 200) {
        document.getElementById("icon-top").style.display = "none";

    } else {
        document.getElementById("icon-top").style.display = "block";
    }
};

// Monitora o scroll. 
window.addEventListener('scroll', btnScroll);



// EXIBIÇÃO DE SENHA - CADASTRO DE USUÁRIO

const iconEsconder = document.querySelector('#esconder');
const iconMostrar = document.querySelector('#mostrar');

let input = document.getElementById('senha');


iconEsconder.addEventListener("click", showSenha);
iconMostrar.addEventListener("click", showSenha);

function showSenha() {


	if (input.type == "password") {
		input.type = "text";
		iconMostrar.style.display = 'none';
		iconEsconder.style.display = 'block';

	} else {
		input.type = "password";
		iconEsconder.style.display = 'none';
		iconMostrar.style.display = 'block';
	}

}

