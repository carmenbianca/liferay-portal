/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ExperienceService from '../../../app/services/ExperienceService';
import updateExperiencePriorityAction from '../actions/updateExperiencePriority';

export default function updateExperiencePriority({subtarget, target}) {
	return dispatch => {
		return ExperienceService.updateExperiencePriority({
			body: {
				newPriority: target.priority,
				segmentsExperienceId: target.segmentsExperienceId,
			},
			dispatch,
		}).then(() => {
			return dispatch(
				updateExperiencePriorityAction({subtarget, target})
			);
		});
	};
}
