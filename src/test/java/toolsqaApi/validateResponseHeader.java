package toolsqaApi;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class validateResponseHeader {


    @Test
    public void validateResponse() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Zonguldak");

        Headers allHeaders = response.headers();

        for (Header header : allHeaders) {

            System.out.println(header.getName() + header.getValue());

            if (header.getName().equals("Server")) {
                Assert.assertEquals(header.getValue(), "nginx/1.14.0");
            } else if (header.getName().equals("Content-Type")) {
                Assert.assertEquals(header.getValue(), "application/json");
            } else if (header.getName().equals("Transfer-Encoding")) {
                Assert.assertEquals(header.getValue(), "chunked");
            } else if (header.getName().equals("Connection")) {
                Assert.assertEquals(header.getValue(), "keep-alive");
            } else if (header.getName().equals("Cache-Control")) {
                Assert.assertEquals(header.getValue(), "max-age=2592000");
            } else if (header.getName().equals("VaryAccept-Encoding")) {
                Assert.assertEquals(header.getValue(), "User-Agent");
            }
        }
    }
}
