package com.razor.dqa.service.impl;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razor.dqa.mapper.ApplyEmergencyContactMapper;
import com.razor.dqa.mapper.ApplyEnterpriseInfoMapper;
import com.razor.dqa.mapper.ApplyGuaranteeInfoMapper;
import com.razor.dqa.mapper.ApplyRecordAuditMapper;
import com.razor.dqa.mapper.ApplyRecordMapper;
import com.razor.dqa.mapper.ApplyUserInfoMapper;
import com.razor.dqa.mapper.ApplyUserSpouseFeedbackMapper;
import com.razor.dqa.mapper.ApplyUserSpouseInfoMapper;
import com.razor.dqa.model.ApplyEmergencyContact;
import com.razor.dqa.model.ApplyEnterpriseInfo;
import com.razor.dqa.model.ApplyGuaranteeInfo;
import com.razor.dqa.model.ApplyRecord;
import com.razor.dqa.model.ApplyRecordAudit;
import com.razor.dqa.model.ApplyUserInfo;
import com.razor.dqa.model.ApplyUserSpouseFeedback;
import com.razor.dqa.model.ApplyUserSpouseInfo;
import com.razor.dqa.service.DataQualityAssessService;
import com.razor.dqa.validator.AnnotationBasedValidator;
import com.razor.dqa.validator.DqaResult;
import com.razor.dqa.validator.DqaValidator;
import com.razor.dqa.validator.fields.ValidateType;
import com.razor.dqa.validator.helper.ConsistencyHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DataQualityAssessServiceImpl implements DataQualityAssessService {

    private static int STEP = 100;

    @Autowired
    ApplyRecordMapper applyRecordMapper;

    @Autowired
    ApplyUserInfoMapper applyUserInfoMapper;

    @Autowired
    ApplyUserSpouseInfoMapper applyUserSpouseInfoMapper;

    @Autowired
    ApplyUserSpouseFeedbackMapper applyUserSpouseFeedbackMapper;

    @Autowired
    ApplyEmergencyContactMapper applyEmergencyContactMapper;

    @Autowired
    ApplyEnterpriseInfoMapper applyEnterpriseInfoMapper;

    @Autowired
    ApplyGuaranteeInfoMapper applyGuaranteeInfoMapper;

    @Autowired
    ApplyRecordAuditMapper applyRecordAuditMapper;

    @Autowired
    ConsistencyHelper consistencyHelper;

    @Override
    public void assessData() {

        DqaValidator validator = AnnotationBasedValidator.createWithValidateType(ValidateType.values());

        
        long applyRecordCount = applyRecordMapper.selectAllCount();
        log.info("=====apply_record(" + applyRecordCount + ")评估开始======");
        DqaResult result = DqaResult.initResult();
        for (int i = 0; i < applyRecordCount; i += STEP) {
            List<ApplyRecord> rows = applyRecordMapper.selectListByRowBounds(new RowBounds(i, STEP));
            if (rows != null && !rows.isEmpty()) {
                for (ApplyRecord row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====apply_record评估结束======");

        
        long applyUserInfoCount = applyUserSpouseInfoMapper.selectAllCount();
        log.info("=====apply_user_info(" + applyUserInfoCount + ")评估开始======");
        for (int i = 0; i < applyUserInfoCount; i += STEP) {
            List<ApplyUserInfo> rows = applyUserInfoMapper.selectListByRowBounds(new RowBounds(i, STEP));
            if (rows != null && !rows.isEmpty()) {
                for (ApplyUserInfo row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====apply_user_info评估结束======");

        
        long applyUserSpouseInfoCount = applyUserSpouseInfoMapper.selectAllCount();
        log.info("=====apply_user_spouse_info(" + applyUserSpouseInfoCount + ")评估开始======");
        for (int i = 0; i < applyUserSpouseInfoCount; i += STEP) {
            List<ApplyUserSpouseInfo> rows = applyUserSpouseInfoMapper.selectListByRowBounds(new RowBounds(i, STEP));
            if (rows != null && !rows.isEmpty()) {
                for (ApplyUserSpouseInfo row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====applyUserSpouseInfo评估结束======");

        
        long applyUserSpouseFeedbackCount = applyUserSpouseFeedbackMapper.selectAllCount();
        log.info("=====apply_user_spouse_feedback(" + applyUserSpouseFeedbackCount + ")评估开始======");
        for (int i = 0; i < applyUserSpouseFeedbackCount; i += STEP) {
            List<ApplyUserSpouseFeedback> rows = applyUserSpouseFeedbackMapper.selectListByRowBounds(new RowBounds(i, STEP));
            if (rows != null && !rows.isEmpty()) {
                for (ApplyUserSpouseFeedback row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====apply_user_spouse_feedback评估结束======");

        
        long applyEnterpriseInfoCount = applyEnterpriseInfoMapper.selectAllCount();
        log.info("=====apply_enterprise_info(" + applyEnterpriseInfoCount + ")评估开始======");

        for (int i = 0; i < applyEnterpriseInfoCount; i += STEP) {
            List<ApplyEnterpriseInfo> rows = applyEnterpriseInfoMapper.selectListByRowBounds(new RowBounds(i, STEP));
            if (rows != null && !rows.isEmpty()) {
                for (ApplyEnterpriseInfo row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====apply_enterprise_info评估结束======");
        
        long applyGuaranteeInfoCount = applyGuaranteeInfoMapper.selectAllCount();
        log.info("=====apply_guarantee_info(" + applyGuaranteeInfoCount + ")评估开始======");

        for (int i = 0; i < applyGuaranteeInfoCount; i += STEP) {
            List<ApplyGuaranteeInfo> rows = applyGuaranteeInfoMapper.selectListByRowBounds(new RowBounds(i, STEP));
            if (rows != null && !rows.isEmpty()) {
                for (ApplyGuaranteeInfo row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====apply_guarantee_info评估结束======");

        long applyEmergencyContactCount = applyEmergencyContactMapper.selectAllCount();
        log.info("=====apply_emergency_contact(" + applyEmergencyContactCount + ")评估开始======");

        for (int i = 0; i < applyEmergencyContactCount; i += STEP) {
            List<ApplyEmergencyContact> rows = applyEmergencyContactMapper.selectListByRowBounds(new RowBounds(i, STEP));
            if (rows != null && !rows.isEmpty()) {
                for (ApplyEmergencyContact row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====apply_emergency_contact评估结束======");


        long applyRecordAuditCount = applyRecordAuditMapper.selectAllCount();
        log.info("=====apply_record_audit(" + applyRecordAuditCount + ")评估开始======");

        for (int i = 0; i < applyRecordAuditCount; i += STEP) {
            List<ApplyRecordAudit> rows = applyRecordAuditMapper.selectListByRowBounds(new RowBounds(i, STEP));
            if (rows != null && !rows.isEmpty()) {
                for (ApplyRecordAudit row : rows) {
                    try {
                        validator.validate(row, result);
                    } catch (RuntimeException e) {
                        log.error("校验出错 " + row, e);
                    }
                }
            }
        }
        log.info("=====apply_record_audit评估结束======");

        log.info(ToStringBuilder.reflectionToString(result, ToStringStyle.MULTI_LINE_STYLE));
        
    }

}
