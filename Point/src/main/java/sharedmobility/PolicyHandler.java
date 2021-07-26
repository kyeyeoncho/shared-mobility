package sharedmobility;

import sharedmobility.config.kafka.KafkaProcessor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired PointsRepository pointsRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentApproved_Save(@Payload PaymentApproved paymentApproved){

        if(!paymentApproved.validate()) return;

        System.out.println("\n\n##### listener Approve : " + paymentApproved.toJson() + "\n\n");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        String today =  sdf.format(timestamp);

        // 결제 승인 시, 포인트적립 가능 상태로 변경
        Points points = new Points(); // 신규 생성
        points.setOrderId(paymentApproved.getOrderId());  // orderId 저장
        points.setPayId(paymentApproved.getPayId());  // payId 저장
        points.setPointStatus("SAVE");  // 적립 상태 저장
        points.setPointChangeDate(today);  // 승인 날짜
        points.setCurrentPoint(Long.valueOf("100"));  // 포인트 적립

        pointsRepository.save(points);

        System.out.println("Notice : 포인트가 적립 되었습니다.");

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentCanceled_SaveCancel(@Payload PaymentCanceled paymentCanceled){

        if(!paymentCanceled.validate()) return;

        System.out.println("\n\n##### listener Return : " + paymentCanceled.toJson() + "\n\n");

        // 결제 취소 수신 시, 포인트적립 취소 상태로 변경
        Points points = new Points(); 
        List<Points> pointList = pointsRepository.findByOrderId(paymentCanceled.getOrderId());

        for (Points o : pointList) {
            points = o;
        }

        if(points != null && !"CANCEL".equals(points.getPointStatus())){

            points.setOrderId(paymentCanceled.getOrderId());  // orderId 저장
            points.setPayId(paymentCanceled.getPayId());  // payId 저장
    
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            points.setPointChangeDate(sdf.format(timestamp));
            points.setPointStatus("CANCEL");
            points.setCurrentPoint(Long.valueOf("-100"));  // 포인트 적립 취소

            pointsRepository.save(points);

            System.out.println("Notice : 포인트가 적립 취소 되었습니다.");


        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
