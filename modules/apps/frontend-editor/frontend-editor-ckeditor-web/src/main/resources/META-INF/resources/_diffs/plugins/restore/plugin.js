/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	var pluginName = 'restore';

	CKEDITOR.plugins.add(pluginName, {
		init(editor) {
			editor.addCommand(pluginName, {
				canUndo: false,
				exec(editor) {
					editor.fire('restoreContent');
				},
			});

			if (editor.ui.addButton) {
				editor.ui.addButton('Restore', {
					command: pluginName,
					icon:
						Liferay.AUI.getPathCKEditor() +
						'/ckeditor/plugins/restore/assets/restore.png',
					label: Liferay.Language.get('restore-the-original-content'),
				});
			}
		},
	});
})();
