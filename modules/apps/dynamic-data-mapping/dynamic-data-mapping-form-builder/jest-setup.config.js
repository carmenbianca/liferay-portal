/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

window.themeDisplay = {
	getDefaultLanguageId: () => 'en_US',
	getLanguageId: () => 'en_US',
	getPathContext: () => '/',
	getPathThemeImages: () => 'http://localhost:8080/o/admin-theme/images',
	getScopeGroupId: () => '20126',
};

window.Liferay = {
	...(window.Liferay || {}),
	ThemeDisplay: window.themeDisplay,
};
