package convertXMLToJSON;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // Deserialize attached XML
        String xmlString = new String(Files.readAllBytes(Paths.get("src/main/resources/websites.xml")));
        JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
        JSONArray websitesArray = xmlJSONObj.getJSONObject("WebsiteList").getJSONArray("Website");

        // Add new attributes to XML
        for (int i = 0; i < websitesArray.length(); i++) {
            JSONObject websiteObj = websitesArray.getJSONObject(i);
            websiteObj.put("NewAttribute", "NewValue");
        }

        // Convert XML to JSON
        List<JSONObject> websitesList = new ArrayList<>();
        for (int i = 0; i < websitesArray.length(); i++) {
            websitesList.add(websitesArray.getJSONObject(i));
        }

// Get all websites created  After September
        JSONArray websitesAfterSeptember = new JSONArray();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a");
        LocalDate afterSeptember = LocalDate.of(2022, 9, 1);
        for (JSONObject website : websitesList) {
            String createdDateStr = website.getString("CreatedDate");
            LocalDate createdDate = LocalDate.parse(createdDateStr, formatter);
//            if (createdDate.isAfter(afterSeptember)) {
//                websitesAfterSeptember.put(website);
//            }
            if (afterSeptember.isAfter(createdDate)) {
                websitesAfterSeptember.put(website);
            }
        }



        // Print information of the websites
        for (int i = 0; i < websitesAfterSeptember.length(); i++) {

            JSONObject website = websitesAfterSeptember.getJSONObject(i);
            System.out.println("Website " + (i + 1) + ":");
            System.out.println("URL: " + website.getString("URL"));
            System.out.println("Title: " + website.getString("Title"));
            System.out.println("Description: " + website.getString("Description"));
            System.out.println("Created Date: " + website.getString("CreatedDate") + "\n");
        }
    }
}

