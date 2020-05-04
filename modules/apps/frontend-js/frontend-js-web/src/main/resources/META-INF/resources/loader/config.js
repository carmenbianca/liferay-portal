/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	var LiferayAUI = Liferay.AUI;

	var combine = LiferayAUI.getCombine();

	window.__CONFIG__ = {
		basePath: '',
		combine,
		reportMismatchedAnonymousModules: 'warn',
		url: combine
			? LiferayAUI.getComboPath()
			: Liferay.ThemeDisplay.getCDNBaseURL(),
	};

	if (!combine) {
		__CONFIG__.defaultURLParams = {
			languageId: themeDisplay.getLanguageId(),
		};
	}

	__CONFIG__.maps = Liferay.MAPS;

	__CONFIG__.modules = Liferay.MODULES;

	__CONFIG__.paths = Liferay.PATHS;

	__CONFIG__.resolvePath = Liferay.RESOLVE_PATH;

	__CONFIG__.namespace = 'Liferay';

	__CONFIG__.explainResolutions = Liferay.EXPLAIN_RESOLUTIONS;

	__CONFIG__.exposeGlobal = Liferay.EXPOSE_GLOBAL;

	__CONFIG__.logLevel = Liferay.LOG_LEVEL;

	__CONFIG__.waitTimeout = Liferay.WAIT_TIMEOUT;
})();
