package com.joham.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequestBuilder;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import java.util.ArrayList;
import java.util.List;

public class TestEs {

    private final static String ipAddress = "172.19.26.190";

    private final static TransportClient client = new TransportClient().addTransportAddress(new InetSocketTransportAddress(ipAddress, 9300));

    public static void main(String[] args) {
//        createIndex();
//        searchIndex();
//        updateIndex();
//        delIndex();
        setVersion("zhumeng-app-site", "versions");
    }

    /**
     * 创建索引
     */
    private static void createIndex() {
        Student student = new Student();
        student.setId(21L);
        student.setName("测试21");
        student.setAge(21);
        String json = JSON.toJSONString(student);
        //索引名称,类型名称,文档ID
        IndexResponse indexResponse = client.prepareIndex("test", "student", student.getId().toString()).setRefresh(true).setSource(json).execute().actionGet();
        System.out.println("索引名称" + indexResponse.getIndex());
        System.out.println("类型名称" + indexResponse.getType());
        System.out.println("文档ID" + indexResponse.getId());
    }

    /**
     * 根据id查询一条记录
     */
    private static void searchIndex() {
        GetResponse getResponse = client.prepareGet("test", "student", "21").get();
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = new Student();
        try {
            student = objectMapper.readValue(getResponse.getSourceAsString(), Student.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(student.getId() + "" + student.getName());
    }


    /**
     * 根据id修改索引
     */
    private static void updateIndex() {
        Student student = new Student();
        student.setId(21L);
        student.setName("测试修改1");
        student.setAge(21);
        client.prepareUpdate("test", "student", "21").setDoc(JSON.toJSONString(student)).execute().actionGet();
    }

    /**
     * 根据id删除索引
     */
    private static void delIndex() {
        client.prepareDelete("test", "student", "21").execute().actionGet();
    }

    /**
     * 批量创建索引
     */
    private static void bulkCreateIndex() {
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.setId(Long.valueOf(i));
            student.setName("测试" + i);
            student.setAge(i);
            String json = JSON.toJSONString(student);
            IndexRequest request = client.prepareIndex("test", "student", student.getId().toString()).setSource(json).request();
            bulkRequestBuilder.add(request);
        }
        BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();
        if (bulkResponse.hasFailures()) {
            System.out.println("批量创建索引失败");
        } else {
            System.out.println("批量创建索引成功");
        }
    }

    /**
     * 简单搜索
     */
    private static void simpleSearch() {
        SearchResponse searchResponse = client.prepareSearch("test")
                .setTypes("student")
                .setSearchType(SearchType.QUERY_THEN_FETCH).setQuery(QueryBuilders.matchAllQuery()).setSize(100)
//                .setQuery(QueryBuilders.matchQuery("name", "19"))
//                .addHighlightedField("name")//高亮
//                .setHighlighterPreTags("<span style=\"color:red\">")
//                .setHighlighterPostTags("</span>")
                .execute().actionGet();
//                .setQuery(QueryBuilders.fuzzyQuery("name","测试19")).execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        for (SearchHit searchHit : searchHits) {
            System.out.println(searchHit.getSource());
        }
    }

    /**
     * 索引库是否存在
     *
     * @param index 索引库名
     * @return 存在则返回true，不存在则返回false
     */
    private static Boolean indexExist(String index) {
        IndicesExistsRequest request = new IndicesExistsRequestBuilder(client.admin().indices(), index).request();
        IndicesExistsResponse response = client.admin().indices().exists(request).actionGet();
        return response.isExists();
    }

    /**
     * 判断类型是否存在
     *
     * @param index
     * @param type
     * @return
     */
    public static boolean isTypeExist(String index, String type) {
        return client.admin().indices().
                typesExists(new TypesExistsRequest(new String[]{index}, type)).actionGet().isExists();
    }

    /**
     * 批量删除索引
     */
    private static void bulkDelIndex() {
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        for (int i = 10; i < 15; i++) {
            bulkRequestBuilder.add(client.prepareDelete("test", "student", String.valueOf(i)).request());
        }
        bulkRequestBuilder.execute().actionGet();
    }

    /**
     * 根据索引名称删除索引类型
     */
    private static void delIndexByName() {
        client.admin().indices().prepareDeleteMapping("test").setType("student").execute().actionGet();
//        client.admin().indices().prepareDeleteMapping("luokeke-app-site").setType("floors").execute().actionGet();
    }

    /**
     * 修改版本信息
     */

    private static void setVersion(String index, String type) {
        //初始化版本信息
        client.admin().indices().prepareDeleteMapping(index).setType(type).execute().actionGet();
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        Version version = new Version("ios", "1.0.0", 1476798884845L, "http://www.baidu.com", null);
        Version version1 = new Version("android", "1.0.0", 1476798884845L, "http://www.baidu.com", null);
        bulkRequestBuilder.add(client.prepareIndex(index, type).setSource(JSON.toJSONString(version)).request());
        bulkRequestBuilder.add(client.prepareIndex(index, type).setSource(JSON.toJSONString(version1)).request());
        BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();
        if (bulkResponse.hasFailures()) {
            System.out.println("修改版本信息成功");
        } else {
            System.out.println("修改版本信息失败");
        }
    }
}
