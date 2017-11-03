package xin.codetop.handler;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Class<?> obj = handlerMethod.getBeanType();
		Annotation[] beanAnnotations = obj.getAnnotations();
		//controller注解，RestController 不会通过视图去渲染页面
		for (Annotation annotation : beanAnnotations) {
			if (annotation instanceof RestController) {
				break;
			}
		}
		Annotation[] methodAnnotations = handlerMethod.getMethod().getAnnotations();
		//ResponseBody 不会通过视图去渲染页面
		for (Annotation annotation : methodAnnotations) {
			if (annotation instanceof ResponseBody) {
				break;
			}
		}
		return null;
	}

}
