import requests 
from bs4 import BeautifulSoup 
import random
import webbrowser

def get_url_content(URL):
    r = requests.get(URL)
    soup = BeautifulSoup(r.content, 'html5lib')     
    return soup

page_number = random.randint(1,652)
URL = "https://projecteuler.net/archives;page=%s"%str(page_number)
soup = get_url_content(URL)
table = soup.findAll('td', attrs= {'class': 'id_column'})
p_id = str(random.choice(table).text)
problem_link = "https://projecteuler.net/problem=%s"%p_id

print problem_link
try:
    chrome_path = 'open -a /Applications/Google\ Chrome.app %s'
    webbrowser.get(chrome_path).open(problem_link)  
except:
    pass