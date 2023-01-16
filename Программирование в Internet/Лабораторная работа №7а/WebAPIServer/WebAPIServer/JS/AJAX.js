function GetCollectionRequst(isAsync = true) {
    let xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.open("GET", "https://localhost:44394/api/Values/", isAsync);
    try {
        xmlHttpRequest.onreadystatechange = () => {
            if (xmlHttpRequest.readyState === xmlHttpRequest.DONE && xmlHttpRequest.status === 200) {
                document.getElementById("info-table").innerHTML = "";
                document.getElementById("info-table").innerHTML += "<tr>" + "<td style='display:none'><p>Id</p></td><td><p>Фамилия</p></td><td><p>Телефон</p></td>" + "</tr>";
                let parsedJsonObject = JSON.parse(JSON.parse(xmlHttpRequest.responseText));
                parsedJsonObject.phoneRecords.forEach((item) => {
                    document.getElementById("info-table").innerHTML += "<tr><td style='display:none' id='phone-record-id'>" + item.Id + "</td><td>" + item.LastName + "</td><td>" + item.PhoneNumber + "</td><td style='border: 0px'>" + "<button onclick='DeleteElementRequst(this);' data-item='" + item.Id + "'>Удалить</button>" + "<button onclick='ChangeToUpdate(\"" + item.Id + "\",\"" + item.LastName + "\",\"" + item.PhoneNumber + "\");'>Редактировать</button>" + "</td></tr>";
                });
            }
        };

        xmlHttpRequest.send();
    } catch (error) {
        console.error(error);
    }
}

function AddElementRequst(isAsync = true) {
    var phoneRecord = {
        Id: 0,
        LastName: $('#last-name').val(),
        PhoneNumber: $('#phone-number').val()
    };

    var json = JSON.stringify(phoneRecord);

    $.ajax({
        url: 'https://localhost:44394/api/Values/',
        type: 'POST',
        data: json,
        contentType: "application/json;charset=utf-8"
    });
}

function DeleteElementRequst(el, isAsync = true) {
    var id = $(el).attr("data-item");
    $.ajax({
        url: 'https://localhost:44394/api/Values/' + id,
        type: 'DELETE',
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            GetCollectionRequst();
        }
    });
}

function UpdateElementRequst(isAsync = true) {
    var phoneRecord = {
        Id: 0,
        LastName: $('#update-last-name').val(),
        PhoneNumber: $('#update-phone-number').val()
    };

    var json = JSON.stringify(phoneRecord);
    var id = document.getElementById("update-id").value;
    $.ajax({
        url: 'https://localhost:44394/api/Values/' + id,
        type: 'PUT',
        data: json,
        contentType: "application/json;charset=utf-8",
    });
}

function ChangeToUpdate(id, lastName, phoneNumber) {

    document.getElementById("update-id").value = id;
    document.getElementById("update-last-name").value = lastName;
    document.getElementById("update-phone-number").value = phoneNumber;

    document.getElementById("update-table").style.display = "block";
    document.getElementById("add-table").style.display = "none";
   
}

function ChangeToAdd() {
    document.getElementById("update-table").style.display = "none";
    document.getElementById("add-table").style.display = "block";
}