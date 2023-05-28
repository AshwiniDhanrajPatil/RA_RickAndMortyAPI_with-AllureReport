package testClassPackage;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.Get_req_repository;
import similarFunctionPackage.API_Common_Function;

public class testClass
{
	@Test
	public static void execute() throws IOException 
	{
		String baseURI= Get_req_repository.baseURI();
		String resource =Get_req_repository.resource();	
		int statusCode=API_Common_Function.statusCode(baseURI, resource);
		String responseBody=API_Common_Function.resource(baseURI, resource);
		int id[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		String name[]= {"Rick Sanchez","Morty Smith","Summer Smith","Beth Smith","Jerry Smith","Abadango Cluster Princess","Abradolf Lincler","Adjudicator Rick","Agency Director","Alan Rails","Albert Einstein","Alexander","Alien Googah","Alien Morty","Alien Rick","Amish Cyborg","Annie","Antenna Morty","Antenna Rick","Ants in my Eyes Johnson"};
        String status[]= {"Alive","Alive","Alive","Alive","Alive","Alive","unknown","Dead","Dead","Dead","Dead","Dead","unknown","unknown","unknown","Dead","Alive","Alive","unknown","unknown"};
		String species[]= {"Human","Human","Human","Human","Human","Alien","Human","Human","Human","Human","Human","Human","Alien","Alien","Alien","Alien","Human","Human","Human","Human"};
		
		JsonPath jsp=new JsonPath(responseBody);
		int count=jsp.getList("results").size();
		for(int i=0;i<count;i++)
		{
			int exp_id=id[i];
			String exp_name=name[i];
			String exp_status=status[i];
			String exp_species=species[i];
			
			int res_id=jsp.getInt("results["+i+"].id");
			String res_name=jsp.getString("results["+i+"].name");
			String res_status=jsp.getString("results["+i+"].status");
			String res_species=jsp.getString("results["+i+"].species");
			
			Assert.assertEquals(statusCode, 200);
			Assert.assertEquals(res_id, exp_id);
		    Assert.assertEquals(res_name,exp_name);
			Assert.assertEquals(res_status, exp_status);
		    Assert.assertEquals(res_species,exp_species);
		}
		
		System.out.println("display the get validation result:"+responseBody);
	}

}
