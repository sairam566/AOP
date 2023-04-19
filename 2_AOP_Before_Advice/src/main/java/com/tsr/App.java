package com.tsr;

import org.springframework.aop.framework.ProxyFactory;

import com.tsr.audit.AuditAdvice;
import com.tsr.audit.LoanManger;

public class App 
{
    public static void main( String[] args )
    {
       ProxyFactory pf = new ProxyFactory();
       
       pf.setTarget(new LoanManger());
       pf.addAdvice(new AuditAdvice());
       
       LoanManger manager = (LoanManger) pf.getProxy();
       manager.approveLoan(20L);
    }
}
