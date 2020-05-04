/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	AUI().applyConfig({
		groups: {
			'frontend-taglib': {
				base: MODULE_PATH + '/',
				combine: Liferay.AUI.getCombine(),
				filter: Liferay.AUI.getFilterConfig(),
				modules: {
					'liferay-management-bar': {
						path: 'management_bar/js/management_bar.js',
						requires: ['aui-component', 'liferay-portlet-base'],
					},
					'liferay-sidebar-panel': {
						path: 'sidebar_panel/js/sidebar_panel.js',
						requires: [
							'aui-base',
							'aui-debounce',
							'aui-parse-content',
							'liferay-portlet-base',
						],
					},
				},
				root: MODULE_PATH + '/',
			},
		},
	});
})();
