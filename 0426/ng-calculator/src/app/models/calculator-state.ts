export interface CalculatorState {
    display: string; // The current display value of the calculator
}

export const initialState: CalculatorState = {
    display: '0' // Initial display value is set to '0'
};