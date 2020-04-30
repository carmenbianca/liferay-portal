/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

window.AlloyEditor = {
	Selections: [
		{
			buttons: ['linkEdit'],
			name: 'link',
		},
		{
			buttons: [
				'styles',
				'bold',
				'italic',
				'underline',
				'link',
				'twitter',
			],
			name: 'text',
		},
	],
};

window.AUI = () => ({
	use: (...modules) => {
		const callback = modules[modules.length - 1];

		callback({
			LiferayAlloyEditor: () => ({
				render: () => ({
					destroy: () => {},
					getHTML: () => 'test',
					getNativeEditor: () => ({
						on: () => true,
						setData: () => false,
					}),
				}),
			}),
			one: () => ({
				innerHTML: () => {},
			}),
		});
	},
});

window.themeDisplay = {
	getDefaultLanguageId: () => 'en_US',
	getLanguageId: () => 'en_US',
	getPathContext: () => '/',
	getPathThemeImages: () => 'http://localhost:8080/o/admin-theme/images',
};

window.util = {
	isEqual: (a, b) => a === b,
};

const languageMap = {
	'days-abbreviation': 'd',
	'decimal-delimiter': '.',
	'hours-abbreviation': 'h',
	'minutes-abbreviation': 'min',
	'mmm-dd': 'MMM DD',
	'mmm-dd-hh-mm': 'MMM DD, HH:mm',
	'mmm-dd-hh-mm-a': 'MMM DD, hh:mm A',
	'mmm-dd-lt': 'MMM DD, LT',
	'mmm-dd-yyyy': 'MMM DD, YYYY',
	'mmm-dd-yyyy-lt': 'MMM DD, YYYY, LT',
	'thousand-abbreviation': 'K',
};

window.Liferay = {
	...(window.Liferay || {}),
	Language: {
		get: key => {
			if (languageMap[key]) {
				return languageMap[key];
			}

			return key;
		},
	},
	ThemeDisplay: window.themeDisplay,
	Util: window.util,
};
