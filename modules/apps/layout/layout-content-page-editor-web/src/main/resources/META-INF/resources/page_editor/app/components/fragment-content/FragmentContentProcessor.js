/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';
import {useEffect, useMemo} from 'react';

import {config} from '../../config/index';
import selectPrefixedSegmentsExperienceId from '../../selectors/selectPrefixedSegmentsExperienceId';
import selectSegmentsExperienceId from '../../selectors/selectSegmentsExperienceId';
import {useDispatch, useSelector} from '../../store/index';
import updateEditableValues from '../../thunks/updateEditableValues';
import {
	useEditableProcessorClickPosition,
	useEditableProcessorUniqueId,
	useIsProcessorEnabled,
	useSetEditableProcessorUniqueId,
} from './EditableProcessorContext';
import getEditableUniqueId from './getEditableUniqueId';

export default function FragmentContentProcessor({
	editables,
	fragmentEntryLinkId,
}) {
	const dispatch = useDispatch();
	const editableProcessorClickPosition = useEditableProcessorClickPosition();
	const editableProcessorUniqueId = useEditableProcessorUniqueId();
	const setEditableProcessorUniqueId = useSetEditableProcessorUniqueId();
	const isProcessorEnabled = useIsProcessorEnabled();
	const languageId = useSelector(
		state => state.languageId || config.defaultLanguageId
	);
	const prefixedSegmentsExperienceId = useSelector(
		selectPrefixedSegmentsExperienceId
	);
	const segmentsExperienceId = useSelector(selectSegmentsExperienceId);

	const editable = useMemo(() => {
		let enabledEditable = {
			editableId: null,
			editableValueNamespace: null,
			element: null,
			processor: null,
		};

		if (editables) {
			enabledEditable =
				editables.find(editable =>
					isProcessorEnabled(
						getEditableUniqueId(
							fragmentEntryLinkId,
							editable.editableId
						)
					)
				) || enabledEditable;
		}

		return enabledEditable;
	}, [editables, isProcessorEnabled, fragmentEntryLinkId]);

	const editableValues = useSelector(
		state =>
			state.fragmentEntryLinks[fragmentEntryLinkId] &&
			state.fragmentEntryLinks[fragmentEntryLinkId].editableValues
	);

	useEffect(() => {
		if (!editable.element || !editableValues) {
			return;
		}

		const editableValue =
			editableValues[editable.editableValueNamespace][
				editable.editableId
			];

		editable.processor.createEditor(
			editable.element,
			value => {
				let nextEditableValue = {
					...editableValue,
				};

				if (prefixedSegmentsExperienceId) {
					nextEditableValue = {
						...nextEditableValue,

						[prefixedSegmentsExperienceId]: {
							...(nextEditableValue[
								prefixedSegmentsExperienceId
							] || {}),
							[languageId]: value,
						},
					};
				}
				else {
					nextEditableValue = {
						...nextEditableValue,
						[languageId]: value,
					};
				}

				dispatch(
					updateEditableValues({
						editableValues: {
							...editableValues,
							[editable.editableValueNamespace]: {
								...editableValues[
									editable.editableValueNamespace
								],
								[editable.editableId]: nextEditableValue,
							},
						},
						fragmentEntryLinkId,
						segmentsExperienceId,
					})
				);
			},
			() => {
				editable.processor.destroyEditor(
					editable.element,
					editableValue.config
				);

				setEditableProcessorUniqueId(null);
			},
			editableProcessorClickPosition
		);

		return () => {
			if (!editableProcessorUniqueId) {
				editable.processor.destroyEditor(
					editable.element,
					editableValue.config
				);
			}
		};
	}, [
		dispatch,
		editable.editableId,
		editable.editableValueNamespace,
		editable.element,
		editable.processor,
		editableProcessorClickPosition,
		editableProcessorUniqueId,
		editableValues,
		fragmentEntryLinkId,
		languageId,
		prefixedSegmentsExperienceId,
		segmentsExperienceId,
		setEditableProcessorUniqueId,
	]);

	return null;
}

FragmentContentProcessor.propTypes = {
	editables: PropTypes.arrayOf(
		PropTypes.shape({
			editableId: PropTypes.string.isRequired,
			editableValueNamespace: PropTypes.string.isRequired,
			element: PropTypes.instanceOf(HTMLElement).isRequired,
			processor: PropTypes.object,
		})
	),
	fragmentEntryLinkId: PropTypes.string.isRequired,
};
