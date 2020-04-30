/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import FieldType from './FieldType.es';

export default ({
	deleteLabel,
	fieldTypes,
	keywords,
	onClick,
	onDelete,
	onDoubleClick,
}) => {
	const regex = new RegExp(keywords, 'ig');

	return fieldTypes
		.filter(({system}) => !system)
		.filter(({description, label}) => {
			if (!keywords) {
				return true;
			}

			return regex.test(description) || regex.test(label);
		})
		.map((fieldType, index) => (
			<FieldType
				{...fieldType}
				deleteLabel={deleteLabel}
				key={`${fieldType.name}_${index}`}
				onClick={onClick}
				onDelete={onDelete}
				onDoubleClick={onDoubleClick}
			/>
		));
};
