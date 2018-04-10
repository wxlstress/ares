/*
package com.qudian.pay.ares.test.service;

import java.util.UUID;
import javax.annotation.Resource;
import com.alibaba.fastjson.JSON;
import com.qudian.framework.dao.base.Page;
import com.qudian.pay.ares.dao.entity.Demo;
import com.qudian.pay.ares.service.DemoService;
import org.testng.annotations.Test;


public class DemoServiceTest{

	@Resource
	private DemoService demoService;

	@Test
	public void add(){
		Demo data = new Demo();
		data.setName(UUID.randomUUID().toString());
		System.out.println(JSON.toJSONString(demoService.add(data)));
	}

	@Test
	public void listPage(){
		Demo data = new Demo();
		Page page = new Page(1,3);
		data.setPage(page);
		System.out.println(JSON.toJSONString(demoService.listPage(data)));
		System.out.println(JSON.toJSONString(page));
	}

}
*/
