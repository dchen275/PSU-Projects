import math
import pprint
import requests
import matplotlib.pyplot as plt
from matplotlib.pyplot import plot, draw, show, legend


# get data from link
def getData():
    link = "https://data.giss.nasa.gov/gistemp/tabledata_v3/GLB.Ts+dSST.txt"
    f = requests.get(link)
    return f.text


def splitTemps():
    # split the data into a list for every line
    data = getData()
    lines = data.split('\n')
    # initializing variables to use
    monthTemps = {}
    sumOfTemps = 0
    validTemps = 0
    try:
        # for every line after the 8th line
        for line in lines[8:]:
            # if the line is empty or starts with "Year" skip line if line
            # starts with "Divide" break loop
            if line is "" or "Year" in line:
                continue
            elif "Divide" in line:
                break
            # initialize a temporary list to store temperatures
            temps = []
            # splits the line by every blank space
            tempsInLine = line.split()
            # grabbing temperatures excluding the years
            for temp in tempsInLine[1:-1]:
                temps.append(tempConversion(temp))
            # storing list into dictionary with year as key
            for temp in temps:
                if isinstance(temp, float):
                    sumOfTemps += temp
                    validTemps += 1
            monthTemps[tempsInLine[0]] = temps
        return [monthTemps, sumOfTemps / validTemps]
    except Exception as e:
        print(e)


def tempConversion(temp):
    if "*" in temp:
        return temp
    else:
        fahrenheit = float(temp) / 100 * (9 / 5) + 57.2
        return fahrenheit


def monthlyTemps(temps):
    monthTemps = {}
    # number of month - 1
    # indicating each key will have a list to append to
    monthTemps.setdefault(0, [])
    monthTemps.setdefault(1, [])
    monthTemps.setdefault(2, [])
    monthTemps.setdefault(3, [])
    monthTemps.setdefault(4, [])
    monthTemps.setdefault(5, [])
    monthTemps.setdefault(6, [])
    monthTemps.setdefault(7, [])
    monthTemps.setdefault(8, [])
    monthTemps.setdefault(9, [])
    monthTemps.setdefault(10, [])
    monthTemps.setdefault(11, [])

    # adding temps by month
    for value in temps.values():
        for i in range(len(value)):
            if i < 12:
                monthTemps[i].append(value[i])

    return monthTemps


def meanMonthTemps(monthTemps):
    # new dictionary with mean monthly temps
    meanTemps = {}
    # key for dictionary
    counter = 0
    for value in monthTemps.values():
        meanTemp = 0  # initializing starting temp
        c = 0  # counting months
        for temp in value:
            if isinstance(temp, float) and value.index(temp) < 12:
                meanTemp += float(temp)
                c += 1
        # calculating mean of temps
        mean = meanTemp / c
        # storing mean into dictionary
        meanTemps[counter] = mean
        counter += 1

    return meanTemps


def indexOfMonthYear(month, year, data):
    # to iterate through it later
    temp = list(data.items())
    # numeric month is 1 more than indexing
    month = int(month) - 1
    iMonth = 0
    # get index of key if match
    iYear = [idx for idx, key in enumerate(temp) if key[0] == year]
    # get index of value if match
    for i in range(len(temp[iYear[0]][1])):
        if temp[iYear[0]][1][i] == str(month):
            iMonth = i
    return iMonth, iYear


def monthYearByIndex(iMonth, iYear, data):
    # get year if index match
    year = [key[0] for idx, key in enumerate(data.items()) if idx == int(iYear)]
    # get month if index match
    month = [idx + 1 for idx, value in enumerate(data.values()) if idx == int(iMonth)]
    return month, year


def annualAvgTemps(temps):
    jdTemps = []
    for value in temps.values():
        for i in range(len(value)):
            if i == 12:
                jdTemps.append(value[i])

    return jdTemps


# Python program to get transpose
# elements of two dimension list
def transpose(l1):
    l2 = []
    # iterate over list l1 to the length of an item
    for i in range(len(l1[0])):
        # print(i)
        row = []
        for item in l1:
            # appending to new list with values and index positions
            # i contains index position and item contains values
            row.append(item[i])
        l2.append(row)
    return l2


def plotAvgYearTemp(x, y, startYear, endYear):
    plt.figure()
    plt.title("Plot of Year vs. Temperature Between " + str(startYear) + "-" + str(endYear))
    plt.xlabel("Years")
    plt.ylabel("Temperature")
    # new dict to match year to temps
    plots = getPlotPoints(x, y, startYear, endYear)

    # boundaries
    plt.xlim(int(min(list(plots.keys()))), int(max(list(plots.keys()))))
    plt.ylim(round_down(min(list(plots.values())), 1), round_up(max(list(plots.values())), 1))
    # plotting
    plot(list(map(int, plots.keys())), list(plots.values()))
    draw()


