#!/usr/bin/python

import sys
from selenium import webdriver
from selenium.webdriver.common.by import By

#This stops the window closing immediately
options = webdriver.EdgeOptions()
options.add_experimental_option("detach", True)

#The below code will open up a chrome browser
#This tells us we are using a chrome browser
#We also provide the options so the tab does not close immediately
web = webdriver.Edge(options=options)

web.get(sys.argv[1])

pricecheck = web.find_element("xpath", '//*[@id="asparagus-root"]/div/div[2]/main/div/div/div[2]/div/section[2]/div[2]/div[1]/div/div/div[1]/p')
print(pricecheck.text)

