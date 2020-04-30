<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String backURL = ParamUtil.getString(request, "redirect");

String actionCommandName = (String)request.getAttribute(DepotAdminWebKeys.ACTION_COMMAND_NAME);
String formDescription = (String)request.getAttribute(DepotAdminWebKeys.FORM_DESCRIPTION);
String formLabel = (String)request.getAttribute(DepotAdminWebKeys.FORM_LABEL);
String jspPath = (String)request.getAttribute(DepotAdminWebKeys.JSP_PATH);

if (Validator.isNotNull(backURL)) {
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(backURL);
}

DepotEntry depotEntry = (DepotEntry)request.getAttribute(DepotAdminWebKeys.DEPOT_ENTRY);

Group group = depotEntry.getGroup();

renderResponse.setTitle(group.getDescriptiveName(locale));
%>

<liferay-ui:success key='<%= DepotPortletKeys.DEPOT_ADMIN + "requestProcessed" %>' message="asset-library-was-added" />

<portlet:actionURL name="<%= actionCommandName %>" var="actionCommandURL" />

<aui:form action="<%= actionCommandURL %>" method="post" name="fm">
	<aui:input name="depotEntryId" type="hidden" value="<%= depotEntry.getDepotEntryId() %>" />
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />

	<div class="sheet sheet-lg">
		<div class="sheet-header">
			<h2 class="sheet-title"><%= formLabel %></h2>

			<c:if test="<%= Validator.isNotNull(formDescription) %>">
				<p><%= formDescription %></p>
			</c:if>
		</div>

		<div class="sheet-section">
			<liferay-util:include page="<%= jspPath %>" servletContext="<%= application %>" />
		</div>

		<c:if test="<%= (boolean)request.getAttribute(DepotAdminWebKeys.SHOW_CONTROLS) %>">
			<div class="sheet-footer">
				<aui:button primary="<%= true %>" type="submit" />

				<aui:button href="<%= Validator.isNotNull(backURL) ? backURL : String.valueOf(renderResponse.createRenderURL()) %>" type="cancel" />
			</div>
		</c:if>
	</div>
</aui:form>