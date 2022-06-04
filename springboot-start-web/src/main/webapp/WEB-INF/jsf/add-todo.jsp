<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">

<form:form method="post" modelAttribute="todo">
	<fieldset class="form-group">	 
		<form:label path="description" for="desc">Description:</form:label>
		<form:input path="description" type="text" id="desc"  class="form-control" required="required" />
		<form:errors path="description" cssClass="text-warning" />
	</fieldset>
	<fieldset class="form-group">	  
		<form:label path="targetDate" for="targetDate">Target Date:</form:label>
		<form:input path="targetDate" type="text" id="targetDate"  class="form-control" required="required" />
		<form:errors path="targetDate" cssClass="text-warning" />
	</fieldset>
	<button type="submit" class="btn btn-success">Add</button>
</form:form>

</div>

<%@ include file="common/footer.jspf" %>
