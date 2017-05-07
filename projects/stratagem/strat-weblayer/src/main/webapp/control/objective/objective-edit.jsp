<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.kota.stratagem.weblayer.common.objective.ObjectiveAttribute" %>
<%@page import="com.kota.stratagem.ejbserviceclient.domain.ObjectiveRepresentor"%>
<%@ page import="com.kota.stratagem.ejbserviceclient.domain.ObjectiveStatusRepresentor" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="../../header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../../partial/navbar-fill.jsp"></jsp:include>
	<jsp:useBean id="objective" class="com.kota.stratagem.ejbserviceclient.domain.ObjectiveRepresentor" scope="request" />
	<br/><br/><br/><br/><br/>
	
	<div class="container">
	
		<div class="card card-cascade narrower mb-r">
	        <div class="admin-panel info-admin-panel">
	            <!--Card heading-->
	            <div class="card-header mdb-color darken-1 white-text">
	                <h5>Edit Objective</h5>
	            </div>
	            <!--/Card heading-->
	            <!--Card content-->
	            <div class="card-block">
	                <!-- Edit Form -->
	                <form action="ObjectiveAction" method="post">
	                	<c:if test="${requestScope.objective.getId() != -1}"><input type="hidden" name="id" value="${objective.id}" /></c:if>
	                    <!--First row-->
	                    <div class="row">
	                        <!--First column-->
	                        <div class="col-md-6">
	                        	<div class="md-form form-sm">
			               			<label>The name of the Objective</label><br/>
                  				</div>
	                            <div class="md-form">
	                                <input type="text" id="form1" class="form-control validate" name="name" placeholder="The name of the Ovjective" value="${objective.name}">
	                            </div>
	                        </div>
	                    </div>
	                    <!--/.First row-->
	                    <!--Second row-->
	                    <div class="row">
	                        <!--First column-->
	                        <div class="col-md-6">
	                        	<div class="md-form form-sm">
			               			<label>The priority of the Objective</label><br/>
                  				</div>
	                            <div class="md-form">
	                                <input type="text" name="priority" id="form81" class="form-control validate" value="${objective.priority}">
	                            </div>
	                        </div>
	                        <!--Second column-->
	                        <div class="col-md-6">
								<div class="md-form form-sm">
			               			<label>The current status of the Objective</label><br/>
                  				</div>
	                            <div class="md-form">
                       				<select class="form-control" id="form89" name="status">
										<% for ( ObjectiveStatusRepresentor status : ObjectiveStatusRepresentor.values()) { %>
											<option value="<% out.print(status.name()); %>" <% out.print( status == objective.getStatus() ? "selected=\"selected\"" : "" ); %> ><% out.print(status.getLabel()); %></option>
										<% } %>
									</select>
	                            </div>
	                        </div>
	                    </div>
	                    <!--/.Second row-->
	                    <!--Third row-->
	                    <div class="row">
	                        <!--First column-->
	                        <div class="col-md-12">
	                        	<div class="md-form form-sm">
			               			<label>The description of the Objective</label><br/>
                  				</div>
	                            <div class="md-form">
	                                <textarea type="text" id="form78" class="md-textarea" name="description" value="${objective.description}"></textarea>
	                            </div>
	                        </div>
	                    </div>
	                    <!--/.Third row-->
	                    <!-- Fourth row -->
	                    <div class="row">
	                        <div class="col-md-12 text-center">
								<button type="submit" name="submit" class="btn mdb-color darken-1 ml-auto">
	            					Update Objective <i class="fa fa-save ml-1"></i>
	            				</button>
	                        </div>
	                    </div>
	                    <!-- /.Fourth row -->
	                </form>
	                <!-- Edit Form -->
	            </div>
	            <!--/.Card content-->
	        </div>
	    </div>
	</div>
	
	<jsp:include page="../../partial/copyright.jsp"></jsp:include>
	<jsp:include page="../../partial/wow.jsp"></jsp:include>
	
</body>
</html>