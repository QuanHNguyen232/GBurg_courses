"use strict";
class Circle {
    /**
    * Contructor: Creates an instance of Triangle.
    * @param {float} offsetX the center of the Triangle on the x axis.
    * @param {float} offsetY the center of the Triangle on the y axis.
    */
    constructor(offsetX, offsetY, radius, startColor, endColor, noOfTriangles = 100000){
        // assign properties of the Triangle object.
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        // this.color   = color;
        this.startColor = startColor;
        this.endColor   = endColor;
        this.noOfTriangles = noOfTriangles;

        
        // TODO: enter values for position data.
        this.position = this.createCircleArray(radius)
        // TODO: add another property (array) for the color data and enter values.
        // this.color =  [
        //     1, 0, 0,
        //     0, 1, 0,
        //     0, 0, 1,
        // ]

        // const color_length = this.position.length / 2 * 3
        // this.color   = Array(Math.floor(this.position.length / 2 * 3)).fill(this.color)

        this.color = this.genLerpColor(this.startColor, this.endColor)

        //Do as following: create buffer, put some data. Done, we can read it later with vertex attrib pointer if we bind it
        this.positionBuffer = gl.createBuffer();
        gl.bindBuffer(gl.ARRAY_BUFFER, this.positionBuffer)
        gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(this.position), gl.STATIC_DRAW)

        this.colorBuffer = gl.createBuffer();
        gl.bindBuffer(gl.ARRAY_BUFFER, this.colorBuffer)
        gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(this.color), gl.STATIC_DRAW)

        // TODO: repeat for color buffer.
        // a_color is a vec3, so vertexSize needs to be 3!
        this.vertexCount = this.position.length / 2;

	}

    genLerpColor = (begin, end) => {
        const numOfPoints = this.position.length / 2

        const [a, b, c] = begin;
        const [d, e, f] = end;
        const increaseR = (d - a) / (numOfPoints)
        const increaseB = (e - b) / (numOfPoints)
        const increaseG = (f - c) / (numOfPoints)

        let color = []
        for (let i = 0; i < numOfPoints; i += 1) {
            color.push(a + increaseR * i)
            color.push(b + increaseB * i)
            color.push(c + increaseG * i)
        }

        return color
    }

    createCircleArray = (radius) => {
        //Angle for each isocelete triangles
        const radToDeg = 180 / Math.PI
        const alpha = 2 * Math.PI / this.noOfTriangles;

        //Array contains the center of the circle at (0, 0)
        //First vertex
        const array =  [0, 0];

        //Second vertex and the rest
        for (let i = 0; i <= this.noOfTriangles; i ++) {
            const x = radius * Math.cos(alpha * i);
            const y = radius * Math.sin(alpha * i);
            array.push(x)
            array.push(y)
        }

        return new Float32Array(array);
    }
};
