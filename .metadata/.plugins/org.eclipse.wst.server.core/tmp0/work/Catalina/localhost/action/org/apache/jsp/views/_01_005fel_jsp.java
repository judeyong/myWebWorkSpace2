/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.99
 * Generated at: 2024-04-03 01:48:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.model.vo.Person;

public final class _01_005fel_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.LinkedHashSet<>(1);
    _jspx_imports_classes.add("com.kh.model.vo.Person");
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
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>EL 기본구문</h1>\r\n");
      out.write("	<h3>1. 기존 방식대로 스크립틀릿과 표현식을 이용해서 각 영역에 담겨있는 값을 뽑아서 화면에 출력</h3>\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("	<hr>\r\n");
      out.write("	\r\n");
      out.write("	<h3>2. EL을 이용해서 request/session Scope에 담긴 값들을 출력</h3>\r\n");
      out.write("	\r\n");
      out.write("	<p>\r\n");
      out.write("		학원명 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ academy }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("  <br> \r\n");
      out.write("		강의장 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ classRoom }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" <br>\r\n");
      out.write("		강사정보 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ lecture.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(',');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ lecture.age }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(',');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ lecture.address }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<br>\r\n");
      out.write("		\r\n");
      out.write("		<!-- \r\n");
      out.write("			필드값에 직접접근 X\r\n");
      out.write("			name -> getName()\r\n");
      out.write("			내부적으로 getter메소드를 찾아서 호출해서 값을 출력해주는 구조\r\n");
      out.write("			=> 항상 명심해야할 사항 : getter메소드를 꼭 만들어야함\r\n");
      out.write("			\r\n");
      out.write("			lecture에 접근했을 때 value값은 Person타입 객체\r\n");
      out.write("			해당 Person각체의 각 필드에 담긴 값을 출력하고자 한다면 키값, 필드명으로 접근하면 됨(눈에 보이는 코드상)\r\n");
      out.write("			\r\n");
      out.write("			=> 해당 필드에 네이밍컨벤션에 부합하는 getter를 찾아서 호출해주는 구조\r\n");
      out.write("			\r\n");
      out.write("		 -->\r\n");
      out.write("		\r\n");
      out.write("		수강생정보 <br>\r\n");
      out.write("		<ul>\r\n");
      out.write("			<li>이름: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ student.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</li>\r\n");
      out.write("			<li>나이: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ student.age }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</li>\r\n");
      out.write("			<li>주소: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ student.address }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</li>\r\n");
      out.write("		</ul> \r\n");
      out.write("	</p>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<h4>여러분들이 많이 한 실수</h4>\r\n");
      out.write("	\r\n");
      out.write("	<p>없는 키값을 통해 출력한 경우</p>\r\n");
      out.write("	<p>출력식을 이용한 출력 : &lt;%= num %&gt;</p>\r\n");
      out.write("	<p>EL구문을 이용해서 없는 키값을 제시하는 경우 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ abcd }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p> <!-- 아무것도 출력 안됨 -->\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<h3>3. EL 사용시 객체들의 저장된 키값이 동일한 경우</h3>\r\n");
      out.write("	\r\n");
      out.write("	scope키값에 담긴 밸류 값: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ scope }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" <br>\r\n");
      out.write("	\r\n");
      out.write("	<!-- \r\n");
      out.write("		EL구문은 공유범위가 가장 작은 scope에서부터 해당 키값을 검색함\r\n");
      out.write("		page => request => session => application순으로 키값을 찾음\r\n");
      out.write("		\r\n");
      out.write("		만약에 모든 영역에서 해당 키에 담긴 값을 못찾았다?\r\n");
      out.write("		출력안됨\r\n");
      out.write("		오류가 안남\r\n");
      out.write("	 -->\r\n");
      out.write("	\r\n");
      out.write("	<h3>4. 직접 Scope영역을 지정해서 접근하기</h3>\r\n");
      out.write("	");

		// pageScope에 담기
		pageContext.setAttribute("scope", "page");
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	Quiz. ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ scope }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 를 작성하면 무슨값이 나올까요? => page <br><br>\r\n");
      out.write("	\r\n");
      out.write("	pageScope에 담긴 \"scope\"도 출력하고 싶고, requestScope, sessionScope, applicationScope에 있는 \"scope\"를 다 출력하고 싶음 <br>\r\n");
      out.write("	\r\n");
      out.write("	pageScope에 담긴 값 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ scope }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 또는 ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageScope.scope }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" <br>\r\n");
      out.write("	requestScope에 담긴 값 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ requestScope.scope }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" <br>\r\n");
      out.write("	sessionScope에 담긴 값 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ sessionScope.scope }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" <br>\r\n");
      out.write("	applicationScope에 담긴 값 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ applicationScope.scope }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" <br>\r\n");
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