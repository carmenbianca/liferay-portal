/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {openImageSelector} from '../../core/openImageSelector';

function createEditor(element, changeCallback, destroyCallback) {
	openImageSelector(
		image => changeCallback(image && image.url ? image.url : ''),
		destroyCallback
	);
}

function destroyEditor(_element) {}

function render(element, value) {
	element.style.backgroundImage = value
		? `url("${value.url ? value.url : value}")`
		: '';
	element.style.backgroundSize = 'cover';
}

export default {
	createEditor,
	destroyEditor,
	render,
};
