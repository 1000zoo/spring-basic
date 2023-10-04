package zoo.springbasic.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zoo.springbasic.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("serviceId = " + id);
    }
}
