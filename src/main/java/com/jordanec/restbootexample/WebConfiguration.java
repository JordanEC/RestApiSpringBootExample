package com.jordanec.restbootexample;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;

@Configuration
//
@EnableAuthorizationServer
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
//
public class WebConfiguration {
	@EnableWebMvc
	protected static class WebMvcConfiguration extends WebMvcConfigurerAdapter {
		@Override
		public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
			converters.add(jacksonMessageConverter());
			super.configureMessageConverters(converters);
		}

		private MappingJackson2HttpMessageConverter jacksonMessageConverter() {
			MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
			ObjectMapper mapper = new ObjectMapper();
			Hibernate4Module hibernate4Module = new Hibernate4Module();
			hibernate4Module.configure(Feature.FORCE_LAZY_LOADING, true);
			mapper.registerModule(hibernate4Module);
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
			mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
			mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			messageConverter.setObjectMapper(mapper);
			return messageConverter;
		}
	}
}