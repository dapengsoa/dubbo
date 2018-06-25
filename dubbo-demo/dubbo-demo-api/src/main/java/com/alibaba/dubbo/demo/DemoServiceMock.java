package com.alibaba.dubbo.demo;

/**
 * desc: 在接口服务xxxxService的目录下创建相应的mock业务处理类，同时实现业务接口xxxxService()
 *
 * @author hz.lei
 * @since 2018年06月25日 上午11:55
 */
public class DemoServiceMock implements DemoService {
    @Override
    public String sayHello(String name) {
        return "mock service result !!!";
    }
}
