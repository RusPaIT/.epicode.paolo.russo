document.getElementById("entra").addEventListener("click", function () {
    let utente = document.getElementById("user").value;
    localStorage.setItem(utente, "");
    document.getElementById("ciao").innerHTML = `Ciao ${utente}`;
})

