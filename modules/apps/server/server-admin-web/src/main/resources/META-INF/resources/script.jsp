<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String language = ParamUtil.getString(renderRequest, "language", "groovy");

if (SessionMessages.contains(renderRequest, "language")) {
	language = (String)SessionMessages.get(renderRequest, "language");
}

String script = "// ### Groovy Sample ###\n\nnumber = com.liferay.portal.kernel.service.UserLocalServiceUtil.getUsersCount();\n\nout.println(number);";

if (SessionMessages.contains(renderRequest, "script")) {
	script = (String)SessionMessages.get(renderRequest, "script");
}

String scriptOutput = (String)SessionMessages.get(renderRequest, "scriptOutput");
%>

<liferay-ui:error exception="<%= ScriptingException.class %>">

	<%
	ScriptingException se = (ScriptingException)errorException;
	%>

	<pre><%= se.getMessage() %></pre>
</liferay-ui:error>

<aui:fieldset-group markupView="lexicon">
	<aui:fieldset>
		<aui:select name="language">

			<%
			for (String supportedLanguage : ScriptingUtil.getSupportedLanguages()) {
			%>

				<aui:option label="<%= TextFormatter.format(supportedLanguage, TextFormatter.J) %>" selected="<%= supportedLanguage.equals(language) %>" value="<%= supportedLanguage %>" />

			<%
			}
			%>

		</aui:select>

		<aui:input cssClass="lfr-textarea-container" name="script" resizable="<%= true %>" type="textarea" value="<%= script %>" />
	</aui:fieldset>
</aui:fieldset-group>

<c:if test="<%= Validator.isNotNull(scriptOutput) %>">
	<b><liferay-ui:message key="output" /></b>

	<pre><%= scriptOutput %></pre>
</c:if>

<aui:button-row>
	<aui:button cssClass="save-server-button" data-cmd="runScript" value="execute" />
</aui:button-row>

<aui:script>
	var <portlet:namespace />selectLanguage = document.getElementById(
		'<portlet:namespace />language'
	);
	var <portlet:namespace />textArea = document.getElementById(
		'<portlet:namespace />script'
	);

	if (<portlet:namespace />selectLanguage && <portlet:namespace />textArea) {
		<portlet:namespace />selectLanguage.addEventListener('change', function() {
			<portlet:namespace />textArea.value = '';
		});
	}
</aui:script>