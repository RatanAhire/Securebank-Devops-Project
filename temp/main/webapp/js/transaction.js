/* ==========================================
        TRANSACTION PAGE
========================================== */

// FIX: Declare variables globally so all functions below can see them
let searchInput;
let tableRows;

document.addEventListener("DOMContentLoaded", function () {

    searchInput = document.querySelector(".search-box input");
    tableRows = document.querySelectorAll(".transaction-table tbody tr");

    // ==========================================
    // Search Transaction ID
    // ==========================================
    // Guard check prevents errors if the search box is missing on some pages
    if (searchInput) {
        searchInput.addEventListener("keyup", function () {
            const value = this.value.toLowerCase();

            tableRows.forEach(function (row) {
                const txnId = row.cells[0].textContent.toLowerCase();

                if (txnId.includes(value)) {
                    row.style.display = "";
                } else {
                    row.style.display = "none";
                }
            });
        });
    }

    // ==========================================
    // Row Highlight (Moved inside or runs safely now)
    // ==========================================
    tableRows.forEach(function(row){
        row.addEventListener("click", function(){
            tableRows.forEach(function(r){
                r.style.background = "";
            });
            this.style.background = "#eef5ff";
        });
    });

});

// ==========================================
// Filter Button
// ==========================================
const filterButton = document.querySelector(".filter-btn");
if (filterButton) {
    filterButton.addEventListener("click", function(){
        alert("Filter Applied Successfully!\n\nDemo Version");
    });
}

// ==========================================
// View Receipt
// ==========================================
const receiptButtons = document.querySelectorAll(".receipt-btn");
receiptButtons.forEach(function(button){
    button.addEventListener("click", function(){
        const row = this.closest("tr");
        const txn = row.cells[0].innerText;
        const amount = row.cells[4].innerText;
        const status = row.cells[6].innerText;

        alert(
            "Transaction Receipt\n\n" +
            "Transaction ID : " + txn +
            "\nAmount : " + amount +
            "\nStatus : " + status +
            "\n\nThank you for banking with SecureBank."
        );
    });
});

// ==========================================
// Download Buttons
// ==========================================
const pdfBtn = document.querySelector(".pdf-btn");
if (pdfBtn) {
    pdfBtn.addEventListener("click", function(){
        alert("Downloading PDF Statement...\n\nDemo Version");
    });
}

const excelBtn = document.querySelector(".excel-btn");
if (excelBtn) {
    excelBtn.addEventListener("click", function(){
        alert("Downloading Excel Statement...\n\nDemo Version");
    });
}

const printBtn = document.querySelector(".print-btn");
if (printBtn) {
    printBtn.addEventListener("click", function(){
        window.print();
    });
}

// ==========================================
// Card Hover Effect
// ==========================================
const cards = document.querySelectorAll(".stat-card");
cards.forEach(function(card){
    card.addEventListener("mouseenter", function(){
        this.style.transform = "translateY(-8px)";
    });

    card.addEventListener("mouseleave", function(){
        this.style.transform = "translateY(0px)";
    });
});

// ==========================================
// Welcome
// ==========================================
console.log("SecureBank Transaction Module Loaded Successfully");
