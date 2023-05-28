package requestRepositoryPackage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.BeforeTest;

public class Get_req_repository {
@BeforeTest
	public static String baseURI() {
		String baseURI="https://reqres.in/";
		return baseURI;
	}
    public static String resource() {
    	String resource="/api/users?page=2";
    	return resource;
    }
}

