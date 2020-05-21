import math
import turtle

#class to create body of car
class Body:
    #color and pen as parameters
    #color assigned when instance is created, pen used as turtle object
    def __init__(self, color, pen):
        self.color = color
        self.pen = pen
        
    #method to draw and color body
    def draw(self, x, y):
        self.pen.up()
        self.pen.goto(x, y)
        self.pen.down()
        self.pen.fillcolor(self.color)
        self.pen.begin_fill()
        self.pen.forward(50)
        self.pen.right(90)
        self.pen.forward(50)
        self.pen.left(90)
        self.pen.forward(100)
        self.pen.right(90)
        self.pen.forward(50)
        self.pen.right(90)
        self.pen.forward(50)
        self.pen.right(90)
        self.pen.circle(25, 180)
        self.pen.right(90)
        self.pen.forward(40)
        self.pen.right(90)
        self.pen.circle(25, 180)
        self.pen.right(90)
        self.pen.forward(50)
        self.pen.right(90)
        self.pen.forward(50)
        self.pen.right(90)
        self.pen.forward(40)
        self.pen.left(45)
        self.pen.forward(math.sqrt(5000))
        self.pen.end_fill()


# class to draw the wheels of the car
class Wheel:
    # constructor that takes in a color and pen as params
    # defining the color and pen being used throughout the class
    def __init__(self, color, pen):
        self.color = color
        self.pen = pen

    # method to utilize backTire and frontTire methods within class
    def draw(self):
        self.backTire()
        self.frontTire()

    # method to draw the back color + color it
    def backTire(self):
        self.pen.up()
        self.pen.fillcolor(self.color)
        self.pen.left(90)
        self.pen.forward(50)
        self.pen.right(90)
        self.pen.forward(50)
        self.pen.down()
        self.pen.right(90)
        self.pen.begin_fill()
        self.pen.circle(25, 360)
        self.pen.end_fill()

    # method to draw the front color + color it
    def frontTire(self):
        self.pen.up()
        self.pen.fillcolor(self.color)
        self.pen.left(90)
        self.pen.forward(90)
        self.pen.right(90)
        self.pen.down()
        self.pen.begin_fill()
        self.pen.circle(25, 360)
        self.pen.end_fill()


# class to draw the antenna of the car
class Antenna:
    # constructor that takes a pen as the param to draw the antenna
    def __init__(self, pen):
        self.pen = pen

    # method to draw the antenna at the right place
    def draw(self, x, y):
        self.pen.up()
        self.pen.goto(x - 50, y - 50)
        self.pen.down()
        self.pen.forward(60)

#class to create window of car
class Window:
    #color and pen as parameters
    #color assigned when instance is created, pen used as turtle object
    def __init__(self, color, pen):
        self.color = color
        self.pen = pen

    #method to draw and color window
    def draw(self, x, y):
        self.pen.fillcolor(self.color)
        self.pen.begin_fill()
        self.pen.up()
        self.pen.goto(x + 5, y - 5)
        self.pen.down()
        self.pen.right(45)
        self.pen.forward(40)
        self.pen.right(90)
        self.pen.forward(40)
        self.pen.right(90)
        self.pen.forward(40)
        self.pen.right(90)
        self.pen.forward(40)
        self.pen.end_fill()

