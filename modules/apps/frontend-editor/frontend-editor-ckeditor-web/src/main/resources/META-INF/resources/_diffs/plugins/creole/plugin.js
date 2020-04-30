/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	CKEDITOR.plugins.add('creole', {
		init(editor) {
			var instance = this;

			var path = instance.path;

			var dependencies = [
				CKEDITOR.getUrl(path + 'creole_data_processor.js'),
				CKEDITOR.getUrl(path + 'creole_parser.js'),
			];

			CKEDITOR.scriptLoader.load(dependencies, () => {
				var creoleDataProcessor = CKEDITOR.plugins.get(
					'creole_data_processor'
				);

				creoleDataProcessor.init(editor);
			});
		},
	});
})();
