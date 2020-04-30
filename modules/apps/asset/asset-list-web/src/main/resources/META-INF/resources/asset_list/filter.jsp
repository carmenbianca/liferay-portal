<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-frontend:fieldset-group>
	<liferay-frontend:fieldset>
		<liferay-asset:asset-tags-error />

		<liferay-ui:error exception="<%= DuplicateQueryRuleException.class %>">

			<%
			DuplicateQueryRuleException dqre = (DuplicateQueryRuleException)errorException;

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

		<p><liferay-ui:message key="displayed-assets-must-match-these-rules" /></p>

		<div id="<portlet:namespace />ConditionForm"></div>

		<div>

			<%
			Map<String, Object> data = HashMapBuilder.<String, Object>put(
				"categorySelectorURL", editAssetListDisplayContext.getCategorySelectorURL()
			).put(
				"groupIds", ListUtil.toList(editAssetListDisplayContext.getReferencedModelsGroupIds())
			).put(
				"namespace", liferayPortletResponse.getNamespace()
			).put(
				"rules", editAssetListDisplayContext.getAutoFieldRulesJSONArray()
			).put(
				"tagSelectorURL", editAssetListDisplayContext.getTagSelectorURL()
			).put(
				"vocabularyIds", editAssetListDisplayContext.getVocabularyIds()
			).build();
			%>

			<react:component
				data="<%= data %>"
				module="auto_field/index"
			/>
		</div>
	</liferay-frontend:fieldset>
</liferay-frontend:fieldset-group>