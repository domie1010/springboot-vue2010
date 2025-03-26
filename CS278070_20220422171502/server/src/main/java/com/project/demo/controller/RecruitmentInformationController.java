package com.project.demo.controller;

import com.project.demo.entity.RecruitmentInformation;
import com.project.demo.service.RecruitmentInformationService;
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
 *招聘信息：(RecruitmentInformation)表控制层
 *
 */
@RestController
@RequestMapping("/recruitment_information")
public class RecruitmentInformationController extends BaseController<RecruitmentInformation,RecruitmentInformationService> {

    /**
     *招聘信息对象
     */
    @Autowired
    public RecruitmentInformationController(RecruitmentInformationService service) {
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
