package tr.com.getir.persistency.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Created by omeruluoglu on 15.12.2019.
 */
public class RequestPayload implements Serializable {

    /**
     * Given rest payload start date field
     */
    private String startDate;

    /**
     * Given rest payload end date field
     */
    private String endDate;

    /**
     * Given rest payload minimum count field
     */
    private Integer minCount;

    /**
     * Given rest payload maximum count field
     */
    private Integer maxCount;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getMinCount() {
        return minCount;
    }

    public void setMinCount(Integer minCount) {
        this.minCount = minCount;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RequestPayload that = (RequestPayload) o;

        return new EqualsBuilder()
                .append(startDate, that.startDate)
                .append(endDate, that.endDate)
                .append(minCount, that.minCount)
                .append(maxCount, that.maxCount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(startDate)
                .append(endDate)
                .append(minCount)
                .append(maxCount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "RequestPayload{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", minCount=" + minCount +
                ", maxCount=" + maxCount +
                '}';
    }
}
