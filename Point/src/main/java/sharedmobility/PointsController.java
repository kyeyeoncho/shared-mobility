package sharedmobility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

 @RestController
 public class PointsController {
    @Autowired
    PointsRepository repository;

    // 결제 승인된 상태여야 적립 가능
    // 포인트ID로 접근하여 적립 요청
    @PutMapping(value = "/points/{id}")
    public boolean save(@PathVariable String id) {

        Points points = null;
        points = this.getPointById(id);
        boolean result = false; 

        // 적립 상태면 포인트 적립 진행
        if(points != null && "SAVE".equals(points.getPointStatus())){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            String today =  sdf.format(timestamp);
    
            points.setPointChangeDate(today);
            this.updatePoint(Long.toString(points.getPointId()), "SAVE");

            try {
                points = repository.save(points);
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // 적립 취소    
    @PutMapping(value = "/points/cancel/{id}")
    public Points saveCancel(@PathVariable String id) {
        return this.updatePoint(id, "CANCEL");
    }
    
    // 상태 변경
    @PatchMapping(value = "/points/update/{id}")
    public Points updatePoint(@PathVariable String id, @PathVariable String status) {
        Points points = null;
        List<Points> pointList = repository.findByPointId(Long.parseLong(id));  // orderId 입력해야함!

        for (Points o : pointList) {
            o.setPointStatus(status);

            points = repository.save(o);    // 저장
        }

        return points;
    }

    // 적립 상태 확인
    @GetMapping(value = "/points/{id}")
    public Points getPointById(@PathVariable String id) {
        Points points = null;
        List<Points> pointList = repository.findByOrderId(Long.parseLong(id));  // orderId 입력해야함!

        for (Points o : pointList) {
            points = o;
        }

        return points;
    }

    // 전체 렌트 리스트 확인
    @GetMapping(value = "/points")
    public Iterable<Points> getPointList() {

        Iterable<Points> iter = repository.findAll();

        return iter;
    }
 }
