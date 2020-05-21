from Plot import Plot


class LineGraph(Plot):
    def __init__(self, data, topic, locations):
        super().__init__(data)
        self.topic = self._getTopic(topic)
        self.locations = locations

    # uses superclass to draw and plot data points for specified graph type
    def plot(self):
        self._initFigure()
        self._setTitle(self.locations)
        self._setLabels(self.topic)
        self._lineGraph(self._setXAxis())

