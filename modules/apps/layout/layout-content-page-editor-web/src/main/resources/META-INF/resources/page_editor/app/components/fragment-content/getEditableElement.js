/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {closest} from 'metal-dom';

export function getEditableElement(target) {
	let editableElement = closest(target, 'lfr-editable');

	if (!editableElement) {
		editableElement = closest(target, '[data-lfr-editable-id]');
	}

	if (!editableElement) {
		editableElement = closest(target, '[data-lfr-background-image-id]');
	}

	return editableElement;
}
