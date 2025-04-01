document.addEventListener('DOMContentLoaded', () => {
    let data = {
        name: '',
        surname: '',
        phone: '',

        isValid() {
            return (this.name.length * this.surname.length
                * this.phone.length) != 0
        }
    }

    const button = document.querySelector('button')
    const checkButton = () => {
        if (!data.isValid())
            button.setAttribute('disabled', 'disabled')
        else
            button.removeAttribute('disabled')
    }
    checkButton()

    document.querySelectorAll("input[type='text']").forEach(e =>
        e.addEventListener('change', (ev) => {
            // {} = tupla
            const { name, value } = ev.target
            data = { ...data, [name]: value }
            checkButton()
        })
    )

    document.querySelector('button').addEventListener('click', () =>{
        const ul = document.querySelector('ul')
        const li = document.createElement('li')
        const text = document.createTextNode(`${data.name} ${data.surname} ${data.phone}`)
        li.appendChild(text)
        ul.appendChild(li)
    })
})