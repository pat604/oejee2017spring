<%@ page import="hu.smiklos.stmm.web.common.CreditCardAttributes" %>
<%@ page import="hu.smiklos.stmm.web.common.Page" %>
<%@ page import="hu.smiklos.stmm.pers.entity.AppUser" %>
<%@ page import="hu.smiklos.stmm.ejb.common.Errors" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="hu.smiklos.stmm.ejb.domain.CreditCard.CreditCardStub" %>
<%@ page import="hu.smiklos.stmm.ejb.uribuilder.UriBuilder" %>
<%@ page import="hu.smiklos.stmm.web.common.CreditCardAction" %>
<%
    Errors errors = new Errors();
    if (request.getAttribute(CreditCardAttributes.ATTR_ERROR) != null) {
        errors = (Errors) request.getAttribute(CreditCardAttributes.ATTR_ERROR);
    }
    CreditCardStub cardStub = new CreditCardStub();
    if(request.getAttribute(CreditCardAttributes.HAS_CARD) != null) {
        cardStub = (CreditCardStub)request.getAttribute(CreditCardAttributes.CARD_STUB);
    }
%>
<% if (errors.hasError()) {%>
<div class="row">
    <div class="col-md-6 col-md-offset-3 vcenter">
        <div id="error-panel" class="panel panel-danger">
            <div class="panel-heading">
                <h3 class="panel-title">Credit card error!</h3>
            </div>
            <div class="panel-body">
                <%
                    Iterator it = errors.getErrorList().entrySet().iterator();
                    out.println("<ul>");
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry) it.next();
                        out.println("<li><a href='#" + pair.getKey() + "'>" + pair.getValue() + "</a></li>");
                        it.remove(); // avoids a ConcurrentModificationException
                    }
                    out.println("</ul>");

                %>
            </div>
        </div>
    </div>
</div>
<% } %>
<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Credit card</h3>
            <% if(cardStub.getCreditCardId() != null) { %>
                <a href="<%= UriBuilder.getUrl(Page.CREDIT_CARD.getUrl(),CreditCardAction.CONFIRM_DELETE_CREDITCARD) %>" class="btn btn-danger pull-right" role="button">Delete card</a>
                <div class="clearfix"></div>
            <% } %>
        </div>
        <div class="panel-body">
            <form method="post" action="<%= Page.CREDIT_CARD.getUrl() %>" class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-3 control-label" for="<%=CreditCardStub.ATTR_CARD_HOLDER_NAME%>">Name on
                        Card</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="<%=CreditCardStub.ATTR_CARD_HOLDER_NAME%>"
                               id="<%=CreditCardStub.ATTR_CARD_HOLDER_NAME%>"
                               placeholder="Card Holder's Name" value="<%= cardStub.getCreditcard_card_holder_name() != null ? cardStub.getCreditcard_card_holder_name() : ""  %>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label" for="<%= CreditCardStub.ATTR_CARD_NUMBER %>">Card
                        Number</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="<%= CreditCardStub.ATTR_CARD_NUMBER %>"
                               id="<%= CreditCardStub.ATTR_CARD_NUMBER %>"
                               placeholder="Debit/Credit Card Number"
                         value="<%= cardStub.getCard_number() != null ? cardStub.getCard_number() : "" %>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label" for="<%= CreditCardStub.ATTR_CARD_EXPIRY_MONTH %>">Expiration
                        Date</label>
                    <div class="col-sm-9">
                        <div class="row">
                            <div class="col-xs-3">
                                <select class="form-control col-sm-2"
                                        name="<%= CreditCardStub.ATTR_CARD_EXPIRY_MONTH %>"
                                        id="<%= CreditCardStub.ATTR_CARD_EXPIRY_MONTH %>">
                                    <% if(cardStub.getCreditcard_expiry_month() != null) { %>
                                    <option value="01" <%= cardStub.getCreditcard_expiry_month().equals("01")? "selected": "" %>>Jan (01)</option>
                                    <option value="02" <%= cardStub.getCreditcard_expiry_month().equals("02")? "selected": "" %>>Feb (02)</option>
                                    <option value="03" <%= cardStub.getCreditcard_expiry_month().equals("03")? "selected": "" %>>Mar (03)</option>
                                    <option value="04" <%= cardStub.getCreditcard_expiry_month().equals("04")? "selected": "" %>>Apr (04)</option>
                                    <option value="05" <%= cardStub.getCreditcard_expiry_month().equals("05")? "selected": "" %>>May (05)</option>
                                    <option value="06" <%= cardStub.getCreditcard_expiry_month().equals("06")? "selected": "" %>>June (06)</option>
                                    <option value="07" <%= cardStub.getCreditcard_expiry_month().equals("07")? "selected": "" %>>July (07)</option>
                                    <option value="08" <%= cardStub.getCreditcard_expiry_month().equals("08")? "selected": "" %>>Aug (08)</option>
                                    <option value="09" <%= cardStub.getCreditcard_expiry_month().equals("09")? "selected": "" %>>Sep (09)</option>
                                    <option value="10" <%= cardStub.getCreditcard_expiry_month().equals("10")? "selected": "" %>>Oct (10)</option>
                                    <option value="11" <%= cardStub.getCreditcard_expiry_month().equals("11")? "selected": "" %>>Nov (11)</option>
                                    <option value="12" <%= cardStub.getCreditcard_expiry_month().equals("12")? "selected": "" %>>Dec (12)</option>
                                    <% } else { %>
                                    <option value="01" >Jan (01)</option>
                                    <option value="02" >Feb (02)</option>
                                    <option value="03" >Mar (03)</option>
                                    <option value="04" >Apr (04)</option>
                                    <option value="05" >May (05)</option>
                                    <option value="06" >June (06)</option>
                                    <option value="07" >July (07)</option>
                                    <option value="08" >Aug (08)</option>
                                    <option value="09" >Sep (09)</option>
                                    <option value="10" >Oct (10)</option>
                                    <option value="11" >Nov (11)</option>
                                    <option value="12" >Dec (12)</option>
                                    <% } %>
                                </select>
                            </div>
                            <div class="col-xs-3">
                                <select class="form-control" name="<%= CreditCardStub.ATTR_CARD_EXPIRY_YEAR %>">
                                    <% if(cardStub.getCreditcard_expiry_year() != null) { %>
                                    <option value="17" <%= cardStub.getCreditcard_expiry_year().equals("17")? "selected": "" %>>2017</option>
                                    <option value="18" <%= cardStub.getCreditcard_expiry_year().equals("18")? "selected": "" %>>2018</option>
                                    <option value="19" <%= cardStub.getCreditcard_expiry_year().equals("19")? "selected": "" %>>2019</option>
                                    <option value="20" <%= cardStub.getCreditcard_expiry_year().equals("20")? "selected": "" %>>2020</option>
                                    <option value="21" <%= cardStub.getCreditcard_expiry_year().equals("21")? "selected": "" %>>2021</option>
                                    <option value="22" <%= cardStub.getCreditcard_expiry_year().equals("22")? "selected": "" %>>2022</option>
                                    <option value="23" <%= cardStub.getCreditcard_expiry_year().equals("23")? "selected": "" %>>2023</option>
                                    <% } else { %>
                                    <option value="17" >2017</option>
                                    <option value="18" >2018</option>
                                    <option value="19" >2019</option>
                                    <option value="20" >2020</option>
                                    <option value="21">2021</option>
                                    <option value="22" >2022</option>
                                    <option value="23" >2023</option>
                                    <% } %>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-success">Save My Card</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>