

<%-- 
Document   : index
Created on : Nov 24, 2007, 4:55:55 PM
Author     : Amer
--%>
<%@ page import="com.abbhsoft.faq.dao.*" %>
<%@ page import="com.abbhsoft.faq.model.*" %>
<%@ page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Layout Container Demo 2</title>
        <style type="text/css">
            @import "http://o.aolcdn.com/dojo/1.0.0/dijit/themes/tundra/tundra.css";
            @import "http://o.aolcdn.com/dojo/1.0.0/dojo/resources/dojo.css";
        </style>
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <style> 
            /* NOTE: for a full screen layout, must set body size equal to the viewport. */
            html, body { height: 100%; width: 100%; margin: 0; padding: 0; }
        </style>
        
        <script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0.0/dojo/dojo.xd.js"
                djConfig="parseOnLoad: true"></script>
        <script type='text/javascript' src='/FAQ1/dwr/interface/faqRemoteService.js'></script>
        <script type='text/javascript' src='/FAQ1/dwr/engine.js'></script>
        
        
        <script type='text/javascript' src='/SRM/dwr/engine.js'></script>
        <script type='text/javascript' src='/SRM/dwr/util.js'></script>
        <script type='text/javascript'>
            function objectEval(text)
            {
            // eval() breaks when we use it to get an object using the { a:42, b:'x' }
            // syntax because it thinks that { and } surround a block and not an object
            // So we wrap it in an array and extract the first element to get around
            // this.
            // This code is only needed for interpreting the parameter input fields,
            // so you can ignore this for normal use.
            // The regex = [start of line][whitespace]{[stuff]}[whitespace][end of line]
            text = text.replace(/\n/g, ' ');
            text = text.replace(/\r/g, ' ');
            if (text.match(/^\s*\{.*\}\s*$/))
            {
            text = '[' + text + '][0]';
            }
            return eval(text);
            }
            function sendEmailToAllStudents() {
            addEntityRemoteService.sendEmailToAllStudents(replyEmails);
            }       
            var replyEmails = function(data) {
            alert ( 'Emails Send!');
            }
            
        </script>
        <script type="text/javascript">
            dojo.require("dojo.parser");
            dojo.require("dijit.form.TextBox");
            dojo.require("dijit.form.ValidationTextBox");
            dojo.require("dijit.Dialog");
            dojo.require("dojo.parser");
            dojo.require("dijit.form.Button");
            dojo.require("dijit.Toolbar");     
            dojo.require("dijit.form.DateTextBox");                 
            dojo.require("dijit.form.CheckBox");            
            dojo.require("dijit.form.ComboBox");
            dojo.require("dijit.layout.ContentPane");
            dojo.require("dijit.layout.LayoutContainer");
            
            
            
        </script>
        
    </head>
    <body class="tundra" >
        
        <div dojoType="dijit.layout.LayoutContainer" style="width: 100%; height: 100%; padding: 0; margin: 0; border: 0;">
            
            <div dojoType="dijit.layout.ContentPane" layoutAlign="top" >
                
                
                <div id="toolbar1" dojoType="dijit.Toolbar"
                     ><div dojoType="dijit.form.Button" id="toolbar1.Category" iconClass="dijitEditorIcon"   
                          onclick="dijit.byId('CategoryDiv').show()">New Category </div
                    
                    ><div dojoType="dijit.form.Button" id="toolbar1.Topic" iconClass="dijitEditorIcon "
                          onclick="dijit.byId('TopicDiv').show()">New Topic</div
                    ><div dojoType="dijit.form.Button" id="toolbar1.question" iconClass="dijitEditorIcon "
                          onclick="dijit.byId('QuestionDiv').show()">New Question</div
                    ><!-- The following adds a line between toolbar sections
                    -->
                    
                    <div dojoType="dijit.form.ToggleButton" id="toolbar1.developers"
                         iconClass="dijitEditorIcon " 
                         onclick="dijit.byId('developersDiv').show()">Developers</div>
                    <div dojoType="dijit.form.ToggleButton" id="toolbar1.logout"
                         iconClass="dijitEditorIcon " 
                         onclick="window.location='j_acegi_logout'">Logout</div> 
                    
                    
                    
                </div>
                
                <br/>
                
                <!--
                category div
                -->
                <div dojoType="dijit.Dialog" title="New Category" id="CategoryDiv">           
                    
                    
                    <table border="0">                        
                        <tbody>
                            <tr>
                                <td><label for="name">Category Name: </label></td>
                                <td><input dojoType="dijit.form.TextBox"  name="name" id="categoryName"
                                               trim="true"
                                               lowercase="true"
                                               required="true"
                                               promptMessage="Category Name"
                                           invalidMessage="Cannot be Empty!"/></td>
                            </tr>
                            
                            
                            <tr>
                                <td>
                                    <button class='ibutton' type='button' dojoType="dijit.form.Button" onclick='addCategory();' value='Execute'  >Add Category </button>
                                    
                                </td>
                                <script type='text/javascript'>
                                    function addCategory() {
                                    var category = "'" + $("categoryName").value + "'";
                                    
                                    faqRemoteService.addCategory(objectEval(category), reply1);
                                    }
                                    var reply1 = function(data)
                                    {
                                    if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                                    else dwr.util.setValue('d1', dwr.util.toDescriptiveString(data, 1));
                                    }
                                </script>
                                <span id='d1' class='reply'></span>
                            </tr>
                        </tbody>
                    </table>
                    
                    
                </div>
                
                <!-- End of Category Div -->
                
                <!--
                topic div
                -->
                <div dojoType="dijit.Dialog" title="New Topic" id="TopicDiv">           
                    
                    
                    <table border="0">                        
                        <tbody>
                            <tr>
                                <td><label for="name">Category Name: </label></td>
                                <td>
                                    <select name="category1" id="category2"
                                            dojoType="dijit.form.ComboBox"
                                            autocomplete="true"
                                            trim="true"
                                            >
                                        <% 
                                        CategoryDAO dao = new CategoryDAO();
                                        List<Category> list = dao.findAll();
                                        for ( Category c : list ) {
                                        out.println ( "<option> " + c.getName() + "</option>");
                                        }
                                        %>                       
                                        
                                        
                                    </select>
                                </td>
                            </tr>
                            
                            <tr>
                                <td><label for="name">Topic Name: </label></td>
                                <td><input dojoType="dijit.form.TextBox"  name="topicName" id="topicName"
                                               trim="true"
                                               lowercase="true"
                                               required="true"
                                               
                                           invalidMessage="Cannot be Empty!"/></td>
                            </tr>
                            <tr>
                                <td>
                                    <button class='ibutton' type='button' dojoType="dijit.form.Button" onclick='addTopic();' value='Execute'  >Add Topic </button>
                                    
                                </td>
                                <script type='text/javascript'>
                                    function addTopic() {
                                    var category = "'" + $("category2").value + "'";
                                    
                                    var topic = "'" + $("topicName").value + "'";
                                    
                                    faqRemoteService.addTopic(objectEval(category), objectEval(topic), reply2);
                                    }
                                    var reply2 = function(data)
                                    {
                                    if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                                    else dwr.util.setValue('d2', dwr.util.toDescriptiveString(data, 1));
                                    }
                                </script>
                                <span id='d2' class='reply'></span>
                            </tr>
                        </tbody>
                    </table>
                    
                    
                </div>
                
                <!-- End of topic Div -->
                
                <!-- Add Developers -->
                
                <div dojoType="dijit.Dialog" title="New Question" id="QuestionDiv">           
                    
                    
                    <table border="0">                        
                        <tbody>
                            <tr>
                                <td><label for="name">Topic: </label></td>
                                <td>
                                    <select name="topic1" id="topic1"
                                            dojoType="dijit.form.ComboBox"
                                            autocomplete="true"
                                            trim="true"
                                            >
                                        <% 
                                        TopicDAO dao1 = new TopicDAO();
                                        List<Topic> list1 = dao1.findAll();
                                        for ( Topic c : list1 ) {
                                        out.println ( "<option> " + c.getName() + "</option>");
                                        }
                                        %>                       
                                        
                                        
                                    </select>
                                </td>
                            </tr>
                            
                            <tr>
                                <td><label for="name">Question: </label></td>
                                <td><input dojoType="dijit.form.TextBox"  name="topicName" id="question"
                                               trim="true"
                                               lowercase="true"
                                               required="true"
                                               
                                           invalidMessage="Cannot be Empty!"/></td>
                            </tr>
                            <tr>
                                <td><label for="name">Answer: </label></td>
                                <td><input dojoType="dijit.form.TextBox"  name="topicName" id="answer"
                                               trim="true"
                                               lowercase="true"
                                               required="true"
                                               
                                           invalidMessage="Cannot be Empty!"/></td>
                            </tr>
                            <tr>
                                <td>
                                    <button class='ibutton' type='button' dojoType="dijit.form.Button" onclick='addTopic();' value='Execute'  >Add Topic </button>
                                    
                                </td>
                                <script type='text/javascript'>
                                    function addTopic() {
                                    var t = "'" + $("topic1").value + "'";
                                    
                                    var q = "'" + $("question").value + "'";
                                    var a = "'" + $("answer").value + "'";
                                    
                                    faqRemoteService.addQuestion(objectEval(t), objectEval(q), objectEval(a), reply3);
                                    }
                                    var reply3 = function(data)
                                    {
                                    if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                                    else dwr.util.setValue('d3', dwr.util.toDescriptiveString(data, 1));
                                    }
                                </script>
                                <span id='d3' class='reply'></span>
                            </tr>
                        </tbody>
                    </table>
                    
                    
                </div>
                
                <div dojoType="dijit.Dialog" title="Developers" id="developersDiv">          
                    
                    <table border="0">                        
                        <thead>
                            <tr>
                                <th>Name</th>                                                       
                                <th>Title</th>
                                <th>Email</th>
                                <th>Contribution</th>                            
                            </tr>
                        </thead>
                        <tbody>
                            
                            <tr>
                                <td><label for="name"> Abdul Rahman</label></td>                  
                                <td><label for="name"> Java Developer </label></td>                  
                                <td><label for="name"> abudl.rahman@abbhsoft.com</label></td>                  
                                <td><label for="name"> Service Layer implmentation and Testing</label></td>                  
                                
                            </tr>
                            <tr>
                                <td><label for="name"> Mudasir Khan </label></td>                  
                                <td><label for="name"> Java Developer</label></td>                  
                                <td><label for="name"> mir.khan@abbhsoft.com</label></td>                  
                                <td><label for="name"> Front End Design, Implementation using AJAX</label></td>                  
                                
                            </tr>
                            <tr>
                                <td><label for="name"> Sumair Mohammed</label></td>                  
                                <td><label for="name"> Java Developer</label></td>                  
                                <td><label for="name"> sumair29@gmail.com</label></td>                  
                                <td><label for="name"> Front End Design, Implementation using AJAX, Testing</label></td>                  
                                
                            </tr>
                            <tr>
                                <td><label for="name"> Amer Muqtadir</label></td>                  
                                <td><label for="name"> Java Developer</label></td>                  
                                <td><label for="name"> muqtadir.amer@abbhsoft.com</label></td>                  
                                <td><label for="name"> Database and DAO Layer Implementation</label></td>                               
                            </tr>
                            
                        </tbody>
                    </table>
                    <strong> Project Hours : 35 </strong>
                    
                </div>
                
                <!-- End of Developers -->
                
            </div>
            <div dojoType="dijit.layout.ContentPane" layoutAlign="left"
                 style="width: 15%;">
                
                <%    
                %>
            </div>
            <div dojoType="dijit.layout.ContentPane" layoutAlign="right"
                 >
                
                
                <input type="text" name="searchText" id ="key" value=""
                       dojoType="dijit.form.TextBox"
                       trim="true"
                       lowercase="true"
                       required="true"
                       promptMessage="Search String"
                       invalidMessage="Empty Text!"
                       size="40"
                       />
                <button dojoType="dijit.form.Button" type="submit"
                        iconClass="mailIconOk" onclick="search();">Search</button>
                
                <script type='text/javascript'>
                    function search() {
                    var text = "'" + $("key").value + "'";
                    faqRemoteService.search(objectEval(text), displayResult);
                    }
                    
                    function displayResult(data) {
                    
                    var ni = document.getElementById('tSpan');
                    ni.innerHTML = "";                    
                    for ( i = 0; i < data.length; i++ ) {
                    ni.innerHTML += "<br/>" + data[i].question + " &nbsp; " + data[i].author + " &nbsp; " + data[i].simpleDate;
                    var ans = data[i].answerses;
                    for ( j = 0; j < ans.length; j++ ) {
                    ni.innerHTML += "<br/> <small> " +ans[j].answer + " &nbsp; " + ans[j].author + " &nbsp; " + ans[j].simpleDate + 
                    "<button onclick='deActivateAnswer("+ ans[j].id +");' dojoType='dijit.form.Button' type='submit'>X <button> " +
                    " </small>";
                    
                    }
                    
                    ni.innerHTML += "<hr/>";
                    }
                    }            
                    
                    function deActivateAnswer(id) {
                        faqRemoteService.markAnswerUnappropriate(id, reply5);
                    }
                    reply5 = function(data)
                                    {
                                    if (data != null && typeof data == 'object') alert(dwr.util.toDescriptiveString(data, 2));
                                    else dwr.util.setValue('span5', dwr.util.toDescriptiveString(data, 1));
                                    }
                </script>
            </div>
            <div dojoType="dijit.layout.ContentPane" layoutAlign="client">
                
                
                
                
                
                <br/>
                <span id="span5"> </span>
                <div id="tSpan"> </div>
                
            </div>
        </div>       
        
    </body>
</html>