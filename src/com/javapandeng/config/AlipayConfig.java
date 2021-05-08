package com.javapandeng.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000117649653";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCbaW8AtTAOt4tCIV49m9RQL4JC04SyB0tlJp4f0p8hcPbLFfa1KGbAZIb1iiHbUc6/I5/1ba2I1E59ScqH2gQCxpcNZTtNEtWaS3F9NB7yjdRpOSdykt2+UorjyUrfHwR1dXrJKY64Q0sHCpYWfzfK++vcXY1md/5H6wgPGulxO02OAmKm6alGquLp0a/QCksTI9bIACf8d6ongt0J0O97FzcAsL/Xepb4PiV7elSczGMmDzf0XQb4mV+yF7p8GzXtbIWcuUBekTTcgLM3m8x8pzdPwEycNdc5QZrbIy29Wmi+1xrDP8DnTv+h//i+rV2UepuXEEibYpCT8BaRc1ptAgMBAAECggEBAIVmBM/4tp2LUs+a0MfVQHLrtMYjxV0DAeZ7NXNfWRRdYJmF6tQpL7mpEGcnAFS/bdWHgMAsOq6efhjxBBWEP7kaOYJYCITpy8u7QlkUKhRNRaxkUMX55rh9JZbMq6XFfBBOnOya7VSg/n+2yIna/UsQ3q2y57KzAOM+jRZaJVL5GQKuFsicOS/9jbUe4KQIwNXzjrAqf0KoVfygweKzVuS4mkm21M+JO+oXX97aBL48YMbEU0S+IZln5ZqMGClpzk9SnxogRr9y0uNVeTC189Qkl1er2/zr/zVIEBi+SLh505AMvqV0wbYw5Hzu81OyiIx86uS1/cM+1cpuv+kBM0ECgYEA42y8vfsiyB0CSJpt3+rzeDtb38th7xKQC2SG1JG8y9enc2KalNwi3fIJEeL3qZVzLmS4LmdM3DZOcXSHayi9IXkKQVxKYYPCCjrWni0j4+wuAQMV4bmA3PYuvMDt5RqTzHoEqGq67ixdbvW43Z/llwQF6CxZ+CKBZQXDCij1nzkCgYEArvBa7NfjO1u9v0Jq4EFfbphOEIJE8EAk3u621NtDFkSXY0aiMXg0/ArOjnvzP0922GV2s5dEzMTjkYxLMHSR+CAZWhnmXHLYCf4W1/fusM7DQ84VqbXPFuPGQNwiN+dYN511/VzA+FxnHjQHwf6iXfbehME39tDoQ8AtdNvk4NUCgYEAjLctGUeYP8VjMlULAu828f+YWyJWWDxeEA6FNmVuMZofq88o4k5K7JTjc8PBhZZJDD2ZkGyuK9sWMjDt0SoFy/4+kC5wf2Gs3/OD857uhAoQdOPZ2C6VQyK3zGZ7S7RkGrKsyyAuxUuCDDPRzJ8wyX3dwcgfat6+vSkRgunRAFECgYEAqNxhKBULxhQ8CA34VBdGIt7pG45jNPT1oisSWEx9aVU0PCPGE7JQkqlr0KVcm1P9B8yI07nEM1QpxiiBu3gKHlP9pLczYTGJz7twGW+8+vXaDe0zg+l2yEV87MaQUR4CTUy0w6dwrUukTcczZdKAr+rHx6UqfBgS2rL6Lb7EIzECgYEAgq8D4H75jzul4jHPDv15NtzDXGEhyYTU3PF9sJVsJUQNWVpuuJ9z2Ql6VgvI3xmXzhCE2dYgvIKjWYjJHjC1eZ5id/S+BqafJ0NlOKgjiLRrgMCqNtDkT3DYxIP0s93z3ak5SD5kXAM3WEmVn1jdrRAengG3YvrDzswTw4tkDs8=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm2lvALUwDreLQiFePZvUUC+CQtOEsgdLZSaeH9KfIXD2yxX2tShmwGSG9Yoh21HOvyOf9W2tiNROfUnKh9oEAsaXDWU7TRLVmktxfTQe8o3UaTkncpLdvlKK48lK3x8EdXV6ySmOuENLBwqWFn83yvvr3F2NZnf+R+sIDxrpcTtNjgJipumpRqri6dGv0ApLEyPWyAAn/HeqJ4LdCdDvexc3ALC/13qW+D4le3pUnMxjJg839F0G+Jlfshe6fBs17WyFnLlAXpE03ICzN5vMfKc3T8BMnDXXOUGa2yMtvVpovtcawz/A507/of/4vq1dlHqblxBIm2KQk/AWkXNabQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:83/test1_war_exploded/payNotify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:83/test1_war_exploded/login/uIndex";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

