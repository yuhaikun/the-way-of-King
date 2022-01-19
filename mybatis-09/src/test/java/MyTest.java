import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);



        User user1 = mapper.queryUserById(1);

        System.out.println(user1);
        sqlSession.close();

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserById(1);

        System.out.println(user2);

        System.out.println(user1==user2);
//
//
//        //mapper.updateUser(new User(2,"aaaa","bbbb"));
//
//        sqlSession.clearCache();
//
//        System.out.println("=======================");
//
//        List<User> user2 = mapper.queryUserById(1);
//
//        System.out.println(user2);
//
//        System.out.println(user1==user2);




        sqlSession2.close();
    }
}
