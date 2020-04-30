/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {normalizeFieldName} from 'dynamic-data-mapping-form-renderer';

const findFieldByName = (dataDefinitionFields, fieldName) =>
	dataDefinitionFields.find(({name}) => name === fieldName);

export default ({dataDefinitionFields}, fieldTypeName) => {
	let counter = 0;
	let name = normalizeFieldName(fieldTypeName);

	while (findFieldByName(dataDefinitionFields, name)) {
		name = normalizeFieldName(`${fieldTypeName}${++counter}`);
	}

	return name;
};
