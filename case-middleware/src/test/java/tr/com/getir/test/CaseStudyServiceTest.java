package tr.com.getir.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tr.com.getir.persistency.dao.RecordDao;
import tr.com.getir.persistency.model.Record;
import tr.com.getir.service.CaseStudyService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by omeruluoglu on 15.12.2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class CaseStudyServiceTest {

    @InjectMocks
    private CaseStudyService caseStudyService;

    @Mock
    private RecordDao recordDao;

    private List<Record> recordList;
    private SimpleDateFormat simpleDateFormat;

    private Date date1;
    private Date date2;

    @Before
    public void before() {
        String pattern = "yyyy-MM-dd";
        simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            date1 = simpleDateFormat.parse("2019-12-10T13:23:38.320Z");
            date2 = simpleDateFormat.parse("2019-12-15T13:23:38.320Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Integer> counts = new ArrayList<>();
        counts.add(100);
        counts.add(200);
        counts.add(300);

        List<Integer> counts2 = new ArrayList<>();
        counts2.add(400);
        counts2.add(500);
        counts2.add(100);

        Record record = new Record();
        record.setId("1");
        record.setKey("key");
        record.setValue("value");
        record.setCreatedAt(date1);
        record.setCounts(counts);

        Record record2 = new Record();
        record2.setId("2");
        record2.setKey("key2");
        record2.setValue("value2");
        record2.setCreatedAt(date2);
        record2.setCounts(counts2);
        recordList = new ArrayList<>();
        recordList.add(record);
        recordList.add(record2);
    }

    @Test
    public void test_CaseStudyService_withCorrectPayload_isSuccess() {
        String startDate = "2019-12-09";
        String endDate = "2019-12-16";
        try {
            date1 = simpleDateFormat.parse(startDate);
            date2 = simpleDateFormat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer minCount = 500;
        Integer maxCount = 1100;
        when(recordDao.getRecordsByCreatedAt(date1, date2)).thenReturn(recordList);
        List<Record> filteredRecordList = caseStudyService.getFilteredRecords(startDate, endDate, minCount, maxCount);
        assertFalse(filteredRecordList.isEmpty());
        assertEquals(2, filteredRecordList.size());
    }

    @Test
    public void test_CaseStudyService_withWrongPayload_isSuccess() {
        String startDate = "2019-12-15";
        String endDate = "2019-12-16";
        Integer minCount = 500;
        Integer maxCount = 1100;
        try {
            date1 = simpleDateFormat.parse("2019-12-15T13:23:38.320Z");
            date2 = simpleDateFormat.parse("2019-12-16T13:23:38.320Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        when(recordDao.getRecordsByCreatedAt(date1, date2)).thenReturn(new ArrayList<>());
        List<Record> filteredRecordList = caseStudyService.getFilteredRecords(startDate, endDate, minCount, maxCount);
        assertTrue(filteredRecordList.isEmpty());
        assertEquals(0, filteredRecordList.size());
    }

    @Test
    public void test_CaseStudyService_withWrongPayload_isFail() {
        String startDate = "2019-12-15";
        String endDate = "2019-12-16";
        Integer minCount = 600;
        Integer maxCount = 1000;
        try {
            date1 = simpleDateFormat.parse("2019-12-15T13:23:38.320Z");
            date2 = simpleDateFormat.parse("2019-12-16T13:23:38.320Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        when(recordDao.getRecordsByCreatedAt(date1, date2)).thenReturn(recordList);
        List<Record> filteredRecordList = caseStudyService.getFilteredRecords(startDate, endDate, minCount, maxCount);
        assertTrue(filteredRecordList.isEmpty());
        assertEquals(0, filteredRecordList.size());
    }

    @Test
    public void test_CaseStudyService_withCount_isSucces() {
        String startDate = "2019-12-15";
        String endDate = "2019-12-16";
        Integer minCount = 500;
        Integer maxCount = 1000;
        try {
            date1 = simpleDateFormat.parse("2019-12-15T13:23:38.320Z");
            date2 = simpleDateFormat.parse("2019-12-16T13:23:38.320Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        when(recordDao.getRecordsByCreatedAt(date1, date2)).thenReturn(recordList);
        List<Record> filteredRecordList = caseStudyService.getFilteredRecords(startDate, endDate, minCount, maxCount);
        assertFalse(filteredRecordList.isEmpty());
        assertEquals(1, filteredRecordList.size());
    }
}
