package net.admol.example.web.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author : admol
 * @Date : 2018/3/5
 */
@Slf4j
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.xinyan.task.dal.mapper.center",sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {
    @Value("${jdbc.master.url}")
    private String masterUrl;
    @Value("${jdbc.master.username}")
    private String masterUsername;
    @Value("${jdbc.master.password}")
    private String masterPassword;
    @Value("${jdbc.driver}")
    private String masterDriver;
    @Value("${jdbc.master.maxPoolSize}")
    private String masterMaxPoolSize;
    /**
     * 初始化注入 Hikari 主数据源
     *
     * @return
     */
    @Primary
    @Bean(name = "masterDataSource")
    public DataSource masterDataSource() {
        log.info("*******  初始化注入 Hikari masterDataSource 数据源 ! master_url:{}" , masterUrl);
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(masterUrl);
        hikariDataSource.setUsername(masterUsername);
        hikariDataSource.setPassword(masterPassword);
        hikariDataSource.setDriverClassName(masterDriver);
        hikariDataSource.setMaximumPoolSize(Integer.valueOf(masterMaxPoolSize));
        hikariDataSource.setMinimumIdle(1);
        hikariDataSource.setAutoCommit(true);
        hikariDataSource.setMaxLifetime(140000L);
        return hikariDataSource;
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();

        sessionFactoryBean.setDataSource(masterDataSource);

        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()

                .getResources("classpath*:sql/master/*.xml"));
        return sessionFactoryBean.getObject();

    }
}
