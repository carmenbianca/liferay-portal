/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {config} from '../../../app/config/index';
import ExperienceService from '../../../app/services/ExperienceService';
import deleteExperienceAction from '../actions/deleteExperience';
import selectExperienceAction from '../actions/selectExperience';

export default function removeExperience({
	fragmentEntryLinkIds,
	segmentsExperienceId,
	selectedExperienceId,
}) {
	return dispatch => {
		if (segmentsExperienceId === selectedExperienceId) {
			return ExperienceService.selectExperience({
				body: {
					segmentsExperienceId: config.defaultSegmentsExperienceId,
				},
				dispatch,
			}).then(portletIds => {
				dispatch(
					selectExperienceAction({
						portletIds,
						segmentsExperienceId:
							config.defaultSegmentsExperienceId,
					})
				);

				ExperienceService.removeExperience({
					body: {
						fragmentEntryLinkIds,
						segmentsExperienceId,
					},
					dispatch,
				}).then(() => {
					return dispatch(
						deleteExperienceAction({
							segmentsExperienceId,
						})
					);
				});
			});
		}
		else {
			return ExperienceService.removeExperience({
				body: {
					fragmentEntryLinkIds,
					segmentsExperienceId,
				},
				dispatch,
			}).then(() => {
				return dispatch(
					deleteExperienceAction({
						segmentsExperienceId,
					})
				);
			});
		}
	};
}
