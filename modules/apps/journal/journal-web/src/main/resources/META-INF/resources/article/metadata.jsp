<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
JournalArticle article = journalDisplayContext.getArticle();

JournalEditArticleDisplayContext journalEditArticleDisplayContext = new JournalEditArticleDisplayContext(request, liferayPortletResponse, article);
%>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="metadata"
/>

<aui:model-context bean="<%= article %>" model="<%= JournalArticle.class %>" />

<liferay-asset:asset-categories-error />

<liferay-asset:asset-tags-error />

<%
long classPK = 0;
double priority = 0;

if (article != null) {
	classPK = article.getResourcePrimKey();

	if (!article.isApproved() && (article.getVersion() != JournalArticleConstants.VERSION_DEFAULT)) {
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(JournalArticle.class.getName(), article.getPrimaryKey());

		if (assetEntry != null) {
			classPK = article.getPrimaryKey();
			priority = assetEntry.getPriority();
		}
	}
	else {
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(JournalArticle.class.getName(), article.getResourcePrimKey());

		if (assetEntry != null) {
			priority = assetEntry.getPriority();
		}
	}
}

DDMStructure ddmStructure = journalEditArticleDisplayContext.getDDMStructure();
%>

<liferay-asset:asset-categories-selector
	className="<%= JournalArticle.class.getName() %>"
	classPK="<%= classPK %>"
	classTypePK="<%= ddmStructure.getStructureId() %>"
	ignoreRequestValue="<%= journalEditArticleDisplayContext.isChangeStructure() %>"
/>

<liferay-asset:asset-tags-selector
	className="<%= JournalArticle.class.getName() %>"
	classPK="<%= classPK %>"
	ignoreRequestValue="<%= journalEditArticleDisplayContext.isChangeStructure() %>"
/>

<aui:input cssClass="form-control-sm" label="priority" name="assetPriority" type="text" value="<%= priority %>" wrapperCssClass="mb-3">
	<aui:validator name="number" />

	<aui:validator name="min">[0]</aui:validator>
</aui:input>

<c:if test="<%= CustomAttributesUtil.hasCustomAttributes(company.getCompanyId(), JournalArticle.class.getName(), classPK, null) %>">
	<liferay-expando:custom-attribute-list
		className="<%= JournalArticle.class.getName() %>"
		classPK="<%= (article != null) ? article.getPrimaryKey() : 0 %>"
		editable="<%= true %>"
		label="<%= true %>"
	/>
</c:if>