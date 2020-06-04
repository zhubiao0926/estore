package com.briup.web.listener;



import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.bean.Category;
import com.briup.bean.CategoryDetail;
import com.briup.bean.Product;
import com.briup.bean.Report;
import com.briup.common.exception.ReportException;
import com.briup.dao.impl.CategoryDetailDaoImpl;
import com.briup.service.impl.CategoryDetailServiceImpl;
import com.briup.service.impl.ProductServiceImpl;
import com.briup.service.impl.ReportServoceImpl;



/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

  /*
   * application对象销毁的时候调用
   */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
    /*
     * application对象创建时调用
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
    		 //1、获取application对象
        	ServletContext app = sce.getServletContext();
        	// 2、获取所有的书籍信息
        	    //调用service层的业务逻辑方法
        	ProductServiceImpl productServiceImpl = new ProductServiceImpl();
        	List<Product> allProduct = productServiceImpl.listAllProduct();
        	// 获取所有的分类信息
        	CategoryDetailServiceImpl detailServiceImpl = new CategoryDetailServiceImpl();
        	Map<Category, List<CategoryDetail>> map = detailServiceImpl.listCategoryDetail();
        	// 获取所有的快报信息
        	ReportServoceImpl reportServoceImpl = new ReportServoceImpl();
			List<Report> report = reportServoceImpl.listReport();
			// 将以上信息保存到application对象中
			app.setAttribute("allProducts", allProduct);
			app.setAttribute("cateDets", map);
			app.setAttribute("reports", report);
		} catch (ReportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
}
