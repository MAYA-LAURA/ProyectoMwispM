package com.mx.mwisp.mwsipfinal.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class UploadConfig extends WebMvcConfigurerAdapter{
	private static final Log LOG=LogFactory.getLog(UploadConfig.class);

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
		Path rootBase=Paths.get("uploads").toAbsolutePath();
		//Path rootBase2=Paths.get("uploads2").toAbsolutePath();
		String resourcePath=Paths.get("uploads").toAbsolutePath().toUri().toString();	
		//String resourcePath2=Paths.get("uploads2").toAbsolutePath().toUri().toString();
				
		if(!Files.exists(rootBase)) {
			try {
				Files.createDirectories(rootBase);
				LOG.info("resourcePath========================================================="+resourcePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
						
		registry.addResourceHandler("/uploads/**")
		.addResourceLocations(resourcePath);
		
	}

}
