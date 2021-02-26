from bs4 import BeautifulSoup
import requests
import datetime
import dateparser as dp

title = ''
director = ''

URL = 'https://www.imdb.com/title/tt1130884/?ref_=fn_al_tt_1'
page = requests.get(URL)

soup = BeautifulSoup(page.content, features="html.parser")
title = soup.find('h1', class_="")


plot = soup.find('div', class_="plot_summary")
director = plot.find('div', class_="credit_summary_item").find('a')

print(director.text)