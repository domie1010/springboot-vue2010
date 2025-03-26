package com.project.demo.controller;

import com.project.demo.entity.EmploymentResults;
import com.project.demo.service.EmploymentResultsService;
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
 *录用结果：(EmploymentResults)表控制层
 *
 */
@RestController
@RequestMapping("/employment_results")
public class EmploymentResultsController extends BaseController<EmploymentResults,EmploymentResultsService> {

    /**
     *录用结果对象
     */
    @Autowired
    public EmploymentResultsController(EmploymentResultsService service) {
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
