/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	AUI().applyConfig({
		groups: {
			contactscenter: {
				base: MODULE_PATH + '/js/',
				combine: Liferay.AUI.getCombine(),
				filter: Liferay.AUI.getFilterConfig(),
				modules: {
					'liferay-contacts-center': {
						path: 'main.js',
						requires: [
							'aui-io-plugin-deprecated',
							'aui-toolbar',
							'autocomplete-base',
							'datasource-io',
							'json-parse',
							'liferay-portlet-base',
							'liferay-util-window',
						],
					},
				},
				root: MODULE_PATH + '/js/',
			},
		},
	});
})();
