/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	AUI().applyConfig({
		groups: {
			segmentssimulation: {
				base: MODULE_PATH + '/js/',
				combine: Liferay.AUI.getCombine(),
				filter: Liferay.AUI.getFilterConfig(),
				modules: {
					'liferay-portlet-segments-simulation': {
						path: 'main.js',
						requires: ['aui-base', 'liferay-portlet-base'],
					},
				},
				root: MODULE_PATH + '/js/',
			},
		},
	});
})();
