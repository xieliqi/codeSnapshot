package com.xxx.httpclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {
	
	private CloseableHttpClient client;
	private HttpRequestBase httpRequest;
	private Map<String, String> headers;
	
	public HttpClientTest() {
		client = HttpClients.createDefault();
		headers = new HashMap<String, String>();
	}
	
	public HttpClientTest get(String url){
		httpRequest = new HttpGet(url);
		return this;
	}
	
	public HttpClientTest addHeader(String headerName, String headerValue){
		this.headers.put(headerName, headerValue);
		return this;
	}
	
	public HttpClientTest addHeaders(Map<String, String> headers){
		this.headers.putAll(headers);
		return this;
	}
	
	public CloseableHttpResponse request() throws ClientProtocolException, IOException{
		for(Entry<String, String> header : headers.entrySet()){
			httpRequest.addHeader(header.getKey(), header.getValue());
		}
		return client.execute(httpRequest);
	}
	
	public void requestPrint() throws ClientProtocolException, IOException{
		CloseableHttpResponse response = null;
		try {
			response = request();
			System.out.println("status:"+response.getStatusLine());
			HttpEntity entity = response.getEntity();
			List<String> content = IOUtils.readLines(entity.getContent());
			for(String line : content){
				System.out.println(line);
			}
			EntityUtils.consume(entity);
		} finally{
			if(response!=null){
				response.close();
			}
		}
		
	}
	
	public void close(){
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		new HttpClientTest().get("http://baidu.com").requestPrint();
	}
}
