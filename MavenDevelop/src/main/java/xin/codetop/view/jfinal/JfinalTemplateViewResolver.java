package xin.codetop.view.jfinal;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class JfinalTemplateViewResolver extends UrlBasedViewResolver{
	
	
	public JfinalTemplateViewResolver() {
		setViewClass(requiredViewClass());
	}
	
	@Override
	protected Class<?> requiredViewClass() {
		return JfinalTemplateView.class;
	}
	
	/**
	 * 如果suffix不为空，按照父类来处理
	 * 如果为空，检查viewName是否包含字符"."，如果不包含，默认以".html"作为后缀
	 */
	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		AbstractUrlBasedView view = super.buildView(viewName);
		if(!StringUtils.isEmpty(getSuffix())){
			return view;
		}
		if(viewName.indexOf(".") == -1){
			view.setUrl(getPrefix()+viewName+".html");
		}else {
			view.setUrl(getPrefix()+viewName);
		}
		return view;
	}
}
