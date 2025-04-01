document.addEventListener('DOMContentLoaded', () => {
    let status = {
        // ciò che deve essere visualizzato sul display
        display: '0',
        // il valore attualmente in memoria
        accumulator: 0,
        // la prossima operazione da eseguire
        operation: '=',
        // indica se prima di scrivere sul display occorre 
        // eliminare quanto contenuto sul display
        mustClearDisplay: true
    }
    // mostra il display
    const showDisplay = () => {
        document.querySelector('.display').innerText = status.display
    }
    // aggiunge una cifra al display
    const addDigit = (d) => {
        // se occorre cancellare il display, lo cancella
        if (status.mustClearDisplay) status.display = ''
        // lo zero è possibile solo se ci sono altre cifre
        if ((d === '0' && status.display.length > 0) || d !== '0')
            // aggiunge la cifra al display
            status.display += d
        // se il display è vuoto
        if (status.display.length === 0) {
            // ci scrive uno 0
            status.display = '0'
            // ma dice che alla prossima cifra deve essere nuovamente cancellato
            status.mustClearDisplay = true
        } else
            // altrimenti la prossima cifra può essere aggiunta alle precedenti
            status.mustClearDisplay = false
        // alla fine visualizza il display
        showDisplay()
    }

    const executeOp = (op) => {
        switch (status.operation) {
            case '+':
                status.accumulator += 1 * status.display
                break;
            case '-':
                status.accumulator -= status.display
                break;
            case '*':
                status.accumulator *= status.display
                break;
            case '/':
                status.accumulator /= status.display
                break;
            default:
                status.accumulator = 1 * status.display
        }
        // scrive l'accumulatore sul display
        status.display = `${status.accumulator}`
        // indica che la prossima cifra inizia un nuovo numero
        status.mustClearDisplay = true
        // memorizza l'operazione da eseguire successivamente
        status.operation = op
        showDisplay()
    }
    // inizializzo il display
    showDisplay()

    document.querySelectorAll('.digit').forEach(e =>
        e.addEventListener('click', () => {
            // recupero in qualche modo il valore da aggiungere al display
            const digit = e.getAttribute('data-digit')
            // e lo passo al metodo addDigit
            addDigit(digit)
        }))
    document.querySelectorAll('.operator').forEach(e =>
        e.addEventListener('click', () => {
            const op = e.getAttribute('data-op')
            executeOp(op)
        })
    )
})