package com.nb.beans.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class IsDevProfile implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment env = conditionContext.getEnvironment();
        String activeProfile = env.getProperty("active.profile");
        if("dev".equalsIgnoreCase(activeProfile))
            return true;
        return false;
    }
}
