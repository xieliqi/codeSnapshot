package com.xxx.spring;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * root application context初始化完成后执行
 * 
 * @author xielq@kaolafm.com
 * @since
 */
@Component
public class InitJob implements ApplicationListener<ContextRefreshedEvent>{

	private static Logger logger = LoggerFactory.getLogger(InitJob.class);
	
	@Resource(name="configBean")
	private ConfigBean configBean;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			logger.debug("spring inited!");
			if(configBean.isInitOnStart()){
				logger.info("do something!");
				logger.warn("warn!");
				logger.error("error!");
				logger.trace("trace");
			}
		}
	}

}
