from bs4 import BeautifulSoup as bs
from openpyxl import load_workbook
import pandas as pd
import requests
import json
import csv

page = '1'

while True:

    # 축제 URL
    url = 'https://www.mapo.go.kr/site/culture/fes/culture_onstop_fes_list?cp=' + page + '&sc=A.MOT_TITLE&pageSize=9&listType=list&catId=MTG&cCodeId=MTG001'

    # 호텔 URL
    # url = 'https://www.mapo.go.kr/site/culture/hot/culture_onstop_hot_list?cp=' + page + '&sc=A.MOT_TITLE&pageSize=9&listType=list&catId=MTH&cCodeId=MTH001'

    # 모범 음식점
    # url = 'https://www.mapo.go.kr/site/culture/mo/onstop_food_mo_list?cp=' + page + '&listType=list&catId=MTF&gCodeId=MTFG001'

    headers = {"User-Agent":"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36"}

    res = requests.get(url, headers=headers)

    print('response code : ', res.status_code)

    res.raise_for_status()

    result_list = []

    count = 0

    soup = bs(res.text, 'lxml')

    pages = soup.select('div.bbs_paging > a')

    ttls = soup.select('h3.tit')

    rpr_dscs = soup.select('p.txt_area')

    for element in ttls:
        count += 1

    for i in range(count):
        ttl = ttls[i].get_text()
        rpr_dsc = rpr_dscs[i].get_text()
        contents_dict = {
            'title': ttl,
            'content': rpr_dsc,
        }
        requests.post("http://localhost:80/add", json=json.dumps(contents_dict, ensure_ascii=False), headers=headers).raise_for_status()

    if len(result_list) == 0:
        break

    page = str(int(page) + 1)