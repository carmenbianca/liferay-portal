<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/action/init.jsp" %>

<%
boolean ajax = GetterUtil.getBoolean(request.getParameter("ajax"));

String url = GetterUtil.getString(typeSettingsProperties.get("url"));
%>

<aui:input cssClass="lfr-input-text-container" name="url" type="text" value="<%= url %>">
	<aui:validator name="required" />
</aui:input>

<c:if test="<%= ajax %>">
	<aui:script use="liferay-form">
		var form = Liferay.Form.get('<portlet:namespace />fm');

		if (form) {
			var rules = form.formValidator.get('rules');

			var fieldName = '<portlet:namespace />url';

			if (!(fieldName in rules)) {
				rules[fieldName] = {
					custom: false,
					required: true,
				};
			}
		}
	</aui:script>
</c:if>