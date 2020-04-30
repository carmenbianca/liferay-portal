/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import addFragmentComposition from '../actions/addFragmentComposition';
import FragmentService from '../services/FragmentService';

export default function addFragment({
	description,
	fragmentCollectionId,
	itemId,
	name,
	previewImageURL,
	saveInlineContent,
	saveMappingConfiguration,
	store,
}) {
	return dispatch => {
		const {segmentsExperienceId} = store;

		return FragmentService.addFragmentComposition({
			description,
			fragmentCollectionId,
			itemId,
			name,
			onNetworkStatus: dispatch,
			previewImageURL,
			saveInlineContent,
			saveMappingConfiguration,
			segmentsExperienceId,
		}).then(fragmentComposition => {
			dispatch(
				addFragmentComposition({
					fragmentCollectionId,
					fragmentComposition,
				})
			);
		});
	};
}
