<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/admin/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion = ddmFormAdminDisplayContext.getDDMFormInstanceRecordVersion();

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

String title = ParamUtil.getString(request, "title");

renderResponse.setTitle(GetterUtil.get(title, LanguageUtil.get(request, "view-form")));
%>

<div class="portlet-forms">
	<div class="ddm-form-basic-info ddm-form-success-page">
		<div class="container-fluid-1280">
			<h1 class="ddm-form-name"><%= ddmFormAdminDisplayContext.getFormName() %></h1>

			<h5 class="ddm-form-description"><%= ddmFormAdminDisplayContext.getFormDescription() %></h5>
		</div>
	</div>
</div>

<div class="container-fluid-1280 ddm-form-builder-app editing-form-entry">
	<portlet:actionURL name="addFormInstanceRecord" var="editFormInstanceRecordActionURL" />

	<aui:form action="<%= editFormInstanceRecordActionURL %>" data-DDMFormInstanceId="<%= ddmFormInstanceRecordVersion.getFormInstanceId() %>" data-senna-off="true" method="post" name="fm">
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="formInstanceRecordId" type="hidden" value="<%= ddmFormInstanceRecordVersion.getFormInstanceRecordId() %>" />
		<aui:input name="formInstanceId" type="hidden" value="<%= ddmFormInstanceRecordVersion.getFormInstanceId() %>" />

		<%= ddmFormAdminDisplayContext.getDDMFormHTML(renderRequest) %>
	</aui:form>
</div>