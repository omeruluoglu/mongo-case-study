package tr.com.getir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.getir.persistency.dao.RecordDao;
import tr.com.getir.persistency.model.Record;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by omeruluoglu on 15.12.2019.
 */
@Component
public class CaseStudyService {

    @Autowired
    private RecordDao recordDao;

    /**
     * Retrieves filtered records from MongoDB
     * @param startDate given start date payload
     * @param endDate given end date payload
     * @param minCount given minimum count amount
     * @param maxCount given maximum count amount
     * @return List<Record> list of filtered record result
     */
    public List<Record> getFilteredRecords(String startDate, String endDate, Integer minCount, Integer maxCount) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        List<Record> recordList = new ArrayList<>();
        try {
            Date date1 = simpleDateFormat.parse(startDate);
            Date date2 = simpleDateFormat.parse(endDate);
            recordList = recordDao.getRecordsByCreatedAt(date1, date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!recordList.isEmpty())
            recordList.forEach(x -> {
                int sum = x.getCounts().stream().mapToInt(i -> i).sum();
                x.setTotalCount(sum);
            });
        return recordList.stream().filter(x -> maxCount > x.getTotalCount() && x.getTotalCount() > minCount).collect(Collectors.toList());
    }
}
