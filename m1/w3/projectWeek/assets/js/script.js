function num(valore) {
    document.getElementById("calcoli").value += valore;
}

function operazione() {
    document.getElementById("calcoli").value = eval(document.getElementById("calcoli").value);
}

function reset() {
    document.getElementById("calcoli").value = "";
}

function cancella() {
    var canc = document.getElementById("calcoli").value;
    document.getElementById("calcoli").value = canc.substring(0, canc.length - 1);
}
