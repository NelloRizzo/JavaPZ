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

interface UnaryOperator {
    clearDisplay?: boolean; // Optional flag to indicate if the display should be cleared after execution
    symbol: string; // The symbol representing the operator
    execute(state: CalculatorState): CalculatorState; // Function to execute the operator on a given value
}

const operators: UnaryOperator[] = [
    {
        symbol: 'sqrt',
        execute: (state: CalculatorState) => ({ ...state, display: String(Math.sqrt(Number(state.display))) }),
    },
    {
        symbol: 'sqr',
        execute: (state: CalculatorState) => ({ ...state, display: String(Number(state.display) ** 2) }),
    },
    {
        symbol: '1/x',
        execute: (state: CalculatorState) => ({ ...state, display: String(1 / Number(state.display)) }),
    },
    {
        symbol: 'C',
        execute: (state: CalculatorState) => initialState, // Reset the state to the initial state
    },
    {
        symbol: 'CE',
        execute: (state: CalculatorState) => ({ ...state, mustClearDisplay: true, display: '0' }), // Reset the state to the initial state
    },
    {
        symbol: 'back',
        clearDisplay: false, // Do not clear the display after execution
        execute: (state: CalculatorState) => ({ ...state, display: state.display.slice(0, -1) }), // Reset the state to the initial state
    },
    {
        symbol: '+-',
        clearDisplay: false, // Do not clear the display after execution
        execute: (state: CalculatorState) => ({ ...state, display: String(-Number(state.display)) }),
    },
    {
        symbol: ',',
        clearDisplay: false, // Do not clear the display after execution
        execute: (state: CalculatorState) => {
            if (state.display.length === 0) {
                state.display = '0'; // Clear the display if the flag is set
            }
            if (!state.display.includes('.')) {
                state.display += '.'; // Add a decimal point if it doesn't exist
            }
            return state; // Return the updated state
        },
    },
]

export const executeUnaryOperator = (state: CalculatorState, operator: string): CalculatorState => {
    const unaryOperator = operators.find(op => op.symbol === operator);
    if (unaryOperator) {
        if (state.mustClearDisplay) {
            state.display = ''; // Clear the display if the flag is set
            state.mustClearDisplay = false; // Reset the flag
        }
        state = unaryOperator.execute(state);
        if (state.display.length === 0)
            state.display = '0'; // Ensure display is not empty
        if (unaryOperator.clearDisplay ?? true)
            state.mustClearDisplay = true; // Set the flag to clear the display for the next input
    }
    return state;
}