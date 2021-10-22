package hello.JuDang.JUDANG.Controller.Map;

import hello.JuDang.JUDANG.Controller.ControllerDomain.coordinateForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//
//@Slf4j
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/map")
//class MapController {
//
//    @GetMapping
//    public String goMap(){
//        return "Map/Map";
//    }
//
//    @PostMapping("/mylocation")
//    @ResponseBody
//    public String myLocation(coordinateForm coordinateForm){
//        log.info("위도 = {} 경도 = {}",coordinateForm.getLatitude(),coordinateForm.getLongitude());
//        return "ok";
//    }
//}
