package com.project.demo.controller;

import com.project.demo.entity.SalaryInformation;
import com.project.demo.service.SalaryInformationService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *薪资信息：(SalaryInformation)表控制层
 *
 */
@RestController
@RequestMapping("/salary_information")
public class SalaryInformationController extends BaseController<SalaryInformation,SalaryInformationService> {

    /**
     *薪资信息对象
     */
    @Autowired
    public SalaryInformationController(SalaryInformationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
