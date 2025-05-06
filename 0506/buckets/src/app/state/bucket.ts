export class Bucket {
    private _liters: number = 0;

    constructor(private _capacity: number, private _name: string = "Bucket") { }

    get name(): string { return this._name }
    get capacity(): number { return this._capacity }
    get liters(): number { return this._liters }
    get availables(): number { return this._capacity - this._liters }

    get fillPercent(): number {
        return 100 * this.liters / this.capacity
    }

    get isFull(): boolean { return this.availables == 0 }
    get isEmpty(): boolean { return this.availables == this.capacity }
    add(qty: number): void {
        qty = (this.availables <= qty) ? this.availables : qty;
        this._liters += qty
    }

    empty() {
        this._liters = 0
    }

    fill() {
        this._liters = this._capacity
    }

    transfer(b: Bucket) {
        const qty: number = this.liters <= b.availables ? this.liters : b.availables
        this._liters -= qty
        b.add(qty)
    }
}