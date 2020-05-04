<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long powwowServerId = ParamUtil.getLong(request, "powwowServerId");

PowwowServer powwowServer = PowwowServerLocalServiceUtil.fetchPowwowServer(powwowServerId);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle((powwowServer != null) ? powwowServer.getName() : LanguageUtil.get(request, "new-server"));
%>

<liferay-portlet:actionURL name="updatePowwowServer" var="editURL" />

<aui:form action="<%= editURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="powwowServerId" type="hidden" value="<%= String.valueOf(powwowServerId) %>" />

	<aui:model-context bean="<%= powwowServer %>" model="<%= PowwowServer.class %>" />

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input name="name" />

			<aui:select label="provider-type" name="providerType">

				<%
				String defaultProviderType = StringPool.BLANK;

				if (powwowServer != null) {
					if (ArrayUtil.contains(PortletPropsValues.POWWOW_PROVIDER_TYPES, powwowServer.getProviderType())) {
						defaultProviderType = powwowServer.getProviderType();
					}
				}
				else if (PortletPropsValues.POWWOW_PROVIDER_TYPES.length != 0) {
					defaultProviderType = PortletPropsValues.POWWOW_PROVIDER_TYPES[0];
				}

				for (String providerType : PortletPropsValues.POWWOW_PROVIDER_TYPES) {
				%>

					<aui:option selected="<%= defaultProviderType.equals(providerType) %>" value="<%= providerType %>"><%= PowwowServiceProviderUtil.getPowwowServiceProviderName(providerType) %></aui:option>

				<%
				}
				%>

			</aui:select>

			<aui:input cssClass="optional-field" label="api-url" name="url" />

			<aui:input cssClass="optional-field" label="api-key" name="apiKey" />

			<aui:input cssClass="optional-field" name="secret" />
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button onClick="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base">
	function showProviderTypeFields() {
		A.all('.optional-field').get('parentNode').hide();

		var selectedProviderType = A.one('#<portlet:namespace />providerType option:selected').val();

		<%
		for (String providerType : PortletPropsValues.POWWOW_PROVIDER_TYPES) {
		%>

			if (selectedProviderType == '<%= providerType %>') {
				if (<%= PowwowServiceProviderUtil.isFieldURLRequired(providerType) %>) {
					A.one('#<portlet:namespace />url').get('parentNode').show();
				}

				if (<%= PowwowServiceProviderUtil.isFieldAPIKeyRequired(providerType) %>) {
					A.one('#<portlet:namespace />apiKey').get('parentNode').show();
				}

				if (<%= PowwowServiceProviderUtil.isFieldSecretRequired(providerType) %>) {
					A.one('#<portlet:namespace />secret').get('parentNode').show();
				}
			}

		<%
		}
		%>

	}

	var providerType = A.one('#<portlet:namespace />providerType');

	if (providerType) {
		providerType.on(
			'change',
			function(event) {
				A.all('.optional-field').val('');

				showProviderTypeFields();
			}
		);
	}

	showProviderTypeFields();
</aui:script>