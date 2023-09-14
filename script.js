const logregbox=document.querySelector('.logreg-box');
const loginLink=document.querySelector('.login_link');
const RegisterLink=document.querySelector('.register_link');

RegisterLink.addEventListener('click',()=>{
    logregbox.classList.add('active');
});
loginLink.addEventListener('click',()=>{
    logregbox.classList.remove('active');
});
