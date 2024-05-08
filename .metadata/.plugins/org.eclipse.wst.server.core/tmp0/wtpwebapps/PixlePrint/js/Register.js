/**
 * 
 */

 function checkForm() {
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;
    var fullName = document.getElementById('fullName').value;
    var phoneNumber = document.getElementById('phoneNumber').value;
    var errorElement = document.getElementById('passwordError');
    var registerButton = document.getElementById('registerButton');

    if (password !== confirmPassword) {
        errorElement.textContent = 'Password dont match';
        errorElement.style.textAlign= 'center';
        errorElement.style.backgroundColor= 'red';
        errorElement.style.padding= '10px';
        errorElement.style.color= '#fff';
        disableButton();
        return;
    } else if(password.length && confirmPassword.length) {
        errorElement.textContent = 'Form is ready!';
        errorElement.style.textAlign= 'center';
        errorElement.style.backgroundColor= 'green';
        errorElement.style.padding= '10px';
        errorElement.style.color= '#fff';
    }

    if (fullName.trim() === '' || phoneNumber.trim() === '') {
        errorElement.textContent = 'complete the form';
        errorElement.style.textAlign= 'center';
        errorElement.style.fontWeight= '600';
        errorElement.style.backgroundColor= 'red';
        errorElement.style.padding= '10px';
        errorElement.style.color= '#fff';
        disableButton();
        return;
    }

    enableButton();
}

function disableButton() {
    var registerButton = document.getElementById('registerButton');
    registerButton.disabled = true;
}

function enableButton() {
    var registerButton = document.getElementById('registerButton');
    registerButton.disabled = false;
}

function redirectToLogin() {
    window.location.href = '#';
}

// Call checkForm on input events
document.getElementById('password').addEventListener('input', checkForm);
document.getElementById('confirmPassword').addEventListener('input', checkForm);
document.getElementById('fullName').addEventListener('input', checkForm);
document.getElementById('phoneNumber').addEventListener('input', checkForm);

// Call checkForm on page load to handle initial state
document.addEventListener('DOMContentLoaded', checkForm);