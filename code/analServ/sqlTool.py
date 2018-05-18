#encoding=utf-8
import pymysql


def get_conn():
    return pymysql.connect("makise.tech", "admin", "admin", "weibo", charset='utf8')


def get_all_user():
    db = get_conn()
    cursor = db.cursor()
    # SQL 查询语句
    sql = "SELECT uid FROM user ORDER BY uid"
    try:
        # 执行SQL语句
        cursor.execute(sql)
        results = cursor.fetchall()
        userlist = [row[0] for row in results]
    except:
        print("Error: unable to fetch data")
    # 关闭数据库连接
    finally:
        db.close()
        return userlist


def get_all_about_user(uid):
    db = get_conn()
    cursor = db.cursor()
    # SQL 查询语句
    sql = """
            SELECT * FROM (
                  SELECT b.content, 4 AS weight
                  FROM blog AS b
                  WHERE b.user_id = #{uid}
                  UNION ALL
                  SELECT b.content, 2 AS weight
                  FROM blog AS bc
                  JOIN blog AS b
                  ON b.bid = bc.comment_on AND bc.user_id = #{uid}
                  UNION ALL
                  SELECT b.content, 2 AS weight
                  FROM favorite AS f
                  JOIN blog AS b
                  ON b.bid = f.blog_id AND f.user_id = #{uid}
                  UNION ALL
                  SELECT b.content, 1 AS weight
                  FROM thumb_up AS tu
                  JOIN blog AS b
                  ON b.bid = tu.blog_id AND tu.user_id = #{uid}
                ) AS  t
                ORDER BY t.weight
    """.replace("#{uid}", str(uid), 5)
    try:
        # 执行SQL语句
        cursor.execute(sql)
        results = cursor.fetchall()
        content = [row[0] for row in results]
    except:
        print("Error: unable to fetch data")
    # 关闭数据库连接
    finally:
        db.close()
        return " ".join(content)


def setKeyword(uid, keywords):
    db = get_conn()

    # 使用cursor()方法获取操作游标
    cursor = db.cursor()

    # SQL 更新语句
    sql = "UPDATE user SET keyword = '%s' WHERE uid = '%s'" % (str(keywords), str(uid))
    try:
        # 执行SQL语句
        cursor.execute(sql)
        # 提交到数据库执行
        db.commit()
    except:
        # 发生错误时回滚
        db.rollback()

    # 关闭数据库连接
    db.close()



