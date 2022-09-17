
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


// PÁG LOGIN - Validação de forms 

// CADASTRO USUÁRIO

function verificaSenhaCad() {

    let senhaCadastro = document.getElementById("senha").value;
    let senhaCadastroConfirm = document.getElementById("senhaconfirm").value;

    console.log(senhaCadastroConfirm);

    senhaCadastro.style.backgroundColor = "red !important"

    if (senhaCadastro === senhaCadastroConfirm) {

        // senhaCadastro.style.backgroundColor = "0 0 1rem #00ff00"
        // senhaCadastroConfirm.style.backgroundColor = "0 0 1rem #00ff00"

        // console.log(senhaCadastro)
        // console.log(senhaCadastroConfirm)

    } else {

        // senhaCadastroConfirm.style.backgroundColor = "0 0 1rem #ff0000"

        // console.log(senhaCadastro)
        // console.log(senhaCadastroConfirm);
    }

}

