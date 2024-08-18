package com.razor.dqa.service.impl;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razor.dqa.mapper.BaseMapper;
import com.razor.dqa.mapper.sxjt.TrafficCarRecordMapper;
import com.razor.dqa.mapper.sxjt.TrafficMemberCardMapper;
import com.razor.dqa.mapper.sxjt.TrafficMemberCardPayRecordMapper;
import com.razor.dqa.mapper.sxjt.TrafficOrderOverdueRecordMapper;
import com.razor.dqa.mapper.sxjt.TrafficOrderRecordMapper;
import com.razor.dqa.mapper.sxjt.TrafficParkingMapper;
import com.razor.dqa.mapper.sxjt.TrafficParkingSpacePayRecordMapper;
import com.razor.dqa.model.ApplyRecord;
import com.razor.dqa.model.ApplyUserInfo;
import com.razor.dqa.model.ApplyUserSpouseInfo;
import com.razor.dqa.model.sxjt.TrafficCarRecord;
import com.razor.dqa.model.sxjt.TrafficMemberCard;
import com.razor.dqa.model.sxjt.TrafficMemberCardPayRecord;
import com.razor.dqa.model.sxjt.TrafficOrderOverdueRecord;
import com.razor.dqa.model.sxjt.TrafficOrderRecord;
import com.razor.dqa.model.sxjt.TrafficParking;
import com.razor.dqa.model.sxjt.TrafficParkingSpacePayRecord;
import com.razor.dqa.service.SxjtDqaService;
import com.razor.dqa.validator.AnnotationBasedValidator;
import com.razor.dqa.validator.DqaResult;
import com.razor.dqa.validator.DqaValidator;
import com.razor.dqa.validator.fields.ValidateType;
import com.razor.dqa.validator.helper.ConsistencyHelper;
import com.razor.dqa.validator.helper.SpringContextHolder;

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
        DqaValidator validator = AnnotationBasedValidator.createWithValidateType(ValidateType.values());

        // 先处理TrafficParking
        long trafficParkingCount = trafficParkingMapper.selectAllCount();
        log.info("=====TrafficParking(" + trafficParkingCount + ")评估开始======");
        DqaResult result = DqaResult.initResult();
        for (int i = 0; i < trafficParkingCount; i += BaseMapper.STEP) {
            List<TrafficParking> rows = trafficParkingMapper.selectListByRowBounds(new RowBounds(i, BaseMapper.STEP));
            if (rows != null && !rows.isEmpty()) {
                for (TrafficParking row : rows) {
                    try {
                        // 缓存TrafficParking
                        // TODO 后续提炼到validate的pre里面
                        ConsistencyHelper consistencyHelper = SpringContextHolder.getBean(ConsistencyHelper.class);
                        consistencyHelper.put("TrafficParking.parkingCode", row.getParkingCode());
                        consistencyHelper.put("TrafficParking.parkingName", row.getParkingName());
                        
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====TrafficParking评估结束======");

        long trafficCarRecordCount = trafficCarRecordMapper.selectAllCount();
        log.info("=====TrafficCarRecord(" + trafficCarRecordCount + ")评估开始======");
        for (int i = 0; i < trafficCarRecordCount; i += BaseMapper.STEP) {
            List<TrafficCarRecord> rows = trafficCarRecordMapper.selectListByRowBounds(new RowBounds(i, BaseMapper.STEP));
            if (rows != null && !rows.isEmpty()) {
                for (TrafficCarRecord row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====TrafficCarRecord评估结束======");

        long trafficMemberCardCount = trafficMemberCardMapper.selectAllCount();
        log.info("=====TrafficMemberCard(" + trafficMemberCardCount + ")评估开始======");
        for (int i = 0; i < trafficMemberCardCount; i += BaseMapper.STEP) {
            List<TrafficMemberCard> rows = trafficMemberCardMapper.selectListByRowBounds(new RowBounds(i, BaseMapper.STEP));
            if (rows != null && !rows.isEmpty()) {
                for (TrafficMemberCard row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====TrafficMemberCard评估结束======");

        long trafficMemberCardPayRecordCount = trafficMemberCardPayRecordMapper.selectAllCount();
        log.info("=====TrafficMemberCardPayRecord(" + trafficMemberCardPayRecordCount + ")评估开始======");
        for (int i = 0; i < trafficMemberCardPayRecordCount; i += BaseMapper.STEP) {
            List<TrafficMemberCardPayRecord> rows = trafficMemberCardPayRecordMapper.selectListByRowBounds(new RowBounds(i, BaseMapper.STEP));
            if (rows != null && !rows.isEmpty()) {
                for (TrafficMemberCardPayRecord row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====TrafficMemberCardPayRecord评估结束======");

        long trafficOrderOverdueRecordCount = trafficOrderOverdueRecordMapper.selectAllCount();
        log.info("=====TrafficOrderOverdueRecord(" + trafficOrderOverdueRecordCount + ")评估开始======");
        for (int i = 0; i < trafficOrderOverdueRecordCount; i += BaseMapper.STEP) {
            List<TrafficOrderOverdueRecord> rows = trafficOrderOverdueRecordMapper.selectListByRowBounds(new RowBounds(i, BaseMapper.STEP));
            if (rows != null && !rows.isEmpty()) {
                for (TrafficOrderOverdueRecord row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====TrafficOrderOverdueRecord评估结束======");

        long trafficOrderRecordCount = trafficOrderRecordMapper.selectAllCount();
        log.info("=====TrafficOrderRecord(" + trafficOrderRecordCount + ")评估开始======");
        for (int i = 0; i < trafficOrderRecordCount; i += BaseMapper.STEP) {
            List<TrafficOrderRecord> rows = trafficOrderRecordMapper.selectListByRowBounds(new RowBounds(i, BaseMapper.STEP));
            if (rows != null && !rows.isEmpty()) {
                for (TrafficOrderRecord row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====TrafficOrderRecord评估结束======");

        long trafficParkingSpacePayRecordCount = trafficParkingSpacePayRecordMapper.selectAllCount();
        log.info("=====TrafficParkingSpacePayRecord(" + trafficParkingSpacePayRecordCount + ")评估开始======");
        for (int i = 0; i < trafficParkingSpacePayRecordCount; i += BaseMapper.STEP) {
            List<TrafficParkingSpacePayRecord> rows = trafficParkingSpacePayRecordMapper.selectListByRowBounds(new RowBounds(i, BaseMapper.STEP));
            if (rows != null && !rows.isEmpty()) {
                for (TrafficParkingSpacePayRecord row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====TrafficParkingSpacePayRecord评估结束======");

        log.info(ToStringBuilder.reflectionToString(result, ToStringStyle.MULTI_LINE_STYLE));
    }

}
