package test.java.org.seckill.dao;

import com.javapandeng.mapper.SuccessKilledMapper;
import com.javapandeng.po.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class SuccessKilledMapperTest {

    @Resource
    private SuccessKilledMapper successKilledDao;

    @Test
    public void insertSuccessKilled() {
        long id = 1001L;
        long userPhone = 1661368L;
        Date createTime =new Date();
        int insertCount = successKilledDao.insertSuccessKilled(id,userPhone,createTime);
        System.out.println("insertCount = " + insertCount);
    }

    /**
     * java.sql.SQLSyntaxErrorException: Unknown column 'sk.userphone' in 'field list'
     */
    /**
     * Caused by: com.mysql.cj.exceptions.DataReadException: Zero date value prohibited
     */
    @Test
    public void queryByIdWithSeckill() {
        long id = 1001L;
        long userPhone = 16613160968L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id,userPhone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}
