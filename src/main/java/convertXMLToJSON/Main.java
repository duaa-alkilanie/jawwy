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
    public static void main(String[] args) {
        try {
            // Deserialize attached XML
            String xmlString = new String(Files.readAllBytes(Paths.get("src/main/resources/websites.xml")));
            JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
            JSONArray websiteJSONArray = xmlJSONObj.getJSONObject("WebsiteList").getJSONArray("Website");

            // Add new attributes to XML
            addNewAttributes(websiteJSONArray);

            // Convert XML to JSON
            List<JSONObject> websitesList = convertJSONArrayToList(websiteJSONArray);

            // Get all websites created after September 1
            JSONArray websitesAfterSeptember = getWebsitesAfterDate(websitesList, "MM/dd/yyyy h:mm:ss a", 2022, 9, 1);

            // Print information of the websites
            printWebsitesInfo(websitesAfterSeptember);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addNewAttributes(JSONArray websiteJSONArray) {
        for (int i = 0; i < websiteJSONArray.length(); i++) {
            JSONObject websiteObj = websiteJSONArray.getJSONObject(i);
            websiteObj.put("NewAttribute", "NewValue");
            System.out.println("the JSONArray after add the new attributes="+websiteObj);
        }
    }

    private static List<JSONObject> convertJSONArrayToList(JSONArray jsonArray) {
        List<JSONObject> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getJSONObject(i));
        }
        return list;
    }

    private static JSONArray getWebsitesAfterDate(List<JSONObject> websitesList, String dateFormat, int year, int month, int day) {
        JSONArray resultArray = new JSONArray();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate targetDate = LocalDate.of(year, month, day);
        for (JSONObject website : websitesList) {
            String createdDateStr = website.getString("CreatedDate");
            LocalDate createdDate = LocalDate.parse(createdDateStr, formatter);
            if (targetDate.isAfter(createdDate)) {
                resultArray.put(website);
            }
        }
        return resultArray;
    }

    private static void printWebsitesInfo(JSONArray websitesArray) {
        for (int i = 0; i < websitesArray.length(); i++) {
            JSONObject website = websitesArray.getJSONObject(i);
            System.out.println("Website " + (i + 1) + ":");
            System.out.println("URL: " + website.getString("URL"));
            System.out.println("Title: " + website.getString("Title"));
            System.out.println("Description: " + website.getString("Description"));
            System.out.println("Created Date: " + website.getString("CreatedDate") + "\n");
        }
    }
}
