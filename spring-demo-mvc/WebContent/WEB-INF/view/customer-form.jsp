<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
.error{color:red}
</style>
<title>Customer registration</title>
</head>
<body>
Fill out the form. Asterisk (*) means required

<form:form action="processForm" modelAttribute="customer">
First Name: <form:input path="firstName"/>
<br/>
Last Name(*): <form:input path="lastName"/>
<form:errors path="lastName" cssClass="error"></form:errors>
<br/>
Free Passes: <form:input path="freePasses"/>
<form:errors path="freePasses" cssClass="error"></form:errors>
<br/>
Postal Code: <form:input path="postalCode"/>
<form:errors path="postalCode" cssClass="error"></form:errors>
<br/>

<input type="submit" value="Submit"/>
</form:form>
</body>
</html>