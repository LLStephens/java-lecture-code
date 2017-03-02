	<!DOCTYPE html>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.techelevator.Person"%>
<html>
	<head>
		<title>JSP Expression Language Lecture Notes</title>
		<style>
			b {
				color: red;
				font-weight: normal;
			}
			
			td {
				border: 1px solid black;
				padding: .5em;
			}
			
			th {
				border: 1px solid black;
				padding: .5em;
			}
		</style>
	</head>
	<body>
		
		<h2>Identifiers and Scope</h2>
		<p>Every JSP EL variable is stored in one of four scopes: page, request, session, or application.
		     We will only use the first three.</p>
		<%
			// page scoped variables come from the JSP pageContext object 
			pageContext.setAttribute("myPageVar", "Larry");
		
			// request scoped variables come from the JSP request object (HttpServletRequest)
			request.setAttribute("myRequestVar", "Curly");
			
			// session scoped variables come from the JSP session object (HttpSession)
			session.setAttribute("mySessionVar", "Moe");
		%>
		
		<ul>
			<li>Value of <em>pageScope.myPageVar</em> is: <b>${pageScope.myPageVar}</b></li>
			<li>Value of <em>requestScope.myRequestVar</em> is: <b>${requestScope.myRequestVar}</b></li>
			<li>Value of <em>sessionScope.mySessionVar</em> is: <b>${sessionScope.mySessionVar}</b></li>
		</ul>
		
		<p>Identifiers can also be used within JSP EL expressions without specifying a scope.  In this case, all of the scopes
		are searched for the identifier</p>
		
		<ul>
			<li>Value of <em>myPageVar</em> is: <b>${myPageVar}</b></li>
			<li>Value of <em>myRequestVar</em> is: <b>${myRequestVar}</b></li>
			<li>Value of <em>mySessionVar</em> is: <b>${mySessionVar}</b></li>
		</ul>
		
		<p>When searching the various scopes for an identifier, they are searched in the following order:</p>
		<ol>
			<li>pageScope</li>
			<li>requestScope</li>
			<li>sessionScope</li>
		</ol>
		
		<%
			session.setAttribute("ambiguousReference", "ambiguousReference is in session scope");
			request.setAttribute("ambiguousReference", "ambiguousReference is in request scope");
		%>
		
		<p>So, for instance, if an identifier appears in both requestScope and sessionScope, the requestScope identifier 
		   takes precedence when the identifier is referenced without an scope qualifier</p>
		   
		<ul>
			<li>Value of <em>requestScope.ambiguousReference</em> is: <b>${requestScope.ambiguousReference}</b></li>
			<li>Value of <em>sessionScope.ambiguousReference</em> is: <b>${sessionScope.ambiguousReference}</b></li>
			<li>Value of <em>ambiguousReference</em> is: <b>${ambiguousReference}</b></li>
		</ul>
		
		<h2>JavaBeans and Property Access</h2>
		<% 
			Person johnDoe = new Person("John", "Doe", 24);
			pageContext.setAttribute("thePerson", johnDoe);
		%>
		<p><b>${thePerson.firstName} ${thePerson.lastName}</b> is <b>${thePerson.age}</b> years old.</p>
		<p><b>${thePerson.firstName} ${thePerson.lastName}</b> is an adult.  (True or False?)</p>
		<p><strong>Answer: </strong><b>${thePerson.adult}</b></p>
		
		<h2>Arrays, Lists, and Maps</h2>
		<%
			String[] stringArray = new String[] { "Three", "Blind", "Mice" };
			List<String> stringList = new ArrayList<>();
			stringList.add("Red");
			stringList.add("Yellow");
			stringList.add("Green");
			pageContext.setAttribute("stringArray", stringArray);
			pageContext.setAttribute("stringList", stringList);
		%>
		<p>Array elements are referenced in JSP EL in the same way as Java.  However, one difference
		   is that Lists can also be referenced using the same syntax as arrays</p>
		<ul>
			<li><em>stringArray[1]</em> is <b>${stringArray[1]}</b></li>
			<li><em>stringList[2]</em> is <b>${stringList[2]}</b></li>
		</ul> 
		
		<p>Map elements can be accessed using the same syntax as JavaBeans object attributes.  The key name
	       is used after the dot operator in the same way a property name is used with a JavaBean. </p>
	    <%
	    	Map<String, String> cars = new HashMap<>();
	    	cars.put("Mustang", "Ford");
	    	cars.put("Focus", "Ford");
	    	cars.put("Accord", "Honda");
	    	cars.put("Camry", "Toyota");
	    	pageContext.setAttribute("model2Manufacturer", cars);
	    %>
	    <p>The Mustang is made by <b>${model2Manufacturer.Mustang}</b>.</p>
	    <p>The Camry is made by <b>${model2Manufacturer.Camry}</b>.</p>
	       
	</body>
</html>