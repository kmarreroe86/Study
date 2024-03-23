package linkedinlearning.datascience.loaddata;

import org.apache.commons.csv.CSVRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroceryRecordUtil {

    public static GroceryRecord parseGroceryRecord(CSVRecord record) {

        try {
            String memberNumber = record.get("Member_number");
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(record.get("Date"));
            String itemDescription = record.get("itemDescription");

            return new GroceryRecord(memberNumber, date, itemDescription);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }

    public static Map<String, List<GroceryRecord>> groupGroceryRecordsByMemberNumber(List<GroceryRecord> groceryRecords) {

        Map<String, List<GroceryRecord>> groceryByMemberNumber = groceryRecords.stream()
                .collect(Collectors.groupingBy(g -> g.memberNumber));

        return groceryByMemberNumber;
    }
}
























