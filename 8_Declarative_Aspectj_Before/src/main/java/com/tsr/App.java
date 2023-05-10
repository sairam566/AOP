package com.tsr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tsr.beans.AuthenticationManager;
import com.tsr.beans.LoanManager;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/tsr/config/application-context.xml");
        
        LoanManager loanManager = context.getBean("loanManager",LoanManager.class);
        
        AuthenticationManager authenticationManager = context.getBean("authentication",AuthenticationManager.class);
        
        authenticationManager.login("sai","TSR");
        
        loanManager.approve(1222);
    }
}
