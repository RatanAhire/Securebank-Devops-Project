/* ======================================================
                DEPOSIT PAGE
====================================================== */

document.addEventListener("DOMContentLoaded", () => {

    console.log("Deposit Page Loaded Successfully");

    initializeDeposit();

});

function initializeDeposit(){

    console.log("SecureBank Deposit Initialized");

}

/* ======================================================
                FORM ELEMENTS
====================================================== */

const depositForm = document.getElementById("depositForm");

const amountInput = document.getElementById("amount");

const remarksInput = document.getElementById("remarks");

const submitBtn = document.getElementById("depositBtn");

/* ======================================================
                AMOUNT VALIDATION
====================================================== */

function validateAmount(){

    const amount = Number(amountInput.value);

    if(amount === 0){

        alert("Please enter deposit amount.");

        return false;

    }

    if(amount < 0){

        alert("Amount cannot be negative.");

        return false;

    }

    if(amount < 100){

        alert("Minimum deposit amount is ₹100.");

        return false;

    }

    return true;

}

/* ======================================================
                REMARKS VALIDATION
====================================================== */

function validateRemarks(){

    if(remarksInput.value.trim().length > 150){

        alert("Remarks should not exceed 150 characters.");

        return false;

    }

    return true;

}

/* ======================================================
                FORM SUBMIT
====================================================== */

if(depositForm){

    depositForm.addEventListener("submit",(event)=>{

        event.preventDefault();

        if(!validateAmount()){

            return;

        }

        if(!validateRemarks()){

            return;

        }

        const confirmDeposit = confirm(

            "Do you want to deposit ₹" +

            amountInput.value +

            " ?"

        );

        if(!confirmDeposit){

            return;

        }

        alert("Deposit Successful!");

        depositForm.reset();

    });

}

/* ======================================================
            LIVE AMOUNT FORMAT
====================================================== */

if(amountInput){

    amountInput.addEventListener("input",()=>{

        let amount = amountInput.value;

        amount = amount.replace(/[^0-9]/g,"");

        amountInput.value = amount;

    });

}

/* ======================================================
            REMARKS COUNTER
====================================================== */

const remarksCounter = document.getElementById("remarksCount");

if(remarksInput){

    remarksInput.addEventListener("input",()=>{

        let length = remarksInput.value.length;

        remarksCounter.innerHTML =

        length + " / 150 Characters";

    });

}

/* ======================================================
            LOADING BUTTON
====================================================== */

function startLoading(){

    submitBtn.disabled = true;

    submitBtn.innerHTML =

    '<i class="fa-solid fa-spinner fa-spin"></i> Processing...';

}

function stopLoading(){

    submitBtn.disabled = false;

    submitBtn.innerHTML =

    '<i class="fa-solid fa-circle-plus"></i> Deposit Money';

}

/* ======================================================
            SUBMIT FORM
====================================================== */

if(depositForm){

    depositForm.addEventListener("submit",(event)=>{

        event.preventDefault();

        if(!validateAmount()) return;

        if(!validateRemarks()) return;

        const confirmDeposit = confirm(

            "Confirm deposit of ₹" +

            Number(amountInput.value).toLocaleString("en-IN") +

            " ?"

        );

        if(!confirmDeposit){

            return;

        }

        startLoading();

        setTimeout(()=>{

            stopLoading();

            alert(

                "₹" +

                Number(amountInput.value).toLocaleString("en-IN") +

                " deposited successfully."

            );

            depositForm.reset();

            remarksCounter.innerHTML =

            "0 / 150 Characters";

        },1500);

    });

}

/* ======================================================
            BACKEND READY
====================================================== */

// depositForm.submit();