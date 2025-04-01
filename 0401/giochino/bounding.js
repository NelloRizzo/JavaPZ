document.addEventListener('DOMContentLoaded', () => {
    const ball = document.querySelector('.ball')
    let angle=0
    let dx = 1
    let dy = 1
    let time = 10
    let top = 0
    let left = 0
    let hits = 0

    const move = () => {
        top += dy
        left += dx
        if (top < 0 || top > 220) dy = -dy
        if (left < 0 || left > 270) dx = -dx
        ball.style.setProperty('top', top + 'px')
        ball.style.setProperty('left', left + 'px')
        setTimeout(() => move(), time)
    }
    move()

    document.querySelector('input').addEventListener('change',
        ev => { time = 1 * ev.target.value })
    document.querySelector('.ball').addEventListener('click', () => {
        dx = -dx
        dy = -dy
        hits++
        document.querySelector('span').innerText = hits
    })
})
