/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {
	generateInstanceId,
	generateName,
	generateNestedFieldName,
	parseNestedFieldName,
} from '../../util/repeatable.es';
import {PagesVisitor} from '../../util/visitors.es';

export const createRepeatedField = (sourceField, repeatedIndex) => {
	const instanceId = generateInstanceId();

	return {
		...sourceField,
		instanceId,
		localizedValue: {},
		name: generateName(sourceField.name, {instanceId, repeatedIndex}),
		nestedFields: (sourceField.nestedFields || []).map(nestedField => ({
			...nestedField,
			localizedValue: {},
			value: undefined,
		})),
		value: undefined,
	};
};

export const updateNestedFieldNames = (parentFieldName, nestedFields) => {
	return (nestedFields || []).map(nestedField => {
		const newNestedFieldName = generateNestedFieldName(
			nestedField.name,
			parentFieldName
		);

		return {
			...nestedField,
			name: newNestedFieldName,
			nestedFields: updateNestedFieldNames(
				newNestedFieldName,
				nestedField.nestedFields
			),
			...parseNestedFieldName(newNestedFieldName),
		};
	});
};

export default (pages, name) => {
	const visitor = new PagesVisitor(pages);

	return visitor.mapColumns(column => {
		const {fields} = column;
		const sourceFieldIndex = fields.reduce(
			(sourceFieldIndex = -1, field, index) => {
				if (field.name === name) {
					sourceFieldIndex = index;
				}

				return sourceFieldIndex;
			},
			-1
		);

		if (sourceFieldIndex > -1) {
			const newFieldIndex = sourceFieldIndex + 1;
			const newField = createRepeatedField(
				fields[sourceFieldIndex],
				newFieldIndex
			);

			let currentRepeatedIndex = 0;

			return {
				...column,
				fields: [
					...fields.slice(0, newFieldIndex),
					newField,
					...fields.slice(newFieldIndex),
				].map(currentField => {
					if (currentField.fieldName === newField.fieldName) {
						const name = generateName(currentField.name, {
							repeatedIndex: currentRepeatedIndex++,
						});

						return {
							...currentField,
							name,
							nestedFields: updateNestedFieldNames(
								name,
								currentField.nestedFields
							),
						};
					}

					return currentField;
				}),
			};
		}

		return column;
	});
};
