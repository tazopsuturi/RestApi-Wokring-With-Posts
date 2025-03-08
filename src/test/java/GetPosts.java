import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class GetPosts {
	
	public Response response;
	
	@Test
	public void testGetPosts() {
		response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
		JsonPath jsonPath = response.jsonPath();
		List<Map<String, Object>> firstProd = jsonPath.getList("$");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String formattedJson = gson.toJson(firstProd);
		
		System.out.println(formattedJson);
		
	}
}
