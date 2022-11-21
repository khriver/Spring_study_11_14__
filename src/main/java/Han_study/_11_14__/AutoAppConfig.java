package Han_study._11_14__;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "Han_study._11_14__",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)  // 예외를 잘 하지 않는데 기본 예제 코드를 남기기위해 사용
)
public class AutoAppConfig {

}
