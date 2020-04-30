import {PagesVisitor} from 'dynamic-data-mapping-form-renderer';

import {updateField} from '../util/settingsContext.es';
import {addField} from './fieldAddedHandler.es';
import {createFieldSet} from './sectionAddedHandler.es';

/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const handleFieldSetAdded = (props, state, event) => {
	const {fieldSet, indexes, parentFieldName} = event;
	const {pages} = state;
	const visitor = new PagesVisitor(fieldSet.pages);

	const nestedFields = [];

	visitor.mapFields(nestedField => {
		nestedFields.push(nestedField);
	});

	let fieldSetField = createFieldSet(
		props,
		{skipFieldNameGeneration: false},
		nestedFields
	);

	fieldSetField = updateField(
		props,
		fieldSetField,
		'dataDefinitionId',
		fieldSet.id
	);

	return addField(props, {
		indexes,
		newField: updateField(props, fieldSetField, 'label', fieldSet.title),
		pages,
		parentFieldName,
	});
};

export default handleFieldSetAdded;
