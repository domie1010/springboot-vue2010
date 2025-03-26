package com.project.demo.controller;

import com.project.demo.entity.PunchInRecord;
import com.project.demo.service.PunchInRecordService;
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
 *打卡记录：(PunchInRecord)表控制层
 *
 */
@RestController
@RequestMapping("/punch_in_record")
public class PunchInRecordController extends BaseController<PunchInRecord,PunchInRecordService> {

    /**
     *打卡记录对象
     */
    @Autowired
    public PunchInRecordController(PunchInRecordService service) {
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
