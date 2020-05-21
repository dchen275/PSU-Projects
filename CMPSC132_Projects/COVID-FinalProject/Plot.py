import matplotlib.pyplot as plt
from matplotlib.pyplot import plot, draw, show, bar
from matplotlib import dates, pyplot
import matplotlib


class Plot:
    # initialize plot with data to use
    def __init__(self, data):
        self.data = data

    # title the graph
    def _setTitle(self, title):
        plt.title(title)

    # labeling the graph with date vs topic
    def _setLabels(self, topic):
        plt.xlabel("Date")
        plt.ylabel(topic)

    # initialize graph
    def _initFigure(self):
        plt.figure()

    # get topic
    def _getTopic(self, topic):
        if topic == 2:
            return "New Case"
        elif topic == 3:
            return "New Deaths"
        elif topic == 4:
            return "Total Cases"
        else:
            return "Total Deaths"

    # set xaxis
    def _setXAxis(self):
        ax = pyplot.gca()
        xaxis = dates.date2num(list(self.data.keys()))
        hfmt = dates.DateFormatter('%m\n%d')
        ax.xaxis.set_major_formatter(hfmt)
        ax.get_yaxis().set_major_formatter(
            matplotlib.ticker.FuncFormatter(lambda x, p: format(int(x), ',')))
        return xaxis

    # plot on line graph
    def _lineGraph(self, xaxis):
        plot(xaxis, list(map(int, self.data.values())))
        draw()

    # plot on bar graph
    def _barGraph(self, xaxis):
        bar(xaxis, list(map(int, self.data.values())))
        draw()

    # lay out the plot graph, plot points, and draws the graph
    # NOTE this does not show the graph. USE show() to show the graph
    def plot(self):
        raise NotImplementedError("Subclasses should implement this!")

    # to show the graph
    def show(self):
        show()
