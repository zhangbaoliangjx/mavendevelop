package xin.codetop.view.jfinal;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractUrlBasedView;

import com.jfinal.kit.PathKit;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.jfinal.template.stat.ParseException;

public class JfinalTemplateView extends AbstractUrlBasedView{
	
	private static final Engine engine = new Engine("Spring MVC JFinal Web");
	
	static {
		engine.setBaseTemplatePath(PathKit.getWebRootPath());
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		exposeModelAsRequestAttributes(model, request);
		if (logger.isDebugEnabled()) {
			logger.debug("Rendering JFinal template [" + getUrl() + "] in JFinalTemplateView '" + getBeanName() + "'");
		}
		Template template = engine.getTemplate(getUrl());
		template.render(model, response.getWriter());
	}
	
	@Override
	public boolean checkResource(Locale locale){
		try {
			engine.getTemplate(getUrl());
			return true;
		}catch (ParseException ex) {
			if (logger.isDebugEnabled()) {
				logger.debug("Failed to parse FreeMarker template for URL [" +  getUrl() + "]");
			}
			return false;
		}
	}
	
}
