/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import updateFragmentEntryLinkContent from '../actions/updateFragmentEntryLinkContent';
import {FREEMARKER_FRAGMENT_ENTRY_PROCESSOR} from '../config/constants/freemarkerFragmentEntryProcessor';
import FragmentService from '../services/FragmentService';

export default function updateFragmentConfiguration({
	configurationValues,
	fragmentEntryLink,
	prefixedSegmentsExperienceId,
}) {
	const {editableValues, fragmentEntryLinkId} = fragmentEntryLink;

	const nextEditableValues = {
		...editableValues,
		[FREEMARKER_FRAGMENT_ENTRY_PROCESSOR]: prefixedSegmentsExperienceId
			? {
					...editableValues[FREEMARKER_FRAGMENT_ENTRY_PROCESSOR],
					[prefixedSegmentsExperienceId]: configurationValues,
			  }
			: configurationValues,
	};

	return dispatch => {
		return FragmentService.updateConfigurationValues({
			configurationValues: nextEditableValues,
			fragmentEntryLinkId,
			onNetworkStatus: dispatch,
		}).then(({content, editableValues}) => {
			dispatch(
				updateFragmentEntryLinkContent({
					content,
					editableValues,
					fragmentEntryLinkId,
				})
			);
		});
	};
}
