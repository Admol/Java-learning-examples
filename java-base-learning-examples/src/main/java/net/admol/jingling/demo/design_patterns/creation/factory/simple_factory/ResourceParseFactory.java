package net.admol.jingling.demo.design_patterns.creation.factory.simple_factory;

/**
 * @author : jingling
 * @Date : 2021/7/28
 */
public class ResourceParseFactory{

    public static ResourceParse createParser(String ruleConfigFileExtension){
        ResourceParse parser = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }
}
