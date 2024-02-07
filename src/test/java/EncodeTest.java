import com.baomidou.mybatisplus.core.toolkit.AES;
import org.junit.jupiter.api.Test;

public class EncodeTest {
    @Test
    void testToken(){
        String key= AES.generateRandomKey();//生成随机密钥  d5fd37bab5292e07
        System.out.println("密钥"+key);
        String url=AES.encrypt(" jdbc:mysql://127.0.0.1:3306/soft",key);
        String user=AES.encrypt("root",key);
        String pwd=AES.encrypt("123",key);
        System.out.println("user"+user);
        System.out.println("pwd"+pwd);
        System.out.println("url"+url);
        System.out.println("---------");

    }
}
