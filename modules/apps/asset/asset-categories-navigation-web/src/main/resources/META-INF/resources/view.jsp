<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Map<String, Object> contextObjects = HashMapBuilder.<String, Object>put(
	"assetCategoriesNavigationDisplayContext", assetCategoriesNavigationDisplayContext
).build();
%>

<liferay-ddm:template-renderer
	className="<%= AssetCategory.class.getName() %>"
	contextObjects="<%= contextObjects %>"
	displayStyle="<%= assetCategoriesNavigationPortletInstanceConfiguration.displayStyle() %>"
	displayStyleGroupId="<%= assetCategoriesNavigationDisplayContext.getDisplayStyleGroupId() %>"
	entries="<%= assetCategoriesNavigationDisplayContext.getDDMTemplateAssetVocabularies() %>"
>
	<c:choose>
		<c:when test="<%= assetCategoriesNavigationPortletInstanceConfiguration.allAssetVocabularies() %>">
			<liferay-asset:asset-categories-navigation
				hidePortletWhenEmpty="<%= true %>"
			/>
		</c:when>
		<c:otherwise>
			<liferay-asset:asset-categories-navigation
				hidePortletWhenEmpty="<%= true %>"
				vocabularyIds="<%= assetCategoriesNavigationDisplayContext.getAssetVocabularyIds() %>"
			/>
		</c:otherwise>
	</c:choose>
</liferay-ddm:template-renderer>