<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String backURL = ParamUtil.getString(request, "backURL", redirect);

LayoutsSEODisplayContext layoutsSEODisplayContext = (LayoutsSEODisplayContext)request.getAttribute(LayoutSEOWebKeys.LAYOUT_PAGE_LAYOUT_SEO_DISPLAY_CONTEXT);

if (Validator.isNull(backURL)) {
	backURL = PortalUtil.getLayoutFullURL(layoutsSEODisplayContext.getSelLayout(), themeDisplay);
}
%>

<aui:form action="<%= layoutsSEODisplayContext.getEditOpenGraphURL() %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= layoutsSEODisplayContext.getRedirectURL() %>" />
	<aui:input name="portletResource" type="hidden" value='<%= ParamUtil.getString(request, "portletResource") %>' />
	<aui:input name="groupId" type="hidden" value="<%= layoutsSEODisplayContext.getGroupId() %>" />
	<aui:input name="privateLayout" type="hidden" value="<%= layoutsSEODisplayContext.isPrivateLayout() %>" />
	<aui:input name="layoutId" type="hidden" value="<%= layoutsSEODisplayContext.getLayoutId() %>" />

	<div class="sheet sheet-lg">
		<div class="sheet-header">
			<h2 class="sheet-title"><liferay-ui:message key="custom-meta-tags" /></h2>

			<p class="text-muted">
				<liferay-ui:message key="custom-meta-tags-description" />
			</p>
		</div>

		<liferay-ui:error exception="<%= DDMFormValuesValidationException.class %>" message="field-validation-failed" />

		<liferay-ui:error exception="<%= DDMFormValuesValidationException.RequiredValue.class %>">

			<%
			DDMFormValuesValidationException.RequiredValue rv = (DDMFormValuesValidationException.RequiredValue)errorException;
			%>

			<liferay-ui:message arguments="<%= HtmlUtil.escape(rv.getFieldName()) %>" key="no-value-is-defined-for-field-x" translateArguments="<%= false %>" />
		</liferay-ui:error>

		<liferay-ddm:html
			classNameId="<%= PortalUtil.getClassNameId(com.liferay.dynamic.data.mapping.model.DDMStructure.class) %>"
			classPK="<%= layoutsSEODisplayContext.getDDMStructurePrimaryKey() %>"
			ddmFormValues="<%= layoutsSEODisplayContext.getDDMFormValues() %>"
			defaultEditLocale="<%= PortalUtil.getSiteDefaultLocale(layoutsSEODisplayContext.getGroupId()) %>"
			defaultLocale="<%= PortalUtil.getSiteDefaultLocale(layoutsSEODisplayContext.getGroupId()) %>"
			fieldsNamespace="<%= String.valueOf(layoutsSEODisplayContext.getDDMStructurePrimaryKey()) %>"
			groupId="<%= layoutsSEODisplayContext.getGroupId() %>"
			requestedLocale="<%= locale %>"
		/>

		<div class="sheet-footer">
			<aui:button primary="<%= true %>" type="submit" />

			<aui:button href="<%= backURL %>" type="cancel" />
		</div>
	</div>
</aui:form>