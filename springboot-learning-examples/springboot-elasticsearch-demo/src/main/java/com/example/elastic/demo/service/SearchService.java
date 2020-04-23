package com.example.elastic.demo.service;

import com.example.elastic.demo.util.JestUtil;
import io.searchbox.core.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : admol
 * @Date : 2018/3/9
 */
@Service
@Slf4j
public class SearchService {
    @Autowired
    private JestUtil jestUtil;

    public int search(String indexName, String typeName, String query){
        try{
            SearchResult searchResult = jestUtil.search(indexName,typeName,query);
            return searchResult.getTotal();
        }catch (Exception e){
            log.error("SearchService search Exception:{}",e);
        }
        return 0;
    }
}
