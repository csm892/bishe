package com.javapandeng.controller;

import com.alibaba.fastjson.JSONObject;
import com.javapandeng.po.Item;
import com.javapandeng.po.Car;
import com.javapandeng.po.User;
import com.javapandeng.service.ItemService;
import com.javapandeng.service.CarService;
import com.javapandeng.service.UserService;
import com.javapandeng.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 购物车
 */
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @RequestMapping("/exAdd")
    @ResponseBody
    public String exAdd(Car car, HttpServletRequest request){
        JSONObject js = new JSONObject();
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            //json返回，失败是o
            js.put(Consts.RES,0);
            return js.toJSONString();
        }
        //保存到购物车
        Integer userId = Integer.valueOf(attribute.toString());
        car.setUserId(userId);
        Item item = itemService.load(car.getItemId());
        String price = item.getPrice();
        Double valueOf = Double.valueOf(price);
        car.setPrice(valueOf);
        if(item.getZk()!=null){
            valueOf = valueOf*item.getZk()/10;
            //保留两位小数
            BigDecimal bg = new BigDecimal(valueOf).setScale(2, RoundingMode.UP);
            car.setPrice(bg.doubleValue());
            valueOf = bg.doubleValue();
        }
        Integer num = car.getNum();
        Double t = valueOf*num;

        BigDecimal bg = new BigDecimal(t).setScale(2, RoundingMode.UP);
        double doubleValue = bg.doubleValue();
        //总价格也保留两位数
        car.setTotal(doubleValue+"");
        carService.insert(car);
        js.put(Consts.RES,1);
        return js.toJSONString();
    }

    /**
     * 转向我的购物车页面
     */
    @RequestMapping("/findBySql")
    public String findBySql(Model model,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            return "redirect:/login/toLogin";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        User user= userService.load(userId);
        String sql = "select * from car where user_id="+userId+" order by id desc";
        List<Car> list = carService.listBySqlReturnEntity(sql);
        model.addAttribute("list",list);

        model.addAttribute("user",user);

        return "car/car";
    }

    /**
     * 删除购物车
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        carService.deleteById(id);
        return "success";
    }
}
