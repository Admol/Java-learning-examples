package net.admol.jingling.demo.design_patterns.creation.builder;

import org.springframework.util.StringUtils;

/**
 * 构建者模式
 * @author : jingling
 * @Date : 2021/7/28
 */
public class ResourceConfig{
    private String name;
    private int maxSize;
    private int minSize;
    private int coreSize;

    private ResourceConfig(Builder builder){
        this.name = builder.name;
        this.coreSize = builder.coreSize;
        this.minSize = builder.minSize;
        this.maxSize = builder.maxSize;
    }


    public static class Builder{
        private static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
        private static final int DEFAULT_MIN_SIZE = 1;
        private static final int DEFAULT_CORE_SIZE = 16;

        private String name;

        private int maxSize = DEFAULT_MAX_SIZE;
        private int minSize = DEFAULT_MIN_SIZE;
        private int coreSize = DEFAULT_CORE_SIZE;

        /**
         * 最终构建对象
         * @return
         */
        public ResourceConfig build(){
            // 1.构建对象前，做好参数检验
            if(StringUtils.isEmpty(name)){
                throw new IllegalArgumentException("名字不能为空");
            }
            if(minSize > maxSize ||minSize > coreSize || coreSize > maxSize){
                throw new IllegalArgumentException("参数设置错误");
            }
            // 2.构建目标对象
            return new ResourceConfig(this);
        }

        public Builder setName(String name){
            if (StringUtils.isEmpty(name)) {
                throw new IllegalArgumentException("名字不能为空");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxSize(int maxSize){
            if (maxSize <= 0) {
                throw new IllegalArgumentException("coreSize不能小于0");
            }
            this.maxSize = maxSize;
            return this;
        }

        public Builder setMinSize(int minSize){
            if (minSize <= 0) {
                throw new IllegalArgumentException("coreSize不能小于0");
            }
            this.minSize = minSize;
            return this;
        }

        public Builder setCoreSize(int coreSize){
            if (coreSize <= 0) {
                throw new IllegalArgumentException("coreSize不能小于0");
            }
            this.coreSize = coreSize;
            return this;
        }
    }

}
