/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const actionHandlers = {
	copyLayout: ({actionURL, namespace}) => {
		Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
				height: 480,
				resizable: false,
				width: 640,
			},
			dialogIframe: {
				bodyCssClass: 'dialog-with-footer',
			},
			id: `${namespace}addLayoutDialog`,
			title: Liferay.Language.get('copy-page'),
			uri: actionURL,
		});
	},

	delete: ({actionURL}) => {
		const deleteMessage = Liferay.Language.get(
			'are-you-sure-you-want-to-delete-this'
		);

		if (confirm(deleteMessage)) {
			Liferay.Util.navigate(actionURL);
		}
	},

	permissions: ({actionURL}) => {
		Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
				modal: true,
			},
			dialogIframe: {
				bodyCssClass: 'dialog-with-footer',
			},
			title: Liferay.Language.get('permissions'),
			uri: actionURL,
		});
	},
};

export default actionHandlers;
