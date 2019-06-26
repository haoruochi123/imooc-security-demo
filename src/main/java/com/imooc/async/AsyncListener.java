package com.imooc.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class AsyncListener implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private QueueOrder queueOrder;
	@Autowired
	private DeferredResultHodler deferredResultHodler;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					if(StringUtils.isNotBlank(queueOrder.getComplete())) {
						String complete =queueOrder.getComplete();
						deferredResultHodler.getMap().get(complete).setResult("完成订单"+complete);
						logger.info("完成订单");
						queueOrder.setComplete(null);
					}else {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
		
	}

}
