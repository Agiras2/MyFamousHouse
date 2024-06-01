document.addEventListener('DOMContentLoaded', () => {
    let menu = document.querySelector('.header .menu');

    document.querySelector('#menu-btn').onclick = () => {
        menu.classList.toggle('active');
    }

    window.onscroll = () => {
        menu.classList.remove('active');
    }

    document.querySelectorAll('input[type="number"]').forEach(inputNumber => {
        inputNumber.oninput = () => {
            if (inputNumber.value.length > inputNumber.maxLength) inputNumber.value = inputNumber.value.slice(0, inputNumber.maxLength);
        };
    });

    document.querySelectorAll('.view-property .details .thumb .small-images img').forEach(images => {
        images.onclick = () => {
            let src = images.getAttribute('src');
            document.querySelector('.view-property .details .thumb .big-image img').src = src;
        }
    });

    document.querySelectorAll('.faq .box-container .box h3').forEach(headings => {
        headings.onclick = () => {
            headings.parentElement.classList.toggle('active');
        }
    });

    // Añadir evento de clic para el logout
    document.querySelector('.logout-link').onclick = () => {
        window.location.href = 'LogoutServlet';
    }

    // Lógica del temporizador de inactividad
    let timer;
    const logoutURL = '/realstate/LogoutServlet';

    function resetTimer() {
        clearTimeout(timer);
        timer = setTimeout(logout, 900000); // 15 minutes in milliseconds
    }

    function logout() {
        window.location.href = logoutURL;
    }

    window.onload = resetTimer;
    window.onmousemove = resetTimer;
    window.onkeypress = resetTimer;
});