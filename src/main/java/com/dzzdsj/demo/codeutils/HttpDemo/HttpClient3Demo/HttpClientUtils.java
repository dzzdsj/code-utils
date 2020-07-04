package com.dzzdsj.demo.codeutils.HttpDemo.HttpClient3Demo;

import org.apache.commons.codec.CharEncoding;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpClientUtils {
    /**
     * @param url:请求地址
     * @param headerParams:请求头上的参数
     * @return String
     * @author zhangjian
     * @date 2017年12月28日 上午9:06:52
     * @Description: get请求
     */
    public static String doGet(String url, Map<String, String> param, Map<String, String> headerParams) {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 创建hander参数列表
            if (headerParams != null) {
                Set<String> keySet = headerParams.keySet();
                if (keySet.size() != 0) {
                    for (String string : keySet) {
                        httpGet.setHeader(string, headerParams.get(string));
                    }
                }
            }

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), CharEncoding.UTF_8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    /**
     * @param url:请求地址
     * @param param:form提交方式参数
     * @param headerParams:请求头参数
     * @return String
     * @author zhangjian
     * @date 2017年12月28日 上午9:08:18
     * @Description: TODO
     */
    public static String doPost(String url, Map<String, String> param, Map<String, String> headerParams) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            // 创建hander参数列表
            if (headerParams != null) {
                Set<String> keySet = headerParams.keySet();
                if (keySet.size() != 0) {
                    for (String string : keySet) {
                        httpPost.setHeader(string, headerParams.get(string));
                    }
                }
            }

            httpPost.setEntity(new StringEntity("{}"));

            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }

    /**
     * @param url          请求地址
     * @param param        请求参数
     * @param headerParams 请求头
     * @param inputStream  文件输入流
     * @param fileName     文件名称
     * @return
     */
    public static String doPost4Upload(String url, Map<String, String> param, Map<String, String> headerParams, InputStream inputStream, String fileName) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 模拟文件
            MultipartEntityBuilder mutiEntity = MultipartEntityBuilder.create();
            mutiEntity.setCharset(Charset.forName("UTF-8"));
            mutiEntity.addBinaryBody("file", inputStream, ContentType.create("multipart/form-data"), fileName);
            // 创建参数列表
            if (param != null) {
                for (String key : param.keySet()) {
                    mutiEntity.addTextBody(key, param.get(key));
                }
            }
            httpPost.setEntity(mutiEntity.build());

            // 创建hander参数列表
            if (headerParams != null) {
                Set<String> keySet = headerParams.keySet();
                if (keySet.size() != 0) {
                    for (String string : keySet) {
                        httpPost.setHeader(string, headerParams.get(string));
                    }
                }
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resultString;
    }


    /**
     * @param url:请求地址
     * @param json:参数的json格式
     * @param headerParams:请求头参数
     * @return String
     * @author zhangjian
     * @date 2017年12月28日 上午9:08:54
     * @Description: TODO
     */
    public static String doPostJson(String url, String json, Map<String, String> headerParams) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 创建hander参数列表
            if (headerParams != null) {
                Set<String> keySet = headerParams.keySet();
                if (keySet.size() != 0) {
                    for (String string : keySet) {
                        httpPost.setHeader(string, headerParams.get(string));
                    }
                }
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }

    /**
     * @param url:请求地址
     * @param param:form提交方式参数
     * @param headerParams:请求头参数
     * @return String
     * @author zhangjian
     * @date 2017年12月28日 上午9:09:15
     * @Description: TODO
     */
    public static String doPut(String url, Map<String, String> param, Map<String, String> headerParams) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPut httpPut = new HttpPut(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                entity.setContentType("application/x-www-form-urlencoded");
                httpPut.setEntity(entity);

            }
            // 创建hander参数列表
            if (headerParams != null) {
                Set<String> keySet = headerParams.keySet();
                if (keySet.size() != 0) {
                    for (String string : keySet) {
                        httpPut.setHeader(string, headerParams.get(string));
                    }
                }
            }
            // 执行http请求
            response = httpClient.execute(httpPut);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }

    /**
     * @param url:请求地址
     * @param json:参数的json格式
     * @param headerParams:请求头参数
     * @return String
     * @author zhangjian
     * @date 2017年12月28日 上午9:09:48
     * @Description: TODO
     */
    public static String doPutJson(String url, String json, Map<String, String> headerParams) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPut httpPut = new HttpPut(url);

            StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPut.setEntity(stringEntity);
            // 创建hander参数列表
            if (headerParams != null) {
                Set<String> keySet = headerParams.keySet();
                if (keySet.size() != 0) {
                    for (String string : keySet) {
                        httpPut.setHeader(string, headerParams.get(string));
                    }
                }
            }
            // 执行http请求
            response = httpClient.execute(httpPut);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }

    public static String doPostForm(String url, Map<String, String> param, Map<String, String> headerParams) {

        // 创建参数列表
        MultiValueMap multiValueMap = new LinkedMultiValueMap<>();
        if (param != null) {
            for (String key : param.keySet()) {
                multiValueMap.add(key, param.get(key));
            }
        }
        // 创建hander参数列表
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        if (headerParams != null) {
            Set<String> keySet = headerParams.keySet();
            if (!keySet.isEmpty()) {
                for (String string : keySet) {
                    headers.add(string, headerParams.get(string));
                }
            }
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(multiValueMap, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return response.getBody();
    }

}
