package top.codx.boot;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Slf4j
@SpringBootApplication(scanBasePackages = {"top.codx"})
@MapperScan("top.codx.db.mapper")
@EnableTransactionManagement
@EnableScheduling
public class TrackBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackBootApplication.class, args);
        log.warn("ᓚᘏᗢ Track-All 启动成功！ ヾ(≧▽≦*)o");
    }

}
