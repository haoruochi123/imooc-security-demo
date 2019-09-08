import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void contextLoads() throws Exception {
        Map qqResultq = objectMapper.readValue("{\"client_id\":\"YOUR_APPID\",\"openid\":\"YOUR_OPENID\"}", Map.class);
       System.out.println(qqResultq.get("openid"));
    }

}
