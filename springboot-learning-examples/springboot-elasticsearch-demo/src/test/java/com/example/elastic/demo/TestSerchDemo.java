package com.example.elastic.demo;

import com.alibaba.fastjson.JSON;
import com.example.elastic.demo.util.JestUtil;
import io.searchbox.core.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : jingling
 * @Date : 2018/3/14
 */
@Slf4j
public class TestSerchDemo extends BaseTest{

    @Autowired
    private JestUtil jestUtil;

    @Test
    public void  testSearch(){
        try{
            SearchResult  result = jestUtil.search("accounts","person","1");
            log.info("searchResult:{}" , result.getJsonObject());
        }catch (Exception e){
            log.error("e:{}",e);
        }

    }
}
