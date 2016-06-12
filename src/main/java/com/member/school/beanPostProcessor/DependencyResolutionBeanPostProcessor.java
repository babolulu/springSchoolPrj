package com.member.school.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.member.school.service.StudentService;

@Component
public class DependencyResolutionBeanPostProcessor implements BeanPostProcessor, Ordered{

	private int order;
	
	public DependencyResolutionBeanPostProcessor(){
		System.out.println("Constructed DependencyResolutionBeanPostProcessor instance");
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		if( arg0 instanceof StudentService){
			System.out.println("2. postProcessBeforeInitialization() method invoked Before invocation of initMethod() in " + arg1 + " Class And this is right after invocation of constructor method");
		}
		return arg0;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		if( arg0 instanceof StudentService){
			System.out.println("5. postProcessAfterInitialization() method invoked After invocation of initMethod() in " + arg1 + " Class");
		}
		return arg0;
	}
}
