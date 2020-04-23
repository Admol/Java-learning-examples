package com.example.elastic.demo.controller;

import com.example.elastic.demo.service.ElasticIndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jingling
 * @Date : 2018/3/9
 */
@Slf4j
@RestController
public class ElasticTestController {

    @Autowired
    private ElasticIndexService elasticIndexService;

    @GetMapping(value="/get")
    public String getIndexMapping(String indexName, String typeName){
        try {
            return elasticIndexService.getIndexMapping(indexName,typeName);
        }catch (Exception e){
            log.error("getIndexMapping error:{}",e);
        }
        return "error";
    }


    @RequestMapping("/search")
    public String search(String content){
        return null;
    }

    @RequestMapping("/index")
    public Boolean createIndex(){
        String source = "{\n" +
                "    \"admol_blog\": {\n" +
                "      \"articls\": {\n" +
                "      \t\"article_id\": {\n" +
                "          \"type\": \"text\",\n" +
                "          \"analyzer\": \"ik_max_word\",\n" +
                "          \"search_analyzer\": \"ik_max_word\"\n" +
                "        },\n" +
                "        \"author\": {\n" +
                "          \"type\": \"text\",\n" +
                "          \"analyzer\": \"ik_max_word\",\n" +
                "          \"search_analyzer\": \"ik_max_word\"\n" +
                "        },\n" +
                "        \"create_time\": {\n" +
                "          \"type\": \"text\",\n" +
                "          \"analyzer\": \"ik_max_word\",\n" +
                "          \"search_analyzer\": \"ik_max_word\"\n" +
                "        },\n" +
                "        \"title\": {\n" +
                "          \"type\": \"text\",\n" +
                "          \"analyzer\": \"ik_max_word\",\n" +
                "          \"search_analyzer\": \"ik_max_word\"\n" +
                "        },\n" +
                "        \"content\": {\n" +
                "          \"type\": \"text\",\n" +
                "          \"analyzer\": \"ik_max_word\",\n" +
                "          \"search_analyzer\": \"ik_max_word\"\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "}";
        boolean createSuccess = elasticIndexService.createIndexMapping("admol_blog","articls",source);
        return createSuccess;
    }
}
