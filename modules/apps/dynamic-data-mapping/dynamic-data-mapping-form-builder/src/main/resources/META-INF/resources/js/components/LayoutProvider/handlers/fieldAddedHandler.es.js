/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {FormSupport, PagesVisitor} from 'dynamic-data-mapping-form-renderer';

import {createField} from '../../../util/fieldSupport.es';
import {updateField} from '../util/settingsContext.es';

export const addField = (
	props,
	{indexes, newField, pages, parentFieldName}
) => {
	const {columnIndex, pageIndex, rowIndex} = indexes;

	let newPages;

	if (parentFieldName) {
		const visitor = new PagesVisitor(pages);

		newPages = visitor.mapFields(
			field => {
				if (field.fieldName === parentFieldName) {
					const nestedFields = field.nestedFields
						? [...field.nestedFields, newField]
						: [newField];

					field = updateField(
						props,
						field,
						'nestedFields',
						nestedFields
					);

					const pages = FormSupport.addFieldToColumn(
						[{rows: field.rows}],
						pageIndex,
						rowIndex,
						columnIndex,
						newField.fieldName
					);

					return updateField(props, field, 'rows', pages[0].rows);
				}

				return field;
			},
			true,
			true
		);
	}
	else {
		newPages = FormSupport.addFieldToColumn(
			pages,
			pageIndex,
			rowIndex,
			columnIndex,
			newField
		);
	}

	return {
		focusedField: {
			...newField,
		},
		pages: newPages,
		previousFocusedField: newField,
	};
};

const handleFieldAdded = (props, state, event) => {
	const {data, indexes} = event;
	const {pages} = state;
	const {parentFieldName} = data;

	const newField = createField(props, event);

	return addField(props, {
		indexes,
		newField,
		pages,
		parentFieldName,
	});
};

export default handleFieldAdded;
