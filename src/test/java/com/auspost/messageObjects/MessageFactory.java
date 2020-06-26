package com.auspost.messageObjects;

import io.restassured.specification.RequestSpecification;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.w3c.dom.Document;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class MessageFactory extends MessageConstruct {

    String headerKey = "Srcsysid";
    String headerValue = "12";
    public static RequestSpecification httpRequest;
    String response = null;
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();


    public void authorizeRequest(String searchString,String modifyValue,String templateType,String templateIdValue) throws Exception {

        switch (templateType) {
            case "JSON":
                httpRequest = given().auth().none().headers(headerKey, headerValue, "Content-Type", "application/json")
                        .body(getBody(searchString,modifyValue,templateType,templateIdValue));
                httpRequest = given().auth().basic(variables.getProperty("HOST_USERNAME"), variables.getProperty("HOST_PASSWORD"))
                        .headers(headerKey, headerValue, "Content-Type", "application/json").body(getBody(searchString,modifyValue,templateType,templateIdValue));
                break;
            case "XML":
                httpRequest = given().auth().none().header("Content-Type", "application/xml").body(getBody(searchString,modifyValue,templateType,templateIdValue));
               // httpRequest = given().auth().basic(variables.getProperty("HOST_USERNAME"), variables.getProperty("HOST_PASSWORD")).header("Content-Type", "application/xml").body(getBody(searchString,modifyValue,templateType,templateIdValue));
                break;
        }



    }

    public String getBody(String searchString,String modifyValue, String templateType,String templateIdValue) throws Exception {
        String body = null;
        String template;

        switch(templateType) {
            case "JSON":
                //Get the Template data
                template = getTemplateData("Type",templateType,"Template");
                //Construct the JSON String
                body = constructJsonString(template,searchString,modifyValue);
                break;
            case "XML":
                //Get the Template data
                template = getTemplateData("Type",templateType,"TemplateId",templateIdValue,"Template");

                //Convert the XML template(String) to XML Doc Object
                Document doc = convertStringToXML(template);

                //update the XML doc(which contains xml template).
                updateXMLTemplateWithTestData(doc,searchString,modifyValue);

                //Once the XML doc is updated and is ready to be sent as a request body, convert it to String.
                body= convertDocumentToString(doc);
                break;
        }
        return body;

    }

    public void submitSOAPRequest(String searchString,String modifyValue,String templateType,String templateIdValue) throws Exception {
        response = String.valueOf(getSOAPResponse(variables.getProperty("HOST_URI"),getBody(searchString,modifyValue,templateType,templateIdValue)));
    }

    public void submitRequest(String templateType) throws Exception {
        String statusCode = null;

        if(templateType.contains("PublicAPI")){
            response = String.valueOf(httpRequest.when().post(variables.getProperty("publicHostURI")).thenReturn().getStatusCode());
        }else {
            String uriConstruct = getTemplateData("Type",templateType,"URIConstruct");
            response = String.valueOf(httpRequest.when().post(variables.getProperty("HOST_URI") + uriConstruct).thenReturn().getStatusCode());
        }
    }

    public void validateResponse(String statusCode){
        assertThat(response).contains(statusCode);
    }


    public int getSOAPResponse(String hostURI,String body) throws Exception {
        //***********SOAP XML works well with HTTPURLConnection Library*************
        String basicAuth = "Basic " + variables.getProperty("encodedAuth");

        URL url = new URL(hostURI);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.addRequestProperty("Content-Type", "application/xml; charset=UTF-8");
        conn.setRequestProperty ("Authorization", basicAuth);
        conn.setRequestMethod("POST");
        conn.setReadTimeout(15000);
        conn.setConnectTimeout(15000);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
        writer.write(body);
        writer.flush();
        writer.close();
        os.close();

        return conn.getResponseCode();
    }

}
