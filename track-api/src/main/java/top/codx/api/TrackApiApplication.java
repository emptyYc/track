package top.codx.api;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication(scanBasePackages = {"top.codx.db", "top.codx.core", "top.codx.api"})
@MapperScan("top.codx.db.mapper")
@EnableTransactionManagement
@EnableScheduling
public class TrackApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackApiApplication.class, args);
        log.warn("ᓚᘏᗢ Track-Admin 启动成功！ ヾ(≧▽≦*)o");
    }

}