def plotAvgMonthTemp(x, y, startYear, endYear):
    plt.figure()
    plt.title("Plot of Year vs. Temperature Between " + str(startYear) + "-" + str(endYear))
    plt.xlabel("Years")
    plt.ylabel("Temperature")

    # new dict to make year to temps
    plots = getPlotPoints(x, y, startYear, endYear)

    # change to list and find min/max
    plt.xlim(int(min(list(plots.keys()))), int(max(list(plots.keys()))))
    # find min and max of the lists within list then the min max of those to round to the nearest 1 decimal
    plt.ylim(round_down(min(list(map(float, min(plots.values())))), 1) - 0.5,
             round_up(max(list(map(float, max(plots.values())))), 1) + 0.5)
    # index of month counter
    counter = 0
    # flip temps by year to temps by months
    months = transpose(list(plots.values()))
    # plotting
    for month in months:
        if counter < 12:
            plot(list(map(int, plots.keys())), month, label=monthNames(counter))

        counter += 1
    legend()
    draw()


# returns dictionary for linking years to temps
def getPlotPoints(years, temps, startYear, endYear):
    # making x, y into iterable lists
    years = list(years)
    temps = list(temps)
    plots = {}
    for i in range(len(years)):
        if startYear <= int(years[i]) <= endYear and not isinstance(temps[i], str):
            plots[years[i]] = temps[i]
    return plots


def getMeanOfTemps(tempsByYear):
    sumOfTemps = 0
    validTemps = 0
    for temps in tempsByYear:
        for temp in tempsByYear[temps]:
            if isinstance(temp, float):
                sumOfTemps += temp
                validTemps += 1
    return sumOfTemps / validTemps


def plotPoints(x, y):
    try:
        plt.figure()
        plt.title("Plot of Year vs. Temperature of " + monthNames(y[0]))
        plt.xlabel("Years")
        plt.ylabel("Temperature")
        # gets the years from the dict
        years = [key for idx, key in enumerate(x)]
        # removing missing values
        temp = [x for x in y[1] if not isinstance(x, str)]
        for i in range(len(y[1])):
            if isinstance(y[1][i], str):
                years.remove(years[i])
        # setting boundaries
        plt.xlim(int(min(years)), int(max(years)))
        plt.ylim(round_down(min(temp), 1), round_up(max(temp), 1))
        # plotting
        plot(list(map(int, years)), temp)
        draw()

    except TypeError:
        print("Fail")


def round_up(n, decimals=0):
    multiplier = 10 ** decimals
    return math.floor(n * multiplier + 1) / multiplier


def round_down(n, decimals=0):
    multiplier = 10 ** decimals
    return math.floor(n * multiplier) / multiplier


def monthNames(numericMonth):
    if numericMonth is 0:
        return "January"
    elif numericMonth is 1:
        return "February"
    elif numericMonth is 2:
        return "March"
    elif numericMonth is 3:
        return "April"
    elif numericMonth is 4:
        return "May"
    elif numericMonth is 5:
        return "June"
    elif numericMonth is 6:
        return "July"
    elif numericMonth is 7:
        return "August"
    elif numericMonth is 8:
        return "September"
    elif numericMonth is 9:
        return "October"
    elif numericMonth is 10:
        return "November"
    else:
        return "December"


def main():
    data = splitTemps()

    pp = pprint.PrettyPrinter(4)
    pp.pprint(data[0])
    print("Mean temperature in Fahrenheit over the entire data set:", data[1])

    print("Mean of temps by numeric month starting from 0:")
    monthlyTemperatures = monthlyTemps(data[0])
    pp.pprint(meanMonthTemps(monthlyTemperatures))

    print(indexOfMonthYear("1", "1990", data[0]))
    print(monthYearByIndex("0", "110", data[0]))

    for monthTemps in monthlyTemperatures.items():
        plotPoints(data[0].keys(), monthTemps)

    plotAvgYearTemp(data[0].keys(), annualAvgTemps(data[0]), 1880, 2019)
    plotAvgMonthTemp(data[0].keys(), data[0].values(), 2000, 2017)
    plotAvgYearTemp(data[0].keys(), annualAvgTemps(data[0]), 2000, 2017)
    plotAvgMonthTemp(data[0].keys(), data[0].values(), 1990, 1999)
    plotAvgYearTemp(data[0].keys(), annualAvgTemps(data[0]), 1990, 1999)
    plotAvgMonthTemp(data[0].keys(), data[0].values(), 1980, 1989)
    print("The mean temperature between the years 1980 and 1989 is:",
          getMeanOfTemps(getPlotPoints(data[0].keys(), data[0].values(), 1980, 1989)))

    show()


main()
'''for more about plots, visit https://matplotlib.org/users/pyplot_tutorial.html'''
