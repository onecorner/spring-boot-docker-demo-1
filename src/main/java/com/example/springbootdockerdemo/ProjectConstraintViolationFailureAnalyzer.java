package com.example.springbootdockerdemo;

import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;
import org.springframework.stereotype.Component;

/**
 * @author htj
 * @since 2019/8/30 13:21
 */
@Component
public class ProjectConstraintViolationFailureAnalyzer implements FailureAnalyzer {
    @Override
    public FailureAnalysis analyze(Throwable failure) {
        System.out.println(failure.getCause()+"-------------------------->");
        return null;
    }
}
