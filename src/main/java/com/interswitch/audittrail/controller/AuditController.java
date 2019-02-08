package com.interswitch.audittrail.controller;

import com.interswitch.audittrail.domain.AuditTrail;
import com.interswitch.audittrail.dao.AuditRepository;
import com.interswitch.audittrail.domain.CustomMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/audit")
public class AuditController {

    @Autowired
    AuditRepository auditRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @ResponseBody
    public List<?> audit() {
        List<AuditTrail>auditList = auditRepository.findAll();
        return auditList;
    }
}
