<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long termsOfUseGroupId = PrefsPropsUtil.getLong(themeDisplay.getCompanyId(), JournalServiceConfigurationKeys.TERMS_OF_USE_JOURNAL_ARTICLE_GROUP_ID, JournalServiceConfigurationValues.TERMS_OF_USE_JOURNAL_ARTICLE_GROUP_ID);
String termsOfUseArticleId = PrefsPropsUtil.getString(themeDisplay.getCompanyId(), JournalServiceConfigurationKeys.TERMS_OF_USE_JOURNAL_ARTICLE_ID, JournalServiceConfigurationValues.TERMS_OF_USE_JOURNAL_ARTICLE_ID);

JournalArticle journalArticle = null;

if ((termsOfUseGroupId > 0) && Validator.isNotNull(termsOfUseArticleId)) {
	journalArticle = JournalArticleLocalServiceUtil.fetchArticle(termsOfUseGroupId, termsOfUseArticleId);
}
%>

<c:choose>
	<c:when test="<%= journalArticle != null %>">
		<liferay-asset:asset-display
			className="<%= JournalArticle.class.getName() %>"
			classPK="<%= journalArticle.getResourcePrimKey() %>"
			template="<%= AssetRenderer.TEMPLATE_FULL_CONTENT %>"
		/>
	</c:when>
	<c:otherwise>
		<liferay-util:include page="/html/portal/terms_of_use_default.jsp" />
	</c:otherwise>
</c:choose>