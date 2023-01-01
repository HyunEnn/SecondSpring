package SecondSpring.core.web;

import SecondSpring.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Provider;

@Service
@RequiredArgsConstructor // 자동으로 생성자 만들어줌
public class LogDemoService {

    private final ObjectProvider<MyLogger> myLoggerProvider;
    public void logic(String id) {
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
