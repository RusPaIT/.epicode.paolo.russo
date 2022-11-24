var arrayTask = new Array;
var btnAdd:HTMLElement = document.getElementById("invia")!;
var lista:HTMLElement = document.getElementById("lista")!;
var nulla:HTMLElement = document.getElementById("nulla")!;
var errore:HTMLElement = document.getElementById("errore")!;

function Task(_titolo:string, _categoria:string, _contenuto:string) {
    this.titolo = _titolo;
    this.categoria = _categoria;
    this.contenuto = _contenuto;
}

window.addEventListener("DOMContentLoaded", stampaLista);


btnAdd.addEventListener("click", async function(e) {
    e.preventDefault();
    let newTitolo = (document.getElementById("titolo") as HTMLInputElement).value;
    let newCategoria = (document.getElementById("categoria") as HTMLInputElement).value;
    let newContenuto = (document.getElementById("contenuto") as HTMLInputElement).value;

    
    if (newTitolo && newCategoria && newContenuto) {
        let newTask = new Task(newTitolo, newCategoria, newContenuto);
        arrayTask.push(newTask);
        await aggiungiTask(newTask);
        stampaLista();
    } else {
        errore.style.visibility = "visible";
        errore.innerHTML = "Attenzione! Riempire tutti i campi";
        svuotaForm();
        return;
    }
})

 async function aggiungiTask(task:any) {
    let res = await fetch("http://localhost:3000/task/", {
        method:"POST",
        headers: {
            "Content-Type": "application/json;charset=utf-8",
        },
        body: JSON.stringify(task)
    })
}

function stampaLista() {
    fetch ("http://localhost:3000/task").then((res) => {return res.json()}).then(async (data) => {
         arrayTask = data;
         nulla.style.display = "none";
         errore.style.visibility = "hidden";
         lista.innerHTML = "";
         arrayTask.forEach(task => {
        let li:HTMLElement = document.createElement("li");
        li.className = "list-group-item mb-3 text-start";
        li.innerHTML = ` Titolo task : <strong>${task.titolo}</strong> / Categoria: <strong>${task.categoria}</strong> / Descrizione: <strong>${task.contenuto}</strong>`;
        let span:HTMLSpanElement = document.createElement("span");
        span.className = "btn btn-danger btn-sm float-end";
        span.innerText = "X";
        let hr:HTMLHRElement = document.createElement("hr");
        lista.appendChild(li);
        li.appendChild(span);
        li.appendChild(hr);
        span.addEventListener("click", async function() {                  
            this.parentNode!.parentNode!.removeChild(this.parentNode!);
            let id:number = arrayTask[arrayTask.indexOf(task)].id;
            await cancellaTask(id);
            stampaLista();
        })
    });
    svuotaForm();
});
}

async function cancellaTask(id:number) {
    let res = await fetch("http://localhost:3000/task/" + id, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json;charset=utf-8",
        },
        body: JSON.stringify(arrayTask)
    });
}
function svuotaForm() {
     (document.getElementById("titolo") as HTMLInputElement).value = "";
     (document.getElementById("categoria") as HTMLInputElement).value = "";
     (document.getElementById("contenuto") as HTMLInputElement).value = "";
}