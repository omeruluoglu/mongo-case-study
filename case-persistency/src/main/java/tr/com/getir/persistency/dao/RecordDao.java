package tr.com.getir.persistency.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import tr.com.getir.persistency.model.Record;

import java.util.Date;
import java.util.List;

/**
 * Created by omeruluoglu on 15.12.2019.
 */
public interface RecordDao extends MongoRepository<Record, String> {

    /**
     * Filtering query according to case
     * @param startDate given start date
     * @param endDate given end date
     * @return List<Record>
     */
    @Query("{'createdAt' : { $gt: ?0, $lt: ?1 } }")
    List<Record> getRecordsByCreatedAt(Date startDate, Date endDate);
}
