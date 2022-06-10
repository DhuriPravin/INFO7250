import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class ipAddress {
    String ipAddress;
    String timestamp;
    String timestampWithoutZone;
    String statusCode;
    String singleStatusCode;
    String command;
    String website;

    ipAddress(String ipAddress, String timeStamp, String timeStampWithoutZone, String statusCode, String singleStatusCode, String command, String website) {
        this.ipAddress = ipAddress;
        this.timestamp = timeStamp;
        this.timestampWithoutZone = timeStampWithoutZone;
        this.statusCode = statusCode;
        this.singleStatusCode = singleStatusCode;
        this.command = command;
        this.website = website;
    }

    @Override
    public String toString() {
        return "Address{" +
                "ipAddress='" + ipAddress + '\'' +
                ", timeStamp='" + timestamp + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", singleStatusCode='" + singleStatusCode + '\'' +
                ", command='" + command + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}

public class accesslogUpload {
    final static String fileName = "/Users/pravin/Documents/Northeastern_MSIS/Summer_2022/Assigments/Assignment_2/access.log";
    final static Charset encoding = StandardCharsets.UTF_8;
    private static final List<ipAddress> logs = new ArrayList<>();
    private static ArrayList<String> lines = new ArrayList<>();

    public static void main(String[] args) {
        try {
            lines = readFiles(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String l : lines)
            logs.add(logUpload(l));

        System.out.println("Log Count: " + logs.size());

        MongoDBUpload();


    }

    public static void MongoDBUpload() {

        MongoClient mongo = new MongoClient("localhost", 27017);
        System.out.println("Connection Established");
        DB database = mongo.getDB("accesslog");
        database.createCollection("logs", null);
        DBCollection collection = database.getCollection("logfiles");

        for (ipAddress add : logs) {
            BasicDBObject document = new BasicDBObject();
            document.put("ipAddress", add.ipAddress);
            document.put("timestamp", add.timestamp);
            document.put("timestampWithoutZone", add.timestampWithoutZone);
            document.put("statusCode", add.singleStatusCode);
            document.put("command", add.command);
            document.put("website", add.website);
            collection.insert(document);
        }

        System.out.println("Document uploaded to MongoDB");
    }

    public static ArrayList<String> readFiles(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(path, encoding.name())) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }
        return lines;
    }

    public static ipAddress logUpload(String log) {

        String[] logs = log.split(" - - ");
        String ipAddress = logs[0];

        logs = logs[1].split("]", 2);
        String timeStamp = logs[0].substring(1);
        timeStamp = timeStamp.replaceFirst(":", " ");

        String timeStampWithoutZone = timeStamp.split(" ")[0];

        logs = logs[1].split("\"");
        String statusCode = logs[2].substring(1);
        String singleStatusCode = statusCode.substring(0, statusCode.indexOf(' '));

        logs = logs[1].split(" ", 2);
        String command = logs[0];
        String address = "";
        try {
            address = logs[1];

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ip address not found");
        }
        return new ipAddress(ipAddress, timeStamp, timeStampWithoutZone, statusCode, singleStatusCode, command, address);
    }


}
