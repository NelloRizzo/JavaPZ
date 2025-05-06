export default class Fraction {
    private _numerator: number = 0
    private _denominator: number = 1
    private _signum: number = 1

    get numerator(): number { return this._numerator }
    get denominator(): number { return this._denominator }
    get signum(): number { return this._signum }

    asFloat(): number { return this.signum * this.numerator / this.denominator }
    public static gcd(a: number, b: number): number {
        if (b > a) [a, b] = [b, a]
        if (b == 0) return a
        return this.gcd(b, a % b)
    }

    private constructor(n: number, d: number) {
        this._numerator = Math.abs(Math.floor(n))
        this._denominator = Math.abs(Math.floor(d))
        this._signum = Math.sign(n * d)
        const gcd = Fraction.gcd(this._numerator, this._denominator);
        this._denominator /= gcd
        this._numerator /= gcd
    }

    public static from(numerator: number, denominator?: number): Fraction {
        if (denominator)
            return new Fraction(numerator, denominator)
        return new Fraction(numerator * 1000, 1000)
    }
    public static of(fraction: string) {
        const re: RegExp = /^(?<signum>[\+-]?)(?<numerator>\d+)\/(?<denominator>\d*)$/
        const result = re.exec(fraction)
        const num =
            Number.parseInt(result!.groups!["numerator"]) *
            ((result!.groups!["signum"] ?? '+') === '-' ? -1 : 1)
        const den = Number.parseInt(result!.groups!["denominator"])
        return new Fraction(num, den)
    }
}