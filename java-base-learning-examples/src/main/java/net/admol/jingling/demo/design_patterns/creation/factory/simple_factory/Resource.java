package net.admol.jingling.demo.design_patterns.creation.factory.simple_factory;

/**
 * @author : jingling
 * @Date : 2021/7/28
 */
public class Resource{
    /**
     * 根据路径解析配置
     * @param configPath
     * @return
     */
    public Config load(String configPath){
        // 1.根据路径解析后缀扩展名
        String ruleConfigFileExtension = getFileExtension(configPath);
        // 2.根据扩展名获取对应的解析parser
        ResourceParse parser = ResourceParseFactory.createParser(ruleConfigFileExtension);

        // todo 从configPath获取内容
        String content = "";
        // 3. 调用具体的解析
        Config config = parser.parser(content);
        // 4. 返回解析结果
        return config;
    }

    private String getFileExtension(String configPath){
        // ... 解析返回 json xml  properties yaml ......
        return "json";
    }

    class Config{
    }
}
