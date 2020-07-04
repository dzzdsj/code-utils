package com.dzzdsj.demo.codeutils.HttpDemo.RestTemplateDemo.util.security.crypto.sm.sm4;

/**
 * @author MaJingcao
 * @date 2017/12/27
 * Copyright by syswin
 */
public class SM4Context {

    public int mode;

    public long[] sk;

    public boolean isPadding;

    public SM4Context() {
        this.mode = 1;
        this.isPadding = true;
        this.sk = new long[32];
    }
}
