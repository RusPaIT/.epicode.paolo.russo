var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (g && (g = 0, op[0] && (_ = 0)), _) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
var arrayTask = new Array;
var btnAdd = document.getElementById("invia");
var lista = document.getElementById("lista");
var nulla = document.getElementById("nulla");
var errore = document.getElementById("errore");
function Task(_titolo, _categoria, _contenuto) {
    this.titolo = _titolo;
    this.categoria = _categoria;
    this.contenuto = _contenuto;
}
window.addEventListener("DOMContentLoaded", stampaLista);
btnAdd.addEventListener("click", function (e) {
    return __awaiter(this, void 0, void 0, function () {
        var newTitolo, newCategoria, newContenuto, newTask;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    e.preventDefault();
                    newTitolo = document.getElementById("titolo").value;
                    newCategoria = document.getElementById("categoria").value;
                    newContenuto = document.getElementById("contenuto").value;
                    if (!(newTitolo && newCategoria && newContenuto)) return [3 /*break*/, 2];
                    newTask = new Task(newTitolo, newCategoria, newContenuto);
                    arrayTask.push(newTask);
                    return [4 /*yield*/, aggiungiTask(newTask)];
                case 1:
                    _a.sent();
                    stampaLista();
                    return [3 /*break*/, 3];
                case 2:
                    errore.style.visibility = "visible";
                    errore.innerHTML = "Attenzione! Riempire tutti i campi";
                    svuotaForm();
                    return [2 /*return*/];
                case 3: return [2 /*return*/];
            }
        });
    });
});
function aggiungiTask(task) {
    return __awaiter(this, void 0, void 0, function () {
        var res;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0: return [4 /*yield*/, fetch("http://localhost:3000/task/", {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json;charset=utf-8"
                        },
                        body: JSON.stringify(task)
                    })];
                case 1:
                    res = _a.sent();
                    return [2 /*return*/];
            }
        });
    });
}
function stampaLista() {
    var _this = this;
    fetch("http://localhost:3000/task").then(function (res) { return res.json(); }).then(function (data) { return __awaiter(_this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            arrayTask = data;
            nulla.style.display = "none";
            errore.style.visibility = "hidden";
            lista.innerHTML = "";
            arrayTask.forEach(function (task) {
                var li = document.createElement("li");
                li.className = "list-group-item mb-3 text-start";
                li.innerHTML = " Titolo task : <strong>".concat(task.titolo, "</strong> / Categoria: <strong>").concat(task.categoria, "</strong> / Descrizione: <strong>").concat(task.contenuto, "</strong>");
                var span = document.createElement("span");
                span.className = "btn btn-danger btn-sm float-end";
                span.innerText = "X";
                var hr = document.createElement("hr");
                lista.appendChild(li);
                li.appendChild(span);
                li.appendChild(hr);
                span.addEventListener("click", function () {
                    return __awaiter(this, void 0, void 0, function () {
                        var id;
                        return __generator(this, function (_a) {
                            switch (_a.label) {
                                case 0:
                                    this.parentNode.parentNode.removeChild(this.parentNode);
                                    id = arrayTask[arrayTask.indexOf(task)].id;
                                    return [4 /*yield*/, cancellaTask(id)];
                                case 1:
                                    _a.sent();
                                    stampaLista();
                                    return [2 /*return*/];
                            }
                        });
                    });
                });
            });
            svuotaForm();
            return [2 /*return*/];
        });
    }); });
}
function cancellaTask(id) {
    return __awaiter(this, void 0, void 0, function () {
        var res;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0: return [4 /*yield*/, fetch("http://localhost:3000/task/" + id, {
                        method: "DELETE",
                        headers: {
                            "Content-Type": "application/json;charset=utf-8"
                        },
                        body: JSON.stringify(arrayTask)
                    })];
                case 1:
                    res = _a.sent();
                    return [2 /*return*/];
            }
        });
    });
}
function svuotaForm() {
    document.getElementById("titolo").value = "";
    document.getElementById("categoria").value = "";
    document.getElementById("contenuto").value = "";
}
