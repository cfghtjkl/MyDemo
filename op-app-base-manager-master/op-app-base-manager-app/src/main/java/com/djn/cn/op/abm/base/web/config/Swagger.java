package com.djn.cn.op.abm.base.web.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 
 * <b>类 名：</b>Swagger<br/>
 * <b>类描述：</b>Swagger配置类<br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2019年5月4日 下午7:17:29<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2019年5月4日 下午7:17:29<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 *
 */
@Configuration
public class Swagger {
	@Value("${swagger.is.enable}")
	private boolean swaggerIsEnable;
    Predicate<RequestHandler> selectorBaseApi = RequestHandlerSelectors.basePackage("com.djn.cn.op.abm.base.web.controller");

	@Bean
	public Docket controllerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(swaggerIsEnable)
				.apiInfo(apiInfo())
				.select()
				.apis(Predicates.or(selectorBaseApi))
				.paths(PathSelectors.any()).build();
	}
	
	//  优雅的构建 
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("xx公司_xx项目_接口文档")
				.description("描述内容")
				.version("1.0.0")
				.build();	
	}
}
