package com.dzzdsj.demo.codeutils.DesignPattern.CompositePattern;

/**
 * 自定义异常类，表示向文件中添加文件时的错误
 */
public class FileTreatmentException extends RuntimeException {
    public FileTreatmentException() {
    }

    public FileTreatmentException(String message) {
        super(message);
    }
}
