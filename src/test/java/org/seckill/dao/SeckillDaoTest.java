package test.java.org.seckill.dao;

import com.javapandeng.mapper.SeckillMapper;
import com.javapandeng.po.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 首先需要配置spring 和 junit 整合，为了junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class SeckillDaoTest {
    //注入Dao依赖
    @Resource
    private SeckillMapper seckillDao;

    @Test
    public void reduceNumber() {
        Date killTime =new Date();
        int updateCount = seckillDao.reduceNumber(1000L,killTime);
        System.out.println("updateCount=" + updateCount);

    }

    /**
     * Caused by: org.springframework.core.NestedIOException:
     * Failed to parse mapping resource:
     * 'file [/Users/yoyo/IdeaProjects/seckill/target/classes/mapper/SeckillMapper.xml]';
     * nested exception is org.apache.ibatis.builder.BuilderException: Error creating document instance.
     * Cause: org.xml.sax.SAXParseException; lineNumber: 30; columnNumber: 10; XML 文档结构必须从头至尾包含在同一个实体内。
     */
    @Test
    public void queryById() {
        long id = 1000;
        Seckill seckill = seckillDao.queryById2(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    /**
     * Caused by: org.apache.ibatis.binding.BindingException:
     * Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
     *    List<Seckill> queryAll(int offset , int limit);a
     *    java没有保存行参的表述
     */
    @Test
    public void queryAll() {
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for (Seckill seckill:seckills) {
            System.out.println(seckill);

        }
    }

    @Test
    public void queryAll2() {
        //全部订单
        String sql = "select * from seckill";
       // List<ItemOrder> all = itemOrderService.listBySqlReturnEntity(sql);
        List<Seckill> seckills = seckillDao.listBySqlReturnEntity(sql);
        for (Seckill seckill:seckills) {
            System.out.println(seckill);

        }
    }
}
