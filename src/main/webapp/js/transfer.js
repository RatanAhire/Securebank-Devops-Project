/* ==========================================
        SecureBank - Transfer Page
========================================== */

document.addEventListener("DOMContentLoaded", function () {

    const form = document.querySelector(".transfer-form");

    const beneficiary = document.querySelector("input[placeholder='Enter Beneficiary Name']");
    const account = document.querySelector("input[placeholder='Beneficiary Account Number']");
    const ifsc = document.querySelector("input[placeholder='SBIN0001234']");
    const amount = document.querySelector("input[placeholder='₹ Enter Amount']");
    const transferType = document.querySelectorAll("select")[1];
    const remarks = document.querySelector("textarea");

    form.addEventListener("submit", function (e) {

        e.preventDefault();

        // Beneficiary Name
        if (beneficiary.value.trim() === "") {

            alert("Please enter Beneficiary Name.");

            beneficiary.focus();

            return;

        }

        // Account Number
        if (account.value.trim() === "") {

            alert("Please enter Beneficiary Account Number.");

            account.focus();

            return;

        }

        if (!/^[0-9]{9,18}$/.test(account.value.trim())) {

            alert("Account Number should contain 9 to 18 digits.");

            account.focus();

            return;

        }

        // IFSC Code
        if (ifsc.value.trim() === "") {

            alert("Please enter IFSC Code.");

            ifsc.focus();

            return;

        }

        if (!/^[A-Z]{4}0[A-Z0-9]{6}$/.test(ifsc.value.toUpperCase())) {

            alert("Invalid IFSC Code.");

            ifsc.focus();

            return;

        }

        // Amount
        if (amount.value === "") {

            alert("Please enter Transfer Amount.");

            amount.focus();

            return;

        }

        if (Number(amount.value) <= 0) {

            alert("Transfer Amount must be greater than ₹0.");

            amount.focus();

            return;

        }

        if (Number(amount.value) > 500000) {

            alert("Maximum transfer limit is ₹5,00,000.");

            amount.focus();

            return;

        }

        // Confirmation

        const confirmTransfer = confirm(

            "Transfer Details\n\n" +

            "Beneficiary : " + beneficiary.value +

            "\nAmount : ₹" + amount.value +

            "\nMode : " + transferType.value +

            "\n\nProceed with Transfer?"

        );

        if (!confirmTransfer) {

            return;

        }

        // Demo Processing

        const button = document.querySelector(".transfer-btn");

        button.disabled = true;

        button.innerHTML =

        '<i class="fa-solid fa-spinner fa-spin"></i> Processing...';

        setTimeout(function () {

            alert(

                "₹" + amount.value +

                " transferred successfully to " +

                beneficiary.value +

                " via " +

                transferType.value +

                "."

            );

            form.reset();

            button.disabled = false;

            button.innerHTML =

            '<i class="fa-solid fa-paper-plane"></i> Transfer Money';

        },2000);

    });

});