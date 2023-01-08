function Multiply() {
    let xhr = new XMLHttpRequest();
    let formData = new FormData();
    formData.append('X', document.getElementById('FirstValue').value);
    formData.append('Y', document.getElementById('SecondValue').value);
    xhr.open('POST', 'https://' + location.host + '/01/SEA5');
    xhr.send(formData);
    xhr.onload = function () {
        if (xhr.status != '200') {
            alert('Ошибка запроса' + xhr.statusText);
        }
        else {
            document.getElementById('Result').value = xhr.response;
        }
    }
}