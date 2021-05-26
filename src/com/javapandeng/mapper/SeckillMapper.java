package com.javapandeng.mapper;


import com.javapandeng.base.BaseDao;
import com.javapandeng.po.Sc;
import com.javapandeng.po.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillMapper extends BaseDao<Seckill> {
    /**
     * 减库存
     * @param  seckillId
     * @param  killTime，用户下单秒杀时间
     * @return 如果影响行数>1 表示更新行数
     */
    int reduceNumber (@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀对象
     * @param seckillId
     * @return
     */

    Seckill queryById2(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     */
    List<Seckill> queryAll(@Param("offset") int offset , @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     * @param paramMap
     */
    void killByProcedure(Map<String,Object> paramMap);
}
