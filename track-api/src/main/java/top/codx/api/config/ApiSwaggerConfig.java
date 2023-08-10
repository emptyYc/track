package top.codx.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger配置类
 *
 * @author lch mailTo:{yulwins@163.com}
 * @since 2023-04-03 15:40
 */
@Configuration
public class ApiSwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.OAS_30)
                .enable(true)
                .apiInfo(apiApiInfo())
                .groupName("Api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.codx.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiApiInfo() {
        return new ApiInfoBuilder()
                .title("Fresh-Admin API")
                .description("轨迹后台API")
                .contact(new Contact("个人主页", "https://codx.top", null))
                .version("1.0")
                .build();
    }
}
