/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.87
 * Generated at: 2024-07-18 00:54:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005fnotice_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/sh3/workspace-sts-3.9.18/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Shinhan_SW_1st_TeamProject/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1719295440415L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>공지사항 목록</title>\r\n");
      out.write("    <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>    \r\n");
      out.write("    <style>\r\n");
      out.write("        .modal-body {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("        }\r\n");
      out.write("        #noticeForm {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            max-width: 500px;\r\n");
      out.write("        }\r\n");
      out.write("        #noticeForm .form-group {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            margin-bottom: 15px;\r\n");
      out.write("        }\r\n");
      out.write("        #noticeForm label {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        #noticeForm input, #noticeForm textarea {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common.jsp", out, false);
      out.write("\r\n");
      out.write("    <div class=\"content\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <h1>공지사항 목록</h1>\r\n");
      out.write("\r\n");
      out.write("            <form id=\"searchForm\" class=\"form-inline mb-3\">\r\n");
      out.write("                <input type=\"text\" name=\"searchNotice\" id=\"searchNotice\" placeholder=\"공지사항 제목 검색\" class=\"form-control mr-2\">\r\n");
      out.write("                <input type=\"button\" class=\"btn btn-primary\" onclick=\"searchNotices()\" value=\"검색\" />\r\n");
      out.write("                <input type=\"button\" class=\"btn btn-secondary ml-2\" onclick=\"resetSearch()\" value=\"초기화\" />\r\n");
      out.write("                <input type=\"button\" class=\"btn btn-success ml-auto\" onclick=\"openCreatePopup()\" value=\"등록\" />                \r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"table-container\">\r\n");
      out.write("                <table class=\"table table-striped\">\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>공지사항 번호</th>\r\n");
      out.write("                            <th>공지사항 제목</th>\r\n");
      out.write("                            <th>공지사항 내용</th>\r\n");
      out.write("                            <th>작성 일자</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <tbody id=\"noticeList\">\r\n");
      out.write("                        ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Notice Detail Popup Modal -->\r\n");
      out.write("    <div class=\"modal fade\" id=\"noticeDetailModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"noticeDetailModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("            <div class=\"modal-content\">\r\n");
      out.write("                <div class=\"modal-header\">\r\n");
      out.write("                    <h5 class=\"modal-title\" id=\"noticeDetailModalLabel\">공지사항 상세</h5>\r\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                </div>                \r\n");
      out.write("                <div class=\"modal-body\">\r\n");
      out.write("                    <form id=\"noticeForm\">\r\n");
      out.write("                        <input type=\"hidden\" id=\"not_id\" name=\"not_id\">\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"not_title\">제목</label>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"not_title\" name=\"not_title\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"not_content\">내용</label>\r\n");
      out.write("                            <textarea class=\"form-control\" id=\"not_content\" name=\"not_content\" rows=\"5\" required></textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"not_date\">작성 일자</label>\r\n");
      out.write("                            <input type=\"date\" class=\"form-control\" id=\"not_date\" name=\"not_date\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-success\" id=\"saveButton\">저장</button>\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-danger\" id=\"deleteButton\" onclick=\"deleteNotice()\">삭제</button>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>                \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        function searchNotices() {\r\n");
      out.write("            var searchNotice = $('#searchNotice').val();\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: 'admin_notice_search',\r\n");
      out.write("                type: 'GET',\r\n");
      out.write("                data: { search_notice: searchNotice },\r\n");
      out.write("                success: function(response) {\r\n");
      out.write("                    $('#noticeList').html(response);\r\n");
      out.write("                },\r\n");
      out.write("                error: function() {\r\n");
      out.write("                    alert('공지사항 검색에 실패했습니다.');\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function resetSearch() {\r\n");
      out.write("            $('#searchNotice').val('');\r\n");
      out.write("            location.reload();\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        function openDetailPopup(not_id) {\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: 'admin_notice_detail',\r\n");
      out.write("                type: 'GET',\r\n");
      out.write("                data: { not_id: not_id },\r\n");
      out.write("                success: function(data) {\r\n");
      out.write("                    $('#noticeDetailModalLabel').text('공지사항 상세');\r\n");
      out.write("                    $('#not_id').val(data.not_id);\r\n");
      out.write("                    $('#not_title').val(data.not_title);\r\n");
      out.write("                    $('#not_content').val(data.not_content);\r\n");
      out.write("                    $('#not_date').val(new Date(data.not_date).toISOString().split('T')[0]);\r\n");
      out.write("                    $('#deleteButton').show();\r\n");
      out.write("                    $('#noticeDetailModal').modal('show');\r\n");
      out.write("                },\r\n");
      out.write("                error: function() {\r\n");
      out.write("                    alert('공지사항 세부 정보를 불러오는 데 실패했습니다.');\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function deleteNotice() {\r\n");
      out.write("            var not_id = $('#not_id').val();\r\n");
      out.write("            if (confirm('공지사항을 삭제하시겠습니까?')) {\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url: 'admin_notice_delete',\r\n");
      out.write("                    type: 'POST',\r\n");
      out.write("                    data: { not_id: not_id },\r\n");
      out.write("                    success: function() {\r\n");
      out.write("                        alert('공지사항이 삭제되었습니다.');\r\n");
      out.write("                        $('#noticeDetailModal').modal('hide');\r\n");
      out.write("                        location.reload();\r\n");
      out.write("                    },\r\n");
      out.write("                    error: function() {\r\n");
      out.write("                        alert('공지사항 삭제에 실패했습니다.');\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function openCreatePopup() {\r\n");
      out.write("            $('#noticeDetailModalLabel').text('공지사항 등록');\r\n");
      out.write("            $('#not_id').val('');\r\n");
      out.write("            $('#not_title').val('');\r\n");
      out.write("            $('#not_content').val('');\r\n");
      out.write("            $('#not_date').val(new Date().toISOString().split('T')[0]);\r\n");
      out.write("            $('#deleteButton').hide();\r\n");
      out.write("            $('#noticeDetailModal').modal('show');\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        $('#noticeForm').submit(function(event) {\r\n");
      out.write("            event.preventDefault();\r\n");
      out.write("            var action = $('#not_id').val() ? 'admin_notice_update' : 'admin_notice_insert';\r\n");
      out.write("            var formData = $(this).serialize();\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: action,\r\n");
      out.write("                type: 'POST',\r\n");
      out.write("                data: formData,\r\n");
      out.write("                success: function() {\r\n");
      out.write("                    alert('공지사항이 저장되었습니다.');\r\n");
      out.write("                    $('#noticeDetailModal').modal('hide');\r\n");
      out.write("                    location.reload();\r\n");
      out.write("                },\r\n");
      out.write("                error: function() {\r\n");
      out.write("                    alert('공지사항 저장에 실패했습니다.');\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/admin/admin_notice_list.jsp(60,24) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("notice");
      // /WEB-INF/views/admin/admin_notice_list.jsp(60,24) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/admin/admin_notice_list.jsp(60,24) '${notices}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${notices}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                            <tr>\r\n");
            out.write("                                <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.not_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                                <td><a href=\"#\" onclick=\"openDetailPopup(");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.not_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(')');
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.not_title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</a></td>\r\n");
            out.write("                                <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.not_content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                                <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.not_date}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>                                \r\n");
            out.write("                            </tr>\r\n");
            out.write("                        ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
