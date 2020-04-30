/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	var pluginName = 'lfrpopup';

	CKEDITOR.plugins.add(pluginName, {
		init(editor) {
			AUI().use('querystring-parse', A => {
				editor.popup = function(url, width, height, options) {
					var params = A.QueryString.parse(url.split('?')[1]);

					if (params.p_p_id) {
						url = url.replace(
							'CKEditorFuncNum=',
							'_' + params.p_p_id + '_CKEditorFuncNum='
						);
					}

					options = A.QueryString.parse(options);

					Liferay.Util.openWindow({
						dialog: {
							zIndex: CKEDITOR.getNextZIndex(),
						},
						height,
						stack: false,
						title: options.title || '',
						uri: url,
						width,
					});
				};
			});
		},
	});
})();
