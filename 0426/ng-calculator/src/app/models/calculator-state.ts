export interface CalculatorState {
    display: string; // The current display value of the calculator
    mustClearDisplay: boolean; // Flag to indicate if the display should be cleared
    nextOperator: string; // The next operator to be executed
    accumulator: number; // The accumulated value for calculations
}

export const initialState: CalculatorState = {
    display: '0', // Initial display value is set to '0'
    mustClearDisplay: true, // Initially, the display must be cleared
    nextOperator: '=',
    accumulator: 0 // Initial accumulator value is set to 0
};

export const addDigit = (state: CalculatorState, digit: number): CalculatorState => {
    if (state.mustClearDisplay) {
        state.display = ''; // If the display must be cleared, set it to the digit
    }
    if (digit !== 0 || state.display.length > 0) {
        state.display += String(digit);
    }
    if (state.display.length === 0) {
        state.display = '0'
    }
    state.mustClearDisplay = state.display === '0'
    return state;
}

export const executeBinaryOperator = (state: CalculatorState, operator: string): CalculatorState => {
    switch (state.nextOperator) {
        case '+':
            state.accumulator += Number(state.display);
            break;
        case '-':   
            state.accumulator -= Number(state.display);
            break;
        case '*':
            state.accumulator *= Number(state.display); 
            break;
        case '/':
            state.accumulator /= Number(state.display);
            break;
        default:
            state.accumulator = Number(state.display);
            break;
    }
    state.display = String(state.accumulator);
    state.mustClearDisplay = true; // Set the flag to clear the display for the next input
    state.nextOperator = operator; // Update the next operator to the one clicked
    return state;
}   