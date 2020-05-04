<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long ddmTemplateId = ParamUtil.getLong(request, "ddmTemplateId");

DDMTemplate ddmTemplate = DDMTemplateLocalServiceUtil.fetchDDMTemplate(ddmTemplateId);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle(LanguageUtil.format(request, "copy-x", ddmTemplate.getName(locale)));
%>

<portlet:actionURL name="/journal/copy_ddm_template" var="copyDDMTemplateURL">
	<portlet:param name="mvcPath" value="/copy_ddm_template.jsp" />
</portlet:actionURL>

<liferay-frontend:edit-form
	action="<%= copyDDMTemplateURL %>"
	method="post"
	name="fm"
>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<aui:input name="ddmTemplateId" type="hidden" value="<%= ddmTemplateId %>" />

	<aui:model-context bean="<%= ddmTemplate %>" model="<%= DDMTemplate.class %>" />

	<liferay-frontend:edit-form-body>
		<liferay-ui:error exception="<%= TemplateNameException.class %>" message="please-enter-a-valid-name" />

		<liferay-frontend:fieldset-group>
			<liferay-frontend:fieldset>
				<aui:input name="name" />

				<aui:input name="description" />
			</liferay-frontend:fieldset>
		</liferay-frontend:fieldset-group>
	</liferay-frontend:edit-form-body>

	<liferay-frontend:edit-form-footer>
		<aui:button type="submit" value="copy" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>