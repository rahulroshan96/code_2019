import requests 
from bs4 import BeautifulSoup 
import random
import webbrowser

def get_url_content(URL):
    r = requests.get(URL)
    soup = BeautifulSoup(r.content, 'html5lib')     
    return soup

page_number = random.randint(0,500)
URL = "https://www.spoj.com/problems/classical/sort=0,start=%s"%str(page_number)
soup = get_url_content(URL)
table = soup.findAll('td', attrs= {'align': 'left'})
p_id = str(random.choice(table))
p_id = str(p_id.split('/')[2].split('\"')[0])
problem_link = "https://www.spoj.com/problems/%s/"%p_id

print problem_link
try:
    chrome_path = 'open -a /Applications/Google\ Chrome.app %s'
    webbrowser.get(chrome_path).open(problem_link)  
except:
    pass