package com.razor.dqa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razor.dqa.mapper.sxjt.TrafficCarRecordMapper;
import com.razor.dqa.mapper.sxjt.TrafficMemberCardMapper;
import com.razor.dqa.mapper.sxjt.TrafficMemberCardPayRecordMapper;
import com.razor.dqa.mapper.sxjt.TrafficOrderOverdueRecordMapper;
import com.razor.dqa.mapper.sxjt.TrafficOrderRecordMapper;
import com.razor.dqa.mapper.sxjt.TrafficParkingMapper;
import com.razor.dqa.mapper.sxjt.TrafficParkingSpacePayRecordMapper;
import com.razor.dqa.model.sxjt.TrafficMemberCard;
import com.razor.dqa.service.SxjtDqaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SxjtDqaServiceImpl implements SxjtDqaService {

    
    @Autowired
    private TrafficCarRecordMapper trafficCarRecordMapper;

    @Autowired
    private TrafficMemberCardMapper trafficMemberCardMapper;

    @Autowired
    private TrafficMemberCardPayRecordMapper trafficMemberCardPayRecordMapper;

    @Autowired
    private TrafficOrderOverdueRecordMapper trafficOrderOverdueRecordMapper;

    @Autowired
    private TrafficOrderRecordMapper trafficOrderRecordMapper;

    @Autowired
    private TrafficParkingMapper trafficParkingMapper;

    @Autowired
    private TrafficParkingSpacePayRecordMapper trafficParkingSpacePayRecordMapper;

    @Override
    public void assessData() {
        // TODO Auto-generated method stub

        throw new UnsupportedOperationException("Unimplemented method 'assessData'");
    }

}
