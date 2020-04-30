/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {normalizeFieldName} from 'dynamic-data-mapping-form-renderer';

export const shouldAutoGenerateName = (
	defaultLanguageId,
	editingLanguageId,
	focusedField
) => {
	const {fieldName, label} = focusedField;

	return (
		defaultLanguageId === editingLanguageId &&
		fieldName.indexOf(normalizeFieldName(label)) === 0
	);
};
