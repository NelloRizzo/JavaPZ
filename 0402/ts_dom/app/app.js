"use strict";
document.addEventListener('DOMContentLoaded', () => {
    const input = document.querySelector('input');
    const button = document.querySelector('button');
    const ul = document.querySelector('ul');
    button.setAttribute('disabled', 'disabled');
    button.addEventListener('click', (ev) => {
        const li = document.createElement('li');
        li.appendChild(document.createTextNode(input.value));
        ul.appendChild(li);
    });
    input.addEventListener('blur', (ev) => {
        const { value } = ev.target;
        if (value.length === 0)
            button.setAttribute('disabled', 'disabled');
        else
            button.removeAttribute('disabled');
    });
});
