var nome;
var cognome;
var addBtn;
var elencoHTML;
var errore;
var erroreElenco;
var elenco = [];
var utente;
window.addEventListener('DOMContentLoaded', init);

function init() {
	nome = document.getElementById('nome');
	cognome = document.getElementById('cognome');
	addBtn = document.getElementById('scrivi');
	elencoHTML = document.getElementById('elenco');
	errore = document.getElementById('errore');
	erroreElenco = document.getElementById('erroreElenco');
	printData();
	eventHandler();
}

function eventHandler() {
	addBtn.addEventListener('click', function () {
		if(utente){
		modiFica(utente);
		} else {
		controlla();
		}
	});
}

function printData() {
	fetch('http://localhost:3000/elenco')
		.then((response) => {
			return response.json();
		})
		.then((data) => {
			elenco = data;
			if (elenco.length > 0) {
				errore.innerHTML = '';
				elencoHTML.innerHTML = '';
				elenco.map(function (element) {
					elencoHTML.innerHTML += `<li><button type="button" class="btn btn-danger m-1" onClick="elimina(${element.id})"><strong>x</strong></button><button type="button" onClick="modifica(${element.id})" class="btn btn-warning m-1"><i class="bi bi-pen-fill"></i></i></button>${element.nome} ${element.cognome}</li>`;
				});
			} else {
				erroreElenco.innerHTML = 'Nessun elemento presente in elenco';
			}
		});
}

function controlla() {
	if (nome.value != '' && cognome.value != '') {
		var data = {
			nome: nome.value,
			cognome: cognome.value,
		};
		addData(data);
	} else {
		errore.innerHTML = 'Compilare correttamente i campi!';
		return;
	}
}

async function addData(data) {
	let response = await fetch('http://localhost:3000/elenco', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8',
		},
		body: JSON.stringify(data),
	});
	clearForm();
}

function clearForm() {
	nome.value = '';
	cognome.value = '';
}

async function elimina(i) {
	
if (confirm("Sei sicuro della eliminazione?la decisione è irreversibile!!!")  == true) {
	let response = await fetch(`http://localhost:3000/elenco/${i}`, {
		method:"DELETE",
	})}
}

function modifica(i) {
	fetch(`http://localhost:3000/elenco/${i}`)

    .then((response) => {
        return response.json();
    })
    .then((data) => {
        document.getElementById('nome').value = data.nome;
        document.getElementById('cognome').value = data.cognome;
    })
	return utente = i;
}


function modiFica(utente) {
	if(nome.value && cognome.value){
	fetch(`http://localhost:3000/elenco/${utente}`, {
			method: 'PUT',         
			headers: {
			'Content-Type': 'application/json;charset=utf-8',
		},
		body: JSON.stringify({
			"nome": nome.value,
			"cognome": cognome.value
			})
	})
	} else {
		errore.innerHTML = 'Compilare correttamente i campi!';
	}
}