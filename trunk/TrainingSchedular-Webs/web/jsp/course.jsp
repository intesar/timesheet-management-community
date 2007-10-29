
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.abbhsoft.trainingschedular.service.*" %>
<%@page import="com.abbhsoft.trainingschedular.model.*" %>
<%@page import="com.abbhsoft.trainingschedular.model.Class" %>
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
        <script type="text/javascript" src="http://malsup.com/jquery/form/jquery.form.js"></script> 
        
        <script type="text/javascript"> 
            // wait for the DOM to be loaded 
            $(document).ready(function() { 
            // bind 'myForm' and provide a simple callback function 
            $('#myForm').ajaxForm(function() { 
            alert("Thank you for your comment!"); 
            }); 
            }); 
        </script> 
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
        <%
        CourseService service = ServiceFactory.getCourseService();
        Long id = Long.parseLong(request.getParameter("courseId"));
        Course c = service.getById(id);
        %>
        <br/>
        <h3> Course Details </h3>
        <table border="0">
            <thead>
            
            <tbody>
                <tr>
                    <td>Name</td>
                    <td><%= c.getName() %> </td>
                    <td>Start Date</td>
                    <td><%= c.getStateDate() %></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><%= c.getDescription() %> </td>
                    <td>Location</td>
                    <td><%= c.getLocation() %> </td>
                </tr>
            </tbody>
        </table>
        
        <br/>
        <br/>
        <h3> Prerequisite </h3>
        
        <table>
            <%
            Collection<Prerequisite> pres = c.getPrerequisiteCollection();
            for ( Prerequisite p : pres ) {
            %>
            <tr>
                <td><%= p.getName() %></td>
                <td><%= p.getDescription() %></td>
            </tr>
            <%
            }
            %>
            
        </table>
        <br/>
        <br/>
        <h3> Class Details </h3>
        <table>
            <%
            Collection<Class> classes = c.getClassCollection();
            for ( Class cl :classes ) {
            %>
            <tr>
            <td><%= cl.getClassNo() %></td>
            <td><%= cl.getTopic() %></td>
            <td><%= cl.getDescription() %></td>            
            <td><%= cl.getDuration() %></td>
            <td><%= cl.getInstructor() %></td>
            <td><%= cl.getClassDate() %> </td>        
        </table>
        <%
        }
        %>
        
        <br/>
        <h3> Enroll </h3>
        <table border="0">
            <form action="Enroll" id="myForm">
                
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Middle Initial</td>
                        <td><input type="text" name="mi" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Home Phone</td>
                        <td><input type="text" name="homePhone" value="" /></td>
                    </tr>
                    <tr>
                        <td>Mobile Phone</td>
                        <td><input type="text" name="mobilePhone" value="" /></td>
                    </tr>
                    <tr>
                        <td>Comments</td>
                        <td><textarea  name="comments" value="" size="3" ></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Reset" /></td>
                        <td><input type="submit" value="Enroll" /></td>
                    </tr>
                </tbody>
            </form>
        </table>
        
        
        
    </body>
</html>
