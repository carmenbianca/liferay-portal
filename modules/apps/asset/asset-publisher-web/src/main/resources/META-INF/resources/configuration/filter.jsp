<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<aui:fieldset label="displayed-assets-must-match-these-rules" markupView="lexicon">
	<liferay-asset:asset-tags-error />

	<%
	DuplicateQueryRuleException dqre = null;
	%>

	<liferay-ui:error exception="<%= DuplicateQueryRuleException.class %>">

		<%
		dqre = (DuplicateQueryRuleException)errorException;

		String name = "categories";

		if (Objects.equals(dqre.getName(), "assetTags")) {
			name = "tags";
		}
		else if (Objects.equals(dqre.getName(), "keywords")) {
			name = "keywords";
		}
		%>

		<liferay-util:buffer
			var="messageArgument"
		>
			<em>(<liferay-ui:message key='<%= dqre.isContains() ? "contains" : "does-not-contain" %>' /> - <liferay-ui:message key='<%= dqre.isAndOperator() ? "all" : "any" %>' /> - <liferay-ui:message key="<%= name %>" />)</em>
		</liferay-util:buffer>

		<liferay-ui:message arguments="<%= messageArgument %>" key="only-one-rule-with-the-combination-x-is-supported" translateArguments="<%= false %>" />
	</liferay-ui:error>
</aui:fieldset>

<div id="<portlet:namespace />ConditionForm"></div>

<div>

	<%
	Map<String, Object> data = HashMapBuilder.<String, Object>put(
		"categorySelectorURL", assetPublisherDisplayContext.getCategorySelectorURL()
	).put(
		"groupIds", ListUtil.toList(assetPublisherDisplayContext.getReferencedModelsGroupIds())
	).put(
		"id", "autofield"
	).put(
		"namespace", liferayPortletResponse.getNamespace()
	).put(
		"pathThemeImages", themeDisplay.getPathThemeImages()
	).put(
		"rules", assetPublisherDisplayContext.getAutoFieldRulesJSONArray()
	).put(
		"tagSelectorURL", assetPublisherDisplayContext.getTagSelectorURL()
	).put(
		"vocabularyIds", assetPublisherDisplayContext.getVocabularyIds()
	).build();
	%>

	<react:component
		data="<%= data %>"
		module="auto_field/index"
	/>
</div>