#class to create packages on car
class Packages:
    #color and pen as parameters
    #color assigned when instance is created, pen used as turtle object
    def __init__(self, color, pen):
        self.color = color
        self.pen = pen
    
    #method to draw and color packages
    def draw(self, x, y):
        self.pen.fillcolor(self.color)
        #start first package
        self.pen.begin_fill()
        self.pen.up()
        self.pen.goto(x + 70, y - 50)
        self.pen.down()
        self.pen.forward(50)
        self.pen.right(90)
        self.pen.forward(10)
        self.pen.right(90)
        self.pen.forward(20)
        self.pen.left(90)
        self.pen.forward(40)
        self.pen.left(90)
        self.pen.forward(20)
        self.pen.right(90)
        self.pen.forward(10)
        self.pen.right(90)
        self.pen.forward(50)
        self.pen.right(90)
        self.pen.forward(60)
        self.pen.end_fill()
        #close first package, start second package
        self.pen.begin_fill()
        self.pen.up()
        self.pen.goto(x + 80, y)
        self.pen.down()
        self.pen.right(90)
        self.pen.forward(40)
        self.pen.right(90)
        self.pen.forward(40)
        self.pen.right(90)
        self.pen.forward(60)
        self.pen.right(90)
        self.pen.forward(40)
        self.pen.end_fill()
        #close second package, start wires
        self.pen.up()
        self.pen.goto(x + 80, y + 40)
        self.pen.down()
        self.pen.goto(x + 50, y - 50)
        self.pen.up()
        self.pen.goto(x + 120, y + 40)
        self.pen.down()
        self.pen.goto(x + 150, y - 50)


# class to draw the lights of the car
class Lights:
    # constructor that takes in the colors of the lights, the pen, and the starting
    # coordinates as params. They will be utilized in the methods within the class
    def __init__(self, headlightsColor, taillightColor, x, y, pen):
        self.headlightsColor = headlightsColor
        self.taillightColor = taillightColor
        self.x = x
        self.y = y
        self.pen = pen

    # class to call headlights and taillights to be drawn
    def draw(self):
        self.headlights()
        self.taillights()

    # class to draw headlights and color it
    def headlights(self):
        self.pen.fillcolor(self.headlightsColor)
        self.pen.begin_fill()
        self.pen.up()
        self.pen.goto(self.x - 90, self.y - 60)
        self.pen.down()
        self.pen.right(90)
        self.pen.forward(20)
        self.pen.right(90)
        self.pen.forward(15)
        self.pen.right(90)
        self.pen.forward(20)
        self.pen.right(90)
        self.pen.forward(15)
        self.pen.end_fill()

    # class to draw taillights and color it
    def taillights(self):
        self.pen.fillcolor(self.taillightColor)
        self.pen.begin_fill()
        self.pen.up()
        self.pen.goto(self.x + 130, self.y - 60)
        self.pen.down()
        self.pen.right(90)
        self.pen.forward(20)
        self.pen.right(90)
        self.pen.forward(15)
        self.pen.right(90)
        self.pen.forward(20)
        self.pen.right(90)
        self.pen.forward(15)
        self.pen.end_fill()


def vehicle(pen, x, y, bodycolor, windowcolor, packagecolor, wheelColor, headlightsColor, taillightColor):
    #instance of Body class, passing body color and pen to draw the body
    body = Body(bodycolor, pen)
    #call draw method in Body class
    body.draw(x, y)
    #instance of Window class, passing window color and pen to draw the window
    window = Window(windowcolor, pen)
    #call draw method in Window class
    window.draw(x, y)
    #instance of Packages class, passing package color and pen to draw the packages
    packages = Packages(packagecolor, pen)
    #call draw method in Packages class
    packages.draw(x, y)
    # declaring a wheel instance and passing in wheel color and pen to be used to draw the wheel
    wheel = Wheel(wheelColor, pen)
    # calling the draw method within the wheel class
    wheel.draw()
    # declaring antenna instance and passing in the pen to be used
    antenna = Antenna(pen)
    # using the draw method within the antenna class passing in the starting coordinates
    antenna.draw(x, y)
    # declaring lights instance passing in the color, pen, and starting coordinates
    lights = Lights(headlightsColor, taillightColor, x, y, pen)
    # using the draw method within the lights class to draw the lights
    lights.draw()


# initialize the screen to be drawn on
screen = turtle.Screen()
# sets the background of screen to be white
screen.bgcolor('white')
# putting in vehicle attributes to be used to draw the vehicle
vehicle(turtle.Turtle(), 60, 60, 'blue', 'lightblue', 'red', 'black', 'yellow', 'red')
# to keep the screen open
screen.mainloop()
