<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
AssetAutoTaggerConfiguration assetAutoTaggerConfiguration = (AssetAutoTaggerConfiguration)request.getAttribute(AssetAutoTaggerConfiguration.class.getName());
%>

<c:if test="<%= assetAutoTaggerConfiguration.isAvailable() %>">
	<liferay-frontend:fieldset
		collapsible="true"
		cssClass="panel-group-flush"
		label='<%= LanguageUtil.get(request, "asset-auto-tagging") %>'
	>
		<aui:input helpMessage="asset-library-asset-auto-tagging-help" label="enable-auto-tagging-of-assets-on-this-asset-library" name="TypeSettingsProperties--assetAutoTaggingEnabled--" type="toggle-switch" value="<%= assetAutoTaggerConfiguration.isEnabled() %>" />
	</liferay-frontend:fieldset>
</c:if>