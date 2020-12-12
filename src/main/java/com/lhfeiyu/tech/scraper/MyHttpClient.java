package com.lhfeiyu.tech.scraper;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MyHttpClient {

    private static Logger logger = LoggerFactory.getLogger(MyHttpClient.class);

    public static String get(Map<String, String> params, String url, Map<String, String> header) {
        return get(params, url, header, 10000);//10秒
    }

    public static String get(Map<String, String> params, String url, Map<String, String> header, int timeout_ms) {
        String body = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        logger.debug("GET:{}", url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeout_ms).setConnectionRequestTimeout(timeout_ms).setSocketTimeout(timeout_ms).build();
        httpGet.setConfig(requestConfig);

        if (header != null) {
            for (String key : header.keySet()) {
                httpGet.setHeader("key", header.get(key));
            }
        }
        //	httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        //	httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //获取结果实体
        CloseableHttpResponse response = null;

        try {
            response = client.execute(httpGet);
            if (null == response) {
                logger.info("INFORM_NEW_VIDEO(informPeerSystemByHttp) - GET response is null");
                return body;
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                body = EntityUtils.toString(entity, "utf-8");//按指定编码转换结果实体为String类型
                logger.info("INFORM_NEW_VIDEO(informPeerSystemByHttp) - GET response : {}", body);
            }
            EntityUtils.consume(entity);
        } catch (Exception e) {
            logger.warn("INFORM_NEW_VIDEO(informPeerSystemByHttp) - GET throw exception : ");
            e.printStackTrace();
        } finally {
            if (null != response)
                try {
                    logger.debug("GET response is: {}", body);
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }//释放链接
        }

        return body;
    }

    public static String post(Map<String, String> params, String url, Map<String, String> header) {
        return post(params, url, header, 500000);
    }

    public static String post(Map<String, String> params, String url, Map<String, String> header, int timeout_ms) {
        String body = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //设置超时时间,数据有可能较大，因此设置500秒的超时时间

        logger.debug("Start HTTP: {}", url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeout_ms).setConnectionRequestTimeout(timeout_ms).setSocketTimeout(timeout_ms).build();
        httpPost.setConfig(requestConfig);

        List<NameValuePair> nvps = new ArrayList<>();

        if (params != null) {
            for (Entry<String, String> entry : params.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /*
        Object o = JSONObject.toJSON(params);
        String jsonString =o.toString();
        StringEntity strEntity = new StringEntity(jsonString, "UTF-8");
    	strEntity.setContentEncoding("UTF-8");
    	strEntity.setContentType("application/json");
    	httpPost.setEntity(strEntity);
    	*/
        if (header != null) {
            for (String key : header.keySet()) {
                httpPost.setHeader("key", header.get(key));
            }
        }
        //	httpPost.setHeader("Content-type", "application/json");
        //	httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //获取结果实体
        CloseableHttpResponse response = null;

        try {
            Scanner scanner = new Scanner(httpPost.getEntity().getContent(), "UTF-8");
            String text = scanner.useDelimiter("\\A").next();
            logger.debug("对接外部系统: {}, 参数: {}", httpPost.getRequestLine(), text);
        } catch (UnsupportedOperationException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            response = client.execute(httpPost);
            if (null == response) {
                logger.info("INFORM_NEW_VIDEO(informPeerSystemByHttp) - response is null");
                return body;
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                body = EntityUtils.toString(entity, "utf-8");//按指定编码转换结果实体为String类型
                logger.info("INFORM_NEW_VIDEO(informPeerSystemByHttp) - response : {}", body);
            }
            EntityUtils.consume(entity);
        } catch (Exception e) {
            logger.warn("INFORM_NEW_VIDEO(informPeerSystemByHttp) - throw exception : ");
            e.printStackTrace();
        } finally {
            if (null != response)
                try {
                    logger.debug("response is: {}", body);
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }//释放链接
        }

        return body;
    }

    /**
     * 发送http （json参数）
     *
     * @param url
     * @param params
     * @return
     */
    public static JSONObject doPost(String url, JSONObject params) {
        JSONObject body = null;
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        //设置超时时间,数据有可能较大，因此设置500秒的超时时间
        logger.debug("Start HTTP: {}", url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(500000).setConnectionRequestTimeout(500000)
                .setSocketTimeout(500000).build();
        post.setConfig(requestConfig);
        HttpResponse res = null;
        int statusCode = 0;
        //List<NameValuePair> li = new ArrayList<NameValuePair>();
        try {
        	/*Set<Entry<String,Object>> entrySet = params.entrySet();
        	Iterator<Entry<String, Object>> iterator = entrySet.iterator();
        	while(iterator.hasNext()){
        		Entry<String, Object> next = iterator.next();
        		Object value = next.getValue();
        		String key = next.getKey();
        		li.add(new BasicNameValuePair(key,value.toString()));
        	}*/
            StringEntity s = new StringEntity(params.toString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            res = httpclient.execute(post);
            if (res == null) {
                logger.info("Do Http Post(informPeerSystemByHttp) - response is null");
                return body;
            }
            StatusLine statusLine = res.getStatusLine();
            statusCode = statusLine.getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(entity);// 返回json格式：
                body = JSONObject.parseObject(result);
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            logger.warn("Do Http Post(informPeerSystemByHttp) - throw exception : ");
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.info("Do Http Post(informPeerSystemByHttp) - httpclient close exception:");
                e.printStackTrace();
            }
        }
        return body;
    }
    
    public static JSONObject doJsonPost(String url, String jsonParams) {
        JSONObject body = null;
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        //设置超时时间,数据有可能较大，因此设置500秒的超时时间
       
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(500000).setConnectionRequestTimeout(500000)
                .setSocketTimeout(500000).build();
        post.setConfig(requestConfig);
        HttpResponse res = null;
        int statusCode = 0;
        try {

            post.setEntity(new StringEntity(jsonParams,"UTF-8")); //防止中文乱码
            post.addHeader("Content-Type", "application/json");
            logger.debug("Start HTTP: {}  params={}", url,jsonParams);
            res = httpclient.execute(post);
            if (res == null) {
                logger.info("Do Http Post(informPeerSystemByHttp) - response is null");
                return body;
            }
            StatusLine statusLine = res.getStatusLine();
            statusCode = statusLine.getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
            	logger.debug("DoPost Success");
                HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(entity);// 返回json格式：
                body = JSONObject.parseObject(result);
                EntityUtils.consume(entity);
            }else{
            	logger.warn("DoPost Failure {}",statusCode);
            }
        } catch (Exception e) {
            logger.warn("Do Http Post(informPeerSystemByHttp) - throw exception : ");
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.warn("Do Http Post(informPeerSystemByHttp) - httpclient close exception:");
                e.printStackTrace();
            }
        }
        return body;
    }

}
