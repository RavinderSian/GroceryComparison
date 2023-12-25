import sys
from selenium import webdriver

# Create a new instance of the Firefox driver
driver = webdriver.Chrome()

# Open the webpage
driver.get(sys.argv[1])

# Find the element by ID
element = driver.find_element_by_id("myButton")