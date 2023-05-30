daysToExpire = 90;
function acceptCookie(){
    var expirationDate = new Date();
    expirationDate.setDate(expirationDate.getDate() + daysToExpire);
    document.cookie = "cookieAccepted=true; expires=" + expirationDate.toUTCString() + "; path=/";
    document.getElementById("div_cookie_banner").style.display = "none";
}
function declineCookie(){
    var expirationDate = new Date();
    expirationDate.setDate(expirationDate.getDate() + daysToExpire);
    document.cookie = "cookieAccepted=false; expires=" + expirationDate.toUTCString() + "; path=/";
    document.getElementById("div_cookie_banner").style.display = "none";
}