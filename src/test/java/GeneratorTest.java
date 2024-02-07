import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.sql.Types;
import java.util.Collections;

public class GeneratorTest {

    /**
     * 代码生成器
     */
    @Test
    void genCode(){
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/soft", "root", "123")
                .globalConfig(builder -> {
                    builder.author("baomidou") // 设置作者
                           // .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\Users\\44563\\Desktop\\iov-admin\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.softeem") // 设置父包名
                            .moduleName("iov") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "C:\\Users\\44563\\Desktop\\iov-admin\\src\\main\\resources\\mappers")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {})
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
