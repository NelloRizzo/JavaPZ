document.addEventListener('DOMContentLoaded', () => {
    let angle = 0
    let c = { x: 150, y: 150 }
    let radius = 80
    const ball = document.querySelector('.ball')
    const move = () => {
        const x = c.x + radius * Math.cos(angle)
        const y = c.y + radius * Math.sin(angle)
        ball.style.setProperty('top', y - 15 + 'px')
        ball.style.setProperty('left', x - 15 + 'px')
        angle += .01
        setTimeout(() => move(), 10)
    }
    move()
})