<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<portlet:actionURL name="installRemoteApp" var="installRemoteAppURL" />

<aui:form action="<%= installRemoteAppURL %>" cssClass="container-fluid container-fluid-max-xl container-view" method="post" name="fm">
	<aui:input name="mvcPath" type="hidden" value="/install_remote_app.jsp" />

	<div class="sheet sheet-lg">
		<c:if test="<%= CompanyLocalServiceUtil.getCompaniesCount(false) > 1 %>">
			<div class="alert alert-info">
				<liferay-ui:message key="installed-apps-are-available-to-all-portal-instances.-go-to-plugins-configuration-within-each-portal-instance-to-enable-disable-each-app" />
			</div>
		</c:if>

		<liferay-ui:error key="invalidURL" message="please-enter-a-valid-url" />

		<liferay-ui:success key="pluginDownloaded" message="the-plugin-was-downloaded-successfully-and-is-now-being-installed" />

		<aui:input cssClass="file-input" name="url" type="text" />

		<div class="sheet-footer">
			<aui:button type="submit" value="install" />
		</div>
	</div>
</aui:form>