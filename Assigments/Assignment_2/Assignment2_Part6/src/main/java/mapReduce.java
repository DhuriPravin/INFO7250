import com.mongodb.*;


public class mapReduce {

    public static void countIpAddressVisit() {
        String map = "function(){"
                + "emit(this.ipAddress," + "{\"visitCount\":1});"
                + "}";

        // Define the reduce function
        String reduce = "function(key,values){"
                + "var result = {\"visitCount\": 0};"
                + "values.forEach("
                + "function(value){"
                +"result.visitCount += value.visitCount;"
                + "});"
                +" return result;"
                + "}";

        String inputCollection = "logfiles";
        String outputCollection = "countIpAddressVisit";

        mapReduce(inputCollection, map, reduce, outputCollection);
    }

    public static void countByMonth() {
        String map = "function(){"
                + "emit(this.month," + "{\"visitCount\":1});"
                + "}";

        // Define the reduce function
        String reduce = "function(key,values){"
                + "var result = {\"visitCount\": 0};"
                + "values.forEach("
                + "function(value){"
                +"result.visitCount += value.visitCount;"
                + "});"
                +" return result;"
                + "}";

        String inputCollection = "logfiles";
        String outputCollection = "countByMonth";

        mapReduce(inputCollection, map, reduce, outputCollection);
    }
    

    public static void main(String[] args) {
        countIpAddressVisit();
        countByMonth();

    }

    public static void mapReduce(String inputCollection, String map, String reduce, String outputCollection) {
        MongoClient client = new MongoClient("localhost", 27017);
        DB database = client.getDB("accesslog");
        DBCollection collection = database.getCollection(inputCollection);

        MapReduceCommand cmd = new MapReduceCommand(collection, map, reduce, outputCollection, MapReduceCommand.OutputType.REPLACE, null);

        MapReduceOutput it = collection.mapReduce(cmd);

        for (DBObject obj: it.results()) {
            System.out.println(obj.toString());
        }

        client.close();
    }
}