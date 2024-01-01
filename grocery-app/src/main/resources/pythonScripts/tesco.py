import sys
from selenium import webdriver

#This stops the window closing immediately
options = webdriver.EdgeOptions()
options.add_experimental_option("detach", True)

#The below code will open up a chrome browser
#This tells us we are using a chrome browser
#We also provide the options so the tab does not close immediately
web = webdriver.Edge(options=options)

web.get(sys.argv[1])

# Find the element by ID
# element = driver.find_element_by_id("myButton")