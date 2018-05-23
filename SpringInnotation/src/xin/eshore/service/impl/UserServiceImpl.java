/**
 * @Package xin.xin.eshore.service.impl
 * @Title: UserServiceImpl
 * @Description: UserService接口实现类
 * @Author: 5776范仲旭
 * @Date: 2018-05-16 8:49
 **/
package xin.eshore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import xin.eshore.dao.UserDao;
import xin.eshore.entity.User;
import xin.eshore.service.UserService;

/**
 * @Title: UserServiceImpl
 * @Description: UserService接口实现类
 * @Author: 5776范仲旭
 * @Date: 2018-05-16 8:49
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    // 声明Dao接口的引用
    // 方法一：
//    @Autowired
//    @Qualifier("userDao")  //Qualifier指定所需要的bean
    private UserDao dao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void addNewUser(User user) {
        dao.save(user);
    }

    public UserDao getDao() {
        return dao;
    }

    // dao属性的setter访问器，会被spring调用实现设值的注入
    //方法二：
    @Autowired(required = false)
    public void setDao(@Qualifier("userDao") UserDao dao) {
        this.dao = dao;
    }
}
