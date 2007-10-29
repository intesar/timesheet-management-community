<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.abbhsoft.trainingschedular.service.*" %>
<%@page import="com.abbhsoft.trainingschedular.model.Course" %>
<%@page import="java.util.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="http://www.webtoolkit.info/demo/jquery/scrollable/webtoolkit.scrollabletable.js"></script>
        <script type="text/javascript" src="http://www.webtoolkit.info/demo/jquery/scrollable/jquery.js"></script>
        <script type="text/javascript" src="http://www.webtoolkit.info/demo/jquery/scrollable/webtoolkit.jscrollable.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function() {
                jQuery('courseTable').Scrollable(400, 1000);
            });
        </script>

        <style>
            table {
                text-align: left;
                font-size: 12px;
                font-family: verdana;
                background: #c0c0c0;
            }

            table thead tr,
            table tfoot tr {
                background: #c0c0c0;
            }

            table tbody tr {
                background: #f0f0f0;
            }

            td, th {
                border: 1px solid white;
            }
        </style>
    </head>
    <body>
       
        
        
        <table id="courseTable">
           
                <th>
                    <tr>
                    <td>Course</td>
                    <td>Description</td>
                    <td>Start Date </td>
                    <td>City</td>                    
                    </tr>
                </th>
            
            <% 
                CourseService service = ServiceFactory.getCourseService();
                List<Course> list = service.getAll();
                for ( Course c : list ) {
            %>
            
            <tr>
                <td> <a href="course.jsp?courseId=<%= c.getId() %>" /><%= c.getName() %></a> </td>
                <td> <%= c.getDescription() %> </td>
                <td> <%= c.getStateDate() %> </td>
                <td> <%= c.getLocation().getCity() %> </td>

            </tr>
           
            <%                
                }            
            %>
        </table>
        
    </body>
</html>
