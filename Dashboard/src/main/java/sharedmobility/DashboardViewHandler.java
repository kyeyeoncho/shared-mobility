package sharedmobility;

import sharedmobility.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DashboardViewHandler {


    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {

            if (!ordered.validate()) return;
            // view 객체 조회
            List<Dashboard> dashboardList = dashboardRepository.findByOrderId(ordered.getOrderId());
            for(Dashboard dashboard : dashboardList){
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setOrderId(ordered.getOrderId());
                dashboard.setOrderStatus(ordered.getOrderStatus());
                dashboard.setCustomerId(ordered.getCustomerId());
                dashboard.setOrderDate(ordered.getOrderDate());

                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_1(@Payload PaymentApproved paymentApproved) {
        try {
            if (!paymentApproved.validate()) return;
                // view 객체 생성
                Dashboard dashboard = new Dashboard();
                // view 객체에 이벤트의 Value 를 set 함
                dashboard.setOrderId(paymentApproved.getOrderId());
                dashboard.setPaymentId(paymentApproved.getPayId());
                dashboard.setPayDate(paymentApproved.getPayDate());
                dashboard.setPayStatus(paymentApproved.getPayStatus());
                dashboard.setPrice(paymentApproved.getPrice());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceled_then_UPDATE_2(@Payload Canceled canceled) {
        try {
            if (!canceled.validate()) return;
                // view 객체 조회

                    List<Dashboard> dashboardList = dashboardRepository.findByOrderId(canceled.getOrderId());
                    for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setOrderStatus(canceled.getOrderStatus());
                    dashboard.setCancelDate(canceled.getCancelDate());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReturned_then_UPDATE_3(@Payload Returned returned) {
        try {
            if (!returned.validate()) return;
                // view 객체 조회

                    List<Dashboard> dashboardList = dashboardRepository.findByOrderId(returned.getOrderId());
                    for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setOrderStatus(returned.getOrderStatus());
                    dashboard.setReturnDate(returned.getReturnDate());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCanceled_then_UPDATE_4(@Payload PaymentCanceled paymentCanceled) {
        try {
            if (!paymentCanceled.validate()) return;
                // view 객체 조회

                    List<Dashboard> dashboardList = dashboardRepository.findByOrderId(paymentCanceled.getOrderId());
                    for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setPayStatus(paymentCanceled.getPayStatus());
                    dashboard.setPayCancelDate(paymentCanceled.getPayCancelDate());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRented_then_UPDATE_5(@Payload Rented Rented) {
        try {
            if (!Rented.validate()) return;
                // view 객체 조회

                    List<Dashboard> dashboardList = dashboardRepository.findByOrderId(Rented.getOrderId());
                    for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setRentId(Rented.getRentId());
                    dashboard.setRentStatus(Rented.getRentStatus());
                    dashboard.setRentDate(Rented.getRentDate());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //추가
    @StreamListener(KafkaProcessor.INPUT)
    public void whenSaved_then_UPDATE_6(@Payload Saved Saved) {
        try {
            if (!Saved.validate()) return;
                // view 객체 조회

                    List<Dashboard> dashboardList = dashboardRepository.findByOrderId(Saved.getOrderId());
                    for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setPointId(Saved.getPointId());
                    dashboard.setPointStatus(Saved.getPointStatus());
                    dashboard.setPointChangeDate(Saved.getPointChangeDate());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSaveCanceled_then_UPDATE_7(@Payload SaveCanceled SaveCanceled) {
        try {
            if (!SaveCanceled.validate()) return;
                // view 객체 조회

                    List<Dashboard> dashboardList = dashboardRepository.findByOrderId(SaveCanceled.getOrderId());
                    for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setPointId(SaveCanceled.getPointId());
                    dashboard.setPointStatus(SaveCanceled.getPointStatus());
                    dashboard.setPointChangeDate(SaveCanceled.getPointChangeDate());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
