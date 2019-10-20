package com.nrsc.elegant;

import com.nrsc.elegant.util.ResultVOUtil;
import com.nrsc.elegant.vo.ResultVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ElegantApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElegantApplication.class, args);
    }

    @GetMapping("/ping")
    public ResultVO<String> ping() {
        return ResultVOUtil.success("pong");
    }

}
