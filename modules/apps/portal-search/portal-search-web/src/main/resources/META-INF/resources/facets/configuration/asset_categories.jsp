<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
SearchFacet searchFacet = (SearchFacet)request.getAttribute("facet_configuration.jsp-searchFacet");

JSONObject dataJSONObject = searchFacet.getData();

String displayStyle = dataJSONObject.getString("displayStyle", "cloud");
int frequencyThreshold = dataJSONObject.getInt("frequencyThreshold");
int maxTerms = dataJSONObject.getInt("maxTerms", 10);
boolean showAssetCount = dataJSONObject.getBoolean("showAssetCount", true);
%>

<aui:select label="display-style" name='<%= searchFacet.getClassName() + "displayStyleFacet" %>'>
	<aui:option label="cloud" selected='<%= displayStyle.equals("cloud") %>' />
	<aui:option label="list" selected='<%= displayStyle.equals("list") %>' />
</aui:select>

<aui:input label="frequency-threshold" name='<%= searchFacet.getClassName() + "frequencyThreshold" %>' value="<%= frequencyThreshold %>" />

<aui:input label="max-terms" name='<%= searchFacet.getClassName() + "maxTerms" %>' value="<%= maxTerms %>" />

<aui:input label="show-asset-count" name='<%= searchFacet.getClassName() + "showAssetCount" %>' type="checkbox" value="<%= showAssetCount %>" />