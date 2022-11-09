//Se si rifresha velocemente la pagina c'è la possibilità di non aspettare il minuto perche si accellera velocemente i secondi cosi da vedere come si comporta il timer dopo i 60 sec


document.addEventListener("DOMContentLoaded", timer);
var contatore = document.getElementById("timer");
var s = 0;
var m = 0;
var secondS = sessionStorage.getItem("s");
var minuteS = sessionStorage.getItem("m");
let interval = setInterval(timer, 1000);


if (secondS || minuteS) {
    s = Number(secondS);
    m = Number(minuteS);
}

function timer() {

        contatore.innerHTML = `Tempo: ${m} min ${s} sec`;
        s++;
        if (s == 60) {
            m++;
            s = 0;
        }
        sessionStorage.setItem("s", s);
        sessionStorage.setItem("m", m);
    };
