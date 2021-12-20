package com.java.complaints.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.java.complaints.dao.ComplaintDAOImpl;
import com.java.complaints.dao.ComplaintResolveDAOImpl;
import com.java.complaints.dao.ResolveDAOImpl;

@Configuration
@ComponentScan(basePackages="com.java.complaints")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/complaint");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
	@Bean
	public ComplaintDAOImpl getComplaintDAO() {
		return new ComplaintDAOImpl(getDataSource());
	}
	
	@Bean
	public ResolveDAOImpl getResolveDAO() {
		return new ResolveDAOImpl(getDataSource());
	}
	
	@Bean
	public ComplaintResolveDAOImpl getComplaintResolveDAO() {
		return new ComplaintResolveDAOImpl(getDataSource());
	}
	
}
