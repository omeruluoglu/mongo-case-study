package tr.com.getir.persistency.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by omeruluoglu on 15.12.2019.
 */
public class ResponsePayload implements Serializable {

    /**
     * Status of the request. Exp: 0 is success.
     */
    private Integer code;

    /**
     * Description of the code.
     */
    private String msg;

    /**
     * Filtered items according to the request.
     */
    private List<Record> recordList;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ResponsePayload that = (ResponsePayload) o;

        return new EqualsBuilder()
                .append(code, that.code)
                .append(msg, that.msg)
                .append(recordList, that.recordList)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(code)
                .append(msg)
                .append(recordList)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ResponsePayload{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", recordList=" + recordList +
                '}';
    }
}
