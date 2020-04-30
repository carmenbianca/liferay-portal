/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	AUI().applyConfig({
		groups: {
			bookmarks: {
				base: MODULE_PATH + '/bookmarks/js/',
				combine: Liferay.AUI.getCombine(),
				filter: Liferay.AUI.getFilterConfig(),
				modules: {
					'liferay-bookmarks': {
						path: 'main.js',
						requires: ['liferay-portlet-base'],
					},
				},
				root: MODULE_PATH + '/bookmarks/js/',
			},
		},
	});
})();
