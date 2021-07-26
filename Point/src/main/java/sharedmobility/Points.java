package sharedmobility;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Points_table")
public class Points {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long pointId;
    private Long orderId;
    private Long payId;
    private Long customerId;
    private Long currentPoint;
    private String pointChangeDate;
    private String pointStatus; //SAVE, CANCEL

    //엔티티 저장 후
    @PostPersist
    public void onPostPersist(){
        if(this.currentPoint == -100){
            SaveCanceled saveCanceled = new SaveCanceled();
            BeanUtils.copyProperties(this, saveCanceled);
            saveCanceled.publishAfterCommit();
        }else if(this.currentPoint == 100){
            Saved saved = new Saved();
            BeanUtils.copyProperties(this, saved);
            saved.publishAfterCommit();
        }
        /*       
        Inquired inquired = new Inquired();
        BeanUtils.copyProperties(this, inquired);
        inquired.publishAfterCommit();
        */

    }

    //엔티티 업데이트 후
    @PostUpdate
    public void onPostUpdate(){
        if("CANCEL".equals(this.pointStatus)){
            // 적립취소 상태
            SaveCanceled canceled = new SaveCanceled();
            BeanUtils.copyProperties(this, canceled);
            canceled.publishAfterCommit();
        }
        
        if("SAVE".equals(this.pointStatus)){
            // 적립 상태
            Saved saved = new Saved();
            BeanUtils.copyProperties(this, saved);
            saved.publishAfterCommit();
        }
    }    

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Long currentPoint) {
        this.currentPoint = currentPoint;
    }
    public String getPointChangeDate() {
        return pointChangeDate;
    }

    public void setPointChangeDate(String pointChangeDate) {
        this.pointChangeDate = pointChangeDate;
    }

    public String getPointStatus() {
        return pointStatus;
    }

    public void setPointStatus(String pointStatus) {
        this.pointStatus = pointStatus;
    }


}