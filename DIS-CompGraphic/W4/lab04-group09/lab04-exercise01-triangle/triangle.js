"use strict";
class Triangle{
    /**
    * Contructor: Creates an instance of Triangle.
    * @param {float} offsetX the center of the Triangle on the x axis.
    * @param {float} offsetY the center of the Triangle on the y axis.
    */
    constructor(offsetX, offsetY){
        // assign properties of the Triangle object.
        this.offsetX = offsetX;
        this.offsetY = offsetY;

        
        // TODO: enter values for position data.
        this.position =  [
            -0.25, -0.25,
            0.25, -0.25,
            0.0, 0.25
        ]

        // TODO: add another property (array) for the color data and enter values.
        this.color =  [
            1, 0, 0,
            0, 1, 0,
            0, 0, 1,
        ]

        //Do as following: create buffer, put some data. Done, we can read it later with vertex attrib pointer if we bind it
        this.positionBuffer = gl.createBuffer();
        gl.bindBuffer(gl.ARRAY_BUFFER, this.positionBuffer)
        gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(this.position), gl.STATIC_DRAW)

        this.colorBuffer = gl.createBuffer();
        gl.bindBuffer(gl.ARRAY_BUFFER, this.colorBuffer)
        gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(this.color), gl.STATIC_DRAW)

        // TODO: repeat for color buffer.
        // a_color is a vec3, so vertexSize needs to be 3!
        this.vertexCount = 3;

	}
};
