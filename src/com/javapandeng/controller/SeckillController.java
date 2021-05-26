package com.javapandeng.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.javapandeng.config.AlipayConfig;
import com.javapandeng.enums.SeckillStatEnum;
import com.javapandeng.exception.RepeatKillException;
import com.javapandeng.exception.SeckillCloseException;
import com.javapandeng.po.*;
import com.javapandeng.service.*;
import com.javapandeng.utils.Consts;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/3/29 8:39 下午
 */
@Controller
@RequestMapping("/seckill") //url:/模块/资源/{id}/细分
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemOrderService itemOrderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private SuccessKillerService successKillerService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *  @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
     *     public String detail(@PathVariable("seckillId") Long seckillId, Model model)
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/view")
    public String view(Integer id,Model model,HttpServletRequest request){
        Item obj = itemService.load(id);
        model.addAttribute("obj",obj);

        Seckill seckill = seckillService.getById2(id);

        model.addAttribute("seckill", seckill);

        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        model.addAttribute("id",userId);
        return "seckill/view";
    }

    //全部秒杀,管理员界面
    @RequestMapping(value = "/findBySql", method = RequestMethod.GET)
    public String list2(Model model) {
        //全部订单*/
        String sql = "select * from seckill";
        // List<ItemOrder> all = itemOrderService.listBySqlReturnEntity(sql);
        List<Seckill> seckillList = seckillService.listBySqlReturnEntity(sql);
        model.addAttribute("seckillList", seckillList);
        return "seckill/seckillList";
    }

    /**
     * 秒杀商品下架
     */
    @RequestMapping("/delete")
    public String update(Long seckillId){
       seckillService.deleteById(seckillId);
       return "redirect:/seckill/findBySql.action";
    }

    /**
     * 添加秒杀商品入口
     */
    @RequestMapping("/add")
    public String add(Model model){

        //查出二级类目商品在传过去
        List<Item> items=itemService.listAll();
        model.addAttribute("items",items);
        return "seckill/add";
    }

    /**
     * 执行添加秒杀商品
     */
    @RequestMapping("/exAdd")
    public String exAdd(Seckill seckill,HttpServletRequest request) throws IOException {


        seckill.setCreateTime(new Date());
        System.out.println(seckill);
        seckillService.insert(seckill);
        return "redirect:/seckill/findBySql.action";
    }


    //秒杀成功全部
    //全部秒杀,管理员界面
    @RequestMapping(value = "/successKill", method = RequestMethod.GET)

    public String success(Model model) {
        String sql = "select * from success_killed";
        List<SuccessKilled> success =successKillerService.listBySqlReturnEntity(sql);
        model.addAttribute("success", success);
        return "seckill/success";
    }


    //全部秒杀
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Seckill> list(Model model) {
        //全部订单*/
        String sql = "select * from seckill";
        // List<ItemOrder> all = itemOrderService.listBySqlReturnEntity(sql);
        List<Seckill> seckillList = seckillService.listBySqlReturnEntity(sql);
        model.addAttribute("seckillList", seckillList);
        return seckillList;
    }





    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (null == seckillId) {
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getById2(seckillId);
        if (null == seckill) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill", seckill);//承载最终要返回给用户的数据，返回Seckill类数据

        return "detail";//view

    }

    //ajax json
    @RequestMapping(value = "/{seckillId}/exposer",
            method = {RequestMethod.POST, RequestMethod.GET},
            produces = {"application/json;charset=utf-8"})
    @ResponseBody//返回json类型
    public SeckillResult<Exposer> exposer( @PathVariable Long seckillId){
        SeckillResult<Exposer> result;

        try {

            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true,exposer);

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            result = new SeckillResult<Exposer>(false,e.getMessage());

        }
        return result;
    }

    //执行秒杀测试
    @RequestMapping(value = "/test")
    @ResponseBody
    public Integer test(HttpServletRequest request){

        Object attribute = request.getSession().getAttribute(Consts.USERID);
        Integer userId = Integer.valueOf(attribute.toString());
        return userId;

    }



    //-----
    @RequestMapping(value = "/{seckillId}/{md5}/execution",

            produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public SeckillResult<SeckillExcution> excute(@PathVariable("seckillId") Long seckillId,
                                                 @PathVariable("md5") String md5, HttpServletRequest request, Model model
    ){
        //验证phone或者spring MVC验证（此处没有）SeckillExecution
        /**if(phone == null){
         return new SeckillResult<SeckillExcution>(false,"未注册");
         }*/
        Object attribute = request.getSession().getAttribute(Consts.USERID);

        Integer userId = Integer.valueOf(attribute.toString());

        Long phone=userId.longValue();
        SeckillResult<SeckillExcution> result;
        try {
            //SeckillExcution seckillExcution = seckillService.executeSeckill(seckillId,phone,md5);
            //通过存储过程去获取
            SeckillExcution seckillExcution = seckillService.executeSeckill(seckillId,phone,md5);
            result = new SeckillResult<SeckillExcution>(true,seckillExcution);
        } catch (RepeatKillException e) {
            SeckillExcution excution = new SeckillExcution(seckillId, SeckillStatEnum.REPEAT_KILL);
            result = new SeckillResult<SeckillExcution>(true,excution);
        }catch (SeckillCloseException e) {
            SeckillExcution excution = new SeckillExcution(seckillId, SeckillStatEnum.END);
            result = new SeckillResult<SeckillExcution>(true,excution);
        }catch (Exception e) {
            SeckillExcution excution = new SeckillExcution(seckillId, SeckillStatEnum.INNER_ERROR);

            result = new SeckillResult<SeckillExcution>(true,excution);
        }
        return result;

    }

    //获取系统时间
    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time(){
        Date now = new Date();
        return new SeckillResult<> (true,now.getTime());

    }


    //秒杀头添加订单
    @RequestMapping(value = "/seckillPay", produces = {"text/html;charset=UTF-8"})
    @ResponseBody
    public String exAdd( Long seckillId, HttpServletRequest request, Model model) throws Exception {

        System.out.println("----------------------------------");
        System.out.println(seckillId);

        String code="";

        String total="";

        Object attribute = request.getSession().getAttribute(Consts.USERID);
        JSONObject js = new JSONObject();
        if (attribute == null) {
            js.put(Consts.RES, 0);
            // return js.toJSONString();
        }
        Integer userId = Integer.valueOf(attribute.toString());
        User byId = userService.getById(userId);
        if (StringUtils.isEmpty(byId.getAddress())) {
            js.put(Consts.RES, 2);
            //return js.toJSONString();
        }

        Seckill seckill=seckillService.getById2(seckillId);

        ItemOrder order = new ItemOrder();
        order.setStatus(0);
        order.setCode(getOrderNo());
        code=getOrderNo();
        order.setIsDelete(0);
        order.setTotal(seckill.getPrice());
        total=seckill.getPrice();
        order.setUserId(userId);
        order.setAddTime(new Date());
        itemOrderService.insert(order);


                OrderDetail de = new OrderDetail();
                de.setItemId(seckillId.intValue());
                //itemorder的1id是自动生成
                de.setOrderId(order.getId());
                de.setStatus(0);
                de.setNum(1);
                de.setTotal(seckill.getPrice());
                orderDetailService.insert(de);
                //修改成交数
                Item load2 = itemService.load(seckillId.intValue());
                load2.setGmNum(load2.getGmNum()+1);
                itemService.updateById(load2);

        System.out.println(code);
        System.out.println(total);
        Pay pay=new Pay();
        pay.setCode(code);
        pay.setTotal(total);

        model.addAttribute("pay",pay);
        JSONArray jsonArray = new JSONArray();
        js.put(Consts.RES,1);
        js.put("code",code);
        js.put("total",total);


        Map<String ,Object> map=new HashMap<String,Object>();
        map.put("code",code);
        map.put("total",total);
        return js.toJSONString();

    }

    private static String date;
    private static long orderNum = 0L;
    //shezhi订单号
    public static synchronized String getOrderNo(){
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        if(date==null||!date.equals(str)){
            date = str;
            orderNum = 0L;
        }
        orderNum++;
        long orderNO = Long.parseLong(date)*10000;
        orderNO += orderNum;
        return orderNO+"";
    }


    //秒杀支付
    @RequestMapping(value = "/pay", produces = {"text/html;charset=UTF-8"})
    public String aliPay(@RequestParam(value="code", required=true) String code, @RequestParam(value="total", required=true) String total, HttpServletRequest request, Model model) throws Exception {

     //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填?a=2
        String out_trade_no = code;
        //付款金额，必填
        String total_amount =total;
        //订单名称，必填
        String subject ="手机";
        //商品描述，可空
        String body = "畅购";
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println(result);
        model.addAttribute("result",result);

        //输出
        // out.println(result);
        return "pay/test";
    }




}
