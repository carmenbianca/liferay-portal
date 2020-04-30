/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import * as FormSupport from 'dynamic-data-mapping-form-renderer/js/components/FormRenderer/FormSupport.es';
import {PagesVisitor} from 'dynamic-data-mapping-form-renderer/js/util/visitors.es';

import {FIELD_TYPE_FIELDSET} from '../../../util/constants.es';
import {createField} from '../../../util/fieldSupport.es';
import {updateField} from '../util/settingsContext.es';
import handleFieldDeleted from './fieldDeletedHandler.es';

const addNestedField = ({field, indexes, nestedField, props}) => {
	const layout = FormSupport.addFieldToColumn(
		[{rows: field.rows}],
		indexes.pageIndex,
		indexes.rowIndex,
		indexes.columnIndex,
		nestedField.fieldName
	);
	const nestedFields = [...field.nestedFields, nestedField];

	field = updateField(props, field, 'nestedFields', nestedFields);

	const {rows} = layout[indexes.pageIndex];

	field = updateField(props, field, 'rows', rows);

	return {
		...field,
		nestedFields,
		rows,
	};
};

const addNestedFields = ({field, indexes, nestedFields, props}) => {
	let layout = [{rows: field.rows}];
	const visitor = new PagesVisitor(layout);

	visitor.mapFields((field, fieldIndex, columnIndex, rowIndex, pageIndex) => {
		if (
			!nestedFields.some(
				nestedField => nestedField.fieldName === field.fieldName
			)
		) {
			layout = FormSupport.removeFields(
				layout,
				pageIndex,
				rowIndex,
				columnIndex
			);
		}
	});

	[...nestedFields].reverse().forEach(nestedField => {
		layout = FormSupport.addFieldToColumn(
			layout,
			indexes.pageIndex,
			indexes.rowIndex,
			indexes.columnIndex,
			nestedField.fieldName
		);
	});

	field = updateField(props, field, 'nestedFields', nestedFields);

	const {rows} = layout[indexes.pageIndex];

	return {
		...updateField(props, field, 'rows', rows),
		nestedFields,
		rows,
	};
};

export const createFieldSet = (
	props,
	event,
	nestedFields,
	rows = [{columns: [{fields: [], size: 12}]}]
) => {
	const {fieldTypes} = props;
	const fieldType = fieldTypes.find(fieldType => {
		return fieldType.name === FIELD_TYPE_FIELDSET;
	});
	const fieldSetField = createField(props, {...event, fieldType});

	return addNestedFields({
		field: {
			...fieldSetField,
			rows,
		},
		indexes: {
			columnIndex: 0,
			pageIndex: 0,
			rowIndex: 0,
		},
		nestedFields,
		props,
	});
};

const handleSectionAdded = (props, state, event) => {
	const {data, indexes} = event;
	const {fieldName, parentFieldName} = data;
	const {pages} = state;

	const newField = event.newField || createField(props, event);
	const existingField = FormSupport.findFieldByFieldName(pages, fieldName);
	const fieldSetField = createFieldSet(props, event, [
		existingField,
		newField,
	]);

	const visitor = new PagesVisitor(pages);

	let newPages;

	if (parentFieldName) {
		newPages = visitor.mapFields(
			field => {
				if (field.fieldName === parentFieldName) {
					const updatedParentField = FormSupport.findFieldByFieldName(
						handleFieldDeleted(props, state, {
							fieldName,
						}).pages,
						parentFieldName
					);

					return addNestedField({
						field: updatedParentField,
						indexes,
						nestedField: fieldSetField,
						props,
					});
				}

				return field;
			},
			false,
			true
		);
	}
	else {
		newPages = visitor.mapFields(field => {
			if (field.fieldName === fieldName) {
				return fieldSetField;
			}

			return field;
		});
	}

	return {
		focusedField: {
			...newField,
		},
		pages: newPages,
		previousFocusedField: fieldSetField,
	};
};

export default handleSectionAdded;
