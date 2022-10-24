var dataOggi = new Date();
const mesi = ["Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"]
var meseCorrente = mesi[dataOggi.getMonth()];

document.getElementById("giorno").innerHTML += dataOggi.getDate() + "&nbsp;/&nbsp;" + meseCorrente + "&nbsp;/&nbsp;" + dataOggi.getFullYear();


document.getElementById("dataCompleta").innerHTML += dataOggi;

document.getElementById("day").innerHTML += "&nbsp;" + dataOggi.getDate();
document.getElementById("month").innerHTML += "&nbsp;" + meseCorrente;

document.getElementById("giorno2").innerHTML += "&nbsp;" + dataOggi.getDate() + "&nbsp;-&nbsp;" + meseCorrente + "&nbsp;-&nbsp;" + dataOggi.getFullYear();







