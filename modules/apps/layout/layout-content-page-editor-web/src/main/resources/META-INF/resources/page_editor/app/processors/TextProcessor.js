/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import getAlloyEditorProcessor from './getAlloyEditorProcessor';
import {getLinkableEditableEditorWrapper} from './getLinkableEditableEditorWrapper';

export default getAlloyEditorProcessor(
	'text',
	getLinkableEditableEditorWrapper,
	(element, value, config = {}) => {
		if (config.href) {
			let anchor =
				element instanceof HTMLAnchorElement
					? element
					: element.querySelector('a');

			if (!anchor) {
				anchor = document.createElement('a');
			}

			anchor.href = config.href;
			anchor.target = config.target || '';
			anchor.innerHTML = value;

			element.innerHTML = anchor.outerHTML;
		}
		else {
			element.innerHTML = value;
		}
	}
);
