/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {PagesVisitor} from 'dynamic-data-mapping-form-renderer';

import handleFieldEdited from './fieldEditedHandler.es';

const handleFocusedFieldEvaluationEnded = (props, state, settingsContext) => {
	const visitor = new PagesVisitor(settingsContext.pages);
	const {focusedField} = state;

	state = {
		...state,
		focusedField: {
			...focusedField,
			settingsContext,
		},
	};

	visitor.mapFields(({fieldName, value}) => {
		state = handleFieldEdited(
			{
				...props,
				shouldAutoGenerateName: () => false,
			},
			state,
			{
				propertyName: fieldName,
				propertyValue: value,
			}
		);
	});

	return state;
};

export default handleFocusedFieldEvaluationEnded;
