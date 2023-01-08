var textAreaTag;
var webSocket = null;
var buttonStart;
var buttonStop;
window.onload = function () {
    if (Modernizr.websockets) {
        WriteMessages('support', 'да');
        textAreaTag = document.getElementById("textArea");
        buttonStart = document.getElementById("buttonStart");
        buttonStop = document.getElementById("buttonStop");
        buttonStart.disabled = false;
        buttonStop.disabled = true;
    }
}

function WriteMessages(idSpan, txt) {
    var span = document.getElementById(idSpan);
    span.innerHTML = txt;
}

function appStart() {
    if (webSocket == null) {
        webSocket = new WebSocket('wss://' + location.host + '/websockets');
        webSocket.onopen = function () { webSocket.send('Соединение'); }
        webSocket.onclose = function (s) { console.log('onclose', s); }
        webSocket.onmessage = function (evt) { textAreaTag.innerHTML += '\n' + evt.data; }
        buttonStart.disabled = true;
        buttonStop.disabled = false;
    }
}

function appStop() {
    webSocket.onopen = null;
    webSocket.onclose = null;
    webSocket.onmessage = null;
    webSocket.close(3001, 'stopapplication');
    webSocket = null;
    buttonStart.disabled = false;
    buttonStop.disabled = true;
}