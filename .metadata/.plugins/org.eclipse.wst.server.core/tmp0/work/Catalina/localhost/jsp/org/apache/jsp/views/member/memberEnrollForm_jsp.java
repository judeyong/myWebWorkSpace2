/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.99
 * Generated at: 2024-03-21 02:45:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.jsp.member.model.vo.Member;

public final class memberEnrollForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/member/../common/menubar.jsp", Long.valueOf(1710746254758L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(1);
    _jspx_imports_classes.add("com.kh.jsp.member.model.vo.Member");
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
      out.write("<style>\r\n");
      out.write("	#enroll-form input{\r\n");
      out.write("		margin: 8px;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");
 Member loginUser=(Member)session.getAttribute("loginUser");
	// 로그인 전 : menubar.jsp가 로딩될 때 null
	// 로그인 성공 후 :menubar.jsp가 로딩될 때 필드에 회원의 정보가 담겨있는 Member객체의 주소값  
	
	String contextPath = request.getContextPath();
	String alertMsg = (String)session.getAttribute("alertMsg");
	// System.out.println(alertMsg);
	// 로그인 성공 전 : alerMsg == null
	// 로그인 성공 후 : alerMsg == 메시지문구 
	
 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>헤더</title>\r\n");
      out.write("	\r\n");
      out.write("	<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script>\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\r\n");
      out.write("	<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("	\r\n");
      out.write("    <style>\r\n");
      out.write("        .login-area {\r\n");
      out.write("            float: right;\r\n");
      out.write("        }\r\n");
      out.write("		.menu{\r\n");
      out.write("			width: 200px;\r\n");
      out.write("			height: 50px;\r\n");
      out.write("			display: table-cell;\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		.menu > a {\r\n");
      out.write("			display: block;\r\n");
      out.write("			width: 100%;\r\n");
      out.write("			height: 100%;\r\n");
      out.write("			text-decoration: none;\r\n");
      out.write("			color: black;\r\n");
      out.write("			font-weight: bold;\r\n");
      out.write("			font-size: 20px;\r\n");
      out.write("			line-height: 50px;\r\n");
      out.write("		}\r\n");
      out.write("		.menu > a:hover{\r\n");
      out.write("			font-size: 21px;\r\n");
      out.write("			background-color: lightslategray;\r\n");
      out.write("		}\r\n");
      out.write("		.outer{\r\n");
      out.write("			width: 1200px;\r\n");
      out.write("			height: auto;\r\n");
      out.write("			margin: auto;\r\n");
      out.write("			border: 1px solid lightpink;\r\n");
      out.write("			padding-top: 15px;\r\n");
      out.write("			padding-bottom: 15px;\r\n");
      out.write("			margin-top: 10px;\r\n");
      out.write("		}\r\n");
      out.write("    </style>\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<script>\r\n");
      out.write("		// script태그 안에서도 스크립틀릿 같은 JSP요소를 사용할 수 있음	\r\n");
      out.write("		\r\n");
      out.write("		const msg = '");
      out.print( alertMsg );
      out.write("';\r\n");
      out.write("		\r\n");
      out.write("		if(msg != 'null'){\r\n");
      out.write("			alert(msg);\r\n");
      out.write("			\r\n");
      out.write("			// menubar.jsp가 로딩 될 때 마다 alert이 계속 수행됨\r\n");
      out.write("			// session에 들어있는 alrertMsg키값에 해당하는 밸류값을 지워줄 것!\r\n");
      out.write("			// xx.removeAttribute(\"키값\");\r\n");
      out.write("			");
 session.removeAttribute("alertMsg"); 
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("	</script>\r\n");
      out.write("	\r\n");
      out.write("    <h1 align=\"center\">대답을 잘하자</h1>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"login-area\">\r\n");
      out.write("\r\n");
      out.write("        <!-- 사용자가 로그인 전 보게 될 화면(아이디 입력란 / 비밀번호 입력란 / 로그인버튼 / 회원가입)\r\n");
      out.write("\r\n");
      out.write("        <!-- \r\n");
      out.write("    	=> http://localhost:7777/jsp/서블릿매핑값\r\n");
      out.write("\r\n");
      out.write("    	form태그 내부에 존재하는 제출버튼(submit)클릭 시 form태그가 가지고 있는 속성 중\r\n");
      out.write("    	action속성에 작성된 url로 요청을 보내게됨(제출)\r\n");
      out.write("\r\n");
      out.write("    	==> Controller(Servlet)을 호출한다고 생각하면 됨\r\n");
      out.write("\r\n");
      out.write("    	* 경로 지정 방식\r\n");
      out.write("    	절대 경로 방식(/) : /Context Root/요청할 url	\r\n");
      out.write("                        localhost:포트번호 뒤에 action속성에 작성한 값이 붙으면서 요청\r\n");
      out.write("\r\n");
      out.write("    	상대 경로 방식(요청할url) :/없이 요청할 url문구로 시작하는 경우\r\n");
      out.write("                                            현재 이 페이지에 보여지는 url경로 중에서\r\n");
      out.write("                                            마지막 / 로부터 뒤에 action속성의 값이 붙으면서 요청\r\n");
      out.write("		-->\r\n");
      out.write("		\r\n");
      out.write("		");
if(loginUser == null) {
      out.write("\r\n");
      out.write("		<!-- <form action=\"/login\" method=\"post\"> -->\r\n");
      out.write("		<form action=\"");
      out.print(contextPath);
      out.write("/login\" method=\"post\">\r\n");
      out.write("		    <table>\r\n");
      out.write("		        <tr>\r\n");
      out.write("		            <th>아이디</th>\r\n");
      out.write("		            <td><input type=\"text\" name=\"userId\" required></td>\r\n");
      out.write("		        </tr>\r\n");
      out.write("		        <tr>\r\n");
      out.write("		            <th>비밀번호</th>\r\n");
      out.write("		            <td><input type=\"password\" name=\"userPwd\" required></td>\r\n");
      out.write("		        </tr>\r\n");
      out.write("		        <tr>\r\n");
      out.write("		            <th colspan=\"2\">\r\n");
      out.write("		                <button type=\"submit\" class=\"btn btn-sm btn-primary\">로그인</button>\r\n");
      out.write("		                <button type=\"button\" class=\"btn btn-sm btn-secondary\" onclick=\"enrollPage();\">회원가입</button>\r\n");
      out.write("		            </th>\r\n");
      out.write("		        </tr>\r\n");
      out.write("		    </table>\r\n");
      out.write("		</form>\r\n");
      out.write("		<script>\r\n");
      out.write("			function enrollPage() {\r\n");
      out.write("				// 페이지 이동\r\n");
      out.write("				// localhost:7777/jsp/views/member/memberEnrollForm.jsp\r\n");
      out.write("				// location.href = '");
      out.print(contextPath);
      out.write("/views/member/memberEnrollForm.jsp';\r\n");
      out.write("				// 프로젝트의 디렉토리 구조가 url에 노출됨 => 보안에 취약\r\n");
      out.write("				\r\n");
      out.write("				location.href = '");
      out.print( contextPath );
      out.write("/enrollForm.me';\r\n");
      out.write("				// 단순한 정적페이지 요청이지만 Servlet을 경유해서 띄어줄 것\r\n");
      out.write("				// localhost:7777/jsp/매핑값\r\n");
      out.write("				// => url에 서블릿매핑값까지만 노출됨\r\n");
      out.write("				\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("		</script>\r\n");
      out.write("		");
} else { 
      out.write("\r\n");
      out.write("		<!-- 사용자가 로그인 성공 후 보게 될 화면-->\r\n");
      out.write("		<div id=\"user-info\">\r\n");
      out.write("		    <span>");
      out.print( loginUser.getUserName() );
      out.write("</span>님 환영합니다.<br><br>\r\n");
      out.write("		    <div>\r\n");
      out.write("		        <a href=\"");
      out.print( contextPath );
      out.write("/myPage\" class=\"btn btn-sm btn-primary\" >마이페이지</a>\r\n");
      out.write("		        <!-- <a href=\"/jsp/logout\">로그아웃</a> -->\r\n");
      out.write("		        <a href=\"");
      out.print( contextPath );
      out.write("/logout\" class=\"btn btn-sm btn-secondary\">로그아웃</a>\r\n");
      out.write("		    </div>\r\n");
      out.write("		</div>\r\n");
      out.write("		");
} 
      out.write("\r\n");
      out.write("		\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<br clear=\"both\">\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"nav-area\" align=\"center\">\r\n");
      out.write("		<div class=\"menu\"><a href=\"");
      out.print( contextPath );
      out.write("\">HOME</a></div>\r\n");
      out.write("		<div class=\"menu\"><a href=\"");
      out.print( contextPath );
      out.write("/noticeList\">공지사항</a></div>\r\n");
      out.write("		<div class=\"menu\"><a href=\"");
      out.print( contextPath );
      out.write("/boardList?currentPage=1\">일반게시판</a></div>\r\n");
      out.write("		<div class=\"menu\"><a href=\"");
      out.print( contextPath );
      out.write("/thumbnailList\">사진게시판</a></div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"outer\">\r\n");
      out.write("		<br>\r\n");
      out.write("		<h2 align=\"center\" >회원가입</h2>\r\n");
      out.write("		\r\n");
      out.write("		<form id=\"enroll-form\" method=\"post\" action=\"");
      out.print( contextPath );
      out.write("/insert.me\">\r\n");
      out.write("			<table align=\"center\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>* 아이디</td>\r\n");
      out.write("					<td><input type=\"text\" maxlength=\"12\" required name=\"userId\"></td>\r\n");
      out.write("					<td><button class=\"btn btn-sm btn-primary\" type=\"button\" onclick=\"idCheck();\">중복확인</button></td>\r\n");
      out.write("					<!-- 중복확인 나중에 AJAX배우고 다음주..? -->\r\n");
      out.write("				</tr>\r\n");
      out.write("				<script>\r\n");
      out.write("					function idCheck(){\r\n");
      out.write("						const $userId = $('#enroll-form input[name=userId]');\r\n");
      out.write("						\r\n");
      out.write("						// AJAX 요청\r\n");
      out.write("						$.ajax({\r\n");
      out.write("							url: 'idCheck.do',\r\n");
      out.write("							data: {\r\n");
      out.write("								checkId : $userId.val()\r\n");
      out.write("							},\r\n");
      out.write("							// 성공시 콜백함수\r\n");
      out.write("							success : function(result){\r\n");
      out.write("								// console.log(result);\r\n");
      out.write("								// result 경우의 수 : \"NNNNN\" / \"NNNNY\"\r\n");
      out.write("								if(result == 'NNNNN'){ // 중복된 아이디\r\n");
      out.write("									alert('이미 존재하거나 탈퇴한 아이디 입니다.');\r\n");
      out.write("								\r\n");
      out.write("									$userId.val('').focus();\r\n");
      out.write("								}\r\n");
      out.write("								else {\r\n");
      out.write("									if(confirm('사용 가능한 아이디입니다. 사용하시겠습니까?')){\r\n");
      out.write("										// 아이디값은 변경 불가능 하도록 == readonly\r\n");
      out.write("										$userId.attr('readonly', true);\r\n");
      out.write("									}\r\n");
      out.write("									else {\r\n");
      out.write("										$('#enroll-form button[type=submit]').removeAttr('disabled');\r\n");
      out.write("									}\r\n");
      out.write("								}\r\n");
      out.write("								\r\n");
      out.write("							},\r\n");
      out.write("							\r\n");
      out.write("							// 실패시 콜백함수\r\n");
      out.write("							error : function(){\r\n");
      out.write("								console.log('AJAX 통신 실패!');\r\n");
      out.write("							}\r\n");
      out.write("							\r\n");
      out.write("							\r\n");
      out.write("						});\r\n");
      out.write("						\r\n");
      out.write("						\r\n");
      out.write("						\r\n");
      out.write("					}\r\n");
      out.write("				</script>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>* 비밀번호</td>\r\n");
      out.write("					<td><input type=\"password\" maxlength=\"15\" required name=\"userPwd\"></td>\r\n");
      out.write("					<td></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>* 비밀번호확인</td>\r\n");
      out.write("					<td><input type=\"password\" maxlength=\"15\" required></td>\r\n");
      out.write("					<td></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>* 이름</td>\r\n");
      out.write("					<td><input type=\"text\" maxlength=\"5\" required name=\"userName\"></td>\r\n");
      out.write("					<td></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>&nbsp;&nbsp;전화번호</td>\r\n");
      out.write("					<td><input type=\"text\" placeholder=\"-포함해서 입력해주세요.\" name=\"phone\"></td>\r\n");
      out.write("					<td></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>&nbsp;&nbsp;이메일</td>\r\n");
      out.write("					<td><input type=\"email\" name=\"email\"></td>\r\n");
      out.write("					<td></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>&nbsp;&nbsp;주소</td>\r\n");
      out.write("					<td><input type=\"text\" name=\"address\"></td>\r\n");
      out.write("					<td></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>&nbsp;&nbsp;취미</td>\r\n");
      out.write("					<td colspan=\"2\">\r\n");
      out.write("						<input type=\"checkbox\" id=\"travel\" value=\"여행\" name=\"interest\"><label for=\"travel\">여행</label>\r\n");
      out.write("						<input type=\"checkbox\" id=\"lodge\" value=\"숙박\" name=\"interest\"><label for=\"lodge\">숙박</label>\r\n");
      out.write("						<input type=\"checkbox\" id=\"movie\" value=\"영화\" name=\"interest\"><label for=\"movie\">영화</label>\r\n");
      out.write("\r\n");
      out.write("						<br>\r\n");
      out.write("\r\n");
      out.write("						<input type=\"checkbox\" id=\"lent\" value=\"차량대여\" name=\"interest\"><label for=\"lent\">차량대여</label>\r\n");
      out.write("						<input type=\"checkbox\" id=\"tea\" value=\"다도\" name=\"interest\"><label for=\"tea\">다도</label>\r\n");
      out.write("						<input type=\"checkbox\" id=\"java\" value=\"자바\" name=\"interest\"><label for=\"java\">자바</label>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("\r\n");
      out.write("			<br><br>\r\n");
      out.write("\r\n");
      out.write("			<div align=\"center\">\r\n");
      out.write("				<button type=\"reset\" class=\"btn btn-sm btn-secondary\">취소</button>\r\n");
      out.write("				<button type=\"submit\" class=\"btn btn-sm btn-primary\" disabled>회원가입</button>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<br><br>\r\n");
      out.write("			\r\n");
      out.write("		</form>\r\n");
      out.write("		\r\n");
      out.write("	</div>\r\n");
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
