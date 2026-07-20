// ===========================================
// SecureBank Dashboard
// ===========================================

document.addEventListener("DOMContentLoaded", function () {

    // ============================
    // Welcome Message
    // ============================

    const hour = new Date().getHours();
    const heading = document.querySelector(".topbar h2");

    if (heading) {

        if (hour < 12) {

            heading.innerHTML = "Good Morning, Ratan 👋";

        } else if (hour < 17) {

            heading.innerHTML = "Good Afternoon, Ratan 👋";

        } else {

            heading.innerHTML = "Good Evening, Ratan 👋";

        }

    }

    // ============================
    // Last Login Time
    // ============================

    const loginInfo = document.querySelector(".topbar p");

    if (loginInfo) {

        const now = new Date();

        loginInfo.innerHTML =
            "Today • " +
            now.toLocaleTimeString([], {
                hour: "2-digit",
                minute: "2-digit"
            });

    }

    // ============================
    // Card Hover Animation
    // ============================

    const cards = document.querySelectorAll(".card");

    cards.forEach(function (card) {

        card.addEventListener("mouseenter", function () {

            card.style.transform = "translateY(-8px)";

        });

        card.addEventListener("mouseleave", function () {

            card.style.transform = "translateY(0px)";

        });

    });

    // ============================
    // Notification Bell
    // ============================

    const bell = document.querySelector(".profile i");

    if (bell) {

        bell.addEventListener("click", function () {

            alert(
                "No new notifications."
            );

        });

    }

    // ============================
    // Logout
    // ============================

    const logout = document.querySelector(
        'a[href="index.html"]'
    );

    if (logout) {

        logout.addEventListener("click", function (e) {

            const confirmLogout =
                confirm("Are you sure you want to logout?");

            if (!confirmLogout) {

                e.preventDefault();

            }

        });

    }

});