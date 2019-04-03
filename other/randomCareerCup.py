import requests 
from bs4 import BeautifulSoup 
import random
import webbrowser


url = "https://www.careercup.com/page"

def get_url_content(URL, querystring):
    r = requests.request("GET", url, params=querystring)
    # r = requests.get(URL)
    soup = BeautifulSoup(r.content, 'html5lib')     
    return soup

random_number = random.randint(1,10)
querystring = {"pid":"software-engineer-developer-interview-questions","n":str(random_number)}


soup = get_url_content(url, querystring)
table = soup.find('ul', attrs= {'id': 'question_preview'})
link_list = []

for li in table.findAll('li'):
    for l in li.find_all('a', href=True):
        if '/question' in l.get('href'):
            link_list.append(l.get('href'))

problem_link = random.choice(link_list)
problem_link = "https://www.careercup.com%s"%problem_link
print problem_link
try:
    chrome_path = 'open -a /Applications/Google\ Chrome.app %s'
    webbrowser.get(chrome_path).open(problem_link)
except:
    pass
