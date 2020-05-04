<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long layoutPageTemplateCollectionId = ParamUtil.getLong(request, "layoutPageTemplateCollectionId");

LayoutPageTemplateCollection layoutPageTemplateCollection = LayoutPageTemplateCollectionLocalServiceUtil.fetchLayoutPageTemplateCollection(layoutPageTemplateCollectionId);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle((layoutPageTemplateCollection != null) ? layoutPageTemplateCollection.getName() : LanguageUtil.get(request, "add-collection"));
%>

<portlet:actionURL name="/layout_page_template/edit_layout_page_template_collection" var="editLayoutPageTemplateCollectionURL">
	<portlet:param name="mvcRenderCommandName" value="/layout_page_template/edit_layout_page_template_collection" />
	<portlet:param name="tabs1" value="page-templates" />
</portlet:actionURL>

<liferay-frontend:edit-form
	action="<%= editLayoutPageTemplateCollectionURL %>"
	name="fm"
>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="layoutPageTemplateCollectionId" type="hidden" value="<%= layoutPageTemplateCollectionId %>" />

	<liferay-frontend:edit-form-body>
		<liferay-ui:error exception="<%= DuplicateLayoutPageTemplateCollectionException.class %>" message="please-enter-a-unique-name" />
		<liferay-ui:error exception="<%= LayoutPageTemplateCollectionNameException.class %>" message="please-enter-a-valid-name" />

		<aui:model-context bean="<%= layoutPageTemplateCollection %>" model="<%= LayoutPageTemplateCollection.class %>" />

		<liferay-frontend:fieldset-group>
			<liferay-frontend:fieldset>
				<aui:input autoFocus="<%= true %>" label="name" name="name" placeholder="name" />

				<aui:input name="description" placeholder="description" />
			</liferay-frontend:fieldset>
		</liferay-frontend:fieldset-group>
	</liferay-frontend:edit-form-body>

	<liferay-frontend:edit-form-footer>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>