<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
AssetAutoTaggerConfiguration assetAutoTaggerConfiguration = (AssetAutoTaggerConfiguration)request.getAttribute(AssetAutoTaggerConfiguration.class.getName());
%>

<aui:input helpMessage="site-asset-auto-tagging-help" label="enable-auto-tagging-of-assets-on-this-site" name="TypeSettingsProperties--assetAutoTaggingEnabled--" type="toggle-switch" value="<%= assetAutoTaggerConfiguration.isEnabled() %>" />