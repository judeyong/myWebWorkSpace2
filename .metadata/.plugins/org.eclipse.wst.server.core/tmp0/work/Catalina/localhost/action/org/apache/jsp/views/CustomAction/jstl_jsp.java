/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.99
 * Generated at: 2024-04-05 01:08:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.CustomAction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jstl_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	\r\n");
      out.write("	<h1>JSTL이란..?</h1>\r\n");
      out.write("	\r\n");
      out.write("	<P>\r\n");
      out.write("		JSP Standard Tag Library의 약자로 JSP에서 사용할 수 있는 커스텀 액션 태그 <br>\r\n");
      out.write("		공통적으로 사용하는 코드들의 집합을 보다 쉽게 사용할 수 있도록 태그화 해서 제공하는 라이브러리\r\n");
      out.write("	</P>\r\n");
      out.write("	\r\n");
      out.write("	<hr>\r\n");
      out.write("	\r\n");
      out.write("	<h3>* 라이브러리 다운로드 후 추가 방법</h3>\r\n");
      out.write("	1) https://tomcat.apach.org/download-taglibs.cgi 접속 <br>\r\n");
      out.write("	2) Standard-1.2.5 jar파일 4개 다 다운로드 <br> \r\n");
      out.write("	3) WEB-INF/lib폴더에 추가 <br>\r\n");
      out.write("	\r\n");
      out.write("	<h3>* JSTL 선언방법</h3>\r\n");
      out.write("	\r\n");
      out.write("	<p>\r\n");
      out.write("		JSTL을 사용하고자 하는 해당 JSP페이지 상단에 <br>\r\n");
      out.write("		taglib지시어를 사용해서 선언함<br><br>\r\n");
      out.write("		\r\n");
      out.write("		[ 표현법 ]<br>\r\n");
      out.write("		&lt;% taglib prefix=\"접두어\" uri=\"사용하고자 하는 파일상의 uri주소\"%&gt;\r\n");
      out.write("	</p>\r\n");
      out.write("	\r\n");
      out.write("	<hr>\r\n");
      out.write("	\r\n");
      out.write("	<h3>* JSTL 분류</h3>\r\n");
      out.write("	\r\n");
      out.write("	<h4>1. JSTL Core Library</h4>\r\n");
      out.write("	<p>\r\n");
      out.write("		변수와 조건문, 반복문 등의 로직과 관련된 문법을 제공\r\n");
      out.write("	</p>\r\n");
      out.write("	\r\n");
      out.write("	<a href=\"01_core.jsp\">core library</a>\r\n");
      out.write("	\r\n");
      out.write("	<br>\r\n");
      out.write("	<h4>2. JSTL Formatting Library </h4>\r\n");
      out.write("	\r\n");
      out.write("	<p>\r\n");
      out.write("		숫자, 날짜 및 시간데이터의 출력 형식을 지정할 때 사용하는 태그들을 제공\r\n");
      out.write("	</p>\r\n");
      out.write("	\r\n");
      out.write("	<a href=\"02_formatting.jsp\">formatting library</a>\r\n");
      out.write("	\r\n");
      out.write("	<br>\r\n");
      out.write("	\r\n");
      out.write("	<h4>3. JSTL Function Library</h4>\r\n");
      out.write("	\r\n");
      out.write("	<p>\r\n");
      out.write("		EL구문 안에서 사용할 수 있는 메소드들을 제공\r\n");
      out.write("	</p>\r\n");
      out.write("	\r\n");
      out.write("	<a href=\"03_functions.jsp\">function library</a>\r\n");
      out.write("	\r\n");
      out.write("	<br>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
