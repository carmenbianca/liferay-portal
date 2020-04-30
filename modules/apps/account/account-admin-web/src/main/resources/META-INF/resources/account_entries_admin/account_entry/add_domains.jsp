<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "addDomains");
%>

<div class="modal-body">
	<clay:alert
		elementClasses="hide"
		id='<%= renderResponse.getNamespace() + "domainAlert" %>'
		message='<%= LanguageUtil.get(request, "please-enter-valid-mail-domains-separated-by-commas") %>'
		style="danger"
		title='<%= LanguageUtil.get(request, "error") %>'
	/>

	<aui:field-wrapper cssClass="form-group">
		<aui:input label="domain" name="domain" />

		<div class="form-text">
			<liferay-ui:message key="for-multiple-domains,-separate-each-domain-by-a-comma" />
		</div>
	</aui:field-wrapper>

	<aui:button-row>
		<aui:button onClick='<%= renderResponse.getNamespace() + "addDomains();" %>' primary="<%= true %>" value="save" />

		<aui:button type="cancel" />
	</aui:button-row>
</div>

<aui:script>
	function <portlet:namespace />addDomains() {
		var domainsInput = document.getElementById('<portlet:namespace />domain');

		var domains = domainsInput.value.split(',');

		// Email domain regex from aui-form-validator.js

		var pattern = new RegExp(
			'^((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?$',
			'i'
		);

		for (var i = 0; i < domains.length; i++) {
			var domain = domains[i];

			if (!pattern.test(domain.trim())) {
				var domainAlert = document.getElementById(
					'<portlet:namespace />domainAlert'
				);

				domainAlert.classList.remove('hide');

				domainsInput.focus();

				return;
			}
		}

		<portlet:namespace/>closePopup();
	}

	function <portlet:namespace/>closePopup() {
		var Util = Liferay.Util;

		var openingLiferay = Util.getOpener().Liferay;

		openingLiferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', {
			data: document.getElementById('<portlet:namespace />domain').value,
		});

		Util.getWindow().hide();
	}
</aui:script>