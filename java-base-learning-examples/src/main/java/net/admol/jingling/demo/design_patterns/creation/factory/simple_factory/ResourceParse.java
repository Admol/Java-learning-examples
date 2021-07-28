package net.admol.jingling.demo.design_patterns.creation.factory.simple_factory;

/**
 * @author : jingling
 * @Date : 2021/7/28
 */
public interface ResourceParse{

    Resource.Config parser(String content);
}
