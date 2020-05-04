<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
%>

<portlet:actionURL name="updateArchivedSetup" var="updateArchivedSetupURL">
	<portlet:param name="mvcPath" value="/edit_configuration_templates.jsp" />
	<portlet:param name="portletConfiguration" value="<%= Boolean.TRUE.toString() %>" />
</portlet:actionURL>

<div class="portlet-configuration-add-template">
	<aui:form action="<%= updateArchivedSetupURL %>" cssClass="form" method="post" name="fm">
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="portletResource" type="hidden" value="<%= portletResource %>" />

		<div class="portlet-configuration-body-content">
			<div class="container-fluid-1280">
				<liferay-ui:error exception="<%= PortletItemNameException.class %>" message="please-enter-a-valid-setup-name" />

				<aui:fieldset-group markupView="lexicon">
					<aui:fieldset>

						<%
						String name = StringPool.BLANK;

						boolean useCustomTitle = GetterUtil.getBoolean(portletPreferences.getValue("portletSetupUseCustomTitle", null));

						if (useCustomTitle) {
							name = PortletConfigurationUtil.getPortletTitle(portletPreferences, LocaleUtil.toLanguageId(themeDisplay.getSiteDefaultLocale()));
						}
						%>

						<aui:input name="name" placeholder="name" required="<%= true %>" type="text" value="<%= name %>">
							<aui:validator name="maxLength">75</aui:validator>
						</aui:input>
					</aui:fieldset>
				</aui:fieldset-group>
			</div>
		</div>

		<aui:button-row>
			<aui:button type="submit" />

			<aui:button href="<%= redirect %>" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>