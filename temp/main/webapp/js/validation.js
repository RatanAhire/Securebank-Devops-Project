// ================================
// Login Validation
// ================================

function validateLogin() {

    let username = document.forms["loginForm"]["username"].value.trim();
    let password = document.forms["loginForm"]["password"].value.trim();

    if (username === "") {
        alert("Username is required.");
        return false;
    }

    if (password === "") {
        alert("Password is required.");
        return false;
    }

    return true;
}

// ================================
// SecureBank Registration Validation
// ================================

document.addEventListener("DOMContentLoaded", function () {

    const form = document.getElementById("registerForm");

    if (!form) return;

    form.addEventListener("submit", function (e) {

        e.preventDefault();

        const firstName = document.querySelector('input[placeholder="Enter First Name"]').value.trim();
        const lastName = document.querySelector('input[placeholder="Enter Last Name"]').value.trim();
        const email = document.querySelector('input[type="email"]').value.trim();
        const mobile = document.querySelector('input[type="tel"]').value.trim();
        const accountType = document.querySelector("select").value;
        const aadhaar = document.querySelector('input[placeholder="Enter Aadhaar Number"]').value.trim();
        const password = document.getElementById("password").value;
        const confirmPassword = document.getElementById("confirmPassword").value;
        const address = document.querySelector("textarea").value.trim();
        const terms = document.querySelector(".checkbox input").checked;

        // First Name
        if (firstName.length < 2) {

            alert("Please enter a valid First Name.");

            return;

        }

        // Last Name
        if (lastName.length < 2) {

            alert("Please enter a valid Last Name.");

            return;

        }

        // Email
        const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,}$/i;

        if (!emailPattern.test(email)) {

            alert("Please enter a valid Email Address.");

            return;

        }

        // Mobile
        if (!/^[6-9][0-9]{9}$/.test(mobile)) {

            alert("Mobile Number must contain 10 digits.");

            return;

        }

        // Account Type
        if (accountType === "") {

            alert("Please select Account Type.");

            return;

        }

        // Aadhaar
        if (!/^[0-9]{12}$/.test(aadhaar)) {

            alert("Aadhaar Number must contain 12 digits.");

            return;

        }

        // Password Length
        if (password.length < 8) {

            alert("Password should contain at least 8 characters.");

            return;

        }

        // Password Match
        if (password !== confirmPassword) {

            alert("Passwords do not match.");

            return;

        }

        // Address
        if (address.length < 10) {

            alert("Please enter your complete Address.");

            return;

        }

        // Terms
        if (!terms) {

            alert("Please accept the Terms & Conditions.");

            return;

        }

        alert("Registration Successful!");

        form.reset();

    });

});

// ================================
// Deposit Validation
// ================================

function validateDeposit() {

    let amount = document.getElementById("depositAmount").value;

    if (amount === "" || Number(amount) <= 0) {

        alert("Enter a valid deposit amount.");

        return false;
    }

    return true;
}

// ================================
// Withdraw Validation
// ================================

function validateWithdraw() {

    let amount = document.getElementById("withdrawAmount").value;

    if (amount === "" || Number(amount) <= 0) {

        alert("Enter a valid withdrawal amount.");

        return false;
    }

    return true;
}

// ================================
// Transfer Validation
// ================================

function validateTransfer() {

    let account = document.getElementById("toAccount").value.trim();
    let amount = document.getElementById("transferAmount").value;

    if (account === "") {

        alert("Beneficiary Account Number is required.");

        return false;
    }

    if (amount === "" || Number(amount) <= 0) {

        alert("Enter a valid transfer amount.");

        return false;
    }

    return true;
}