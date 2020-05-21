import csv
import urllib.request
import codecs
from datetime import datetime


class DataHandler:
    def __init__(self):
        self.data = self.__getData()
        self.targetData = {}

    # To get data from a csv URL
    # Data is formatted to have:
    # Date, Location, New Cases, New Deaths, Total Cases, and Total Deaths
    def __getData(self):
        url = 'https://covid.ourworldindata.org/data/ecdc/full_data.csv'
        ftpstream = urllib.request.urlopen(url)
        csvfile = csv.reader(codecs.iterdecode(ftpstream, 'utf-8'))

        return csvfile

    # topic is a numeric user input
    def getDataPoints(self, location, topic):
        for line in self.data:
            if location.lower() == line[1].lower():
                dateSplit = line[0].split('-')
                date = dateSplit[1] + dateSplit[2] + dateSplit[0]
                self.targetData[datetime.strptime(date, '%m%d%Y')] = line[topic]
        return self.targetData

    def getXMin(self):
        return min(self.targetData.keys())

    def getXMax(self):
        return max(self.targetData.keys())

    def getYMin(self):
        return min(self.targetData.values())

    def getYMax(self):
        return max(self.targetData.values())

    # get selectable locations
    def getUniqueLocations(self):
        locations = []
        for line in self.data:
            if line[1] not in locations and line[1] != "location":
                locations.append(line[1])
        return locations
