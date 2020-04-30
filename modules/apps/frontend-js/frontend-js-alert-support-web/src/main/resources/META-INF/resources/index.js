/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import dom from 'metal-dom';

let handle;

export default () => {
	if (!handle) {
		handle = dom.delegate(
			document.body,
			'click',
			'[data-dismiss="liferay-alert"]',
			event => {
				event.preventDefault();

				const container = dom.closest(event.delegateTarget, '.alert');

				if (container) {
					container.parentNode.removeChild(container);
				}
			}
		);
	}
};
