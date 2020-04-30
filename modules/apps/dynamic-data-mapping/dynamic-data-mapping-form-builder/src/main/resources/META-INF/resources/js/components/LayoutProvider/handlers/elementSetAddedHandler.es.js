/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {PagesVisitor} from 'dynamic-data-mapping-form-renderer';

import {generateFieldName} from '../util/fields.es';

const handleElementSetAdded = (props, state, event) => {
	const {fieldSetPages, indexes} = event;
	const {pages} = state;
	const {pageIndex, rowIndex} = indexes;

	const visitor = new PagesVisitor(fieldSetPages);

	const newFieldsetPages = visitor.mapFields(field => {
		const name = generateFieldName(pages, field.fieldName);

		const settingsContextVisitor = new PagesVisitor(
			field.settingsContext.pages
		);

		return {
			...field,
			fieldName: name,
			settingsContext: {
				...field.settingsContext,
				pages: settingsContextVisitor.mapFields(
					settingsContextField => {
						if (settingsContextField.fieldName === 'name') {
							settingsContextField = {
								...settingsContextField,
								value: name,
							};
						}

						return settingsContextField;
					}
				),
			},
		};
	});

	const rows = newFieldsetPages[0].rows;

	for (let i = rows.length - 1; i >= 0; i--) {
		pages[pageIndex].rows.splice(rowIndex, 0, rows[i]);
	}

	return {pages};
};

export default handleElementSetAdded;
