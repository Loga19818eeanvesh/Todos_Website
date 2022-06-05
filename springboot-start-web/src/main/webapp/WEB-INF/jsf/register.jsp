<%@ include file="common/header.jspf" %>
<div class="container">
	<div style="color:red;">${errorMessage}</div>
	<form:form method="post" modelAttribute="user">
		<form:hidden path="active" id="active" />
		<form:hidden path="roles" id="roles" />
		<fieldset class="form-group">	 
		<form:label path="name" for="name">Name:</form:label>
			<form:input path="name" type="text" id="name"  class="form-control" required="required" />
			<form:errors path="name" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">	 
		<form:label path="userName" for="username">UserName:</form:label>
			<form:input path="userName" type="text" id="username"  class="form-control" required="required" />
			<form:errors path="userName" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">	 
		<form:label path="password" for="password">Password:</form:label>
			<form:input path="password" type="text" id="password"  class="form-control" required="required" />
			<form:errors path="password" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success">Register</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>
