import com.petstore.pojo.Request.Pet;
import com.petstore.utils.Configuration;
import io.restassured.RestAssured;
import io.restassured.config.Config;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;


public class BaseTest {



    @BeforeClass
    static void setupConfig() throws IOException {
        Configuration config = new Configuration();
        RestAssured.baseURI = config.getString("base.uri");
        RestAssured.basePath = config.getString("base.path");
        RestAssured.defaultParser = Parser.JSON;
    }
}
