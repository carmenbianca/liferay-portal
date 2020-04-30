/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {getEditableItemPropTypes} from '../../../prop-types/index';
import {BACKGROUND_IMAGE_FRAGMENT_ENTRY_PROCESSOR} from '../../config/constants/backgroundImageFragmentEntryProcessor';
import {EDITABLE_FRAGMENT_ENTRY_PROCESSOR} from '../../config/constants/editableFragmentEntryProcessor';
import {EDITABLE_TYPES} from '../../config/constants/editableTypes';
import selectEditableValue from '../../selectors/selectEditableValue';
import {useDispatch, useSelector} from '../../store/index';
import updateEditableValues from '../../thunks/updateEditableValues';
import isMapped from '../fragment-content/isMapped';
import MappingSelector from './MappingSelector';

export function MappingPanel({item}) {
	const {editableId, editableType, fragmentEntryLinkId} = item;

	const dispatch = useDispatch();
	const state = useSelector(state => state);

	const fragmentEntryLink = state.fragmentEntryLinks[fragmentEntryLinkId];

	const processoryKey =
		editableType === EDITABLE_TYPES.backgroundImage
			? BACKGROUND_IMAGE_FRAGMENT_ENTRY_PROCESSOR
			: EDITABLE_FRAGMENT_ENTRY_PROCESSOR;

	const editableValue = selectEditableValue(
		state,
		fragmentEntryLinkId,
		editableId,
		processoryKey
	);

	const updateEditableValue = newEditableValue => {
		const nextEditableValues = {
			...fragmentEntryLink.editableValues,
			[processoryKey]: {
				...fragmentEntryLink.editableValues[processoryKey],
				[editableId]: {
					config: isMapped(newEditableValue)
						? {...editableValue.config, alt: ''}
						: editableValue.config,
					defaultValue: editableValue.defaultValue,
					...newEditableValue,
				},
			},
		};

		dispatch(
			updateEditableValues({
				editableValues: nextEditableValues,
				fragmentEntryLinkId,
				segmentsExperienceId: state.segmentsExperienceId,
			})
		);
	};

	return (
		<MappingSelector
			fieldType={editableType}
			mappedItem={editableValue}
			onMappingSelect={updateEditableValue}
		/>
	);
}

MappingPanel.propTypes = {
	item: getEditableItemPropTypes(),
};
