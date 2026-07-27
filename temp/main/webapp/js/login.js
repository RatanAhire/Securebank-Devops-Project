// =====================================
// SecureBank Login
// =====================================

document.addEventListener("DOMContentLoaded", function () {

    const form = document.getElementById("loginForm");
    const password = document.getElementById("password");
    const toggle = document.getElementById("togglePassword");

    // ==========================
    // Show / Hide Password
    // ==========================

    toggle.addEventListener("click", function () {

        if (password.type === "password") {

            password.type = "text";

            toggle.classList.remove("fa-eye");
            toggle.classList.add("fa-eye-slash");

        } else {

            password.type = "password";

            toggle.classList.remove("fa-eye-slash");
            toggle.classList.add("fa-eye");

        }

    });

    // ==========================
    // Login Validation
    // ==========================

    form.addEventListener("submit", function (e) {

        e.preventDefault();

        const email = document.querySelector('input[type="email"]').value.trim();
        const pass = password.value.trim();

        const emailPattern =
            /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!emailPattern.test(email)) {

            alert("Please enter a valid Email Address.");

            return;

        }

        if (pass.length < 8) {

            alert("Password must be at least 8 characters.");

            return;

        }

        // ==========================
        // Demo Login
        // ==========================

        alert("Login Successful!");

        window.location.href = "dashboard.html";

    });

});