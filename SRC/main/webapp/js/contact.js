/* ======================================================
                CONTACT PAGE
====================================================== */

document.addEventListener("DOMContentLoaded", () => {

    console.log("Contact Page Loaded Successfully");

    initializeContact();

});

function initializeContact(){

    console.log("SecureBank Contact Initialized");

}

/* ======================================================
                FORM ELEMENTS
====================================================== */

const contactForm = document.getElementById("contactForm");

const nameInput = document.getElementById("name");

const emailInput = document.getElementById("email");

const phoneInput = document.getElementById("phone");

const subjectInput = document.getElementById("subject");

const messageInput = document.getElementById("message");

const sendBtn = document.getElementById("sendBtn");

/* ======================================================
                NAME VALIDATION
====================================================== */

function validateName(){

    const name = nameInput.value.trim();

    if(name===""){

        alert("Please enter your name.");

        return false;

    }

    if(name.length < 3){

        alert("Name should contain at least 3 characters.");

        return false;

    }

    return true;

}

/* ======================================================
                EMAIL VALIDATION
====================================================== */

function validateEmail(){

    const email = emailInput.value.trim();

    const emailPattern =

    /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if(!emailPattern.test(email)){

        alert("Please enter a valid email address.");

        return false;

    }

    return true;

}

/* ======================================================
                MOBILE VALIDATION
====================================================== */

function validatePhone(){

    const phone = phoneInput.value.trim();

    const phonePattern = /^[6-9]\d{9}$/;

    if(!phonePattern.test(phone)){

        alert("Please enter a valid 10-digit mobile number.");

        return false;

    }

    return true;

}

/* ======================================================
                SUBJECT VALIDATION
====================================================== */

function validateSubject(){

    if(subjectInput.value===""){

        alert("Please select a subject.");

        return false;

    }

    return true;

}

/* ======================================================
                MESSAGE VALIDATION
====================================================== */

function validateMessage(){

    const message = messageInput.value.trim();

    if(message===""){

        alert("Please enter your message.");

        return false;

    }

    if(message.length < 10){

        alert("Message should contain at least 10 characters.");

        return false;

    }

    if(message.length > 500){

        alert("Message cannot exceed 500 characters.");

        return false;

    }

    return true;

}

/* ======================================================
            MESSAGE COUNTER
====================================================== */

const messageCounter = document.getElementById("messageCount");

if(messageInput){

    messageInput.addEventListener("input",()=>{

        let length = messageInput.value.length;

        messageCounter.innerHTML =

        length + " / 500 Characters";

    });

}

/* ======================================================
                BUTTON LOADING
====================================================== */

function startLoading(){

    sendBtn.disabled = true;

    sendBtn.innerHTML =

    '<i class="fa-solid fa-spinner fa-spin"></i> Sending...';

}

function stopLoading(){

    sendBtn.disabled = false;

    sendBtn.innerHTML =

    '<i class="fa-solid fa-paper-plane"></i> Send Message';

}

/* ======================================================
                FORM SUBMIT
====================================================== */

if(contactForm){

    contactForm.addEventListener("submit",(event)=>{

        event.preventDefault();

        if(!validateName()) return;

        if(!validateEmail()) return;

        if(!validatePhone()) return;

        if(!validateSubject()) return;

        if(!validateMessage()) return;

        startLoading();

        setTimeout(()=>{

            stopLoading();

            alert(

                "Thank you for contacting SecureBank.\n\n" +

                "Our support team will contact you shortly."

            );

            contactForm.reset();

            messageCounter.innerHTML =

            "0 / 500 Characters";

        },1500);

    });

}

/* ======================================================
            BACKEND READY
====================================================== */

// contactForm.submit();    