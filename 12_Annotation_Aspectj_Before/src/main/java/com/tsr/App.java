package com.tsr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tsr.beans.LoanManager;
import com.tsr.config.ABJavaConfig;
import com.tsr.helper.AuthenticationManager;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ABJavaConfig.class);
        
        AuthenticationManager authenticationManager = context.getBean("authenticationManager",AuthenticationManager.class);
        
        authenticationManager.login("sai","ram");
        
        LoanManager loanManager = context.getBean("loanManager",LoanManager.class);
        
        boolean loanStatus = loanManager.approveLoan(12);
        
        System.out.println("Loan Status is : "+loanStatus);
    }
}
