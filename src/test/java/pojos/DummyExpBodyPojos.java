package pojos;

public class DummyExpBodyPojos {

    private String status;
    private DummyDataPojos data;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyDataPojos getData() {
        return data;
    }

    public void setData(DummyDataPojos data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DummyExpBodyPojos(String status, DummyDataPojos data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public DummyExpBodyPojos() {
    }

    @Override
    public String toString() {
        return "DummyExpBodyPojos{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
