import com.DAO.BlogDao;
import com.DAO.UserDao;
import com.model.*;

import java.util.List;

public class myTest {
    public static void main(String[] args) {
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
        Sensitivity Sensitivity_blog = new Sensitivity();
        Favorite Favorite_blog = new Favorite();
        Sensitivity_blog.setType(0);
        Sensitivity_blog.setDetails("色情");
        Sensitivity_blog.setBlog_id(18);
        BlogDao.reportBlog(Sensitivity_blog);
        Favorite_blog.setBlog_id(17);
        Favorite_blog.setUser_id(3);
        BlogDao.collectBlog(Favorite_blog);

    }
}
