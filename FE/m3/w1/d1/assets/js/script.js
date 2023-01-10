var arrayTask = [];
var btnAdd = document.getElementById("invia");
var lista = document.getElementById("lista");
var nulla = document.getElementById("nulla");
var errore = document.getElementById("errore");

function Task(_nome, _cognome, _data, _eta) {
    this.nome = _nome;
    this.cognome = _cognome;
    this.data = _data;
    this.eta = _eta;
}

function calcolaEta(){
    var dataNascita = new Date(document.getElementById("data").value);
    var oggi = new Date();
    var anno = (oggi.getFullYear() - dataNascita.getFullYear());

    if(oggi.getMonth() < dataNascita.getMonth() || oggi.getMonth() == 
    dataNascita.getMonth() && oggi.getDate() < dataNascita.getDate()){
        anno--;
    }
    return anno;
}

btnAdd.addEventListener("click", function(e){
    e.preventDefault();
    let newNome = document.getElementById("nome").value;
    let newCognome = document.getElementById("cognome").value;
    let newData = document.getElementById("data").value;
    let newEta = calcolaEta();

    if (newNome && newCognome && newData && newEta) {
        let newTask = new Task(newNome, newCognome, newData, newEta);
        arrayTask.push(newTask);
        stampaLista();
    } else {
        errore.style.visibility = "visible";
        errore.innerHTML = "Attenzione! Riempire tutti i campi";
        svuotaForm();
        return;
    }
})

function stampaLista() {
    nulla.style.display = "none";
    errore.style.visibility = "hidden";
    lista.innerHTML = "";
    arrayTask.forEach(task => {
        let li = document.createElement("li");
        li.className = "list-group-item mb-3 text-start";
        li.innerHTML = `<strong>${task.nome}</strong>  <strong>${task.cognome}</strong> - <strong> ${task.eta}</strong>`;
        let span = document.createElement("span");
        span.className = "btn btn-danger btn-sm float-end";
        span.innerText = "X";
        let hr = document.createElement("hr");
        lista.appendChild(li);
        li.appendChild(span);
        li.appendChild(hr);
        span.addEventListener("click", function() {                  
            span.parentNode.remove();
            let i = arrayTask.indexOf(task);
            arrayTask.splice(i, 1);
            stampaLista();
        })
    });
    svuotaForm();
}

function svuotaForm() {
    document.getElementById("nome").value = "";
    document.getElementById("cognome").value = "";
    document.getElementById("data").value = "";
}


