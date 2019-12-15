package tr.com.getir.persistency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by omeruluoglu on 15.12.2019.
 */
@Document(collection = "records")
public class Record implements Serializable {

    /**
     * Records model identifier
     */
    @Id
    @JsonIgnore
    private String id;

    /**
     * Records model key field
     */
    private String key;

    /**
     * Records model value field
     */
    @JsonIgnore
    private String value;

    /**
     * Records model created at field
     */
    private Date createdAt;

    /**
     * Records model counts field
     */
    @JsonIgnore
    private List<Integer> counts;

    /**
     * Calculated total count according to count field
     */
    private Integer totalCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Integer> getCounts() {
        return counts;
    }

    public void setCounts(List<Integer> counts) {
        this.counts = counts;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        return new EqualsBuilder()
                .append(id, record.id)
                .append(key, record.key)
                .append(value, record.value)
                .append(createdAt, record.createdAt)
                .append(counts, record.counts)
                .append(totalCount, record.totalCount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(key)
                .append(value)
                .append(createdAt)
                .append(counts)
                .append(totalCount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", createdAt=" + createdAt +
                ", counts=" + counts +
                ", totalCount=" + totalCount +
                '}';
    }
}
