/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.87
 * Generated at: 2024-07-08 11:45:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>관리자 로그인</title>\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write("body, html {\r\n");
      out.write("	height: 100%;\r\n");
      out.write("	margin: 0;\r\n");
      out.write("	font-family: Arial, sans-serif;\r\n");
      out.write("	background-color: #343a40;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login-background {\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("	align-items: center;\r\n");
      out.write("	height: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".login-popup {\r\n");
      out.write("	background-color: #212529;\r\n");
      out.write("	color: #fff;\r\n");
      out.write("	padding: 40px;\r\n");
      out.write("	border-radius: 10px;\r\n");
      out.write("	box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);\r\n");
      out.write("	width: 400px;\r\n");
      out.write("	max-width: 100%;\r\n");
      out.write("	text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".popup {\r\n");
      out.write("	display: none;\r\n");
      out.write("	position: fixed;\r\n");
      out.write("	z-index: 1;\r\n");
      out.write("	left: 0;\r\n");
      out.write("	top: 0;\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	height: 100%;\r\n");
      out.write("	overflow: auto;\r\n");
      out.write("	background-color: rgba(0, 0, 0, 0.4);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".popup-content {\r\n");
      out.write("	background-color: #212529;\r\n");
      out.write("	color: #fff;\r\n");
      out.write("	padding: 40px;\r\n");
      out.write("	border-radius: 10px;\r\n");
      out.write("	box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);\r\n");
      out.write("	width: 400px;\r\n");
      out.write("	max-width: 100%;\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	margin: 10% auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".close {\r\n");
      out.write("	color: #aaa;\r\n");
      out.write("	float: right;\r\n");
      out.write("	font-size: 28px;\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".close:hover, .close:focus {\r\n");
      out.write("	color: black;\r\n");
      out.write("	text-decoration: none;\r\n");
      out.write("	cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h2 {\r\n");
      out.write("	margin-bottom: 20px;\r\n");
      out.write("	color: #007bff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn-primary {\r\n");
      out.write("	background-color: #007bff;\r\n");
      out.write("	border-color: #007bff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn-primary:hover {\r\n");
      out.write("	background-color: #0056b3;\r\n");
      out.write("	border-color: #004085;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-group label {\r\n");
      out.write("	float: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-group input {\r\n");
      out.write("	background-color: #495057;\r\n");
      out.write("	color: #fff;\r\n");
      out.write("	border: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-group input:focus {\r\n");
      out.write("	background-color: #495057;\r\n");
      out.write("	color: #fff;\r\n");
      out.write("	border: 1px solid #007bff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-find {\r\n");
      out.write("	margin-top: 20px;\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: space-between;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-find a {\r\n");
      out.write("	color: #007bff;\r\n");
      out.write("	text-decoration: none;\r\n");
      out.write("	cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-find a:hover {\r\n");
      out.write("	text-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"login-background\">\r\n");
      out.write("		<div class=\"login-popup\">\r\n");
      out.write("			<h2>관리자 로그인</h2>\r\n");
      out.write("			<form id=\"loginForm\" action=\"admin_login\" method=\"post\">\r\n");
      out.write("				<div class=\"form-group\">\r\n");
      out.write("					<label for=\"admin_id\">사용자 이름</label> \r\n");
      out.write("					<input type=\"text\" class=\"form-control\" id=\"admin_id\" name=\"admin_id\" value=\"admin\" required>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"form-group\">\r\n");
      out.write("					<label for=\"admin_pw\">비밀번호</label> \r\n");
      out.write("					<input type=\"password\" class=\"form-control\" id=\"admin_pw\" name=\"admin_pw\" value=\"admin\" required>\r\n");
      out.write("				</div>\r\n");
      out.write("				<button type=\"submit\" class=\"btn btn-primary btn-block\">로그인</button>\r\n");
      out.write("\r\n");
      out.write("			</form>\r\n");
      out.write("			<div class=\"form-find\">\r\n");
      out.write("				<a href=\"#\" onclick=\"resetForm()\">초기화</a> <a href=\"#\"\r\n");
      out.write("					onclick=\"openFindIdPopup()\">아이디 찾기</a> <a href=\"#\"\r\n");
      out.write("					onclick=\"openFindPwPopup()\">비밀번호 찾기</a>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- ID 찾기 팝업 -->\r\n");
      out.write("	<div id=\"findIdPopup\" class=\"popup\">\r\n");
      out.write("		<div class=\"popup-content\">\r\n");
      out.write("			<span class=\"close\" onclick=\"closeFindIdPopup()\">&times;</span>\r\n");
      out.write("			<h2>아이디 찾기</h2>\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"find_admin_email\">이메일</label> <input type=\"email\"\r\n");
      out.write("					class=\"form-control\" id=\"find_admin_email\" name=\"admin_email\"\r\n");
      out.write("					required>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"find_admin_name\">이름</label> <input type=\"text\"\r\n");
      out.write("					class=\"form-control\" id=\"find_admin_name\" name=\"admin_name\"\r\n");
      out.write("					required>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"button\" class=\"btn btn-primary btn-block\"\r\n");
      out.write("				onclick=\"findId()\" value=\"아이디 찾기\">\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- PW 찾기 팝업 -->\r\n");
      out.write("	<div id=\"findPwPopup\" class=\"popup\">\r\n");
      out.write("		<div class=\"popup-content\">\r\n");
      out.write("			<span class=\"close\" onclick=\"closeFindPwPopup()\">&times;</span>\r\n");
      out.write("			<h2>비밀번호 찾기</h2>\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"find_pw_admin_id\">아이디</label> <input type=\"text\"\r\n");
      out.write("					class=\"form-control\" id=\"find_pw_admin_id\" name=\"admin_id\" required>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"find_pw_admin_name\">이름</label> <input type=\"text\"\r\n");
      out.write("					class=\"form-control\" id=\"find_pw_admin_name\" name=\"admin_name\"\r\n");
      out.write("					required>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"find_pw_admin_phone\">연락처</label> <input type=\"text\"\r\n");
      out.write("					class=\"form-control\" id=\"find_pw_admin_phone\" name=\"admin_phone\"\r\n");
      out.write("					required>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"button\" class=\"btn btn-primary btn-block\"\r\n");
      out.write("				onclick=\"findPw()\" value=\"비밀번호 찾기\">\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<!-- PW 변경 팝업 -->\r\n");
      out.write("	<div id=\"changePwPopup\" class=\"popup\">\r\n");
      out.write("		<div class=\"popup-content\">\r\n");
      out.write("			<span class=\"close\" onclick=\"closeChangePwPopup()\">&times;</span>\r\n");
      out.write("			<h2>비밀번호 변경</h2>\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"new_password\">새 비밀번호</label> <input type=\"password\"\r\n");
      out.write("					class=\"form-control\" id=\"new_admin_pw\" name=\"new_admin_pw\" required>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"button\" class=\"btn btn-primary btn-block\"\r\n");
      out.write("				onclick=\"changePw()\" value=\"비밀번호 변경\">\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("	<script>		\r\n");
      out.write("		function openFindIdPopup() {\r\n");
      out.write("			document.getElementById(\"findIdPopup\").style.display = \"block\";\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		function closeFindIdPopup() {\r\n");
      out.write("			document.getElementById(\"findIdPopup\").style.display = \"none\";\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		function openFindPwPopup() {\r\n");
      out.write("			document.getElementById(\"findPwPopup\").style.display = \"block\";\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		function closeFindPwPopup() {\r\n");
      out.write("			document.getElementById(\"findPwPopup\").style.display = \"none\";\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		function openChangePwPopup() {\r\n");
      out.write("			document.getElementById(\"changePwPopup\").style.display = \"block\";\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		function closeChangePwPopup() {\r\n");
      out.write("			document.getElementById(\"changePwPopup\").style.display = \"none\";\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		function resetForm() {\r\n");
      out.write("			document.getElementById(\"loginForm\").reset();\r\n");
      out.write("		}\r\n");
      out.write("		function findId() {\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				type : \"post\",\r\n");
      out.write("				url : \"admin_findid\",\r\n");
      out.write("				data : {\r\n");
      out.write("					\"admin_email\" : $(\"#find_admin_email\").val(),\r\n");
      out.write("					\"admin_name\" : $(\"#find_admin_name\").val()\r\n");
      out.write("				},\r\n");
      out.write("				success : function(findIdResult) {\r\n");
      out.write("					if (findIdResult == \"0\") {\r\n");
      out.write("						alert(\"아이디를 찾을 수 없습니다.\");\r\n");
      out.write("					} else {\r\n");
      out.write("						alert(\"아이디: \" + findIdResult);\r\n");
      out.write("						closeFindIdPopup();\r\n");
      out.write("					}\r\n");
      out.write("\r\n");
      out.write("				},\r\n");
      out.write("				error : function() {\r\n");
      out.write("	                alert(\"오류가 발생했습니다.\");\r\n");
      out.write("	            }\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		function findPw() {\r\n");
      out.write("			console.log($(\"#find_pw_admin_id\").val());\r\n");
      out.write("			console.log($(\"#find_pw_admin_name\").val());\r\n");
      out.write("			console.log($(\"#find_pw_admin_phone\").val());\r\n");
      out.write("			\r\n");
      out.write("	        $.ajax({			\r\n");
      out.write("	            type: \"post\",\r\n");
      out.write("	            url: \"admin_findpw\",\r\n");
      out.write("	            data: {\r\n");
      out.write("	                \"admin_id\": $(\"#find_pw_admin_id\").val(),\r\n");
      out.write("	                \"admin_name\": $(\"#find_pw_admin_name\").val(),\r\n");
      out.write("	                \"admin_phone\": $(\"#find_pw_admin_phone\").val()\r\n");
      out.write("	            },\r\n");
      out.write("	            success: function(findPwResult) {\r\n");
      out.write("	                if(findPwResult == \"0\"){\r\n");
      out.write("	                    alert(\"정보가 일치하지 않습니다.\");	\r\n");
      out.write("	                } else {	                \r\n");
      out.write("	                    openChangePwPopup();\r\n");
      out.write("	                }\r\n");
      out.write("	            },\r\n");
      out.write("	            error: function() {\r\n");
      out.write("	                alert(\"오류가 발생했습니다.\");\r\n");
      out.write("	            }\r\n");
      out.write("	        });\r\n");
      out.write("	    }\r\n");
      out.write("		\r\n");
      out.write("		function changePw() {\r\n");
      out.write("	        console.log($(\"#find_pw_admin_id\").val());\r\n");
      out.write("	        console.log($(\"#new_admin_pw\").val());\r\n");
      out.write("			$.ajax({\r\n");
      out.write("	            type: \"post\",\r\n");
      out.write("	            url: \"admin_changepw\",\r\n");
      out.write("	            data: {\r\n");
      out.write("	                \"admin_id\": $(\"#find_pw_admin_id\").val(),\r\n");
      out.write("	                \"new_admin_pw\": $(\"#new_admin_pw\").val()\r\n");
      out.write("	            },\r\n");
      out.write("	            success: function(changePwResult) {\r\n");
      out.write("	                if(changePwResult == \"1\"){\r\n");
      out.write("	                    alert(\"비밀번호가 성공적으로 변경되었습니다.\");\r\n");
      out.write("	                    closeChangePwPopup();\r\n");
      out.write("	                    closeFindPwPopup();\r\n");
      out.write("	                } else {\r\n");
      out.write("	                    alert(\"비밀번호 변경에 실패했습니다.\");\r\n");
      out.write("	                }\r\n");
      out.write("	            },\r\n");
      out.write("	            error: function() {\r\n");
      out.write("	                alert(\"오류가 발생했습니다.\");\r\n");
      out.write("	            }\r\n");
      out.write("	        });\r\n");
      out.write("	    }		\r\n");
      out.write("	</script>\r\n");
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
