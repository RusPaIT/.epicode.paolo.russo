var screen1 = [1, 8, 12, 14, 15, 16, 17, 18];
var screen2 = [1, 4,  8, 10, 12, 13, 14];
var screen3 = [1, 3,  5,  7,  9, 11];
var screen4 = [1, 2,  4,  6,  8];

function findIndex() {
    let step = document.getElementsByName("next");
    let check = 0;
    for (i=0; i<step.length; i++) {
        if (step[i].checked==true) {
            check = (i + 1);
        }
    }
    return check;
}

function findResolution() {
    let display = document.getElementsByClassName("slide");
    return display[1].height;    
}

function next() {
    var now = findIndex();
    var size = findResolution();
    var slides = [];
    if (size == 171) {
        slides = screen1;
    }
    else if (size == 170) {
        slides = screen2;
    }
    else if (size == 161) {
        slides = screen3;
    }
    else {
        slides = screen4;
    }
    var next = slides.indexOf(now) + 1;
    if (now == slides[(slides.length)-1]) {
        next = 0;
    }
    document.getElementById("nav" + slides[next]).checked = true; 
}

function highlight(index) {
    let tab = document.getElementsByClassName("tabs");
    tab[index].style.borderBottom = "2px solid #ff5333";
}

function leave(index) {
    let tab = document.getElementsByClassName("tabs");
    tab[index].style.borderBottom = "transparent";
}