/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayInput} from '@clayui/form';
import React, {useState} from 'react';

import {ImageSelector} from '../../../common/components/ImageSelector';
import {useDebounceCallback} from '../../../core/hooks/useDebounceCallback';
import {getEditableItemPropTypes} from '../../../prop-types/index';
import {BACKGROUND_IMAGE_FRAGMENT_ENTRY_PROCESSOR} from '../../config/constants/backgroundImageFragmentEntryProcessor';
import {EDITABLE_FRAGMENT_ENTRY_PROCESSOR} from '../../config/constants/editableFragmentEntryProcessor';
import {EDITABLE_TYPES} from '../../config/constants/editableTypes';
import selectEditableValueContent from '../../selectors/selectEditableValueContent';
import selectPrefixedSegmentsExperienceId from '../../selectors/selectPrefixedSegmentsExperienceId';
import {useDispatch, useSelector} from '../../store/index';
import updateEditableValuesThunk from '../../thunks/updateEditableValues';

export function ImagePropertiesPanel({item}) {
	const {editableId, editableType, fragmentEntryLinkId} = item;

	const dispatch = useDispatch();
	const state = useSelector(state => state);

	const processorKey =
		editableType === EDITABLE_TYPES.backgroundImage
			? BACKGROUND_IMAGE_FRAGMENT_ENTRY_PROCESSOR
			: EDITABLE_FRAGMENT_ENTRY_PROCESSOR;

	const editableValues =
		state.fragmentEntryLinks[fragmentEntryLinkId].editableValues;

	const editableValue = editableValues[processorKey][editableId];

	const editableConfig = editableValue.config || {};

	const [imageDescription, setImageDescription] = useState(
		editableConfig.alt
	);

	const imageUrl = useSelector(state => {
		const url = selectEditableValueContent(
			state,
			fragmentEntryLinkId,
			editableId,
			processorKey
		);

		return url === editableValue.defaultValue ? '' : url;
	});

	const updateEditableValues = (
		alt,
		editableValues,
		editableId,
		processorKey
	) => {
		const editableProcessorValues = editableValues[processorKey];

		const editableValue = editableValues[processorKey][editableId];

		const editableConfig = editableValue.config || {};

		const nextEditableValues = {
			...editableValues,
			[processorKey]: {
				...editableProcessorValues,
				[editableId]: {
					...editableProcessorValues[editableId],
					config: {
						...editableConfig,
						alt,
					},
				},
			},
		};

		dispatch(
			updateEditableValuesThunk({
				editableValues: nextEditableValues,
				fragmentEntryLinkId,
				segmentsExperienceId: state.segmentsExperienceId,
			})
		);
	};

	const [debounceUpdateEditableValues] = useDebounceCallback(
		updateEditableValues,
		500
	);

	const onImageChange = (imageTitle, imageUrl) => {
		const {editableValues} = state.fragmentEntryLinks[fragmentEntryLinkId];

		const editableProcessorValues = editableValues[processorKey];

		const editableValue = editableProcessorValues[editableId];

		const prefixedSegmentsExperienceId = selectPrefixedSegmentsExperienceId(
			state
		);

		let nextEditableValue = {};

		setImageDescription('');

		const nextEditableValueConfig = {
			...editableValue.config,
			alt: '',
			imageTitle: '',
		};

		if (imageTitle) {
			nextEditableValueConfig.imageTitle = imageTitle;
		}

		if (prefixedSegmentsExperienceId) {
			nextEditableValue = {
				...editableValue,
				config: nextEditableValueConfig,
				[prefixedSegmentsExperienceId]: {
					...editableValue[prefixedSegmentsExperienceId],
					[state.languageId]: imageUrl,
				},
			};
		}
		else {
			nextEditableValue = {
				...editableValue,
				config: nextEditableValueConfig,
				[state.languageId]: imageUrl,
			};
		}

		const nextEditableValues = {
			...editableValues,

			[processorKey]: {
				...editableProcessorValues,
				[editableId]: {
					...nextEditableValue,
				},
			},
		};

		dispatch(
			updateEditableValuesThunk({
				editableValues: nextEditableValues,
				fragmentEntryLinkId,
				segmentsExperienceId: state.segmentsExperienceId,
			})
		);
	};

	return (
		<>
			<ImageSelector
				imageTitle={editableConfig.imageTitle || imageUrl}
				label={Liferay.Language.get('image')}
				onClearButtonPressed={() => onImageChange('', '')}
				onImageSelected={image => onImageChange(image.title, image.url)}
			/>

			{editableType === EDITABLE_TYPES.image && (
				<>
					<label htmlFor="imageDescription">
						{Liferay.Language.get('image-description')}
					</label>
					<ClayInput
						id="imageDescription"
						onChange={event => {
							setImageDescription(event.target.value);

							debounceUpdateEditableValues(
								event.target.value,
								editableValues,
								editableId,
								processorKey
							);
						}}
						sizing="sm"
						type="text"
						value={imageDescription || ''}
					/>
				</>
			)}
		</>
	);
}

ImagePropertiesPanel.propTypes = {
	item: getEditableItemPropTypes().isRequired,
};
