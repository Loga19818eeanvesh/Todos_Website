<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<div style="color:red;">${errorMessage}</div>
	<form method="post">
		<fieldset class="form-group">
			<label for="name">Name:</label><br>
			<input type="text" id="name" name="name" required="required"><br>
		</fieldset>
		<fieldset class="form-group">
			<label for="password">Password:</label><br>
			<input type="password" id="password" name="password" required="required"><br>
		</fieldset>
		<button type="submit" class="btn btn-success">Login</button>
	</form>
</div>
<%@ include file="common/footer.jspf" %>
