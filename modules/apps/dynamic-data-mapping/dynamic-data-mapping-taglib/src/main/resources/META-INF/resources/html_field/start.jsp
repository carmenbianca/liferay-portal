<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html_field/init.jsp" %>

<div class="lfr-ddm-container" id="<%= randomNamespace %>">
	<c:if test="<%= ddmForm != null %>">

		<%
		Map<String, DDMFormField> ddmFormFieldsMap = ddmForm.getDDMFormFieldsMap(true);

		DDMFormField ddmFormField = ddmFormFieldsMap.get(field.getName());

		DDMFormFieldRenderer ddmFormFieldRenderer = DDMFormFieldRendererRegistryUtil.getDDMFormFieldRenderer(ddmFormField.getType());

		DDMFormFieldRenderingContext ddmFormFieldRenderingContext = new DDMFormFieldRenderingContext();

		ddmFormFieldRenderingContext.setField(field);
		ddmFormFieldRenderingContext.setHttpServletRequest(request);
		ddmFormFieldRenderingContext.setHttpServletResponse(response);
		ddmFormFieldRenderingContext.setLocale(requestedLocale);
		ddmFormFieldRenderingContext.setMode(mode);
		ddmFormFieldRenderingContext.setNamespace(fieldsNamespace);
		ddmFormFieldRenderingContext.setPortletNamespace(portletResponse.getNamespace());
		ddmFormFieldRenderingContext.setReadOnly(readOnly);
		ddmFormFieldRenderingContext.setShowEmptyFieldLabel(showEmptyFieldLabel);
		%>

		<%= ddmFormFieldRenderer.render(ddmFormField, ddmFormFieldRenderingContext) %>

		<aui:input name="<%= HtmlUtil.getAUICompatibleId(ddmFormValuesInputName) %>" type="hidden" />

		<aui:script use="liferay-ddm-form">
			Liferay.component(
				'<portlet:namespace /><%= HtmlUtil.escapeJS(fieldsNamespace) %>ddmForm',
				function() {
					return new Liferay.DDM.Form({
						container: '#<%= randomNamespace %>',
						ddmFormValuesInput:
							'#<portlet:namespace /><%= HtmlUtil.getAUICompatibleId(ddmFormValuesInputName) %>',
						definition: <%= DDMUtil.getDDMFormJSONString(ddmForm) %>,
						doAsGroupId: <%= scopeGroupId %>,
						fieldsNamespace: '<%= HtmlUtil.escapeJS(fieldsNamespace) %>',
						mode: '<%= HtmlUtil.escapeJS(mode) %>',
						p_l_id: <%= themeDisplay.getPlid() %>,
						portletNamespace: '<portlet:namespace />',
						repeatable: <%= repeatable %>,
					});
				}
			);
		</aui:script>
	</c:if>