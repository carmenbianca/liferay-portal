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
%>

<aui:field-wrapper helpMessage='<%= LanguageUtil.get(resourceBundle, "terms-of-use-web-content-help") %>' label='<%= LanguageUtil.get(resourceBundle, "terms-of-use-web-content") %>'>
	<aui:fieldset>
		<aui:input label='<%= LanguageUtil.get(resourceBundle, "group-id") %>' name='<%= "settings--" + JournalServiceConfigurationKeys.TERMS_OF_USE_JOURNAL_ARTICLE_GROUP_ID + "--" %>' type="text" value="<%= termsOfUseGroupId %>" />

		<aui:input label='<%= LanguageUtil.get(resourceBundle, "article-id") %>' name='<%= "settings--" + JournalServiceConfigurationKeys.TERMS_OF_USE_JOURNAL_ARTICLE_ID + "--" %>' type="text" value="<%= termsOfUseArticleId %>" />
	</aui:fieldset>
</aui:field-wrapper>