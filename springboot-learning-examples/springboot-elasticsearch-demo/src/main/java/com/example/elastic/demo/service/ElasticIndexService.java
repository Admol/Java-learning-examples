package com.example.elastic.demo.service;

import com.example.elastic.demo.util.JestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : jingling
 * @Date : 2018/3/9
 */
@Service
@Slf4j
public class ElasticIndexService {
    @Autowired
    private JestUtil jestUtil;

    public void createIndex(String indexName){
        try{
            jestUtil.createIndex(indexName);
        }catch (Exception e){
            log.error("createIndex exception:{}",e);
        }
    }
    public boolean createIndexMapping(String indexName, String typeName, String source){
        try{
            return jestUtil.createIndexMapping(indexName,typeName,source);
        }catch (Exception e){
            log.error("createIndex exception:{}",e);
        }
        return false;
    }

    public String getIndexMapping(String indexName, String typeName) throws Exception{
        return jestUtil.getIndexMapping(indexName,typeName);
    }
}
