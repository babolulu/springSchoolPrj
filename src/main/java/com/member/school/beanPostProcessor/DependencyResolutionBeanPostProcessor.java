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
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		if( arg0 instanceof StudentService){
			System.out.println("5 나는 StudentService 빈, init 메소드 수행 후 입니다.  postProcessAfterInitialization" + arg1);
		}
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		if( arg0 instanceof StudentService){
			System.out.println("5 나는 StudentService 빈, 초기화 전 입니다.  postProcessBeforeInitialization" + arg1);
		}
		return arg0;
	}

}
