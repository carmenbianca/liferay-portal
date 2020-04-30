/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {FormSupport} from 'dynamic-data-mapping-form-renderer';

import {addField} from './fieldAddedHandler.es';
import handleFieldDeleted from './fieldDeletedHandler.es';
import handleSectionAdded from './sectionAddedHandler.es';

export default (props, state, event) => {
	const {
		sourceFieldName,
		targetFieldName,
		targetIndexes,
		targetParentFieldName,
	} = event;
	const deletedState = handleFieldDeleted(props, state, {
		fieldName: sourceFieldName,
	});
	const sourceField = FormSupport.findFieldByFieldName(
		state.pages,
		sourceFieldName
	);

	if (targetFieldName) {
		return {
			...handleSectionAdded(
				props,
				{
					...state,
					pages: deletedState.pages,
				},
				{
					data: {
						fieldName: targetFieldName,
						parentFieldName: targetParentFieldName,
					},
					indexes: targetIndexes,
					newField: sourceField,
				}
			),
		};
	}

	return {
		...addField(props, {
			indexes: targetIndexes,
			newField: sourceField,
			pages: deletedState.pages,
			parentFieldName: targetParentFieldName,
		}),
	};
};
