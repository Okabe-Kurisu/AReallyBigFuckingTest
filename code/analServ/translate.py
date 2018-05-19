# /usr/bin/env python
# coding=utf8

import requests
import hashlib
import urllib
import random


def trans(key, toLang="zh"):
    appid = '20180516000160326'
    secretKey = 'BAgmOeSHQAaiouoopnzY'
    httpClient = None
    myurl = 'http://api.fanyi.baidu.com/api/trans/vip/translate'
    fromLang = 'auto'
    salt = random.randint(32768, 65536)

    sign = appid + key + str(salt) + secretKey
    m1 = hashlib.md5()
    m1.update(sign.encode('UTF-8'))
    sign = m1.hexdigest()
    myurl = myurl + '?appid=' + appid + '&q=' + urllib.parse.quote(
        key) + '&from=' + fromLang + '&to=' + toLang + '&salt=' + str(
        salt) + '&sign=' + sign
    try:
        r = requests.get(myurl)
        r.encoding
        return r.json()['trans_result'][0]['dst']
    except Exception as e:
        print(e)
    finally:
        if httpClient:
            httpClient.close()
