package com.xxx.spring;
/**
 * 持有项目�?要需要的配置�?
 * 
 * @author xielq@kaolafm.com
 * @since
 */

public class ConfigBean {

	private boolean initOnStart = false;
	
	private int nodeIndex = 1;
	
	private int nodeCount = 1;
	
	private int dataThreadCount = 10;
	
	private int redisThreadCount = 2;
	
	private int batchCount = 1000;

	/**
	 * 是否在启动时进行用户信息的初始化工作
	 * @return
	 */
	public boolean isInitOnStart() {
		return initOnStart;
	}

	public void setInitOnStart(boolean initOnStart) {
		this.initOnStart = initOnStart;
	}

	public int getDataThreadCount() {
		return dataThreadCount;
	}

	public void setDataThreadCount(int dataThreadCount) {
		this.dataThreadCount = dataThreadCount;
	}

	public int getRedisThreadCount() {
		return redisThreadCount;
	}

	public void setRedisThreadCount(int redisThreadCount) {
		this.redisThreadCount = redisThreadCount;
	}

	public int getBatchCount() {
		return batchCount;
	}

	public void setBatchCount(int batchCount) {
		this.batchCount = batchCount;
	}

	public int getNodeIndex() {
		return nodeIndex;
	}

	public void setNodeIndex(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}
	
}
