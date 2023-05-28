package testClassPackage;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctionPackage.API_Common_Function;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.Get_req_repository;

public class Get_tc_1
{
	@Test
	public static void execute() throws IOException 
	{
		String baseURI= Get_req_repository.baseURI();
		String resource =Get_req_repository.resource();	
		int statusCode=API_Common_Function.statusCode(baseURI, resource);
		String responseBody=API_Common_Function.resource(baseURI, resource);
		int id[]= {7,8,9,10,11,12};
		String[] email={"michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", "tobias.funke@reqres.in", "byron.fields@reqres.in", "george.edwards@reqres.in", "rachel.howell@reqres.in"};
		JsonPath jsp=new JsonPath(responseBody);
		int count=jsp.getList("data").size();
		for(int i=0;i<count;i++)
		{
			int exp_id=id[i];
			String exp_email=email[i];
			int res_id=jsp.getInt("data["+i+"].id");
			String res_email=jsp.getString("data["+i+"].email");
			Assert.assertEquals(statusCode, 200);
			Assert.assertEquals(res_id, exp_id);
			Assert.assertEquals(res_email,exp_email);
			
		}
		
		System.out.println("display the get validation result:"+responseBody);
	}

}
