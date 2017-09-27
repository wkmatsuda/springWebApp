package jp.co.ws.training.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/item_name.properties")
public class ItemNameProperties {

    // Environmentをインジェクション
    @Autowired
    private Environment env;

    public String get(String key){
        // Environmentからプロパティ値を取得
        return env.getProperty(key);
    }

}
