/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	AUI().applyConfig({
		groups: {
			'item-selector-taglib': {
				base: MODULE_PATH + '/',
				combine: Liferay.AUI.getCombine(),
				filter: Liferay.AUI.getFilterConfig(),
				modules: {
					'liferay-image-selector': {
						path: 'image_selector/js/image_selector.js',
						requires: [
							'aui-base',
							'liferay-item-selector-dialog',
							'liferay-portlet-base',
							'uploader',
						],
					},
				},
				root: MODULE_PATH + '/',
			},
		},
	});
})();
