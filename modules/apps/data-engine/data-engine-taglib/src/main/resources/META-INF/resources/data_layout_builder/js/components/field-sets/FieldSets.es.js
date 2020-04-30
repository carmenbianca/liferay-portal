/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useContext} from 'react';

import AppContext from '../../AppContext.es';
import {DRAG_FIELDSET} from '../../drag-and-drop/dragTypes.es';
import {containsFieldSet} from '../../utils/dataDefinition.es';
import FieldType from '../field-types/FieldType.es';

export default function FieldSets() {
	const [{dataDefinition, fieldSets}] = useContext(AppContext);

	return (
		<>
			{fieldSets.map(fieldSet => (
				<FieldType
					description={`${
						fieldSet.dataDefinitionFields.length
					} ${Liferay.Language.get('fields')}`}
					disabled={containsFieldSet(dataDefinition, fieldSet.id)}
					dragType={DRAG_FIELDSET}
					fieldSet={fieldSet}
					icon="forms"
					key={fieldSet.dataDefinitionKey}
					label={fieldSet.name[themeDisplay.getLanguageId()]}
				/>
			))}
		</>
	);
}
