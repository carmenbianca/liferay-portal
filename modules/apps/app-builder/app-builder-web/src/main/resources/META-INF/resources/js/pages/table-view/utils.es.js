/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import dom from 'metal-dom';

export const getColumnIndex = node => {
	const rowNode = dom.closest(node, 'tr');

	if (!rowNode) {
		return -1;
	}

	const columnNode = dom.closest(node, 'td,th');

	if (!columnNode) {
		return -1;
	}

	const scopeId = `${Date.now()}`;

	rowNode.setAttribute('data-scope-uuid', scopeId);

	const columns = rowNode.querySelectorAll(
		`[data-scope-uuid="${scopeId}"] > ${columnNode.tagName}`
	);

	rowNode.removeAttribute('data-scope-uuid');

	return Array.prototype.indexOf.call(columns, columnNode) - 1;
};

export const getColumnNode = (container, index) => {
	return container.querySelector(
		`table tbody > tr:first-of-type > td:nth-of-type(${index + 2})`
	);
};

export const getColumns = container => {
	return container.querySelectorAll(`table tbody > tr:first-of-type > td`);
};

export const getFieldTypeLabel = (fieldTypes, fieldType) => {
	const fieldTypeObject = fieldTypes.find(({name}) => name === fieldType);

	if (fieldTypeObject) {
		return fieldTypeObject.label;
	}

	return fieldType;
};
