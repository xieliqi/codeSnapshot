package com.xxx.bootstrap;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	private static volatile boolean running = true;

	public static void main(String[] args) throws IOException {
		System.out.println(System.getenv());
		System.out.println(Main.class.getClass().getResource("/applicationContext.xml").getPath());
		//System.out.println(IOUtils.readLines(Main.class.getResourceAsStream("/applicationContext.xml")));
		@SuppressWarnings("resource")
		final FileSystemXmlApplicationContext appContext = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		try {
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					try {
						appContext.stop();
						logger.info("SpringAppContext stopped!");
					} catch (Throwable t) {
						logger.error(t.getMessage(), t);
					}
					synchronized (Main.class) {
						running = false;
						Main.class.notify();
					}
				}
			});

			appContext.start();
			System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]")
					.format(new Date()) + "java application started!");
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			System.exit(1);
		}
		synchronized (Main.class) {
			while (running) {
				try {
					Main.class.wait();
				} catch (Throwable e) {
				}
			}
		}
	}

}