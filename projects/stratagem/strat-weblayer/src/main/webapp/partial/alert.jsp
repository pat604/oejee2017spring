<%@page import="com.kota.stratagem.weblayer.common.LoginAttribute"%>
<%@page import="com.kota.stratagem.weblayer.common.RegistrationAttribute"%>

<% if (request.getAttribute(LoginAttribute.ATTR_ERROR) != null) { %>

	<% String errorMessage = (String) request.getAttribute(LoginAttribute.ATTR_ERROR); %>
	<div id="alertErrorMessage">
       <div id="inner-message" class="alert alert-error">
          <button type="button" name="dismissError" class="close" data-dismiss="alert">&times;</button>
          <div class="error"><%= errorMessage %></div>
        </div>
	</div>
	
<% } %>

<% if (request.getAttribute(RegistrationAttribute.ATTR_REG_ERROR) != null) { %>

	<% String errorMessage = (String) request.getAttribute(RegistrationAttribute.ATTR_REG_ERROR); %>
	<div id="alertErrorMessage">
       <div id="inner-message" class="alert alert-error">
          <button type="button" name="dismissError" class="close" data-dismiss="alert">&times;</button>
          <div class="error"><%= errorMessage %></div>
        </div>
	</div>
	
<% } %>

<% if (request.getAttribute(RegistrationAttribute.ATTR_REG_SUCCESS) != null) { %>

	<% String successMessage = (String) request.getAttribute(RegistrationAttribute.ATTR_REG_SUCCESS); %>	
	<div id="alertSuccessMessage">
       <div id="inner-message" class="alert alert">
          <button type="button" name="dismissSuccess" class="close" data-dismiss="alert">&times;</button>
          <div class="error"><%= successMessage %></div>
        </div>
	</div>
	
<% } %>