package com.imooc.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QueueOrder {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private String placeOrder;
	
	private String complete;

	public String getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(String placeOrder) throws InterruptedException {
		new Thread(()->{
			logger.info("订单处理开始"+placeOrder);
			this.placeOrder = placeOrder;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.complete = placeOrder;
			logger.info("订单处理结束"+placeOrder);
		}).start();
		
		
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	
}
