/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ExperienceService from '../../../app/services/ExperienceService';
import updateExperienceAction from '../actions/updateExperience';

export default function updateExperience({
	name,
	segmentsEntryId,
	segmentsExperienceId,
}) {
	return dispatch => {
		return ExperienceService.updateExperience({
			body: {
				active: true,
				name,
				segmentsEntryId,
				segmentsExperienceId,
			},
			dispatch,
		}).then(() => {
			return dispatch(
				updateExperienceAction({
					name,
					segmentsEntryId,
					segmentsExperienceId,
				})
			);
		});
	};
}
