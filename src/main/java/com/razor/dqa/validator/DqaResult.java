package com.razor.dqa.validator;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import lombok.Data;

@Data
public class DqaResult {

    Normativity normativity = new Normativity();

    Completeness completeness = new Completeness();
    
    Accuracy accuracy = new Accuracy();

    Consistency consistency = new Consistency();

    Timeliness timeliness = new Timeliness();

    Accessibility accessibility = new Accessibility();

    public static DqaResult initResult() {
        DqaResult result = new DqaResult();
        return result;
    }

    @Data
    public static class Normativity {
        
        String name = "规范性";

        AssessmentElement dataStandard = AssessmentElement.of("数据标准");

        AssessmentElement dataModel = AssessmentElement.of("数据模型");

        AssessmentElement metaData = AssessmentElement.of("元数据");

        AssessmentElement businessRule = AssessmentElement.of("业务规则");

        AssessmentElement authoritativeReference = AssessmentElement.of("权威参考数据");

        AssessmentElement safetyRegulation = AssessmentElement.of("安全规范");
    }

    @Data
    public static class Completeness {
        
        String name = "完整性";

        AssessmentElement elementCompleteness = AssessmentElement.of("数据元素完整性");

        AssessmentElement recordCompleteness = AssessmentElement.of("数据记录完整性");

    }

    @Data
    public static class Accuracy {

        String name = "准确性";

        AssessmentElement correctness = AssessmentElement.of("数据内容正确性");

        AssessmentElement formatCompliance = AssessmentElement.of("数据格式合规性");

        AssessmentElement duplicationRate = AssessmentElement.of("数据重复率");

        AssessmentElement uniqueness = AssessmentElement.of("数据唯一性");

        AssessmentElement dirtyDataRate = AssessmentElement.of("脏数据出现率");       

    }

    @Data
    public static class Consistency {

        String name = "一致性";

        AssessmentElement sameData = AssessmentElement.of("相同数据一致性");

        AssessmentElement releventData = AssessmentElement.of("关联数据一致性");

    }

    @Data
    public static class Timeliness {

        String name = "时效性";

        AssessmentElement periodBased = AssessmentElement.of("基于时间段的正确性");

        AssessmentElement timestampBased = AssessmentElement.of("基于时间点的及时性");

        AssessmentElement temporality = AssessmentElement.of("时序性");
    }

    @Data
    public static class Accessibility {
        
        String name = "可访问性";

        AssessmentElement accessibility = AssessmentElement.of("可访问性");

        AssessmentElement availability = AssessmentElement.of("可用性");
    }

    @Data
    public static class AssessmentElement {
        
        String aspectName;

        Map<String, CountAndSample> failures = Maps.newHashMap();

        /**
         * 通过数量
         */
        long b = 0;

        /**
         * 总量
         */
        long a = 0;

        public static AssessmentElement of(String aspectName) {
            AssessmentElement ae = new AssessmentElement();
            ae.setAspectName(aspectName);
            return ae;
        }

        public AssessmentElement pass() {
            a++;
            b++;
            return this;
        }

        public AssessmentElement fail(String target, Object value) {
            a++;
            if (target == null) return this;
            if (!failures.containsKey(target)) {
                failures.put(target, new CountAndSample());
            }
            failures.get(target).rec(String.valueOf(value));
            return this;
        }
    }

    @Data
    public static class CountAndSample {

        private static final int SAMPLE_MAX_SIZE = 10;

        int count = 0;

        Set<String> sample = Sets.newHashSet();

        public void rec(String value) {
            count++;
            if (sample.size() < SAMPLE_MAX_SIZE) {
                sample.add(value);
            }
        }
    }
}
