import com.kuang.dao.StudentMapper;
import com.kuang.pojo.Student;
import org.apache.ibatis.session.SqlSession;

import com.kuang.dao.TeacherMapper;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;


public class Mytest {
    public static void main(String[] args) {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher);
        sqlSession.close();
    }
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        mapper.getStudent().forEach(System.out::println);


        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        mapper.getStudent2().forEach(System.out::println);


        sqlSession.close();
    }
}
