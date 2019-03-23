import requests 
import random
import webbrowser
import json

url = "https://leetcode.com/api/problems/all/"

response = requests.request("GET", url)

data = json.loads(response.text)
p_list = data['stat_status_pairs']
p_id = random.choice(p_list)
idx = p_id['stat']['question__title_slug']
problem_link = "https://leetcode.com/problems/%s/"%idx
print problem_link

try:
    chrome_path = 'open -a /Applications/Google\ Chrome.app %s'
    webbrowser.get(chrome_path).open(problem_link)  
except:
    pass

