import com.DAO.BlogDao;
import com.DAO.UserDao;
import com.model.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class myTest {
    public static void main(String[] args) {
        BlogDao.SetBlogNum(19);
//        Blog blog=new Blog();
//        blog.setUser_id(3);
////        blog.setBid(15);
//        blog.setContent("评论微博15");
//        blog.setVisibility(0);
//        blog.setType(2);
//        blog.setRelease_time((int) (System.currentTimeMillis() / 1000));
//        blog.setMultimedia("");
//        blog.setComment_on(15);
//        BlogDao.commit(blog);
////        BlogDao.delBlog(15);
//        ThumbUp thumbup=new ThumbUp();
//        thumbup.setUser_id(5);
//        thumbup.setBlog_id(5);
//        thumbup.setDate((int) (System.currentTimeMillis() / 1000));
//        BlogDao.thumbUp(thumbup);

//        List<User> userList = null;
//        userList=UserDao.getFiveUser("");
//        for (User user:userList
//             ) {
//            System.out.print(user.getNickname());
//        }
//        CallAt user=new CallAt();
////        user.setUser_id(5);
////        user.setBlog_id(5);
////        user.setDate((int) (System.currentTimeMillis() / 1000));
////            UserDao.addAtUser(user);

       /* Sensitivity Sensitivity_blog = new Sensitivity();
        Favorite Favorite_blog = new Favorite();
        Sensitivity_blog.setType(0);
        Sensitivity_blog.setDetails("色情");
        Sensitivity_blog.setBlog_id(18);
        BlogDao.reportBlog(Sensitivity_blog);
        Favorite_blog.setBlog_id(17);
        Favorite_blog.setUser_id(3);
        BlogDao.collectBlog(Favorite_blog);*/
        // UserDao.checkusername("aaaa");
       /* User user = new User();
        user.setUid(233);
        user.setUsername("t333");
        user.setIs_ban(0);
        user.setNickname("xiugai");
        user.setPassword("11111");
        user.setSex(0);
        user.setAge(12);
        user.setLast_logtime(2222);
        user.setIp_address("qweqwe");
        user.setBrowser_sign("asdasdf");
        System.out.println("aaaaaa"+UserDao.updateUuser(user)+"aaaaaaa");*/
       /* UserDao.userLeave(4);*/
//        User user = new User();
//        user.setUid(3);
//        UserDao.initUser(user);

//        Sensitivity Sensitivity_blog = new Sensitivity();
//        Favorite Favorite_blog = new Favorite();
//        Sensitivity_blog.setType(0);
//        Sensitivity_blog.setDetails("色情");
//        Sensitivity_blog.setBlog_id(18);
//        BlogDao.reportBlog(Sensitivity_blog);
//        Favorite_blog.setBlog_id(17);
//        Favorite_blog.setUser_id(3);
//        BlogDao.collectBlog(Favorite_blog);


    }
}
