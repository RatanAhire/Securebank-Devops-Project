/* ======================================================
            PROFILE PAGE
====================================================== */

document.addEventListener("DOMContentLoaded", () => {

    console.log("Profile Page Loaded Successfully");

    initializeProfile();

});

function initializeProfile(){

    console.log("SecureBank Profile Initialized");

}

/* ======================================================
            EDIT PROFILE
====================================================== */

const editBtn = document.querySelector(".btn-primary");

if(editBtn){

    editBtn.addEventListener("click",()=>{

        alert("Profile Edit feature will be available after backend integration.");

    });

}

/* ======================================================
        CHANGE PASSWORD
====================================================== */

const passwordBtn = document.getElementById("changePasswordBtn");

if(passwordBtn){

    passwordBtn.addEventListener("click",()=>{

        alert("Redirecting to Change Password Page...");

        // window.location.href="change-password.html";

    });

}

/* ======================================================
                TWO FACTOR AUTH
====================================================== */

const twoFABtn = document.getElementById("enable2FABtn");

if(twoFABtn){

    let enabled = false;

    twoFABtn.addEventListener("click",()=>{

        enabled = !enabled;

        if(enabled){

            twoFABtn.innerHTML="2FA Enabled";

            alert("Two-Factor Authentication Enabled Successfully.");

        }

        else{

            twoFABtn.innerHTML="Enable 2FA";

            alert("Two-Factor Authentication Disabled.");

        }

    });

}

/* ======================================================
            LOGIN HISTORY
====================================================== */

const historyBtn = document.getElementById("loginHistoryBtn");

if(historyBtn){

    historyBtn.addEventListener("click",()=>{

        alert(
`Recent Login Activity

✓ Mumbai
✓ Chrome
✓ Windows 11

Last Login:
12 July 2026
09:45 AM`
        );

    });

}

/* ======================================================
        PROFILE IMAGE PREVIEW
====================================================== */

const profileImage = document.querySelector(".profile-image img");

const uploadInput = document.getElementById("profileUpload");

if(uploadInput){

    uploadInput.addEventListener("change",(event)=>{

        const file = event.target.files[0];

        if(file){

            const reader = new FileReader();

            reader.onload = function(e){

                profileImage.src = e.target.result;

            };

            reader.readAsDataURL(file);

        }

    });

}

/* ======================================================
            CLICK IMAGE TO UPLOAD
====================================================== */

if(profileImage && uploadInput){

    profileImage.style.cursor="pointer";

    profileImage.title="Click to change profile photo";

    profileImage.addEventListener("click",()=>{

        uploadInput.click();

    });

}

/* ======================================================
            SUCCESS MESSAGE
====================================================== */

function showMessage(message){

    alert(message);

}