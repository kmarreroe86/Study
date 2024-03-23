package linkedinlearning.datascience.loaddata;

import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvLoading {

    public static void main(String[] args) {

        File file = new File("src/main/resources/datascience/Groceries_dataset.csv");
        List<CSVRecord> records = CsvLoader.parseCsv(file.getAbsolutePath());

        List<GroceryRecord> groceryRecords = records.stream().map(GroceryRecordUtil::parseGroceryRecord).collect(Collectors.toList());
//        groceryRecords.forEach(System.out::println);


        // Implement this:
        System.out.println("Challenge");
        Map<String, List<GroceryRecord>> recordsByMemberNumber =
                GroceryRecordUtil.groupGroceryRecordsByMemberNumber(groceryRecords);

        System.out.println(recordsByMemberNumber);

    }
}
