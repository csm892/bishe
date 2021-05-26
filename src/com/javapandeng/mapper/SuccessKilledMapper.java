package com.javapandeng.mapper;

import com.javapandeng.base.BaseDao;
import com.javapandeng.po.Sc;
import com.javapandeng.po.SuccessKilled;
import org.apache.ibatis.annotations.Param;

import java.util.Date;


public interface SuccessKilledMapper extends BaseDao<SuccessKilled> {

    /**
     * 插入购买明细，可过滤重复
     * @param seckillId
     * @param userPhone
     * @return 表示插入的行数 这边是一行
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId , @Param("userPhone") long userPhone,@Param("createTime")Date createTime);

    /**
     * 根据ID查询SuccessKilled并携带秒杀产品对象实体
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill (@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}
