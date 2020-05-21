from DataHandler import DataHandler
from LineGraph import LineGraph
from BarGraph import BarGraph


class Menu:
    def __init__(self):
        self.getSelectableLocations = DataHandler().getUniqueLocations()
        self.selectedLocations = []
        self.selectedTopic = 0

    # start and end of user menu selections
    def menu(self):
        print("Thank you for choosing COVID\n")

        # User selects multiple locations
        self.userSelectedLocations()
        # User selects one topic
        self.userSelectedTopic()
        # User selects one type of graph
        self.userSelectedGraph()

        print("Your results are in! See you next time!")

    # ask for locations to compare
    def userSelectedLocations(self):
        print("\nSelectable countries:\n")
        self.printSelectableLocations()
        print("\nSelected countries: ", self.selectedLocations)
        userInput = input("Please select the countries of which you want to compare"
                          " or enter '-1' to finish selection (Selectable countries are listed above): ")

        # store valid selection and determine if finished selecting
        if self.validateLocationInput(userInput):
            self.selectedLocations.append(userInput.title())
            self.userSelectedLocations()
        elif not self.selectedLocations:
            print("Please enter at least one location to look at or to compare to.")
            self.userSelectedLocations()
        elif userInput == "-1":
            print("Locations selected are: ", self.selectedLocations)
        else:
            print("Invalid Location Entered. Please try again.")
            self.userSelectedLocations()

    # validate user selection of topic
    def userSelectedTopic(self):
        print("Topics\n1) New Cases\n2) New Deaths\n3) Total Cases\n4) Total Deaths")
        userInput = input("Please select the number corresponding to the topic you would want to compare: ")
        try:
            if int(userInput) in range(1, 5):
                self.selectedTopic = int(userInput) + 1
            else:
                print("Invalid input. Please try again.")
                self.userSelectedTopic()
        except ValueError:
            print("Not an integer! Try again.")
            self.userSelectedTopic()

    # validate user selection of desired graph type
    def userSelectedGraph(self):
        print("Graph Types\n1) Line Graph\n2) Bar Chart")
        userInput = input("Please select the number corresponding to the graph type you would want: ")
        try:
            if int(userInput) not in range(1, 3):
                print("Invalid input. Please try again.")
                self.userSelectedGraph()
        except ValueError:
            print("Not an integer! Try again.")
            self.userSelectedGraph()

        self.selectGraph(userInput)

    # handle which graph to plot with then plot with resulting data
    def selectGraph(self, userInput):
        global graph
        for location in self.selectedLocations:
            if userInput == "1":
                graph = self.lineGraph(location)
            elif userInput == "2":
                graph = self.barGraph(location)
            graph.plot()
        graph.show()

    # plot for line graph
    def lineGraph(self, location):
        return LineGraph(DataHandler().getDataPoints(location, self.selectedTopic),
                         self.selectedTopic, location)

    # plot for bar graph
    def barGraph(self, location):
        return BarGraph(DataHandler().getDataPoints(location, self.selectedTopic),
                        self.selectedTopic, location)

    # validate user input for location if input is within selectable countries
    def validateLocationInput(self, userInput):
        if userInput.upper() in (location.upper() for location in self.getSelectableLocations):
            return True
        return False

    # print selectable location in 3 columns
    def printSelectableLocations(self):
        listOfLocations = self.getSelectableLocations
        for a, b, c in zip(listOfLocations[::3], listOfLocations[1::3], listOfLocations[2::3]):
            print('{:<50}{:<50}{:<}'.format(a, b, c))


if __name__ == '__main__':
    Menu().menu()
