document.addEventListener('DOMContentLoaded', () => {
    const status = {
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
    // inizializzo il display
    showDisplay()
})