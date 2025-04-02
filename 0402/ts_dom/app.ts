document.addEventListener('DOMContentLoaded', () => {
    const input: HTMLInputElement = document.querySelector('input')!
    const button: HTMLButtonElement = document.querySelector('button')!
    const ul: HTMLUListElement = document.querySelector('ul')!

    button.setAttribute('disabled', 'disabled')

    button.addEventListener('click', (ev: MouseEvent) => {
        const li: HTMLLIElement = document.createElement('li')
        li.appendChild(document.createTextNode(input.value))
        ul.appendChild(li)
    })

    input.addEventListener('blur', (ev: Event) => {
        const { value } = ev.target as HTMLInputElement
        if (value.length === 0)
            button.setAttribute('disabled', 'disabled')
        else
            button.removeAttribute('disabled')
    })
})