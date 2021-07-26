package sharedmobility;

public class Saved extends AbstractEvent {

    private Long pointId;
    private Long payId;
    private Long point;
    private String pointChangeDate;
    private String pointStatus;

    public Saved(){
        super();
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }
    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }
    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }
    public String getPointChangeDate() {
        return pointChangeDate;
    }

    public void setPointChangeDate(String saveDate) {
        this.pointChangeDate = saveDate;
    }
    public String getPointStatus() {
        return pointStatus;
    }

    public void setPointStatus(String pointStatus) {
        this.pointStatus = pointStatus;
    }
}
