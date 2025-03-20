package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//application-datasource
/*
 *     <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
       p:driverClassName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@localhost:1521:XE"
       p:username="hr"
       p:password="happy"
    />
   
    />
    <!-- Mapper���� MapperFactoryBean : SQL������ �о ���� / ����� -->
    <mybatis-spring:scan base-package="com.sist.mapper" factory-ref="ssf"/>
 */
@Configuration
@MapperScan(basePackages = "com.sist.mapper")
public class DatabaseConfig {
		/*
		 *  <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		       p:driverClassName="oracle.jdbc.driver.OracleDriver"
		       p:url="jdbc:oracle:thin:@localhost:1521:XE"
		       p:username="hr"
		       p:password="happy"
    		/>
		 */
		@Bean("ds")
		public DataSource dataSource() {
			
			
			BasicDataSource ds=new BasicDataSource();
			ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			ds.setUsername("hr");
			ds.setPassword("happy");
			
			return ds;
		}
		/*
		 *  <!-- MyBatis���� : SqlSessionFactory : ����Ŭ ����/���� -->
		    <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		      p:dataSource-ref="ds"
		 */
		@Bean("ssf")
		public SqlSessionFactory sqlSessionFactory() throws Throwable {
			
			SqlSessionFactoryBean ssf= new SqlSessionFactoryBean();
			ssf.setDataSource(dataSource());
			return ssf.getObject();
			
		}
}
