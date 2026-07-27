/* ==========================================
        SecureBank - Withdraw Page
========================================== */

document.addEventListener("DOMContentLoaded", function () {

    const form = document.querySelector(".withdraw-form");

    const accountNumber = form.querySelector("input[placeholder='Enter Account Number']");
    const accountHolder = form.querySelector("input[placeholder='Account Holder Name']");
    const amount = form.querySelector("input[placeholder='₹ Enter Amount']");
    const method = form.querySelector("select");
    const remarks = form.querySelector("textarea");

    form.addEventListener("submit", function (e) {

        e.preventDefault();

        if (accountNumber.value.trim() === "") {

            alert("Please enter Account Number.");

            accountNumber.focus();

            return;

        }

        if (accountHolder.value.trim() === "") {

            alert("Please enter Account Holder Name.");

            accountHolder.focus();

            return;

        }

        if (amount.value === "" || Number(amount.value) <= 0) {

            alert("Please enter a valid withdrawal amount.");

            amount.focus();

            return;

        }

        if (Number(amount.value) > 50000) {

            alert("Daily withdrawal limit is ₹50,000.");

            amount.focus();

            return;

        }

        alert(

            "Withdrawal Request Submitted Successfully!\n\n" +

            "Account : " + accountNumber.value +

            "\nAmount : ₹" + amount.value +

            "\nMethod : " + method.value

        );

        form.reset();

    });

});