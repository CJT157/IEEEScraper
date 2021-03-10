from bs4 import BeautifulSoup
import requests
import datetime
import dateparser as dp

# Variables
title = ''
genres_html = []
genres = []
release =''

# Gets info for movie from IMDB
URL = 'https://www.imdb.com/title/tt1130884/?ref_=fn_al_tt_1'
page = requests.get(URL)
soup = BeautifulSoup(page.content, features="html.parser")

# Gets title of movie
title = soup.find('h1', class_='')

plot = soup.find('div', class_="plot_summary")
director = plot.find('div', class_="credit_summary_item").find('a')

# Gets list of genres
genres_html = (soup.find('div', class_='subtext').find_all('a'))

# Adds html genres to the genre list
for i in genres_html[:-1]:
    genres.append(i.text)

# Gets and formats the release date
release = genres_html[-1].text
release = release.split('(')[0]
release = dp.parse(release)
