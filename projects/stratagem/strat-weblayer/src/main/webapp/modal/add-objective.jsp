<%@ page import="com.kota.stratagem.weblayer.common.objective.ObjectiveAttribute" %>
<%@page import="com.kota.stratagem.ejbserviceclient.domain.ObjectiveRepresentor"%>
<%@ page import="com.kota.stratagem.ejbserviceclient.domain.ObjectiveStatusRepresentor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--Modal: objective Form-->
<div class="modal fade" id="addObjective" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog cascading-modal" role="document">
        <!--Content-->
        <div class="modal-content">

            <!--Header-->
            <div class="modal-header mdb-color darken-1 white-text">
                <h4 class="title"><i class="fa fa-flag"></i>Objective</h4>
            </div>
            <!--Body-->
            <form action="ObjectiveAction" method="post">
	            <div class="modal-body">
	                <div class="md-form form-sm">
	                    <i class="fa fa-font prefix"></i>
	                    <input type="text" id="objform31" class="form-control" name="name" placeholder="Name" value="${objective.name}">
	                </div>
            	
            		<div class="md-form form-sm">
            			<i class="fa fa-exclamation prefix"></i>
               			<label>Set priority</label>
               			<br/>
                  	</div>
            	
               		<div class="md-form form-sm">
               			<c:choose>
	      			      	<c:when test = "${objective != null}">
		         				<input type="number" id="objform32" class="form-control" name="priority" 
			                    min="0" max="100" value="${objective.priority}">
			                </c:when>
			                <c:otherwise>
			                	<input type="number" id="objform32" class="form-control" name="priority" 
			                    min="0" max="100" value="10">
			                </c:otherwise>
		                </c:choose>
	                </div>
	                
					<div class="md-form form-sm">
						<i class="fa fa-lightbulb-o prefix"></i>
               			<label>Set status</label>
               			<br/>
                  	</div>
	                
	                <div class="md-form form-sm">
						<select class="form-control" id="objform33" name="status">
							<% for ( ObjectiveStatusRepresentor status : ObjectiveStatusRepresentor.values()) { %>
								<option value="<% out.print(status.name()); %>"><% out.print(status.getLabel()); %></option>
							<% } %>
						</select>
	                </div>
            	
	                <div class="md-form form-sm">
	                    <i class="fa fa-file-text prefix"></i>
	                    <textarea type="text" id="objform34" class="md-textarea" class="form-control" 
	                    name="description" placeholder="Description" value="${objective.description}"></textarea>
	                    <!-- <input type="text" id="objform32" class="form-control" name="description" placeholder="Description" value="${objective.description}"> -->
	                </div>
	            </div>
	            <!--Footer-->
	            <div class="modal-footer">
	                <button type="button" class="btn btn-outline-info mr-auto" data-dismiss="modal">
	                	Close <i class="fa fa-times-circle ml-1"></i>
	                </button>
	            	<button type="submit" name="submit" class="btn mdb-color darken-1 ml-auto">
	            		Save <i class="fa fa-save ml-1"></i>
	            	</button>
	            </div>
            </form>
        </div>
        <!--/.Content-->
    </div>
</div>
<!--Modal: Objective Form-->