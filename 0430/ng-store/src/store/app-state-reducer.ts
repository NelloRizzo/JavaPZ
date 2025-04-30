import { createReducer, on } from "@ngrx/store";
import { initialState } from "./app-state";
import { decrement, increment, incrementBy, reset } from "./app-state-actions";

export const stateReducer = createReducer(
    initialState,
    on(increment, s => ({ ...s, counterValue: s.counterValue + 1 })),
    on(decrement, s => ({ ...s, counterValue: s.counterValue - 1 })),
    on(reset, s => ({ ...s, counterValue: 0 })),
    on(incrementBy, (s, { amount }) => ({ ...s, counterValue: s.counterValue + amount }))
)

export default stateReducer 