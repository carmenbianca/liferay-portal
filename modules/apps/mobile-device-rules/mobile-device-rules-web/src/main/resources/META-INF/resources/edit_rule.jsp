<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

MDRRule rule = (MDRRule)renderRequest.getAttribute(MDRWebKeys.MOBILE_DEVICE_RULES_RULE);

long ruleId = BeanParamUtil.getLong(rule, request, "ruleId");

String type = (String)renderRequest.getAttribute(MDRWebKeys.MOBILE_DEVICE_RULES_RULE_TYPE);
String editorJSP = (String)renderRequest.getAttribute(MDRWebKeys.MOBILE_DEVICE_RULES_RULE_EDITOR_JSP);

MDRRuleGroup ruleGroup = (MDRRuleGroup)renderRequest.getAttribute(MDRWebKeys.MOBILE_DEVICE_RULES_RULE_GROUP);

long ruleGroupId = BeanParamUtil.getLong(ruleGroup, request, "ruleGroupId");

String title = StringPool.BLANK;

if (ruleGroup != null) {
	title = LanguageUtil.format(resourceBundle, "new-classification-rule-for-x", ruleGroup.getName(locale), false);

	if (rule != null) {
		title = rule.getName(locale) + " (" + ruleGroup.getName(locale) + ")";
	}
}

Collection<String> ruleHandlerTypes = RuleGroupProcessorUtil.getRuleHandlerTypes();

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle(title);
%>

<portlet:actionURL name="/mobile_device_rules/edit_rule" var="editRuleURL">
	<portlet:param name="mvcRenderCommandName" value="/mobile_device_rules/edit_rule" />
</portlet:actionURL>

<aui:form action="<%= editRuleURL %>" cssClass="container-fluid-1280" enctype="multipart/form-data" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= (rule == null) ? Constants.ADD : Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="ruleGroupId" type="hidden" value="<%= ruleGroupId %>" />
	<aui:input name="ruleId" type="hidden" value="<%= ruleId %>" />

	<liferay-ui:error exception="<%= NoSuchRuleException.class %>" message="rule-does-not-exist" />
	<liferay-ui:error exception="<%= NoSuchRuleGroupException.class %>" message="device-family-does-not-exist" />
	<liferay-ui:error exception="<%= UnknownRuleHandlerException.class %>" message="please-select-a-rule-type" />

	<aui:model-context bean="<%= rule %>" model="<%= MDRRule.class %>" />

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<c:if test="<%= rule == null %>">
				<p class="text-default">
					<liferay-ui:message key="classification-rule-help" />
				</p>
			</c:if>

			<aui:input name="name" placeholder="name" />

			<aui:input name="description" placeholder="description" />

			<c:choose>
				<c:when test="<%= ruleHandlerTypes.size() == 1 %>">

					<%
					String ruleHandlerType = ruleHandlerTypes.iterator().next();
					%>

					<aui:input name="type" type="hidden" value="<%= ruleHandlerType %>" />
				</c:when>
				<c:otherwise>
					<aui:select changesContext="<%= true %>" name="type" showEmptyOption="<%= true %>">

						<%
						for (String ruleHandlerType : ruleHandlerTypes) {
						%>

							<aui:option label="<%= ruleHandlerType %>" selected="<%= type.equals(ruleHandlerType) %>" />

						<%
						}
						%>

					</aui:select>
				</c:otherwise>
			</c:choose>
		</aui:fieldset>

		<div id="<%= renderResponse.getNamespace() %>typeSettings">
			<c:if test="<%= Validator.isNotNull(editorJSP) %>">
				<liferay-util:include page="<%= editorJSP %>" servletContext="<%= application %>" />
			</c:if>
		</div>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button href="<%= redirect %>" value="cancel" />
	</aui:button-row>
</aui:form>

<portlet:resourceURL id="/mobile_device_rules/edit_rule" var="editorURL" />

<aui:script sandbox="<%= true %>">
	var typeNode = document.getElementById('<portlet:namespace />type');
	var typeSettingsContainer = document.getElementById(
		'<portlet:namespace />typeSettings'
	);

	if (typeNode && typeSettingsContainer) {
		var loadTypeFields = function() {
			Liferay.Util.fetch(
				'<%= editorURL %>' +
					'&<portlet:namespace />type=' +
					typeNode.value +
					'&<portlet:namespace />type=' +
					<%= ruleId %>
			)
				.then(function(response) {
					return response.text();
				})
				.then(function(response) {
					typeSettingsContainer.innerHTML = response;
				});
		};

		<c:choose>
			<c:when test="<%= ruleHandlerTypes.size() == 1 %>">
				loadTypeFields();
			</c:when>
			<c:otherwise>
				if (typeNode) {
					typeNode.addEventListener('change', loadTypeFields);
				}
			</c:otherwise>
		</c:choose>
	}
</aui:script>