package com.project.demo.controller;

import com.project.demo.entity.RewardAndPunishmentInformation;
import com.project.demo.service.RewardAndPunishmentInformationService;
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
 *奖惩信息：(RewardAndPunishmentInformation)表控制层
 *
 */
@RestController
@RequestMapping("/reward_and_punishment_information")
public class RewardAndPunishmentInformationController extends BaseController<RewardAndPunishmentInformation,RewardAndPunishmentInformationService> {

    /**
     *奖惩信息对象
     */
    @Autowired
    public RewardAndPunishmentInformationController(RewardAndPunishmentInformationService service) {
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
