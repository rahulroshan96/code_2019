import requests 
from bs4 import BeautifulSoup 
import random
import webbrowser

def get_url_content(URL):
    r = requests.get(URL)
    soup = BeautifulSoup(r.content, 'html5lib')     
    return soup

def get_problem_title(URL):
    soup = get_url_content(URL)
    table = soup.find('h1', attrs={'class':'entry-title'})
    return table.getText()

URL = "https://www.geeksforgeeks.org/fundamentals-of-algorithms/"
soup = get_url_content(URL)
table = soup.find('div', attrs= {'class': 'entry-content'})
link_list = []
for divv in table.findAll('ol'):
    for row in divv.findAll('li'):
        link = row.find_all('a', href=True)
        for l in link:
            if not l['href'].startswith('#'):
                link_list.append(l['href'])

problem_link = random.choice(link_list)
print problem_link
try:
    chrome_path = 'open -a /Applications/Google\ Chrome.app %s'
    webbrowser.get(chrome_path).open(problem_link)  
except:
    pass