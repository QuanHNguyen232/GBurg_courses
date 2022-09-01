// add an event listener that calls keyDownFunction
// whenever any key is pressed.
window.addEventListener("keydown", keyDownFunction);

function keyDownFunction(event){
    if(event.key === "ArrowDown"){
        console.log("pressed down")
    }
}