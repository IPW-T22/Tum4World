/* script.js */
function caricaCitazione() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = xhr.responseText;
            //alert(data);
            document.getElementById("citazione").innerText = data;
        }
    }
    xhr.open('GET', '${pageContext.request.contextPath}/citazione', true);
    xhr.send(null);
}

setInterval(caricaCitazione, 20*1000);

//console.log("ciao");