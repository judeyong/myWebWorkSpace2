/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.99
 * Generated at: 2024-03-20 01:41:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.kh.jsp.board.model.vo.Board;
import com.kh.jsp.member.model.vo.Member;

public final class imageBoardList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/board/../common/menubar.jsp", Long.valueOf(1710746254758L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(3);
    _jspx_imports_classes.add("com.kh.jsp.member.model.vo.Member");
    _jspx_imports_classes.add("com.kh.jsp.board.model.vo.Board");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("    ");

    	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
    
    
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("	.list-area{\r\n");
      out.write("		text-align: center;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.thumbnail{\r\n");
      out.write("		box-shadow: 2px 2px 4px lightgray;\r\n");
      out.write("		width: 300px;\r\n");
      out.write("		padding: 12px;\r\n");
      out.write("		margin: 25px;\r\n");
      out.write("		display:inline-block;\r\n");
      out.write("		background-color: lightblue;\r\n");
      out.write("		font-weight: bold;\r\n");
      out.write("		border-radius: 12px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.thumbnail > img {\r\n");
      out.write("		width: 250px;\r\n");
      out.write("		height: 180px;\r\n");
      out.write("		margin-botton: 8px;\r\n");
      out.write("		border-radius: 12px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.thumbnail:hover {\r\n");
      out.write("		cursor:pointer;\r\n");
      out.write("		opacity: 0.8;\r\n");
      out.write("	}	\r\n");
      out.write("	\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
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
      out.write("		<div style=\"margin-top: 15px; width: 400px; height: 280px; margin: auto;\" >\r\n");
      out.write("			<img width=400 height=280 src=\"https://i.namu.wiki/i/uwHGKFJAZTgXlnja_ul4Z-myJ1KUyA32HL9mOw69w9c3-KRKwb6S0Sk5EtuE_cRWoES5QIUORWgXHH6oJleBMA.webp\" >\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		");
if(loginUser != null) {
      out.write("\r\n");
      out.write("			<div style=\"align:right\">\r\n");
      out.write("				<a class=\"btn btn-sm btn-primary\" style=\"color:black; background-color: lightblue; border:none;'\"\r\n");
      out.write("				   href=\"");
      out.print( contextPath );
      out.write("/enrollForm.imageBoard\"\r\n");
      out.write("				>글작성</a>\r\n");
      out.write("			</div>\r\n");
      out.write("		");
}  
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"list-area\">\r\n");
      out.write("		");
if(list.isEmpty()){ 
      out.write("\r\n");
      out.write("			등록된 게시글이 존재하지 않습니다. <br>\r\n");
      out.write("		");
} else { 
      out.write("\r\n");
      out.write("			");
 for(Board b : list){ 
      out.write("\r\n");
      out.write("				<div class=\"thumbnail\" align=\"center\">\r\n");
      out.write("					<input type=\"hidden\" value=\"");
      out.print( b.getBoardNo() );
      out.write("\">\r\n");
      out.write("					<img src=\"");
      out.print( b.getTitleImg() );
      out.write("\" />\r\n");
      out.write("					<p>\r\n");
      out.write("						<!-- <label>No. ");
      out.print( b.getBoardNo() );
      out.write("</label>/ -->\r\n");
      out.write("						<span style=\"font-size: 17px;\">");
      out.print( b.getBoardTitle() );
      out.write("</span><br>\r\n");
      out.write("						<label>조회수</label> : <span>");
      out.print( b.getCount() );
      out.write("</span>\r\n");
      out.write("					</p>\r\n");
      out.write("				</div>\r\n");
      out.write("			");
} 
      out.write("\r\n");
      out.write("			\r\n");
      out.write("		");
} 
      out.write("\r\n");
      out.write("		<script>\r\n");
      out.write("			$(function(){\r\n");
      out.write("				$('.thumbnail').click(function(e){\r\n");
      out.write("					// 클릭 할 때 마다 url요청 => location.href\r\n");
      out.write("					// console.log($(this).children().eq(1).children().eq(0).text().split(' ')[1]);\r\n");
      out.write("					// console.log($(this).children().eq(0).val());\r\n");
      out.write("					\r\n");
      out.write("					const boardNo = $(this).children().eq(0).val();\r\n");
      out.write("					location.href='");
      out.print( contextPath );
      out.write("/detail.image?boardNo=' + boardNo;\r\n");
      out.write("					\r\n");
      out.write("				});\r\n");
      out.write("				\r\n");
      out.write("				\r\n");
      out.write("			});\r\n");
      out.write("		</script>\r\n");
      out.write("		\r\n");
      out.write("			<!-- \r\n");
      out.write("			<div class=\"thumbnail\" align=\"center\">\r\n");
      out.write("				<img src=\"https://cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/UVBJZL3RXAB36BDSHVM3MW2WNY.jpg\" >\r\n");
      out.write("				<p>\r\n");
      out.write("					<label>No.1</label> / <span>개구리 페페</span><br>\r\n");
      out.write("					<label>조회수</label> : <span>200</span>\r\n");
      out.write("				</p>\r\n");
      out.write("			</div>\r\n");
      out.write("			 -->\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
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