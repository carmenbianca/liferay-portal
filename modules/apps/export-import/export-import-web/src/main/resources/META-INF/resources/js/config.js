/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	AUI().applyConfig({
		groups: {
			exportimportweb: {
				base: MODULE_PATH + '/',
				combine: Liferay.AUI.getCombine(),
				filter: Liferay.AUI.getFilterConfig(),
				modules: {
					'liferay-export-import-export-import': {
						path: 'js/main.js',
						requires: [
							'aui-datatype',
							'aui-dialog-iframe-deprecated',
							'aui-modal',
							'aui-parse-content',
							'aui-toggler',
							'aui-tree-view',
							'liferay-notice',
							'liferay-portlet-base',
							'liferay-util-window',
						],
					},
				},
				root: MODULE_PATH + '/',
			},
		},
	});
})();
