var cubo = document.querySelectorAll(".cube")
var length = cubo.length;
function mouseOutRight() {
    for ( index = 0 ; index < cubo.length; index++) {
        cubo[index].style.transform = "rotateY(0deg)";
    }
}

function mouseOverRight() {
    for ( index = 0 ; index < cubo.length; index++) {
        cubo[index].style.transform = "rotateY(25deg)";
    }
}

function mouseOutLeft() {
    for ( index = 0 ; index < cubo.length; index++) {
        cubo[index].style.transform = "rotateY(0deg)";
    }
}

function mouseOverLeft() {
    for ( index = 0 ; index < cubo.length; index++) {
        cubo[index].style.transform = "rotateY(-25deg)";
    }
}

function ruota90() {
    let angolo = Number(cubo[0].style.transform.replace(/\D/g, ""));
    for ( index = 0 ; index < cubo.length; index++) {
        cubo[index].style.transform = "rotateY("+(angolo+90)+"deg)";
    }
}

function ruota_90() {
    let angolo = Number(cubo[0].style.transform.replace(/\D/g, ""));
    for ( index = 0 ; index < cubo.length; index++) {
        cubo[index].style.transform = "rotateY("+((angolo+90)*-1)+"deg)";
    }
}

function ruota360() {
    for ( index = 0 ; index < cubo.length; index++) {
        cubo[index].style.transform = "rotateY(360deg)";
    }
}


