package sharedmobility;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Dashboard_table")
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dashboardId;
    private Long customerId;
    private Long orderId;
    private Long paymentId;
    private Long rentId;
    private String payStatus;
    private String orderStatus;
    private String orderDate;
    private String cancelDate;
    private String returnDate;
    private String payDate;
    private Long price;
    private String payCancelDate;
    private String rentStatus;
    private String rentDate;
    // 추가
    private Long pointId;
    private Long currentPoint;
    private String pointChangeDate;
    private String pointStatus;

        public Long getDashboardId() {
            return dashboardId;
        }

        public void setDashboardId(Long dashboardId) {
            this.dashboardId = dashboardId;
        }
        public Long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Long customerId) {
            this.customerId = customerId;
        }
        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }
        public Long getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(Long paymentId) {
            this.paymentId = paymentId;
        }
        public Long getRentId() {
            return rentId;
        }

        public void setRentId(Long rentId) {
            this.rentId = rentId;
        }
        public String getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(String payStatus) {
            this.payStatus = payStatus;
        }
        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }
        public String getCancelDate() {
            return cancelDate;
        }

        public void setCancelDate(String cancelDate) {
            this.cancelDate = cancelDate;
        }
        public String getReturnDate() {
            return returnDate;
        }

        public void setReturnDate(String returnDate) {
            this.returnDate = returnDate;
        }
        public String getPayDate() {
            return payDate;
        }

        public void setPayDate(String payDate) {
            this.payDate = payDate;
        }
        public Long getPrice() {
            return price;
        }

        public void setPrice(Long price) {
            this.price = price;
        }
        public String getPayCancelDate() {
            return payCancelDate;
        }

        public void setPayCancelDate(String payCancelDate) {
            this.payCancelDate = payCancelDate;
        }

        public void setRentStatus(String rentStatus) {
            this.rentStatus = rentStatus;
        }

        public String getRentStatus() {
            return rentStatus;
        }

        public String getRentDate() {
            return rentDate;
        }

        public void setRentDate(String rentDate) {
            this.rentDate = rentDate;
        }
        //  
        public Long getPointId() {
            return pointId;
        }

        public void setPointId(Long pointId) {
            this.pointId = pointId;
        }
      
        public String getPointChangeDate() {
            return pointChangeDate;
        }

        public void setPointChangeDate(String pointChangeDate) {
            this.pointChangeDate = pointChangeDate;
        }

        public Long getCurrentPoint() {
			return currentPoint;
		}

		public void setCurrentPoint(Long currentPoint) {
			this.currentPoint = currentPoint;
        }
        
        public String getPointStatus() {
            return pointStatus;
        }

        public void setPointStatus(String pointStatus) {
            this.pointStatus = pointStatus;
        }
}
