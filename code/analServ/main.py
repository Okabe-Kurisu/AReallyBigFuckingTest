# encoding=utf-8
import operator

import time

from wiki import wikipedia
from translate import trans
import sqlTool
import jieba


def main():
    print("开始分析用户")
    total_time_start = time.time()
    # userlist = sqlTool.get_all_user()
    # for uid in userlist:
    print("正在对用户", str(37), "进行分析")
    time_start = time.time()
    content = sqlTool.get_all_about_user(37)
    print(content)
    keywords = seg(content)
    sqlTool.setKeyword(37, keywords)
    time_end = time.time()
    print("用户", str(37), "分析完成，关键字为", keywords, "用时", str(time_end - time_start), "秒")

    total_time_end = time.time()
    print("分析完成，总用时", str(total_time_end - total_time_start), "秒")


# 分词，排序
def seg(content):
    temp = jieba.cut_for_search(content)  # 分词
    word_list = "~*~".join(temp).split("~*~")
    print(word_list)
    word_dict = list2dict(word_list)  # 统计分词结果
    word_dict = sorted(word_dict.items(), key=operator.itemgetter(1), reverse=True)  # 将分词结果进行排序
    print(word_dict)
    word_list = [x[0] for x in word_dict][0:9]  # 取出排名前十的关键词
    print(word_list)
    key_dict = {}
    for word in word_list:
        key_dict = getCag(trans(word, "en"), key_dict)  # 从维基百科取到结果
    word_dict = sorted(key_dict.items(), key=operator.itemgetter(1), reverse=True)  # 再次排序，得到最终确认的关键字
    print(word_dict)
    return [trans(x[0]) for x in word_dict][0:14]


# 从维基百科取出全部关键字的父话题
def getCag(key, rtn={}):
    print("正在查找", key)
    try:
        result_list = wikipedia.search(key, type="pageid")
    except:
        print("超时，正在重试")
        time.sleep(5)
        getCag(key, rtn)
    temp = []
    for x in result_list:
        try:
            categorie_list = wikipedia.page(pageid=x).categories
            temp.extend(categorie_list)
            time.sleep(0.3)  # 请求太快会被停用
        except:
            continue
    return list2dict(temp, rtn, "web")


# 将list中的数据使用dict进行统计
def list2dict(list, rtn={}, type="nor"):
    extensionsToCheck = ['article', 'wikipedia', 'webarchive', 'cs1', 'page', 'parameters', ' dmy ', ' mdy ']
    while len(list) != 0:
        key = list[0]
        counts = list.count(key)
        list = remove_key(list, key, counts)
        if (type != "nor" and any(ext in key.lower() for ext in extensionsToCheck)) or key == " ":
            None
        elif key not in rtn:
            rtn[key] = counts
        elif key in rtn:
            rtn[key] += counts
    return rtn


def remove_key(list, key, counts):
    for x in range(counts):
        list.remove(key)
    return list


main()
