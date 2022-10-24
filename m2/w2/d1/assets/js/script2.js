
var oraAttuale = new Date();

if (oraAttuale.getHours() >= 6 && oraAttuale.getHours() < 14) {
    document.getElementById("ciao").innerHTML = "Buongiorno!!!";
}
else if (oraAttuale.getHours() >= 14 && oraAttuale.getHours() < 20) {
    document.getElementById("ciao").innerHTML = "Buon Pomeriggio!!!";
}
else if (oraAttuale.getHours() >= 20 && oraAttuale.getHours() < 23) {
    document.getElementById("ciao").innerHTML = "Buonasera!!!";
}
else if(oraAttuale.getHours() >= 0 && oraAttuale.getHours() < 6) {
    document.getElementById("ciao").innerHTML = "buonanotte!!!";
}