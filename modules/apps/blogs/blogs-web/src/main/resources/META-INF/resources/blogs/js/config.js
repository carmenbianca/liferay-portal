/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	AUI().applyConfig({
		groups: {
			blogs: {
				base: MODULE_PATH + '/blogs/js/',
				combine: Liferay.AUI.getCombine(),
				filter: Liferay.AUI.getFilterConfig(),
				modules: {
					'liferay-blogs': {
						path: 'blogs.js',
						requires: ['aui-base', 'liferay-form'],
					},
				},
				root: MODULE_PATH + '/blogs/js/',
			},
		},
	});
})();
