<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/liferay/init.jsp" %>

<%
String languageId = LanguageUtil.getLanguageId(request);

Locale locale = LocaleUtil.fromLanguageId(languageId);
%>

AUI.add(
	'portal-available-languages',
	function(A) {
		var available = {};

		var direction = {};

		<%
		for (Locale curLocale : LanguageUtil.getAvailableLocales()) {
			String selLanguageId = LocaleUtil.toLanguageId(curLocale);
		%>

			available['<%= selLanguageId %>'] = '<%= curLocale.getDisplayName(locale) %>';
			direction['<%= selLanguageId %>'] = '<%= LanguageUtil.get(curLocale, "lang.dir") %>';

		<%
		}
		%>

		Liferay.Language.available = available;
		Liferay.Language.direction = direction;
	},
	'',
	{
		requires: ['liferay-language']
	}
);