package SecondSpring.core.beanfind;

import SecondSpring.core.discount.DiscountPolicy;
import SecondSpring.core.discount.FixDiscountPolicy;
import SecondSpring.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시, 저삭아 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByParentTypeDuplicate() {
//        ac.getBean(DiscountPolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy FixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
