package gr.pr.udemy.rest.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	protected Class<?>[] getRootConfigClasses() {
		return new Class[0];
	}

	protected Class<?>[] getServletConfigClasses() {
//		return new Class[0];
		return new Class[] {AppConfiguration.class};
	}

	protected String[] getServletMappings() {
//		return new String[0];
		return new String[] { "/"};
	}
}
