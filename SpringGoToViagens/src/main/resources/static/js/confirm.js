const form = document.querySelector('#form');
const msg = document.querySelector('#success');
const btnEnviar = document.querySelector('#enviar');
const btnSair = document.querySelector('#sair');

form.style.display = "block";
msg.style.display = "none";

form.addEventListener("submit", (e) => {
	e.preventDefault()
	//form.submit();

	//e.preventDefault(form.submit());

	//form.submit(e.preventDefault());

		if (form.style.display == "block") {
			console.log(msg)
			form.style.display = "none";
			msg.style.display = "block";
			
}
	
});


btnSair.addEventListener("click", sair);


function sair() {

	if (form.style.display == "none") {

		form.style.display = "block"
		msg.style.display = "none"

	}
}