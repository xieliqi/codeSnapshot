package com.xxx.bootstrap;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.paoding.rose.scanning.context.RoseAppContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chaoxing.cvs.service.VideoConvertService;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	private static volatile boolean running = true;

	public static void main(String[] args) {
		final RoseAppContext roseContext = new RoseAppContext();
		try {
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					try {
						roseContext.stop();
						logger.info("RoseAppContext stopped!");
					}
					catch (Throwable t) {
						logger.error(t.getMessage(), t);
					}
					synchronized (Main.class) {
						running = false;
						Main.class.notify();
					}
				}
			});

			roseContext.start();
			logger.info("RoseAppContext started!");
			System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " Video Converter service started!");
			VideoConvertService service = roseContext.getBean(VideoConvertService.class);
			service.service();
		}
		catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			System.exit(1);
		}
		synchronized (Main.class) {
			while (running) {
				try {
					Main.class.wait();
				}
				catch (Throwable e) {
				}
			}
		}
	}

}