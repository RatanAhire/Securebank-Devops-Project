/* ==========================================
        SETTINGS PAGE
========================================== */

document.addEventListener("DOMContentLoaded", function () {

    const saveButton = document.querySelector(".save-btn");

    saveButton.addEventListener("click", function () {

        alert(

            "✅ Settings saved successfully!\n\n" +

            "Your account preferences have been updated."

        );

    });

});

/* ==========================================
        THEME SELECTION
========================================== */

const themeSelect = document.querySelectorAll("select")[1];

themeSelect.addEventListener("change", function () {

    if (this.value === "Dark") {

        alert("🌙 Dark Theme Selected (Demo)");

    }

    else if (this.value === "Light") {

        alert("☀️ Light Theme Selected (Demo)");

    }

    else {

        alert("🖥️ System Default Theme Selected");

    }

});

/* ==========================================
        LANGUAGE
========================================== */

const languageSelect = document.querySelectorAll("select")[0];

languageSelect.addEventListener("change", function () {

    alert(

        "Language changed to : " +

        this.value +

        "\n\n(Demo)"

    );

});

/* ==========================================
        NOTIFICATIONS
========================================== */

const switches =
document.querySelectorAll(".switch input");

switches.forEach(function(toggle){

toggle.addEventListener("change",function(){

if(this.checked){

console.log("Enabled");

}

else{

console.log("Disabled");

}

});

});

/* ==========================================
        SECURITY BUTTONS
========================================== */

const settingButtons =
document.querySelectorAll(".setting-btn");

settingButtons.forEach(function(button){

button.addEventListener("click",function(){

alert(

"This feature will be available after backend integration."

);

});

});

/* ==========================================
        REMOVE DEVICE
========================================== */

const removeButtons =
document.querySelectorAll(".remove-btn");

removeButtons.forEach(function(button){

button.addEventListener("click",function(){

const confirmRemove = confirm(

"Remove this device from your account?"

);

if(confirmRemove){

this.parentElement.remove();

}

});

});

/* ==========================================
        UNSAVED CHANGES
========================================== */

let changed = false;

const inputs =
document.querySelectorAll("input,select");

inputs.forEach(function(item){

item.addEventListener("change",function(){

changed = true;

});

});

window.addEventListener("beforeunload",function(e){

if(changed){

e.preventDefault();

e.returnValue="";

}

});

/* ==========================================
        READY
========================================== */

console.log(

"SecureBank Settings Loaded Successfully."

);