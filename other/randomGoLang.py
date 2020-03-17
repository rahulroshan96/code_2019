# import requests 
import random
import webbrowser


url = "https://tour.golang.org"
# starts with 1 not zero
sections_list = ['basics-16', 'flowcontrol-13', 'moretypes-26', 'methods-25', 'concurrency-10']
selection = sections_list[random.randint(1,len(sections_list)-1)]
section = selection.split('-')[0]
page_number = int(selection.split('-')[1])
page = str(random.randint(1,page_number))
page_url = "%s/%s/%s"%(url, section,page)
print page_url
try:
    chrome_path = 'open -a /Applications/Google\ Chrome.app %s'
    webbrowser.get(chrome_path).open(page_url)
except:
    pass
