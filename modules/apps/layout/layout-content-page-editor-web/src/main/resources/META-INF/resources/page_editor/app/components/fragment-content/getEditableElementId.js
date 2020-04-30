/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * @param {HTMLElement} editableElement
 */
export default function getEditableElementId(editableElement) {
	return (
		editableElement.dataset.lfrBackgroundImageId ||
		editableElement.dataset.lfrEditableId ||
		editableElement.getAttribute('id')
	);
}
