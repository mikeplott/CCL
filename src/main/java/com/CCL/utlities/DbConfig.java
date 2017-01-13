//package com.CCL.utlities;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//import javax.sql.DataSource;
//
///**
// * Created by michaelplott on 1/13/17.
// */
//@Configuration
////@EnableJpaRepositories("com.CCL.services.EmpMetaData")
//public class DbConfig {
//
//    @Primary
//    @Bean(name = "myh2Db")
//    @ConfigurationProperties(prefix = "spring.ds_h2")
//    public DataSource h2DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "myh2JdbcTemplate")
//    public JdbcTemplate jdbcTemplate(@Qualifier("myh2Db") DataSource dsh2Db) {
//        return new JdbcTemplate(dsh2Db);
//    }
//
//    @Bean(name = "mongodb")
//    @ConfigurationProperties(prefix = "spring.ds_mongo")
//    public DataSource mongoDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "mongoJdbcTemplate")
//    public JdbcTemplate mongoJdbcTemplate(@Qualifier("mongodb") DataSource dsMongo) {
//        return new JdbcTemplate(dsMongo);
//    }
//}
