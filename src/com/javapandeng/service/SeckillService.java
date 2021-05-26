package com.javapandeng.service;


import com.javapandeng.base.BaseService;
import com.javapandeng.exception.RepeatKillException;
import com.javapandeng.exception.SeckillCloseException;
import com.javapandeng.exception.SeckillException;
import com.javapandeng.po.Exposer;
import com.javapandeng.po.Sc;
import com.javapandeng.po.Seckill;
import com.javapandeng.po.SeckillExcution;

import java.util.List;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/3/28 8:52 下午
 * 业务接口：站在'使用者'的角度上实现接口，而不是实现。
 * 三个方面：实现定义粒度、参数、返回类型（return 类型/异常）
 */
public interface SeckillService extends BaseService<Seckill> {
    /**
     * 查询所有秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById2(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址，否则输出系统时间和秒杀时间
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5,如果md5不一样，说明用户变了，不允许抢购
     *
     */
    SeckillExcution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException, RepeatKillException, SeckillCloseException;

    /**
     * 执行秒杀操作 存储过程
     * @param seckillId
     * @param userPhone
     * @param md5

    SeckillExcution executeSeckillProcedure(long seckillId, long userPhone, String md5);
     */
}
