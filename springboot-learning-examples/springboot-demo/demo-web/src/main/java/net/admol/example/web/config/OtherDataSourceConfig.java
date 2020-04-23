package net.admol.example.web.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author : admol
 * @Date : 2018/3/5
 */
@Slf4j
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.xinyan.task.dal.mapper.center",sqlSessionFactoryRef = "otherSqlSessionFactory")
public class OtherDataSourceConfig {
    @Value("${jdbc.other.url}")
    private String otherUrl;
    @Value("${jdbc.other.username}")
    private String otherUsername;
    @Value("${jdbc.other.password}")
    private String otherPassword;
    @Value("${jdbc.driver}")
    private String otherDriver;
    @Value("${jdbc.other.maxPoolSize}")
    private String otherMaxPoolSize;
    /**
     * 初始化注入 Hikari 主数据源
     *
     * @return
     */
    @Primary
    @Bean(name = "otherDataSource")
    public DataSource otherDataSource() {
        log.info("*******  初始化注入 Hikari otherDataSource 数据源 ! other_url:{}" , otherUrl);
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(otherUrl);
        hikariDataSource.setUsername(otherUsername);
        hikariDataSource.setPassword(otherPassword);
        hikariDataSource.setDriverClassName(otherDriver);
        hikariDataSource.setMaximumPoolSize(Integer.valueOf(otherMaxPoolSize));
        hikariDataSource.setMinimumIdle(1);
        hikariDataSource.setAutoCommit(true);
        hikariDataSource.setMaxLifetime(140000L);
        return hikariDataSource;
    }

    @Bean(name = "otherSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("otherDataSource") DataSource otherDataSource) throws Exception {

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();

        sessionFactoryBean.setDataSource(otherDataSource);

        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()

                .getResources("classpath*:sql/other/*.xml"));
        return sessionFactoryBean.getObject();

    }
}
