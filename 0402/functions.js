function work(n) {

    function doIt() {
        console.log("doIt()")
    }

    const myFunc = function (x) {
        return x * x
    }

    console.log(n)
    doIt()
    console.log(myFunc(n))
}

work(2)